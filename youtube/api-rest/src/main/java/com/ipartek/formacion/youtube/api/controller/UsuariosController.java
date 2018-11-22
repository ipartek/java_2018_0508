package com.ipartek.formacion.youtube.api.controller;

import java.util.ArrayList;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.youtube.pojo.UsuarioPrivado;
import com.ipartek.formacion.youtube.service.IServiceUsuario;
import com.ipartek.formacion.youtube.service.impl.ServiceUsuario;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "*") // Para poder habilitar CORS, para hacer llamadas en JavaScript
@RestController
@RequestMapping("/usuarios")
@Api(tags = "Usuari@s", produces = "application/json", description = "Gestión de Usuari@s")
public class UsuariosController {
	ValidatorFactory factory = null;
	Validator validator = null;
	IServiceUsuario servicioUsuario = null;
	private final static Logger LOG = Logger.getLogger(UsuariosController.class);

	public UsuariosController() {
		super();
		servicioUsuario = ServiceUsuario.getInstance();

		// Crear factoria y validador
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();

	}

	@ApiOperation(value = "Listado de usuari@s")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Usuari@s encontrad@s"),
			@ApiResponse(code = 204, message = "La lista de Usuari@s se encuentra vacia") })
	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public ResponseEntity<ArrayList<UsuarioPrivado>> listar() {
		// ResponseEntity es una response que se compone de dos parametros,1-un mensaje
		// , 2-código de estado
		ResponseEntity<ArrayList<UsuarioPrivado>> response = new ResponseEntity<ArrayList<UsuarioPrivado>>(
				HttpStatus.INTERNAL_SERVER_ERROR);

		try {
			ArrayList<UsuarioPrivado> usuarios = (ArrayList<UsuarioPrivado>) servicioUsuario.listar();

			if (usuarios != null && usuarios.size() > 1) {
				response = new ResponseEntity<ArrayList<UsuarioPrivado>>(usuarios, HttpStatus.OK);
			} else {
				response = new ResponseEntity<ArrayList<UsuarioPrivado>>(HttpStatus.NO_CONTENT);

			}
		} catch (Exception e) {
			LOG.error(e);
		}

		return response;

	}

	@ApiOperation(value = "Detalle de un/a usuari@", response = UsuarioPrivado.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Usuari@ encontrad@"),
			@ApiResponse(code = 404, message = "El/La usuari@  no existe") })
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<UsuarioPrivado> detalle(@PathVariable long id) {
		ResponseEntity<UsuarioPrivado> response = new ResponseEntity<UsuarioPrivado>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {

			UsuarioPrivado usuario = servicioUsuario.buscarPorId(id);
			if (usuario != null && usuario.getId() > 0) {
				response = new ResponseEntity<UsuarioPrivado>(usuario, HttpStatus.OK);
			} else {
				response = new ResponseEntity<UsuarioPrivado>(HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			LOG.error(e);

		}
		return response;

	}
}
