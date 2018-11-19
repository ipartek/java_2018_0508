package com.ipartek.formacion.prestamos.api.controller;

import java.sql.Date;
import java.util.ArrayList;

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

import com.ipartek.formacion.prestamos_libros.pojo.Libro;
import com.ipartek.formacion.prestamos_libros.pojo.Prestamo;
import com.ipartek.formacion.prestamos_libros.pojo.Usuario;
import com.ipartek.formacion.prestamos_libros.service.ServicePrestamo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;
@Api(tags= {"Prestamos"}, produces="application/json", description="Gestion Prestamos")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/prestamos")
public class PrestamosController {
	
	private final static Logger LOG = Logger.getLogger(PrestamosController.class);

	ServicePrestamo servicePrestamo = null;
	ValidatorFactory factory = null;
	Validator validator = null;


	public PrestamosController() {
		super();
		LOG.trace("constructor");
		servicePrestamo = ServicePrestamo.getInstance();
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
		LOG.trace("Servicios prestamos instanciados");
		
	}
	@ApiOperation(value = "Listado Prestamos Activos o Historico")
	@ApiResponses( value = {
			@ApiResponse (code = 200, message = "Listado Prestamos"),
			@ApiResponse (code = 404, message = "No se encontro prestamo")}
	)
	
	@ApiParam( value="activo", required = false, defaultValue = "1")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Prestamo>> listado(
			@ApiParam(value = "No obligatorio <ol><li>true: Prestamos sin retornar</li> <li>false: Prestamos Retornados</li>")
			@RequestParam(value = "activo", required = false, defaultValue = "true") boolean estado) {

		ArrayList<Prestamo> list = new ArrayList<Prestamo>();
		ResponseEntity<ArrayList<Prestamo>> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {
			if(estado) {
				list = (ArrayList<Prestamo>) servicePrestamo.listar();
				LOG.debug("prestamos recuperados" + list.size());
			}else {
				list = (ArrayList<Prestamo>) servicePrestamo.listardevueltos();
			}
			
			response = new ResponseEntity<>(list, HttpStatus.OK);

		} catch (Exception e) {
			LOG.error(e);
		}

		return response;
	}
	
	@ApiOperation(value = "Dar de alta prestamo", 
			notes = "Campos obligatorios: <ol><li><b>fech_inicio</b>: Fecha_inicio</li> <li><b>libro.id</b>: Identificador del libro</li> <li><b>usuario.id</b>: Identificador del usuario</li></ol>", 
			response = Prestamo.class)
	@ApiResponses( value = {
			@ApiResponse (code = 201, message = "Prestamo realizado", response = Prestamo.class),
			@ApiResponse (code = 400, message = "Faltan campos obligatorios", response = ResponseMensaje.class),
			@ApiResponse (code = 409, message = "<ol><li>El libro o alumno ya tiene prestamos activos</li> <li>El libro o alumno no existe</li></ol>", response = ResponseMensaje.class)}
	)
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> crear(@RequestBody Prestamo prestamo){
		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		try {
			if (servicePrestamo.crear(prestamo)) {
				response = new ResponseEntity<Object>(prestamo, HttpStatus.CREATED);
			} else {
				response = new ResponseEntity<Object>(prestamo, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		} catch (Exception e) {
			
			String message = e.getMessage();
			ResponseMensaje responseMsg = null;
			
			if (message.equals(ServicePrestamo.EXCEPTION_LIBRO_PRESTADO)
					|| message.equals(ServicePrestamo.EXCEPTION_USUARIO_PRESTADO)) {
 				responseMsg = new ResponseMensaje(message);
				response = new ResponseEntity<Object>(responseMsg,HttpStatus.CONFLICT);
 			}else {
				responseMsg = new ResponseMensaje(message);
				response = new ResponseEntity<Object>(responseMsg,HttpStatus.BAD_REQUEST);
			}
			
			LOG.error(e);
		}
		
		return response;
	}
	
	@ApiOperation(value = "Devolver prestamo", response = Prestamo.class)
	@ApiResponses( value = {
			@ApiResponse (code = 201, message = "Devolver Prestamo"),
			@ApiResponse (code = 409, message = "<ol><li>No cumple validaciones</li> <li>El libro, usuario o prestamo no existe</li></ol>")}
	)
	
	@RequestMapping(value = "/{idUsuario}/{idLibro}/{finicio}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> devolver(@PathVariable long idUsuario, @PathVariable long idLibro, @PathVariable Date finicio, @RequestBody Prestamo prestamo){
		ResponseEntity<Object> response = null;
		
		try {
			prestamo.setUsuario(new Usuario(idUsuario, ""));
			prestamo.setLibro(new Libro(idLibro, "", "", null));
			prestamo.setFech_inicio(finicio);
			
			
			if(servicePrestamo.devolver(prestamo)) {
				response = new ResponseEntity<Object>(prestamo, HttpStatus.CREATED);
			}else {
				response = new ResponseEntity<>(prestamo, HttpStatus.INTERNAL_SERVER_ERROR);
			}

		} catch (Exception e) {
			String message = e.getMessage();
			ResponseMensaje responseMsg = null;
			
			if (message.equals(ServicePrestamo.EXCEPTION_LIBRO_NO_PRESTADO)
					|| message.equals(ServicePrestamo.EXCEPTION_USUARIO_NO_PRESTADO)) {
 				responseMsg = new ResponseMensaje(message);
				response = new ResponseEntity<Object>(responseMsg,HttpStatus.CONFLICT);
 			}else {
				responseMsg = new ResponseMensaje(message);
				response = new ResponseEntity<Object>(responseMsg,HttpStatus.BAD_REQUEST);
			}
			
			LOG.error(e);
		}
		
		
		return response;
	}

	@ApiOperation(value = "Modificar Prestamo", response = Prestamo.class)
	@ApiResponses( value = {
			@ApiResponse (code = 201, message = "Modificar Prestamo"),
			@ApiResponse (code = 409, message = "<ol><li>No cumple validaciones</li> <li>El libro, usuario o prestamo no existe</li></ol>")}
	)
	
	@RequestMapping(value = "/{idUsuario}/{idLibro}/{finicio}", method = RequestMethod.PUT)
	public ResponseEntity<Object> modificar(@PathVariable long idUsuario, @PathVariable long idLibro, @PathVariable Date finicio, @RequestBody Prestamo prestamoNuevo){
		ResponseEntity<Object> response = null;
		
		try {
			Prestamo p = new Prestamo();
			Libro l = new Libro();
			Usuario u = new Usuario();
			l.setId(idLibro);
			p.setLibro(l);
			u.setId(idUsuario);
			p.setUsuario(u);
			p.setFech_inicio(finicio);
			
			if(servicePrestamo.modificarHistorico(prestamoNuevo, p)) {
				response = new ResponseEntity<Object>(prestamoNuevo, HttpStatus.CREATED);
			}else {
				response = new ResponseEntity<Object>(prestamoNuevo, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		} catch (Exception e) {
			String message = e.getMessage();
			ResponseMensaje responseMsg = null;
			
			if (message.equals(ServicePrestamo.EXCEPTION_LIBRO_NO_PRESTADO)
					|| message.equals(ServicePrestamo.EXCEPTION_USUARIO_NO_PRESTADO)) {
 				responseMsg = new ResponseMensaje(message);
				response = new ResponseEntity<Object>(responseMsg,HttpStatus.CONFLICT);
 			}else {
				responseMsg = new ResponseMensaje(message);
				response = new ResponseEntity<Object>(responseMsg,HttpStatus.BAD_REQUEST);
			}
			
			LOG.error(e);
		}
		
		return response;
	}
}
