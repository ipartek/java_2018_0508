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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.pojo.Editorial;
import com.ipartek.formacion.pojo.Libro;
import com.ipartek.formacion.service.ServiceEditorial;
import com.ipartek.formacion.service.ServiceLibro;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/libros")
@Api(tags = "Libros",  description = "Parte de la API que gestiona los libros", produces="application/json")
public class LibrosController {

	private final static Logger LOG = Logger.getLogger(LibrosController.class);
	
	ServiceLibro serviceLibro = null;
	ServiceEditorial serviceEditorial = null;
	ValidatorFactory factory = null;
	Validator validator = null;

	public LibrosController() {
		super();
		serviceLibro = serviceLibro.getInstance();
		serviceEditorial = serviceEditorial.getInstance();
		// Crear Factoria y Validador
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@ApiOperation( 
		    value = "Lista todos los libros que se encuentran en la BBDD", 
		    notes = ""
		)
	@ApiResponses({@ApiResponse(code = 200, message = "Acción realizada con exito"),
		    @ApiResponse( code = 404, message = "No existe la dirección a la que intenta acceder." )    
		} )	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<ArrayList<Libro>> listar() {

		ArrayList<Libro> list = new ArrayList<Libro>();
		ResponseEntity<ArrayList<Libro>> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		try {
			list = (ArrayList<Libro>) serviceLibro.listar();
			response = new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			LOG.error(e);
		}

		return response;
	}

	@ApiOperation( 
		    value = "Lista un libro concreto que se encuentran en la BBDD", 
		    notes = "Busqueda por <b>ID LIBRO</b>"
		)
	@ApiResponses({@ApiResponse(code = 200, message = "Acción realizada con exito"),
		    @ApiResponse( code = 404, message = "Libro no existe" )    
		} )	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Libro> detalle(@PathVariable long id) {
		ResponseEntity<Libro> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {
			Libro libro = serviceLibro.buscar(id);

			if (libro != null && libro.getId() > 0) {
				response = new ResponseEntity<>(libro, HttpStatus.OK);
			} else {
				response = new ResponseEntity<>(HttpStatus.NOT_FOUND);	
	
			}
		} catch (Exception e) {
			LOG.error(e);
		}

		return response;

	}
	@ApiOperation( 
		    value = "Elimina un libro concreto que se encuentran en la BBDD", 
		    notes = "Se requiere un <b>ID LIBRO</b> para eliminar el registro.",
    		response= Libro.class
		)
	@ApiResponses({@ApiResponse(code = 200, message = "Acción realizada con exito"),
		    @ApiResponse( code = 404, message = "El registro a eliminar no existe" ),
		    @ApiResponse( code = 409, message = "Libro esta en prestamo y no se puede eliminar." )    
		   
		} )	
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
			response = new ResponseEntity<>(new ResponseMensaje("No se puede eliminar si tiene prestamos asociados"), HttpStatus.CONFLICT);
			LOG.debug(response);
		}catch (Exception e) {
			LOG.error(e);
		}
		return response;
	}

	@ApiOperation( 
		    value = "Crea un nuevo registro para libro", 
		    notes = "Se requiere: <br>"
		    		+ "<ol><li><b>ISBN</b>comprendido entre 8 y 13 caracteres.</li>"
		    		+ "<li><b>TÍTULO</b>comprendido  entre 2 y 255 caracteres.</li>"
		    		+ "<li><b>ID EDITORIAL</b>.</li></ol>",
		    		response= Libro.class
		)
	@ApiResponses({@ApiResponse(code = 201, message = "Acción realizada con exito"),
		    @ApiResponse( code = 409, message = "Los datos introducidos no cumple con los parametros establecidos." )    
		} )
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> crear(@RequestBody Libro libro) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {

			Set<ConstraintViolation<Libro>> violations = validator.validate(libro);
			if(violations.isEmpty()) {
				 
				if (serviceLibro.crear(libro)) {
					Editorial editorial = serviceEditorial.buscar(libro.getEditorial().getId());
					libro.setEditorial(editorial);
					response = new ResponseEntity<>(libro, HttpStatus.CREATED);
				} else {
					response = new ResponseEntity<>("Los datos no son correctos. Reviselos.",HttpStatus.CONFLICT);
				}
			}else {
				ResponseMensaje mensaje = new ResponseMensaje("Los datos no son correctos");
				for (ConstraintViolation<Libro> violation : violations) {
					mensaje.addError( violation.getPropertyPath() + ": " + violation.getMessage() );
					
					
				}
				response = new ResponseEntity<>( mensaje ,  HttpStatus.CONFLICT);
			}

			
		} catch (SQLIntegrityConstraintViolationException e) {
			ResponseMensaje msj = new ResponseMensaje("Editorial no existe");			
			response = new ResponseEntity<>(msj, HttpStatus.CONFLICT);
			LOG.debug(response);
		} catch (Exception e) {
			LOG.error(e);
		}

		return response;

	}

	@ApiOperation( 
		    value = "Modifica un libro.", 
		    notes = "Se requiere un <b>ID LIBRO</b>.<br>"
		    		+ "Además los campos a modificar deben cumplir:<br>"
		    		+ "<ol><li><b>ISBN</b>comprendido entre 8 y 13 caracteres.</li>"
		    		+ "<li><b>TÍTULO</b>comprendido  entre 2 y 255 caracteres.</li>"
		    		+ "<li><b>ID EDITORIAL</b>.</li></ol>",
		    		response= Libro.class
		)
	@ApiResponses({@ApiResponse(code = 201, message = "Acción realizada con exito"),
		    @ApiResponse( code = 409, message = "Los datos introducidos no cumplen las condiciones especificadas." )    
		} )
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> modificar(@PathVariable long id, @RequestBody Libro libro) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {
			
			Set<ConstraintViolation<Libro>> violations =  validator.validate(libro);
			if ( violations.isEmpty() ) {
			
				libro.setId(id);			
				if ( serviceLibro.modificar(libro) ) {
					Editorial editorial = serviceEditorial.buscar(libro.getEditorial().getId());
					libro.setEditorial(editorial);
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
			
			response = new ResponseEntity<>( new ResponseMensaje("La editorial no existe en la BBDD")  ,HttpStatus.CONFLICT);
			LOG.debug(response);
		}catch (Exception e) {
			LOG.error(e);
		}
		return response;
	}
}
