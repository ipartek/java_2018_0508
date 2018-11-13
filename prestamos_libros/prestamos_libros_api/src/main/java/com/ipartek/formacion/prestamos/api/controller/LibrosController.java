package com.ipartek.formacion.prestamos.api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.prestamos_libros.pojo.Editorial;
import com.ipartek.formacion.prestamos_libros.pojo.Libro;
import com.ipartek.formacion.prestamos_libros.service.ServiceEditorial;
import com.ipartek.formacion.prestamos_libros.service.ServiceLibro;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

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

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/libros")
public class LibrosController {
	
	ServiceLibro serviceLibro = null;
	ServiceEditorial serviceEditorial = null;
	ValidatorFactory factory = null;
	Validator validator = null;
	
	public LibrosController() {
		super();
		serviceLibro = ServiceLibro.getInstance();
		serviceEditorial = ServiceEditorial.getInstance();
		//Crear Factoria y Validador
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@RequestMapping( method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Libro>> listado() {
		ResponseEntity<ArrayList<Libro>> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		ArrayList<Libro> libros = new ArrayList<Libro>();
		
		try {
			libros = (ArrayList<Libro>) serviceLibro.listar();
			response = new ResponseEntity<>(libros, HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return response;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Libro> detalle(@PathVariable long id) {
		
		ResponseEntity<Libro> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		try {
			Libro libro = serviceLibro.buscarPorId(id);
			if(libro != null && libro.getId() > 0) {
				response = new ResponseEntity<>(libro, HttpStatus.OK);
			}else {
				response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

		return response;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> crear(@RequestBody Libro libro) {
		
		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		try {
			
			Set<ConstraintViolation<Libro>> violations = validator.validate(libro);
			if (violations.isEmpty()) {
			    /* Ha pasado la validacion*/
				if(serviceLibro.crear(libro)) {
					Editorial editorial = serviceEditorial.buscarPorId(libro.getEditorial().getId());
					libro.getEditorial().setNombre(editorial.getNombre());
					response = new ResponseEntity<>(libro, HttpStatus.CREATED);
				}else {
					response = new ResponseEntity<>(HttpStatus.CONFLICT);
				}
			}else{
			    /* Hay fallos, la Validacion no es correcta */
				ResponseMensaje msj = new ResponseMensaje();
				msj.setMensaje("Los datos no son válidos.");
				 for (ConstraintViolation<Libro> violation : violations) {
					 msj.addError(violation.getPropertyPath()+": "+violation.getMessage());
				 }
				response = new ResponseEntity<>(msj, HttpStatus.CONFLICT);
			}
			
			
		}catch(MySQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
			ResponseMensaje msj = new ResponseMensaje("Debe seleccionar una editorial para el libro.");
			response = new ResponseEntity<>(msj, HttpStatus.CONFLICT);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		 
		return response;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> modificar(@PathVariable long id, @RequestBody Libro libro) {
		
		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		try {
			Set<ConstraintViolation<Libro>> violations = validator.validate(libro);
			
			libro.setId(id);
			
			if (violations.isEmpty()) {
			    /* Ha pasado la validacion*/
				if(serviceLibro.modificar(libro)) {
					Editorial editorial = serviceEditorial.buscarPorId(libro.getEditorial().getId());
					libro.getEditorial().setNombre(editorial.getNombre());
					response = new ResponseEntity<>(libro, HttpStatus.OK);
				}else {
					response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}
			}else{
			    /* Hay fallos, la Validacion no es correcta */
				ResponseMensaje msj = new ResponseMensaje();
				msj.setMensaje("Los datos no son válidos.");
				 for (ConstraintViolation<Libro> violation : violations) {
					 msj.getErrores().add(violation.getPropertyPath()+": "+violation.getMessage());
				 }
				response = new ResponseEntity<>(msj, HttpStatus.CONFLICT);
			}
		}catch(MySQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
			ResponseMensaje msj = new ResponseMensaje("Debes seleccionar una editorial para el libro.");
			response = new ResponseEntity<>(msj, HttpStatus.CONFLICT);
		}catch(Exception e) {
			e.printStackTrace();
			ResponseMensaje msj = new ResponseMensaje("No existe el libro.");
			response = new ResponseEntity<>(msj, HttpStatus.NOT_FOUND);
		}
		 
		return response;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> eliminar(@PathVariable long id) {
		
		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		try {
			if(serviceLibro.eliminar(id)) {
				response = new ResponseEntity<>(HttpStatus.OK);
			}else {
				ResponseMensaje msj = new ResponseMensaje("No se puede borrar un registro que no existe");
				response = new ResponseEntity<>(msj, HttpStatus.NOT_FOUND);
			}
		}catch(MySQLIntegrityConstraintViolationException e) {
			ResponseMensaje msj = new ResponseMensaje("No se puede borrar el libro porque tiene préstamos asociados.");
			response = new ResponseEntity<>(msj, HttpStatus.CONFLICT);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return response;
	}
	
}
