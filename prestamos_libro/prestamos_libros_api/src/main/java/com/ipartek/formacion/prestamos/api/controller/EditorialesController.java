package com.ipartek.formacion.prestamos.api.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.pojo.Editorial;
import com.ipartek.formacion.service.ServiceEditorial;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Editoriales", produces = "aplication/json", description = "Gestion de editoriales")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/editoriales")
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

	@ApiOperation(value = "Listado de editoriales")
	@ApiResponses(value = { @ApiResponse(code = 200, message = " Listado editoriales") })
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Editorial>> listar() {

		ArrayList<Editorial> editoriales = new ArrayList<Editorial>();
		ResponseEntity<ArrayList<Editorial>> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

		try {

			editoriales = (ArrayList<Editorial>) serviceEditorial.listar();
			response = new ResponseEntity<>(editoriales, HttpStatus.OK);

		} catch (Exception e) {
			LOG.error(e);
		}

		return response;
	}

	@ApiOperation(value = "Obtener editorial por su identificador",response = Editorial.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = " editorial encontrada"),
			@ApiResponse(code = 404, message = " No se encontró la editorial deseada") })
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> detalle(@PathVariable long id) throws Exception {
		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
		Editorial editorial = new Editorial();
		editorial = serviceEditorial.buscarPorId(id);

		if (editorial != null && editorial.getId() > 0) {

			response = new ResponseEntity<>(editorial, HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(
					new ResponseMensaje("No se ha encotrado ningun registro, cambie de identificador"),
					HttpStatus.NOT_FOUND);
			LOG.debug("No se ha encotrado ningun registro, cambie de identificador");
		}

		return response;
	}

	@ApiOperation(value = "Eliminar editorial")
	@ApiResponses(value = { @ApiResponse(code = 200, message = " editorial eliminada correctamente"),
			@ApiResponse(code = 404, message = " No se encontró la editorial deseada"),
			@ApiResponse(code = 409, message = " No se puede borrar la aditorial porque está asociada a un libro") })
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> eliminar(@PathVariable long id) throws Exception {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

		try {

			if (serviceEditorial.eliminar(id)) {
				response = new ResponseEntity<>(HttpStatus.OK);
			} else {
				response = new ResponseEntity<>(
						new ResponseMensaje("No se ha encotrado ningun registro, cambie de identificador"),
						HttpStatus.NOT_FOUND);
				LOG.debug("No se ha encotrado ningun registro, cambie de identificador");
			}

		} catch (MySQLIntegrityConstraintViolationException e) {

			response = new ResponseEntity<>(
					new ResponseMensaje("No es posible eliminar la editorial deseada porque está asociada a un libro."),
					HttpStatus.CONFLICT);

			LOG.debug("No es posible eliminar la editorial deseada porque está asociada a un libro.");

		} catch (Exception e) {
			LOG.error(e);
		}
		return response;
	}

	@ApiOperation(value = "Crear editorial")
	@ApiResponses(value = { @ApiResponse(code = 201, message = " editorial creada correctamente"),
			@ApiResponse(code = 409, message = "<ol><li>El nombre de la editorial está vacío</li><li> o el nombre de la editorial ya existe</li></ol>") })
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> crear(@RequestBody Editorial editorial) throws Exception {
		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		ResponseMensaje responseMensaje = new ResponseMensaje();

		try {

			Set<ConstraintViolation<Editorial>> violations = validator.validate(editorial);
			if (violations.size() > 0) {
				/* No ha pasado la valiadacion, iterar sobre los mensajes de validacion */

				ArrayList<String> errores = new ArrayList<>();
				for (ConstraintViolation<Editorial> violation : violations) {
					errores.add(violation.getPropertyPath() + ": " + violation.getMessage());

				}
				responseMensaje.setErrores(errores);
				responseMensaje.setMensaje("Datos no validos");
				LOG.debug("Datos no validos");

				response = new ResponseEntity<>(responseMensaje, HttpStatus.CONFLICT);
			} else {
				if (serviceEditorial.crear(editorial)) {
					response = new ResponseEntity<>(editorial, HttpStatus.CREATED);
				} else {
					response = new ResponseEntity<>(HttpStatus.CONFLICT);
					LOG.debug("no se pudo crear la editorial");
				}
			}

		} catch (MySQLIntegrityConstraintViolationException e) {

			response = new ResponseEntity<>(
					new ResponseMensaje("Ya existe la editorial,Por favor prueba con otro nombre."),
					HttpStatus.CONFLICT);

		} catch (Exception e) {

			LOG.error(e);
		}
		return response;
	}

	@ApiOperation(value = "Modificar editorial")
	@ApiResponses(value = { @ApiResponse(code = 200, message = " editorial modificada correctamente"),
			@ApiResponse(code = 404, message = " No se encontró la editorial deseada"),
			@ApiResponse(code = 409, message = "<ol><li>El nombre de la editorial está vacío</li><li>El nombre de la editorial ya existe</li></ol>") })
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> modificar(@PathVariable long id, @RequestBody Editorial editorial) throws Exception {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
		ResponseMensaje responseMensaje = new ResponseMensaje();

		try {
			editorial.setId(id);
			Set<ConstraintViolation<Editorial>> violations = validator.validate(editorial);
			if (violations.size() > 0) {
				/* No ha pasado la valiadacion, iterar sobre los mensajes de validacion */

				ArrayList<String> errores = new ArrayList<>();
				for (ConstraintViolation<Editorial> violation : violations) {
					errores.add(violation.getPropertyPath() + ": " + violation.getMessage());

				}
				responseMensaje.setErrores(errores);
				responseMensaje.setMensaje("Datos no validos");
				LOG.debug("Datos no validos");

				response = new ResponseEntity<>(responseMensaje, HttpStatus.CONFLICT);
			} else {
				if (serviceEditorial.modificar(editorial)) {
					response = new ResponseEntity<>(editorial, HttpStatus.OK);
				} else {
					response = new ResponseEntity<>(
							new ResponseMensaje("No se ha encotrado ningun registro, cambie de identificador"),
							HttpStatus.NOT_FOUND);
					LOG.debug("No se ha encotrado ningun registro, cambie de identificador");
				}
			}

		} catch (MySQLIntegrityConstraintViolationException e) {

			response = new ResponseEntity<>(
					new ResponseMensaje("Ya existe la editorial,Por favor prueba con otro nombre."),
					HttpStatus.CONFLICT);
			LOG.debug("Ya existe la editorial,Por favor prueba con otro nombre.");

		} catch (Exception e) {
			LOG.error(e);
		}
		return response;
	}

}
