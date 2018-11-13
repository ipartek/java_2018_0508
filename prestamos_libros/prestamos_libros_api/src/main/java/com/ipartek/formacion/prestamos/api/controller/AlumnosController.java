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

import com.ipartek.formacion.prestamolibros.pojo.Alumno;
import com.ipartek.formacion.prestamolibros.service.ServicioAlumno;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/alumnos")
public class AlumnosController {
	
	ServicioAlumno servicioAlumno = null;
	ValidatorFactory factory = null;
	Validator validator = null;

	public AlumnosController() {
		super();
		servicioAlumno = ServicioAlumno.getInstance();
		
		//Crear Factoria y Validador
		 factory = Validation.buildDefaultValidatorFactory();
		 validator = factory.getValidator();
	}

	@RequestMapping( method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Alumno>> listado() {
		
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		ResponseEntity<ArrayList<Alumno>> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		try {
			alumnos = (ArrayList<Alumno>) servicioAlumno.listar();
			response = new ResponseEntity<>(alumnos, HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Alumno> detalle(@PathVariable("id") long id) {
		
		ResponseEntity<Alumno> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		Alumno alumno = new Alumno();
		
		try {
			
			alumno = servicioAlumno.buscar(id);
			
			if(alumno != null && alumno.getId() > 0) {
				response = new ResponseEntity<Alumno>(alumno, HttpStatus.OK);
			}else {
				response = new ResponseEntity<Alumno>(alumno, HttpStatus.NOT_FOUND);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		return response;
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> eliminar(@PathVariable("id") long id) {
		
		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
		
		try {
			
			if(servicioAlumno.eliminar(id)) {
				response = new ResponseEntity<>(HttpStatus.OK);
			}else {
				response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return response;	
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> crear(@RequestBody Alumno alumno) {
		
		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		ResponseMensaje msg = new ResponseMensaje();
		
		try {
			
			Set<ConstraintViolation<Alumno>> violations = validator.validate(alumno);
			if(violations.isEmpty()) {
				
				if(servicioAlumno.crear(alumno)) {
					response = new ResponseEntity<>(alumno, HttpStatus.CREATED);
				}else {
					response = new ResponseEntity<>(alumno, HttpStatus.CONFLICT);
				}
				
			}else {

				msg.setMensaje("No se pudo crear el alumno");
				
				for (ConstraintViolation<Alumno> violation : violations) {
					
					msg.addError(violation.getPropertyPath() + ": " + violation.getMessage());
				}
				
				response = new ResponseEntity<>(msg, HttpStatus.CONFLICT);
			}
			
		}catch(SQLIntegrityConstraintViolationException e){
			response = new ResponseEntity<>(new ResponseMensaje("El alumno " + alumno.getNombre() + " " + alumno.getApellidos() + " ya existe."), HttpStatus.CONFLICT);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return response;	
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> modificar(@PathVariable("id") long id, @RequestBody Alumno alumno) {
		
		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		ResponseMensaje msg = new ResponseMensaje();
		
		try {
			
			Set<ConstraintViolation<Alumno>> violations = validator.validate(alumno);
			if(violations.isEmpty()) {
				
				alumno.setId(id);
				
				if(servicioAlumno.modificar(alumno)) {
					response = new ResponseEntity<>(alumno, HttpStatus.OK);
				}else {
					response = new ResponseEntity<>(alumno, HttpStatus.CONFLICT);
				}
				
			}else {

				msg.setMensaje("No se pudo modificar el alumno");
				
				for (ConstraintViolation<Alumno> violation : violations) {
					
					msg.addError(violation.getPropertyPath() + ": " + violation.getMessage());
				}
				
				response = new ResponseEntity<>(msg, HttpStatus.CONFLICT);
			}
			
		}catch(SQLIntegrityConstraintViolationException e){
			response = new ResponseEntity<>(new ResponseMensaje("El alumno " + alumno.getNombre() + " " + alumno.getApellidos() + " ya existe."), HttpStatus.CONFLICT);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return response;	
		
	}

}
