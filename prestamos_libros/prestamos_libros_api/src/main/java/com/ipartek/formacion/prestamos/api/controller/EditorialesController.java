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

import com.ipartek.formacion.prestamolibros.pojo.Editorial;
import com.ipartek.formacion.prestamolibros.service.ServicioEditorial;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/editoriales")
@Api(value = "Editoriales", tags = { "Editoriales" })
public class EditorialesController {
	
	private final static Logger LOG = Logger.getLogger(EditorialesController.class);
	ServicioEditorial servicioEditorial = null;
	ValidatorFactory factory = null;
	Validator validator = null;

	public EditorialesController() {
		super();
		servicioEditorial = ServicioEditorial.getInstance();
		
		//Crear Factoria y Validador
		 factory = Validation.buildDefaultValidatorFactory();
		 validator = factory.getValidator();
	}

	@RequestMapping( method = RequestMethod.GET)
	@ApiOperation(value = "Listado de editoriales")
	@ApiResponses(value = { 
							@ApiResponse(code = 200, message = "Listado de editoriales"),
							@ApiResponse(code = 500, message = "Error fatal") }
				)
	@ApiParam(value="activo", required=false,  name="bla bla bla", defaultValue="1")
	public ResponseEntity<ArrayList<Editorial>> listado() {
		
		ArrayList<Editorial> editoriales = new ArrayList<Editorial>();
		ResponseEntity<ArrayList<Editorial>> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		try {
			editoriales = (ArrayList<Editorial>) servicioEditorial.listar();
			response = new ResponseEntity<>(editoriales, HttpStatus.OK);
			
		} catch (Exception e) {
			LOG.error(e);
		}

		return response;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "Detalle de una editorial")
	@ApiResponses(value = { 
							@ApiResponse(code = 200, message = "Detalle de la editorial"),
							@ApiResponse(code = 404, message = "La editorial no existe"),
							@ApiResponse(code = 500, message = "Error fatal")  
							}
				)
	@ApiParam(value="id", required=true)
	public ResponseEntity<Editorial> detalle(@PathVariable("id") long id) {
		
		ResponseEntity<Editorial> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		Editorial editorial = new Editorial();
		
		try {
			
			editorial = servicioEditorial.buscar(id);
			
			if(editorial != null && editorial.getId() > 0) {
				response = new ResponseEntity<Editorial>(editorial, HttpStatus.OK);
			}else {
				response = new ResponseEntity<Editorial>(editorial, HttpStatus.NOT_FOUND);
			}
			
			
		} catch (Exception e) {
			LOG.error(e);
		}	
		
		return response;
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Eliminar una editorial")
	@ApiResponses(value = { 
							@ApiResponse(code = 200, message = "Editorial eliminada"),
							@ApiResponse(code = 404, message = "La editorial no existe"),
							@ApiResponse(code = 409, message = "No podemos eliminar la editorial, ya que tiene uno o más libros asociados."),
							@ApiResponse(code = 500, message = "Error fatal")  
							}
				)
	@ApiParam(value="La id del libro a eliminar", name="id", required=true)
	public ResponseEntity<Object> eliminar(@PathVariable("id") long id) {
		
		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
		
		try {
			
			if(servicioEditorial.eliminar(id)) {
				response = new ResponseEntity<>(HttpStatus.OK);
			}else {
				response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
		}catch(SQLIntegrityConstraintViolationException e){
			response = new ResponseEntity<>(new ResponseMensaje("No podemos eliminar la editorial, ya que tiene uno o más libros asociados."), HttpStatus.CONFLICT);
		} catch (Exception e) {
			LOG.error(e);
		}
		
		return response;	
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value = "Crear una editorial")
	@ApiResponses(value = { 
							@ApiResponse(code = 201, message = "Editorial creada"),
							@ApiResponse(code = 404, message = "La editorial no existe"),
							@ApiResponse(code = 409, message = "La editorial ya existe / No puede estar vacía y debe contener entre 2 y 50 caracteres"),
							@ApiResponse(code = 500, message = "Error fatal")  
							}
				)
	public ResponseEntity<Object> crear(@RequestBody Editorial editorial) {
		
		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		ResponseMensaje msg = new ResponseMensaje();
		
		try {
			
			Set<ConstraintViolation<Editorial>> violations = validator.validate(editorial);
			if(violations.isEmpty()) {
				
				if(servicioEditorial.crear(editorial)) {
					response = new ResponseEntity<>(editorial, HttpStatus.CREATED);
				}else {
					response = new ResponseEntity<>(editorial, HttpStatus.NOT_FOUND);
				}
				
			}else {

				msg.setMensaje("No se pudo crear la editorial");
				
				for (ConstraintViolation<Editorial> violation : violations) {
					
					msg.addError(violation.getPropertyPath() + ": " + violation.getMessage());
				}
				
				response = new ResponseEntity<>(msg, HttpStatus.CONFLICT);
			}
			
		}catch(SQLIntegrityConstraintViolationException e){
			response = new ResponseEntity<>(new ResponseMensaje("La editorial " + editorial.getEditorial() + " ya existe."), HttpStatus.CONFLICT);
			
		} catch (Exception e) {
			LOG.error(e);
		}
		
		return response;	
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ApiOperation(value = "Modificar una editorial")
	@ApiResponses(value = { 
							@ApiResponse(code = 200, message = "Editorial modificada"),
							@ApiResponse(code = 404, message = "La editorial no existe"),
							@ApiResponse(code = 409, message = "Ya existe unaeditorial con ese nombre. / No puede estar vacía y debe contener entre 2 y 50 caracteres."),
							@ApiResponse(code = 500, message = "Error fatal")  
							}
				)
	@ApiParam(value="id", required=true)
	public ResponseEntity<Object> modificar(@PathVariable("id") long id, @RequestBody Editorial editorial) {
		
		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		ResponseMensaje msg = new ResponseMensaje();
		
		try {
			
			Set<ConstraintViolation<Editorial>> violations = validator.validate(editorial);
			if(violations.isEmpty()) {
				
				editorial.setId(id);
				
				if(servicioEditorial.modificar(editorial)) {
					response = new ResponseEntity<>(editorial, HttpStatus.OK);
				}else {
					response = new ResponseEntity<>(editorial, HttpStatus.NOT_FOUND);
				}
				
			}else {

				msg.setMensaje("No se pudo modificar la editorial");
				
				for (ConstraintViolation<Editorial> violation : violations) {
					
					msg.addError(violation.getPropertyPath() + ": " + violation.getMessage());
				}
				
				response = new ResponseEntity<>(msg, HttpStatus.CONFLICT);
			}
			
		}catch(SQLIntegrityConstraintViolationException e){
			response = new ResponseEntity<>(new ResponseMensaje("La editorial " + editorial.getEditorial() + " ya existe."), HttpStatus.CONFLICT);
			
		} catch (Exception e) {
			LOG.error(e);
		}
		
		return response;	
		
	}

}
