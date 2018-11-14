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

import com.ipartek.formacion.prestamos_libros.pojo.Editorial;
import com.ipartek.formacion.prestamos_libros.pojo.Usuario;
import com.ipartek.formacion.prestamos_libros.service.ServiceUsuario;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/alumnos")
public class AlumnosController {

	ServiceUsuario serviceUsuario = null;
	ValidatorFactory factory = null;
	Validator validator = null;

	public AlumnosController() {
		super();
		serviceUsuario = ServiceUsuario.getInstance();
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
	
	@ApiOperation(value = "Listado Alumnos")
	@ApiResponses( value = {
			@ApiResponse (code = 200, message = "Listado Alumnos"),
			@ApiResponse (code = 404, message = "No se encontro Alumno")}
	)

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Usuario>> listado() {

		ArrayList<Usuario> list = new ArrayList<Usuario>();
		ResponseEntity<ArrayList<Usuario>> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {

			list = (ArrayList<Usuario>) serviceUsuario.listar();
			response = new ResponseEntity<>(list, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}
	
	@ApiOperation(value = "Detalle Alumno")
	@ApiResponses( value = {
			@ApiResponse (code = 200, message = "Detalle Alumno"),
			@ApiResponse (code = 404, message = "No se encontro Alumno valor incorrecto"),
			@ApiResponse (code = 409, message = "Caracteres vacios")}
	)

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Usuario> detalle(@PathVariable long id) {

		ResponseEntity<Usuario> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {
			
			Usuario usuario = serviceUsuario.buscarId(id);
			if ( usuario != null && usuario.getId() > 0 ) {
				response = new ResponseEntity<>(usuario, HttpStatus.OK);
			}else {
				response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
	
	
	@ApiOperation(value = "Eliminar Alumno")
	@ApiResponses( value = {
			@ApiResponse (code = 200, message = "Eliminar Alumno"),
			@ApiResponse (code = 404, message = "No se encontro Alumno"),
			@ApiResponse (code = 409, message = "No se puede eliminar Alumno si esta asociado a un libro")}
	)
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> eliminar(@PathVariable long id) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {
						
			if ( serviceUsuario.eliminar(id) ) {
				response = new ResponseEntity<>(HttpStatus.OK);
			}else {
				response = new ResponseEntity<>(new ResponseMensaje("Usuario Eliminado"), HttpStatus.NOT_FOUND);
			}
		
		}catch( SQLIntegrityConstraintViolationException e ) {	
			response = new ResponseEntity<>(new ResponseMensaje("No se puede eliminar si tiene Libors asociados"), HttpStatus.CONFLICT);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	@ApiOperation(value = "Crear Alumno")
	@ApiResponses( value = {
			@ApiResponse (code = 201, message = "Crear Alumno"),
			@ApiResponse (code = 409, message = "Esta vacio Alumno o el Nombre alumno ya existe")}
	)
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> crear(@RequestBody Usuario usuario) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {
			
			Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);
	
			if ( violations.isEmpty() ) {
			
				if ( serviceUsuario.crear(usuario) ) {
					response = new ResponseEntity<>(usuario, HttpStatus.CREATED);
				}else {
					response = new ResponseEntity<>(HttpStatus.CONFLICT);
				}
				
			}else {
				ResponseMensaje mensaje = new ResponseMensaje("Los datos no son correctos");
				for ( ConstraintViolation<Usuario> v : violations ) {
					mensaje.addError( v.getPropertyPath() + ": " + v.getMessage() );
				};
				response = new ResponseEntity<>( mensaje ,  HttpStatus.CONFLICT);
			}	
		
		}catch ( SQLIntegrityConstraintViolationException e) {
			
			
			ResponseMensaje msj = new ResponseMensaje("Ya existe el Usuario, por favor prueba con otro nombre");			
			response = new ResponseEntity<>(msj, HttpStatus.CONFLICT);
			
		}catch (Exception e) {
			//TODO gestionar duplicate key entry
			e.printStackTrace();
		}
		return response;
	}
	
	
	
	@ApiOperation(value = "Modificar Alumno")
	@ApiResponses( value = {
			@ApiResponse (code = 201, message = "Modificar Alumno"),
			@ApiResponse (code = 404, message = "No se encontro Alumno"),
			@ApiResponse (code = 409, message = "No se puede modificar alumno con el mismo nombre o que esta vacio")}
	)
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> modificar(@PathVariable long id, @RequestBody Usuario usuario) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {
			
			Set<ConstraintViolation<Usuario>> violations =  validator.validate(usuario);
			if ( violations.isEmpty() ) {
			
				usuario.setId(id);			
				if ( serviceUsuario.modificar(usuario) ) {
					response = new ResponseEntity<>(usuario, HttpStatus.OK);
				}else {
					response = new ResponseEntity<>(HttpStatus.CONFLICT);
				}
				
			}else {
				ResponseMensaje mensaje = new ResponseMensaje("Los datos no son correctos");
				for ( ConstraintViolation<Usuario> v : violations ) {
					mensaje.addError( v.getPropertyPath() + ": " + v.getMessage() );
				};
				response = new ResponseEntity<>( new ResponseMensaje("Ya existe la Usuario, por favor prueba con otro nombre"), HttpStatus.CONFLICT);
			}	
		
		}catch (SQLIntegrityConstraintViolationException e) {
			
			response = new ResponseEntity<>( new ResponseMensaje("Ya existe la Usuario, por favor prueba con otro nombre")  ,HttpStatus.CONFLICT);
		}catch (Exception e) {
			//TODO gestionar duplicate key entry
			e.printStackTrace();
		}
		return response;
	}


}