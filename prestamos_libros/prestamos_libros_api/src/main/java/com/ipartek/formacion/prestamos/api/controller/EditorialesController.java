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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.pojo.Editorial;
import com.ipartek.formacion.service.ServiceEditorial;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/editoriales")

@Api(tags = "Editoriales", description = "Parte de la API que gestiona las editoriales", produces = "application/json")
public class EditorialesController {

	private final static Logger LOG = Logger.getLogger(EditorialesController.class);

	ServiceEditorial serviceEditorial = null;
	ValidatorFactory factory = null;
	Validator validator = null;

	public EditorialesController() {
		super();
		serviceEditorial = ServiceEditorial.getInstance();
		// Crear Factoria y Validador
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@ApiOperation(value = "Lista todas las editoriales que se encuentran en la BBDD", notes = "")
	@ApiResponses({@ApiResponse(code = 200, message = "Acción realizada con exito"),
		@ApiResponse(code = 404, message = "No existe la dirección a la que intenta acceder.") })
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<ArrayList<Editorial>> listar() {

		ArrayList<Editorial> list = new ArrayList<Editorial>();
		ResponseEntity<ArrayList<Editorial>> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		try {
			list = (ArrayList<Editorial>) serviceEditorial.listar();
			response = new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			LOG.error(e);
		}

		return response;
	}

	@ApiOperation(value = "Lista una editorial concreta que se encuentran en la BBDD", notes = "Busqueda por <b>ID EDITORIAL</b>", response = Editorial.class)
	@ApiResponses({@ApiResponse(code = 200, message = "Acción realizada con exito"),
		@ApiResponse(code = 404, message = "Editorial no existe") })
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Editorial> detalle(@PathVariable long id) {
		ResponseEntity<Editorial> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {
			Editorial editorial = serviceEditorial.buscar(id);

			if (editorial != null && editorial.getId() > 0) {
				response = new ResponseEntity<>(editorial, HttpStatus.OK);
			} else {
				response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			LOG.error(e);
		}

		return response;

	}

	@ApiOperation(value = "Elimina una editorial concreta que se encuentran en la BBDD", notes = "Se requiere <b>ID EDITORIAL</b> para eliminar el registro.", response = Editorial.class)
	@ApiResponses({@ApiResponse(code = 200, message = "Acción realizada con exito"),
		@ApiResponse(code = 404, message = "El registro a eliminar no existe"),
		@ApiResponse(code = 409, message = "No se puede eliminar una editorial con libros asociados")})

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> eliminar(@PathVariable long id) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {

			if (serviceEditorial.eliminar(id)) {
				response = new ResponseEntity<>(HttpStatus.OK);
			} else {
				response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

		} catch (SQLIntegrityConstraintViolationException e) {
			response = new ResponseEntity<>(new ResponseMensaje("No se puede eliminar si tiene Libors asociados"),
					HttpStatus.CONFLICT);
			LOG.debug(response);
		} catch (Exception e) {
			LOG.error(e);
		}
		return response;
	}

	@ApiOperation(value = "Crea una nueva editorial", notes = "Se requiere <b>NOMBRE</b> de editorial comprendido entre 2 y 50 caracteres.", response = Editorial.class)
	@ApiResponses({@ApiResponse(code = 201, message = "Acción realizada con exito"),
			@ApiResponse(code = 409, message = "<ol><li>La editorial ya existe.</li><li>El nombre introducido no cumple con los parametros establecidos.</li></ol>") })
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> crear(@RequestBody Editorial editorial) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {

			Set<ConstraintViolation<Editorial>> violations = validator.validate(editorial);
			if (violations.isEmpty()) {

				if (serviceEditorial.crear(editorial)) {
					response = new ResponseEntity<>(editorial, HttpStatus.CREATED);
				} else {
					response = new ResponseEntity<>(HttpStatus.CONFLICT);
				}
			} else {
				ResponseMensaje mensaje = new ResponseMensaje("Los datos no son correctos");
				for (ConstraintViolation<Editorial> violation : violations) {
					mensaje.addError(violation.getPropertyPath() + ": " + violation.getMessage());

				}
				response = new ResponseEntity<>(mensaje, HttpStatus.CONFLICT);
			}

		} catch (SQLIntegrityConstraintViolationException e) {
			ResponseMensaje msj = new ResponseMensaje("Ya existe la Editorial, por favor prueba con otro nombre");
			response = new ResponseEntity<>(msj, HttpStatus.CONFLICT);
			LOG.debug(response);
		} catch (Exception e) {
			LOG.error(e);
		}

		return response;

	}

	@ApiOperation(value = "Modifica una editorial concreta", notes = "Se requiere un <b>ID</b>.<br>"
			+ "Además el <b>NOMBRE</b> a modificar debe estar comprendido entre 2 y 50 caracteres.", response = Editorial.class)
	@ApiResponses({@ApiResponse(code = 200, message = "Acción realizada con exito"),
		@ApiResponse(code = 404, message = "El registro a eliminar no existe"),
		@ApiResponse(code = 409, message = "Editorial tiene un libro asociado y no se puede eliminar.")
	})
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> modificar(@PathVariable long id, @RequestBody Editorial editorial) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {

			Set<ConstraintViolation<Editorial>> violations = validator.validate(editorial);
			if (violations.isEmpty()) {

				editorial.setId(id);
				if (serviceEditorial.modificar(editorial)) {
					response = new ResponseEntity<>(editorial, HttpStatus.OK);
				} else {
					response = new ResponseEntity<>(HttpStatus.CONFLICT);
				}

			} else {
				ResponseMensaje mensaje = new ResponseMensaje("Los datos no son correctos");
				for (ConstraintViolation<Editorial> v : violations) {
					mensaje.addError(v.getPropertyPath() + ": " + v.getMessage());
				}
				;
				response = new ResponseEntity<>(mensaje, HttpStatus.CONFLICT);
			}

		} catch (SQLIntegrityConstraintViolationException e) {

			response = new ResponseEntity<>(
					new ResponseMensaje("Ya existe la Editorial, por favor prueba con otro nombre"),
					HttpStatus.CONFLICT);
			LOG.debug(response);
		} catch (Exception e) {
			LOG.error(e);
		}
		return response;
	}
}
