package com.ipartek.formacion.prestamos.api.controller;

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

import com.ipartek.formacion.pojo.Prestamo;
import com.ipartek.formacion.service.ServiceAlumno;
import com.ipartek.formacion.service.ServiceEditorial;
import com.ipartek.formacion.service.ServiceLibro;
import com.ipartek.formacion.service.ServicePrestamo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "*")
@RestController
@Api(tags = "Prestamos", description = "Parte de la API que gestiona los prestamos", produces = "application/json")
public class PrestamosController {

	private final static Logger LOG = Logger.getLogger(PrestamosController.class);

	ServicePrestamo servicePrestamo = null;
	ServiceAlumno serviceAlumno = null;
	ServiceLibro serviceLibro = null;
	ServiceEditorial serviceEditorial = null;
	ValidatorFactory factory = null;
	Validator validator = null;

	@SuppressWarnings("static-access")
	public PrestamosController() {
		super();
		LOG.trace("Construtor");
		servicePrestamo = servicePrestamo.getInstance();
		serviceAlumno = serviceAlumno.getInstance();
		serviceLibro = serviceLibro.getInstance();
		serviceEditorial = serviceEditorial.getInstance();
		LOG.trace("Servicios instanciados");
		// Crear Factoria y Validador
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@ApiOperation(value = "Lista los prestamos en activo y el historico que se encuentran en la BBDD", notes = "Se requiere el campo activos.<br>"
			+ " <ol><li><b> activos=1</b> u otro valor devolvera los prestamos en activo. </li>"
			+ "<li><b>activos=0</b> devolvera el listado de prestamos devueltos.</li></ol>", response = Prestamo.class)
	@ApiResponses({ @ApiResponse(code = 201, message = "Acción realizada con exito"),
			@ApiResponse(code = 404, message = "No existe la dirección a la que intenta acceder.") })
	@RequestMapping(value = "/prestamos", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Prestamo>> listar(
			@ApiParam(value = "<ol><li><b>TRUE:</b> Prestamos sin devolver.</li><li> <b>FALSE:</b> Prestamos con fecha devuelto</li></ol>") @RequestParam(name = "activos", required = false, defaultValue = "-1") int activos) {

		ArrayList<Prestamo> list = new ArrayList<Prestamo>();
		ResponseEntity<ArrayList<Prestamo>> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		try {
			if (activos == 1) {
				list = (ArrayList<Prestamo>) servicePrestamo.prestados();
				LOG.debug("prestamos recuperados" + list.size());
				response = new ResponseEntity<>(list, HttpStatus.OK);
			} else if (activos == 0) {
				list = (ArrayList<Prestamo>) servicePrestamo.historico();
				response = new ResponseEntity<>(list, HttpStatus.OK);
			} else {
				list = (ArrayList<Prestamo>) servicePrestamo.prestados();
				response = new ResponseEntity<>(list, HttpStatus.OK);
			}
		} catch (Exception e) {
			LOG.error(e);
		}

		return response;
	}

	@ApiOperation(value = "Lista un prestamo concreto que se encuentran en la BBDD ya este en historico o en prestamo activo.", notes = "Busqueda por <b>ID</b> de prestamo", response = Prestamo.class)
	@ApiResponses({ @ApiResponse(code = 201, message = "Acción realizada con exito"),
			@ApiResponse(code = 404, message = "Prestamo no existe") })
	@RequestMapping(value = "/libros/prestamos/{id}", method = RequestMethod.GET)
	public ResponseEntity<Prestamo> detalle(@PathVariable long id) {
		ResponseEntity<Prestamo> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {
			Prestamo prestamo = servicePrestamo.buscar(id);

			if (prestamo != null && prestamo.getId() > 0) {
				response = new ResponseEntity<>(prestamo, HttpStatus.OK);
			} else {
				response = new ResponseEntity<>(HttpStatus.NOT_FOUND);

			}
		} catch (Exception e) {
			LOG.error(e);
		}

		return response;

	}

	@ApiOperation(value = "Crea un nuevo registro para prestamo", notes = "Se requiere: <br>"
			+ "<ol><li><b>ID LIBRO</b></li><li><b>ID ALUMNO</b></li><li><b>FECHA DE INICIO</b> de prestamo con formato <b>'YYYY-MM-DD'</b>.</li>"
			+ "<br><ol><li>La <b>FECHA FIN</B> de prestamo es de 15 días y se rellena automaticamente.</li>"
			+ "<li>La <b>FECHA DEVUELTO</B> por defecto no se rellena el campo</li>", response = Prestamo.class)
	@ApiResponses({ @ApiResponse(code = 201, message = "Acción realizada con exito"),
		@ApiResponse(code = 400, message = "Los datos introducidos ya tienen un prestamo asociado."),
			@ApiResponse(code = 409, message = "Los datos introducidos no cumple con los parametros establecidos.") })
	@RequestMapping(value = "/libros/prestamos", method = RequestMethod.POST)
	public ResponseEntity<Object> crear(@RequestBody Prestamo prestamo) {
		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {

			Set<ConstraintViolation<Prestamo>> violations = validator.validate(prestamo);
			if (violations.isEmpty()) {
				if (servicePrestamo.prestar(prestamo)) {
					response = new ResponseEntity<Object>(prestamo, HttpStatus.CREATED);
				} else {
					response = new ResponseEntity<Object>(prestamo, HttpStatus.INTERNAL_SERVER_ERROR);
				}
			} else {
				ResponseMensaje mensaje = new ResponseMensaje("Los datos no son correctos");
				for (ConstraintViolation<Prestamo> v : violations) {
					mensaje.addError(v.getPropertyPath() + ": " + v.getMessage());
				}
				response = new ResponseEntity<>(mensaje, HttpStatus.CONFLICT);
			}
			

		} catch (Exception e) {

			String message = e.getMessage();
			ResponseMensaje responseMsg = null;
			
			if (message.equals(ServicePrestamo.EXCEPTION_LIBRO_PRESTADO)
					|| message.equals(ServicePrestamo.EXCEPTION_ALUMNO_PRESTADO)) {

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

	@ApiOperation(value = "Modifica un prestamo que se encuentre tanto en listado devuelto o en activo", notes = "Se requiere: <br><ol><li>ID.</li></ol><br>"
			+ "Además los valores a introducir deben cumplir estas condiciones:<br>"
			+ "<ol><li><b>ID LIBRO</b></li><li><b>ID ALUMNO</b></li><li><b>FECHA DE INICIO</b> de prestamo con formato <b>'YYYY-MM-DD'</b></li>"
			+ "<br><li>La <b>FECHA FIN</B> de prestamo con formato <b>'YYYY-MM-DD'</b>.</li>"
			+ "<li>La <b>FECHA DEVUELTO</B> con formato <b>'YYYY-MM-DD'</b></li></ol>", response = Prestamo.class)
	@ApiResponses({ @ApiResponse(code = 201, message = "Acción realizada con exito"),
			@ApiResponse(code = 400, message = "Los datos introducidos ya tienen un prestamo asociado."),
			@ApiResponse(code = 409, message = "Los datos introducidos no cumplen las condiciones especificadas.") })
	@RequestMapping(value = "/libros/prestamos/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> modificar(@PathVariable long id, @RequestBody Prestamo prestamo) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {

			Set<ConstraintViolation<Prestamo>> violations = validator.validate(prestamo);
			if (violations.isEmpty()) {

				prestamo.setId(id);

				if (servicePrestamo.modificar(prestamo)) {
					
					response = new ResponseEntity<>(prestamo, HttpStatus.OK);
				} else {
					response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
				}

			} else {
				ResponseMensaje mensaje = new ResponseMensaje("Los datos no son correctos");
				for (ConstraintViolation<Prestamo> v : violations) {
					mensaje.addError(v.getPropertyPath() + ": " + v.getMessage());
				}
				response = new ResponseEntity<>(mensaje, HttpStatus.CONFLICT);
			}

		} catch (SQLIntegrityConstraintViolationException e) {

			response = new ResponseEntity<>(new ResponseMensaje("Registro inexistente en la BBDD. Revise los datos."),
					HttpStatus.CONFLICT);
			LOG.debug(response);
		} catch (Exception e) {

			String message = e.getMessage();
			ResponseMensaje responseMsg = null;
			
			if (message.equals(ServicePrestamo.EXCEPTION_LIBRO_PRESTADO)
					|| message.equals(ServicePrestamo.EXCEPTION_ALUMNO_PRESTADO)) {

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
	
	@ApiOperation(value = "Devuelve  un prestamo que se encuentre en listado activo", 
			notes = "Se requiere: <br><ol><li>ID.</li></ol><br>"
			+ "Además los valores a introducir deben cumplir estas condiciones:<br>"
			+ "<ol><li><b>ID LIBRO</b></li><li><b>ID ALUMNO</b></li><li><b>FECHA DE INICIO</b> de prestamo con formato <b>'YYYY-MM-DD'</b></li>"
			+ "<li>La <b>FECHA DEVUELTO</B> con formato <b>'YYYY-MM-DD'</b></li></ol>", response = Prestamo.class)
	@ApiResponses({ @ApiResponse(code = 201, message = "Acción realizada con exito"),
			@ApiResponse(code = 400, message = "<ol><li>El prestamo no existe.</li><li>El prestamo ha sido devuelto.</li><li>Alumno o Libro no existen</li></ol>"),
			@ApiResponse(code = 409, message = "Los datos introducidos no cumplen las condiciones especificadas.") })
	@RequestMapping(value = "/libros/prestamos/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> devolver(@PathVariable long id, @RequestBody Prestamo prestamo) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {

			Set<ConstraintViolation<Prestamo>> violations = validator.validate(prestamo);
			if (violations.isEmpty()) {

				prestamo.setId(id);

				boolean devuelto=servicePrestamo.devolver(prestamo);
				
					if (devuelto) {
						
						response = new ResponseEntity<>(prestamo, HttpStatus.OK);
					} else {
						response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
					}

				

			} else {
				ResponseMensaje mensaje = new ResponseMensaje("Los datos no son correctos");
				for (ConstraintViolation<Prestamo> v : violations) {
					mensaje.addError(v.getPropertyPath() + ": " + v.getMessage());
				}
				response = new ResponseEntity<>(mensaje, HttpStatus.CONFLICT);
			}

		} catch (SQLIntegrityConstraintViolationException e) {

			response = new ResponseEntity<>(new ResponseMensaje("Registro inexistente en la BBDD. Revise los datos."),
					HttpStatus.CONFLICT);
			LOG.debug(response);
		} catch (Exception e) {

			String message = e.getMessage();
			ResponseMensaje responseMsg = null;
			
			if (message.equals(ServicePrestamo.EXCEPTION_LIBRO_PRESTADO)
					|| message.equals(ServicePrestamo.EXCEPTION_ALUMNO_PRESTADO)) {

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
	

}
