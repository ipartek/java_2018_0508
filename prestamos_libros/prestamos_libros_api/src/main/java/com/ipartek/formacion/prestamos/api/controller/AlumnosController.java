package com.ipartek.formacion.prestamos.api.controller;

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

import com.ipartek.formacion.prestamolibros.pojo.Alumno;
import com.ipartek.formacion.prestamolibros.service.ServicioAlumno;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "*") 
@RestController
@RequestMapping("/alumnos")
@Api(tags = { "Alumnos" }, produces = "application/json", description="Gestión de alumnos")
public class AlumnosController {
	
	private final static Logger LOG = Logger.getLogger(AlumnosController.class);
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
	@ApiOperation(value = "Listado de alumnos")
	@ApiResponses(value = { 
							@ApiResponse(code = 200, message = "Listado de alumnos"),
							@ApiResponse(code = 500, message = "Error fatal") }
				)
	public ResponseEntity<ArrayList<Alumno>> listado() {
		
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		ResponseEntity<ArrayList<Alumno>> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		try {
			alumnos = (ArrayList<Alumno>) servicioAlumno.listar();
			response = new ResponseEntity<>(alumnos, HttpStatus.OK);
			
		} catch (Exception e) {
			LOG.error(e);
		}

		return response;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "Detalle de un alumno")
	@ApiResponses(value = { 
							@ApiResponse(code = 200, message = "Detalle del alumno"),
							@ApiResponse(code = 404, message = "El alumno no existe"),
							@ApiResponse(code = 500, message = "Error fatal")  
							}
				)
	@ApiParam(value="id", required=true)
	public ResponseEntity<Alumno> detalle(
			@ApiParam(value="Id del alumno.", required=true)
			@PathVariable("id") long id) {
		
		ResponseEntity<Alumno> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		Alumno alumno = new Alumno();
		
		try {
			
			alumno = servicioAlumno.buscar(id);
			
			if(alumno != null && alumno.getId() > 0) {
				response = new ResponseEntity<Alumno>(alumno, HttpStatus.OK);
			}else {
				response = new ResponseEntity<Alumno>(alumno, HttpStatus.NOT_FOUND);
				LOG.debug("El alumno no existe.");
			}
			
			
		} catch (Exception e) {
			LOG.error(e);
		}	
		
		return response;
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Eliminar un alumno", response = Alumno.class)
	@ApiResponses(value = { 
							@ApiResponse(code = 200, message = "Alumno eliminado"),
							@ApiResponse(code = 404, message = "El alumno no existe"),							
							@ApiResponse(code = 500, message = "Error fatal")  
							}
				)
	@ApiParam(value="id", name="id", required=true)
	public ResponseEntity<Object> eliminar(
			@ApiParam(value="Id del alumno", required=true)
			@PathVariable("id") long id) {
		
		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
		
		try {
			
			if(servicioAlumno.eliminar(id)) {
				response = new ResponseEntity<>(HttpStatus.OK);
			}else {
				response = new ResponseEntity<>(new ResponseMensaje("El alumno no existe."), HttpStatus.NOT_FOUND);
				LOG.debug("El alumno no existe.");
			}
			
		}catch (Exception e) {
			LOG.error(e);
		}
		
		return response;	
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value = "Crear un alumno", response = Alumno.class)
	@ApiResponses(value = { 
							@ApiResponse(code = 201, message = "Alumno creado"),
							@ApiResponse(code = 409, message = 
									  "<ol>"
									+ "<li>El alumno ya existe.</li> "
									+ "<li>El nombre no puede estar vacío y debe contener entre 2 y 50 caracteres.</li>"
									+ "<li>El campo apellidos no puede estar vacío y debe contener entre 2 y 150 caracteres.</li>"
									+ "</ol>"),
							@ApiResponse(code = 500, message = "Error fatal")  
							}
				)
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
			response = new ResponseEntity<>(new ResponseMensaje("El alumno ya existe."), HttpStatus.CONFLICT);
			LOG.debug("El alumno ya existe.");
		} catch (Exception e) {
			LOG.error(e);
		}
		
		return response;	
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ApiOperation(value = "Modificar un alumno", response = Alumno.class
	)
	@ApiResponses(value = { 
							@ApiResponse(code = 200, message = "Alumno modificado"),
							@ApiResponse(code = 404, message = "El alumno no existe"),
							@ApiResponse(code = 409, message = 
									  "<ol>"
									+ "<li>El alumno ya existe.</li> "
									+ "<li>El nombre no puede estar vacío y debe contener entre 2 y 50 caracteres.</li>"
									+ "<li>El campo apellidos no puede estar vacío y debe contener entre 2 y 150 caracteres.</li>"
									+ "</ol>"),
							@ApiResponse(code = 500, message = "Error fatal")  
							}
				)
	@ApiParam(value="id", required=true)
	public ResponseEntity<Object> modificar(
			@ApiParam(value="Id del alumno", required=true)
			@PathVariable("id") long id, @RequestBody Alumno alumno) {
		
		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		ResponseMensaje msg = new ResponseMensaje();
		
		try {
			
			Set<ConstraintViolation<Alumno>> violations = validator.validate(alumno);
			if(violations.isEmpty()) {
				
				alumno.setId(id);
				
				if(servicioAlumno.modificar(alumno)) {
					response = new ResponseEntity<>(alumno, HttpStatus.OK);
				}else {
					response = new ResponseEntity<>(new ResponseMensaje("El alumno no existe."), HttpStatus.NOT_FOUND);
					LOG.debug("El alumno no existe.");
				}
				
			}else {

				msg.setMensaje("No se pudo modificar el alumno");
				
				for (ConstraintViolation<Alumno> violation : violations) {
					
					msg.addError(violation.getPropertyPath() + ": " + violation.getMessage());
				}
				
				response = new ResponseEntity<>(msg, HttpStatus.CONFLICT);
			}
			
		}catch(SQLIntegrityConstraintViolationException e){
			response = new ResponseEntity<>(new ResponseMensaje("El alumno ya existe."), HttpStatus.CONFLICT);
			LOG.debug("El alumno ya existe.");
		} catch (Exception e) {
			LOG.error(e);
		}
		
		return response;	
		
	}

}
