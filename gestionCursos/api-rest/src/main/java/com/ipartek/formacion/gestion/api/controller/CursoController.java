package com.ipartek.formacion.gestion.api.controller;

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
import com.ipartek.formacion.gestion.service.IServiceCurso;
import com.ipartek.formacion.gestion.service.impl.ServiceCurso;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = { "Cursos" }, produces = "application/json", description = "Gestion Cursos")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/cursos")
public class CursoController {

	private final static Logger LOG = Logger.getLogger(CursoController.class);

	IServiceCurso serviceCurso = null;
	ValidatorFactory factory = null;
	Validator validator = null;

	public CursoController() {
		super();
		serviceCurso = ServiceCurso.getInstance();
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@ApiOperation(value = "Listado Cursos y profesores", notes = "Listado Cursos y Profesores que lo imparten: <ol><li><b> Nombre del curso:  </b> cursoNom </li><li> Identificador del Curso </li><li><b> Numero horas: </b> nHora <li><b> Nombre y Apellidos Profesor:  </b></li> </li></ol>")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Listado Cursos y Profesores"),
			@ApiResponse(code = 204, message = "No se encontro los Cursos y Profesores") })

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Curso>> listado() {
		ResponseEntity<ArrayList<Curso>> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		ArrayList<Curso> cursos = (ArrayList<Curso>) serviceCurso.listar();

		try {

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
