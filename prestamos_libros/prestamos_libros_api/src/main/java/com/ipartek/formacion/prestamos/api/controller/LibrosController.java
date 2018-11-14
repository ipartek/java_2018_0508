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
import com.ipartek.formacion.prestamolibros.pojo.Libro;
import com.ipartek.formacion.prestamolibros.service.ServicioEditorial;
import com.ipartek.formacion.prestamolibros.service.ServicioLibro;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/libros")
@Api(value = "Libros", tags = { "Libros" })
public class LibrosController {
	
	private final static Logger LOG = Logger.getLogger(LibrosController.class);
	ServicioLibro servicioLibro = null;
	ServicioEditorial servicioEditorial = null;
	ValidatorFactory factory = null;
	Validator validator = null;

	public LibrosController() {
		super();
		servicioLibro = ServicioLibro.getInstance();
		servicioEditorial = ServicioEditorial.getInstance();
		
		//Crear Factoria y Validador
		 factory = Validation.buildDefaultValidatorFactory();
		 validator = factory.getValidator();
	}

	@RequestMapping( method = RequestMethod.GET)
	@ApiOperation(value = "Listado de libros")
	@ApiResponses(value = { 
							@ApiResponse(code = 200, message = "Listado de libros"),
							@ApiResponse(code = 500, message = "Error fatal") }
				)
	public ResponseEntity<ArrayList<Libro>> listado() {
		
		ArrayList<Libro> libros = new ArrayList<Libro>();
		ResponseEntity<ArrayList<Libro>> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		try {
			libros = (ArrayList<Libro>) servicioLibro.listar();
			response = new ResponseEntity<>(libros, HttpStatus.OK);
			
		} catch (Exception e) {
			LOG.error(e);
		}

		return response;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "Detalle de un libro")
	@ApiResponses(value = { 
							@ApiResponse(code = 200, message = "Detalle del libro"),
							@ApiResponse(code = 404, message = "El libro no existe"),
							@ApiResponse(code = 500, message = "Error fatal")  
							}
				)
	@ApiParam(value="id", required=true)
	public ResponseEntity<Libro> detalle(@PathVariable("id") long id) {
		
		ResponseEntity<Libro> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		Libro libro = new Libro();
		
		try {
			
			libro = servicioLibro.buscar(id);
			
			if(libro != null && libro.getId() > 0) {
				response = new ResponseEntity<Libro>(libro, HttpStatus.OK);
			}else {
				response = new ResponseEntity<Libro>(HttpStatus.NOT_FOUND);
			}
			
			
		} catch (Exception e) {
			LOG.error(e);
		}	
		
		return response;
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Eliminar un libro")
	@ApiResponses(value = { 
							@ApiResponse(code = 200, message = "Libro eliminado"),
							@ApiResponse(code = 404, message = "El libro no existe"),
							@ApiResponse(code = 409, message = "No podemos eliminar el libro, ya que en estos momentos está prestado."),								
							@ApiResponse(code = 500, message = "Error fatal")  
							}
				)
	@ApiParam(value="id", name="id", required=true)
	public ResponseEntity<Object> eliminar(@PathVariable("id") long id) {
		
		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
		
		try {
			
			if(servicioLibro.eliminar(id)) {
				response = new ResponseEntity<>(HttpStatus.OK);
			}else {
				response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
		}catch(SQLIntegrityConstraintViolationException e){
			response = new ResponseEntity<>(new ResponseMensaje("No podemos eliminar el libro, ya que en estos momentos está prestado."), HttpStatus.CONFLICT);
		} catch (Exception e) {
			LOG.error(e);
		}
		
		return response;	
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value = "Crear un libro")
	@ApiResponses(value = { 
							@ApiResponse(code = 201, message = "Libro creado"),
							@ApiResponse(code = 404, message = "El libro no existe"),
							@ApiResponse(code = 409, message = "No se pudo crear el libro ya que no existe la editorial indicada. / "
									+ "	El título no puede estar vacío y debe contener entre 2 y 150 caracteres / "
									+ "El isbn no puede estar vacío y debe contener entre 5 y 20 caracteres."),
							@ApiResponse(code = 500, message = "Error fatal")  
							}
				)
	public ResponseEntity<Object> crear(@RequestBody Libro libro) {
		
		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		ResponseMensaje msg = new ResponseMensaje();
		
		try {
			
			Set<ConstraintViolation<Libro>> violations = validator.validate(libro);
			if(violations.isEmpty()) {
				
				if(servicioLibro.crear(libro)) {
					Editorial editorial = servicioEditorial.buscar(libro.getEditorial().getId());
					libro.setEditorial(editorial);
					response = new ResponseEntity<>(libro, HttpStatus.CREATED);
				}else {
					response = new ResponseEntity<>(libro, HttpStatus.CONFLICT);
				}
				
			}else {

				msg.setMensaje("No se pudo crear el libro");
				
				for (ConstraintViolation<Libro> violation : violations) {
					
					msg.addError(violation.getPropertyPath() + ": " + violation.getMessage());
				}
				
				response = new ResponseEntity<>(msg, HttpStatus.CONFLICT);
			}
			
		} catch(SQLIntegrityConstraintViolationException e){
			response = new ResponseEntity<>(new ResponseMensaje("No se pudo crear el libro ya que no existe la editorial indicada."), HttpStatus.CONFLICT);
					
		}catch (Exception e) {
			LOG.error(e);
		}
		
		return response;	
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ApiOperation(value = "Modificar un libro")
	@ApiResponses(value = { 
							@ApiResponse(code = 200, message = "Libro modificado"),
							@ApiResponse(code = 404, message = "El libro no existe"),
							@ApiResponse(code = 409, message = "No se pudo crear el libro ya que no existe la editorial indicada. / "
									+ "	El título no puede estar vacío y debe contener entre 2 y 150 caracteres / "
									+ "El isbn no puede estar vacío y debe contener entre 5 y 20 caracteres."),
							@ApiResponse(code = 500, message = "Error fatal")  
							}
				)
	@ApiParam(value="id", required=true)
	public ResponseEntity<Object> modificar(@PathVariable("id") long id, @RequestBody Libro libro) {
		
		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		ResponseMensaje msg = new ResponseMensaje();
		
		try {
			
			Set<ConstraintViolation<Libro>> violations = validator.validate(libro);
			if(violations.isEmpty()) {
				
				libro.setId(id);
				
				if(servicioLibro.modificar(libro)) {
					Editorial editorial = servicioEditorial.buscar(libro.getEditorial().getId());
					libro.setEditorial(editorial);
					response = new ResponseEntity<>(libro, HttpStatus.OK);
				}else {
					response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}
				
			}else {

				msg.setMensaje("No se pudo modificar el libro");
				
				for (ConstraintViolation<Libro> violation : violations) {
					
					msg.addError(violation.getPropertyPath() + ": " + violation.getMessage());
				}
				
				response = new ResponseEntity<>(msg, HttpStatus.CONFLICT);
			}
			
		}catch(SQLIntegrityConstraintViolationException e){
			response = new ResponseEntity<>(new ResponseMensaje("No se pudo modificar el libro ya que no existe la editorial indicada."), HttpStatus.CONFLICT);
			
		} catch (Exception e) {
			LOG.error(e);
		}
		
		return response;	
		
	}

}
