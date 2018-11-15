package com.ipartek.formacion.prestamos.api.controller;

import java.sql.Date;
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

import com.ipartek.formacion.pojo.Alumno;
import com.ipartek.formacion.pojo.Libro;
import com.ipartek.formacion.pojo.Prestamo;
import com.ipartek.formacion.service.ServiceAlumno;
import com.ipartek.formacion.service.ServiceLibro;
import com.ipartek.formacion.service.ServicePrestamo;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Prestamos", produces = "aplication/json", description = "Gestion de prestamos")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/prestamos")
public class PrestamosController {

	private static final int ACTIVOS = 1;
	private static final int HISTORICOS = 0;
	private final static Logger LOG = Logger.getLogger(PrestamosController.class);

	ServicePrestamo servicePrestamo = null;
	ValidatorFactory factory = null;
	Validator validator = null;

	public PrestamosController() {
		super();
		LOG.trace("constructor");
		servicePrestamo = ServicePrestamo.getInstance();
		// Crear Factoria y Validador
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();

		LOG.trace("servicio instanciado");
	}

	@ApiOperation(value = "Listado de prestamos activos o historicos")
	@ApiResponses(value = { @ApiResponse(code = 200, message = " Listado Prestamos") })

	@ApiParam(value = "activos", required = false, name = "bla bla bla", defaultValue = "1")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Prestamo>> listar(
			@ApiParam(value = "No obligatorio.<ol><li><strong> 1</strong>: prestamos sin retornar</li><li> <strong>0</strong>: prestamos retornados</li></ol>") @RequestParam(value = "activos", required = false, defaultValue = "1") int activos) {

		ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
		ResponseEntity<ArrayList<Prestamo>> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

		try {

			if (activos == ACTIVOS || activos != ACTIVOS && activos != HISTORICOS) {
				prestamos = (ArrayList<Prestamo>) servicePrestamo.listarPrestados();

			} else if (activos == HISTORICOS) {
				prestamos = (ArrayList<Prestamo>) servicePrestamo.listarHistorico();

			}
			LOG.debug("prestamos recuperados:" + prestamos.size());
			response = new ResponseEntity<>(prestamos, HttpStatus.OK);

		} catch (Exception e) {
			LOG.error(e);
		}

		return response;
	}

	@ApiOperation(value = "Crear prestamo", response = Prestamo.class, notes = "Campos obligatorios:<ol><li><b>identificador del libro</b></li><li><b>identificador del alumno</b></li><li><b>fecha que se realiza el prestamo</b></li></ol>")

	@RequestMapping(value = "/{idLibro}/{idALumno}/{fecha_prestado}", method = RequestMethod.GET)
	public ResponseEntity<Object> detalle(@PathVariable long idLibro,@PathVariable long idALumno, @PathVariable Date fecha_prestado)
			throws Exception {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

		Libro l = new Libro();
		l.setId(idLibro);

		Alumno a = new Alumno();
		a.setId(idALumno);

		Prestamo prestamo = new Prestamo();

		prestamo.setFecha_prestado(fecha_prestado);
		prestamo.setAlumno(a);
		prestamo.setLibro(l);
		prestamo = servicePrestamo.buscarPorId(prestamo);

		try {
			if (prestamo != null) {

				response = new ResponseEntity<>(prestamo, HttpStatus.OK);

			} else {

				response = new ResponseEntity<>(
						new ResponseMensaje("No se ha encotrado ningun registro, cambie de identificador"),
						HttpStatus.NOT_FOUND);
				LOG.debug("No se ha encotrado ningun registro, cambie de identificador");
			}

		} catch (Exception e) {
			LOG.error(e);
		}

		return response;
	}
//
//	@ApiOperation(value = "Devolver prestamo", response = Prestamo.class, notes = "Campos obligatorios:<ol><li><b>identificador del libro</b></li><li><b>identificador del alumno</b></li><li><b>fecha que se realiza el prestamo</b></li><li><b>fecha en la que se realiza la devolución</b></li></ol>")
//	@RequestMapping(value = "/{idLibro}/{idALumno}/{fecha_prestado}/{fecha_devolucion}", method = RequestMethod.DELETE)
//	public ResponseEntity<Object> devolver(@PathVariable long idLibro,@PathVariable long idALumno, @PathVariable Date fecha_prestado) throws Exception {
//
//		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
//
//		try {
//
//			if (serviceAlumno.eliminar(id)) {
//				response = new ResponseEntity<>(HttpStatus.OK);
//			} else {
//				response = new ResponseEntity<>(
//						new ResponseMensaje("No se ha encotrado ningun registro, cambie de identificador"),
//						HttpStatus.NOT_FOUND);
//			}
//
//		} catch (MySQLIntegrityConstraintViolationException e) {
//
//			response = new ResponseEntity<>(
//					new ResponseMensaje(
//							"No es posible eliminar el registro deseado porque tiene algun prestamo pendiente."),
//					HttpStatus.CONFLICT);
//
//		} catch (Exception e) {
//			LOG.error(e);
//		}
//		return response;
//	}



