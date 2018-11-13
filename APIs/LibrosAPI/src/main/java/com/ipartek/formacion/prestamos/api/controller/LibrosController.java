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

import com.ipartek.formacion.libros.service.ServiceLibro;
import com.ipartek.formacion.libros.pojo.Libro;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/libros")
public class LibrosController {

	private static final String NOT_FOUND_MSG = "NO ENCONTRADO: El recurso no existe en la base de datos.";
	private static final String INTERNAL_ERROR = "ERROR INTERNO: No controlado.";
	
	private static final ResponseEntity<Object> NOT_FOUND_RESPONSE = new ResponseEntity<Object>(
			new ResponseMessage(NOT_FOUND_MSG), HttpStatus.NOT_FOUND);
	
	private static final ResponseEntity<Object> INTERNAL_SERVER_ERROR_RESPONSE = new ResponseEntity<Object>(
			new ResponseMessage(INTERNAL_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);

	private static ServiceLibro servicio;
	private static Libro libro;

	private static ValidatorFactory factory;
	private static Validator validator;

	public LibrosController() {
		super();
		servicio = ServiceLibro.getInstance();

		// Crear Factoria y Validador
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();

	}

	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Libro>> listado() {

		ResponseEntity<ArrayList<Libro>> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

		try {

			response = new ResponseEntity<ArrayList<Libro>>((ArrayList<Libro>) servicio.listar(), HttpStatus.OK);

		} catch (Exception e) {

			response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}

		return response;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> detalle(@PathVariable long id) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

		try {

			libro = servicio.obtener(id);

			if (libro != null && libro.getId() > 0) {

				response = new ResponseEntity<Object>(libro, HttpStatus.OK);

			} else {

				response = NOT_FOUND_RESPONSE;
			}

		} catch (Exception e) {

			response = INTERNAL_SERVER_ERROR_RESPONSE;
			e.printStackTrace();
		}

		return response;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> crear(@RequestBody Libro libro) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

		try {

			Set<ConstraintViolation<Libro>> violations = validator.validate(libro);

			if (violations.size() == 0) {

				if (servicio.crear(libro)) {

					response = new ResponseEntity<Object>(libro, HttpStatus.CREATED);

				}

			} else {

				ArrayList<String> msgs = new ArrayList<String>();

				for (ConstraintViolation<Libro> v : violations) {

					msgs.add(v.getMessage());

				}

				ResponseMessage msg = new ResponseMessage("Alguno de los campos no tiene una longitud adecuada..", msgs);
				response = new ResponseEntity<Object>(msg, HttpStatus.BAD_REQUEST);
			}

		} catch (SQLIntegrityConstraintViolationException e) {

			response = new ResponseEntity<>(new ResponseMessage("La editorial para este libro no existe."), HttpStatus.NOT_IMPLEMENTED);
			e.printStackTrace();

		} catch (Exception e) {

			response = INTERNAL_SERVER_ERROR_RESPONSE;
			e.printStackTrace();
		}

		return response;

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> eliminar(@PathVariable long id) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

		try {

			if (id != 0 && servicio.eliminar(Long.toString(id))) {

				response = new ResponseEntity<Object>(HttpStatus.NO_CONTENT);

			} else {

				response = NOT_FOUND_RESPONSE;

			}

		} catch (SQLIntegrityConstraintViolationException e) {

			response = new ResponseEntity<>(new ResponseMessage("El libro tiene préstamos asociados, no se puede eliminar."), HttpStatus.NOT_IMPLEMENTED);;
			e.printStackTrace();

		} catch (Exception e) {

			response = INTERNAL_SERVER_ERROR_RESPONSE;
			e.printStackTrace();
		}

		return response;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> modificar(@PathVariable long id, @RequestBody Libro libro) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
		libro.setId(id);

		try {
			
			Set<ConstraintViolation<Libro>> violations = validator.validate(libro);

			if (violations.size() == 0) {

				if (servicio.modificar(libro)) {

					response = new ResponseEntity<Object>(libro, HttpStatus.OK);

				} else {

					response = NOT_FOUND_RESPONSE;

				}

			} else {

				ArrayList<String> msgs = new ArrayList<String>();

				for (ConstraintViolation<Libro> v : violations) {

					msgs.add(v.getMessage());

				}

				ResponseMessage msg = new ResponseMessage("Alguno de los campos no tiene una longitud adecuada..", msgs);
				response = new ResponseEntity<Object>(msg, HttpStatus.BAD_REQUEST);
			}

		} catch (SQLIntegrityConstraintViolationException e) {

			response = new ResponseEntity<>(new ResponseMessage("La editorial para este libro no existe."), HttpStatus.NOT_IMPLEMENTED);
			e.printStackTrace();

		} catch (Exception e) {

			response = INTERNAL_SERVER_ERROR_RESPONSE;
			e.printStackTrace();
		}

		return response;

	}

}
