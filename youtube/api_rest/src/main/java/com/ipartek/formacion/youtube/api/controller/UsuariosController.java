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
import com.ipartek.formacion.youtube.pojo.UsuarioPublico;
import com.ipartek.formacion.youtube.service.IServiceUsuario;
import com.ipartek.formacion.youtube.service.impl.ServiceUsuario;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "*") //Para poder habilitar CORS cuando hagamos llamadas en javascript
@RestController
@RequestMapping("/usuarios")
@Api(tags = { "Usuarios" }, produces = "application/json", description="Gestión de usuarios")
public class UsuariosController {
	
	private final static Logger LOG = Logger.getLogger(UsuariosController.class);
	IServiceUsuario serviceUsuario = null;
	
	//Para las validaciones
	ValidatorFactory factory = null;
	Validator validator = null;

	public UsuariosController() {
		super();
		serviceUsuario = ServiceUsuario.getInstance();
		
		//Crear Factoria y Validador
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	
	}
	
	@RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
	@ApiOperation(value = "Listado de usuarios")
	@ApiResponses(value = { 
							@ApiResponse(code = 200, message = "Listado de usuarios."),
							@ApiResponse(code = 204, message = "No hay usuarios en la lista."),
							@ApiResponse(code = 500, message = "Error fatal.") }
				)
	public ResponseEntity<ArrayList<UsuarioPublico>> listar(){	//ResponseEntity es una respuesta con dos parámetros en 
														//una se pasa un mensaje String y en otro un código de estado HTTP.
		
		ResponseEntity<ArrayList<UsuarioPublico>> response = new ResponseEntity<ArrayList<UsuarioPublico>>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		try {
			ArrayList<UsuarioPublico> usuarios = (ArrayList<UsuarioPublico>) serviceUsuario.listarPublicos();
			
			if(usuarios != null && usuarios.size() > 1) {
				response = new ResponseEntity<ArrayList<UsuarioPublico>>(usuarios, HttpStatus.OK);

			}else {
				response = new ResponseEntity<ArrayList<UsuarioPublico>>(HttpStatus.NO_CONTENT);
			}

		} catch (Exception e) {
			LOG.error(e);
		}
		
		return response;
	}
	
	@RequestMapping(value = {"/{idUsuario}"}, method = RequestMethod.GET)
	@ApiOperation(value = "Detalle de un usuario")
	@ApiResponses(value = { 
							@ApiResponse(code = 200, message = "Detalle del usuario."),
							@ApiResponse(code = 404, message = "No existe usuario."),
							@ApiResponse(code = 500, message = "Error fatal.") }
				)
	@ApiParam(value="id", required=true)
	public ResponseEntity<Usuario> detalle(//ResponseEntity es una respuesta con dos parámetros en una se pasa un mensaje String y en otro un código de estado HTTP.
			@ApiParam(value="Id del usuario.", required=true)
			@PathVariable("idUsuario") long id){	
														
		
		ResponseEntity<Usuario> response = new ResponseEntity<Usuario>(HttpStatus.INTERNAL_SERVER_ERROR);
		Usuario usuario = new Usuario();
		
		try {

			usuario = serviceUsuario.buscarPorId(id);
			
			if(usuario != null && usuario.getId() > 0) {
				response = new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
			}else {
				response = new ResponseEntity<Usuario>(usuario, HttpStatus.NOT_FOUND);
				LOG.debug("El usuario no existe.");
			}

		} catch (Exception e) {
			LOG.error(e);
		}
		
		return response;
	}
	
