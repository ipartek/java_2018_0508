package com.ipartek.formacion.prestamos.api.controller;

import java.sql.Date;
import java.sql.SQLException;
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
import org.springframework.util.SocketUtils;
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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(description = "Prestamos", consumes = "application/json")

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/prestamos")
public class PrestamosController {

	private final static Logger LOG = Logger.getLogger(PrestamosController2.class);

	ServicePrestamo servicePrestamo = null;
	ServiceAlumno serviceAlumno = null;
	ServiceLibro serviceLibro = null;
	ValidatorFactory factory = null;
	Validator validator = null;
	String ErrorMsg="";

	public PrestamosController() {
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

	@ApiOperation(value = "Listado de prestamos", notes = "Obtenemos un objeto json con los prestamos existente<br>"
			+ "<h2>3 opciones de consultas</h2>" + "<ul>" + "<li>0 -> Listar el historico de prestamos</li>"
			+ "<li>1 -> Listar prestamos activos</li>"
			+ "<li>vacio -> Listar todos los prestamos , activos e historicos	</li>"
			+ "</ul>", nickname = "listado", responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Listado de libros ok"),
			@ApiResponse(code = 400, message = "Error "), @ApiResponse(code = 401, message = "No autorizado "),
			@ApiResponse(code = 404, message = "No encontrado ") })
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

