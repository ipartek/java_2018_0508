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
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.youtube.impl.ServiceComentario;
import com.ipartek.formacion.youtube.impl.ServiceUsuario;
import com.ipartek.formacion.youtube.impl.ServiceVideo;
import com.ipartek.formacion.youtube.pojo.Comentario;
import com.ipartek.formacion.youtube.pojo.Usuario;
import com.ipartek.formacion.youtube.pojo.Video;
import com.ipartek.formacion.youtube.service.IServiceComentario;
import com.ipartek.formacion.youtube.service.IServiceUsuario;
import com.ipartek.formacion.youtube.service.IServiceVideo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "*") // Para habilitar post habilita llamadas ajasx
@RestController
@RequestMapping("/comentarios")
@Api(tags = { "Servicio /comentarios" }, description = "Gestion de comentarios", consumes = "application/json")
public class ComentarioController {

	IServiceVideo serviceVideo = null;
	IServiceUsuario serviceUsuario = null;
	IServiceComentario serviceComentario = null;
	ValidatorFactory factory = null;
	Validator validator = null;

	private final static Logger LOG = Logger.getLogger(UsuarioController.class);

	public ComentarioController() {
		super();
		serviceVideo = ServiceVideo.getInstance();
		serviceUsuario = ServiceUsuario.getInstance();
		serviceComentario = ServiceComentario.getInstance();
		// Crear Factoria y Validador
		factory = Validation.buildDefaultValidatorFactory();
		validator = (Validator) factory.getValidator();

	}

