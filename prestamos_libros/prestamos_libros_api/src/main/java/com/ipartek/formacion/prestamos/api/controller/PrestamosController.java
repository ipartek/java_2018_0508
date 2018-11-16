package com.ipartek.formacion.prestamos.api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.prestamos_libros.pojo.Alumno;
import com.ipartek.formacion.prestamos_libros.pojo.Editorial;
import com.ipartek.formacion.prestamos_libros.pojo.Libro;
import com.ipartek.formacion.prestamos_libros.pojo.Prestamo;
import com.ipartek.formacion.prestamos_libros.service.ServiceAlumno;
import com.ipartek.formacion.prestamos_libros.service.ServiceEditorial;
import com.ipartek.formacion.prestamos_libros.service.ServiceLibro;
import com.ipartek.formacion.prestamos_libros.service.ServicePrestamo;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

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

@Api(tags = { "Prestamos" }, produces = "application/json", description = "Gestión Préstamos")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/prestamos")
public class PrestamosController {

	ServicePrestamo servicePrestamo = null;
	ServiceAlumno serviceAlumno = null;
	ServiceLibro serviceLibro = null;
	ServiceEditorial serviceEditorial = null;

	ValidatorFactory factory = null;
	Validator validator = null;

	// Logger
	private final static Logger LOG = Logger.getLogger(PrestamosController.class);

	public static final int FINALIZADOS = 0;

	public PrestamosController() {
		super();
		LOG.trace("Constructor");
		servicePrestamo = ServicePrestamo.getInstance();
		serviceAlumno = ServiceAlumno.getInstance();
		serviceLibro = ServiceLibro.getInstance();
		serviceEditorial = ServiceEditorial.getInstance();
		LOG.trace("Servicio préstamo instanciado");

		// Crear Factoria y Validador
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	/**
	 * Retorna un listado u otro dependiendo del valor del parametro activo
	 * @param activos int 0 si se quiere el listado de los prestamos finalizados, 1 si se quiere el listado de los prestamos activos
	 * @return ResponseEntity<ArrayList<Prestamo>> con la lista solicitada de Prestamos
	 */
	@ApiOperation(value = "Listado de prestamos activos o historico")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Listado Prestamos") })
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Prestamo>> listado(
			@ApiParam(value = "No obligatorio, 1: Prestamos activos, 0: Prestamos finalizados") @RequestParam(value = "activos", required = false, defaultValue = "1") int activos) {
		ResponseEntity<ArrayList<Prestamo>> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();

		try {
			// Si es 0 es historico, si es 1 son activos
			if (activos == FINALIZADOS) {
				prestamos = (ArrayList<Prestamo>) servicePrestamo.listarHistorico();
				LOG.debug("Prestamos de histórico recuperados " + prestamos.size());
			} else {
				prestamos = (ArrayList<Prestamo>) servicePrestamo.listarPrestados();
				LOG.debug("Prestamos activos recuperados " + prestamos.size());
			}
			response = new ResponseEntity<>(prestamos, HttpStatus.OK);
		} catch (Exception e) {
			LOG.error(e);
		}

		return response;
	}

	/**
	 * Metodo que devuelve el detalle completo de un prestamo en concreto
	 * @param idLibro long identificador del libro
	 * @param idAlumno long identificador del alumno
	 * @param fechaInicio Date fecha de inicio del prestamo
	 * @return ResponseEntity<Prestamo> con todos sus datos
	 */
	@ApiOperation(value = "Detalle Préstamo", notes = "Muestra el detalle de un préstamo en concreto. <br> Campos obligatorios:" + 
					"<ol><li>1) Fecha de inicio</li><li>2) Id del Libro</li><li>3) Id del Alumno</li></ol>", produces = "application/json", response = Prestamo.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Detalle préstamo mostrado", response = Prestamo.class),
			@ApiResponse(code = 404, message = "Préstamo no existe") })
	@RequestMapping(value = "/{idLibro}/{idAlumno}/{fechaInicio}", method = RequestMethod.GET)
	public ResponseEntity<Prestamo> detalle(@PathVariable long idLibro, @PathVariable long idAlumno,
			@PathVariable Date fechaInicio) {

		ResponseEntity<Prestamo> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		try {
			Prestamo prestamo = servicePrestamo.buscarPorId(idLibro, idAlumno, fechaInicio);
			if (prestamo != null) {
				Libro l = serviceLibro.buscarPorId(idLibro);
				Editorial e = serviceEditorial.buscarPorId(l.getEditorial().getId());
				l.setEditorial(e);
				prestamo.setLibro(l);
				response = new ResponseEntity<>(prestamo, HttpStatus.OK);
				LOG.debug("Detalle prestamo recogido");
			} else {
				response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
				LOG.debug("No se ha encontrado el prestamo");
			}
		} catch (Exception e) {
			LOG.error(e);
		}

		return response;
	}

