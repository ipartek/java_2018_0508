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

import com.ipartek.formacion.prestamos_libros.pojo.Libro;
import com.ipartek.formacion.prestamos_libros.service.ServiceLibro;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/libros")
public class LibrosController {

	ServiceLibro serviceLibro = null;
	ValidatorFactory factory = null;
	Validator validator = null;

	public LibrosController() {
		super();
		serviceLibro = ServiceLibro.getInstance();
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Libro>> listado() {

		ArrayList<Libro> list = new ArrayList<Libro>();
		ResponseEntity<ArrayList<Libro>> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {

			list = (ArrayList<Libro>) serviceLibro.listar();
			response = new ResponseEntity<>(list, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Libro> detalle(@PathVariable long id) {

		ResponseEntity<Libro> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {
			
			Libro libro = serviceLibro.buscarId(id);
			if ( libro != null && libro.getId() > 0 ) {
				response = new ResponseEntity<>(libro, HttpStatus.OK);
			}else {
				response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> eliminar(@PathVariable long id) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {
						
			if ( serviceLibro.eliminar(id) ) {
				response = new ResponseEntity<>(HttpStatus.OK);
			}else {
				response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		
		}catch( SQLIntegrityConstraintViolationException e ) {	
			response = new ResponseEntity<>(new ResponseMensaje("No se puede eliminar si tiene Prestamo asociados"), HttpStatus.CONFLICT);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> crear(@RequestBody Libro libro) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {
			
			
			Set<ConstraintViolation<Libro>> violations =  validator.validate(libro);
	
			if ( violations.isEmpty() ) {
			
				if ( serviceLibro.crear(libro) ) {
					response = new ResponseEntity<>(libro, HttpStatus.CREATED);
				}else {
					response = new ResponseEntity<>(new ResponseMensaje("libro creado"), HttpStatus.CREATED);
				}
				
			}else {
				ResponseMensaje mensaje = new ResponseMensaje("Los datos no son correctos");
				for ( ConstraintViolation<Libro> v : violations ) {
					mensaje.addError( v.getPropertyPath() + ": " + v.getMessage() );
				};
				response = new ResponseEntity<>( mensaje ,  HttpStatus.CONFLICT);
			}	
		
		}catch ( SQLIntegrityConstraintViolationException e) {
			
			
			ResponseMensaje msj = new ResponseMensaje("Los datos no son correctos");			
			response = new ResponseEntity<>(msj, HttpStatus.CONFLICT);
			
		}catch (Exception e) {
			//TODO gestionar duplicate key entry
			e.printStackTrace();
		}
		return response;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> modificar(@PathVariable long id, @RequestBody Libro libro) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {
			
			Set<ConstraintViolation<Libro>> violations =  validator.validate(libro);
			if ( violations.isEmpty() ) {
			
				libro.setId(id);			
				if ( serviceLibro.modificar(libro) ) {
					response = new ResponseEntity<>(libro, HttpStatus.OK);
				}else {
					response = new ResponseEntity<>(HttpStatus.CONFLICT);
				}
				
			}else {
				ResponseMensaje mensaje = new ResponseMensaje("Los datos no son correctos");
				for ( ConstraintViolation<Libro> v : violations ) {
					mensaje.addError( v.getPropertyPath() + ": " + v.getMessage() );
				};
				response = new ResponseEntity<>( mensaje ,  HttpStatus.CONFLICT);
			}	
		
		}catch (SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
			
			response = new ResponseEntity<>( new ResponseMensaje("los datos son incorrectos")  ,HttpStatus.CONFLICT);
		}catch (Exception e) {
			//TODO gestionar duplicate key entry
			e.printStackTrace();
		}
		return response;
	}

}