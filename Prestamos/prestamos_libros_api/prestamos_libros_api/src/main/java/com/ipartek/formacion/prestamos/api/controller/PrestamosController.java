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
		LOG.trace("Serivicios prestamos instanciados");
		
	}
	@ApiOperation(value = "Listado Prestados Activos o historico")
	@ApiResponses( value = {
			@ApiResponse (code = 200, message = "Listado Prestamos"),
			@ApiResponse (code = 404, message = "No se encontro prestamo")}
	)
	
	@ApiParam( value="activo", required = false, defaultValue = "1")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Prestamo>> listado(
			@ApiParam(value = "No obligatorio,1) true: Prestamos sin retornar <br> 2) false: Prestamos Retornados")
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
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ResponseMensaje> crear(@RequestBody Prestamo prestamo){
		ResponseEntity<ResponseMensaje> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		try {
			boolean creado = servicePrestamo.crear(prestamo);
			if(creado) {
				ResponseMensaje msj = new ResponseMensaje("Libro prestado");
				response = new ResponseEntity<>(msj, HttpStatus.OK);
			}else {
				ResponseMensaje msj = new ResponseMensaje("Un usuario no puede hacer dos prestamos a la vez o el libro ya esta prestado");
				response = new ResponseEntity<>(msj, HttpStatus.CONFLICT);
			}
			
		} catch (Exception e) {
			LOG.error(e);
		}
		
		return response;
	}
	
	@RequestMapping(value = "/{idUsuario}/{idLibro}/{finicio}/{fdevuelto}", method = RequestMethod.DELETE)
	public ResponseEntity<ResponseMensaje> devolver(@PathVariable long idUsuario, @PathVariable long idLibro, @PathVariable Date finicio, @PathVariable Date fdevuelto){
		ResponseEntity<ResponseMensaje> response = null;
		
		try {
			Prestamo p = new Prestamo();
			Libro l = new Libro();
			Usuario u = new Usuario();
			l.setId(idLibro);
			p.setLibro(l);
			u.setId(idUsuario);
			p.setUsuario(u);
			p.setFech_inicio(finicio);
			p.setFecha_devuelto(fdevuelto);
			
			boolean devuelto = servicePrestamo.modificar(p);
			if(devuelto) {
				ResponseMensaje msj = new ResponseMensaje("Prestamo devuelto");
				response = new ResponseEntity<>(msj, HttpStatus.OK);
			}else {
				ResponseMensaje msj = new ResponseMensaje("Prestamo no se ha podido devolver por que no exisiste");
				response = new ResponseEntity<>(msj, HttpStatus.CONFLICT);
			}

		} catch (Exception e) {
			LOG.error(e);
			ResponseMensaje msj = new ResponseMensaje("Error");
			response = new ResponseEntity<>(msj, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		return response;
	}

	@RequestMapping(value = "/{idUsuario}/{idLibro}/{finicio}", method = RequestMethod.PUT)
	public ResponseEntity<ResponseMensaje> modificar(@PathVariable long idUsuario, @PathVariable long idLibro, @PathVariable Date finicio, @RequestBody Prestamo prestamoNuevo){
		ResponseEntity<ResponseMensaje> response = null;
		
		
		
		try {
			Prestamo p = new Prestamo();
			Libro l = new Libro();
			Usuario u = new Usuario();
			l.setId(idLibro);
			p.setLibro(l);
			u.setId(idUsuario);
			p.setUsuario(u);
			p.setFech_inicio(finicio);
			
			boolean modificado = servicePrestamo.modificarHistorico(prestamoNuevo, p);
			if(modificado) {
				ResponseMensaje msj = new ResponseMensaje("Prestamo modificado");
				response = new ResponseEntity<>(msj, HttpStatus.OK);
			}else {
				ResponseMensaje msj = new ResponseMensaje("Prestamo no se ha podido moficar el prestamos por que los datos son incorrectos");
				response = new ResponseEntity<>(msj, HttpStatus.CONFLICT);
			}
		} catch (Exception e) {
			LOG.error(e);
			ResponseMensaje msj = new ResponseMensaje("Error");
			response = new ResponseEntity<>(msj, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return response;
	}
}
