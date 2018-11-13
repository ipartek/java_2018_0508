package com.ipartek.formacion.prestamos.api.controller;

import java.sql.Date;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Calendar;
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
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.prestamolibros.pojo.Alumno;
import com.ipartek.formacion.prestamolibros.pojo.Editorial;
import com.ipartek.formacion.prestamolibros.pojo.Libro;
import com.ipartek.formacion.prestamolibros.pojo.Prestamo;
import com.ipartek.formacion.prestamolibros.service.ServicioAlumno;
import com.ipartek.formacion.prestamolibros.service.ServicioEditorial;
import com.ipartek.formacion.prestamolibros.service.ServicioLibro;
import com.ipartek.formacion.prestamolibros.service.ServicioPrestamo;

@CrossOrigin(origins = "*")
@RestController
public class PrestamosController {
	
	ServicioPrestamo servicioPrestamo = null;
	ServicioLibro servicioLibro = null;
	ServicioAlumno servicioAlumno = null;
	ValidatorFactory factory = null;
	Validator validator = null;

	public PrestamosController() {
		super();
		servicioPrestamo = ServicioPrestamo.getInstance();
		servicioLibro = ServicioLibro.getInstance();
		servicioAlumno = ServicioAlumno.getInstance();
		
		//Crear Factoria y Validador
		 factory = Validation.buildDefaultValidatorFactory();
		 validator = factory.getValidator();
	}

	@RequestMapping( value="/prestamos", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Prestamo>> listado(@RequestParam("activo") boolean activo) {
		
		ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
		ResponseEntity<ArrayList<Prestamo>> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		try {
			
			if(activo) {
				prestamos = (ArrayList<Prestamo>) servicioPrestamo.prestados();
			}else {
				prestamos = (ArrayList<Prestamo>) servicioPrestamo.historico();
			}
			
			response = new ResponseEntity<>(prestamos, HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}

	@RequestMapping(value = "/libros/prestamos", method = RequestMethod.POST)
	public ResponseEntity<Object> crear(@RequestBody Prestamo prestamo) {
		
		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		ResponseMensaje msg = new ResponseMensaje();

		try {

			Libro libro = servicioLibro.buscar(prestamo.getLibro().getId());
			prestamo.setLibro(libro);
			
			Alumno alumno = servicioAlumno.buscar(prestamo.getAlumno().getId());
			prestamo.setAlumno(alumno);
			
			Set<ConstraintViolation<Prestamo>> violations = validator.validate(prestamo);
			if(violations.isEmpty()) {
				
				if(servicioPrestamo.prestar(prestamo.getLibro().getId(), prestamo.getAlumno().getId(), prestamo.getFechaInicio())) {
					
					Prestamo pr = conseguirFechaFin(prestamo);
					
					response = new ResponseEntity<>(pr, HttpStatus.CREATED);
					
				}else {
					response = new ResponseEntity<>(prestamo, HttpStatus.CONFLICT);
				}
				
			}else {

				msg.setMensaje("No se pudo realizar el préstamo");
				
				for (ConstraintViolation<Prestamo> violation : violations) {
					
					msg.addError(violation.getPropertyPath() + ": " + violation.getMessage());
				}
				
				response = new ResponseEntity<>(msg, HttpStatus.CONFLICT);
			}
			
		} catch(SQLIntegrityConstraintViolationException e){
			response = new ResponseEntity<>(new ResponseMensaje("El libro " + prestamo.getLibro().getTitulo() + " ya esta prestado."), HttpStatus.CONFLICT);
					
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return response;
		
	}


	private Prestamo conseguirFechaFin(Prestamo prestamo) throws Exception {

		ArrayList<Prestamo> prestamos = (ArrayList<Prestamo>) servicioPrestamo.prestados();	
		for (Prestamo pr : prestamos) {
			if(pr.getAlumno().getId() == prestamo.getAlumno().getId() &&
					pr.getLibro().getId() == prestamo.getLibro().getId() &&
					(pr.getFechaInicio().compareTo(prestamo.getFechaInicio())) == -1) {
				prestamo = pr;
			}
		}
		
		return prestamo;
		
	}
}
