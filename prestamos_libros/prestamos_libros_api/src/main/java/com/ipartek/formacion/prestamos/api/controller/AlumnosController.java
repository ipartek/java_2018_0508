package com.ipartek.formacion.prestamos.api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.prestamos_libros.pojo.Alumno;
import com.ipartek.formacion.prestamos_libros.service.ServiceAlumno;
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

@Api(tags = { "Alumnos" }, produces = "application/json", description = "Gestión Alumnos")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/alumnos")
public class AlumnosController {

	ServiceAlumno serviceAlumno = null;
	ValidatorFactory factory = null;
	Validator validator = null;

	// Logger
	private final static Logger LOG = Logger.getLogger(PrestamosController.class);

	public AlumnosController() {
		super();
		LOG.trace("Constructor");
		serviceAlumno = ServiceAlumno.getInstance();
		LOG.trace("Servicio alumno instanciado");

		// Crear Factoria y Validador
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@ApiOperation(value = "Listado de alumnos", notes = "Muestra el listado de todos los alumnos", produces = "application/json")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Mostrar listado alumnos", responseContainer = "List") })
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Alumno>> listado() {
		ResponseEntity<ArrayList<Alumno>> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();

		try {
			alumnos = (ArrayList<Alumno>) serviceAlumno.listar();
			response = new ResponseEntity<>(alumnos, HttpStatus.OK);
			LOG.debug("Listado de alumnos devuelto " + alumnos.size());
		} catch (Exception e) {
			LOG.error(e);
		}

		return response;
	}

	@ApiOperation(value = "Detalle alumno", notes = "Muestra el detalle de un alumno en concreto", produces = "application/json")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Alumno mostrado", responseContainer = "Alumno"),
			@ApiResponse(code = 404, message = "No existe el alumno") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "Id alumno", required = true, dataType = "long", paramType = "Path") })
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Alumno> detalle(@PathVariable long id) {

		ResponseEntity<Alumno> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		try {
			Alumno alumno = serviceAlumno.buscarPorId(id);
			if (alumno != null && alumno.getId() > 0) {
				response = new ResponseEntity<>(alumno, HttpStatus.OK);
				LOG.debug("Detalle de alumno devuelto correctamente");
			} else {
				response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
				LOG.debug("No se ha encontrado el alumno a mostrar");
			}
		} catch (Exception e) {
			LOG.error(e);
		}

		return response;
	}

	@ApiOperation(value = "Crear alumno", notes = "Crea un nuevo alumno", produces = "application/json", response = Alumno.class)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Alumno creado", responseContainer = "Editorial"),
			@ApiResponse(code = 409, message = "<ol><li>1) Nombre de alumno ya existe.</li><li> 2) No cumple las validaciones.</li></ol>") })
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> crear(@RequestBody Alumno alumno) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		try {

			Set<ConstraintViolation<Alumno>> violations = validator.validate(alumno);
			if (violations.isEmpty()) {
				/* Ha pasado la validacion */
				if (serviceAlumno.crear(alumno)) {
					response = new ResponseEntity<>(alumno, HttpStatus.CREATED);
					LOG.debug("Alumno creado correctamente");
				} else {
					response = new ResponseEntity<>(HttpStatus.CONFLICT);
					LOG.debug("No se ha podido crear el alumno");
				}
			} else {
				/* Hay fallos, la Validacion no es correcta */
				ResponseMensaje msj = new ResponseMensaje();
				msj.setMensaje("Los datos no son válidos.");
				for (ConstraintViolation<Alumno> violation : violations) {
					msj.addError(violation.getPropertyPath() + ": " + violation.getMessage());
					LOG.debug("Errores de validacion al crear alumno: " + violation.getPropertyPath() + ": "
							+ violation.getMessage());
				}
				response = new ResponseEntity<>(msj, HttpStatus.CONFLICT);
			}

		} catch (MySQLIntegrityConstraintViolationException e) {
			LOG.debug(e);
			ResponseMensaje msj = new ResponseMensaje("Ya existe el alumno, por favor prueba con otro nombre.");
			response = new ResponseEntity<>(msj, HttpStatus.CONFLICT);
		} catch (Exception e) {
			LOG.error(e);
			ResponseMensaje msj = new ResponseMensaje("No existe el alumno.");
			response = new ResponseEntity<>(msj, HttpStatus.NOT_FOUND);
		}

		return response;
	}

	@ApiOperation(value = "Modificar alumno", notes = "Modifica los valores de un alumno", produces = "application/json", response = Alumno.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Modificar un alumno correctamente"),
			@ApiResponse(code = 409, message = "Conflicto por validaciones de alumno o porque ya existe un alumno con el mismo nombre") })
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> modificar(@PathVariable long id, @RequestBody Alumno alumno) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		try {
			Set<ConstraintViolation<Alumno>> violations = validator.validate(alumno);

			alumno.setId(id);

			if (violations.isEmpty()) {
				/* Ha pasado la validacion */
				if (serviceAlumno.modificar(alumno)) {
					response = new ResponseEntity<>(alumno, HttpStatus.OK);
					LOG.debug("Alumno modificado correctamente");
				} else {
					response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
					LOG.debug("No se ha encontrado el alumno a modificar");
				}
			} else {
				/* Hay fallos, la Validacion no es correcta */
				ResponseMensaje msj = new ResponseMensaje();
				msj.setMensaje("Los datos no son válidos.");
				for (ConstraintViolation<Alumno> violation : violations) {
					msj.getErrores().add(violation.getPropertyPath() + ": " + violation.getMessage());
					LOG.debug("Errores de validacion al modificar alumno: " + violation.getPropertyPath() + ": "
							+ violation.getMessage());
				}
				response = new ResponseEntity<>(msj, HttpStatus.CONFLICT);
			}
		} catch (MySQLIntegrityConstraintViolationException e) {
			LOG.debug(e);
			ResponseMensaje msj = new ResponseMensaje("Ya existe el alumno, por favor prueba con otro nombre.");
			response = new ResponseEntity<>(msj, HttpStatus.CONFLICT);
		} catch (Exception e) {
			LOG.error(e);
			ResponseMensaje msj = new ResponseMensaje("No existe el alumno.");
			response = new ResponseEntity<>(msj, HttpStatus.NOT_FOUND);
		}

		return response;
	}

	@ApiOperation(value = "Eliminar libro", notes = "Elimina un libro existente", produces = "application/json")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Eliminar un libro correctamente"),
			@ApiResponse(code = 404, message = "No existe el alumno a borrar"),
			@ApiResponse(code = 409, message = "Conflicto por intentar eliminar un alumno que tiene préstamos asociados") })
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> eliminar(@PathVariable long id) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		try {
			if (serviceAlumno.eliminar(id)) {
				response = new ResponseEntity<>(HttpStatus.OK);
				LOG.debug("Alumno eliminado correctamente");
			} else {
				ResponseMensaje msj = new ResponseMensaje("No se puede borrar un registro que no existe");
				response = new ResponseEntity<>(msj, HttpStatus.NOT_FOUND);
				LOG.debug("No se ha encontrado el alumno a borrar");
			}
		} catch (MySQLIntegrityConstraintViolationException e) {
			LOG.debug(e);
			ResponseMensaje msj = new ResponseMensaje("No se puede borrar el alumno porque tiene libros asociados.");
			response = new ResponseEntity<>(msj, HttpStatus.CONFLICT);
		} catch (Exception e) {
			LOG.error(e);
		}

		return response;
	}

}
