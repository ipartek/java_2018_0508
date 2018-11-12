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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.pojo.Alumno;
import com.ipartek.formacion.pojo.Alumno;
import com.ipartek.formacion.service.ServiceAlumno;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/alumnos")
public class LibrosController {

	ServiceAlumno serviceAlumno = null;
	ValidatorFactory factory = null;
	Validator validator = null;

	public LibrosController() {
		super();
		serviceAlumno = serviceAlumno.getInstance();
		// Crear Factoria y Validador
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<ArrayList<Alumno>> listar() {

		ArrayList<Alumno> list = new ArrayList<Alumno>();
		ResponseEntity<ArrayList<Alumno>> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		try {
			list = (ArrayList<Alumno>) serviceAlumno.listar();
			response = new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Alumno> detalle(@PathVariable long id) {
		ResponseEntity<Alumno> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {
			Alumno Alumno = serviceAlumno.buscar(id);

			if (Alumno != null && Alumno.getId() > 0) {
				response = new ResponseEntity<>(Alumno, HttpStatus.OK);
			} else {
				response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> eliminar(@PathVariable long id) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {
						
			if ( serviceAlumno.eliminar(id) ) {
				response = new ResponseEntity<>(HttpStatus.OK);
			}else {
				response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		
		}catch( SQLIntegrityConstraintViolationException e ) {	
			response = new ResponseEntity<>(new ResponseMensaje("No se puede eliminar si tiene Libros asociados"), HttpStatus.CONFLICT);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> crear(@RequestBody Alumno Alumno) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {

			Set<ConstraintViolation<Alumno>> violations = validator.validate(Alumno);
			if(violations.isEmpty()) {
				 
				if (serviceAlumno.crear(Alumno)) {
					response = new ResponseEntity<>(Alumno, HttpStatus.CREATED);
				} else {
					response = new ResponseEntity<>(HttpStatus.CONFLICT);
				}
			}else {
				ResponseMensaje mensaje = new ResponseMensaje("Los datos no son correctos");
				for (ConstraintViolation<Alumno> violation : violations) {
					mensaje.addError( violation.getPropertyPath() + ": " + violation.getMessage() );
					
					
				}
				response = new ResponseEntity<>( mensaje ,  HttpStatus.CONFLICT);
			}

			
		} catch (SQLIntegrityConstraintViolationException e) {
			ResponseMensaje msj = new ResponseMensaje("Ya existe la Alumno, por favor prueba con otro nombre");			
			response = new ResponseEntity<>(msj, HttpStatus.CONFLICT);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> modificar(@PathVariable long id, @RequestBody Alumno Alumno) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {
			
			Set<ConstraintViolation<Alumno>> violations =  validator.validate(Alumno);
			if ( violations.isEmpty() ) {
			
				Alumno.setId(id);			
				if ( serviceAlumno.modificar(Alumno) ) {
					response = new ResponseEntity<>(Alumno, HttpStatus.OK);
				}else {
					response = new ResponseEntity<>(HttpStatus.CONFLICT);
				}
				
			}else {
				ResponseMensaje mensaje = new ResponseMensaje("Los datos no son correctos");
				for ( ConstraintViolation<Alumno> v : violations ) {
					mensaje.addError( v.getPropertyPath() + ": " + v.getMessage() );
				};
				response = new ResponseEntity<>( mensaje ,  HttpStatus.CONFLICT);
			}	
		
		}catch (SQLIntegrityConstraintViolationException e) {
			
			response = new ResponseEntity<>( new ResponseMensaje("Ya existe la Alumno, por favor prueba con otro nombre")  ,HttpStatus.CONFLICT);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
}
