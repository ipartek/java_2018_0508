package com.ipartek.formacion.gestiondocente.controller;

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

import com.ipartek.formacion.gestiondocente.pojo.Curso;
import com.ipartek.formacion.gestiondocente.service.IServiceCurso;
import com.ipartek.formacion.gestiondocente.service.impl.ServiceCurso;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "*") // Para poder habilitar CORS, para hacer llamadas en JavaScript
@RestController
@RequestMapping("/cursos")
@Api(tags = "Cursos", produces = "application/json", description = "Gestión de Cursos")
public class CursosController {

	ValidatorFactory factory = null;
	Validator validator = null;
	IServiceCurso servicioCurso = null;
	private final Logger LOG = Logger.getLogger(CursosController.class);

	public CursosController() {
		super();
		servicioCurso = ServiceCurso.getInstance();

		// Crear factoria y validador
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();

	}

	@ApiOperation(value = "Listado de cursos")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Cursos encontrados"),
			@ApiResponse(code = 204, message = "La lista de cursos se encuentra vacia") })
	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Curso>> listar() {

		ResponseEntity<ArrayList<Curso>> response = new ResponseEntity<ArrayList<Curso>>(
				HttpStatus.INTERNAL_SERVER_ERROR);

		try {
			ArrayList<Curso> cursos = (ArrayList<Curso>) servicioCurso.listar();

			if (cursos != null && cursos.size() > 1) {
				response = new ResponseEntity<ArrayList<Curso>>(cursos, HttpStatus.OK);
			} else {
				response = new ResponseEntity<ArrayList<Curso>>(HttpStatus.NO_CONTENT);

			}
		} catch (Exception e) {
			LOG.error(e);
		}

		return response;

	}

}
