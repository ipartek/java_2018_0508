package com.ipartek.formacion.prestamos.api.controller;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.pojo.Editorial;
import com.ipartek.formacion.service.ServiceEditorial;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

@RestController
@RequestMapping("/editoriales")
public class EditorialesController {

	ServiceEditorial serviceEditorial = null;

	public EditorialesController() {
		super();
		serviceEditorial = ServiceEditorial.getInstance();
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Editorial>> listar() {

		ArrayList<Editorial> editoriales = new ArrayList<Editorial>();
		ResponseEntity<ArrayList<Editorial>> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

		try {

			editoriales = (ArrayList<Editorial>) serviceEditorial.listar();
			response = new ResponseEntity<>(editoriales, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Editorial> detalle(@PathVariable long id) throws Exception {
		ResponseEntity<Editorial> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
		Editorial editorial = new Editorial();
		editorial = serviceEditorial.buscarPorId(id);

		if (editorial != null && editorial.getId() > 0) {

			response = new ResponseEntity<>(editorial, HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return response;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> eliminar(@PathVariable long id) throws Exception {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

		try {

			if (serviceEditorial.eliminar(id)) {
				response = new ResponseEntity<>(HttpStatus.OK);
			} else {
				response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

		} catch (MySQLIntegrityConstraintViolationException e) {

			response = new ResponseEntity<>(
					new ResponseMensaje("No es posible eliminar la editorial deseada porque está asociada a un libro."),
					HttpStatus.CONFLICT);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> crear(@RequestBody Editorial editorial) throws Exception {
		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {

			if (serviceEditorial.crear(editorial)) {
				response = new ResponseEntity<>(editorial, HttpStatus.CREATED);
			} else {
				response = new ResponseEntity<>(HttpStatus.CONFLICT);

			}
		} catch (MySQLIntegrityConstraintViolationException e) {

			response = new ResponseEntity<>(
					new ResponseMensaje("Ya existe la editorial,Por favor prueba con otro nombre."),
					HttpStatus.CONFLICT);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return response;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> modificar(@PathVariable long id, @RequestBody Editorial editorial) throws Exception {
		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

		try {
			editorial.setId(id);

			if (serviceEditorial.modificar(editorial)) {
				response = new ResponseEntity<>(editorial, HttpStatus.OK);
			} else {
				response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

		} catch (MySQLIntegrityConstraintViolationException e) {

			response = new ResponseEntity<>(
					new ResponseMensaje("Ya existe la editorial,Por favor prueba con otro nombre."),
					HttpStatus.CONFLICT);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

}
