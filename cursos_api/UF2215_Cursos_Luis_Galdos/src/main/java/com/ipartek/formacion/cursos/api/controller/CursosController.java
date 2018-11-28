package com.ipartek.formacion.cursos.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.cursos.pojo.Curso;
import com.ipartek.formacion.cursos.service.ServiceCurso;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@CrossOrigin(origins = "*") // Habilitar CORS -> Llamadas en JS
@RestController
@RequestMapping("/cursos")

@Api(tags = { "Cursos" }, produces = "application/json", description = "Gestión de Cursos del centro IPARTEK.")
public class CursosController {

	private static final Logger LOG = Logger.getLogger(CursosController.class);

	private static ServiceCurso servicio;
	
	public CursosController() {
		super();
		LOG.debug("Cargando SERVICIO.");
		servicio = ServiceCurso.getInstance();
		LOG.debug("Cargado SERVICIO.");
		LOG.debug(servicio);

	}

	@ApiOperation(value = "Listado de cursos.", notes = "Devuelve los cursos impartidos por el centro de estudios Ipartek, así como también:<br>"
			+ "<ul><li>El profesor que imparte dicho curso.</li>"
			+ "<li>Los alumnos ya matriculados.</li></ol>", response = Curso.class)

	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Listado de cursos devuelto correctamente.", response = Curso.class) })

	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Curso>> listado() {

		ResponseEntity<ArrayList<Curso>> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

		List<Curso> cursos;

		try {

			cursos = servicio.listar();

			if (!cursos.isEmpty()) {

				response = new ResponseEntity<ArrayList<Curso>>((ArrayList<Curso>) cursos, HttpStatus.OK);

			} else {

				response = new ResponseEntity<ArrayList<Curso>>(HttpStatus.NO_CONTENT);

			}

		} catch (Exception e) {

			response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
			LOG.error(e);
		}

		return response;
	}
	
	/*

	@ApiOperation(value = "Vista detalle de un curso en concreto.", 
			notes = "Devuelve el curso con el código (identificador) de la URL.", response = Curso.class)

	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Curso encontrado y devuelto correctamente.", response = Curso.class),
			@ApiResponse(code = 400, message = "Solicitud incorrecta.", response = ResponseMessage.class),
			@ApiResponse(code = 404, message = "Recurso no encontrado.", response = ResponseMessage.class) })

	@RequestMapping(value = "/{codigo}", method = RequestMethod.GET)
	public ResponseEntity<Object> detalle(

			@ApiParam(value = "Código indentificador del curso a mostrar.") @PathVariable long codigo) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

		try {

			curso = servicio.buscarCodigo(codigo);

			if (curso != null && curso.getCodigo() > 0) {

				response = new ResponseEntity<Object>(curso, HttpStatus.OK);

			} else {

				response = NOT_FOUND_RESPONSE;
			}

		} catch (Exception e) {

			response = INTERNAL_SERVER_ERROR_RESPONSE;
			e.printStackTrace();
		}

		return response;
	}*/

}