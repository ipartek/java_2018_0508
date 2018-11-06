package com.ipartek.formacion.prestamos.api.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping("/editoriales")
public class EditorialesController {

	@RequestMapping( method = RequestMethod.GET)
	public @ResponseBody ArrayList<Editorial> listado() {
		ArrayList<Editorial> editoriales = new ArrayList<Editorial>();
		for(long i = 0; i<5 ; i++){
			editoriales.add(new Editorial(i, "Nombre"+i));
		}
		
		return editoriales;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Editorial> detalle(@PathVariable long id) {
		
		ResponseEntity<Editorial> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
		
		
		if(id < 0) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			Editorial editorial = new Editorial();
			editorial.setId(id);
			editorial.setNombre("nombre"+id);
			response = new ResponseEntity<>(editorial, HttpStatus.OK);
		}
		
		return response;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Editorial> crear(@RequestBody Editorial editorial) {
		
		ResponseEntity<Editorial> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
		
		editorial.setId(69);
		
		response = new ResponseEntity<>(editorial, HttpStatus.OK);
		 
		return response;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Editorial> modificar(@PathVariable long id, @RequestBody Editorial editorial) {
		
		ResponseEntity<Editorial> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
		
		if(id>0) {
			editorial.setId(id);
			
			response = new ResponseEntity<>(editorial, HttpStatus.OK);
		}else {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		 
		return response;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Editorial> eliminar(@PathVariable long id) {
		
		ResponseEntity<Editorial> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);		
		
		if(id < 0) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			Editorial editorial = new Editorial();
			editorial.setId(id);
			editorial.setNombre("nombre"+id);
			response = new ResponseEntity<>(HttpStatus.OK);
		}
		
		return response;
	}
	
}
