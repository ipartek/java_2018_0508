package com.ipartek.formacion.youtube.api.controller;

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

import com.ipartek.formacion.youtube.pojo.Usuario;
import com.ipartek.formacion.youtube.service.IServiceUsuario;
import com.ipartek.formacion.youtube.service.impl.ServiceUsuario;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "*") 
@RestController
@RequestMapping("/usuarios")
@Api(tags = { "USUARIOS" }, produces = "application/json", description="Gestión de Usuarios")
public class UsuariosController {
	
	private final static Logger LOG = Logger.getLogger(UsuariosController.class);	
	IServiceUsuario serviceUsuario = null;	
	ValidatorFactory factory = null;
	Validator validator = null;

	public UsuariosController() {
		super();
		serviceUsuario = ServiceUsuario.getInstance();
		
		//Crear Factoria y Validador
		 factory = Validation.buildDefaultValidatorFactory();
		 validator = factory.getValidator();
	}

	@ApiOperation(value = "Listado Usuarios")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Listado Usuarios"),
			@ApiResponse(code = 204, message = "No se encontro Usuario")})
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Usuario>> listar() {
		
		ResponseEntity<ArrayList<Usuario>> response = new ResponseEntity<ArrayList<Usuario>>(HttpStatus.INTERNAL_SERVER_ERROR );
		try {
			ArrayList<Usuario> usuarios = (ArrayList<Usuario>) serviceUsuario.listar();
			
			if ( usuarios != null && usuarios.size() > 1 ) {
				response = new ResponseEntity<ArrayList<Usuario>>(usuarios, HttpStatus.OK );
			}else {
				response = new ResponseEntity<ArrayList<Usuario>>(HttpStatus.NO_CONTENT );
			}	
		}catch (Exception e) {
			LOG.error(e);
		}			
		return response;
	}
	
	@ApiOperation(value = "Detalle Usuario")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Detalle Usuario"),
			@ApiResponse(code = 404, message = "No se encontro Usuario")})

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Usuario> detalle(@PathVariable long id) {

		ResponseEntity<Usuario> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {

			Usuario usuario = serviceUsuario.buscarPorId(id);
			if (usuario != null && usuario.getId() > 0) {
				response = new ResponseEntity<>(usuario, HttpStatus.OK);
			} else {
				response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			LOG.error(e);
		}
		return response;
	}
	
	@ApiOperation(value = "Crear Usuario", response = Usuario.class)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Usuario Creado"),
			@ApiResponse(code = 400, message = "No cumple validaciones"),
			@ApiResponse(code = 409, message = "El nombre del alumno no puede estar repetido") })
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> crear(@RequestBody Usuario usuario) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {

			Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);

			if (violations.isEmpty()) {

				if (serviceUsuario.crear(usuario)) {
					response = new ResponseEntity<>(usuario, HttpStatus.CREATED);
				} else {
					response = new ResponseEntity<>(HttpStatus.CONFLICT);
				}

			} else {
				ResponseMensaje mensaje = new ResponseMensaje("Los datos no son correctos");
				for (ConstraintViolation<Usuario> v : violations) {
					mensaje.addError(v.getPropertyPath() + ": " + v.getMessage());
				}
				;
				response = new ResponseEntity<>(mensaje, HttpStatus.CONFLICT);
			}

		} catch (SQLIntegrityConstraintViolationException e) {
			LOG.debug(response);
			ResponseMensaje msj = new ResponseMensaje("Ya existe el Usuario, por favor prueba con otro nombre");
			response = new ResponseEntity<>(msj, HttpStatus.CONFLICT);

		} catch (Exception e) {
			// TODO gestionar duplicate key entry
			LOG.error(e);
		}
		return response;
	}
	
	@ApiOperation(value = "Modificar Usuario", response = Usuario.class)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Modificar Usuario"),
			@ApiResponse(code = 400, message = "No cumple validaciones"),
			@ApiResponse(code = 404, message = "No se encontro Usuario"),
			@ApiResponse(code = 409, message = "El nombre del alumno no puede estar repetido") })

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> modificar(@PathVariable long id, @RequestBody Usuario usuario) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {

			Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);
			if (violations.isEmpty()) {

				usuario.setId(id);
				if (serviceUsuario.modificar(usuario)) {
					response = new ResponseEntity<>(usuario, HttpStatus.OK);
				} else {
					response = new ResponseEntity<>(HttpStatus.CONFLICT);
				}

			} else {
				ResponseMensaje mensaje = new ResponseMensaje("Los datos no son correctos");
				for (ConstraintViolation<Usuario> v : violations) {
					mensaje.addError(v.getPropertyPath() + ": " + v.getMessage());
				}
				;
				response = new ResponseEntity<>(
						new ResponseMensaje("Ya existe el Usuario, por favor prueba con otro nombre"),
						HttpStatus.CONFLICT);
			}

		} catch (SQLIntegrityConstraintViolationException e) {
			LOG.debug(response);
			response = new ResponseEntity<>(
					new ResponseMensaje("Ya existe el Usuario, por favor prueba con otro nombre"), HttpStatus.CONFLICT);
		} catch (Exception e) {
			// TODO gestionar duplicate key entry
			LOG.error(e);
		}
		return response;
	}
	
	@ApiOperation(value = "Eliminar Usuario")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Eliminar Usuario"),
			@ApiResponse(code = 404, message = "No se encontro Usuario"),
			@ApiResponse(code = 409, message = "No se puede eliminar Usuario si esta asociado a un video") })
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> eliminar(@PathVariable long id) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {

			if (serviceUsuario.eliminar(id)) {
				response = new ResponseEntity<>(new ResponseMensaje("Usuario Eliminado"), HttpStatus.OK);
			} else {
				response = new ResponseEntity<>(new ResponseMensaje("Usuario no encontrado"), HttpStatus.NOT_FOUND);
			}

		} catch (SQLIntegrityConstraintViolationException e) {
			LOG.debug(response);
			response = new ResponseEntity<>(new ResponseMensaje("No se puede eliminar si tiene Videos asociados"),
					HttpStatus.CONFLICT);
		} catch (Exception e) {
			LOG.error(e);
		}
		return response;
	}

}