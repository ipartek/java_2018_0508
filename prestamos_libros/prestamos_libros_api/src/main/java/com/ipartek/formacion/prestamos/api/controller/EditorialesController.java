package com.ipartek.formacion.prestamos.api.controller;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.ApplicationScope;

import com.ipartek.formacion.libros.pojo.Editorial;
import com.ipartek.formacion.libros.service.ServiceEditorial;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/editoriales")
public class EditorialesController {

	ServiceEditorial serviceEditorial = null;
	ValidatorFactory factory = null;
	Validator validator = null;

	public EditorialesController() {
		super();
		serviceEditorial = ServiceEditorial.getInstance();
		// Crear Factoria y Validador
		factory = Validation.buildDefaultValidatorFactory();
		validator = (Validator) factory.getValidator();

	}

	@ApiOperation(value = "Listado de editoriales")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Listado de Editoriales"),
			@ApiResponse(code = 400, message = "Error "), @ApiResponse(code = 401, message = "No autorizado "),
			@ApiResponse(code = 404, message = "No encontrado ") })
	@ApiParam(required = false, name = "Blabla ?", defaultValue = "1")

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Editorial>> listado() {

		ArrayList<Editorial> list = new ArrayList<Editorial>();
		ResponseEntity<ArrayList<Editorial>> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		try {

			list = (ArrayList<Editorial>) serviceEditorial.listar();
			response = new ResponseEntity<>(list, HttpStatus.OK);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return response;
	}

	@ApiOperation(value = "Detalle de editorial")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Detalle de prestamo correcto"),
			@ApiResponse(code = 400, message = "Error "), @ApiResponse(code = 401, message = "No autorizado "),
			@ApiResponse(code = 404, message = "Editorial no encontrada ") })
	@ApiParam(required = false, name = "Blabla ?", defaultValue = "1")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> detalle(@PathVariable long id) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		ResponseMensaje rm = new ResponseMensaje();
		try {

			Editorial editorial = serviceEditorial.obtener(id);

			if (editorial != null && editorial.getId() > 0) {

				response = new ResponseEntity<Object>(editorial, HttpStatus.OK);

			} else {
				String[] errores = new String[1];
				rm.setMensaje("Error");
				errores[0] = "Editorial no encontrada";
				rm.setErrores(errores);
				response = new ResponseEntity<>(rm, HttpStatus.NOT_FOUND);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	@ApiOperation(value = "Eliminar editoriales")
	@ApiResponses(value = { @ApiResponse(code = 204, message = "Editorial eliminada"),
			@ApiResponse(code = 404, message = "Editorial no encontrada"),
			@ApiResponse(code = 409, message = "No puedes borrar una editorial con libros asociados") })
	@ApiParam(required = false, name = "Blabla ?", defaultValue = "1")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> eliminar(@PathVariable long id) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		ResponseMensaje rm = new ResponseMensaje();

		try {

			if (serviceEditorial.eliminar(String.valueOf(id))) {

				response = new ResponseEntity<>(HttpStatus.OK);

			} else {
				String[] errores = new String[1];
				rm.setMensaje("Error");
				errores[0] = "Editorial no encontrada";
				rm.setErrores(errores);
				response = new ResponseEntity<>(rm, HttpStatus.NOT_FOUND);
			}

		} catch (SQLIntegrityConstraintViolationException e) {
			if (e.getMessage().contains("Cannot delete or update a parent row")) {
				e.printStackTrace();
				String[] errores = new String[1];
				rm.setMensaje("Error");
				errores[0] = "No puedes borrar una editorial con libros asociados";
				rm.setErrores(errores);
				response = new ResponseEntity<>(rm, HttpStatus.CONFLICT);

			}
		} catch (Exception e) {

			e.printStackTrace();
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return response;
	}

	@ApiOperation(value = "Crear editoriales")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Editorial Creada"),
			@ApiResponse(code = 400, message = "No encontrado"),
			@ApiResponse(code = 409, message = "Conflicto : Editorial existente") })
	@ApiParam(required = false, name = "Blabla ?", defaultValue = "1")
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Object> crear(@RequestBody Editorial editorial) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		ResponseMensaje rm = new ResponseMensaje();

		try {

			Set<ConstraintViolation<Editorial>> violations = validator.validate(editorial);
			String[] errores = new String[violations.size()];

			if (violations.size() > 0) {

				int contador = 0;

				/* No tenemos ningun fallo, la Validacion es correcta */
				for (ConstraintViolation<Editorial> violation : violations) {

					System.out.println(violation.getMessage());
					System.out.println(violation.getPropertyPath());
					errores[contador] = violation.getPropertyPath() + ":" + violation.getMessage();
					contador++;
				}

				rm.setErrores(errores);
				rm.setMensaje("error de validación");
				response = new ResponseEntity<>(rm, HttpStatus.CONFLICT);

			} else {

				if (serviceEditorial.crear(editorial)) {

					response = new ResponseEntity<>(editorial, HttpStatus.CREATED);

				} else {

					response = new ResponseEntity<>(HttpStatus.CONFLICT);
				}
			}

		} catch (SQLIntegrityConstraintViolationException e) {
			if (e.getMessage().contains("Duplicate entry")) {
				e.printStackTrace();
				String[] errores = new String[1];
				rm.setMensaje("Error");
				errores[0] = "Editorial existente";
				rm.setErrores(errores);
			}

			response = new ResponseEntity<>(rm, HttpStatus.CONFLICT);
		} catch (SQLException e) {
			e.printStackTrace();
			if (e.getMessage().contains("nombre")) {
				String[] errores = new String[1];
				errores[0] = "El <b>nombre</b> debe ser inferior a 50 caracteres";
				rm.setMensaje("El <b>nombre</b> debe ser inferior a 50 caracteres");
				rm.setErrores(errores);
				response = new ResponseEntity<>(rm, HttpStatus.CONFLICT);
			} else {
				String[] errores = new String[1];
				errores[0] = "El <b>nombre</b> debe ser inferior a 50 caracteres";
				rm.setMensaje("La <b>contraseña</b> debe ser inferior a 20 caracteres");
				rm.setErrores(errores);
				response = new ResponseEntity<>(rm, HttpStatus.CONFLICT);
			}
		} catch (Exception e) {
			String[] errores = new String[1];
			errores[0] = "Hemos tenido un problema";
			rm.setMensaje("Hemos tenido un problema");
			rm.setErrores(errores);
			response = new ResponseEntity<>(rm, HttpStatus.CONFLICT);
			e.printStackTrace();
		}

		return response;
	}

	@ApiOperation(value = "Modificar editoriales")
	@ApiResponses(value = {

			@ApiResponse(code = 400, message = "No encontrado"), @ApiResponse(code = 409, message = "Modificacion del nombre de una editorial por uno ya existente") })
	@ApiParam(value = "activos", required = false, name = "Blabla ?", defaultValue = "1")
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> modificar(@PathVariable long id, @RequestBody Editorial editorial) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		ResponseMensaje rm = new ResponseMensaje();

		try {

			Set<ConstraintViolation<Editorial>> violations = validator.validate(editorial);
			String[] errores = new String[violations.size()];

			if (violations.size() > 0) {

				int contador = 0;
				/* No ha pasado la valiadacion, iterar sobre los mensajes de validacion */
				for (ConstraintViolation<Editorial> violation : violations) {

					errores[contador] = violation.getPropertyPath() + " :" + violation.getMessage();
					contador++;

				}
				rm.setErrores(errores);
				rm.setMensaje("Error de validación");

				response = new ResponseEntity<>(rm, HttpStatus.CONFLICT);

			} else {

				editorial.setId(id);

				if (serviceEditorial.modificar(editorial)) {

					response = new ResponseEntity<>(editorial, HttpStatus.OK);

				} else {

					response = new ResponseEntity<>(HttpStatus.CONFLICT);
				}
			}

		} catch (SQLIntegrityConstraintViolationException e) {
			if (e.getMessage().contains("Duplicate entry")) {
				e.printStackTrace();
				String[] errores = new String[1];
				rm.setMensaje("Error");
				errores[0] = "Modificacion del nombre de una editorial por uno ya existente";
				rm.setErrores(errores);
				response = new ResponseEntity<>(rm,HttpStatus.CONFLICT);
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

		return response;
	}

}