	/**
	 * Metodo para prestar un nuevo libro a un alumno que no tenga prestamos activos y libros que no esten aun prestados
	 * @param prestamo Objeto Prestamo recogido del @RequestBody con todos los datos necesarios para crear un nuevo Prestamo
	 * @return ResponseEntity<Object> Prestamo si se ha prestado correctamente el libro, ResponseMensaje con errores en caso de fallos
	 */
	@ApiOperation(value = "Prestar un libro", notes = "Prestar un libro a un alumno para una fecha concreta. <br> Campos obligatorios: "
			+ "<ol><li>1) Fecha de inicio</li><li>2) Id del Libro</li><li>3) Id del Alumno</li></ol>", produces = "application/json", response = Prestamo.class)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Préstamo creado", response = Prestamo.class),
			@ApiResponse(code = 400, message = "Faltan campos obligatorios", response = ResponseMensaje.class),
			@ApiResponse(code = 409, message = "<ol><li>1) Libro ya prestado.</li><li>2) Alumno con préstamo activo.</li><li> 3) No cumple las validaciones.</li></ol>", response = ResponseMensaje.class) })
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> prestar(@RequestBody Prestamo prestamo) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		try {

			Set<ConstraintViolation<Prestamo>> violations = validator.validate(prestamo);
			if (violations.isEmpty()) {
				/* Ha pasado la validacion */
				if (servicePrestamo.prestar(prestamo)) {
					Libro l = serviceLibro.buscarPorId(prestamo.getLibro().getId());

					Editorial e = serviceEditorial.buscarPorId(l.getEditorial().getId());
					l.setEditorial(e);

					prestamo.setLibro(l);

					Alumno a = serviceAlumno.buscarPorId(prestamo.getAlumno().getId());
					prestamo.setAlumno(a);

					response = new ResponseEntity<>(prestamo, HttpStatus.CREATED);
					LOG.debug("Nuevo prestamo creado correctamente");
				} else {
					ResponseMensaje msj = new ResponseMensaje(
							"No se puede realizar el préstamo porque el alumno o el libro seleccionado no están disponibles.");
					response = new ResponseEntity<>(msj, HttpStatus.CONFLICT);
					LOG.debug("No se ha podido crear el prestamo porque el alumno o el libro no estan disponibles");
				}
			} else {
				/* Hay fallos, la Validacion no es correcta */
				ResponseMensaje msj = new ResponseMensaje();
				msj.setMensaje("Los datos no son válidos.");
				for (ConstraintViolation<Prestamo> violation : violations) {
					msj.addError(violation.getPropertyPath() + ": " + violation.getMessage());
					LOG.debug("Error de validacion al crear: " + violation.getPropertyPath() + ": "
							+ violation.getMessage());
				}
				response = new ResponseEntity<>(msj, HttpStatus.CONFLICT);
			}

		} catch (MySQLIntegrityConstraintViolationException e) {
			LOG.debug(e);
			ResponseMensaje msj = new ResponseMensaje("No se puede realizar el préstamo.");
			response = new ResponseEntity<>(msj, HttpStatus.CONFLICT);
		} catch (Exception e) {
			LOG.error(e);
		}

		return response;
	}

	/**
	 * Metodo que modifica cualquier dato de un prestamo, tanto activo como finalizado
	 * @param idLibro long identificador del libro antes de modificar el prestamo
	 * @param idAlumno long identificador del alumno antes de modificar el prestamo
	 * @param fechaInicio Date fecha inicio del prestamo antes de haber modificado sus datos
	 * @param prestamo objeto Prestamo del @RequestBody con los valores modificados, pudiendo incluir el idLibro, idAlumno o fechaInicio modificados
	 * @return ResponseEntity<Object> Prestamo si se ha modificado correctamente, ResponseMensaje con errores en caso de fallo
	 */
	@ApiOperation(value = "Modificar préstamo", notes = "Modifica los datos de un préstamo. <br> Campos obligatorios:" + 
				"<ol><li>1) Fecha de inicio</li><li>2) Id del Libro</li><li>3) Id del Alumno</li></ol>", produces = "application/json", response = Libro.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Préstamo modificado"),
			@ApiResponse(code = 409, message = "<ol><li>1) Libro ya prestado.</li><li>2) Alumno con préstamo activo.</li><li> 3) No cumple las validaciones.</li></ol>") })
	@RequestMapping(value = "/{idLibro}/{idAlumno}/{fechaInicio}", method = RequestMethod.PUT)
	public ResponseEntity<Object> modificar(@PathVariable long idLibro, @PathVariable long idAlumno,
			@PathVariable Date fechaInicio, @RequestBody Prestamo prestamo) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		try {
			Set<ConstraintViolation<Prestamo>> violations = validator.validate(prestamo);

			if (violations.isEmpty()) {
				/* Ha pasado la validacion */
				if (servicePrestamo.update(idLibro, idAlumno, fechaInicio, prestamo.getLibro().getId(),
						prestamo.getAlumno().getId(), prestamo.getFecha_prestado(), prestamo.getFecha_fin(),
						prestamo.getFecha_retorno())) {

					Libro l = serviceLibro.buscarPorId(prestamo.getLibro().getId());

					Editorial e = serviceEditorial.buscarPorId(l.getEditorial().getId());
					l.setEditorial(e);

					prestamo.setLibro(l);

					Alumno a = serviceAlumno.buscarPorId(prestamo.getAlumno().getId());
					prestamo.setAlumno(a);

					response = new ResponseEntity<>(prestamo, HttpStatus.OK);
					LOG.debug("Prestamo modificado correctamente");
				} else {
					response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
					LOG.debug("No se ha encontrado el prestamo a modificar");
				}
			} else {
				/* Hay fallos, la Validacion no es correcta */
				ResponseMensaje msj = new ResponseMensaje();
				msj.setMensaje("Los datos no son válidos.");
				for (ConstraintViolation<Prestamo> violation : violations) {
					msj.getErrores().add(violation.getPropertyPath() + ": " + violation.getMessage());
					LOG.debug("Error de validacion al modificar: " + violation.getPropertyPath() + ": "
							+ violation.getMessage());
				}
				response = new ResponseEntity<>(msj, HttpStatus.CONFLICT);
			}
		} catch (MySQLIntegrityConstraintViolationException e) {
			LOG.debug(e);
			ResponseMensaje msj = new ResponseMensaje("Debes seleccionar una editorial para el libro.");
			response = new ResponseEntity<>(msj, HttpStatus.CONFLICT);
		} catch (Exception e) {
			LOG.error(e);
			ResponseMensaje msj = new ResponseMensaje("No existe el libro.");
			response = new ResponseEntity<>(msj, HttpStatus.NOT_FOUND);
		}

		return response;
	}

	/**
	 * Metodo que devuelve un libro y finaliza un prestamo activo
	 * @param idLibro long identificador del libro
	 * @param idAlumno long identificador del alumno
	 * @param fechaInicio Date fecha inicio del prestamo
	 * @param prestamo Objeto prestamo en el @RequestBody con la fecha de retorno a incluir en el registro
	 * @return ResponseEntity<Object> Prestamo si se ha devuelto correctamente, ResponseMensaje con errores si ha fallado
	 */
	@ApiOperation(value = "Devolver libro", notes = "Devuelve un libro y finaliza un préstamo. <br> Campos obligatorios:" + 
					"<ol><li>1) Fecha de inicio</li><li>2) Id del Libro</li><li>3) Id del Alumno</li></ol>", produces = "application/json")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Libro devuelto") })
	@RequestMapping(value = "/{idLibro}/{idAlumno}/{fechaInicio}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> devolver(@PathVariable long idLibro, @PathVariable long idAlumno,
			@PathVariable Date fechaInicio, @RequestBody Prestamo prestamo) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		try {
			prestamo.setAlumno(new Alumno(idAlumno, ""));
			prestamo.setLibro(new Libro(idLibro, "", "", 1, new Editorial()));
			prestamo.setFecha_prestado(fechaInicio);
			if (servicePrestamo.devolver(prestamo)) {
				Libro l = serviceLibro.buscarPorId(prestamo.getLibro().getId());

				Editorial e = serviceEditorial.buscarPorId(l.getEditorial().getId());
				l.setEditorial(e);

				prestamo.setLibro(l);

				Alumno a = serviceAlumno.buscarPorId(prestamo.getAlumno().getId());
				prestamo.setAlumno(a);
				response = new ResponseEntity<>(prestamo, HttpStatus.OK);
				LOG.debug("Libro devuelto correctamente");
			} else {
				ResponseMensaje msj = new ResponseMensaje("No se puede devolver el libro");
				response = new ResponseEntity<>(msj, HttpStatus.CONFLICT);
				LOG.debug("No se puede devolver el libro");
			}
		} catch (MySQLIntegrityConstraintViolationException e) {
			LOG.debug(e);
			ResponseMensaje msj = new ResponseMensaje("No se puede devolver el libro.");
			response = new ResponseEntity<>(msj, HttpStatus.CONFLICT);
		} catch (Exception e) {
			LOG.error(e);
		}

		return response;
	}

}