	@ApiOperation(value = "Detalle por id del prestamo", notes = "Obtener los prestamos relacionados por libro<br>"
			+ "<h2>Requisitos</h2><br>" + "<ul>" + "<li>Formato de la fecha 2018-01-01</li>" + "</ul>")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Detalle del prestamo correcto"),
			@ApiResponse(code = 400, message = "El requerimiento enviado por el cliente era sintácticamente incorrecto "),
			@ApiResponse(code = 401, message = "No autorizado "),
			@ApiResponse(code = 404, message = "prestamo no encontrado no encontrada ") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "fechaInicio", value = "Formato de la fecha<br> 2018-01-01", required = true, dataType = "date", paramType = "Path") })

	@RequestMapping(value = "/{idLibro}/{idAlumno}/{fechaInicio}", method = RequestMethod.GET)
	public ResponseEntity<Object> detalle(@PathVariable long idLibro, @PathVariable long idAlumno,
			@PathVariable Date fechaInicio) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		ResponseMensaje rm = new ResponseMensaje();
		System.out.println(fechaInicio);
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date fechaInicioSql = new java.sql.Date(fechaInicio.getTime());

		try {

			Prestamo prestamo = servicePrestamo.obtenerPorId(idLibro, idAlumno, fechaInicioSql);

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
	
	
	@ApiImplicitParams({
		@ApiImplicitParam(name = "prestamo",
				value = "formato esperado:<br>"
						+ "<pre>"
						+ "    {\n" + 
						"        \"alumno\": {\n" + 
						"            \"id\": 1,\n" + 
						"            \"nombre\": \"Ander\"\n" + 
						"        },\n" + 
						"        \"libro\": {\n" + 
						"            \"id\": 6,\n" + 
						"            \"titulo\": \"\",\n" + 
						"            \"isbn\": \"\",\n" + 
						"            \"editorial\": {\n" + 
						"                \"id\": \"\",\n" + 
						"                \"nombre\": \"\"\n" + 
						"            }\n" + 
						"        },\n" + 
						"        \"fechaInicio\": \"2018-10-29\",\n" + 
						"        \"fechaFin\": \"2018-11-14\",\n" + 
						"        \"fechaRetorno\": null,\n" + 
						"        \"diasRestantes\": 0\n" + 
						"    }"
						+ "<pre>") })
	@ApiOperation(value = "Crear editoriales",notes = "Para la creacion de un prestamo se espera un objeto json<br>se pueden crear prestamos activos comofinalizados"
			+ "<h2>formato esperado</h2>"
			+ "<pre>"			
			+ "    {\n" + 
			"        \"alumno\": {\n" + 
			"            \"id\": 1,\n" + 
			"            \"nombre\": \"\"\n" + 
			"        },\n" + 
			"        \"libro\": {\n" + 
			"            \"id\": 6,\n" + 
			"            \"titulo\": \"\",\n" + 
			"            \"isbn\": \"\",\n" + 
			"            \"editorial\": {\n" + 
			"                \"id\": \"\",\n" + 
			"                \"nombre\": \"\"\n" + 
			"            }\n" + 
			"        },\n" + 
			"        \"fechaInicio\": \"2018-10-29\",\n" + 
			"        \"fechaFin\": null,\n" + 
			"        \"fechaRetorno\": null,\n " + 
			"        \"diasRestantes\": 0\n" + 
			"    }"+
			"</pre>"
			
			
				)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Prestamo Creado", responseContainer="nose"),
			@ApiResponse(code = 400, message = "No encontrado"),
			@ApiResponse(code = 409, message = "Conflictos :<br> 1 <br>2<br>3") })
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Object> crear(@RequestBody Prestamo prestamo) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		ResponseMensaje rm = new ResponseMensaje();

		boolean alumnoResul = false;
		boolean libroResul = false;

		try {
			ArrayList<Alumno> alumnosDisponibles = new ArrayList<Alumno>();
			ArrayList<Libro> librosDisponibles = new ArrayList<Libro>();
			Alumno a = serviceAlumno.obtener(prestamo.getAlumno().getId());
			Libro l = serviceLibro.obtener(prestamo.getLibro().getId());
			alumnosDisponibles = (ArrayList<Alumno>) serviceAlumno.listarDisponibles();
			librosDisponibles = (ArrayList<Libro>) serviceLibro.listarDisponibles();

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
			
			if(alumnoResul == false || libroResul == false) {
				if(alumnoResul == false) {
					ErrorMsg +="Alumno no encontrado,";
				}
				if(libroResul == false) {
					ErrorMsg +="Libro no encontrado,";
				}
			}
			//TODO agregar los mensajes al response

			prestamo.setAlumno(a);
			prestamo.setLibro(l);
			Set<ConstraintViolation<Prestamo>> violations = validator.validate(prestamo);
			String[] errores = new String[violations.size()];

			if (violations.size() > 0) {

				int contador = 0;

				// No tenemos ningun fallo, la Validacion es correcta
				for (ConstraintViolation<Prestamo> violation : violations) {
					
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
			if(e.getMessage().contains("Cannot add or update a child row")) {
				String[] errores = new String[1];
				rm.setMensaje("Error");
				errores[0] = "No puede eliminar un registro que tengan relacion con otros registros";
				rm.setErrores(errores);
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

	@ApiOperation(value = "Devolver prestamo", notes = "Devolver libros prestados<br>" + "<h2>Requisitos</h2><br>"
			+ "<ul>" + "<li>Formato de la fecha  2018-01-01</li>" + "</ul>")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Detalle del prestamo correcto"),
			@ApiResponse(code = 400, message = "El requerimiento enviado por el cliente era sintácticamente incorrecto "),
			@ApiResponse(code = 401, message = "No autorizado "),
			@ApiResponse(code = 404, message = "prestamo no encontrado no encontrada ") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "fechaInicio", value = "Formato de la fecha<br> 2018-01-01", required = true, dataType = "date", paramType = "Path"),
			@ApiImplicitParam(name = "fechaRetorno", value = "Formato de la fecha<br> 2018-01-01", required = true, dataType = "date", paramType = "Path") })
	@RequestMapping(value = "/{idLibro}/{idAlumno}/{fechaInicio}/{fechaRetorno}", method = RequestMethod.DELETE)
	public ResponseEntity<Prestamo> eliminar(@PathVariable long idLibro, @PathVariable long idAlumno,
			@PathVariable Date fechaInicio, @PathVariable Date fechaRetorno) throws ParseException {

		ResponseEntity<Prestamo> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		java.sql.Date fechaInicioSql = new java.sql.Date(fechaInicio.getTime());
		java.sql.Date fechaRetornoSql = new java.sql.Date(fechaRetorno.getTime());


		try {

			if (servicePrestamo.devolver(idAlumno, idLibro, fechaInicioSql, fechaRetornoSql)) {

				response = new ResponseEntity<>(HttpStatus.OK);

			} else {

				response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return response;
	}
	
	
	@ApiImplicitParams({
		@ApiImplicitParam(name = "prestamo",
				value = "formato esperado:<br>"
						+ "<pre>"
						+ "    {\n" + 
						"        \"alumno\": {\n" + 
						"            \"id\": 1,\n" + 
						"            \"nombre\": \"Ander\"\n" + 
						"        },\n" + 
						"        \"libro\": {\n" + 
						"            \"id\": 6,\n" + 
						"            \"titulo\": \"\",\n" + 
						"            \"isbn\": \"\",\n" + 
						"            \"editorial\": {\n" + 
						"                \"id\": \"\",\n" + 
						"                \"nombre\": \"\"\n" + 
						"            }\n" + 
						"        },\n" + 
						"        \"fechaInicio\": \"2018-10-29\",\n" + 
						"        \"fechaFin\": \"2018-11-14\",\n" + 
						"        \"fechaRetorno\": null,\n" + 
						"        \"diasRestantes\": 0\n" + 
						"    }"
						+ "<pre>") })
	@ApiOperation(value = "Crear editoriales",notes = "Para la creacion de un prestamo se espera un objeto json<br>se pueden crear prestamos activos comofinalizados"
			+ "<h2>formato esperado</h2>"
			+ "<pre>"			
			+ "    {\n" + 
			"        \"alumno\": {\n" + 
			"            \"id\": 1,\n" + 
			"            \"nombre\": \"\"\n" + 
			"        },\n" + 
			"        \"libro\": {\n" + 
			"            \"id\": 6,\n" + 
			"            \"titulo\": \"\",\n" + 
			"            \"isbn\": \"\",\n" + 
			"            \"editorial\": {\n" + 
			"                \"id\": \"\",\n" + 
			"                \"nombre\": \"\"\n" + 
			"            }\n" + 
			"        },\n" + 
			"        \"fechaInicio\": \"2018-10-29\",\n" + 
			"        \"fechaFin\": null,\n" + 
			"        \"fechaRetorno\": null,\n " + 
			"        \"diasRestantes\": 0\n" + 
			"    }"+
			"</pre>"
			
			
				)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Prestamo Creado", responseContainer="nose"),
			@ApiResponse(code = 400, message = "No encontrado"),
			@ApiResponse(code = 409, message = "Conflictos :<br> 1 <br>2<br>3") })
	@RequestMapping(value = "/{id}",method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<Object> modificar(@RequestBody Prestamo prestamo) {

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