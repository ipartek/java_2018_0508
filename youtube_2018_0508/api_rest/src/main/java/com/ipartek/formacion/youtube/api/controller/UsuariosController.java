package com.ipartek.formacion.youtube.api.controller;

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

import com.andrea.perez.youtube.pojo.Usuario;
import com.andrea.perez.youtube.service.IServiceUsuario;
import com.andrea.perez.youtube.service.impl.ServicioUsuario;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@CrossOrigin(origins = "*") //Es para poder habilitar CORS(Control de Acceso HTTP), para llamadas de javaScript(Permite que cualquier servidor llame a la app)
@RestController
@RequestMapping("/usuarios")
@Api(tags = "USUARIOS", produces = "aplication/json", description = "Gestion de usuarios") //Documentar
public class UsuariosController {
	
	private final static Logger LOG = Logger.getLogger(UsuariosController.class);
	
	IServiceUsuario serviceUsuario = null;
	
	ValidatorFactory factory = null;
	Validator validator = null;

	public UsuariosController() {
		super();
		
		serviceUsuario = ServicioUsuario.getInstance();
		// Crear Factoria y Validador
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
		
	}

	@ApiOperation(value = "Listado de usuarios")
	@ApiResponses(value = { @ApiResponse(code = 200, message = " Listado usuarios"),
			@ApiResponse(code = 204, message = " Sin registro") })
	@RequestMapping(method = RequestMethod.GET)
	//@RequestMapping(value= {"/",""},method = RequestMethod.GET)				//Escrucha en 2 mapping value= / y sin value
	public ResponseEntity<ArrayList<Usuario>> listar() {

		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		ResponseEntity<ArrayList<Usuario>> response = new ResponseEntity<ArrayList<Usuario>>(HttpStatus.INTERNAL_SERVER_ERROR);

		try {

			usuarios = (ArrayList<Usuario>) serviceUsuario.listar();
				
			 if(usuarios!= null && usuarios.size()>0) {
				response = new ResponseEntity<>(usuarios, HttpStatus.OK); //devuelve 2 param: el cuerpo en este caso  y codigo
			}else {
				response = new ResponseEntity<>(HttpStatus.NO_CONTENT); 
			}

		} catch (Exception e) {
			LOG.error(e);
		}

		return response;
	}
	
	

	@ApiOperation(value = "Obtener usuario por su identificador")
	@ApiResponses(value = { @ApiResponse(code = 200, message = " usuario encontrado"),
			@ApiResponse(code = 404, message = " No se encontró el usuario deseado") })
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> buscarPorId(@PathVariable long id) throws Exception {
		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
		Usuario usuario = new Usuario();
		usuario = serviceUsuario.buscarPorId(id);

		if (usuario != null && usuario.getId() > 0) {

			response = new ResponseEntity<>(usuario, HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(
					new ResponseMensaje("No se ha encotrado ningun registro, cambie de identificador"),
					HttpStatus.NOT_FOUND);
			LOG.debug("No se ha encotrado ningun registro, cambie de identificador");
		}

		return response;
	}

	@ApiOperation(value = "Eliminar usuario por su identificador")
	@ApiResponses(value = { @ApiResponse(code = 200, message = " usuario eliminado correctamente"),
			@ApiResponse(code = 404, message = " No se encontró el usuario deseado"),
			@ApiResponse(code = 409, message = " No se puede eliminar el usuario, porque tiene algun video asociado")})
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> eliminar(@PathVariable long id) throws Exception {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

		try {

			if (serviceUsuario.eliminar(id)) {
				response = new ResponseEntity<>(HttpStatus.OK);
			} else {
				response = new ResponseEntity<>(
						new ResponseMensaje(""),
						HttpStatus.NOT_FOUND);
				LOG.debug("No se ha encontrado ningun registro, cambie de identificador");
			}

		} catch (MySQLIntegrityConstraintViolationException e) {

			response = new ResponseEntity<>(
					new ResponseMensaje(
							"No es posible eliminar el registro deseado porque tiene algun prestamo pendiente."),
					HttpStatus.CONFLICT);
			LOG.debug("No es posible eliminar el registro deseado porque tiene algun prestamo pendiente.");

		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e);
		}
		return response;
	}

