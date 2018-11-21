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

import com.ipartek.formacion.youtube.impl.ServiceUsuario;
import com.ipartek.formacion.youtube.pojo.Usuario;
import com.ipartek.formacion.youtube.service.IServiceUsuario;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "*") // Para habilitar post habilita llamadas ajasx
@RestController
@RequestMapping("/usuarios")
@Api(tags = { "Servicio /usuarios" }, description = "Clase AlumnosController", consumes = "application/json")
public class UsuarioController {

	IServiceUsuario serviceUsuario = null;
	ValidatorFactory factory = null;
	Validator validator = null;

	private final static Logger LOG = Logger.getLogger(UsuarioController.class);

	public UsuarioController() {
		super();
		serviceUsuario = ServiceUsuario.getInstance();
		// Crear Factoria y Validador
		factory = Validation.buildDefaultValidatorFactory();
		validator = (Validator) factory.getValidator();

	}

	/**
	 * Entidad que va a responder json y codigo de estado 2 parametros cuerpo con
	 * los datos arraylist y el codigo http
	 * 
	 * @return
	 */
	@ApiOperation(value = "Listado de alumnos", notes = "Obtener todos los alumnos en json", nickname = "listado", responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Listado de alumnos ok"),
			@ApiResponse(code = 400, message = "Error "), @ApiResponse(code = 401, message = "No autorizado "),
			@ApiResponse(code = 404, message = "No encontrado ") })
	@ApiParam(required = false, name = "Blabla ?", defaultValue = "1")
	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Usuario>> listado() {

		ArrayList<Usuario> list = new ArrayList<Usuario>();

		ResponseEntity<ArrayList<Usuario>> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		try {

			list = (ArrayList<Usuario>) serviceUsuario.listar();
			
			if (list != null && list.size() > 1) {

				response = new ResponseEntity<>(list, HttpStatus.OK);
			} else {
				
				//Para cuando por la razon que sea nos viene el resultado vacio o nulo
				response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

		} catch (Exception e) {
			
			LOG.error(e.getMessage());

		}

		return response;
	}

}
