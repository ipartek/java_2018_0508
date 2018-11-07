package com.ipartek.formacion.prestamos.api.controller;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.prestamolibros.pojo.Editorial;
import com.ipartek.formacion.prestamolibros.service.ServicioEditorial;
import com.ipartek.formacion.prestamos.api.controller.pojo.ResponseMensaje;

@RestController
@RequestMapping("/editoriales")
public class EditorialesController {

	ValidatorFactory factory = null;
	Validator validator = null;
	ServicioEditorial serviceEditorial = null;

	public EditorialesController() {
		super();
		serviceEditorial = ServicioEditorial.getInstance();
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();

	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Editorial>> listar() {
		ResponseEntity<ArrayList<Editorial>> response = new ResponseEntity<ArrayList<Editorial>>(
				HttpStatus.INTERNAL_SERVER_ERROR);
		ArrayList<Editorial> editoriales = new ArrayList<Editorial>();

		try {
			ServicioEditorial.getInstance();
			editoriales = (ArrayList<Editorial>) serviceEditorial.listar();
			response = new ResponseEntity<ArrayList<Editorial>>(editoriales, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<Editorial> detalle(@PathVariable long id) {
		ResponseEntity<Editorial> response = new ResponseEntity<Editorial>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {

			Editorial edit = serviceEditorial.buscar(id);
			if (edit != null && edit.getId() > 0) {
				response = new ResponseEntity<Editorial>(edit, HttpStatus.OK);
			} else {
				response = new ResponseEntity<Editorial>(HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;

	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> eliminar(@PathVariable long id) {
		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {

			if (serviceEditorial.eliminar(id)) {
				response = new ResponseEntity<>(HttpStatus.OK);
			} else {
				response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
			response = new ResponseEntity<>(
					new ResponseMensaje("No se puede eliminar esta editorial porque tiene un registro asociado"),
					HttpStatus.CONFLICT);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;

	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> crear(@RequestBody Editorial editorial) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		ResponseMensaje msg = new ResponseMensaje();
		try {

			// Validacion con javax validator
			Set<ConstraintViolation<Editorial>> violations = validator.validate(editorial);
			if (violations.isEmpty()) {
				if (serviceEditorial.crear(editorial)) {
					response = new ResponseEntity<>(editorial, HttpStatus.CREATED);
				} else {
					response = new ResponseEntity<>(new ResponseMensaje("La editorial ya existe"), HttpStatus.CONFLICT);
				}
			} else {
				for (ConstraintViolation<Editorial> constraint : violations) {
					msg.addError((constraint.getPropertyPath() + ": " + constraint.getMessage()));
				}
				response = new ResponseEntity<>(msg, HttpStatus.CONFLICT);

			}

		} catch (SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
			response = new ResponseEntity<>(
					new ResponseMensaje("Ya existe una editorial con ese nombre, por favor cambialo"),
					HttpStatus.CONFLICT);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return response;
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PATCH)
	public ResponseEntity<Object> modificar(@PathVariable long id, @RequestBody Editorial editorial) {
		ResponseMensaje msg = new ResponseMensaje();

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {
			Set<ConstraintViolation<Editorial>> violations = validator.validate(editorial);
			if (violations.isEmpty()) {
				editorial.setId(id);
				if (serviceEditorial.modificar(editorial)) {
					response = new ResponseEntity<>(editorial, HttpStatus.OK);
				} else {
					response = new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
				}
			} else {

				for (ConstraintViolation<Editorial> constraint : violations) {
					msg.addError((constraint.getPropertyPath() + ": " + constraint.getMessage()));
				}
				response = new ResponseEntity<>(msg, HttpStatus.CONFLICT);

			}
		} catch (SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
			response = new ResponseEntity<>(
					new ResponseMensaje("Ya existe una editorial con ese nombre, por favor elige otro nombre"),
					HttpStatus.CONFLICT);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
}
