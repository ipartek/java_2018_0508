package com.ipartek.formacion.prestamos.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.prestamos_libros.pojo.Prestamo;
import com.ipartek.formacion.prestamos_libros.service.ServicePrestamo;

@RestController
@RequestMapping("/prestamos")
public class PrestamosController {
	private ServicePrestamo servicePrestamo = ServicePrestamo.getInstance();
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody ArrayList<Prestamo> listado() {

		ArrayList<Prestamo> list = new ArrayList<Prestamo>();
		

		try {
		list = (ArrayList<Prestamo>) servicePrestamo.listar();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@RequestMapping(value = "/{idUsuario}/{idLibro}/{fechaInicio}", method = RequestMethod.GET)
	public ResponseEntity<Prestamo> detalle(@PathVariable String idUsuario, @PathVariable String idLibro, @PathVariable String fechaInicio) throws Exception {
		ResponseEntity<Prestamo> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
		
		

		if (idUsuario != null && idLibro != null && fechaInicio != null ) {
			Prestamo prestamo = servicePrestamo.getByIds(idLibro, idUsuario, fechaInicio);
			response = new ResponseEntity<>(prestamo, HttpStatus.OK);
			
			
		} else {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return response;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Prestamo> crear(@RequestBody Prestamo prestamo) {
		ResponseEntity<Prestamo> response = null;
		
		try {
			servicePrestamo.crear(prestamo);
			response = new ResponseEntity<>(prestamo, HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<>(prestamo, HttpStatus.NOT_MODIFIED);
			e.printStackTrace();
		}

		return response;
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Prestamo> modificar(@RequestBody List<Prestamo> prestamos) throws Exception {
		ResponseEntity<Prestamo> response = null;
			servicePrestamo.modificarPrestamo(prestamos.get(0), prestamos.get(1));

			response = new ResponseEntity<>(prestamos.get(1), HttpStatus.OK);


		return response;
	}



}
