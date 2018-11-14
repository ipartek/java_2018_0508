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

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

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

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/libros")
public class LibrosController {
	
	ServiceLibro serviceLibro = null;
	ServiceEditorial serviceEditorial = null;
	ServicePrestamo servicePrestamo = null;
	ServiceAlumno serviceAlumno = null;
	ValidatorFactory factory = null;
	Validator validator = null;
	
	//Logger
	private final static Logger LOG = Logger.getLogger(LibrosController.class);
	
	public LibrosController() {
		super();
		
		LOG.trace("Constructor");
		serviceLibro = ServiceLibro.getInstance();
		LOG.trace("Servicio libro instanciado");
		serviceEditorial = ServiceEditorial.getInstance();
		LOG.trace("Servicio editorial instanciado");
		servicePrestamo = ServicePrestamo.getInstance();
		LOG.trace("Servicio prestamo instanciado");
		serviceAlumno = ServiceAlumno.getInstance();
		LOG.trace("Servicio alumno instanciado");
		
		//Crear Factoria y Validador
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@ApiOperation(value = "Listado de libros", notes = "Muestra el listado de todos los libros", produces="application/json")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Mostrar lista de libros correctamente", responseContainer="List")})
	@RequestMapping( method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Libro>> listado() {
		ResponseEntity<ArrayList<Libro>> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		ArrayList<Libro> libros = new ArrayList<Libro>();
		
		try {
			libros = (ArrayList<Libro>) serviceLibro.listar();
			response = new ResponseEntity<>(libros, HttpStatus.OK);
			LOG.debug("Lista de libros devuelta correctamente "+libros.size());
		}catch(Exception e) {
//			e.printStackTrace();
			LOG.error(e);
		}
		
		return response;
	}

	@ApiOperation(value = "Detalle libro", notes = "Muestra el detalle de un libro en concreto", produces="application/json")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Mostrar detalle libro correctamente", responseContainer="Libro"),
							@ApiResponse(code = 404, message = "No existe el libro")})
	@ApiImplicitParams({
	    @ApiImplicitParam(name = "id", value = "Id libro", required = true, dataType = "long", paramType = "Path")
	  })
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Libro> detalle(@PathVariable long id) {
		
		ResponseEntity<Libro> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		try {
			Libro libro = serviceLibro.buscarPorId(id);
			if(libro != null && libro.getId() > 0) {
				response = new ResponseEntity<>(libro, HttpStatus.OK);
				LOG.debug("Detalle del libro devuelto correctamente");
			}else {
				response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
				LOG.warn("No se ha encontrado el libro a mostrar");
			}
		}catch(Exception e) {
//			e.printStackTrace();
			LOG.error(e);
		}

		return response;
	}
	
