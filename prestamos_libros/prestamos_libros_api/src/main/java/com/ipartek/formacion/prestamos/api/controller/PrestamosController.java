package com.ipartek.formacion.prestamos.api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.prestamos_libros.pojo.Alumno;
import com.ipartek.formacion.prestamos_libros.pojo.Editorial;
import com.ipartek.formacion.prestamos_libros.pojo.Libro;
import com.ipartek.formacion.prestamos_libros.pojo.Prestamo;
import com.ipartek.formacion.prestamos_libros.service.ServiceAlumno;
import com.ipartek.formacion.prestamos_libros.service.ServiceEditorial;
import com.ipartek.formacion.prestamos_libros.service.ServiceLibro;
import com.ipartek.formacion.prestamos_libros.service.ServicePrestamo;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import java.sql.Date;
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

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/libros/prestamos")
public class PrestamosController {
	
	ServicePrestamo servicePrestamo = null;
	ServiceLibro serviceLibro = null;
	ServiceAlumno serviceAlumno = null;
	ServiceEditorial serviceEditorial = null;
	ValidatorFactory factory = null;
	Validator validator = null;
	
	public PrestamosController() {
		super();
		servicePrestamo = ServicePrestamo.getInstance();
		serviceLibro = ServiceLibro.getInstance();
		serviceAlumno = ServiceAlumno.getInstance();
		serviceEditorial = ServiceEditorial.getInstance();
		//Crear Factoria y Validador
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Prestamo>> listado(@RequestParam(value = "activos", required = false) int activos) {
		ResponseEntity<ArrayList<Prestamo>> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
		
		try {
			//Si es 0 es historico, si es 1 son activos
			if(activos == 0) {
				prestamos = (ArrayList<Prestamo>) servicePrestamo.listarHistorico();
			}else {
				prestamos = (ArrayList<Prestamo>) servicePrestamo.listarPrestados();
			}
			
			response = new ResponseEntity<>(prestamos, HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return response;
	}

	@RequestMapping(value = "/{idLibro}/{idAlumno}/{fechaInicio}", method = RequestMethod.GET)
	public ResponseEntity<Prestamo> detalle(@PathVariable long idLibro, @PathVariable long idAlumno, @PathVariable Date fechaInicio) {
		
		ResponseEntity<Prestamo> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		try {
			Prestamo prestamo = servicePrestamo.buscarPorId(idLibro, idAlumno, fechaInicio);
			if(prestamo != null /*&& fechaInicio != null && idLibro > 0 && idAlumno > 0*/) {
				Libro l = serviceLibro.buscarPorId(idLibro);
				Editorial e = serviceEditorial.buscarPorId(l.getEditorial().getId());
				l.setEditorial(e);
				prestamo.setLibro(l);
				response = new ResponseEntity<>(prestamo, HttpStatus.OK);
			}else {
				response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

		return response;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> prestar(@RequestBody Prestamo prestamo) {
		
		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		try {
			
			Set<ConstraintViolation<Prestamo>> violations = validator.validate(prestamo);
			if (violations.isEmpty()) {
			    /* Ha pasado la validacion*/
				if(servicePrestamo.prestar(prestamo/*prestamo.getLibro().getId(), prestamo.getAlumno().getId(), prestamo.getFecha_prestado()*/)) {
					Libro l = serviceLibro.buscarPorId(prestamo.getLibro().getId());
					
					Editorial e = serviceEditorial.buscarPorId(l.getEditorial().getId());					
					l.setEditorial(e);
					
					prestamo.setLibro(l);
					
					Alumno a = serviceAlumno.buscarPorId(prestamo.getAlumno().getId());
					prestamo.setAlumno(a);
					
					response = new ResponseEntity<>(prestamo, HttpStatus.CREATED);
				}else {
					ResponseMensaje msj = new ResponseMensaje("No se puede realizar el préstamo porque el alumno o el libro seleccionado no están disponibles.");
					response = new ResponseEntity<>(msj, HttpStatus.CONFLICT);
				}
			}else{
			    /* Hay fallos, la Validacion no es correcta */
				ResponseMensaje msj = new ResponseMensaje();
				msj.setMensaje("Los datos no son válidos.");
				 for (ConstraintViolation<Prestamo> violation : violations) {
					 msj.addError(violation.getPropertyPath()+": "+violation.getMessage());
				 }
				response = new ResponseEntity<>(msj, HttpStatus.CONFLICT);
			}
			
			
		}catch(MySQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
			ResponseMensaje msj = new ResponseMensaje("No se puede realizar el préstamo.");
			response = new ResponseEntity<>(msj, HttpStatus.CONFLICT);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		 
		return response;
	}
	
	@RequestMapping(value = "/{idLibro}/{idAlumno}/{fechaInicio}", method = RequestMethod.PUT)
	public ResponseEntity<Object> modificar(@PathVariable long idLibro, @PathVariable long idAlumno, @PathVariable Date fechaInicio, @RequestBody Prestamo prestamo) {
		
		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		try {
			Set<ConstraintViolation<Prestamo>> violations = validator.validate(prestamo);
			
//			prestamo.setId(id);
			
			if (violations.isEmpty()) {
			    /* Ha pasado la validacion*/
				if(servicePrestamo.update(idLibro, idAlumno, fechaInicio, prestamo.getLibro().getId(), prestamo.getAlumno().getId(), 
						prestamo.getFecha_prestado(), prestamo.getFecha_fin(), prestamo.getFecha_retorno())) {
					
					response = new ResponseEntity<>(prestamo, HttpStatus.OK);
				}else {
					response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}
			}else{
			    /* Hay fallos, la Validacion no es correcta */
				ResponseMensaje msj = new ResponseMensaje();
				msj.setMensaje("Los datos no son válidos.");
				 for (ConstraintViolation<Prestamo> violation : violations) {
					 msj.getErrores().add(violation.getPropertyPath()+": "+violation.getMessage());
				 }
				response = new ResponseEntity<>(msj, HttpStatus.CONFLICT);
			}
		}catch(MySQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
			ResponseMensaje msj = new ResponseMensaje("Debes seleccionar una editorial para el libro.");
			response = new ResponseEntity<>(msj, HttpStatus.CONFLICT);
		}catch(Exception e) {
			e.printStackTrace();
			ResponseMensaje msj = new ResponseMensaje("No existe el libro.");
			response = new ResponseEntity<>(msj, HttpStatus.NOT_FOUND);
		}
		 
		return response;
	}
	
	@RequestMapping(value = "/{idLibro}/{idAlumno}/{fechaInicio}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> devolver(@PathVariable long idLibro, @PathVariable long idAlumno, @PathVariable Date fechaInicio, @RequestBody Prestamo prestamo) {
		
		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		try {
			if(servicePrestamo.devolver(idLibro, idAlumno, fechaInicio, prestamo.getFecha_retorno())) {
				response = new ResponseEntity<>(HttpStatus.OK);
			}else {
				ResponseMensaje msj = new ResponseMensaje("No se puede devolver el préstamo");
				response = new ResponseEntity<>(msj, HttpStatus.CONFLICT);
			}
		}catch(MySQLIntegrityConstraintViolationException e) {
			ResponseMensaje msj = new ResponseMensaje("No se puede borrar el libro porque tiene préstamos asociados.");
			response = new ResponseEntity<>(msj, HttpStatus.CONFLICT);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return response;
	}
	
}