	@RequestMapping(value = "/{idUsuario}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Eliminar un usuario", response = Usuario.class)
	@ApiResponses(value = { 
							@ApiResponse(code = 200, message = "Usuario eliminada"),
							@ApiResponse(code = 404, message = "El usuario no existe"),
							@ApiResponse(code = 409, message = "No podemos eliminar el usuario, ya que tiene uno o más videos asociados."),
							@ApiResponse(code = 500, message = "Error fatal")  
							}
				)
	@ApiParam(value="id", name="id", required=true)
	public ResponseEntity<Object> eliminar(
			@ApiParam(value="Id del usuario", required=true)
			@PathVariable("idUsuario") long id) {
		
		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
		
		try {
			
			if(serviceUsuario.eliminar(id)) {
				response = new ResponseEntity<>(HttpStatus.OK);
			}else {
				response = new ResponseEntity<>(new ResponseMensaje("El usuario no existe."), HttpStatus.NOT_FOUND);
				LOG.debug("El usuario no existe.");
			}
			
		}catch(SQLIntegrityConstraintViolationException e){
			response = new ResponseEntity<>(new ResponseMensaje("No podemos eliminar el usuario, ya que tiene uno o más videos asociados."), HttpStatus.CONFLICT);
			LOG.debug("No podemos eliminar el usuario, ya que tiene uno o más videos asociados.");
		} catch (Exception e) {
			LOG.error(e);
		}
		
		return response;	
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value = "Crear un usuario", response = Usuario.class,
				  notes="Campos obligatorios:"
				  	  + "<ol>"
				  	  + "<li><b>usuario.nombre</b> Nombre(nick) del usuario</li>"
				  	  + "<li><b>usuario.pass</b> Contraseña del usuario</li>"
				  	  + "</ol>")
	@ApiResponses(value = { 
							@ApiResponse(code = 201, message = "Usuario creado."),
							@ApiResponse(code = 409, message = "El usuario ya existe."),
							@ApiResponse(code = 400, message = "<ol>"
															 + "<li>El nombre no puede estar vacío y debe contener entre 2 y 50 caracteres.</li>"
															 + "<li>La password no puede estar vacía y debe contener entre 6 y 20 caracteres.</li>"),
							@ApiResponse(code = 500, message = "Error fatal.")  
							}
				)
	public ResponseEntity<Object> crear(@RequestBody Usuario usuario) {
		
		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		ResponseMensaje msg = new ResponseMensaje();
		
		try {
			
			Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);
			if(violations.isEmpty()) {
				
				if(serviceUsuario.crear(usuario)) {
					response = new ResponseEntity<>(usuario, HttpStatus.CREATED);
				}else {
					response = new ResponseEntity<>(usuario, HttpStatus.CONFLICT);
				}
				
			}else {

				msg.setMensaje("No se pudo crear el usuario");
				
				for (ConstraintViolation<Usuario> violation : violations) {
					
					msg.addError(violation.getPropertyPath() + ": " + violation.getMessage());
				}
				
				response = new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
			}
			
		
		} catch (Exception e) {
			
			if(e.getMessage().contains("SQLIntegrityConstraintViolationException")){
				response = new ResponseEntity<>(new ResponseMensaje("El usuario ya existe."), HttpStatus.CONFLICT);
				LOG.debug("El usuario ya existe.");
				
			}
			LOG.error(e);
		}
		
		return response;	
		
	}
	
	@RequestMapping(value = "/{idUsuario}", method = RequestMethod.PUT)
	@ApiOperation(value = "Modificar una editorial", response = Usuario.class)
	@ApiResponses(value = { 
							@ApiResponse(code = 200, message = "Usuario modificado"),
							@ApiResponse(code = 404, message = "El usuario no existe"),
							@ApiResponse(code = 409, message = "El usuario ya existe."),
							@ApiResponse(code = 400, message = "<ol>"
															 + "<li>El nombre no puede estar vacío y debe contener entre 2 y 50 caracteres.</li>"
															 + "<li>La password no puede estar vacía y debe contener entre 6 y 20 caracteres.</li>"
															 + "</ol>"),
							@ApiResponse(code = 500, message = "Error fatal")  
							}
				)
	@ApiParam(value="id", required=true)
	public ResponseEntity<Object> modificar(
			@ApiParam(value="Id de la editorial", required=true)
			@PathVariable("idUsuario") long id, @RequestBody Usuario usuario) {
		
		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		ResponseMensaje msg = new ResponseMensaje();
		
		try {
			
			Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);
			if(violations.isEmpty()) {
				
				usuario.setId(id);
				
				if(serviceUsuario.modificar(usuario)) {
					response = new ResponseEntity<>(usuario, HttpStatus.OK);
				}else {
					response = new ResponseEntity<>(new ResponseMensaje("El usuario no existe."), HttpStatus.NOT_FOUND);
					LOG.debug("El usuario no existe.");
				}
				
			}else {

				msg.setMensaje("No se pudo modificar el usuario");
				
				for (ConstraintViolation<Usuario> violation : violations) {
					
					msg.addError(violation.getPropertyPath() + ": " + violation.getMessage());
				}
				
				response = new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
			}
			
		
		} catch (Exception e) {
			
			if(e.getMessage().contains("SQLIntegrityConstraintViolationException")){
				response = new ResponseEntity<>(new ResponseMensaje("El usuario ya existe."), HttpStatus.CONFLICT);
				LOG.debug("El usuario ya existe.");
				
			}
			LOG.error(e);
		}
		
		return response;	
		
	}
	
}
