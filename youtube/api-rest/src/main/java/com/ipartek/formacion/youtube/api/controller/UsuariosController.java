package com.ipartek.formacion.youtube.api.controller;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.youtube.pojo.Rol;
import com.ipartek.formacion.youtube.pojo.Usuario;
import com.ipartek.formacion.youtube.service.IServiceUsuario;
import com.ipartek.formacion.youtube.service.impl.ServiceUsuario;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "*") // Habilitar CORS-->para llamadas en JavaScript
@RestController
@RequestMapping("/usuarios")

@Api(tags = "USUARIOS", description = "Gestión de los usuarios", produces = "application/json")
public class UsuariosController {

	private final static Logger LOG = Logger.getLogger(UsuariosController.class);

	IServiceUsuario serviceUsuario = null;
	ValidatorFactory factory = null;
	Validator validator = null;

	public UsuariosController() {
		super();
		serviceUsuario = ServiceUsuario.getInstance();

		// Crear Factoria y Validador
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@ApiOperation(value = "Lista todas los usuarios que se encuentran en la BBDD", notes = "")
	@ApiResponses({ @ApiResponse(code = 200, message = "Acción realizada con exito"),
			@ApiResponse(code = 404, message = "No existe la dirección a la que intenta acceder.") })
	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<ArrayList<Usuario>> listar() {

		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		ResponseEntity<ArrayList<Usuario>> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		try {
			lista = (ArrayList<Usuario>) serviceUsuario.listar();
			if (lista != null && lista.size() > 1) {
				response = new ResponseEntity<>(lista, HttpStatus.OK);
			} else {
				response = new ResponseEntity<>(lista, HttpStatus.NO_CONTENT);
			}

		} catch (Exception e) {
			LOG.error(e);
		}

		return response;
	}

	@ApiOperation(value = "Lista todas los usuarios que se encuentran en la BBDD sin mostrar password", notes = "")
	@ApiResponses({ @ApiResponse(code = 200, message = "Acción realizada con exito"),
			@ApiResponse(code = 404, message = "No existe la dirección a la que intenta acceder.") })
	@RequestMapping(value = { "publicos" }, method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<ArrayList<Usuario>> listarPublico() {

		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		ResponseEntity<ArrayList<Usuario>> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		try {
			lista = (ArrayList<Usuario>) serviceUsuario.listarPublicos();
			if (lista != null && lista.size() > 1) {
				response = new ResponseEntity<>(lista, HttpStatus.OK);
			} else {
				response = new ResponseEntity<>(lista, HttpStatus.NO_CONTENT);
			}

		} catch (Exception e) {
			LOG.error(e);
		}

		return response;
	}

	@RequestMapping(value = "/{idUsuario}", method = RequestMethod.GET)
	@ApiOperation(value = "Detalle de un usuario concreto")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Detalle del usuario"),
			@ApiResponse(code = 404, message = "El usuario no existe"),
			@ApiResponse(code = 500, message = "Error fatal") })
	@ApiParam(value = "id", required = true)
	public ResponseEntity<Usuario> buscarPorId(
			@ApiParam(value = "Id del usuario.", required = true) @PathVariable("idUsuario") long idUsuario) {

		ResponseEntity<Usuario> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		Usuario usuario = new Usuario();

		try {

			usuario = serviceUsuario.buscarPorId(idUsuario);

			if (usuario != null && usuario.getId() > 0) {
				response = new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
			} else {
				response = new ResponseEntity<Usuario>(usuario, HttpStatus.NOT_FOUND);
				LOG.debug("El usuario no existe.");
			}

		} catch (Exception e) {
			LOG.error(e);
		}

		return response;

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Eliminar un usuario", response = Usuario.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Usuario eliminado"),
			@ApiResponse(code = 404, message = "El usuario no existe"),
			@ApiResponse(code = 500, message = "Error fatal") })
	@ApiParam(value = "id", name = "id", required = true)
	public ResponseEntity<Object> eliminar(
			@ApiParam(value = "Id del usuario", required = true) @PathVariable("id") long id) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

		try {

			if (serviceUsuario.eliminar(id)) {
				response = new ResponseEntity<>(HttpStatus.OK);
			} else {
				response = new ResponseEntity<>(new ResponseMensaje("El usuario no existe."), HttpStatus.NOT_FOUND);
				LOG.debug("El usuario no existe.");
			}

		} catch (Exception e) {
			LOG.error(e);
		}

		return response;

	}

	@ApiOperation(value = "Crea un nuevo registro para usuario", 
			notes = "Se requiere: <br> <ol><li><b>NOMBRE:</b> comprendido entre 2 y 100 caracteres. </li><li><b>PASSWORD:</b> comprendido entre 2 y 60 caracteres.</li></ol> ",
			response= Usuario.class)
	@ApiResponses({@ApiResponse(code = 201, message = "Acción realizada con exito"),
			@ApiResponse(code = 409, message = "<ol><li> Nombre coinciden con un registro de la BBDD.</li><li>Los datos introducidos no cumple con los parametros establecidos.</li></ol>") })
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> crear(@RequestBody Usuario usuario) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {

			Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);
			if (violations.isEmpty()) {

				if (serviceUsuario.crear(usuario)) {
					response = new ResponseEntity<>(usuario, HttpStatus.CREATED);
				} else {
					response = new ResponseEntity<>(HttpStatus.CONFLICT);
				}
			} else {
				ResponseMensaje mensaje = new ResponseMensaje("Los datos no son correctos");
				for (ConstraintViolation<Usuario> violation : violations) {
					mensaje.addError(violation.getPropertyPath() + ": " + violation.getMessage());

				}
				response = new ResponseEntity<>(mensaje, HttpStatus.CONFLICT);
			}

		} catch (SQLIntegrityConstraintViolationException e) {
			ResponseMensaje msj = new ResponseMensaje("Ya existe el usuario, por favor prueba con otro nombre");
			response = new ResponseEntity<>(msj, HttpStatus.CONFLICT);
			LOG.debug(e);
		} catch (Exception e) {
			LOG.error(e);
		}

		return response;

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ApiOperation(value = "Modificar un usuario", response = Usuario.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Usuario modificado"),
			@ApiResponse(code = 404, message = "El usuario no existe"),
			@ApiResponse(code = 409, message = "<ol>" + "<li>El usuario ya existe.</li> "
					+ "<li>El nombre no puede estar vacío y debe contener entre 2 y 50 caracteres.</li>"
					+ "<li>El password no puede estar vacío y debe contener entre 2 y 60 caracteres.</li>"
					+ "</ol>"),
			@ApiResponse(code = 500, message = "Error fatal") })
	@ApiParam(value = "id", required = true)
	public ResponseEntity<Object> modificar(
			@ApiParam(value = "Id del usuario", required = true) @PathVariable("id") long id,
			@RequestBody Usuario usuario) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		ResponseMensaje msg = new ResponseMensaje();

		try {

			Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);
			if (violations.isEmpty()) {

				usuario.setId(id);

				if (serviceUsuario.modificar(usuario)) {
					Rol rol = new Rol();
					//TODO comprobar usuario null
					usuario.setRol(rol);
					response = new ResponseEntity<>(usuario, HttpStatus.OK);
				} else {
					response = new ResponseEntity<>(new ResponseMensaje("El usuario no existe."), HttpStatus.NOT_FOUND);
					LOG.debug("El usuario no existe.");
				}

			} else {

				msg.setMensaje("No se pudo modificar el usuario");

				for (ConstraintViolation<Usuario> violation : violations) {

					msg.addError(violation.getPropertyPath() + ": " + violation.getMessage());
				}

				response = new ResponseEntity<>(msg, HttpStatus.CONFLICT);
			}

		} catch (SQLIntegrityConstraintViolationException e) {
			response = new ResponseEntity<>(new ResponseMensaje("El usuario ya existe."), HttpStatus.CONFLICT);
			LOG.debug("El usuario ya existe.");
		} catch (Exception e) {
			LOG.error(e);
		}

		return response;

	}
}
