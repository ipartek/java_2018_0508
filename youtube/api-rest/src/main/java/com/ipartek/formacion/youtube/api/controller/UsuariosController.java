package com.ipartek.formacion.youtube.api.controller;

import java.util.ArrayList;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.youtube.pojo.Usuario;
import com.ipartek.formacion.youtube.service.IServiceUsuario;
import com.ipartek.formacion.youtube.service.impl.ServiceUsuario;

import io.swagger.annotations.Api;

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

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Usuario>> listar() {
		// ResponseEntity es una response que se compone de dos parametros,1-un mensaje
		// , 2-código de estado
		ResponseEntity<ArrayList<Usuario>> response = new ResponseEntity<ArrayList<Usuario>> (HttpStatus.INTERNAL_SERVER_ERROR);

		try {
			ArrayList<Usuario> usuarios = (ArrayList<Usuario>) servicioUsuario.listar();

			if (usuarios != null && usuarios.size() > 1) {
				response= new ResponseEntity<ArrayList<Usuario>>(usuarios, HttpStatus.OK);
			} else {
				response= new ResponseEntity<ArrayList<Usuario>> (HttpStatus.NO_CONTENT);

			}
		} catch (Exception e) {
			LOG.error(e);
		}

		return response;

	}

}
