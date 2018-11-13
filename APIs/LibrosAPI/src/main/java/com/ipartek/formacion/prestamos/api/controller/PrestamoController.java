package com.ipartek.formacion.prestamos.api.controller;

import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
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
import org.springframework.web.bind.annotation.RequestParam;


import com.ipartek.formacion.libros.service.ServicePrestamo;
import com.ipartek.formacion.libros.pojo.Prestamo;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/prestamos")
public class PrestamoController {

	private static final String NOT_FOUND_MSG = "NO ENCONTRADO: El recurso no existe en la base de datos.";
	private static final String INTERNAL_ERROR = "ERROR INTERNO: No controlado.";
	
	private static final ResponseEntity<Object> NOT_FOUND_RESPONSE = new ResponseEntity<Object>(
			new ResponseMessage(NOT_FOUND_MSG), HttpStatus.NOT_FOUND);
	
	private static final ResponseEntity<Object> INTERNAL_SERVER_ERROR_RESPONSE = new ResponseEntity<Object>(
			new ResponseMessage(INTERNAL_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);

	private static ServicePrestamo servicio;
	private static Prestamo prestamo;

	private static ValidatorFactory factory;
	private static Validator validator;

	public PrestamoController() {
		super();
		servicio = ServicePrestamo.getInstance();

		// Crear Factoria y Validador
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();

	}

	
	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Prestamo>> listado(@RequestParam(value="activos", required = true) boolean activos) {

		ResponseEntity<ArrayList<Prestamo>> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

		try {
			
			if (activos) {
				
				response = new ResponseEntity<ArrayList<Prestamo>>((ArrayList<Prestamo>) servicio.prestamosActivos(), HttpStatus.OK);
			
			} else {
				
				response = new ResponseEntity<ArrayList<Prestamo>>((ArrayList<Prestamo>) servicio.historico(), HttpStatus.OK);
			}

			

		} catch (Exception e) {

			response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}

		return response;
	}

	@RequestMapping(value = "/{idLibro}/{idAlumno}/{fInicio}", method = RequestMethod.GET)
	public ResponseEntity<Object> detalle(@PathVariable long idLibro, @PathVariable long idAlumno, @PathVariable Date fInicio) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

		try {

			prestamo = servicio.obtenerPorId(idAlumno, idLibro, fInicio);

			if (prestamo != null) {

				response = new ResponseEntity<Object>(prestamo, HttpStatus.OK);

			} else {

				response = NOT_FOUND_RESPONSE;
			}

		} catch (Exception e) {

			response = INTERNAL_SERVER_ERROR_RESPONSE;
			e.printStackTrace();
		}

		return response;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> crear(@RequestBody Prestamo prestamo) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

		try {

			Set<ConstraintViolation<Prestamo>> violations = validator.validate(prestamo);

			if (violations.size() == 0) {

				if (servicio.prestar(prestamo.getAlumno().getId(), prestamo.getLibro().getId(), prestamo.getFechaInicio())) {

					response = new ResponseEntity<Object>(prestamo, HttpStatus.CREATED);

				}

			} else {

				ArrayList<String> msgs = new ArrayList<String>();

				for (ConstraintViolation<Prestamo> v : violations) {

					msgs.add(v.getMessage());

				}

				ResponseMessage msg = new ResponseMessage("Alguno de los campos no tiene una longitud adecuada..", msgs);
				response = new ResponseEntity<Object>(msg, HttpStatus.BAD_REQUEST);
			}

		} catch (SQLIntegrityConstraintViolationException e) {

			response = new ResponseEntity<>(new ResponseMessage("La editorial para este libro no existe."), HttpStatus.NOT_IMPLEMENTED);
			e.printStackTrace();

		} catch (Exception e) {

			response = new ResponseEntity<>(new ResponseMessage(e.getMessage()), HttpStatus.NOT_IMPLEMENTED);;
			//e.printStackTrace();
		}

		return response;

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> eliminar(@PathVariable long idLibro, @PathVariable long idAlumno, @PathVariable Date fInicio) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

		try {
			
			if (servicio.devolver(idAlumno, idLibro, fInicio, null)) {

				response = new ResponseEntity<Object>(HttpStatus.NO_CONTENT);

			} else {

				response = NOT_FOUND_RESPONSE;

			}

		} catch (SQLIntegrityConstraintViolationException e) {

			response = new ResponseEntity<>(new ResponseMessage("El libro tiene préstamos asociados, no se puede eliminar."), HttpStatus.NOT_IMPLEMENTED);;
			e.printStackTrace();

		} catch (Exception e) {

			response = INTERNAL_SERVER_ERROR_RESPONSE;
			e.printStackTrace();
		}

		return response;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> modificar(@PathVariable long idLibro, @PathVariable long idAlumno, @PathVariable Date fInicio, @PathVariable Date fFin ) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

		try {
			
			Set<ConstraintViolation<Prestamo>> violations = validator.validate(prestamo);

			if (violations.size() == 0) {

				if (servicio.modificar(idAlumno, idLibro, fInicio, fFin)) {

					response = new ResponseEntity<Object>(prestamo, HttpStatus.OK);

				} else {

					response = NOT_FOUND_RESPONSE;

				}

			} else {

				ArrayList<String> msgs = new ArrayList<String>();

				for (ConstraintViolation<Prestamo> v : violations) {

					msgs.add(v.getMessage());

				}

				ResponseMessage msg = new ResponseMessage("Alguno de los campos no tiene una longitud adecuada..", msgs);
				response = new ResponseEntity<Object>(msg, HttpStatus.BAD_REQUEST);
			}

		} catch (SQLIntegrityConstraintViolationException e) {

			response = new ResponseEntity<>(new ResponseMessage("La editorial para este libro no existe."), HttpStatus.NOT_IMPLEMENTED);
			e.printStackTrace();

		} catch (Exception e) {

			response = INTERNAL_SERVER_ERROR_RESPONSE;
			e.printStackTrace();
		}

		return response;

	}

}
