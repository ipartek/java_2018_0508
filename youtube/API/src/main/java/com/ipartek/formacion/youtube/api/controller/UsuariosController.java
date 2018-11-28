package com.ipartek.formacion.youtube.api.controller;

import java.sql.SQLDataException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
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
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.youtube.pojo.Usuario;
import com.ipartek.formacion.youtube.service.impl.ServiceUsuario;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "*") // Habilitar CORS -> Llamadas en JS
@RestController
@RequestMapping("/usuarios")

@Api(tags = { "Usuarios" }, produces = "application/json", description = "Gestión de Usuarios del proyecto Youtube.")
public class UsuariosController {

	private static final Logger LOG = Logger.getLogger(UsuariosController.class);

	private static final String NOT_FOUND_MSG = "NO ENCONTRADO: El recurso no existe en la base de datos.";
	private static final String INTERNAL_ERROR_MSG = "ERROR INTERNO: No controlado.";

	private static final ResponseEntity<Object> NOT_FOUND_RESPONSE = new ResponseEntity<Object>(
			new ResponseMessage(NOT_FOUND_MSG), HttpStatus.NOT_FOUND);

	private static final ResponseEntity<Object> INTERNAL_SERVER_ERROR_RESPONSE = new ResponseEntity<Object>(
			new ResponseMessage(INTERNAL_ERROR_MSG), HttpStatus.INTERNAL_SERVER_ERROR);

	private static ServiceUsuario servicio;
	private static Usuario usuario;

	private static ValidatorFactory factory;
	private static Validator validator;

	public UsuariosController() {
		super();
		servicio = ServiceUsuario.getInstance();

		// Crear Factoria y Validador
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();

	}

	@ApiOperation(value = "Listado de usuarios, sin la contraseña.", notes = "Devuelve los usuarios disponibles en la base de datos, a excepción de la contraseña.", response = Usuario.class)

	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Listado de usuarios devuelto correctamente.", response = Usuario.class) })

	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Usuario>> listado() {

		ResponseEntity<ArrayList<Usuario>> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

		List<Usuario> usuarios;

		try {

			usuarios = servicio.listarPublicos();

			if (!usuarios.isEmpty()) {

				response = new ResponseEntity<ArrayList<Usuario>>((ArrayList<Usuario>) usuarios, HttpStatus.OK);

			} else {

				response = new ResponseEntity<ArrayList<Usuario>>(HttpStatus.NO_CONTENT);

			}

		} catch (Exception e) {

			response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			LOG.error(e);
		}

		return response;
	}

