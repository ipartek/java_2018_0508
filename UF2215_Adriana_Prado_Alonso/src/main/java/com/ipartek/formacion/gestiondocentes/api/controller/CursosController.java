package com.ipartek.formacion.gestiondocentes.api.controller;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.gestiondocentes.pojo.Curso;
import com.ipartek.formacion.gestiondocentes.service.impl.ServiceCurso;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = { "Cursos" }, produces = "application/json", description = "Listados de cursos")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/cursos")
public class CursosController {
	
	ServiceCurso serviceCurso = null;
	
	public CursosController() {
		super();
		LOG.trace("Constructor");
		serviceCurso = ServiceCurso.getInstance();
		LOG.trace("Servicio Curso instanciado");
	}
	
	// Logger
	private final static Logger LOG = Logger.getLogger(CursosController.class);
	
	@ApiOperation(value = "Listado de cursos", notes = "Muestra el listado de todos los cursos", produces = "application/json")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Listado mostrado"), 
							@ApiResponse(code = 204, message = "Listado vacío")})
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Curso>> listado() {
		ResponseEntity<ArrayList<Curso>> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		ArrayList<Curso> cursos = new ArrayList<Curso>();

		try {
			cursos = (ArrayList<Curso>) serviceCurso.listadoCursos();
			if(cursos != null && cursos.size() > 0) {
				response = new ResponseEntity<>(cursos, HttpStatus.OK);
				LOG.debug("Listado de cursos devuelto con " + cursos.size() + "registros");
			}else {
				response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
				LOG.debug("No se han encontrado cursos");
			}
			
		} catch (Exception e) {
			LOG.error(e);
		}

		return response;
	}
	
	@ApiOperation(value = "Listado de cursos más los profesores", notes = "Muestra el listado de todos los cursos"
			+ " más los datos de los profesores que impartieron cada uno", produces = "application/json")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Listado mostrado"), 
							@ApiResponse(code = 204, message = "Listado vacío")})
	@RequestMapping(value= {"/profesores"}, method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Curso>> listadoCursosProfesores() {
		ResponseEntity<ArrayList<Curso>> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		ArrayList<Curso> cursos = new ArrayList<Curso>();

		try {
			cursos = (ArrayList<Curso>) serviceCurso.listadoCursosProfesores();
			if(cursos != null && cursos.size() > 0) {
				response = new ResponseEntity<>(cursos, HttpStatus.OK);
				LOG.debug("Listado de cursos y profesores devuelto con " + cursos.size() + "registros");
			}else {
				response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
				LOG.debug("No se han encontrado cursos con sus profesores");
			}
			
		} catch (Exception e) {
			LOG.error(e);
		}

		return response;
	}
	
	@ApiOperation(value = "Listado de cursos más los profesores y los alumnos de cada curso", notes = "Muestra el listado de todos los cursos,"
			+ " los datos de los profesores que impartieron cada uno y los alumnos que se"
			+ " matricularon en cada uno de ellos", produces = "application/json")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Listado mostrado"), 
							@ApiResponse(code = 204, message = "Listado vacío")})
	@RequestMapping(value= {"/profesores/alumnos"}, method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Curso>> listadoCursosProfesoresAlumnos() {
		ResponseEntity<ArrayList<Curso>> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		ArrayList<Curso> cursos = new ArrayList<Curso>();

		try {
			cursos = (ArrayList<Curso>) serviceCurso.listadoCursosProfesoresAlumnos();
			if(cursos != null && cursos.size() > 0) {
				response = new ResponseEntity<>(cursos, HttpStatus.OK);
				LOG.debug("Listado de cursos, profesores y alumnos devuelto con " + cursos.size() + "registros");
			}else {
				response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
				LOG.debug("No se han encontrado cursos con sus profesores y alumnos");
			}
			
		} catch (Exception e) {
			LOG.error(e);
		}

		return response;
	}
}
