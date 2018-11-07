package com.ipartek.formacion.prestamos.api.controller;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.prestamolibros.pojo.Editorial;
import com.ipartek.formacion.prestamolibros.service.ServicioEditorial;

@RestController
@RequestMapping("/editoriales")
public class EditorialesController {
	
	ServicioEditorial servicioEditorial = null;

	public EditorialesController() {
		super();
		servicioEditorial = ServicioEditorial.getInstance();
	}

	@RequestMapping( method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Editorial>> listado() {
		
		ArrayList<Editorial> editoriales = new ArrayList<Editorial>();
		ResponseEntity<ArrayList<Editorial>> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		try {
			editoriales = (ArrayList<Editorial>) servicioEditorial.listar();
			response = new ResponseEntity<>(editoriales, HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Editorial> detalle(@PathVariable("id") long id) {
		
		ResponseEntity<Editorial> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		Editorial editorial = new Editorial();
		
		try {
			
			editorial = servicioEditorial.buscar(id);
			
			if(editorial != null && editorial.getId() > 0) {
				response = new ResponseEntity<Editorial>(editorial, HttpStatus.OK);
			}else {
				response = new ResponseEntity<Editorial>(editorial, HttpStatus.NOT_FOUND);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		return response;
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Editorial> eliminar(@PathVariable("id") long id) {
		
		ResponseEntity<Editorial> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
		
		try {
			
			if(servicioEditorial.eliminar(id)) {
				response = new ResponseEntity<>(HttpStatus.OK);
			}else {
				response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return response;	
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Editorial> crear(@RequestBody Editorial editorial) {
		
		ResponseEntity<Editorial> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		try {
			
			if(servicioEditorial.crear(editorial)) {
				response = new ResponseEntity<>(editorial, HttpStatus.CREATED);
			}else {
				response = new ResponseEntity<>(editorial, HttpStatus.CONFLICT);
			}
			
		} catch (Exception e) {
			//TODO Gestionar DuplicateKeyEntry
			e.printStackTrace();
		}
		
		return response;	
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Editorial> modificar(@PathVariable("id") long id, @RequestBody Editorial editorial) {
		
		ResponseEntity<Editorial> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		try {
			
			editorial.setId(id);
			if(servicioEditorial.modificar(editorial)) {
				response = new ResponseEntity<>(HttpStatus.OK);
			}else {
				response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return response;	
		
	}

}