	@ApiOperation(value = "Vista detalle de un usuario en concreto.", notes = "Devuelve el usuario con el ID (identificador) de la URL.", response = Usuario.class)

	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Usuario encontrado y devuelto.", response = Usuario.class),
			@ApiResponse(code = 400, message = "Solicitud incorrecta.", response = ResponseMessage.class),
			@ApiResponse(code = 404, message = "Recurso no encontrado.", response = ResponseMessage.class) })

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> detalle(

			@ApiParam(value = "Código indentificador del usuario a mostrar.") @PathVariable long id) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

		try {

			usuario = servicio.buscarPorId(id);

			if (usuario != null && usuario.getId() > 0) {

				usuario.setPassword("");

				response = new ResponseEntity<Object>(usuario, HttpStatus.OK);

			} else {

				response = NOT_FOUND_RESPONSE;
			}

		} catch (Exception e) {

			response = INTERNAL_SERVER_ERROR_RESPONSE;
			e.printStackTrace();
		}

		return response;
	}

	@ApiOperation(value = "Modifica el usuario con el ID (identificador) introducido.", notes = "Devuelve el usuario creado (en formato JSON), o en caso de error, el mensaje."
			+ "<br>Los campos necesarios son:" + "<ul><li>Nombre</li>"
			+ "<li>Password</li></ul>", response = Usuario.class)

	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Usuario correctamente modificado en la base de datos.", response = Usuario.class),
			@ApiResponse(code = 400, message = "Solicitud incorrecta.", response = ResponseMessage.class),
			@ApiResponse(code = 409, message = "CONFLICTO: Ya existe un usuario con ese nombre.", response = ResponseMessage.class) })

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> crear(
			@ApiParam(value = "Usuario a crear en formato JSON.") @RequestBody Usuario usuario) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

		try {

			Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);

			if (violations.size() == 0) {

				if (servicio.crear( usuario )) {

					response = new ResponseEntity<Object>(usuario, HttpStatus.CREATED);

				}

			} else {

				ArrayList<String> msgs = new ArrayList<String>();

				for (ConstraintViolation<Usuario> v : violations) {

					msgs.add(v.getMessage());

				}

				ResponseMessage msg = new ResponseMessage("Los siguientes errores han sucedido:", msgs);
				response = new ResponseEntity<Object>(msg, HttpStatus.BAD_REQUEST);
			}

		} catch (SQLIntegrityConstraintViolationException e) {

			response = new ResponseEntity<Object>(
					new ResponseMessage("CONFLICTO: Ya existe un usuario con ese nombre."), HttpStatus.CONFLICT);
			LOG.debug(e);

		} catch (Exception e) {

			response = INTERNAL_SERVER_ERROR_RESPONSE;
			LOG.error(e);
		}

		return response;

	}

	@ApiOperation(value = "Elimina el usuario con el ID (identificador) introducido.", notes = "Devuelve un mensaje con cuerpo vacío o el mensaje de error. (en formato JSON).")

	@ApiResponses(value = { @ApiResponse(code = 204, message = "Usuario correctamente eliminado de la base de datos."),
			@ApiResponse(code = 404, message = "Recurso no encontrado.", response = ResponseMessage.class),
			@ApiResponse(code = 409, message = "CONFLICTO: El usuario no se puede eliminar.", response = ResponseMessage.class) })

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> eliminar(
			@ApiParam(value = "Código indentificador del usuario a eliminar.") @PathVariable long id) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

		try {

			if (id != 0 && servicio.eliminar(id)) {

				response = new ResponseEntity<Object>(new ResponseMessage("SUCCESS: Eliminado."),
						HttpStatus.NO_CONTENT);

			} else {

				response = NOT_FOUND_RESPONSE;

			}

		} catch (SQLIntegrityConstraintViolationException e) {

			response = new ResponseEntity<Object>(new ResponseMessage("CONFLICTO: El usuario ya existe."),
					HttpStatus.CONFLICT);
			LOG.debug(e);
		
		} catch (SQLDataException e) {

			response = new ResponseEntity<Object>(new ResponseMessage("CONFLICTO: El usuario no se puede eliminar."),
					HttpStatus.CONFLICT);
			LOG.debug(e);

		} catch (Exception e) {

			response = INTERNAL_SERVER_ERROR_RESPONSE;
			LOG.error(e);
		}

		return response;
	}

	@ApiOperation(value = "Modifica el usuario con el ID (identificador) introducido. Sólo se pueden modificar los usuarios de tipo CLIENTE.", notes = "Devuelve el ususario modificado (en formato JSON), o en caso de error, el mensaje.", response = Usuario.class)

	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Usuario correctamente modificado en la base de datos.", response = Usuario.class),
			@ApiResponse(code = 400, message = "Solicitud incorrecta.", response = ResponseMessage.class),
			@ApiResponse(code = 404, message = "Recurso no encontrado.", response = ResponseMessage.class),
			@ApiResponse(code = 409, message = "CONFLICTO: Ya existe un usuario con ese nombre.", response = ResponseMessage.class) })

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> modificar(
			@ApiParam(value = "Código indentificador del usuario (Cliente) a modificar.") @PathVariable long id,
			@ApiParam(value = "Usuario modificado en formato JSON.") @RequestBody Usuario usuario) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
		usuario.setId(id);

		try {

			if (servicio.modificar(usuario)) {

				response = new ResponseEntity<Object>(usuario, HttpStatus.OK);

			} else {

				response = NOT_FOUND_RESPONSE;

			}

		} catch (SQLIntegrityConstraintViolationException e) {

			response = new ResponseEntity<Object>(new ResponseMessage("CONFLICTO: Ya existe un usuario con ese nombre"),
					HttpStatus.CONFLICT);
			e.printStackTrace();

		} catch (Exception e) {

			response = INTERNAL_SERVER_ERROR_RESPONSE;
			e.printStackTrace();
		}

		return response;

	}

}
