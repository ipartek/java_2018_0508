package com.ipartek.formacion.prestamos.api.controller;

import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ipartek.formacion.libros.service.ServiceAlumno;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

import com.ipartek.formacion.libros.pojo.Alumno;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/alumnos")
@Api(tags= {"Servicio Alumnos"}, produces ="application/json")
public class AlumnosController {

	private static final String CONFLICT_MSG = "CONFLICTO: El registro ya existe en la base de datos (al crear) o tiene datos asociados (al eliminar).";
	private static final String NOT_FOUND_MSG = "NO ENCONTRADO: El recurso no existe en la base de datos.";
	private static final String INTERNAL_ERROR = "ERROR INTERNO: No controlado.";

	private static final ResponseEntity<Object> CONFLICT_RESPONSE = new ResponseEntity<Object>(
			new ResponseMessage(CONFLICT_MSG), HttpStatus.CONFLICT);
	
	private static final ResponseEntity<Object> NOT_FOUND_RESPONSE = new ResponseEntity<Object>(
			new ResponseMessage(NOT_FOUND_MSG), HttpStatus.NOT_FOUND);
	
	private static final ResponseEntity<Object> INTERNAL_SERVER_ERROR_RESPONSE = new ResponseEntity<Object>(
			new ResponseMessage(INTERNAL_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);

	private static ServiceAlumno servicio;
	private static Alumno alumno;

	private static ValidatorFactory factory;
	private static Validator validator;

	public AlumnosController() {
		super();
		servicio = ServiceAlumno.getInstance();

		// Crear Factoria y Validador
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();

	}

	@ApiOperation(
			value = "Listado de alumnos.",
			notes = "Devuelve los alumnos disponibles en la base de datos.",
			response=Alumno.class)
	
	@ApiResponses (value = 
		{
				@ApiResponse (code=200, message="Listado de alumnos devuelto correctamente.", response = Alumno.class),
				@ApiResponse(code=400, message="URL no válida.", response = ResponseMessage.class)
		})
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Alumno>> listado() {

		ResponseEntity<ArrayList<Alumno>> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

		try {

			response = new ResponseEntity<ArrayList<Alumno>>((ArrayList<Alumno>) servicio.listar(), HttpStatus.OK);

		} catch (Exception e) {

			response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}

		return response;
	}

	@ApiOperation(
			value = "Vista detalle de un alumno en concreto.",
			notes = "Devuelve el alumno con el ID (identificador) seleccionado.",
			response=Alumno.class)
	
	@ApiResponses (value = 
		{
				@ApiResponse(code=200, message="Alumno encontrado y devuelta.", response = Alumno.class),
				@ApiResponse(code=400, message="URL no válida.", response = ResponseMessage.class),
				@ApiResponse(code=404, message="Recurso no encontrado.", response = ResponseMessage.class)
		})
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> detalle(
			@ApiParam(value = "Código indentificador del alumno a mostrar.") @PathVariable long id) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

		try {

			alumno = servicio.obtener(id);

			if (alumno != null && alumno.getId() > 0) {

				response = new ResponseEntity<Object>(alumno, HttpStatus.OK);

			} else {

				response = NOT_FOUND_RESPONSE;
			}

		} catch (Exception e) {

			response = INTERNAL_SERVER_ERROR_RESPONSE;
			e.printStackTrace();
		}

		return response;
	}

	@ApiOperation(
			value = "Modifica el alumno con el ID (identificador) introducido.",
			notes = "Devuelve el alumno creado (en formato JSON), o en caso de error, el mensaje.",
			response=Alumno.class)
	
	@ApiResponses (value = 
		{
				@ApiResponse(code=201, message="Alumno correctamente creado en la base de datos.", response = Alumno.class),
				@ApiResponse(code=400, message="Formato JSON incorrecto para alguno de los campos.", response = ResponseMessage.class),
				@ApiResponse(code=409, message="CONFLICTO: Ya existe un alumno con ese nombre.", response = ResponseMessage.class)
		})
		
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> crear(
			@ApiParam(value = "Alumno a crear en formato JSON.") @RequestBody Alumno alumno) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

