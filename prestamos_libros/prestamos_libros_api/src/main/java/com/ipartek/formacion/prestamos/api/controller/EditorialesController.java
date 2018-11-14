package com.ipartek.formacion.prestamos.api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.prestamos_libros.pojo.Editorial;
import com.ipartek.formacion.prestamos_libros.service.ServiceEditorial;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

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

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/editoriales")
public class EditorialesController {
	
	ServiceEditorial serviceEditorial = null;
	ValidatorFactory factory = null;
	Validator validator = null;
	
	//Logger
	private final static Logger LOG = Logger.getLogger(EditorialesController.class);
	
	public EditorialesController() {
		super();
		LOG.trace("Constructor");
		serviceEditorial = ServiceEditorial.getInstance();
		LOG.trace("Servicio editorial instanciado");
		
		//Crear Factoria y Validador
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@RequestMapping( method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Editorial>> listado() {
		ResponseEntity<ArrayList<Editorial>> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		ArrayList<Editorial> editoriales = new ArrayList<Editorial>();
		
		try {
			editoriales = (ArrayList<Editorial>) serviceEditorial.listar();
			response = new ResponseEntity<>(editoriales, HttpStatus.OK);
			LOG.debug("Editoriales devueltas correctamente" + editoriales.size());
		}catch(Exception e) {
//			e.printStackTrace();
			LOG.error(e);
		}
		
		return response;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Editorial> detalle(@PathVariable long id) {
		
		ResponseEntity<Editorial> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		try {
			Editorial editorial = serviceEditorial.buscarPorId(id);
			if(editorial != null && editorial.getId() > 0) {
				response = new ResponseEntity<>(editorial, HttpStatus.OK);
				LOG.debug("Detalle editorial devuelta correctamente");
			}else {
				response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
				LOG.warn("No se ha encontrado la editorial a devolver");
			}
		}catch(Exception e) {
//			e.printStackTrace();
			LOG.error(e);
		}

		return response;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> crear(@RequestBody Editorial editorial) {
		
		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		try {
			
			Set<ConstraintViolation<Editorial>> violations = validator.validate(editorial);
			if (violations.isEmpty()) {
			    /* Ha pasado la validacion*/
				if(serviceEditorial.crear(editorial)) {
					response = new ResponseEntity<>(editorial, HttpStatus.CREATED);
					LOG.debug("Editorial creada correctamente");
				}else {
					response = new ResponseEntity<>(HttpStatus.CONFLICT);
					LOG.warn("Conflicto a la hora de crear editorial");
				}
			}else{
			    /* Hay fallos, la Validacion no es correcta */
				ResponseMensaje msj = new ResponseMensaje();
				msj.setMensaje("Los datos no son válidos.");
				 for (ConstraintViolation<Editorial> violation : violations) {
					 msj.addError(violation.getPropertyPath()+": "+violation.getMessage());
					 LOG.warn("Error de validacion al crear editorial: "+ violation.getPropertyPath()+": "+violation.getMessage());
				 }
				response = new ResponseEntity<>(msj, HttpStatus.CONFLICT);
			}
			
			
		}catch(MySQLIntegrityConstraintViolationException e) {
//			e.printStackTrace();
			LOG.error(e);
			ResponseMensaje msj = new ResponseMensaje("Ya existe la editorial, por favor prueba con otro nombre.");
			response = new ResponseEntity<>(msj, HttpStatus.CONFLICT);
		}
		catch(Exception e) {
//			e.printStackTrace();
			LOG.error(e);
		}
		 
		return response;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> modificar(@PathVariable long id, @RequestBody Editorial editorial) {
		
		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		try {
			Set<ConstraintViolation<Editorial>> violations = validator.validate(editorial);
			
			editorial.setId(id);
			
			if (violations.isEmpty()) {
			    /* Ha pasado la validacion*/
				if(serviceEditorial.modificar(editorial)) {
					response = new ResponseEntity<>(editorial, HttpStatus.OK);
					LOG.debug("Editorial modificada correctamente");
				}else {
					response = new ResponseEntity<>(HttpStatus.CONFLICT);
					LOG.warn("No se ha podido modificar la editorial por conflicto");
				}
			}else{
			    /* Hay fallos, la Validacion no es correcta */
				ResponseMensaje msj = new ResponseMensaje();
				msj.setMensaje("Los datos no son válidos.");
				 for (ConstraintViolation<Editorial> violation : violations) {
					 msj.getErrores().add(violation.getPropertyPath()+": "+violation.getMessage());
					 LOG.warn("Error de validacion al modificar editorial: "+violation.getPropertyPath()+": "+violation.getMessage());
				 }
				response = new ResponseEntity<>(msj, HttpStatus.CONFLICT);
			}
		}catch(MySQLIntegrityConstraintViolationException e) {
//			e.printStackTrace();
			LOG.error(e);
			ResponseMensaje msj = new ResponseMensaje("Ya existe la editorial, por favor prueba con otro nombre.");
			response = new ResponseEntity<>(msj, HttpStatus.CONFLICT);
		}catch(Exception e) {
//			e.printStackTrace();
			LOG.error(e);
		}
		 
		return response;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> eliminar(@PathVariable long id) {
		
		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		try {
			if(serviceEditorial.eliminar(id)) {
				response = new ResponseEntity<>(HttpStatus.OK);
				LOG.debug("Editorial eliminada correctamente");
			}else {
//				response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
				ResponseMensaje msj = new ResponseMensaje("No se puede borrar un registro que no existe");
				response = new ResponseEntity<>(msj, HttpStatus.NOT_FOUND);
				LOG.warn("No se ha encontrado la editorial a eliminar");
			}
		}catch(MySQLIntegrityConstraintViolationException e) {
//			e.printStackTrace();
			LOG.error(e);
			ResponseMensaje msj = new ResponseMensaje("No se puede borrar la editorial porque tiene libros asociados.");
			response = new ResponseEntity<>(msj, HttpStatus.CONFLICT);
		}catch(Exception e) {
//			e.printStackTrace();
			LOG.error(e);
		}
		
		return response;
	}
	
}
