package com.ipartek.formacion.youtube.api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.youtube.pojo.Usuario;
import com.ipartek.formacion.youtube.servicio.impl.ServiceUsuario;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

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

@Api(tags = { "Usuarios" }, produces = "application/json", description = "Gestión Usuarios")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

	ServiceUsuario serviceUsuario = null;
	ValidatorFactory factory = null;
	Validator validator = null;

	// Logger
	private final static Logger LOG = Logger.getLogger(UsuariosController.class);

	public UsuariosController() {
		super();
		LOG.trace("Constructor");
		serviceUsuario = ServiceUsuario.getInstance();
		LOG.trace("Servicio usuario instanciado");

		// Crear Factoria y Validador
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@ApiOperation(value = "Listado de usuarios", notes = "Muestra el listado de todos los usuarios", produces = "application/json")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Listado usuarios mostrado"), 
							@ApiResponse(code = 204, message = "Listado vacío")})
	@RequestMapping(value= {"/", ""}, method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Usuario>> listado() {
		ResponseEntity<ArrayList<Usuario>> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

		try {
			usuarios = (ArrayList<Usuario>) serviceUsuario.listar();
			if(usuarios != null && usuarios.size() > 0) {
				response = new ResponseEntity<>(usuarios, HttpStatus.OK);
				LOG.debug("Listado de usuarios devuelto " + usuarios.size());
			}else {
				response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
				LOG.debug("No se han encontrado usuarios");
			}
			
		} catch (Exception e) {
			LOG.error(e);
		}

		return response;
	}

}
