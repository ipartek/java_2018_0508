package com.ipartek.formacion.prestamos.api.controller;

import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLSyntaxErrorException;
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

import com.ipartek.formacion.libros.service.ServiceEditorial;
import com.ipartek.formacion.libros.pojo.Editorial;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/editoriales")
public class EditorialesController {
	
	private static final ResponseEntity<Object> BAD_REQUEST_RESPONSE = new ResponseEntity<Object>(new String("ERROR DE SYNTAXIS: Alguno de los campos no es el esperado."), HttpStatus.BAD_REQUEST);
	private static final ResponseEntity<Object> CONFLICT_RESPONSE = new ResponseEntity<Object>(new String("CONFLICTO: El registro ya existe en la base de datos."),HttpStatus.CONFLICT);
	private static final ResponseEntity<Object> NOT_FOUND_RESPONSE = new ResponseEntity<Object>(new String("NO ENCONTRADO: El recurso no existe."), HttpStatus.NOT_FOUND);
	private static final ResponseEntity<Object> INTERNAL_SERVER_ERROR_RESPONSE =  new ResponseEntity<Object>(new String("ERROR INTERNO: No controlado."), HttpStatus.INTERNAL_SERVER_ERROR);
	
	private static ServiceEditorial servicio;
	private static Editorial editorial;
	
	private static ValidatorFactory factory;
	private static Validator validator;
	
	public EditorialesController() {
		super();
		servicio = ServiceEditorial.getInstance();
		
		//Crear Factoria y Validador
		 factory = Validation.buildDefaultValidatorFactory();
		 validator = factory.getValidator();
		 
	}

	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Editorial>> listado() {

		ResponseEntity<ArrayList<Editorial>> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

		try {
			
			response = new ResponseEntity<ArrayList<Editorial>>((ArrayList<Editorial>) servicio.listar(), HttpStatus.OK);
		
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
			
			editorial = servicio.obtener(id);
			
			if (editorial != null && editorial.getId() > 0) {
				
				response = new ResponseEntity<Object>(editorial, HttpStatus.OK);
			
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
	public ResponseEntity<Object> crear(@RequestBody Editorial editorial) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
		
		try {
			
			Set<ConstraintViolation<Editorial>> violations = validator.validate(editorial);
			
			if (violations.size() == 0) {
				
				if (servicio.crear(editorial)) {
					
					response = new ResponseEntity<Object>(editorial, HttpStatus.CREATED);
				
				}
				
			} else {
				
				ArrayList<String> msgs = new ArrayList<String>();
				
				for (ConstraintViolation<Editorial> v : violations) {
					
					msgs.add(v.getMessage());
					
				}
				
				ResponseMessage msg = new ResponseMessage("El campo no tiene una longitud adecuada.", msgs);
				response = new ResponseEntity<Object>(msg, HttpStatus.BAD_REQUEST);	
			}
			
		} catch (SQLSyntaxErrorException e) {
			
			response = BAD_REQUEST_RESPONSE;
			e.printStackTrace();
			
		} catch (SQLIntegrityConstraintViolationException e) {
			
			response = CONFLICT_RESPONSE;
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
				
				response = new ResponseEntity<Object>(new String("SUCCESS: Eliminado."), HttpStatus.NO_CONTENT);
			
			} else {
				
				response = NOT_FOUND_RESPONSE;
				
			}

		} catch (SQLSyntaxErrorException e) {
			
			response = BAD_REQUEST_RESPONSE;
			e.printStackTrace();
			
		} catch (Exception e) {
			
			response = INTERNAL_SERVER_ERROR_RESPONSE;
			e.printStackTrace();
		}

		return response;
	}


	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> modificar(@PathVariable long id, @RequestBody Editorial editorial) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
		editorial.setId(id);
		
		try {
			
			if (servicio.modificar(editorial)) {
				
				response = new ResponseEntity<Object>(editorial, HttpStatus.OK);
			
			} else {
				
				response = NOT_FOUND_RESPONSE;
				
			}
			
		} catch (SQLSyntaxErrorException e) {
			
			response = BAD_REQUEST_RESPONSE;
			e.printStackTrace();
			
		} catch (SQLIntegrityConstraintViolationException e) {
			
			response = new ResponseEntity<Object>(HttpStatus.CONFLICT);
			e.printStackTrace();
				
		} catch (Exception e) {
			
			response = new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}

		return response;

	}

}
