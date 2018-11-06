package com.ipartek.formacion.prestamos.api.controller;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.prestamos_libros.model.EditorialDAO;
import com.ipartek.formacion.prestamos_libros.pojo.Editorial;
import com.ipartek.formacion.prestamos_libros.service.ServiceEditorial;

@RestController
@RequestMapping("/editoriales")

public class EditorialesController {
	private ServiceEditorial serviceEditorial = ServiceEditorial.getInstance();

	

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody ArrayList<Editorial> listado() {

		ArrayList<Editorial> list = new ArrayList<Editorial>();
		

		try {
			ServiceEditorial serviceEditorial = new ServiceEditorial();
		list = (ArrayList<Editorial>) serviceEditorial.listar();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)

	public ResponseEntity<Editorial> detalle(@PathVariable long id) throws Exception {
		ResponseEntity<Editorial> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
		
		

		if (id > 0) {
			
			ServiceEditorial serviceEditorial = new ServiceEditorial();
			Editorial editorial = serviceEditorial.buscarId(id);  
			response = new ResponseEntity<>(HttpStatus.OK);
			
		} else {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return response;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Editorial> eliminar(@PathVariable long id) throws Exception {
		ResponseEntity<Editorial> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

	serviceEditorial.eliminar(id);
		
			response = new ResponseEntity<>(HttpStatus.OK);
		
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		

		return response;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public ResponseEntity<Editorial> crear(@RequestBody Editorial editorial) {
		ResponseEntity<Editorial> response = null;

		editorial.setId(69);

		response = new ResponseEntity<>(editorial, HttpStatus.OK);

		return response;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Editorial> modificar(@PathVariable long id, @RequestBody Editorial editorial) {
		ResponseEntity<Editorial> response = null;

		if (id > 0) {

			response = new ResponseEntity<>(editorial, HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return response;
	}

}
