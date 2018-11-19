package com.ipartek.formacion.prestamos.api.controller;

import java.sql.Date;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.ParseException;
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

import com.ipartek.formacion.libros.pojo.Prestamo;
import com.ipartek.formacion.libros.service.ServiceAlumno;
import com.ipartek.formacion.libros.service.ServiceLibro;
import com.ipartek.formacion.libros.service.ServicePrestamo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = { "Servicio /prestamos" },description = "Clase : PrestamosController", consumes = "application/json")

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/prestamos")
public class PrestamosController {

	private final static Logger LOG = Logger.getLogger(PrestamosController.class);

	ServicePrestamo servicePrestamo = null;
	ServiceAlumno serviceAlumno = null;
	ServiceLibro serviceLibro = null;
	ValidatorFactory factory = null;
	Validator validator = null;
	String ErrorMsg = "";

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
			+ "<h2>3 opciones de consultas para el parametro accion</h2>" + "<ul>" + "<li>0 -> Listar el historico de prestamos</li>"
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

			LOG.error(e.getMessage());
		}

		return response;
	}

	@ApiOperation(value = "Detalle por id del prestamo", notes = "Obtener los prestamos relacionados por libro<br>"
			+ "<h2>Requisitos</h2><br>" + "<ul>" + "<li>Formato de la fecha 2018-01-01</li>"
			+ "</ul>", response = Prestamo.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Detalle del prestamo correcto"),
			@ApiResponse(code = 400, message = "El requerimiento enviado por el cliente era sintácticamente incorrecto ", response = ResponseMensaje.class),
			@ApiResponse(code = 401, message = "No autorizado "),
			@ApiResponse(code = 404, message = "prestamo no encontrado no encontrada ", response = ResponseMensaje.class) })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "fechaInicio", value = "Formato de la fecha<br> 2018-01-01", required = true, dataType = "date", paramType = "Path") })

	@RequestMapping(value = "/{idLibro}/{idAlumno}/{fechaInicio}", method = RequestMethod.GET)
	public ResponseEntity<Object> detalle(@PathVariable long idLibro, @PathVariable long idAlumno,
			@PathVariable Date fechaInicio) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		System.out.println(fechaInicio);
		java.sql.Date fechaInicioSql = new java.sql.Date(fechaInicio.getTime());

		try {

			Prestamo prestamo = servicePrestamo.obtenerPorId(idAlumno, idLibro, fechaInicioSql);

			if (prestamo != null) {

				response = new ResponseEntity<>(prestamo, HttpStatus.OK);

			} else {

				response = new ResponseEntity<>(HttpStatus.NOT_FOUND);

			}

		} catch (Exception e) {
			LOG.error(e.getMessage());

		}
		return response;

	}

	@ApiOperation(value = "Crear editoriales", notes = "Para la creacion de un prestamo se espera un objeto json<br>se pueden crear prestamos activos como finalizados<br> <h2>Campos olbigatorios</h2><ol><li> idUsuario</li> <li>idAlumno</li> <li> fechaInicio</li>", response = Prestamo.class)

	@ApiImplicitParams({})

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Prestamo Creado", response = Prestamo.class),
			@ApiResponse(code = 400, message = "Faltan campos obligatorias y no tienen el formato correcto", response = ResponseMensaje.class),
			@ApiResponse(code = 409, message = "Conflictos :<br> idLibro, idAlumno,fecha con mal formato o inextitente <br>Que ya exista<br> El usuario o el libro estan ya ocupados", response = ResponseMensaje.class) })
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Object> crear(@RequestBody Prestamo prestamo) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		ResponseMensaje rm = new ResponseMensaje();

		try {

			if (servicePrestamo.prestar(prestamo.getAlumno().getId(), prestamo.getLibro().getId(),
					prestamo.getFechaInicio())) {

				response = new ResponseEntity<>(prestamo, HttpStatus.OK);

			} else {

				response = new ResponseEntity<>(prestamo, HttpStatus.INTERNAL_SERVER_ERROR);
			}

		} catch (SQLIntegrityConstraintViolationException e) {
			if (e.getMessage().contains("Duplicate entry")) {
				LOG.debug(e.getMessage());

				String[] errores = new String[1];
				rm.setMensaje("Error de integridad");
				errores[0] = "Ya disponemos de un prestamo con la relacion propuesta.";
				rm.setErrores(errores);
				response = new ResponseEntity<>(rm, HttpStatus.CONFLICT);
			}
			if (e.getMessage().contains("Cannot add or update a child row")) {
				LOG.debug(e.getMessage());
				String[] errores = new String[1];
				rm.setMensaje("Error");
				errores[0] = "No puede eliminar un registro que tengan relacion con otros registros";
				rm.setErrores(errores);
			}

		} catch (Exception e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
			String[] errores = new String[1];
			errores[0] = e.getMessage();
			rm.setMensaje("Error al crear el prestamo");
			rm.setErrores(errores);
			response = new ResponseEntity<>(rm, HttpStatus.CONFLICT);
			e.printStackTrace();

		}

		return response;
	}

	@ApiOperation(value = "Devolver prestamo", notes = "Devolver libros prestados<br>" + "<h2>Requisitos</h2><br>"
			+ "<ul>" + "<li>Formato de la fecha  2018-01-01</li>" + "</ul>")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Prestamo devuelto"),
			@ApiResponse(code = 400, message = "El requerimiento enviado por el cliente era sintácticamente incorrecto ", response = ResponseMensaje.class),
			@ApiResponse(code = 401, message = "No autorizado ", response = ResponseMensaje.class),
			@ApiResponse(code = 404, message = "prestamo no encontrado no encontrada ", response = ResponseMensaje.class) })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "fechaInicio", value = "Formato de la fecha<br> 2018-01-01", required = true, dataType = "date", paramType = "Path") })

	@RequestMapping(value = "/{idLibro}/{idAlumno}/{fechaInicio}", method = RequestMethod.DELETE)
	public ResponseEntity<Prestamo> devolver(@PathVariable long idLibro, @PathVariable long idAlumno,
			@PathVariable Date fechaInicio, @RequestBody Prestamo prestamo) throws ParseException {

		ResponseEntity<Prestamo> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		java.sql.Date fechaInicioSql = new java.sql.Date(fechaInicio.getTime());

		prestamo.getFechaRetorno();
		java.sql.Date fechaRetornoSql = new java.sql.Date(prestamo.getFechaRetorno().getTime());

		try {

			if (servicePrestamo.devolver(idAlumno, idLibro, fechaInicioSql, fechaRetornoSql)) {
				Prestamo p = servicePrestamo.obtenerPorId(idAlumno, idLibro, fechaInicioSql);

				response = new ResponseEntity<>(p, HttpStatus.OK);

			} else {

				response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			LOG.error(e.getMessage());

		}
		return response;
	}

	@ApiOperation(value = "Crear editoriales", notes = "Para la creacion de un prestamo se espera un objeto json<br>se pueden crear prestamos activos comofinalizados", response = Prestamo.class)
	@ApiImplicitParams({})

	@ApiResponses(value = { @ApiResponse(code = 201, message = "Prestamo Creado", responseContainer = "nose"),
			@ApiResponse(code = 400, message = "No encontrado"),
			@ApiResponse(code = 409, message = "Conflictos :<br> 1 <br>2<br>3") })
	@RequestMapping(value = "/{idAlumno}/{idLibro}/{fechaInicio}", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<Object> modificar(@PathVariable int idAlumno, @PathVariable int idLibro,
			@PathVariable Date fechaInicio, @RequestBody Prestamo prestamo) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		ResponseMensaje rm = new ResponseMensaje();
		Prestamo prestamoModificado = new Prestamo();

		try {

			prestamoModificado = servicePrestamo.modificar(idAlumno, idLibro, fechaInicio, prestamo.getAlumno().getId(),
					prestamo.getLibro().getId(), prestamo.getFechaInicio(), prestamo.getFechaFin(),
					prestamo.getFechaRetorno());

			if (prestamoModificado != null) {

				response = new ResponseEntity<>(prestamoModificado, HttpStatus.CREATED);

			} else {

				response = new ResponseEntity<>(HttpStatus.CONFLICT);
			}

		} catch (Exception e) {

			rm.setMensaje("Error");
			String[] errores = new String[1];
			errores[0] = e.getMessage();
			rm.setErrores(errores);
			response = new ResponseEntity<>(rm, HttpStatus.BAD_REQUEST);

			LOG.error(e.getMessage());
		}

		return response;
	}
}