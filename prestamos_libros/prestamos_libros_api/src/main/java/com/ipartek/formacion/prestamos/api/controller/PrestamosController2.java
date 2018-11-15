package com.ipartek.formacion.prestamos.api.controller;

import java.sql.SQLIntegrityConstraintViolationException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Map;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.libros.pojo.Alumno;
import com.ipartek.formacion.libros.pojo.Libro;
import com.ipartek.formacion.libros.pojo.Prestamo;
import com.ipartek.formacion.libros.service.ServiceAlumno;
import com.ipartek.formacion.libros.service.ServiceLibro;
import com.ipartek.formacion.libros.service.ServicePrestamo;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/prestamos_old")
public class PrestamosController2 {

	private final static Logger LOG = Logger.getLogger(PrestamosController2.class);

	ServicePrestamo servicePrestamo = null;
	ServiceAlumno serviceAlumno = null;
	ServiceLibro serviceLibro = null;
	ValidatorFactory factory = null;
	Validator validator = null;

	public PrestamosController2() {
		super();
		LOG.trace("constructor");
		LOG.trace("Log instaciado");
		servicePrestamo = ServicePrestamo.getInstance();
		serviceAlumno = ServiceAlumno.getInstance();
		serviceLibro = ServiceLibro.getInstance();
		// Crear Factoria y Validador
		factory = Validation.buildDefaultValidatorFactory();
		validator = (Validator) factory.getValidator();

	}

	@ApiOperation(value = "Listado prestamos activos o historicos")
	@ApiResponses(value = {
				@ApiResponse(code = 200, message ="Listado de prestamos"),
				@ApiResponse(code = 200, message ="Listado de prestamos")
	})
	
