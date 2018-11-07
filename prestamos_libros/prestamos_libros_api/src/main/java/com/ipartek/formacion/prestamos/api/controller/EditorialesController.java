package com.ipartek.formacion.prestamos.api.controller;

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

import com.ipartek.formacion.libros.pojo.Editorial;
import com.ipartek.formacion.libros.service.ServiceEditorial;


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

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Editorial> detalle(@PathVariable long id) {

		ResponseEntity<Editorial> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {

			Editorial editorial = serviceEditorial.obtener(id);
			if (editorial != null && editorial.getId() > 0) {
				response = new ResponseEntity<>(editorial, HttpStatus.OK);
			} else {
				response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Editorial> eliminar(@PathVariable long id) {

		ResponseEntity<Editorial> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {

			if (serviceEditorial.eliminar(String.valueOf(id))) {
				response = new ResponseEntity<>(HttpStatus.OK);
			} else {
				response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> crear(@RequestBody Editorial editorial) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {
			Set<ConstraintViolation<Editorial>> violations = validator.validate(editorial);
			String[] errores = new String[violations.size()];
			ResponseMensaje rm = new ResponseMensaje();
			if (violations.size() > 0) {
				int contador = 0;
				/* No ha pasado la valiadacion, iterar sobre los mensajes de validacion */
				for (ConstraintViolation<Editorial> violation : violations) {

					System.out.println(violation.getMessage());
					System.out.println(violation.getPropertyPath());
					errores[contador] = violation.getPropertyPath() + ":" + violation.getMessage();
					contador++;
				}
				rm.setErrores(errores);
				rm.setMensaje("error");
				response = new ResponseEntity<>(rm, HttpStatus.CONFLICT);
			} else {
				/* No tenemos ningun fallo, la Validacion es correcta */
				if (serviceEditorial.crear(editorial)) {
					response = new ResponseEntity<>(editorial, HttpStatus.CREATED);
				} else {
					response = new ResponseEntity<>(HttpStatus.CONFLICT);
				}
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return response;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> modificar(@PathVariable long id, @RequestBody Editorial editorial) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {		
			
			Set<ConstraintViolation<Editorial>> violations = validator.validate(editorial);
			String[] errores = new String[violations.size()];
			ResponseMensaje rm = new ResponseMensaje();
			
			if (violations.size() > 0) {
				int contador = 0;
				/* No ha pasado la valiadacion, iterar sobre los mensajes de validacion */
				for (ConstraintViolation<Editorial> violation : violations) {

					System.out.println(violation.getMessage());
					System.out.println(violation.getPropertyPath());
					errores[contador] = violation.getPropertyPath() + ":" + violation.getMessage();
					contador++;
				}
				rm.setErrores(errores);
				rm.setMensaje("error");
				response = new ResponseEntity<>(rm, HttpStatus.CONFLICT);
			}else {
				editorial.setId(id);
				if (serviceEditorial.modificar(editorial)) {
					response = new ResponseEntity<>(editorial, HttpStatus.OK);
				} else {
					response = new ResponseEntity<>(HttpStatus.CONFLICT);
				}
			}
			

		} catch (Exception e) {
			// TODO gestionar duplicate key entry
			e.printStackTrace();
		}
		return response;
	}

}
