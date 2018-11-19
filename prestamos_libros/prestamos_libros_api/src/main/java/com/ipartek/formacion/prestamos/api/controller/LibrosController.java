package com.ipartek.formacion.prestamos.api.controller;

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

import com.ipartek.formacion.libros.pojo.Editorial;
import com.ipartek.formacion.libros.pojo.Libro;
import com.ipartek.formacion.libros.service.ServiceEditorial;
import com.ipartek.formacion.libros.service.ServiceLibro;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = { "LibrosController" }, description = "Libros", consumes = "application/json")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/libros")
public class LibrosController {

	ServiceLibro serviceLibro = null;
	ServiceEditorial serviceEditoriales = null;
	ValidatorFactory factory = null;
	Validator validator = null;

	private final static Logger LOG = Logger.getLogger(Libro.class);

	public LibrosController() {
		super();
		serviceLibro = ServiceLibro.getInstance();
		serviceEditoriales = ServiceEditorial.getInstance();
		// Crear Factoria y Validador
		factory = Validation.buildDefaultValidatorFactory();
		validator = (Validator) factory.getValidator();

	}

	@ApiOperation(value = "Listado de libros", notes = "Obtener todos los libros en json", nickname = "listado", responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Listado de libros ok"),
			@ApiResponse(code = 400, message = "Error "), @ApiResponse(code = 401, message = "No autorizado "),
			@ApiResponse(code = 404, message = "No encontrado ") })
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Libro>> listado() {

		ArrayList<Libro> list = new ArrayList<Libro>();
		ResponseEntity<ArrayList<Libro>> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		try {

			list = (ArrayList<Libro>) serviceLibro.listar();
			response = new ResponseEntity<>(list, HttpStatus.OK);

		} catch (Exception e) {

			LOG.error(e.getMessage());
		}

		return response;
	}

	@ApiOperation(value = "Detalle por id del libro", notes = "Obtener los prestamos relacionados por libro")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Detalle del alumno correcto"),
			@ApiResponse(code = 400, message = "El requerimiento enviado por el cliente era sintácticamente incorrecto "),
			@ApiResponse(code = 401, message = "No autorizado "),
			@ApiResponse(code = 404, message = "Libro no encontrada ") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "Id del libro", required = true, dataType = "long", paramType = "Path") })
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> detalle(@PathVariable long id) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		ResponseMensaje rm = new ResponseMensaje();

		try {

			Libro libro = serviceLibro.obtener(id);

			if (libro != null && libro.getId() > 0) {

				response = new ResponseEntity<>(libro, HttpStatus.OK);

			} else {
				rm.setMensaje("Libro no encontrado");
				response = new ResponseEntity<>(rm, HttpStatus.NOT_FOUND);

			}

		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
		return response;
	}

	@ApiOperation(value = "Eliminar Libro", notes = "Eliminar libro por id. Si el libro esta asociada con algun prestamo o editorial no podra ser eliminado")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "alumno eliminada"),
			@ApiResponse(code = 400, message = "El requerimiento enviado por el cliente era sintácticamente incorrecto, se espera un campo numerico"),
			@ApiResponse(code = 404, message = "Error intentando borrar un libro que no encontramos"),
			@ApiResponse(code = 409, message = "No puedes borrar un libro con prestamos o relacion ") })
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> eliminar(@PathVariable long id) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		ResponseMensaje rm = new ResponseMensaje();

		try {

			if (serviceLibro.eliminar(String.valueOf(id))) {

				response = new ResponseEntity<>(HttpStatus.OK);

			} else {

				rm.setMensaje("Libro no encontrado en la base de datos");

				response = new ResponseEntity<>(rm, HttpStatus.NOT_FOUND);
			}

		} catch (SQLIntegrityConstraintViolationException e) {
			LOG.debug(e.getMessage());
			rm.setMensaje("Intenta eliminar un libro con relacion a otros registros");
			response = new ResponseEntity<>(rm, HttpStatus.CONFLICT);
		} catch (Exception e) {
			LOG.error(e.getMessage());

		}
		return response;
	}

	@ApiImplicitParams({ @ApiImplicitParam(name = "libro", value = "formato esperado:<br>"
			+ " {<br>\"titulo\" : \"libroN\",<br>" + "<br>\"isbn\" : \"libroNNNNNNNNNN\",<br>"
			+ "<br>\"editorial\" : {<br>" + "<br>\"id\" : 1,<br>" + "<br>\"nombre\" : \"\"}}") })
	@ApiOperation(value = "Crear editoriales", notes = "Para la creacion de un alumno se espera un objeto json con un unico campo llamado nombre.<br>"
			+ "<h2>Requisitos para la creacion de un alumno</h2>" + "<ul>"
			+ "<li>Debe ser mayor de 2 y menor de 50 caracteres</li>" + "<li>No puede estar vacio</li>"
			+ "<li>No se permiten alumnos duplicadas</li>" + "</ul>")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Libro Creado", responseContainer = "nose"),
			@ApiResponse(code = 400, message = "No encontrado"),
			@ApiResponse(code = 409, message = "Conflictos :<br> Alumno existente.<br>Nombre del alumno menor de 2 caracteres<br>Nombre alumno mayor 50") })
	@ApiParam(required = false, name = "Blabla ?", defaultValue = "1")
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Object> crear(@RequestBody Libro libro) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		ResponseMensaje rm = new ResponseMensaje();

		try {
			Editorial e = serviceEditoriales.obtener(libro.getEditorial().getId());
			libro.setEditorial(e);
			Set<ConstraintViolation<Libro>> violations = validator.validate(libro);
			String[] errores = new String[violations.size()];

			if (violations.size() > 0) {

				int contador = 0;

				// No tenemos ningun fallo, la Validacion es correcta
				for (ConstraintViolation<Libro> violation : violations) {

					System.out.println(violation.getMessage());
					System.out.println(violation.getPropertyPath());
					errores[contador] = violation.getPropertyPath() + ":" + violation.getMessage();
					contador++;
				}

				rm.setErrores(errores);
				rm.setMensaje("error de validación");
				response = new ResponseEntity<>(rm, HttpStatus.CONFLICT);

			} else {

				if (serviceLibro.crearVarios(libro, 1)) {

					response = new ResponseEntity<>(libro, HttpStatus.CREATED);

				} else {
					rm.setMensaje("Error");
					response = new ResponseEntity<>(rm, HttpStatus.CONFLICT);
				}
			}
		} catch (SQLIntegrityConstraintViolationException e) {

			LOG.debug(e.getMessage());
			rm.setMensaje("Esta intentando crear un registro con datos no existentes");
			response = new ResponseEntity<>(rm, HttpStatus.CONFLICT);
		} catch (SQLException e) {
			LOG.debug(e.getMessage());
			if (e.getMessage().contains("nombre")) {
				rm.setMensaje("El <b>nombre</b> debe ser inferior a 50 caracteres");
				response = new ResponseEntity<>(rm, HttpStatus.CONFLICT);
			} else {
				rm.setMensaje("La <b>contraseña</b> debe ser inferior a 20 caracteres");
				response = new ResponseEntity<>(rm, HttpStatus.CONFLICT);
			}
		} catch (Exception e) {

			rm.setMensaje("Hemos tenido un problema");
			response = new ResponseEntity<>(rm, HttpStatus.CONFLICT);
			LOG.error(e.getMessage());
		}

		return response;
	}

	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "El id del libro que se va a modificar, en la practica es un @pathvariable", dataType = "long", paramType = "path"),
			@ApiImplicitParam(name = "libro", value = "formato esperado:<br>" + " {<br>\"titulo\" : \"libroN\",<br>"
					+ "<br>\"isbn\" : \"libroNNNNNNNNNN\",<br>" + "<br>\"editorial\" : {<br>" + "<br>\"id\" : 1,<br>"
					+ "<br>\"nombre\" : \"\"}}") })
	@ApiOperation(value = "Crear editoriales", notes = "Para la creacion de un alumno se espera un objeto json con un unico campo llamado nombre.<br>"
			+ "<h2>Requisitos para la creacion de un alumno</h2>" + "<ul>"
			+ "<li>Debe ser mayor de 2 y menor de 50 caracteres</li>" + "<li>No puede estar vacio</li>"
			+ "<li>No se permiten alumnos duplicadas</li>" + "</ul>")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Libro creado", responseContainer = "nose"),
			@ApiResponse(code = 400, message = "No encontrado"), @ApiResponse(code = 404, message = "No encontrado"),
			@ApiResponse(code = 409, message = "Conflictos :<br> Libro existente.<br>Nombre del libro menor de 2 caracteres<br>Nombre libro mayor 50") })
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> modificar(@PathVariable long id, @RequestBody Libro libro) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		ResponseMensaje rm = new ResponseMensaje();

		try {

			Set<ConstraintViolation<Libro>> violations = validator.validate(libro);
			String[] errores = new String[violations.size()];

			if (violations.size() > 0) {

				int contador = 0;
				// No ha pasado la valiadacion, iterar sobre los mensajes de validacion
				for (ConstraintViolation<Libro> violation : violations) {

					errores[contador] = violation.getPropertyPath() + " :" + violation.getMessage();
					contador++;

				}
				errores = new String[1];
				errores[0] = "No se han encontrado libros por ese id";
				rm.setMensaje("Error de validacion");
				rm.setErrores(errores);

				response = new ResponseEntity<>(rm, HttpStatus.CONFLICT);

			} else {

				libro.setId(id);

				if (serviceLibro.modificar(libro)) {

					response = new ResponseEntity<>(libro, HttpStatus.OK);

				} else {
					errores = new String[1];
					errores[0] = "No se han encontrado libros por ese id";
					rm.setMensaje("Error de integridad");
					rm.setErrores(errores);

					response = new ResponseEntity<>(rm, HttpStatus.NOT_FOUND);
				}
			}

		} catch (SQLIntegrityConstraintViolationException e) {
			LOG.debug(e.getMessage());
			if (e.getMessage().contains("Cannot add or update a child row")) {
				String[] errores = new String[1];
				rm.setMensaje("Error");
				errores[0] = "No puede modificar un elemento no existente o con un elemento no existente";
				rm.setErrores(errores);
			}

			response = new ResponseEntity<>(rm, HttpStatus.CONFLICT);
		} catch (SQLException e) {
			LOG.debug(e.getMessage());
			if (e.getMessage().contains("No output parameters returned by procedure")) {
				// System.out.println(e.getCause().toString());
				String[] errores = new String[1];
				errores[0] = "No se han encontrado libros coincidentes";
				rm.setMensaje("Error de integridad");
				rm.setErrores(errores);
				response = new ResponseEntity<>(rm, HttpStatus.CONFLICT);
			}
		} catch (Exception e) {
			if (e.getMessage().contains("null")) {
				String[] errores = new String[1];
				errores[0] = "No se han encontrado libros coincidentes";
				rm.setMensaje("No se han encontrado libros coincidentes");
				rm.setErrores(errores);
				response = new ResponseEntity<>(rm, HttpStatus.CONFLICT);

			}

		}

		return response;
	}

}
