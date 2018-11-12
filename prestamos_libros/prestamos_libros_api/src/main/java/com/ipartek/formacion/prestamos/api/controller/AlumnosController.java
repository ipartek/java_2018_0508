package com.ipartek.formacion.prestamos.api.controller;

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
import com.ipartek.formacion.libros.pojo.Editorial;
import com.ipartek.formacion.libros.service.ServiceAlumno;
import com.ipartek.formacion.libros.service.ServiceEditorial;

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

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Alumno> detalle(@PathVariable long id) {

		ResponseEntity<Alumno> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		try {

			Alumno alumno = serviceAlumno.obtener(id);

			if (alumno != null && alumno.getId() > 0) {

				response = new ResponseEntity<>(alumno, HttpStatus.OK);

			} else {

				response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
				

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> eliminar(@PathVariable long id) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		try {
			ResponseMensaje rm = new ResponseMensaje();

			if (serviceAlumno.eliminar(String.valueOf(id))) {

				response = new ResponseEntity<>(HttpStatus.OK);

			} else {

				
				rm.setMensaje("Usuario no encontrado en la base de datos");

				response = new ResponseEntity<>(rm, HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return response;
	}

	@RequestMapping(method = RequestMethod.POST,consumes="application/json")
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

					System.out.println(violation.getMessage());
					System.out.println(violation.getPropertyPath());
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
					response = new ResponseEntity<>(rm,HttpStatus.CONFLICT);
				}
			}
		}catch(SQLIntegrityConstraintViolationException x) {
			rm.setMensaje("Nombre Duplicado");
			x.printStackTrace();
		
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		return response;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> modificar(@PathVariable long id, @RequestBody Alumno alumno) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		ResponseMensaje rm = new ResponseMensaje();

		try {

			Set<ConstraintViolation<Alumno>> violations = validator.validate(alumno);
			String[] errores = new String[violations.size()];
			

			if (violations.size() > 0) {

				int contador = 0;
				 //No ha pasado la valiadacion, iterar sobre los mensajes de validacion 
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

					response = new ResponseEntity<>(alumno, HttpStatus.OK);

				} else {

					response = new ResponseEntity<>(HttpStatus.CONFLICT);
				}
			}

		}
	catch(SQLIntegrityConstraintViolationException x) {
		rm.setMensaje("Nombre Duplicado");
		x.printStackTrace();
	
	} catch (Exception e) {

			e.printStackTrace();
		}

		return response;
	}

}
