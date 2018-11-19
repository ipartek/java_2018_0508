package com.ipartek.formacion.prestamos.api.controller;

import java.sql.Date;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.prestamolibros.pojo.Prestamo;
import com.ipartek.formacion.prestamolibros.service.ServicioAlumno;
import com.ipartek.formacion.prestamolibros.service.ServicioLibro;
import com.ipartek.formacion.prestamolibros.service.ServicioPrestamo;
import com.ipartek.formacion.prestamos.api.controller.pojo.ResponseMensaje;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "*")
@RestController
@Api(tags = "Préstamos", description = "Gestión de Préstamos", produces = "application/json")
public class PretamosController {
	ValidatorFactory factory = null;
	Validator validator = null;
	ServicioPrestamo servicioPrestamo = null;
	ServicioAlumno servicioAlumno = null;
	ServicioLibro serviciLibro = null;
	private final static Logger LOG = Logger.getLogger(PretamosController.class);

	public PretamosController() {
		super();
		LOG.trace("constructor");
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
		servicioPrestamo = ServicioPrestamo.getInstance();
		servicioAlumno = ServicioAlumno.getInstance();
		serviciLibro = ServicioLibro.getInstance();
		LOG.trace("Servicios instanciando");
	}

	@ApiOperation(value = "Listado Prestamos activos o historico")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Prestamos encontrados"),
			@ApiResponse(code = 500, message = "Ha ocurrido un error") })
	@ApiParam(value = "activo", required = false)
	@RequestMapping(value = "/prestamos", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Prestamo>> listar(
			@ApiParam(value = "<ol><li>true: Préstamos actuales</li><li>false:Préstamos devueltos</li><li>No obligatorio</li></ol>") @RequestParam(name = "activo", required = false, defaultValue = "true") boolean activo) {
		ResponseEntity<ArrayList<Prestamo>> response = new ResponseEntity<ArrayList<Prestamo>>(
				HttpStatus.INTERNAL_SERVER_ERROR);
		ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();

		try {
			if (activo) {
				prestamos = (ArrayList<Prestamo>) servicioPrestamo.prestados();
				response = new ResponseEntity<ArrayList<Prestamo>>(prestamos, HttpStatus.OK);
			} else {
				prestamos = (ArrayList<Prestamo>) servicioPrestamo.historico();
				response = new ResponseEntity<ArrayList<Prestamo>>(prestamos, HttpStatus.OK);
			}
			LOG.debug("prestamos recuperados " + prestamos.size());
		} catch (Exception e) {
			LOG.debug(e);
		}

		return response;
	}

	@ApiOperation(value = "Prestar un libro concreto a un alumno en una fecha concreta", notes = "CAMPOS OBLIGATORIOS: <ol><li><b>Id del libro</b></li><li><b>Id del libro</b></li><li><b>Fecha de inicio</b></li></ol>", response = Prestamo.class)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Préstamo creado", response = Prestamo.class),
			@ApiResponse(code = 400, message = "Faltan campos obligatorios", response = ResponseMensaje.class),
			@ApiResponse(code = 409, message = "<ol><li>Ya existe un préstamo con los datos introducidos</li><li>No existe el libro o alumno</li>", response = ResponseMensaje.class),
			@ApiResponse(code = 500, message = "Ha ocurrido un error") })
	@RequestMapping(value = "/prestamos", method = RequestMethod.POST)
	public ResponseEntity<Object> crear(@RequestBody Prestamo prestamo) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		ResponseMensaje msg = new ResponseMensaje();
		try {

			// Validacion con javax validator
			Set<ConstraintViolation<Prestamo>> violations = validator.validate(prestamo);
			if (violations.isEmpty()) {
				if (servicioPrestamo.prestar(prestamo.getLibro().getId(), prestamo.getAlumno().getId(),
						prestamo.getFechaInicio())) {
					ArrayList<Prestamo> prestamos = (ArrayList<Prestamo>) servicioPrestamo.prestados();
					for (Prestamo pr : prestamos) {
						if (pr.getAlumno().getId() == prestamo.getAlumno().getId()
								&& (pr.getLibro().getId() == (prestamo.getLibro().getId())
										&& (pr.getFechaInicio().compareTo(prestamo.getFechaInicio()) == -1))) {
							prestamo = pr;
						}
						response = new ResponseEntity<>(prestamo, HttpStatus.CREATED);
					}
				} else {
					response = new ResponseEntity<>(new ResponseMensaje("No se puede realizar el prestamo"),
							HttpStatus.CONFLICT);
				}
			} else {
				for (ConstraintViolation<Prestamo> constraint : violations) {
					msg.addError((constraint.getPropertyPath() + ": " + constraint.getMessage()));
				}
				response = new ResponseEntity<>(msg, HttpStatus.CONFLICT);

			}

		} catch (SQLIntegrityConstraintViolationException e) {

			response = new ResponseEntity<>(
					new ResponseMensaje("Ya existe un prestamo con el mismo usuario,libro y fecha de prestamo"),
					HttpStatus.CONFLICT);
			LOG.debug(response);
		} catch (Exception e) {
			response = new ResponseEntity<>(new ResponseMensaje("Compruebe que ha introducido los datos correctamente"),
					HttpStatus.CONFLICT);
			LOG.error(e);
		}

		return response;
	}

	@ApiOperation(value = "Modificar un préstamo",notes="<b>CAMPOS OBLITAGORIOS</b><ol><li><b>Id del libro</b></li><li><b>Id del libro</b></li><li><b>Fecha de inicio</b></li><li><b>Fecha de final</b></li><li><b>Fecha de Devuelto</b></li></ol>")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Préstamo modificado con éxito"),
			@ApiResponse(code = 304, message = "El préstamo no se modifico"),
			@ApiResponse(code = 404, message = "El préstamo no existe"),
			@ApiResponse(code = 409, message = "<ol><li>Los datos introducidos son incorrectos</li></ol>", response = Prestamo.class),
			@ApiResponse(code = 500, message = "Ha ocurrido un error"), })
	@RequestMapping(value = "/libros/{id_libro}/prestamos/{id_alumno}/{fecha_inicio}", method = RequestMethod.PUT)
	public ResponseEntity<Object> modificar(@PathVariable long id_libro, @PathVariable long id_alumno,
			@PathVariable Date fecha_inicio, @RequestBody Prestamo prestamo) {
		

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {

			if (prestamo.getDevuelto() == null) {
				if (servicioPrestamo.modificarPrestamo(prestamo.getLibro().getId(), prestamo.getAlumno().getId(),
						prestamo.getFechaInicio(), prestamo.getFechaFin(), id_libro, id_alumno, fecha_inicio)) {
					response = new ResponseEntity<>(prestamo, HttpStatus.OK);
				} else {
					response = new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
				}
			} else {
				if (servicioPrestamo.modificarHistorico(prestamo.getLibro().getId(), prestamo.getAlumno().getId(),
						prestamo.getFechaInicio(), prestamo.getFechaFin(), prestamo.getDevuelto(), id_libro, id_alumno,
						fecha_inicio)) {
					response = new ResponseEntity<>(prestamo, HttpStatus.OK);
				} else {
					response = new ResponseEntity<>(new ResponseMensaje("El préstamo no se ha modificado,compruebe que ha introducido los datos correctamente"),HttpStatus.NOT_MODIFIED);
				}
			}


		} catch (SQLIntegrityConstraintViolationException e) {

			response = new ResponseEntity<>(new ResponseMensaje(
					"Ya existe un prestamo al mismo alumno,libro y fecha de prestamo, por favor comprueba los datos"),
					HttpStatus.CONFLICT);
			LOG.debug(response);
		} catch (Exception e) {
			LOG.error(e);
		}
		return response;
	}

	@ApiOperation(value = "Devolver un préstamo", notes = "CAMPOS OBLIGATORIOS: <ol><li><b>Id del libro: </b>Identificador del libro.</li><li><b>Id del alumno: </b>Identificador del alumno.</li><li><b>Fecha de inicio</b></li><li>El formato correcto de fecha es: <b>yyyy-MM-dd</b></li></ol>", response = Prestamo.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Préstamo devuelto"),
			@ApiResponse(code = 404, message = "El préstamo que intenta devovler no existe"),
			@ApiResponse(code = 409, message = "<ol<li>Ya existe un prestamo al mismo alumno,libro y fecha de prestamo, por favor comprueba los datos</li></ol>"),
			@ApiResponse(code = 500, message = "Ha ocurrido un error") })
	@RequestMapping(value = "/libros/{id_libro}/prestamos/{id_alumno}/{fecha_inicio}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> devolver(@PathVariable long id_libro, @PathVariable long id_alumno,
			@PathVariable Date fecha_inicio, @RequestBody Prestamo prestamo) {
		ResponseMensaje msg = new ResponseMensaje();

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {
			servicioPrestamo.comprobarDatosDevolucion(id_libro, id_alumno, fecha_inicio, prestamo.getDevuelto());

			if (servicioPrestamo.devolver(id_alumno, id_libro, fecha_inicio, prestamo.getDevuelto())) {
				response = new ResponseEntity<>(prestamo, HttpStatus.OK);
			} else {
				msg.setMensaje(ServicioPrestamo.EXCEPTION_PARAMETROS_INCORRECTOS_DEVOLUCION);
				response = new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			LOG.error(e);
			String mensaje = e.getMessage();

			if (mensaje.equals(ServicioPrestamo.EXCEPTION_LIBRO_SIN_PRESTAMO)
					|| mensaje.equals(ServicioPrestamo.EXCEPTION_ALUMNO_SIN_PRESTAMO)) {
				msg = new ResponseMensaje(mensaje);
				response = new ResponseEntity<Object>(msg, HttpStatus.CONFLICT);
			} else {
				msg = new ResponseMensaje(mensaje);
				response = new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
			}
		}
		return response;
	}

}
