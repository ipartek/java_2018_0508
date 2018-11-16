package com.ipartek.formacion.prestamos.api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.prestamos_libros.pojo.Editorial;
import com.ipartek.formacion.prestamos_libros.pojo.Libro;
import com.ipartek.formacion.prestamos_libros.service.ServiceAlumno;
import com.ipartek.formacion.prestamos_libros.service.ServiceEditorial;
import com.ipartek.formacion.prestamos_libros.service.ServiceLibro;
import com.ipartek.formacion.prestamos_libros.service.ServicePrestamo;
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

@Api(tags = { "Libros" }, produces = "application/json", description = "Gestión Libros")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/libros")
public class LibrosController {

	ServiceLibro serviceLibro = null;
	ServiceEditorial serviceEditorial = null;
	ServicePrestamo servicePrestamo = null;
	ServiceAlumno serviceAlumno = null;
	ValidatorFactory factory = null;
	Validator validator = null;

	// Logger
	private final static Logger LOG = Logger.getLogger(LibrosController.class);

	public LibrosController() {
		super();

		LOG.trace("Constructor");
		serviceLibro = ServiceLibro.getInstance();
		LOG.trace("Servicio libro instanciado");
		serviceEditorial = ServiceEditorial.getInstance();
		LOG.trace("Servicio editorial instanciado");
		servicePrestamo = ServicePrestamo.getInstance();
		LOG.trace("Servicio prestamo instanciado");
		serviceAlumno = ServiceAlumno.getInstance();
		LOG.trace("Servicio alumno instanciado");

		// Crear Factoria y Validador
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	/**
	 * Metodo que devuelve al cliente una lista de los libros
	 * @return ResponseEntity<ArrayList<Libro>>
	 */
	@ApiOperation(value = "Listado de libros", notes = "Muestra el listado de todos los libros", produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Listado libros mostrado", responseContainer = "List") })
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Libro>> listado() {
		ResponseEntity<ArrayList<Libro>> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		ArrayList<Libro> libros = new ArrayList<Libro>();

		try {
			libros = (ArrayList<Libro>) serviceLibro.listar();
			response = new ResponseEntity<>(libros, HttpStatus.OK);
			LOG.debug("Lista de libros devuelta correctamente " + libros.size());
		} catch (Exception e) {
			LOG.error(e);
		}

		return response;
	}

	/**
	 * Devuelve el detalle de un libro concreto a partir de un identificador
	 * @param id long Identificador del libro
	 * @return ResponseEntity<Libro>
	 */
	@ApiOperation(value = "Detalle libro", notes = "Muestra el detalle de un libro en concreto", produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Detalle libro mostrado", responseContainer = "Libro"),
			@ApiResponse(code = 404, message = "Libro no existe") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "Id libro", required = true, dataType = "long", paramType = "Path") })
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Libro> detalle(@PathVariable long id) {

		ResponseEntity<Libro> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		try {
			Libro libro = serviceLibro.buscarPorId(id);
			if (libro != null && libro.getId() > 0) {
				response = new ResponseEntity<>(libro, HttpStatus.OK);
				LOG.debug("Detalle del libro devuelto correctamente");
			} else {
				response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
				LOG.debug("No se ha encontrado el libro a mostrar");
			}
		} catch (Exception e) {
			LOG.error(e);
		}

		return response;
	}

