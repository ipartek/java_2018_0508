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
import com.ipartek.formacion.pojo.Editorial;
import com.ipartek.formacion.pojo.Libro;
import com.ipartek.formacion.pojo.Prestamo;
import com.ipartek.formacion.service.ServiceAlumno;
import com.ipartek.formacion.service.ServiceEditorial;
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
	
/**
 * Metodo que lista los prestamos activos "activos = 1" o lista el historico(prestamos ya devueltos) "activos=0".
 * @param activos Int 1 o 0
 * @return ArrayList de prestamos
 */
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

	/**
	 * Metodo que devuelve el detalle 
	 * @param idLibro
	 * @param idALumno
	 * @param fecha_prestado
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "Crear prestamo", response = Prestamo.class, notes = "Campos obligatorios:<ol><li><b>identificador del libro</b></li><li><b>identificador del alumno</b></li><li><b>fecha que se realiza el prestamo</b></li></ol>")
	@RequestMapping(value = "/{idLibro}/{idALumno}/{fecha_prestado}", method = RequestMethod.GET)
	public ResponseEntity<Object> detalle(@PathVariable long idLibro, @PathVariable long idALumno,
			@PathVariable Date fecha_prestado) throws Exception {

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

	@ApiOperation(value = "Devolver prestamo", response = Prestamo.class, notes = "Campos obligatorios:<ol><li><b>identificador del libro</b></li><li><b>identificador del alumno</b></li><li><b>fecha que se realiza el prestamo</b></li><li><b>Fecha retorno</b></li></ol>")
	@RequestMapping(value = "/{idLibro}/{idALumno}/{fecha_prestado}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> devolver(@PathVariable long idLibro, @PathVariable long idALumno,
			@PathVariable Date fecha_prestado, @RequestBody Prestamo prestamo) throws Exception {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

		try {
		
			prestamo.setAlumno(new Alumno(idALumno, ""));
			prestamo.setLibro(new Libro(idLibro, null, null, 0, null));
			prestamo.setFecha_prestado(fecha_prestado);
			Prestamo pDevuelto = servicePrestamo.buscarPorId(prestamo);

			// Comprobar que el prestamo no esté finalizado
			if (pDevuelto.getFecha_retorno() == null) {

				if (servicePrestamo.devolver(prestamo)) {

					Alumno a = new Alumno();
					a = ServiceAlumno.getInstance().buscarPorId(prestamo.getAlumno().getId());
					prestamo.setAlumno(a);

					Libro l = new Libro();
					l = ServiceLibro.getInstance().buscarPorId(prestamo.getLibro().getId());

					Editorial e = new Editorial();
					e = ServiceEditorial.getInstance().buscarPorId(l.getEditorial().getId());
					l.setEditorial(e);

					prestamo.setLibro(l);
					prestamo.setFecha_prestado(prestamo.getFecha_prestado());

					response = new ResponseEntity<>(prestamo, HttpStatus.OK);
				} else {
					response = new ResponseEntity<>(
							new ResponseMensaje("No se ha encontrado ningun registro, cambie de identificador"),
							HttpStatus.NOT_FOUND);
					LOG.debug("No se ha encotrado ningun registro, cambie de identificador");
				}
			} else {
				response = new ResponseEntity<>(new ResponseMensaje("El prestamo que se desea finalizar , ya lo está"),
						HttpStatus.NOT_FOUND);
				LOG.debug("El prestamo que se desea finalizar , ya lo está");
			}

		} catch (MySQLIntegrityConstraintViolationException e) {

			response = new ResponseEntity<>(new ResponseMensaje("Datos no validos"), HttpStatus.CONFLICT);
			LOG.debug("Datos no validos");

		} catch (Exception e) {
			LOG.error(e);
		}
		return response;
	}

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

				Editorial e = new Editorial();
				e = ServiceEditorial.getInstance().buscarPorId(l.getEditorial().getId());
				l.setEditorial(e);

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

	@ApiOperation(value = "Modificar prestamo", response = Prestamo.class, notes = "Campos obligatorios:<ol><li><b>identificador del libro</b></li><li><b>identificador del alumno</b></li><li><b>fecha que se realiza el prestamo</b></li></ol>")
	@ApiResponses(value = { @ApiResponse(code = 200, message = " Prestamo modificado", response = Prestamo.class),
			@ApiResponse(code = 400, message = " Faltan campos obligatorios", response = ResponseMensaje.class),
			@ApiResponse(code = 409, message = " <ol><li>No existe el libro o el alumno o la fecha no es correcta</li>", response = ResponseMensaje.class) })
	@RequestMapping(value = "/{idLibro}/{idAlumno}/{fechaPrestado}", method = RequestMethod.PUT)
	public ResponseEntity<Object> modificar(@PathVariable long idLibro, @PathVariable long idAlumno,
			@PathVariable Date fechaPrestado, @RequestBody Prestamo prestamo) throws Exception {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
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
				LOG.debug("Datos no validos");

			} else {

				if (servicePrestamo.modificar(idLibro, idAlumno, fechaPrestado, prestamo.getLibro().getId(),
						prestamo.getAlumno().getId(), prestamo.getFecha_prestado(), prestamo.getFecha_fin(),
						prestamo.getFecha_retorno())) {
					
					Alumno a = new Alumno();
					a = ServiceAlumno.getInstance().buscarPorId(prestamo.getAlumno().getId());
					prestamo.setAlumno(a);

					Libro l = new Libro();
					l = ServiceLibro.getInstance().buscarPorId(prestamo.getLibro().getId());

					Editorial e = new Editorial();
					e = ServiceEditorial.getInstance().buscarPorId(l.getEditorial().getId());
					l.setEditorial(e);

					prestamo.setLibro(l);
					
					response = new ResponseEntity<>(prestamo, HttpStatus.OK);
				} else {
					response = new ResponseEntity<>(
							new ResponseMensaje("No se ha encotrado ningun registro, cambie de identificador"),
							HttpStatus.NOT_FOUND);
					LOG.debug("No se ha encontrado ningun registro, cambie de identificador");
				}
			}

		} catch (MySQLIntegrityConstraintViolationException e) {

			response = new ResponseEntity<>(new ResponseMensaje("datos no validos"), HttpStatus.CONFLICT);
			LOG.debug("datos no validos");

		} catch (Exception e) {
			LOG.error(e);
			response = new ResponseEntity<>(new ResponseMensaje(e.getMessage()), HttpStatus.CONFLICT);
		}
		return response;
	}

}
