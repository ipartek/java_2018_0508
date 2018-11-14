package com.ipartek.formacion.prestamos.api.controller;

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

import com.ipartek.formacion.pojo.Alumno;
import com.ipartek.formacion.service.ServiceAlumno;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

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
		validator = factory.getValidator();
	}

	@ApiOperation(value = "Listado de alumnos")
	@ApiResponses (value= {
			@ApiResponse(	code  =  200 , message  =  " Listado alumnos"),
			@ApiResponse(	code  =  404 , message  =  " No se encontró alumnos")					
	} )
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Alumno>> listar() {

		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		ResponseEntity<ArrayList<Alumno>> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

		try {

			alumnos = (ArrayList<Alumno>) serviceAlumno.listar();
			response = new ResponseEntity<>(alumnos, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}
	
	
	@ApiOperation(value = "Obtener alumno por su identificador")
	@ApiResponses (value= {
			@ApiResponse(	code  =  200 , message  =  " alumno encontrado"),
			@ApiResponse(	code  =  404 , message  =  " No se encontró el alumno deseado")					
	} )
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> detalle(@PathVariable long id) throws Exception {
		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
		Alumno alumno = new Alumno();
		alumno = serviceAlumno.buscarPorId(id);

		if (alumno != null && alumno.getId() > 0) {

			response = new ResponseEntity<>(alumno, HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(
					new ResponseMensaje("No se ha encotrado ningun registro, cambie de identificador"),
					HttpStatus.NOT_FOUND);
		}

		return response;
	}

	@ApiOperation(value = "Eliminar alumno por su identificador")
	@ApiResponses (value= {
			@ApiResponse(	code  =  200 , message  =  " alumno eliminado correctamente"),
			@ApiResponse(	code  =  404 , message  =  " No se encontró el alumno deseado"),	
			@ApiResponse(	code  =  409 , message  =  " No se puede borrar el alumno si tiene un prestamo asociado")				
	} )
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> eliminar(@PathVariable long id) throws Exception {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

		try {

			if (serviceAlumno.eliminar(id)) {
				response = new ResponseEntity<>(HttpStatus.OK);
			} else {
				response = new ResponseEntity<>(
						new ResponseMensaje("No se ha encontrado ningun registro, cambie de identificador"),
						HttpStatus.NOT_FOUND);
			}

		} catch (MySQLIntegrityConstraintViolationException e) {

			response = new ResponseEntity<>(
					new ResponseMensaje(
							"No es posible eliminar el registro deseado porque tiene algun prestamo pendiente."),
					HttpStatus.CONFLICT);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	@ApiOperation(value = "Crear alumno ")
	@ApiResponses (value= {
			@ApiResponse(	code  =  201 , message  =  " alumno creada correctamente"),			
			@ApiResponse(	code  =  409 , message  =  " Puede que el nombre del alumno esté vacío o el nombre del alumno ya exista")				
	} )
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> crear(@RequestBody Alumno alumno) throws Exception {
		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		ResponseMensaje responseMensaje = new ResponseMensaje();

		try {

			Set<ConstraintViolation<Alumno>> violations = validator.validate(alumno);
			if (violations.size() > 0) {
				/* No ha pasado la valiadacion, iterar sobre los mensajes de validacion */

				ArrayList<String> errores = new ArrayList<>();
				for (ConstraintViolation<Alumno> violation : violations) {
					errores.add(violation.getPropertyPath() + ": " + violation.getMessage());

				}
				responseMensaje.setErrores(errores);
				responseMensaje.setMensaje("Datos no validos");

				response = new ResponseEntity<>(responseMensaje, HttpStatus.CONFLICT);
			} else {
				if (serviceAlumno.crear(alumno)) {
					response = new ResponseEntity<>(alumno, HttpStatus.CREATED);
				} else {
					response = new ResponseEntity<>(HttpStatus.CONFLICT);

				}
			}

		} catch (MySQLIntegrityConstraintViolationException e) {

			response = new ResponseEntity<>(
					new ResponseMensaje("Ya existe el alumno,Por favor prueba con otro nombre."),
					HttpStatus.CONFLICT);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return response;
	}

	@ApiOperation(value = "Modificar alumno")
	@ApiResponses (value= {
			@ApiResponse(	code  =  200 , message  =  " alumno modificado correctamente"),
			@ApiResponse(	code  =  404 , message  =  " No se encontró el alumno deseada"),	
			@ApiResponse(	code  =  409 , message  =  " Puede que el nombre del alumno esté vacío o el nombre del alumno ya existe")
	} )
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> modificar(@PathVariable long id, @RequestBody Alumno alumno) throws Exception {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
		ResponseMensaje responseMensaje = new ResponseMensaje();

		try {
			alumno.setId(id);
			Set<ConstraintViolation<Alumno>> violations = validator.validate(alumno);
			if (violations.size() > 0) {
				/* No ha pasado la valiadacion, iterar sobre los mensajes de validacion */

				ArrayList<String> errores = new ArrayList<>();
				for (ConstraintViolation<Alumno> violation : violations) {
					errores.add(violation.getPropertyPath() + ": " + violation.getMessage());

				}
				responseMensaje.setErrores(errores);
				responseMensaje.setMensaje("Datos no validos");

				response = new ResponseEntity<>(responseMensaje, HttpStatus.CONFLICT);
			} else {
				if (serviceAlumno.modificar(alumno)) {
					response = new ResponseEntity<>(alumno, HttpStatus.OK);
				} else {
					response = new ResponseEntity<>(
							new ResponseMensaje("No se ha encotrado ningun registro, cambie de identificador"),
							HttpStatus.NOT_FOUND);
				}
			}

		} catch (MySQLIntegrityConstraintViolationException e) {

			response = new ResponseEntity<>(
					new ResponseMensaje("Ya existe el alumno,Por favor prueba con otro nombre."),
					HttpStatus.CONFLICT);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

}