	@ApiParam(value = "activos", required = false, name="Blabla ?", defaultValue = "1")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Prestamo>> listado(
			@RequestParam(name = "accion", required = false, defaultValue = "-1") String accion) {

		ArrayList<Prestamo> list = new ArrayList<Prestamo>();
		ResponseEntity<ArrayList<Prestamo>> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		try {
			switch (accion) {
			case "0":

				list = (ArrayList<Prestamo>) servicePrestamo.historico();
				LOG.trace("Prestamos recuperados " + list.size());
				break;

			case "1":

				list = (ArrayList<Prestamo>) servicePrestamo.prestamosActivos();
				break;

			default:

				list = (ArrayList<Prestamo>) servicePrestamo.todosPrestamos();
				break;

			}
			response = new ResponseEntity<>(list, HttpStatus.OK);

		} catch (Exception e) {

			LOG.trace(e);
		}

		return response;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Prestamo> detalle(@RequestParam Map<String, String> requestParams, @PathVariable long id)
			throws ParseException {

		ResponseEntity<Prestamo> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		String libro = requestParams.get("idLibro");
		String alumno = requestParams.get("idAlumno");
		String fechaInicio = requestParams.get("fechaInicio");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = sdf1.parse(fechaInicio);
		java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());

		try {

			Prestamo prestamo = servicePrestamo.obtenerPorId(Long.parseLong(libro), Long.parseLong(alumno),
					sqlStartDate);

			if (prestamo != null) {

				response = new ResponseEntity<>(prestamo, HttpStatus.OK);

			} else {

				response = new ResponseEntity<>(HttpStatus.NOT_FOUND);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Object> crear(@RequestBody Prestamo prestamo) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		ResponseMensaje rm = new ResponseMensaje();

		boolean alumnoResul = true;
		boolean libroResul = true;

		try {
			ArrayList<Alumno> alumnosDisponibles = new ArrayList<Alumno>();
			ArrayList<Libro> librosDisponibles = new ArrayList<Libro>();
			Alumno a = serviceAlumno.obtener(prestamo.getAlumno().getId());
			Libro l = serviceLibro.obtener(prestamo.getLibro().getId());

			for (Alumno al : alumnosDisponibles) {
				if (al.getId() == a.getId()) {
					alumnoResul = true;

				}
			}
			for (Libro ld : librosDisponibles) {
				if (l.getId() == ld.getId()) {
					libroResul = true;
				}
			}

			prestamo.setAlumno(a);
			prestamo.setLibro(l);
			Set<ConstraintViolation<Prestamo>> violations = validator.validate(prestamo);
			String[] errores = new String[violations.size()];

			if (violations.size() > 0) {

				int contador = 0;

				// No tenemos ningun fallo, la Validacion es correcta
				for (ConstraintViolation<Prestamo> violation : violations) {

					System.out.println(violation.getMessage());
					System.out.println(violation.getPropertyPath());
					errores[contador] = violation.getPropertyPath() + ":" + violation.getMessage();
					contador++;
				}

				rm.setErrores(errores);
				rm.setMensaje("error de validación");
				response = new ResponseEntity<>(rm, HttpStatus.CONFLICT);

			} else {

				if (servicePrestamo.prestar(prestamo.getAlumno().getId(), prestamo.getLibro().getId(),
						prestamo.getFechaInicio())) {

					response = new ResponseEntity<>(prestamo, HttpStatus.CREATED);

				} else {

					response = new ResponseEntity<>(HttpStatus.CONFLICT);
				}
			}

		} catch (SQLIntegrityConstraintViolationException e) {
			if (e.getMessage().contains("Duplicate entry")) {
				e.printStackTrace();
				String[] errores = new String[1];
				rm.setMensaje("Error de integridad");
				errores[0] = "Ya disponemos de un prestamo con la relacion propuesta.";
				rm.setErrores(errores);
				response = new ResponseEntity<>(rm, HttpStatus.CONFLICT);
			}

		} catch (Exception e) {

			String[] errores = new String[1];
			errores[0] = "Asegurese de completar todos los campos, y de que tengan sentido";
			rm.setMensaje("Error al crear el prestamo");
			rm.setErrores(errores);
			response = new ResponseEntity<>(rm, HttpStatus.CONFLICT);
			e.printStackTrace();
		}

		return response;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Prestamo> eliminar(@RequestParam Map<String, String> requestParams, @PathVariable long id)
			throws ParseException {

		ResponseEntity<Prestamo> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		String idLibro = requestParams.get("idLibro");
		String idAlumno = requestParams.get("idAlumno");
		String fechaInicio = requestParams.get("fechaInicio");
		String fechaRetorno = requestParams.get("fechaRetorno");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = sdf1.parse(fechaInicio);
		java.util.Date date2 = sdf1.parse(fechaRetorno);
		java.sql.Date fechaInicioDate = new java.sql.Date(date.getTime());
		java.sql.Date fechaRetornoDate = new java.sql.Date(date2.getTime());

		try {

			if (servicePrestamo.devolver(Long.parseLong(idAlumno), Long.parseLong(idLibro), fechaInicioDate,
					fechaRetornoDate)) {

				response = new ResponseEntity<>(HttpStatus.OK);

			} else {

				response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return response;
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<Object> modificar(@RequestParam Map<String, String> requestParams,
			@RequestBody Prestamo prestamo) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		try {

			java.sql.Date fechaInicioDate = new java.sql.Date(prestamo.getFechaInicio().getTime());
			java.sql.Date fechaRetornoDate = new java.sql.Date(prestamo.getFechaRetorno().getTime());
			Alumno a = serviceAlumno.obtener(prestamo.getAlumno().getId());
			Libro l = serviceLibro.obtener(prestamo.getLibro().getId());
			prestamo.setAlumno(a);
			prestamo.setLibro(l);

			// comprobamos que el libro elegido y el alumno seleccionado esten libres

			Set<ConstraintViolation<Prestamo>> violations = validator.validate(prestamo);
			String[] errores = new String[violations.size()];
			ResponseMensaje rm = new ResponseMensaje();

			if (violations.size() > 0) {

				int contador = 0;
				// No ha pasado la valiadacion, iterar sobre los mensajes de validacion
				for (ConstraintViolation<Prestamo> violation : violations) {

					errores[contador] = violation.getPropertyPath() + " :" + violation.getMessage();
					contador++;

				}
				rm.setErrores(errores);
				rm.setMensaje("Error de validación");

				response = new ResponseEntity<>(rm, HttpStatus.CONFLICT);

			} else {

				// prestamo.setId(id);

				/*
				 * if (servicePrestamo.modificar(prestamo.getAlumno().getId(),
				 * prestamo.getLibro().getId(), fechaInicioDate, fechaRetornoDate)) {
				 * 
				 * response = new ResponseEntity<>(prestamo, HttpStatus.OK);
				 * 
				 * } else {
				 * 
				 * response = new ResponseEntity<>(HttpStatus.CONFLICT); }
				 */
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return response;
	}

}
