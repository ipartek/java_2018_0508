package com.ipartek.formacion.prestamos.api.controller;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.prestamolibros.pojo.Alumno;
import com.ipartek.formacion.prestamolibros.service.ServicioAlumno;
import com.ipartek.formacion.prestamolibros.service.ServicioEditorial;
import com.ipartek.formacion.prestamos.api.controller.pojo.ResponseMensaje;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/alumnos") 
@Api(tags="Alumnos",produces="application/json",description="Gestión de Alumn@s")
public class AlumnosController {
	ValidatorFactory factory = null;
	Validator validator = null;
	ServicioAlumno servicioAlumno = null;
	private final static Logger LOG = Logger.getLogger(AlumnosController.class);


	public AlumnosController() {
		super();
		servicioAlumno = ServicioAlumno.getInstance();
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();

	}
	@ApiOperation(value = "Listado de alumnos")
	@ApiResponses(value =
						{ 
						  @ApiResponse(code = 200, message = "Alumnos encontrados"),
						  @ApiResponse(code = 500, message = "Ha ocurrido un error") })
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Alumno>> listar() {
		ResponseEntity<ArrayList<Alumno>> response = new ResponseEntity<ArrayList<Alumno>>(
				HttpStatus.INTERNAL_SERVER_ERROR);
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();

		try {
			ServicioEditorial.getInstance();
			alumnos = (ArrayList<Alumno>) servicioAlumno.listar();
			response = new ResponseEntity<ArrayList<Alumno>>(alumnos, HttpStatus.OK);
		} catch (Exception e) {
			LOG.error(e);
		}

		return response;
	}
	
	
	
	
	@ApiOperation(value = "Detalle de un/a alumn@",response=Alumno.class)
	@ApiResponses(value =
						{ 
						  @ApiResponse(code = 200, message = "Alumno/a encontrad@"),
						  @ApiResponse(code = 500, message = "Ha ocurrido un error"),
						  @ApiResponse(code = 404, message = "El/La alumn@  no existe")				  })
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<Alumno> detalle(@PathVariable long id) {
		ResponseEntity<Alumno> response = new ResponseEntity<Alumno>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {

			Alumno alumno = servicioAlumno.buscar(id);
			if (alumno != null && alumno.getId() > 0) {
				response = new ResponseEntity<Alumno>(alumno, HttpStatus.OK);
			} else {
				response = new ResponseEntity<Alumno>(HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			LOG.error(e);

		}
		return response;

	}
	
	
	
	
	@ApiOperation(value = "Crear un/a Alumn@",response=Alumno.class,notes="<ol><li>NOMBRE: minimo 2 caracteres, máximo 50</li><li>APELLIDOS: minimo 2 caracteres, máximo 150</li></ol>")
	@ApiResponses(value =
						{ 
							@ApiResponse(code = 201, message = "Alumn@ cread@"),
							@ApiResponse(code = 409, message = "El/La alumn@ que intenta crear ya existe"),
							@ApiResponse(code = 500, message = "Ha ocurrido un error")
						  })
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> crear(@RequestBody Alumno alumno) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		ResponseMensaje msg = new ResponseMensaje();
		try {

			// Validacion con javax validator
			Set<ConstraintViolation<Alumno>> violations = validator.validate(alumno);
			if (violations.isEmpty()) {
				if (servicioAlumno.crear(alumno)) {
					response = new ResponseEntity<>(alumno, HttpStatus.CREATED);
				} else {
					response = new ResponseEntity<>(new ResponseMensaje("El alumno ya existe"), HttpStatus.CONFLICT);
				}
			} else {
				for (ConstraintViolation<Alumno> constraint : violations) {
					msg.addError((constraint.getPropertyPath() + ": " + constraint.getMessage()));
					msg.setMensaje("Ha ocurrido un error");
				}
				response = new ResponseEntity<>(msg, HttpStatus.CONFLICT);

			}

		} catch (SQLIntegrityConstraintViolationException e) {
		
			response = new ResponseEntity<>(
					new ResponseMensaje("Ya existe un alumno con ese nombre, por favor cambialo"), HttpStatus.CONFLICT);
			LOG.debug(response);
		} catch (Exception e) {

			LOG.error(e);

		}

		return response;
	}
	
	
	
	
	
	@ApiOperation(value = "Modificar un/a Alumn@",response=Alumno.class,notes="<ol><li>NOMBRE: minimo 2 caracteres, máximo 50</li><li>APELLIDOS: minimo 2 caracteres, máximo 150</li></ol>")
	@ApiResponses(value =
						{ 
						  @ApiResponse(code = 200, message = "Alumn@ modificad@ con éxito"),
						  @ApiResponse(code = 404, message = "El/La alumn@ no existe"),
						  @ApiResponse(code = 409, message = "<ol><li>Ya existe un/a alumn@ con ese nombre, por favor elige otro nombre</li> <li>Los datos introducidos son incorrectos</li></ol>"),
						  @ApiResponse(code = 500, message = "Ha ocurrido un error")
						  })
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> modificar(@PathVariable long id, @RequestBody Alumno alumno) {
		ResponseMensaje msg = new ResponseMensaje();

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {
			Set<ConstraintViolation<Alumno>> violations = validator.validate(alumno);
			if (violations.isEmpty()) {
				alumno.setId(id);
				if (servicioAlumno.modificar(alumno)) {
					response = new ResponseEntity<>(alumno, HttpStatus.OK);
				} else {
					response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}
			} else {

				for (ConstraintViolation<Alumno> constraint : violations) {
					msg.addError((constraint.getPropertyPath() + ": " + constraint.getMessage()));
				}
				response = new ResponseEntity<>(msg, HttpStatus.CONFLICT);

			}
		} catch (SQLIntegrityConstraintViolationException e) {
			

			response = new ResponseEntity<>(
					new ResponseMensaje("Ya existe un/@ alumn@ con ese nombre, por favor elige otro nombre o apellido"),
					HttpStatus.CONFLICT);
			LOG.debug(response);
		} catch (Exception e) {
			LOG.error(e);

		}
		return response;
	}

	
	
	@ApiOperation(value = "Eliminar un/a alumn@")
	@ApiResponses(value =
						{ 
						  @ApiResponse(code = 200, message = "Alumn@ eliminad@"),
						  @ApiResponse(code = 404, message = "El/La alumn@ no existe"),
						  @ApiResponse(code = 409, message = "No se puede borrar el/la Alumn@ porque hay un registro asociado"),
						  @ApiResponse(code = 500, message = "Ha ocurrido un error")
						  
						  })
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> eliminar(@PathVariable long id) {
		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {

			if (servicioAlumno.eliminar(id)) {
				response = new ResponseEntity<>(HttpStatus.OK);
			} else {
				response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (SQLIntegrityConstraintViolationException e) {
		
			response = new ResponseEntity<>(
					new ResponseMensaje("No se puede eliminar este Alumno porque tiene un registro asociado"),
					HttpStatus.CONFLICT);
			LOG.debug(response);

		} catch (Exception e) {
			LOG.error(e);

		}
		return response;

	}
}
