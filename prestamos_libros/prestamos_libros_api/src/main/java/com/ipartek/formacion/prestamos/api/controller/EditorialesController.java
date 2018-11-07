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

import com.ipartek.formacion.prestamolibros.pojo.Editorial;
import com.ipartek.formacion.prestamolibros.service.ServicioEditorial;

@RestController
@RequestMapping("/editoriales")
public class EditorialesController {
	
	
	ServicioEditorial serviceEditorial=null;

	public EditorialesController() {
		super();
		serviceEditorial= ServicioEditorial.getInstance();
		
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Editorial>>  listar() {
		ResponseEntity<ArrayList<Editorial>> response= new ResponseEntity<ArrayList<Editorial>>(HttpStatus.INTERNAL_SERVER_ERROR);
		ArrayList<Editorial> editoriales = new ArrayList<Editorial>();
		
		try {
			 ServicioEditorial.getInstance();
			editoriales=(ArrayList<Editorial>) serviceEditorial.listar();
			response= new ResponseEntity<ArrayList<Editorial>>(editoriales,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return response;
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<Editorial> detalle(@PathVariable long id) {
		ResponseEntity<Editorial> response=new ResponseEntity<Editorial>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {
			
			Editorial edit=serviceEditorial.buscar(id);
			if (edit!=null && edit.getId()>0) {
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
	public ResponseEntity<Editorial> eliminar(@PathVariable long id) {
		ResponseEntity<Editorial> response=new ResponseEntity<Editorial>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {
			
			if (serviceEditorial.eliminar(id)) {
				response = new ResponseEntity<Editorial>(HttpStatus.OK);
			} else {
				response = new ResponseEntity<Editorial>(HttpStatus.NOT_FOUND);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;

	}

	
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Editorial> crear(@RequestBody Editorial editorial) {
		ResponseEntity<Editorial> response=new ResponseEntity<Editorial>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {
			
			if (serviceEditorial.crear(editorial)) {
				response= new ResponseEntity<Editorial>(editorial,HttpStatus.CREATED);
			} else {
				response= new ResponseEntity<Editorial>(HttpStatus.CONFLICT);
			}
		} catch (Exception e) {
			response= new ResponseEntity<Editorial>(editorial,HttpStatus.CONFLICT);	
			e.printStackTrace();
		}
		
		return response;
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.PATCH)
	public ResponseEntity<Editorial> modificar(@PathVariable long id,@RequestBody Editorial editorial) {

		ResponseEntity<Editorial> response=new ResponseEntity<Editorial>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {
			response = null;
			
			if (serviceEditorial.modificar(editorial)) {
				response= new ResponseEntity<Editorial>(editorial,HttpStatus.OK);
			} else {
				response= new ResponseEntity<Editorial>(editorial,HttpStatus.NOT_MODIFIED);
			}
			
		} catch (Exception e) {
			response= new ResponseEntity<Editorial>(editorial,HttpStatus.NOT_FOUND);
			e.printStackTrace();
		}
		
		return response;

	}
}
