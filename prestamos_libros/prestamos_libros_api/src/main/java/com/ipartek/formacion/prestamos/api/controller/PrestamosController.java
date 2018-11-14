package com.ipartek.formacion.prestamos.api.controller;

import java.sql.Date;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.prestamolibros.pojo.Alumno;
import com.ipartek.formacion.prestamolibros.pojo.Editorial;
import com.ipartek.formacion.prestamolibros.pojo.Libro;
import com.ipartek.formacion.prestamolibros.pojo.Prestamo;
import com.ipartek.formacion.prestamolibros.service.ServicioAlumno;
import com.ipartek.formacion.prestamolibros.service.ServicioLibro;
import com.ipartek.formacion.prestamolibros.service.ServicioPrestamo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@CrossOrigin(origins = "*")
@RestController
@Api(value = "Prestamos", tags = { "Prestamos" })
public class PrestamosController {
	
	private final static Logger LOG = Logger.getLogger(PrestamosController.class);
	ServicioPrestamo servicioPrestamo = null;
	ServicioLibro servicioLibro = null;
	ServicioAlumno servicioAlumno = null;
	ValidatorFactory factory = null;
	Validator validator = null;

	public PrestamosController() {
		super();
		LOG.trace("constructor");
		servicioPrestamo = ServicioPrestamo.getInstance();
		servicioLibro = ServicioLibro.getInstance();
		servicioAlumno = ServicioAlumno.getInstance();
		LOG.trace("servicios instanciados");
		
		//Crear Factoria y Validador
		 factory = Validation.buildDefaultValidatorFactory();
		 validator = factory.getValidator();
	}

	@ApiOperation(value = "Listado de préstamos activos o histórico")
	@ApiResponses(value = { 
							@ApiResponse(code = 200, message = "Listado préstamos"),
							@ApiResponse(code = 400, message = "Listado préstamos") }
				)
	@ApiParam(value="true- Préstamos activos false- Histórico de préstamos", required=false, name="activo", defaultValue="1")
	@RequestMapping( value="/prestamos", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Prestamo>> listado(@RequestParam(name="activo", required=false, defaultValue="1") boolean activo) {
		
		ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
		ResponseEntity<ArrayList<Prestamo>> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		try {
			
			if(activo) {
				prestamos = (ArrayList<Prestamo>) servicioPrestamo.prestados();
				LOG.debug("préstamos recuperados " + prestamos.size());
			}else {
				prestamos = (ArrayList<Prestamo>) servicioPrestamo.historico();
			}
			
			response = new ResponseEntity<>(prestamos, HttpStatus.OK);
			
		} catch (Exception e) {
			LOG.error(e);
			//e.printStackTrace();
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
			LOG.error(e);
		}
		
		return response;
		
	}
	
	@RequestMapping(value = "/libros/{idLibro}/prestamos/{idAlumno}/{fechaInicio}", method = RequestMethod.PUT)
	public ResponseEntity<Object> modificar(@PathVariable("idLibro") long idLibro, @PathVariable("idAlumno") long idAlumno, 
			@PathVariable("fechaInicio") Date fechaInicio, @RequestBody Prestamo p) {
		
		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		ResponseMensaje msg = new ResponseMensaje();
		
		try {
			
			Libro libro = servicioLibro.buscar(p.getLibro().getId());
			p.setLibro(libro);
			
			Alumno alumno = servicioAlumno.buscar(p.getAlumno().getId());
			p.setAlumno(alumno);
			
			Set<ConstraintViolation<Prestamo>> violations = validator.validate(p);
			if(violations.isEmpty()) {
				
				if(p.getDevuelto() == null) {
					
					if(servicioPrestamo.modificarPrestamo(p.getLibro().getId(), p.getAlumno().getId(), p.getFechaInicio(), 
							p.getFechaFin(), idLibro, idAlumno, fechaInicio)) {
						Prestamo pr = conseguirFechaFin(p);
						response = new ResponseEntity<>(pr, HttpStatus.OK);
					}else {
						response = new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
					}
				
				}else {
															
					if(servicioPrestamo.modificarHistorico(p.getLibro().getId(), p.getAlumno().getId(), p.getFechaInicio(), p.getFechaFin(), 
							p.getDevuelto(), idLibro, idAlumno, fechaInicio)) {
						Prestamo pr = conseguirFechaFin(p);
						response = new ResponseEntity<>(pr, HttpStatus.OK);
					}else {
						response = new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
					}
				}
				
				
			}else {
				
				msg.setMensaje("No se pudo modificar el libro");
				
				for (ConstraintViolation<Prestamo> violation : violations) {
					
					msg.addError(violation.getPropertyPath() + ": " + violation.getMessage());
				}
				
				response = new ResponseEntity<>(msg, HttpStatus.CONFLICT);
				
			}
			
		//}catch(SQLIntegrityConstraintViolationException e){
			//response = new ResponseEntity<>(new ResponseMensaje("No se pudo modificar el libro ya que no existe la editorial indicada."), HttpStatus.CONFLICT);
			
		} catch (Exception e) {
			LOG.error(e);
		}
		
		return response;	
		
	}
	
	@RequestMapping(value = "/libros/{idLibro}/prestamos/{idAlumno}/{fechaInicio}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> devolver(@PathVariable("idLibro") long idLibro, @PathVariable("idAlumno") long idAlumno, 
			@PathVariable("fechaInicio") Date fechaInicio, @RequestBody Prestamo p) {
		
		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		ResponseMensaje msg = new ResponseMensaje();
		
		try {
			
			Libro libro = servicioLibro.buscar(idLibro);
			p.setLibro(libro);
			
			Alumno alumno = servicioAlumno.buscar(idAlumno);
			p.setAlumno(alumno);
			
			Set<ConstraintViolation<Prestamo>> violations = validator.validate(p);
			if(violations.isEmpty()) {
				
				if(servicioPrestamo.devolver(idAlumno, idLibro, fechaInicio, p.getDevuelto())) {
					response = new ResponseEntity<>(p, HttpStatus.OK);
				
				}else {
					msg.setMensaje("Debe introducir fecha de devolución");
					response = new ResponseEntity<>(msg, HttpStatus.CONFLICT);
				}
				
				
			}else {
				
				msg.setMensaje("No se pudo devolver el libro");
				
				for (ConstraintViolation<Prestamo> violation : violations) {
					
					msg.addError(violation.getPropertyPath() + ": " + violation.getMessage());
				}
				
				response = new ResponseEntity<>(msg, HttpStatus.CONFLICT);
				
			}
			
		//}catch(SQLIntegrityConstraintViolationException e){
			//response = new ResponseEntity<>(new ResponseMensaje("No se pudo modificar el libro ya que no existe la editorial indicada."), HttpStatus.CONFLICT);
			
		} catch (Exception e) {
			LOG.error(e);
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