	@ApiOperation(value = "Crear libro", notes = "Crea un nuevo libro", produces="application/json")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Crear un libro correctamente", responseContainer="Editorial"),
			@ApiResponse(code = 409, message = "Conflicto por crear un libro sin editorial asociada o con nombre vacío")})
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> crear(@RequestBody Libro libro) {
		
		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		try {
			
			Set<ConstraintViolation<Libro>> violations = validator.validate(libro);
			if (violations.isEmpty()) {
			    /* Ha pasado la validacion*/
				if(serviceLibro.crear(libro)) {
					Editorial editorial = serviceEditorial.buscarPorId(libro.getEditorial().getId());
					libro.getEditorial().setNombre(editorial.getNombre());
					response = new ResponseEntity<>(libro, HttpStatus.CREATED);
					LOG.debug("Libro creado correctamente");
				}else {
					response = new ResponseEntity<>(HttpStatus.CONFLICT);
					LOG.warn("Conflicto al crear un nuevo libro");
				}
			}else{
			    /* Hay fallos, la Validacion no es correcta */
				ResponseMensaje msj = new ResponseMensaje();
				msj.setMensaje("Los datos no son válidos.");
				 for (ConstraintViolation<Libro> violation : violations) {
					 msj.addError(violation.getPropertyPath()+": "+violation.getMessage());
					 LOG.warn("Errores de validacion al crear un libro: "+violation.getPropertyPath()+": "+violation.getMessage());
				 }
				response = new ResponseEntity<>(msj, HttpStatus.CONFLICT);
			}
			
			
		}catch(MySQLIntegrityConstraintViolationException e) {
//			e.printStackTrace();
			LOG.error(e);
			ResponseMensaje msj = new ResponseMensaje("Debe seleccionar una editorial para el libro.");
			response = new ResponseEntity<>(msj, HttpStatus.CONFLICT);
		}
		catch(Exception e) {
//			e.printStackTrace();
			LOG.error(e);
		}
		 
		return response;
	}
	
	@ApiOperation(value = "Modificar libro", notes = "Modifica los valores de un libro", produces="application/json")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Modificar un libro correctamente"),
			@ApiResponse(code = 409, message = "Conflicto por crear un libro sin editorial asociada o con nombre vacío")})
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> modificar(@PathVariable long id, @RequestBody Libro libro) {
		
		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		try {
			Set<ConstraintViolation<Libro>> violations = validator.validate(libro);
			
			libro.setId(id);
			
			if (violations.isEmpty()) {
			    /* Ha pasado la validacion*/
				if(serviceLibro.modificar(libro)) {
					Editorial editorial = serviceEditorial.buscarPorId(libro.getEditorial().getId());
					libro.getEditorial().setNombre(editorial.getNombre());
					response = new ResponseEntity<>(libro, HttpStatus.OK);
					LOG.debug("Libro modificado correctamente");
				}else {
					response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
					LOG.warn("No se ha encontrado el libro a modificar");
				}
			}else{
			    /* Hay fallos, la Validacion no es correcta */
				ResponseMensaje msj = new ResponseMensaje();
				msj.setMensaje("Los datos no son válidos.");
				 for (ConstraintViolation<Libro> violation : violations) {
					 msj.getErrores().add(violation.getPropertyPath()+": "+violation.getMessage());
					 LOG.warn("Error de validacion al modificar un libro: "+violation.getPropertyPath()+": "+violation.getMessage());
				 }
				response = new ResponseEntity<>(msj, HttpStatus.CONFLICT);
			}
		}catch(MySQLIntegrityConstraintViolationException e) {
//			e.printStackTrace();
			LOG.error(e);
			ResponseMensaje msj = new ResponseMensaje("Debes seleccionar una editorial para el libro.");
			response = new ResponseEntity<>(msj, HttpStatus.CONFLICT);
		}catch(Exception e) {
//			e.printStackTrace();
			LOG.error(e);
			ResponseMensaje msj = new ResponseMensaje("No existe el libro.");
			response = new ResponseEntity<>(msj, HttpStatus.NOT_FOUND);
		}
		 
		return response;
	}
	
	@ApiOperation(value = "Eliminar libro", notes = "Elimina un libro existente", produces="application/json")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Eliminar un libro correctamente"),
			@ApiResponse(code = 404, message = "No existe el libro a borrar"),
			@ApiResponse(code = 409, message = "Conflicto por intentar eliminar un libro que tiene préstamos asociados")})
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> eliminar(@PathVariable long id) {
		
		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		try {
			if(serviceLibro.eliminar(id)) {
				response = new ResponseEntity<>(HttpStatus.OK);
				LOG.debug("Libro eliminado correctamente");
			}else {
				ResponseMensaje msj = new ResponseMensaje("No se puede borrar un registro que no existe");
				response = new ResponseEntity<>(msj, HttpStatus.NOT_FOUND);
				LOG.warn("No se ha encontrado el libro a eliminar");
			}
		}catch(MySQLIntegrityConstraintViolationException e) {
//			e.printStackTrace();
			LOG.error(e);
			ResponseMensaje msj = new ResponseMensaje("No se puede borrar el libro porque tiene préstamos asociados.");
			response = new ResponseEntity<>(msj, HttpStatus.CONFLICT);
		}catch(Exception e) {
//			e.printStackTrace();
			LOG.error(e);
		}
		
		return response;
	}
	
	//Detalle Prestamo de un libro
	@RequestMapping(value = "/{idLibro}/prestamos/{idAlumno}/{fechaInicio}", method = RequestMethod.GET)
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
				LOG.debug("Detalle prestamo recogido");
			}else {
				response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
				LOG.warn("No se ha encontrado el prestamo");
			}
		}catch(Exception e) {
//			e.printStackTrace();
			LOG.error(e);
		}

		return response;
	}
	
	//Crear un nuevo prestamo
	@RequestMapping(value = "/prestamos", method = RequestMethod.POST)
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
					LOG.debug("Nuevo prestamo creado correctamente");
				}else {
					ResponseMensaje msj = new ResponseMensaje("No se puede realizar el préstamo porque el alumno o el libro seleccionado no están disponibles.");
					response = new ResponseEntity<>(msj, HttpStatus.CONFLICT);
					LOG.warn("No se ha podido crear el prestamo porque el alumno o el libro no estan disponibles");
				}
			}else{
			    /* Hay fallos, la Validacion no es correcta */
				ResponseMensaje msj = new ResponseMensaje();
				msj.setMensaje("Los datos no son válidos.");
				 for (ConstraintViolation<Prestamo> violation : violations) {
					 msj.addError(violation.getPropertyPath()+": "+violation.getMessage());
					 LOG.warn("Error de validacion al crear: "+violation.getPropertyPath()+": "+violation.getMessage());
				 }
				response = new ResponseEntity<>(msj, HttpStatus.CONFLICT);				
			}
			
			
		}catch(MySQLIntegrityConstraintViolationException e) {
//			e.printStackTrace();
			LOG.error(e);
			ResponseMensaje msj = new ResponseMensaje("No se puede realizar el préstamo.");
			response = new ResponseEntity<>(msj, HttpStatus.CONFLICT);
		}
		catch(Exception e) {
//			e.printStackTrace();
			LOG.error(e);
		}
		 
		return response;
	}
	
	//Modificar un prestamo existente
	@RequestMapping(value = "/{idLibro}/prestamos/{idAlumno}/{fechaInicio}", method = RequestMethod.PUT)
	public ResponseEntity<Object> modificar(@PathVariable long idLibro, @PathVariable long idAlumno, @PathVariable Date fechaInicio, @RequestBody Prestamo prestamo) {
		
		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		try {
			Set<ConstraintViolation<Prestamo>> violations = validator.validate(prestamo);
			
			if (violations.isEmpty()) {
			    /* Ha pasado la validacion*/
				if(servicePrestamo.update(idLibro, idAlumno, fechaInicio, prestamo.getLibro().getId(), prestamo.getAlumno().getId(), 
						prestamo.getFecha_prestado(), prestamo.getFecha_fin(), prestamo.getFecha_retorno())) {
					
					Libro l = serviceLibro.buscarPorId(prestamo.getLibro().getId());
					
					Editorial e = serviceEditorial.buscarPorId(l.getEditorial().getId());					
					l.setEditorial(e);
					
					prestamo.setLibro(l);
					
					Alumno a = serviceAlumno.buscarPorId(prestamo.getAlumno().getId());
					prestamo.setAlumno(a);
					
					response = new ResponseEntity<>(prestamo, HttpStatus.OK);
					LOG.debug("Prestamo modificado correctamente");
				}else {
					response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
					LOG.warn("No se ha encontrado el prestamo a modificar");
				}
			}else{
			    /* Hay fallos, la Validacion no es correcta */
				ResponseMensaje msj = new ResponseMensaje();
				msj.setMensaje("Los datos no son válidos.");
				 for (ConstraintViolation<Prestamo> violation : violations) {
					 msj.getErrores().add(violation.getPropertyPath()+": "+violation.getMessage());
					 LOG.warn("Error de validacion al modificar: "+violation.getPropertyPath()+": "+violation.getMessage());
				 }
				response = new ResponseEntity<>(msj, HttpStatus.CONFLICT);
			}
		}catch(MySQLIntegrityConstraintViolationException e) {
//			e.printStackTrace();
			LOG.error(e);
			ResponseMensaje msj = new ResponseMensaje("Debes seleccionar una editorial para el libro.");
			response = new ResponseEntity<>(msj, HttpStatus.CONFLICT);
		}catch(Exception e) {
//			e.printStackTrace();
			LOG.error(e);
			ResponseMensaje msj = new ResponseMensaje("No existe el libro.");
			response = new ResponseEntity<>(msj, HttpStatus.NOT_FOUND);
		}
		 
		return response;
	}
	
	//Devolver un libro (finalizar un prestamo)
	@RequestMapping(value = "/{idLibro}/prestamos/{idAlumno}/{fechaInicio}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> devolver(@PathVariable long idLibro, @PathVariable long idAlumno, @PathVariable Date fechaInicio, @RequestBody Prestamo prestamo) {
		
		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		try {
			if(servicePrestamo.devolver(idLibro, idAlumno, fechaInicio, prestamo.getFecha_retorno())) {
				response = new ResponseEntity<>(HttpStatus.OK);
				LOG.debug("Libro devuelto correctamente");
			}else {
				ResponseMensaje msj = new ResponseMensaje("No se puede devolver el libro");
				response = new ResponseEntity<>(msj, HttpStatus.CONFLICT);
				LOG.warn("No se puede devolver el libro");
			}
		}catch(MySQLIntegrityConstraintViolationException e) {
//			e.printStackTrace();
			LOG.error(e);
			ResponseMensaje msj = new ResponseMensaje("No se puede devolver el libro.");
			response = new ResponseEntity<>(msj, HttpStatus.CONFLICT);
		}catch(Exception e) {
//			e.printStackTrace();
			LOG.error(e);
		}
		
		return response;
	}
	
}