	/**
	 * Crea un nuevo libro a partir de los datos recibidos en el @RequestBody
	 * @param libro Libro
	 * @return ResponseEntity<Object> Libro si se ha creado correctamente, ResponseMensaje con los errores ocurridos
	 */
	@ApiOperation(value = "Crear libro", notes = "Crea un nuevo libro", produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Libro creado", responseContainer = "Editorial"),
			@ApiResponse(code = 409, message = "<ol><li>1) Editorial no asociada.</li><li> 2) No cumple las validaciones.</li></ol>") })
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> crear(@RequestBody Libro libro) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		try {

			Set<ConstraintViolation<Libro>> violations = validator.validate(libro);
			if (violations.isEmpty()) {
				/* Ha pasado la validacion */
				if (serviceLibro.crear(libro)) {
					Editorial editorial = serviceEditorial.buscarPorId(libro.getEditorial().getId());
					libro.getEditorial().setNombre(editorial.getNombre());
					response = new ResponseEntity<>(libro, HttpStatus.CREATED);
					LOG.debug("Libro creado correctamente");
				} else {
					response = new ResponseEntity<>(HttpStatus.CONFLICT);
					LOG.debug("Conflicto al crear un nuevo libro");
				}
			} else {
				/* Hay fallos, la Validacion no es correcta */
				ResponseMensaje msj = new ResponseMensaje();
				msj.setMensaje("Los datos no son válidos.");
				for (ConstraintViolation<Libro> violation : violations) {
					msj.addError(violation.getPropertyPath() + ": " + violation.getMessage());
					LOG.debug("Errores de validacion al crear un libro: " + violation.getPropertyPath() + ": "
							+ violation.getMessage());
				}
				response = new ResponseEntity<>(msj, HttpStatus.CONFLICT);
			}

		} catch (MySQLIntegrityConstraintViolationException e) {
			LOG.debug(e);
			ResponseMensaje msj = new ResponseMensaje("Debe seleccionar una editorial para el libro.");
			response = new ResponseEntity<>(msj, HttpStatus.CONFLICT);
		} catch (Exception e) {
			LOG.error(e);
		}

		return response;
	}

	/**
	 * Modifica un libro a partir de un identificador
	 * @param id long identificador del libro a modificar
	 * @param ResponseEntity<Object> Libro si se ha modificado correctamente, sino un ResponseMensaje con los errores ocurridos 
	 * @return
	 */
	@ApiOperation(value = "Modificar libro", notes = "Modifica los valores de un libro", produces = "application/json", response = Libro.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Libro modificado"),
			@ApiResponse(code = 409, message = "<ol><li>1) Editorial no asociada.</li><li> 2) No cumple las validaciones.</li></ol>") })
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> modificar(@PathVariable long id, @RequestBody Libro libro) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		try {
			Set<ConstraintViolation<Libro>> violations = validator.validate(libro);

			libro.setId(id);

			if (violations.isEmpty()) {
				/* Ha pasado la validacion */
				if (serviceLibro.modificar(libro)) {
					Editorial editorial = serviceEditorial.buscarPorId(libro.getEditorial().getId());
					libro.getEditorial().setNombre(editorial.getNombre());
					response = new ResponseEntity<>(libro, HttpStatus.OK);
					LOG.debug("Libro modificado correctamente");
				} else {
					response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
					LOG.debug("No se ha encontrado el libro a modificar");
				}
			} else {
				/* Hay fallos, la Validacion no es correcta */
				ResponseMensaje msj = new ResponseMensaje();
				msj.setMensaje("Los datos no son válidos.");
				for (ConstraintViolation<Libro> violation : violations) {
					msj.getErrores().add(violation.getPropertyPath() + ": " + violation.getMessage());
					LOG.debug("Error de validacion al modificar un libro: " + violation.getPropertyPath() + ": "
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
	 * 
	 * @param id long identificador del Libro a eliminar
	 * @return ResponseEntity<Object> Solo con HttpStatus si se ha borrado correctamente, ResponseMensaje con errores en caso de fallo
	 */
	@ApiOperation(value = "Eliminar libro", notes = "Elimina un libro existente", produces = "application/json")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Libro eliminado"),
			@ApiResponse(code = 404, message = "Libro no existe"),
			@ApiResponse(code = 409, message = "Libro con préstamos asociados") })
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> eliminar(@PathVariable long id) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		try {
			if (serviceLibro.eliminar(id)) {
				response = new ResponseEntity<>(HttpStatus.OK);
				LOG.debug("Libro eliminado correctamente");
			} else {
				ResponseMensaje msj = new ResponseMensaje("No se puede borrar un registro que no existe");
				response = new ResponseEntity<>(msj, HttpStatus.NOT_FOUND);
				LOG.debug("No se ha encontrado el libro a eliminar");
			}
		} catch (MySQLIntegrityConstraintViolationException e) {
			LOG.debug(e);
			ResponseMensaje msj = new ResponseMensaje("No se puede borrar el libro porque tiene préstamos asociados.");
			response = new ResponseEntity<>(msj, HttpStatus.CONFLICT);
		} catch (Exception e) {
			LOG.error(e);
		}

		return response;
	}

}
