package com.ipartek.formacion.prestamos.api.controller;

import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ipartek.formacion.libros.service.ServiceEditorial;
import com.ipartek.formacion.libros.pojo.Editorial;


@RestController
@RequestMapping("/editoriales")
public class EditorialesController {
	
	private static ServiceEditorial servicio;
	private static Editorial editorial;
	
	public EditorialesController() {
		super();
		servicio = ServiceEditorial.getInstance();
	}

	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Editorial>> listado() {

		ResponseEntity<ArrayList<Editorial>> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

		try {
			
			response = new ResponseEntity<ArrayList<Editorial>>((ArrayList<Editorial>) servicio.listar(), HttpStatus.OK);
		
		} catch (Exception e) {
			
			response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		
		return response;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Editorial> detalle(@PathVariable long id) {

		ResponseEntity<Editorial> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
		
		try {
			
			editorial = servicio.obtener(id);
			
			if (editorial != null && editorial.getId() > 0) {
				
				response = new ResponseEntity<Editorial>(editorial, HttpStatus.OK);
			
			} else {
				
				response = new ResponseEntity<Editorial>(HttpStatus.NOT_FOUND);
			}
		
		} catch (Exception e) {
			
			response = new ResponseEntity<Editorial>(HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}

		return response;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Editorial> eliminar(@PathVariable long id) {

		ResponseEntity<Editorial> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

		try {
			
			if (id != 0 && servicio.eliminar(Long.toString(id))) {
				
				response = new ResponseEntity<Editorial>(HttpStatus.NO_CONTENT);
			
			} else {
				
				response = new ResponseEntity<Editorial>(HttpStatus.NOT_FOUND);
				
			}
			
		} catch (SQLSyntaxErrorException e) {
			
			response = new ResponseEntity<Editorial>(HttpStatus.BAD_REQUEST);
			e.printStackTrace();
			
		} catch (SQLIntegrityConstraintViolationException e) {
			
			response = new ResponseEntity<Editorial>(HttpStatus.CONFLICT);
			e.printStackTrace();
				
		} catch (Exception e) {
			
			response = new ResponseEntity<Editorial>(HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}

		return response;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Editorial> crear(@RequestBody Editorial editorial) {

		ResponseEntity<Editorial> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
		
		try {
			
			if (editorial != null && servicio.crear(editorial)) {
				
				response = new ResponseEntity<Editorial>(editorial, HttpStatus.CREATED);
			
			} else {
				
				response = new ResponseEntity<Editorial>(HttpStatus.BAD_REQUEST);
			}
			
		} catch (SQLSyntaxErrorException e) {
			
			response = new ResponseEntity<Editorial>(HttpStatus.BAD_REQUEST);
			e.printStackTrace();
			
		} catch (SQLIntegrityConstraintViolationException e) {
			
			response = new ResponseEntity<Editorial>(HttpStatus.CONFLICT);
			e.printStackTrace();
				
		} catch (Exception e) {
			
			response = new ResponseEntity<Editorial>(HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}

		return response;

	}


	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Editorial> modificar(@PathVariable long id, @RequestBody Editorial editorial) {

		ResponseEntity<Editorial> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
		editorial.setId(id);
		
		try {
			
			if (servicio.modificar(editorial)) {
				
				response = new ResponseEntity<Editorial>(editorial, HttpStatus.OK);
			
			} else {
				
				response = new ResponseEntity<Editorial>(HttpStatus.NOT_FOUND);
				
			}
			
		} catch (SQLSyntaxErrorException e) {
			
			response = new ResponseEntity<Editorial>(HttpStatus.BAD_REQUEST);
			e.printStackTrace();
			
		} catch (SQLIntegrityConstraintViolationException e) {
			
			response = new ResponseEntity<Editorial>(HttpStatus.CONFLICT);
			e.printStackTrace();
				
		} catch (Exception e) {
			
			response = new ResponseEntity<Editorial>(HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}

		return response;

	}

}
