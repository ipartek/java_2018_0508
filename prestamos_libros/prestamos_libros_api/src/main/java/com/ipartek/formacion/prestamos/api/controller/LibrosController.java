package com.ipartek.formacion.prestamos.api.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.prestamolibros.pojo.Editorial;
import com.ipartek.formacion.prestamolibros.pojo.Libro;
import com.ipartek.formacion.prestamolibros.service.ServicioEditorial;
import com.ipartek.formacion.prestamolibros.service.ServicioLibro;
import com.ipartek.formacion.prestamos.api.controller.pojo.ResponseMensaje;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/libros")
public class LibrosController {
	ValidatorFactory factory = null;
	Validator validator = null;
	ServicioLibro servicioLibro = null;
	ServicioEditorial servicioEditorial=null;

	public LibrosController() {
		super();
		servicioLibro = ServicioLibro.getInstance();
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
		servicioEditorial= ServicioEditorial.getInstance();

	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Libro>> listar() {
		ResponseEntity<ArrayList<Libro>> response = new ResponseEntity<ArrayList<Libro>>(
				HttpStatus.INTERNAL_SERVER_ERROR);
		ArrayList<Libro> libros = new ArrayList<Libro>();

		try {
			ServicioEditorial.getInstance();
			libros = (ArrayList<Libro>) servicioLibro.listar();
			response = new ResponseEntity<ArrayList<Libro>>(libros, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<Libro> detalle(@PathVariable long id) {
		ResponseEntity<Libro> response = new ResponseEntity<Libro>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {

			Libro libro = servicioLibro.buscar(id);
			if (libro != null && libro.getId() > 0) {
				response = new ResponseEntity<Libro>(libro, HttpStatus.OK);
			} else {
				response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;

	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> eliminar(@PathVariable long id) {
		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {

			if (servicioLibro.eliminar(id)) {
				response = new ResponseEntity<>(HttpStatus.OK);
			} else {
				response = new ResponseEntity<>(new ResponseMensaje("No se puede eliminar este Libro porque no existe"),
						HttpStatus.NOT_FOUND);
			}
		} catch (SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
			response = new ResponseEntity<>(
					new ResponseMensaje("No se puede eliminar este Libro porque tiene un registro asociado"),
					HttpStatus.CONFLICT);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;

	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> crear(@RequestBody Libro libro) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		ResponseMensaje msg = new ResponseMensaje();
		try {

			// Validacion con javax validator
			Set<ConstraintViolation<Libro>> violations = validator.validate(libro);
			if (violations.isEmpty()) {
				if (servicioLibro.crear(libro)) {
					Editorial editorial=servicioEditorial.buscar(libro.getEditorial().getId());
					libro.setEditorial(editorial);
					response = new ResponseEntity<>(libro, HttpStatus.CREATED);
				} else {
					response = new ResponseEntity<>(new ResponseMensaje("El libro ya existe"), HttpStatus.CONFLICT);
				}
			} else {
				for (ConstraintViolation<Libro> constraint : violations) {
					msg.addError((constraint.getPropertyPath() + ": " + constraint.getMessage()));
					msg.setMensaje("Ha ocurrido un error");
				}
				response = new ResponseEntity<>(msg, HttpStatus.CONFLICT);

			}

		} catch (SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
			response = new ResponseEntity<>(
					new ResponseMensaje("Ya existe un libro con ese nombre, por favor cambialo"), HttpStatus.CONFLICT);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return response;
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> modificar(@PathVariable long id, @RequestBody Libro libro) {
		ResponseMensaje msg = new ResponseMensaje();

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {
			Set<ConstraintViolation<Libro>> violations = validator.validate(libro);
			if (violations.isEmpty()) {
				libro.setId(id);
				if (servicioLibro.modificar(libro)) {
					
					Editorial editorial = servicioEditorial.buscar(libro.getEditorial().getId());
					libro.setEditorial(editorial);
					response = new ResponseEntity<>(libro, HttpStatus.OK);
				} else {
					response = new ResponseEntity<>(new ResponseMensaje("El libro que intenta modificar no exite"),HttpStatus.NOT_FOUND);
				}
			} else {

				for (ConstraintViolation<Libro> constraint : violations) {
					msg.addError((constraint.getPropertyPath() + ": " + constraint.getMessage()));
				}
				response = new ResponseEntity<>(msg, HttpStatus.CONFLICT);

			}
		} catch (SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
			response = new ResponseEntity<>(
					new ResponseMensaje("Ya existe un/@ alumn@ con ese nombre, por favor elige otro nombre o apellido"),
					HttpStatus.CONFLICT);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

}