	/**
	 * Entidad que va a responder json y codigo de estado 2 parametros cuerpo con
	 * los datos arraylist y el codigo http
	 * 
	 * @return
	 */
	@ApiOperation(value = "Listado de comentarios", notes = "Obtener todos los comentarios en json", nickname = "listado", responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Listado de comentarios ok") })
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Comentario>> listado() {

		ArrayList<Comentario> Comentarios = new ArrayList<Comentario>();

		ResponseEntity<ArrayList<Comentario>> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		try {

			Comentarios = (ArrayList<Comentario>) serviceComentario.listar();

			if (Comentarios != null && Comentarios.size() > 1) {

				response = new ResponseEntity<>(Comentarios, HttpStatus.OK);
			} else {

				// Para cuando por la razon que sea nos viene el resultado vacio o nulo
				response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

		} catch (Exception e) {

			LOG.error(e.getMessage());

		}

		return response;
	}

	@ApiOperation(value = "Detalle por Usuario", notes = "Obtener el detalle de un comentario")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Detalle del usuario correcto"),
			@ApiResponse(code = 400, message = "El requerimiento enviado por el cliente era sintácticamente incorrecto "),
			@ApiResponse(code = 401, message = "No autorizado "),
			@ApiResponse(code = 404, message = "Comentario no encontrado ") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "Id del usaurio", required = true, dataType = "long", paramType = "Path") })
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> detalle(@PathVariable long id) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		ResponseMensaje rm = new ResponseMensaje();

		try {

			Comentario comentario = serviceComentario.buscarPorId(id);

			if (comentario != null && comentario.getId() > 0) {

				response = new ResponseEntity<>(comentario, HttpStatus.OK);

			} else {
				rm.setMensaje("Usuario no encontrado");
				response = new ResponseEntity<>(rm, HttpStatus.NOT_FOUND);

			}

		} catch (Exception e) {
			LOG.error(e.getMessage());

		}
		return response;
	}

	/*
	 * @ApiOperation(value = "Eliminar Usuario", notes =
	 * "Eliminar usuario por id. Si el usuario esta asociada con algun prestamo no podra ser eliminado"
	 * )
	 * 
	 * @ApiResponses(value = { @ApiResponse(code = 200, message =
	 * "usuario eliminado"),
	 * 
	 * @ApiResponse(code = 400, message =
	 * "El requerimiento enviado por el cliente era sintácticamente incorrecto, se espera un campo numerico"
	 * ),
	 * 
	 * @ApiResponse(code = 404, message =
	 * "Error intentando un usuario que no encontramos"),
	 * 
	 * @ApiResponse(code = 409, message =
	 * "No puedes borrar un usaurio con libros asociados ") })
	 * 
	 * @RequestMapping(value = "/{id}", method = RequestMethod.DELETE) public
	 * ResponseEntity<Object> eliminar(@PathVariable long id) {
	 * 
	 * ResponseEntity<Object> response = new
	 * ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); ResponseMensaje rm = new
	 * ResponseMensaje();
	 * 
	 * try {
	 * 
	 * if (serviceUsuario.eliminarUsuario(id)) {
	 * 
	 * response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
	 * 
	 * } else {
	 * 
	 * rm.setMensaje("Usuario no encontrado en la base de datos");
	 * 
	 * response = new ResponseEntity<>(rm, HttpStatus.NOT_FOUND); }
	 * 
	 * } catch (SQLIntegrityConstraintViolationException x) { if
	 * (x.getMessage().contains("foreign key")) { String[] errores = new String[1];
	 * rm.setMensaje("Error"); errores[0] =
	 * "El usuario que intenta borrar tiene registros asociados.";
	 * rm.setErrores(errores); response = new ResponseEntity<>(rm,
	 * HttpStatus.CONFLICT); LOG.debug(x.getMessage()); }
	 * 
	 * } catch (Exception e) { String[] errores = new String[1];
	 * rm.setMensaje("Error"); errores[0] = e.getMessage(); rm.setErrores(errores);
	 * response = new ResponseEntity<>(rm, HttpStatus.CONFLICT);
	 * LOG.debug(e.getMessage()); } return response; }
	 */

	@ApiOperation(value = "Crear comentario", notes = "Para la creacion de un comentario se espera un objeto json<br>"
			+ "<h2>Requisitos para la creacion de un comentario</h2>" + "<ul>"
			+ "<li>El comentario no debe contener campo id</li>" + "<li>El comentario ha de tener id de usuario e id de video</li>"
			+ "<li>Si no se especifica fecha se mantendra la orignal de publicacion</li>" + ""
					+ "<li>El campo texto no puede estar vacio</li></ul>"
					+ "<h2>Objeto json minimo esperado</h2><br>"
					+ "<pre>"
					+ "{\r\n" + 
					"	\"texto\": \"string\",\r\n" + 
					"	\"usuario\": {\r\n" + 
					"		\"id\": 25\r\n" + 
					"	},\r\n" + 
					"	\"video\": {\r\n" + 
					"		\"id\": 4\r\n" + 
					"	}\r\n" + 
					"}"
					+ "</pre>", response = Comentario.class)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Comentario Creado correctamente", response = Comentario.class),
			@ApiResponse(code = 400, message = "Verifique los datos enviados"),
			@ApiResponse(code = 409, message = "Conflictos :<br> Usuario no existente.<br>Video no existente<br>Mensaje vacio") })

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Object> crear(@RequestBody Comentario comentario) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		ResponseMensaje rm = new ResponseMensaje();

		try {

			Set<ConstraintViolation<Comentario>> violations = validator.validate(comentario);
			String[] errores = new String[violations.size()];

			if (violations.size() > 0) {

				int contador = 0;

				// No tenemos ningun fallo, la Validacion es correcta
				for (ConstraintViolation<Comentario> violation : violations) {

					errores[contador] = violation.getPropertyPath() + ":" + violation.getMessage();
					contador++;
				}

				rm.setErrores(errores);
				rm.setMensaje("error de validación");
				response = new ResponseEntity<>(rm, HttpStatus.CONFLICT);

			} else {

				if (serviceComentario.crear(comentario)) {

					response = new ResponseEntity<>(comentario, HttpStatus.CREATED);

				} else {

					response = new ResponseEntity<>(HttpStatus.CONFLICT);
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

		} catch (Exception e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
			rm.setMensaje("Hemos tenido un problema");
			response = new ResponseEntity<>(rm, HttpStatus.CONFLICT);

		}

		return response;
	}

	@ApiOperation(value = "Modificar Comentarios",notes="Para la edicion de un video se espera un objeto json<br>"
			+ "<h2>Requisitos para la edicion de un comentario</h2>" + "<ul>"
			+ "<li>El campo id se lo pasamos como parametro</li>" + "<li>El comentario ha de tener id de usuario e id de video</li>"
					+ "<li>El campo texto no puede estar vacio</li>"
			+ "<li>Si no se especifica fecha se mantendra la orignal de publicacion</li>" + "</ul>"
			+ "<h2>Objeto json minimo esperado</h2><br>"
			+ "<pre>"
			+ "{\r\n" + 
			"	\"texto\": \"string\",\r\n" + 
			"	\"usuario\": {\r\n" + 
			"		\"id\": 25\r\n" + 
			"	},\r\n" + 
			"	\"video\": {\r\n" + 
			"		\"id\": 4\r\n" + 
			"	}\r\n" + 
			"}"
			+ "</pre>", response = Comentario.class)
	@ApiResponses(value = {

			@ApiResponse(code = 201, message = "Modificacion correcta"),
			@ApiResponse(code = 400, message = "No encontrado"),
			@ApiResponse(code = 409, message = "Conflictos :<br> Usuario no existente.<br>Video no existente<br>Mensaje vacio") })
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> modificar(@PathVariable long id, @RequestBody Comentario comentario) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		ResponseMensaje rm = new ResponseMensaje();

		try {
			Usuario u = serviceUsuario.buscarPorId(comentario.getUsuario().getId());
			Video v = serviceVideo.buscarPorId(comentario.getVideo().getId());
			comentario.setUsuario(u);
			comentario.setVideo(v);
			Set<ConstraintViolation<Comentario>> violations = validator.validate(comentario);
			String[] errores = new String[violations.size()];

			if (violations.size() > 0) {

				int contador = 0;
				// No ha pasado la valiadacion, iterar sobre los mensajes de validacion
				for (ConstraintViolation<Comentario> violation : violations) {

					errores[contador] = violation.getPropertyPath() + " :" + violation.getMessage();
					contador++;

				}
				rm.setErrores(errores);
				rm.setMensaje("Error de validación");

				response = new ResponseEntity<>(rm, HttpStatus.CONFLICT);

			} else {

				comentario.setId(id);

				if (serviceComentario.modificarComentario(comentario)) {

					response = new ResponseEntity<>(comentario, HttpStatus.CREATED);

				} else {

					response = new ResponseEntity<>(HttpStatus.CONFLICT);
				}
			}

		} catch (SQLIntegrityConstraintViolationException x) {
			LOG.debug(x.getMessage());
			if (x.getMessage().contains("Duplicate entry")) {
				String[] errores = new String[1];
				rm.setMensaje("Error");
				errores[0] = "El usuario ya existe";
				rm.setErrores(errores);
				response = new ResponseEntity<>(rm, HttpStatus.CONFLICT);
			}
			if (x.getMessage().contains("Cannot add or update a child row")) {
				String[] errores = new String[1];
				rm.setMensaje("Error");
				errores[0] = "El alumno debe contener un rol";
				rm.setErrores(errores);
				response = new ResponseEntity<>(rm, HttpStatus.CONFLICT);
			}

		} catch (Exception e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
		}

		return response;
	}
}
