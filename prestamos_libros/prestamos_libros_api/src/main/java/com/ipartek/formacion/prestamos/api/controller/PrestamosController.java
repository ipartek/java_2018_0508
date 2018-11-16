package com.ipartek.formacion.prestamos.api.controller;

import java.sql.Date;
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

import com.ipartek.formacion.prestamolibros.pojo.Prestamo;
import com.ipartek.formacion.prestamolibros.service.ServicioAlumno;
import com.ipartek.formacion.prestamolibros.service.ServicioLibro;
import com.ipartek.formacion.prestamolibros.service.ServicioPrestamo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "*")
@RestController
@Api(tags = { "Prestamos" }, produces = "application/json", description="Gestión de préstamos") 
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
	@ApiParam(value="activo", required=false, name="activo", defaultValue="1")
	@RequestMapping( value="/prestamos", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Prestamo>> listado(
					@ApiParam(value="No obligatorio <br> true - Préstamos activos <br> false - Histórico de préstamos")
					@RequestParam(name="activo", required=false, defaultValue="true") boolean activo) {
		
		ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
		ResponseEntity<ArrayList<Prestamo>> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		try {
			
			if(activo) {
				prestamos = (ArrayList<Prestamo>) servicioPrestamo.prestados();
				LOG.debug("Préstamos recuperados " + prestamos.size());
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

	@RequestMapping(value = "/prestamos", method = RequestMethod.POST)
	@ApiResponses(value = { 
			@ApiResponse(code = 201, message = "Préstamo realizado.", response = Prestamo.class),
			@ApiResponse(code = 400, message = "Faltan campos obligatorios.", response = ResponseMensaje.class),
			@ApiResponse(code = 409, message = "<ol>"
											 + "<li>No existe el libro o alumno indicado.</li>"
											 + "<li>Libro o usuario ya tiene un préstamo activo.</li>"
											 + "</ol>"
											 , response = ResponseMensaje.class),
			@ApiResponse(code = 500, message = "Error fatal")}
			)
	@ApiOperation(value = "Prestar un libro a un alumno para una fecha concreta.",
				  response = Prestamo.class,
				  notes="Campos obligatorios:"
				  	  + "<ol>"
				  	  + "<li><b>libro.id</b> Identificador del libro</li>"
				  	  + "<li><b>alumno.id</b> Identificador del alumno</li>"
				  	  + "<li><b>fecha_inicio</b> Fecha inicio del préstamo</li>"
				  	  + "</ol>")
	public ResponseEntity<Object> crear(@RequestBody Prestamo prestamo) {
		
		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		ResponseMensaje msg = new ResponseMensaje();

		try {
			
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
			
		
		}catch (Exception e) {
			String message = e.getMessage();
			ResponseMensaje responseMsg = null;
			
			if (message.equals(ServicioPrestamo.EXCEPTION_LIBRO_PRESTADO)
					|| message.equals(ServicioPrestamo.EXCEPTION_ALUMNO_PRESTADO)) {

				responseMsg = new ResponseMensaje(message);
				response = new ResponseEntity<Object>(responseMsg,HttpStatus.CONFLICT);

			}else {
				responseMsg = new ResponseMensaje(message);
				response = new ResponseEntity<Object>(responseMsg,HttpStatus.BAD_REQUEST);
			}

			LOG.debug(e);
		}
		
		return response;
		
	}
	
	@RequestMapping(value = "/prestamos/{idLibro}/{idAlumno}/{fechaInicio}", method = RequestMethod.PUT)
	@ApiOperation(value = "Modificar un préstamo, esté activo o no.", response = Prestamo.class)
	public ResponseEntity<Object> modificar(@PathVariable("idLibro") long idLibro, @PathVariable("idAlumno") long idAlumno, 
			@PathVariable("fechaInicio") Date fechaInicio, @RequestBody Prestamo p) {
		
		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		ResponseMensaje msg = new ResponseMensaje();
		
		try {
			
			if(p.getDevuelto() == null) {
					
				if(servicioPrestamo.modificarPrestamo(p.getLibro().getId(), p.getAlumno().getId(), p.getFechaInicio(), 
						p.getFechaFin(), idLibro, idAlumno, fechaInicio)) {
					Prestamo pr = conseguirFechaFin(p);
					response = new ResponseEntity<>(pr, HttpStatus.OK);
				}else {
					msg.setMensaje(ServicioPrestamo.EXCEPTION_PARAMETROS_INCORRECTOS_PRESTAMO);
					response = new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
				}
				
			}else {
															
				if(servicioPrestamo.modificarHistorico(p.getLibro().getId(), p.getAlumno().getId(), p.getFechaInicio(), p.getFechaFin(), 
						p.getDevuelto(), idLibro, idAlumno, fechaInicio)) {
					Prestamo pr = conseguirFechaFin(p);
					response = new ResponseEntity<>(pr, HttpStatus.OK);
				}else {
					msg.setMensaje(ServicioPrestamo.EXCEPTION_PARAMETROS_INCORRECTOS_DEVOLUCION);
					response = new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
				}
			}
			
			
		} catch (Exception e) {
			String message = e.getMessage();
			ResponseMensaje responseMsg = null;
			
			if (message.equals(ServicioPrestamo.EXCEPTION_LIBRO_SIN_PRESTAMO)
					|| message.equals(ServicioPrestamo.EXCEPTION_ALUMNO_SIN_PRESTAMO)
					|| message.equals(ServicioPrestamo.EXCEPTION_ALUMNO_PRESTADO)
					|| message.equals(ServicioPrestamo.EXCEPTION_LIBRO_PRESTADO)) {

				responseMsg = new ResponseMensaje(message);
				response = new ResponseEntity<Object>(responseMsg,HttpStatus.CONFLICT);

			}else {
				responseMsg = new ResponseMensaje(message);
				response = new ResponseEntity<Object>(responseMsg,HttpStatus.BAD_REQUEST);
			}

			LOG.debug(e);
		}
		
		return response;	
		
	}
	
	@RequestMapping(value = "/prestamos/{idLibro}/{idAlumno}/{fechaInicio}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Devolver un libro", response = Prestamo.class,
				  notes="Campos obligatorios:"
				  	  + "<ol>"
				  	  + "<li><b>libro.id</b> Identificador del libro</li>"
				  	  + "<li><b>alumno.id</b> Identificador del alumno</li>"
				  	  + "<li><b>fecha_inicio</b> Fecha inicio del préstamo</li>"
				  	  + "<li><b>devuelto</b> Fecha de devolución del préstamo</li>"
				  	  + "<li>El formato de fecha es: <b>yyyy-MM-dd</b></li>"
				  	  + "</ol>")
	public ResponseEntity<Object> devolver(@PathVariable("idLibro") long idLibro, @PathVariable("idAlumno") long idAlumno, 
			@PathVariable("fechaInicio") Date fechaInicio, @RequestBody Prestamo prestamo) {
		
		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		ResponseMensaje msg = new ResponseMensaje();
		
		try {
			
			//Set<ConstraintViolation<Prestamo>> violations = validator.validate(prestamo);
			//if(violations.isEmpty()) {
				
			if(servicioPrestamo.devolver(idAlumno, idLibro, fechaInicio, prestamo.getDevuelto())) {
				response = new ResponseEntity<>(prestamo, HttpStatus.OK);
				
			}else {
				msg.setMensaje(ServicioPrestamo.EXCEPTION_PARAMETROS_INCORRECTOS_DEVOLUCION);
				response = new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
				//}
				
				
			/*}else {
				
				msg.setMensaje("No se pudo devolver el libro");
				
				for (ConstraintViolation<Prestamo> violation : violations) {
					
					msg.addError(violation.getPropertyPath() + ": " + violation.getMessage());
				}
				
				response = new ResponseEntity<>(msg, HttpStatus.CONFLICT);
				*/
			}
			
		//}catch(SQLIntegrityConstraintViolationException e){
			//response = new ResponseEntity<>(new ResponseMensaje("No se pudo modificar el libro ya que no existe la editorial indicada."), HttpStatus.CONFLICT);
			
		}catch (Exception e) {
			String message = e.getMessage();
			ResponseMensaje responseMsg = null;
			
			if (message.equals(ServicioPrestamo.EXCEPTION_LIBRO_SIN_PRESTAMO)
					|| message.equals(ServicioPrestamo.EXCEPTION_ALUMNO_SIN_PRESTAMO)) {

				responseMsg = new ResponseMensaje(message);
				response = new ResponseEntity<Object>(responseMsg,HttpStatus.CONFLICT);

			}else {
				responseMsg = new ResponseMensaje(message);
				response = new ResponseEntity<Object>(responseMsg,HttpStatus.BAD_REQUEST);
			}

			LOG.debug(e);
		}
		
		return response;	
		
	}

	private Prestamo conseguirFechaFin(Prestamo prestamo) throws Exception {

		ArrayList<Prestamo> prestamos = (ArrayList<Prestamo>) servicioPrestamo.prestados();	
		try {
			for (Prestamo pr : prestamos) {
				if(pr.getAlumno().getId() == prestamo.getAlumno().getId() &&
						pr.getLibro().getId() == prestamo.getLibro().getId() &&
						(pr.getFechaInicio().compareTo(prestamo.getFechaInicio())) == -1) {
					prestamo = pr;
				}
			}
		} catch (Exception e) {
			LOG.error(e);
		}
		
		return prestamo;
		
	}
}
