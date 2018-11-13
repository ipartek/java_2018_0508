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

import com.ipartek.formacion.prestamolibros.pojo.Alumno;
import com.ipartek.formacion.prestamolibros.service.ServicioAlumno;
import com.ipartek.formacion.prestamolibros.service.ServicioEditorial;
import com.ipartek.formacion.prestamos.api.controller.pojo.ResponseMensaje;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/alumnos")
public class AlumnosController {
	ValidatorFactory factory = null;
	Validator validator = null;
	ServicioAlumno servicioAlumno = null;

	public AlumnosController() {
		super();
		servicioAlumno = ServicioAlumno.getInstance();
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();

	}

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
			e.printStackTrace();
		}

		return response;
	}

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
			e.printStackTrace();
		}
		return response;

	}

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
			e.printStackTrace();
			response = new ResponseEntity<>(
					new ResponseMensaje("No se puede eliminar este Alumno porque tiene un registro asociado"),
					HttpStatus.CONFLICT);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;

	}

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
			e.printStackTrace();
			response = new ResponseEntity<>(
					new ResponseMensaje("Ya existe un alumno con ese nombre, por favor cambialo"), HttpStatus.CONFLICT);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return response;
	}

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
			e.printStackTrace();
			response = new ResponseEntity<>(
					new ResponseMensaje("Ya existe un/@ alumn@ con ese nombre, por favor elige otro nombre o apellido"),
					HttpStatus.CONFLICT);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

}
