package com.ipartek.formacion.youtube.api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.youtube.pojo.Usuario;
import com.ipartek.formacion.youtube.servicio.impl.ServiceUsuario;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

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

@Api(tags = { "Usuarios" }, produces = "application/json", description = "Gestión Usuarios")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

	ServiceUsuario serviceUsuario = null;
	ValidatorFactory factory = null;
	Validator validator = null;

	// Logger
	private final static Logger LOG = Logger.getLogger(UsuariosController.class);

	public UsuariosController() {
		super();
		LOG.trace("Constructor");
		serviceUsuario = ServiceUsuario.getInstance();
		LOG.trace("Servicio usuario instanciado");

		// Crear Factoria y Validador
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@ApiOperation(value = "Listado de usuarios públicos", notes = "Muestra el listado de todos los usuarios", produces = "application/json")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Listado usuarios mostrado"), 
							@ApiResponse(code = 204, message = "Listado vacío")})
	@RequestMapping(/*value= {"/", ""},*/ method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Usuario>> listado() {
		ResponseEntity<ArrayList<Usuario>> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

		try {
			usuarios = (ArrayList<Usuario>) serviceUsuario.listarPublicos();
			if(usuarios != null && usuarios.size() > 0) {
				response = new ResponseEntity<>(usuarios, HttpStatus.OK);
				LOG.debug("Listado de usuarios devuelto " + usuarios.size());
			}else {
				response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
				LOG.debug("No se han encontrado usuarios");
			}
			
		} catch (Exception e) {
			LOG.error(e);
		}

		return response;
	}

	@ApiOperation(value = "Detalle usuario", notes = "Muestra el detalle de un usuario en concreto<br>"
			+ "Campos obligatorios:<br> <ol><li>1)<b> idUsuario: </b> Identificador del usuario</li></ol>", produces = "application/json")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Usuario mostrado", responseContainer = "Usuario"),
							@ApiResponse(code = 404, message = "No existe el usuario") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "Id usuario", required = true, dataType = "long", paramType = "Path") })
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Usuario> detalle(@PathVariable long id) {

		ResponseEntity<Usuario> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		try {
			Usuario usuario = serviceUsuario.buscarPorId(id);
			if (usuario != null && usuario.getId() > 0) {
				response = new ResponseEntity<>(usuario, HttpStatus.OK);
				LOG.debug("Detalle de usuario devuelto correctamente");
			} else {
				response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
				LOG.debug("No se ha encontrado el usuario a mostrar");
			}
		} catch (Exception e) {
			LOG.error(e);
		}

		return response;
	}

	@ApiOperation(value = "Crear usuario", notes = "Crea un nuevo usuario<br>"
			+ "Campos obligatorios:<br> <ol><li>1)<b> idUsuario: </b> Identificador del usuario</li>"
			+ "<li> 2) <b>Pojo Usuario: </b> Nombre y Password</li></ol>", produces = "application/json", response = Usuario.class)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Usuario creado"),
			 				@ApiResponse(code = 400, message = "Datos no correctos"),
							@ApiResponse(code = 409, message = "Nombre de usuario ya existe") })
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> crear(@RequestBody Usuario usuario) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		try {

			Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);
			if (violations.isEmpty()) {
				/* Ha pasado la validacion */
				if (serviceUsuario.crear(usuario)) {
					response = new ResponseEntity<>(usuario, HttpStatus.CREATED);
					LOG.debug("Usuario creado correctamente");
				} else {
					response = new ResponseEntity<>(HttpStatus.CONFLICT);
					LOG.debug("No se ha podido crear el usuario");
				}
			} else {
				/* Hay fallos, la Validacion no es correcta */
				ResponseMensaje msj = new ResponseMensaje();
				msj.setMensaje("Los datos no son válidos.");
				for (ConstraintViolation<Usuario> violation : violations) {
					msj.addError(violation.getPropertyPath() + ": " + violation.getMessage());
					LOG.debug("Errores de validacion al crear usuario: " + violation.getPropertyPath() + ": "
							+ violation.getMessage());
				}
				response = new ResponseEntity<>(msj, HttpStatus.BAD_REQUEST);
			}

		}catch (MySQLIntegrityConstraintViolationException e) {
			LOG.debug(e);
			ResponseMensaje msj = new ResponseMensaje("Ya existe el usuario, por favor prueba con otro nombre.");
			response = new ResponseEntity<>(msj, HttpStatus.CONFLICT);
		}catch (Exception e) {
			LOG.error(e);
			ResponseMensaje msj = new ResponseMensaje("Error no controlado.");
			response = new ResponseEntity<>(msj, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

	@ApiOperation(value = "Modificar usuario", notes = "Modifica los valores de un usuario<br>"
			+ "Campos obligatorios:<br> <ol><li>1)<b> idUsuario: </b> Identificador del usuario</li></ol>", produces = "application/json", response = Usuario.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Usuario modificado"),
			@ApiResponse(code = 400, message = "Datos incorrectos"),
			@ApiResponse(code = 404, message = "No existe"),
			@ApiResponse(code = 409, message = "Nombre de usuario ya existe") })
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> modificar(@PathVariable long id, @RequestBody Usuario usuario) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		try {
			Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);

			usuario.setId(id);

			if (violations.isEmpty()) {
				/* Ha pasado la validacion */
				if (serviceUsuario.modificar(usuario)) {
					response = new ResponseEntity<>(usuario, HttpStatus.OK);
					LOG.debug("Usuario modificado correctamente");
				} else {
					response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
					LOG.debug("No se ha encontrado el usuario a modificar");
				}
			} else {
				/* Hay fallos, la Validacion no es correcta */
				ResponseMensaje msj = new ResponseMensaje();
				msj.setMensaje("Los datos no son válidos.");
				for (ConstraintViolation<Usuario> violation : violations) {
					msj.getErrores().add(violation.getPropertyPath() + ": " + violation.getMessage());
					LOG.debug("Errores de validacion al modificar usuario: " + violation.getPropertyPath() + ": "
							+ violation.getMessage());
				}
				response = new ResponseEntity<>(msj, HttpStatus.BAD_REQUEST);
			}
		} catch (MySQLIntegrityConstraintViolationException e) {
			LOG.debug(e);
			ResponseMensaje msj = new ResponseMensaje("Ya existe el usuario, por favor prueba con otro nombre.");
			response = new ResponseEntity<>(msj, HttpStatus.CONFLICT);
		} catch (Exception e) {
			LOG.error(e);
			ResponseMensaje msj = new ResponseMensaje("Error no controlado.");
			response = new ResponseEntity<>(msj, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

	@ApiOperation(value = "Eliminar usuario", notes = "Elimina un usuario existente<br>"
			+ "Campos obligatorios:<br> <ol><li>1)<b> idUsuario: </b> Identificador del usuario</li>", produces = "application/json")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Usuario eliminado"),
			@ApiResponse(code = 404, message = "Usuario no existe"),
			@ApiResponse(code = 409, message = "Vídeos asociados") })
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> eliminar(@PathVariable long id) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		try {
			if (serviceUsuario.eliminar(id)) {
				response = new ResponseEntity<>(HttpStatus.OK);
				LOG.debug("Usuario eliminado correctamente");
			} else {
				ResponseMensaje msj = new ResponseMensaje("No se puede borrar un usuario que no existe");
				response = new ResponseEntity<>(msj, HttpStatus.NOT_FOUND);
				LOG.debug("No se ha encontrado el usuario a borrar");
			}
		} catch (MySQLIntegrityConstraintViolationException e) {
			LOG.debug(e);
			ResponseMensaje msj = new ResponseMensaje("No se puede borrar el usuario porque tiene videos asociados.");
			response = new ResponseEntity<>(msj, HttpStatus.CONFLICT);
		} catch (Exception e) {
			LOG.error(e);
		}

		return response;
	}

}
