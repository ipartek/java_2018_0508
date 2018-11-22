/*package com.ipartek.formacion.gestiondocente.api.controller;

import java.sql.SQLException;
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
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.youtube.impl.ServiceUsuario;
import com.ipartek.formacion.youtube.pojo.Usuario;
import com.ipartek.formacion.youtube.service.IServiceUsuario;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "*") // Para habilitar post habilita llamadas ajasx
@RestController
@RequestMapping("/usuarios")
@Api(tags = { "Servicio /usuarios" }, description = "Clase UsuarioController", consumes = "application/json")
public class AlumnosController {

	
	ValidatorFactory factory = null;
	Validator validator = null;

	private final static Logger LOG = Logger.getLogger(AlumnosController.class);

	public AlumnosController() {
		super();

		// Crear Factoria y Validador
		factory = Validation.buildDefaultValidatorFactory();
		validator = (Validator) factory.getValidator();

	}

	*//**
	 * Entidad que va a responder json y codigo de estado 2 parametros cuerpo con
	 * los datos arraylist y el codigo http
	 * 
	 * @return
	 *//*
	@ApiOperation(value = "Listado de alumnos", notes = "Obtener todos los alumnos en json", nickname = "listado", responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Listado de alumnos ok"),
			@ApiResponse(code = 400, message = "Error "), @ApiResponse(code = 401, message = "No autorizado "),
			@ApiResponse(code = 404, message = "No encontrado ") })
	@ApiParam(required = false, name = "Blabla ?", defaultValue = "1")
	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Usuario>> listado() {

		ArrayList<Usuario> list = new ArrayList<Usuario>();

		ResponseEntity<ArrayList<Usuario>> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		try {

			list = (ArrayList<Usuario>) serviceUsuario.listar();

			if (list != null && list.size() > 1) {

				response = new ResponseEntity<>(list, HttpStatus.OK);
			} else {

				// Para cuando por la razon que sea nos viene el resultado vacio o nulo
				response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

		} catch (Exception e) {

			LOG.error(e.getMessage());

		}

		return response;
	}

	@ApiOperation(value = "Detalle por Usuario", notes = "Obtener el detalle de un usuario")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Detalle del usuario correcto"),
			@ApiResponse(code = 400, message = "El requerimiento enviado por el cliente era sintácticamente incorrecto "),
			@ApiResponse(code = 401, message = "No autorizado "),
			@ApiResponse(code = 404, message = "Usaurios no encontrado ") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "Id del usaurio", required = true, dataType = "long", paramType = "Path") })
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> detalle(@PathVariable long id) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		ResponseMensaje rm = new ResponseMensaje();

		try {

			Usuario usuario = serviceUsuario.buscarPorId(id);

			if (usuario != null && usuario.getId() > 0) {

				response = new ResponseEntity<>(usuario, HttpStatus.OK);

			} else {
				rm.setMensaje("Usuario no encontrado");
				response = new ResponseEntity<>(rm, HttpStatus.NOT_FOUND);

			}

		} catch (Exception e) {
			LOG.error(e.getMessage());

		}
		return response;
	}

	@ApiOperation(value = "Eliminar Usuario", notes = "Eliminar usuario por id. Si el usuario esta asociada con algun prestamo no podra ser eliminado")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "usuario eliminado"),
			@ApiResponse(code = 400, message = "El requerimiento enviado por el cliente era sintácticamente incorrecto, se espera un campo numerico"),
			@ApiResponse(code = 404, message = "Error intentando un usuario que no encontramos"),
			@ApiResponse(code = 409, message = "No puedes borrar un usaurio con libros asociados ") })
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> eliminar(@PathVariable long id) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		ResponseMensaje rm = new ResponseMensaje();

		try {

			if (serviceUsuario.eliminarUsuario(id)) {

				response = new ResponseEntity<>(HttpStatus.OK);

			} else {

				rm.setMensaje("Usuario no encontrado en la base de datos");

				response = new ResponseEntity<>(rm, HttpStatus.NOT_FOUND);
			}

		} catch (SQLIntegrityConstraintViolationException x) {
			if (x.getMessage().contains("foreign key")) {
				String[] errores = new String[1];
				rm.setMensaje("Error");
				errores[0] = "El alumno que intenta borrar tiene registros asociados.";
				rm.setErrores(errores);
				response = new ResponseEntity<>(rm, HttpStatus.CONFLICT);
				LOG.debug(x.getMessage());
			}

		} catch (Exception e) {

			LOG.error(e.getMessage());
		}
		return response;
	}

	
	@ApiOperation(value = "Crear usuario", notes = "Para la creacion de un usuario se espera un objeto json con un unico campo llamado nombre.<br>"
			+ "<h2>Requisitos para la creacion de un usuario</h2>" + "<ul>"
			+ "<li>Debe ser mayor de 2 y menor de 50 caracteres</li>" + "<li>No puede estar vacio</li>"
			+ "<li>No se permiten usuarios duplicadas</li>" + "</ul>", response = Usuario.class)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Usuario Creada", responseContainer = "nose"),
			@ApiResponse(code = 400, message = "No encontrado"),
			@ApiResponse(code = 409, message = "Conflictos :<br> Usuario existente.<br>Nombre del usuario menor de 2 caracteres<br>Nombre usuario mayor 50") })

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Object> crear(@RequestBody Usuario usuario) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		ResponseMensaje rm = new ResponseMensaje();

		try {

			Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);
			String[] errores = new String[violations.size()];

			if (violations.size() > 0) {

				int contador = 0;

				// No tenemos ningun fallo, la Validacion es correcta
				for (ConstraintViolation<Usuario> violation : violations) {

					errores[contador] = violation.getPropertyPath() + ":" + violation.getMessage();
					contador++;
				}

				rm.setErrores(errores);
				rm.setMensaje("error de validación");
				response = new ResponseEntity<>(rm, HttpStatus.CONFLICT);

			} else {

				if (serviceUsuario.crear(usuario)) {

					response = new ResponseEntity<>(usuario, HttpStatus.CREATED);

				} else {
					
					
					response = new ResponseEntity<>( HttpStatus.CONFLICT);
				}
			}
		} catch (SQLIntegrityConstraintViolationException e) {

			LOG.debug(e.getMessage());
			if (e.getMessage().contains("Duplicate entry")) {
				String[] errores = new String[1];
				rm.setMensaje("Error de integridad");
				errores[0] = "El usuario ya existe";
				rm.setErrores(errores);
				response = new ResponseEntity<>(rm, HttpStatus.CONFLICT);
			}

		} catch (SQLException e) {

			LOG.debug(e.getMessage());
			if (e.getMessage().contains("nombre")) {

				rm.setMensaje("El <b>nombre</b> debe ser inferior a 50 caracteres");
				response = new ResponseEntity<>(rm, HttpStatus.CONFLICT);

			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
			rm.setMensaje("Hemos tenido un problema");
			response = new ResponseEntity<>(rm, HttpStatus.CONFLICT);

		}

		return response;
	}

}
*/