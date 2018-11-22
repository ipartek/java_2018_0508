package com.ipartek.formacion.gestiondocente.api.controller;

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

import com.ipartek.formacion.gestiondocente.impl.ServiceCurso;
import com.ipartek.formacion.gestiondocente.pojo.Curso;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "*") // Para habilitar post habilita llamadas ajasx
@RestController
@RequestMapping("/cursos")
@Api(tags = { "Servicio /cursos" }, description = "Clase CursoControllerr", consumes = "application/json")
public class CursoController {
	
	

	private static ServiceCurso servicioCurso;
	ValidatorFactory factory = null;
	Validator validator = null;

	private final static Logger LOG = Logger.getLogger(CursoController.class);

	public CursoController() {
		super();
		servicioCurso = ServiceCurso.getInstance();
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
	@ApiOperation(value = "Listado de Cursos", notes = "Obtener todos los Cursos en json", nickname = "listado", responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Listado de Cursos ok"),
			@ApiResponse(code = 400, message = "Error "), @ApiResponse(code = 401, message = "No autorizado "),
			@ApiResponse(code = 404, message = "No encontrado ") })
	@RequestMapping(value = {  "" }, method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Curso>> listado() {

		ArrayList<Curso> list = new ArrayList<Curso>();

		ResponseEntity<ArrayList<Curso>> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		try {

			list = (ArrayList<Curso>) servicioCurso.listar();

			if (list != null && list.size() > 1) {

				response = new ResponseEntity<>(list, HttpStatus.OK);
			} else {

				// Para cuando por la razon que sea nos viene el resultado vacio o nulo
				response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

		} catch (Exception e) {

			LOG.error(e.getMessage());

		}

		return response;
	}
	
	/**
	 * Entidad que va a responder json y codigo de estado 2 parametros cuerpo con
	 * los datos arraylist y el codigo http
	 * 
	 * @return
	 */
	@ApiOperation(value = "Listado de Cursos con sus profesores", notes = "Obtener todos los Cursos con profesores en json")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Listado de Curso mas profesoress ok"),
			@ApiResponse(code = 204, message = "Error "), @ApiResponse(code = 401, message = "No autorizado "),
			@ApiResponse(code = 404, message = "No encontrado ") })
	@RequestMapping(value = { "/maestro" }, method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Curso>> listadoConProfesores() {

		ArrayList<Curso> list = new ArrayList<Curso>();

		ResponseEntity<ArrayList<Curso>> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		try {

			list = (ArrayList<Curso>) servicioCurso.listaCursosProfesoresr();

			if (list != null && list.size() > 1) {

				response = new ResponseEntity<>(list, HttpStatus.OK);
			} else {

				// Para cuando por la razon que sea nos viene el resultado vacio o nulo
				response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

		} catch (Exception e) {

			LOG.error(e.getMessage());

		}

		return response;
	}

	

	
	
	

}