	@ApiOperation(value = "Crear usuario ",notes="Parametros a ingresar: <ol><li>nombre usuario</li><li>contraseña</li></ol>" ,response = Usuario.class)
	@ApiResponses(value = { @ApiResponse(code = 201, message = " usuario creado"),
			@ApiResponse(code = 409, message = " <ol><li>El nombre del usuario ya existe.</li><li>No cumple validaciones.</li></ol>") })
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> crear(@RequestBody Usuario usuario) throws Exception {
		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		ResponseMensaje responseMensaje = new ResponseMensaje();

		try {

			Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);
			if (violations.size() > 0) {
				/* No ha pasado la valiadacion, iterar sobre los mensajes de validacion */

				ArrayList<String> errores = new ArrayList<>();
				for (ConstraintViolation<Usuario> violation : violations) {
					errores.add(violation.getPropertyPath() + ": " + violation.getMessage());

				}
				responseMensaje.setErrores(errores);
				responseMensaje.setMensaje("Datos no validos");

				response = new ResponseEntity<>(responseMensaje, HttpStatus.CONFLICT);
				LOG.debug("Datos no validos");
			} else {
				if (serviceUsuario.crear(usuario)) {
					
					response = new ResponseEntity<>(usuario, HttpStatus.CREATED);
				} else {
					response = new ResponseEntity<>(HttpStatus.CONFLICT);
					LOG.debug("No se pudo crear el alumno");

				}
			}

		} catch (MySQLIntegrityConstraintViolationException e) {

			response = new ResponseEntity<>(
					new ResponseMensaje("Ya existe el nombre usuario,Por favor prueba con otro nombre."), HttpStatus.CONFLICT);
			LOG.debug("Ya existe el usuario,Por favor prueba con otro nombre.");

		} catch (Exception e) {

			LOG.error(e);
		}
		return response;
	}

	@ApiOperation(value = "Modificar usuario")
	@ApiResponses(value = { @ApiResponse(code = 200, message = " usuario modificado correctamente"),
			@ApiResponse(code = 404, message = " No se encontró el usuaRIO"),
			@ApiResponse(code = 409, message = " Puede que el nombre del usuario esté vacío o el nombre del usuario ya existe") })
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> modificar(@PathVariable long id, @RequestBody Usuario usuario) throws Exception {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
		ResponseMensaje responseMensaje = new ResponseMensaje();

		try {
			usuario.setId(id);
			Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);
			if (violations.size() > 0) {
				/* No ha pasado la valiadacion, iterar sobre los mensajes de validacion */

				ArrayList<String> errores = new ArrayList<>();
				for (ConstraintViolation<Usuario> violation : violations) {
					errores.add(violation.getPropertyPath() + ": " + violation.getMessage());

				}
				responseMensaje.setErrores(errores);
				responseMensaje.setMensaje("Datos no validos");

				response = new ResponseEntity<>(responseMensaje, HttpStatus.CONFLICT);
				LOG.debug("Datos no validos");
			} else {
				if (serviceUsuario.modificar(usuario)) {
					response = new ResponseEntity<>(usuario, HttpStatus.OK);
				} else {
					response = new ResponseEntity<>(
							new ResponseMensaje("No se ha encotrado ningun registro, cambie de identificador"),
							HttpStatus.NOT_FOUND);
					LOG.debug("No se ha encotrado ningun registro, cambie de identificador");
				}
			}

		} catch (MySQLIntegrityConstraintViolationException e) {

			response = new ResponseEntity<>(
					new ResponseMensaje("Ya existe el usuario,Por favor prueba con otro nombre."), HttpStatus.CONFLICT);
			LOG.debug("Ya existe el usuario,Por favor prueba con otro nombre");
		} catch (Exception e) {
			LOG.error(e);
		}
		return response;
	}

}
