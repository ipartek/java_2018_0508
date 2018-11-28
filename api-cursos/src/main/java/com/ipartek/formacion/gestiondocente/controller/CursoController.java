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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.gestiondocente.impl.ServiceCurso;
import com.ipartek.formacion.gestiondocente.pojo.Curso;
import com.ipartek.formacion.gestiondocente.pojo.ResponseMensaje;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "*") // Para habilitar post habilita llamadas ajasx
@RestController
@RequestMapping("/curso")
@Api(tags = { "Servicio /curso" }, description = "Listado de cursos", consumes = "application/json")
public class CursoController {

	ServiceCurso cursoService = null;
	ValidatorFactory factory = null;
	Validator validator = null;
	

	private final static Logger LOG = Logger.getLogger(CursoController.class);

	public CursoController() {
		super();
		
		cursoService = ServiceCurso.getInstance();
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
	@ApiOperation(value = "Listado de cursos", notes = "Obtener todos los cursos en json debemos pasarle un parametro llamado accion con los siguientes valores<br>"
			+ "<ol>"
			+ "<li>0 para obtener el listado de todos cursos</li>"
			+ "<li>1 para obtener el listado de cursos con sus profesores</li>"
			+ "<li>2 para obtener el listado de cursos que contienen alumnos</li>"
			+ "</ol>", nickname = "listado", responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Listado de cursos ok" ) })
	@RequestMapping( method = RequestMethod.GET)
	public ResponseEntity<Object> listado(
			@RequestParam(name = "accion", required = false, defaultValue = "0" ) String accion) {

		ArrayList<Curso> list = new ArrayList<Curso>();

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		ResponseMensaje rm = new ResponseMensaje();

		try {
			
			
			
				list = (ArrayList<Curso>) cursoService.listar(accion);
				


			if (list != null && list.size() > 1) {

				response = new ResponseEntity<Object>(list, HttpStatus.OK);
			} else {

				// Para cuando por la razon que sea nos viene el resultado vacio o nulo
				response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

		} catch (Exception e) {
			if(e.getMessage().contains("Por favor introduzca una opcion valida")) {
				rm.setMensaje("Error con la opcion introducida");
				String[] errores = new String[1];
				errores[0] = e.getMessage();
				rm.setErrores(errores);
				response = new ResponseEntity<>(rm,HttpStatus.CONFLICT);
			}
			LOG.error(e.getMessage());
			
			
			

		}

		return response;
	}

	
}
