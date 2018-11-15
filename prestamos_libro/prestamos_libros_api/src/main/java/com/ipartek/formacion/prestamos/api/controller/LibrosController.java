package com.ipartek.formacion.prestamos.api.controller;

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

import com.ipartek.formacion.pojo.Libro;
import com.ipartek.formacion.service.ServiceEditorial;
import com.ipartek.formacion.service.ServiceLibro;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Libros", produces = "aplication/json", description = "Gestion de libros")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/libros")
public class LibrosController {
	private final static Logger LOG = Logger.getLogger(LibrosController.class);

	ServiceLibro serviceLibro = null;
	ServiceEditorial serviceEditorial = null;
	ValidatorFactory factory = null;
	Validator validator = null;

	public LibrosController() {

		super();
		serviceLibro = ServiceLibro.getInstance();
		serviceEditorial = ServiceEditorial.getInstance();

		// Crear Factoria y Validador
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@ApiOperation(value = "Listado de libros")
	@ApiResponses(value = { @ApiResponse(code = 200, message = " Listado libros")})
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Libro>> listar() {

		ArrayList<Libro> libros = new ArrayList<Libro>();
		ResponseEntity<ArrayList<Libro>> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

		try {

			libros = (ArrayList<Libro>) serviceLibro.listar();
			response = new ResponseEntity<>(libros, HttpStatus.OK);

		} catch (Exception e) {
			LOG.error(e);
		}

		return response;
	}

	@ApiOperation(value = "Obtener libro por su identificador")
	@ApiResponses(value = { @ApiResponse(code = 200, message = " Libro encontrada"),
			@ApiResponse(code = 404, message = " No se encontró el libro deseada") })
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> detalle(@PathVariable long id) throws Exception {
		
		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
		Libro libro = new Libro();
		libro = serviceLibro.buscarPorId(id);

		if (libro != null && libro.getId() > 0) {
			response = new ResponseEntity<>(libro, HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(new ResponseMensaje("No se ha encotrado ningun registro, cambie de identificador"),	HttpStatus.NOT_FOUND);
			LOG.debug("No se ha encotrado ningun registro, cambie de identificador");
		}

		return response;
	}

	@ApiOperation(value = "Eliminar libro")
	@ApiResponses(value = { @ApiResponse(code = 200, message = " libro eliminado correctamente"),
			@ApiResponse(code = 404, message = " No se encontró el libro deseado"),
			@ApiResponse(code = 409, message = "No se puede borrar un libro con prestamo asociado") })
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> eliminar(@PathVariable long id) throws Exception {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

		try {

			if (serviceLibro.eliminar(id)) {
				response = new ResponseEntity<>(HttpStatus.OK);
			} else {
				response = new ResponseEntity<>(
						new ResponseMensaje("No se ha encotrado ningun registro, cambie de identificador"),
						HttpStatus.NOT_FOUND);
				LOG.debug("No se ha encotrado ningun registro, cambie de identificador");
			}

		} catch (MySQLIntegrityConstraintViolationException e) {

			response = new ResponseEntity<>(
					new ResponseMensaje(
							"No es posible eliminar el registro deseado porque tiene algun prestamo pendiente."),
					HttpStatus.CONFLICT);
			LOG.debug("No es posible eliminar el registro deseado porque tiene algun prestamo pendiente.");

		} catch (Exception e) {
			LOG.debug(e);
		}
		return response;
	}

	@ApiOperation(value = "Crear libro")
	@ApiResponses(value = { @ApiResponse(code = 201, message = " libro creado correctamente"),
			@ApiResponse(code = 409, message = "<ol><li>El nombre del libro está vacío</li><li>Nombre largo(max.150 caracteres)</li><li>Nombre corto(minimo 2 caracteres)</li><li>Falta la editorial</li></ol>") })
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> crear(@RequestBody Libro libro) throws Exception {
		
		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		ResponseMensaje responseMensaje = new ResponseMensaje();

		try {

			Set<ConstraintViolation<Libro>> violations = validator.validate(libro);
			
			if (violations.size() > 0) {
				/* No ha pasado la valiadacion, iterar sobre los mensajes de validacion */

				ArrayList<String> errores = new ArrayList<>();
				for (ConstraintViolation<Libro> violation : violations) {
					errores.add(violation.getPropertyPath() + ": " + violation.getMessage());

				}
				
				responseMensaje.setErrores(errores);
				responseMensaje.setMensaje("Datos no validos");

				response = new ResponseEntity<>(responseMensaje, HttpStatus.CONFLICT);
				LOG.debug("Datos no validos");
				
			} else {
				
				if (serviceLibro.crear(libro)) {
					libro.setEditorial(serviceEditorial.buscarPorId(libro.getEditorial().getId()));
					response = new ResponseEntity<>(libro, HttpStatus.CREATED);
				} else {
					response = new ResponseEntity<>(new ResponseMensaje("Nombre vacio o sin editorial"),HttpStatus.CONFLICT);
					LOG.debug("Nombre vacio o sin editorial");
				}
			}

		} catch (MySQLIntegrityConstraintViolationException e) {

			response = new ResponseEntity<>(new ResponseMensaje(""), HttpStatus.CONFLICT);
			LOG.debug(e);
			
		} catch (Exception e) {
			LOG.error(e);
		}
		
		return response;
	}

	@ApiOperation(value = "Modificar libro")
	@ApiResponses(value = { @ApiResponse(code = 200, message = " libro modificado correctamente"),
			@ApiResponse(code = 404, message = " No se encontró el libro deseado"),
			@ApiResponse(code = 409, message = "<ol><li>El nombre del libro está vacío</li><li>Nombre largo(max.150 caracteres)</li><li>Nombre corto(minimo 2 caracteres)</li><li>Falta la editorial</li></ol>") })
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> modificar(@PathVariable long id, @RequestBody Libro libro) throws Exception {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
		ResponseMensaje responseMensaje = new ResponseMensaje();

		try {
			
			libro.setId(id);
			Set<ConstraintViolation<Libro>> violations = validator.validate(libro);
			
			if (violations.size() > 0) {
				/* No ha pasado la valiadacion, iterar sobre los mensajes de validacion */

				ArrayList<String> errores = new ArrayList<>();
				
				for (ConstraintViolation<Libro> violation : violations) {
					errores.add(violation.getPropertyPath() + ": " + violation.getMessage());
				}
				
				responseMensaje.setErrores(errores);
				responseMensaje.setMensaje("Datos no validos");

				response = new ResponseEntity<>(responseMensaje, HttpStatus.CONFLICT);
				LOG.debug("Datos no validos");
				
			} else {
				
				if (serviceLibro.modificar(libro)) {

					libro.setEditorial(serviceEditorial.buscarPorId(libro.getEditorial().getId()));
					response = new ResponseEntity<>(libro, HttpStatus.OK);
					
				} else {
					
					response = new ResponseEntity<>(
							new ResponseMensaje("No se ha encotrado ningun registro, cambie de identificador"),
							HttpStatus.NOT_FOUND);
					LOG.debug("No se ha encotrado ningun registro, cambie de identificador");
					
				}
			}

		} catch (MySQLIntegrityConstraintViolationException e) {

			response = new ResponseEntity<>(new ResponseMensaje("editorial inexistente, inserte alguna existente"),
					HttpStatus.CONFLICT);
			LOG.debug(e);
			
		} catch (Exception e) {
			LOG.error(e);
		}
		return response;
	}
}
