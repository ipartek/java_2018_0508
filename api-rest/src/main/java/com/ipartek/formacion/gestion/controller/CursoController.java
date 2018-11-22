package com.ipartek.formacion.gestion.controller;

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

import com.ipartek.formacion.gestion.pojo.Curso;
import com.ipartek.formacion.gestion.service.impl.ServicioCurso;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/cursos")
@Api(tags = "CURSOS", produces = "aplication/json", description = "Gestion de docentes")
public class CursoController {

	private final static Logger LOG = Logger.getLogger(CursoController.class);

	ServicioCurso servicioCurso = null;

	ValidatorFactory factory = null;
	Validator validator = null;

	public CursoController() {
		super();

		servicioCurso = ServicioCurso.getInstance();
		// Crear Factoria y Validador
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();

	}

	@ApiOperation(value = "Listado de cursos")
	@ApiResponses(value = { @ApiResponse(code = 200, message = " Listado cursos"),
			@ApiResponse(code = 204, message = " Sin registro") })
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Curso>> listar() {

		ArrayList<Curso> cursos = new ArrayList<Curso>();
		ResponseEntity<ArrayList<Curso>> response = new ResponseEntity<ArrayList<Curso>>(
				HttpStatus.INTERNAL_SERVER_ERROR);

		try {

			cursos = (ArrayList<Curso>) servicioCurso.listarCurso();

			if (cursos != null && cursos.size() > 0) {
				response = new ResponseEntity<>(cursos, HttpStatus.OK);
				LOG.debug("listado curso");
			} else {
				response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

		} catch (Exception e) {
			LOG.error(e);
		}

		return response;
	}

	@ApiOperation(value = "Listado de cursos con profesores", notes = "Metodo que devuelve todos los cursos con sus correspondientes profesores")
	@ApiResponses(value = { @ApiResponse(code = 200, message = " Listado cursos con profesores"),
			@ApiResponse(code = 204, message = " Sin registro") })
	@RequestMapping(value = { "/Profesores" }, method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Curso>> listarConProfesor() {

		ArrayList<Curso> cursos = new ArrayList<Curso>();
		ResponseEntity<ArrayList<Curso>> response = new ResponseEntity<ArrayList<Curso>>(
				HttpStatus.INTERNAL_SERVER_ERROR);

		try {

			cursos = (ArrayList<Curso>) servicioCurso.listarCursoConProfesor();

			if (cursos != null && cursos.size() > 0) {
				response = new ResponseEntity<>(cursos, HttpStatus.OK);
				LOG.debug("listado curso profesor");
			} else {
				response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

		} catch (Exception e) {
			LOG.error(e);
		}

		return response;
	}

	@ApiOperation(value = "Listado de cursos con alumno", notes = "Metodo que devuelve todos los cursos con sus correspondientes alumnos")
	@ApiResponses(value = { @ApiResponse(code = 200, message = " Listado cursos con alumnos"),
			@ApiResponse(code = 204, message = " Sin registro") })
	@RequestMapping(value = { "/alumnos" }, method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Curso>> listarConAlumno() {

		ArrayList<Curso> cursos = new ArrayList<Curso>();
		ResponseEntity<ArrayList<Curso>> response = new ResponseEntity<ArrayList<Curso>>(
				HttpStatus.INTERNAL_SERVER_ERROR);

		try {

			cursos = (ArrayList<Curso>) servicioCurso.listarCursoAlumno();

			if (cursos != null && cursos.size() > 0) {
				response = new ResponseEntity<>(cursos, HttpStatus.OK);
				LOG.debug("listado curso Alumno");
			} else {
				response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

		} catch (Exception e) {
			LOG.error(e);
		}

		return response;
	}

}