		try {

			Set<ConstraintViolation<Alumno>> violations = validator.validate(alumno);

			if (violations.size() == 0) {

				if (servicio.crear(alumno)) {

					response = new ResponseEntity<Object>(alumno, HttpStatus.CREATED);

				}

			} else {

				ArrayList<String> msgs = new ArrayList<String>();

				for (ConstraintViolation<Alumno> v : violations) {

					msgs.add(v.getMessage());

				}

				ResponseMessage msg = new ResponseMessage("El campo no tiene una longitud adecuada.", msgs);
				response = new ResponseEntity<Object>(msg, HttpStatus.BAD_REQUEST);
			}

		} catch (SQLIntegrityConstraintViolationException e) {

			response = CONFLICT_RESPONSE;
			e.printStackTrace();

		} catch (Exception e) {

			response = INTERNAL_SERVER_ERROR_RESPONSE;
			e.printStackTrace();
		}

		return response;

	}

	@ApiOperation(
			value = "Elimina el alumno con el ID (identificador) introducido.",
			notes = "Devuelve un mensaje con cuerpo vacío o el mensaje de error. (en formato JSON).")
	
	@ApiResponses (value = 
		{
				@ApiResponse(code=204, message="Alumno correctamente eliminado de la base de datos."),
				@ApiResponse(code=404, message="Recurso no encontrado.", response = ResponseMessage.class),
				@ApiResponse(code=409, message="CONFLICTO: El alumno tiene algún préstamo activo.", response = ResponseMessage.class)
		})
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> eliminar(
			@ApiParam(value = "Código indentificador del alumno a eliminar.") @PathVariable long id) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

		try {

			if (id != 0 && servicio.eliminar(Long.toString(id))) {

				response = new ResponseEntity<Object>(new String("SUCCESS: Eliminado."), HttpStatus.NO_CONTENT);

			} else {

				response = NOT_FOUND_RESPONSE;

			}

		} catch (SQLIntegrityConstraintViolationException e) {

			response = CONFLICT_RESPONSE;
			e.printStackTrace();

		} catch (Exception e) {

			response = INTERNAL_SERVER_ERROR_RESPONSE;
			e.printStackTrace();
		}

		return response;
	}

	@ApiOperation(
			value = "Modifica el alumno con el ID (identificador) introducido.",
			notes = "Devuelve el alumno creado (en formato JSON), o en caso de error, el mensaje.",
			response=Alumno.class)
	
	@ApiResponses (value = 
		{
				@ApiResponse(code=200, message="Alumno correctamente modificado en la base de datos.", response = Alumno.class),
				@ApiResponse(code=400, message="Formato JSON incorrecto para alguno de los campos.", response = ResponseMessage.class),
				@ApiResponse(code=404, message="Recurso no encontrado.", response = ResponseMessage.class),
				@ApiResponse(code=409, message="CONFLICTO: Ya existe un alumno con ese nombre.", response = ResponseMessage.class)
		})
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> modificar(
			@ApiParam(value = "Código indentificador del alumno a modificar.") @PathVariable long id, 
			@ApiParam(value = "Alumno modificado en formato JSON.") @RequestBody Alumno alumno) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
		alumno.setId(id);

		try {

			if (servicio.modificar(alumno)) {

				response = new ResponseEntity<Object>(alumno, HttpStatus.OK);

			} else {

				response = NOT_FOUND_RESPONSE;

			}

		} catch (SQLIntegrityConstraintViolationException e) {

			response = CONFLICT_RESPONSE;
			e.printStackTrace();

		} catch (Exception e) {

			response = INTERNAL_SERVER_ERROR_RESPONSE;
			e.printStackTrace();
		}

		return response;

	}

}
