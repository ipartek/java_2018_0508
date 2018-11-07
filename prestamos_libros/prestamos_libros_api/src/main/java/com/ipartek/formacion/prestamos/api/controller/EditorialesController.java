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
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping("/editoriales")
public class EditorialesController {

	

	@RequestMapping( method = RequestMethod.GET)
	public @ResponseBody ArrayList<Editorial> listado() {
		
		ArrayList<Editorial> list = new ArrayList<Editorial>();
		
		try {
			ServiceEditorial ServiceEditorial = new ServiceEditorial();		
			list = (ArrayList<Editorial>) ServiceEditorial.listar();
			
		}catch (Exception e) {
			e.printStackTrace();
		}	
		
		
		return list;
	}
	
	
	@RequestMapping( value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Editorial> detalle( @PathVariable long id) {
		
		ResponseEntity<Editorial> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
		
		if ( id > 0 ) {
			Editorial editorial = new Editorial();
			editorial.setId(id);
			editorial.setNombre("nombre" + id);
			response = new ResponseEntity<>(editorial, HttpStatus.OK);
			
		}else {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}	
		
		return response;
	}
	
	
	@RequestMapping( value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Editorial> eliminar( @PathVariable long id) {
		
		ResponseEntity<Editorial> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
		
		if ( id > 0 ) {			
			response = new ResponseEntity<>(HttpStatus.OK);
			
		}else {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}	
		
		return response;
	}
	
	 
	@RequestMapping( method = RequestMethod.POST)
	public ResponseEntity<Editorial> crear( @RequestBody Editorial editorial) {
		
		ResponseEntity<Editorial> response = null;
		
		editorial.setId(69);
		response = new ResponseEntity<>(editorial, HttpStatus.OK);
			
		
		return response;
	}
	
	@RequestMapping( value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Editorial> modificar( @PathVariable long id, @RequestBody Editorial editorial) {
		
		ResponseEntity<Editorial> response = null;
		
		if ( id > 0 ) {			
			editorial.setId(id);
			response = new ResponseEntity<>(editorial, HttpStatus.OK);
		}else {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}		
		
		return response;
	}
	
	
	
	
}