	@ApiOperation(value = "Crear prestamo", response = Prestamo.class, notes = "Campos obligatorios:<ol><li><b>identificador del libro</b></li><li><b>identificador del alumno</b></li><li><b>fecha que se realiza el prestamo</b></li></ol>")
	@ApiResponses(value = { @ApiResponse(code = 201, message = " Prestamo creado", response = Prestamo.class),
			@ApiResponse(code = 400, message = " Faltan campos obligatorios", response = ResponseMensaje.class),
			@ApiResponse(code = 409, message = " <ol>" + "<li>No existe el libro o el alumno</li>"
					+ "<li>El libro o el alumno ya tienen un prestamo activo</li>"
					+ "</ol>", response = ResponseMensaje.class) })
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> prestar(@RequestBody Prestamo prestamo) throws Exception {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		ResponseMensaje responseMensaje = new ResponseMensaje();

		try {

			Set<ConstraintViolation<Prestamo>> violations = validator.validate(prestamo);
			if (violations.size() > 0) {
				/* No ha pasado la valiadacion, iterar sobre los mensajes de validacion */

				ArrayList<String> errores = new ArrayList<>();
				for (ConstraintViolation<Prestamo> violation : violations) {
					errores.add(violation.getPropertyPath() + ": " + violation.getMessage());

				}
				responseMensaje.setErrores(errores);
				responseMensaje.setMensaje("Datos no validos");

				response = new ResponseEntity<>(responseMensaje, HttpStatus.CONFLICT);
				LOG.debug(response);
			} else {

				Alumno a = new Alumno();
				a = ServiceAlumno.getInstance().buscarPorId(prestamo.getAlumno().getId());
				prestamo.setAlumno(a);

				Libro l = new Libro();
				l = ServiceLibro.getInstance().buscarPorId(prestamo.getLibro().getId());
				prestamo.setLibro(l);
				prestamo.setFecha_prestado(prestamo.getFecha_prestado());

				if (servicePrestamo.prestar(prestamo)) {
					response = new ResponseEntity<>(prestamo, HttpStatus.CREATED);
				} else {

					response = new ResponseEntity<>(new ResponseMensaje("Datos no validos"), HttpStatus.CONFLICT);
					LOG.debug(response);
				}
			}

		} catch (MySQLIntegrityConstraintViolationException e) {

			response = new ResponseEntity<>(new ResponseMensaje("Datos no validos"), HttpStatus.CONFLICT);
			LOG.debug(response);

		} catch (Exception e) {

			LOG.error(e);
		}
		return response;
	}

	// put endPoint/libros/{id_libro}/prestamos/{id_alumno}/{fecha_inicio}

//	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
//	public ResponseEntity<Object> modificar(@PathVariable long id, @RequestBody Alumno alumno) throws Exception {
//
//		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
//		ResponseMensaje responseMensaje = new ResponseMensaje();
//
//		try {
//			alumno.setId(id);
//			Set<ConstraintViolation<Alumno>> violations = validator.validate(alumno);
//			if (violations.size() > 0) {
//				/* No ha pasado la valiadacion, iterar sobre los mensajes de validacion */
//
//				ArrayList<String> errores = new ArrayList<>();
//				for (ConstraintViolation<Alumno> violation : violations) {
//					errores.add(violation.getPropertyPath() + ": " + violation.getMessage());
//
//				}
//				responseMensaje.setErrores(errores);
//				responseMensaje.setMensaje("Datos no validos");
//
//				response = new ResponseEntity<>(responseMensaje, HttpStatus.CONFLICT);
//			} else {
//				if (serviceAlumno.modificar(alumno)) {
//					response = new ResponseEntity<>(alumno, HttpStatus.OK);
//				} else {
//					response = new ResponseEntity<>(
//							new ResponseMensaje("No se ha encotrado ningun registro, cambie de identificador"),
//							HttpStatus.NOT_FOUND);
//				}
//			}
//
//		} catch (MySQLIntegrityConstraintViolationException e) {
//
//			response = new ResponseEntity<>(
//					new ResponseMensaje("Ya existe el alumno,Por favor prueba con otro nombre."),
//					HttpStatus.CONFLICT);
//
//		} catch (Exception e) {
//			LOG.error(e);
//		}
//		return response;
//	}

}
