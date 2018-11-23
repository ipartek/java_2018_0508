package com.ipartek.formacion.youtube.api.controller;

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
import com.ipartek.formacion.youtube.impl.ServiceVideo;
import com.ipartek.formacion.youtube.pojo.Usuario;
import com.ipartek.formacion.youtube.pojo.Video;
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
@RequestMapping("/videos")
@Api(tags = { "Servicio /videos" }, description = "Gestion de videos", consumes = "application/json")
public class VideoController {

	IServiceVideo serviceVideo = null;
	IServiceUsuario serviceUsuario = null;
	ValidatorFactory factory = null;
	Validator validator = null;

	private final static Logger LOG = Logger.getLogger(VideoController.class);

	public VideoController() {
		super();
		serviceVideo = ServiceVideo.getInstance();
		serviceUsuario = ServiceUsuario.getInstance();
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
	@ApiOperation(value = "Listado de Videos", notes = "Obtener todos los videos en json", nickname = "listado", responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Listado de videos ok") })
	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Video>> listado() {

		ArrayList<Video> list = new ArrayList<Video>();

		ResponseEntity<ArrayList<Video>> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		try {

			list = (ArrayList<Video>) serviceVideo.listar();

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

	@ApiOperation(value = "Detalle por Video", notes = "Obtener el detalle de un video")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Detalle del video correcto"),
			@ApiResponse(code = 400, message = "El requerimiento enviado por el cliente era sintácticamente incorrecto "),
			@ApiResponse(code = 401, message = "No autorizado "),
			@ApiResponse(code = 404, message = "Videos no encontrado ") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "Id del video", required = true, dataType = "long", paramType = "Path") })
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> detalle(@PathVariable long id) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		ResponseMensaje rm = new ResponseMensaje();

		try {

			Video video = serviceVideo.buscarPorId(id);

			if (video != null && video.getId() > 0) {

				response = new ResponseEntity<>(video, HttpStatus.OK);

			} else {
				rm.setMensaje("Usuario no encontrado");
				response = new ResponseEntity<>(rm, HttpStatus.NOT_FOUND);

			}

		} catch (Exception e) {
			LOG.error(e.getMessage());

		}
		return response;
	}



	@ApiOperation(value = "Crear Video", notes = "Para la creacion de un video se espera un objeto json con los siguientes requisitos <br>"
			+ "<h2>Requisitos para la creacion de un video</h2>" + "<ul>"
			+ "<li>No puede haber videos sin usuarios, pero si se pueden crear sin comentarios</li>"
			+ "<li>El nombre debe ser mayor de 2 y menor de 50 caracteres</li>" + "<li>No puede estar vacio</li>"
			+ "<li>No se permiten nombres de videos duplicadas</li>"
			+ "<li>El codigo del video debe contener 11 caracteres</li></ul>"
			+ "<h6>Plantilla minima para la creacion de un video</h6>" + "<pre>" + "{\r\n"
			+ "  \"codigo\": \"8tC5vjvuE-A\",\r\n" + "  \"nombre\": \"blake\",\r\n" + "  \"usuario\": {\r\n"
			+ "    \"id\":4,\r\n" + "    }\r\n" + "}" + "</pre>"

			, response = Video.class)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "video Creado", responseContainer = "nose"),
			@ApiResponse(code = 400, message = "Verifique los datos enviados"),
			@ApiResponse(code = 409, message = "Conflictos :<br> Video existente.<br>Nombre del video menor de 2 caracteres<br>Nombre mayor mayor 50") })

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Object> crear(@RequestBody Video video) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		ResponseMensaje rm = new ResponseMensaje();

		try {

			Set<ConstraintViolation<Video>> violations = validator.validate(video);
			String[] errores = new String[violations.size()];

			if (violations.size() > 0) {

				int contador = 0;

				// No tenemos ningun fallo, la Validacion es correcta
				for (ConstraintViolation<Video> violation : violations) {

					errores[contador] = violation.getPropertyPath() + ":" + violation.getMessage();
					contador++;
				}

				rm.setErrores(errores);
				rm.setMensaje("error de validación");
				response = new ResponseEntity<>(rm, HttpStatus.CONFLICT);

			} else {
				Usuario u = serviceUsuario.buscarPorId(video.getUsuario().getId());
				video.setUsuario(u);

				if (serviceVideo.crear(video)) {

					response = new ResponseEntity<>(video, HttpStatus.CREATED);

				} else {

					response = new ResponseEntity<>(HttpStatus.CONFLICT);
				}
			}
		} catch (SQLIntegrityConstraintViolationException e) {

			LOG.debug(e.getMessage());
			if (e.getMessage().contains("Duplicate entry")) {
				String[] errores = new String[1];
				rm.setMensaje("Error de integridad");
				errores[0] = "El Video ya existe";
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

	@ApiOperation(value = "Modificar Videos", notes = "Para la modificacion de un video se espera un objeto json .<br>"
			+ "El id del video se la pasamos en campo id como @pathvariable"
			+ "<h2>Requisitos para la modificacion de un video</h2>" + "<ul>"
			+ "<li>La modificacion del codigo del video tiene que ser por otro de 11 caracteres</li>"
			+ "<li>No puede estar vacio</li>"
			+ "<li>No se permiten videos con codigo duplicado, por lo que si ya existe devolvera un error de respuesta 409</li>"
			+ "<li>El titulo de la cancion debe contener entre 2 y 150 caracteres</li>" + "</ul>"
			+ "<b>Formato esperado</b><br>" + "<pre>{\r\n" + "  \"codigo\": \"string\",\r\n"
			+ "  \"nombre\": \"string\",\r\n" + "  \"usuario\": {\r\n" + "    \"id\": 0\r\n" + "  }\r\n"
			+ "}</pre>", response = Video.class)
	@ApiResponses(value = {

			@ApiResponse(code = 201, message = "Modificacion correcta"),
			@ApiResponse(code = 400, message = "Algun campo no cumple con las condiciones ejemplo codigo cancion no tiene el numero de caracteres "),
			@ApiResponse(code = 409, message = "Modificacion del nombre de un usuario por un nombre ya existente<br> El nombre contiene menos de 2 o mas de 50 caracteres") })
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> modificar(@PathVariable long id, @RequestBody Video videoModif) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		ResponseMensaje rm = new ResponseMensaje();

		try {

			Set<ConstraintViolation<Video>> violations = validator.validate(videoModif);
			String[] errores = new String[violations.size()];

			if (violations.size() > 0) {

				int contador = 0;
				// No ha pasado la valiadacion, iterar sobre los mensajes de validacion
				for (ConstraintViolation<Video> violation : violations) {

					errores[contador] = violation.getPropertyPath() + " :" + violation.getMessage();
					contador++;

				}
				rm.setErrores(errores);
				rm.setMensaje("Error de validación");

				response = new ResponseEntity<>(rm, HttpStatus.CONFLICT);

			} else {
				videoModif.setId(id);

				if (serviceVideo.modificarVideo(videoModif)) {

					response = new ResponseEntity<>(videoModif, HttpStatus.CREATED);

				} else {

					response = new ResponseEntity<>(HttpStatus.CONFLICT);
				}
			}

		} catch (SQLIntegrityConstraintViolationException x) {
			LOG.debug(x.getMessage());
			if (x.getMessage().contains("Duplicate entry")) {
				String[] errores = new String[1];
				rm.setMensaje("Error");
				errores[0] = "El Codigo de la cancion ya existe";
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

		}catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
		}

		return response;
	}
}
