package com.ipartek.formacion.prestamos.api.controller;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.libros.pojo.Alumno;
import com.ipartek.formacion.libros.service.ServiceAlumno;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api( tags = {"AlumnosController"},description = "Alumnos")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/alumnos")
public class AlumnosController {

	ServiceAlumno serviceAlumno = null;
	ValidatorFactory factory = null;
	Validator validator = null;

	public AlumnosController() {
		super();
		serviceAlumno = ServiceAlumno.getInstance();
		// Crear Factoria y Validador
		factory = Validation.buildDefaultValidatorFactory();
		validator = (Validator) factory.getValidator();

	}
	
	@ApiOperation(value = "Listado de alumnos", notes = "Obtener todos los alumnos en json", nickname = "listado", responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Listado de alumnos ok"),
			@ApiResponse(code = 400, message = "Error "), @ApiResponse(code = 401, message = "No autorizado "),
			@ApiResponse(code = 404, message = "No encontrado ") })
	@ApiParam(required = false, name = "Blabla ?", defaultValue = "1")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Alumno>> listado() {

		ArrayList<Alumno> list = new ArrayList<Alumno>();
		ResponseEntity<ArrayList<Alumno>> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		try {

			list = (ArrayList<Alumno>) serviceAlumno.listar();
			response = new ResponseEntity<>(list, HttpStatus.OK);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return response;
	}
	
	
	@ApiOperation(value = "Detalle por alumno",notes = "Obtener el detalle de un alumno")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Detalle del alumno correcto"),
			@ApiResponse(code = 400, message = "El requerimiento enviado por el cliente era sintácticamente incorrecto "), @ApiResponse(code = 401, message = "No autorizado "),
			@ApiResponse(code = 404, message = "Alumnos no encontrada ") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "Id del alumno", required = true, dataType = "long", paramType = "Path") })
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> detalle(@PathVariable long id) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		ResponseMensaje rm = new ResponseMensaje();

		try {

			Alumno alumno = serviceAlumno.obtener(id);

			if (alumno != null && alumno.getId() > 0) {

				response = new ResponseEntity<>(alumno, HttpStatus.OK);

			} else {
				rm.setMensaje("Usuario no encontrado");
				response = new ResponseEntity<>(rm,HttpStatus.NOT_FOUND);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
	
	
	@ApiOperation(value = "Eliminar Alumno",notes = "Eliminar alumno por id. Si el alumno esta asociada con algun prestamo no podra ser eliminado")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "alumno eliminada"),
			@ApiResponse(code=400, message = "El requerimiento enviado por el cliente era sintácticamente incorrecto, se espera un campo numerico"),
			@ApiResponse(code = 404, message = "Error intentando un alumno que no encontramos"),
			@ApiResponse(code = 409, message = "No puedes borrar un alumno con libros asociados ") })
	@ApiParam(required = false, name = "Blabla ?", defaultValue = "1")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> eliminar(@PathVariable long id) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		ResponseMensaje rm = new ResponseMensaje();

		try {

			if (serviceAlumno.eliminar(String.valueOf(id))) {

				response = new ResponseEntity<>(HttpStatus.OK);

			} else {

				rm.setMensaje("Usuario no encontrado en la base de datos");

				response = new ResponseEntity<>(rm, HttpStatus.NOT_FOUND);
			}

		}catch (SQLIntegrityConstraintViolationException x) {
			if(x.getMessage().contains("foreign key")) {
				String[] errores = new String[1];
				rm.setMensaje("Error");
				errores[0] = "El alumno que intenta borrar tiene registros asociados.";
				rm.setErrores(errores);
				response = new ResponseEntity<>(rm, HttpStatus.CONFLICT);
			}
			
			x.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();
		}
		return response;
	}
	
	
	@ApiImplicitParams({
		@ApiImplicitParam(name = "alumno", value = "formato esperado:<br> {<br>\"nombre\" : \"alumnolN\"<br>}") })
	@ApiOperation(value = "Crear editoriales",notes = "Para la creacion de un alumno se espera un objeto json con un unico campo llamado nombre.<br>"
			+ "<h2>Requisitos para la creacion de un alumno</h2>"
			+ "<ul>"
			+ "<li>Debe ser mayor de 2 y menor de 50 caracteres</li>"
			+ "<li>No puede estar vacio</li>"
			+ "<li>No se permiten alumnos duplicadas</li>"
			+ "</ul>"
				)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Alumno Creada", responseContainer="nose"),
			@ApiResponse(code = 400, message = "No encontrado"),
			@ApiResponse(code = 409, message = "Conflictos :<br> Alumno existente.<br>Nombre del alumno menor de 2 caracteres<br>Nombre alumno mayor 50") })
	@ApiParam(required = false, name = "Blabla ?", defaultValue = "1")
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Object> crear(@RequestBody Alumno alumno) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		ResponseMensaje rm = new ResponseMensaje();

		try {

			Set<ConstraintViolation<Alumno>> violations = validator.validate(alumno);
			String[] errores = new String[violations.size()];

			if (violations.size() > 0) {

				int contador = 0;

				// No tenemos ningun fallo, la Validacion es correcta
				for (ConstraintViolation<Alumno> violation : violations) {
					
					errores[contador] = violation.getPropertyPath() + ":" + violation.getMessage();
					contador++;
				}

				rm.setErrores(errores);
				rm.setMensaje("error de validación");
				response = new ResponseEntity<>(rm, HttpStatus.CONFLICT);

			} else {

				if (serviceAlumno.crear(alumno)) {

					response = new ResponseEntity<>(alumno, HttpStatus.CREATED);

				} else {
					rm.setMensaje("Error");
					response = new ResponseEntity<>(rm, HttpStatus.CONFLICT);
				}
			}
		} catch (SQLIntegrityConstraintViolationException e) {
			
			e.printStackTrace();
			if(e.getMessage().contains("Duplicate entry")) {
				String[] errores = new String[1];
				rm.setMensaje("Error de integridad");
				errores[0] = "El alumno ya existe";
				rm.setErrores(errores);
				response = new ResponseEntity<>(rm, HttpStatus.CONFLICT);
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			if (e.getMessage().contains("nombre")) {
				
				rm.setMensaje("El <b>nombre</b> debe ser inferior a 50 caracteres");				
				response = new ResponseEntity<>(rm, HttpStatus.CONFLICT);
				
			} 
		} catch (Exception e) {
			
			e.printStackTrace();
			rm.setMensaje("Hemos tenido un problema");
			response = new ResponseEntity<>(rm, HttpStatus.CONFLICT);
			
		}

		return response;
	}
	
	
	@ApiImplicitParams({
		
		@ApiImplicitParam(name = "id", value = "El id del alumno que se va a modificar, en la practica es un @pathvariable", dataType="long", paramType="path"), 
		@ApiImplicitParam(name = "alumno", value = "formato esperado:<br> {<br>\"nombre\" : \"alumnoN\"<br>}", required=true)
		})
		
	@ApiOperation(value = "Modificar Alumnos",notes = "Para la modificacion de un alumno se espera un objeto json con un unico campo llamado nombre.<br>"
			+ "El id de la editorial se la pasamos en campo id como @pathvariable"
			+ "<h2>Requisitos para la modificacion de un alumno</h2>"
			+ "<ul>"
			+ "<li>Debe ser mayor de 2 y menor de 50 caracteres</li>"
			+ "<li>No puede estar vacio</li>"
			+ "<li>No se permiten editoriales duplicadas</li>"
			+ "</ul>"
				)
	@ApiResponses(value = {
			
			@ApiResponse(code = 201, message = "Modificacion correcta"),
			@ApiResponse(code = 400, message = "No encontrado"),
			@ApiResponse(code = 409, message = "Modificacion del nombre de un alumno por un nombre ya existente<br> El nombre contiene menos de 2 o mas de 50 caracteres") })
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> modificar(@PathVariable long id, @RequestBody Alumno alumno) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		ResponseMensaje rm = new ResponseMensaje();

		try {

			Set<ConstraintViolation<Alumno>> violations = validator.validate(alumno);
			String[] errores = new String[violations.size()];

			if (violations.size() > 0) {

				int contador = 0;
				// No ha pasado la valiadacion, iterar sobre los mensajes de validacion
				for (ConstraintViolation<Alumno> violation : violations) {

					errores[contador] = violation.getPropertyPath() + " :" + violation.getMessage();
					contador++;

				}
				rm.setErrores(errores);
				rm.setMensaje("Error de validación");

				response = new ResponseEntity<>(rm, HttpStatus.CONFLICT);

			} else {

				alumno.setId(id);

				if (serviceAlumno.modificar(alumno)) {

					response = new ResponseEntity<>(alumno, HttpStatus.CREATED);

				} else {

					response = new ResponseEntity<>(HttpStatus.CONFLICT);
				}
			}

		} catch (SQLIntegrityConstraintViolationException x) {
			if(x.getMessage().contains("Duplicate entry")) {
				String[] errores = new String[1];
				rm.setMensaje("Error");
				errores[0] = "El alumno ya existe";
				rm.setErrores(errores);
			}
			
			x.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();
		}

		return response;
	}

}
