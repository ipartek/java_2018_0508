package com.ipartek.formacion.prestamos.api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.prestamos_libros.pojo.Editorial;
import com.ipartek.formacion.prestamos_libros.service.ServiceEditorial;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/editoriales")
public class EditorialesController {
	
	ServiceEditorial serviceEditorial = null;
	
	public EditorialesController() {
		super();
		serviceEditorial = ServiceEditorial.getInstance();
	}

	@RequestMapping( method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Editorial>> listado() {
		ResponseEntity<ArrayList<Editorial>> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
		ArrayList<Editorial> editoriales = new ArrayList<Editorial>();
		
		try {
			editoriales = (ArrayList<Editorial>) serviceEditorial.listar();
			response = new ResponseEntity<>(editoriales, HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return response;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Editorial> detalle(@PathVariable long id) {
		
		ResponseEntity<Editorial> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
		
		try {
			Editorial editorial = serviceEditorial.buscarPorId(id);
			if(editorial != null && editorial.getId() > 0) {
				response = new ResponseEntity<>(editorial, HttpStatus.OK);
			}else {
				response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

		return response;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Editorial> crear(@RequestBody Editorial editorial) {
		
		ResponseEntity<Editorial> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
		
		try {
			if(serviceEditorial.crear(editorial)) {
				response = new ResponseEntity<>(editorial, HttpStatus.CREATED);
			}else {
				response = new ResponseEntity<>(HttpStatus.CONFLICT);
			}
		}catch(Exception e) {
			//TODO gestionar duplicate key entry
			e.printStackTrace();
		}
		 
		return response;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Editorial> modificar(@PathVariable long id, @RequestBody Editorial editorial) {
		
		ResponseEntity<Editorial> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
		
		try {
			editorial.setId(id);
			if(serviceEditorial.modificar(editorial)) {
				response = new ResponseEntity<>(editorial, HttpStatus.OK);
			}else {
				response = new ResponseEntity<>(HttpStatus.CONFLICT);
			}
		}catch(Exception e) {
			//TODO gestionar duplicate key entry
			e.printStackTrace();
		}
		 
		return response;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Editorial> eliminar(@PathVariable long id) {
		
		ResponseEntity<Editorial> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
		
		try {
			if(serviceEditorial.eliminar(id)) {
				response = new ResponseEntity<>(HttpStatus.OK);
			}else {
				response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return response;
	}
	
}
