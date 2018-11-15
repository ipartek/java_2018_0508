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

import com.ipartek.formacion.prestamos_libros.pojo.Editorial;
import com.ipartek.formacion.prestamos_libros.service.ServiceEditorial;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@Api(tags= {"Editoriales"}, produces="application/json", description="Gestion Editoriales")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/editoriales")
public class EditorialesController {
	private final static Logger LOG = Logger.getLogger(EditorialesController.class);
	
	ServiceEditorial serviceEditorial = null;
	ValidatorFactory factory = null;
	Validator validator = null;

	public EditorialesController() {
		super();
		serviceEditorial = ServiceEditorial.getInstance();
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
	
	@ApiOperation(value = "Listado Editoriales")
	@ApiResponses( value = {
			@ApiResponse (code = 200, message = "Listado Editoriales"),
			@ApiResponse (code = 404, message = "No se encontro Editoriales")}
	)

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Editorial>> listado() {

		ArrayList<Editorial> list = new ArrayList<Editorial>();
		ResponseEntity<ArrayList<Editorial>> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {

			list = (ArrayList<Editorial>) serviceEditorial.listar();
			response = new ResponseEntity<>(list, HttpStatus.OK);

		} catch (Exception e) {
			LOG.error(e);
		}

		return response;
	}
	
	@ApiOperation(value = "Detalle Editorial")
	@ApiResponses( value = {
			@ApiResponse (code = 200, message = "Detalle Editorial"),
			@ApiResponse (code = 404, message = "No se encontro Editorial valor incorrecto")}
	)

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Editorial> detalle(@PathVariable long id) {

		ResponseEntity<Editorial> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {
			
			Editorial editorial = serviceEditorial.buscarId(id);
			if ( editorial != null && editorial.getId() > 0 ) {
				response = new ResponseEntity<>(editorial, HttpStatus.OK);
			}else {
				response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
		}catch (Exception e) {
			LOG.error(e);
		}
		return response;
	}
	
	@ApiOperation(value = "Editorial Eliminado")
	@ApiResponses( value = {
			@ApiResponse (code = 200, message = "Editorial Eliminado"),
			@ApiResponse (code = 404, message = "No se encontro Editorial"),
			@ApiResponse (code = 409, message = "No se puede eliminar el editorial por que esta asociado a un libro")}
	)
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> eliminar(@PathVariable long id) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {
						
			if ( serviceEditorial.eliminar(id) ) {
				response = new ResponseEntity<>(HttpStatus.OK);
			}else {
				response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		
		}catch( SQLIntegrityConstraintViolationException e ) {	
		
			response = new ResponseEntity<>(new ResponseMensaje("No se puede eliminar si tiene Libors asociados"), HttpStatus.CONFLICT);
			LOG.debug("No se puede eliminar si tiene Libors asociados");
		}catch (Exception e) {
			LOG.error(e);
		}
		return response;
	}
	

	@ApiOperation(value = "Editorial Creado", response = Editorial.class)
	@ApiResponses( value = {
			@ApiResponse (code = 201, message = "Editorial creado"),
			@ApiResponse (code = 409, message = "<o><li>Esta vacio Editorial</li><li> Nombre editorial ya existe</li></o>")}
	)

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> crear(@RequestBody Editorial editorial) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {
			
			
			Set<ConstraintViolation<Editorial>> violations =  validator.validate(editorial);
	
			if ( violations.isEmpty() ) {
			
				if ( serviceEditorial.crear(editorial) ) {
					response = new ResponseEntity<>(editorial, HttpStatus.CREATED);
				}else {
					response = new ResponseEntity<>(HttpStatus.CONFLICT);
				}
				
			}else {
				ResponseMensaje mensaje = new ResponseMensaje("Los datos no son correctos");
				for ( ConstraintViolation<Editorial> v : violations ) {
					mensaje.addError( v.getPropertyPath() + ": " + v.getMessage() );
				};
				response = new ResponseEntity<>( mensaje ,  HttpStatus.CONFLICT);
			}	
		
		}catch ( SQLIntegrityConstraintViolationException e) {
		
			
			ResponseMensaje msj = new ResponseMensaje("Ya existe la Editorial, por favor prueba con otro nombre");			
			response = new ResponseEntity<>(msj, HttpStatus.CONFLICT);
			LOG.debug("Ya existe la Editorial, por favor prueba con otro nombre");
		}catch (Exception e) {
			LOG.error(e);
		}
		return response;
	}
	
	@ApiOperation(value = "Modificar Editorial", response = Editorial.class)
	@ApiResponses( value = {
			@ApiResponse (code = 200, message = "Modificar Editorial"),
			@ApiResponse (code = 404, message = "No se encontro Editorial"),
			@ApiResponse (code = 409, message = "<o><li>No se puede modificar editoria con el mismo nombre</li><li> Caracteres esta vacio</li></o>")}
	)

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> modificar(@PathVariable long id, @RequestBody Editorial editorial) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {
			
			Set<ConstraintViolation<Editorial>> violations =  validator.validate(editorial);
			if ( violations.isEmpty() ) {
			
				editorial.setId(id);			
				if ( serviceEditorial.modificar(editorial) ) {
					response = new ResponseEntity<>(editorial, HttpStatus.OK);
				}else {
					response = new ResponseEntity<>(HttpStatus.CONFLICT);
				}
				
			}else {
				ResponseMensaje mensaje = new ResponseMensaje("Los datos no son correctos");
				for ( ConstraintViolation<Editorial> v : violations ) {
					mensaje.addError( v.getPropertyPath() + ": " + v.getMessage() );
				};
				response = new ResponseEntity<>( mensaje ,  HttpStatus.CONFLICT);
			}	
		
		}catch (SQLIntegrityConstraintViolationException e) {
		
			response = new ResponseEntity<>( new ResponseMensaje("Ya existe la Editorial, por favor prueba con otro nombre")  ,HttpStatus.CONFLICT);
			LOG.debug("Ya existe la Editorial, por favor prueba con otro nombre");
		}catch (Exception e) {
			//TODO gestionar duplicate key entry
			LOG.error(e);
		}
		return response;
	}

}