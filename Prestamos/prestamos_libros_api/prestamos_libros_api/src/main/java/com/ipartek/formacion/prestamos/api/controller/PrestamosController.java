package com.ipartek.formacion.prestamos.api.controller;

import java.util.ArrayList;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.prestamos_libros.pojo.Prestamo;
import com.ipartek.formacion.prestamos_libros.service.ServicePrestamo;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/prestamos")
public class PrestamosController {
	

	ServicePrestamo servicePrestamo = null;
	ValidatorFactory factory = null;
	Validator validator = null;


	public PrestamosController() {
		super();
		servicePrestamo = ServicePrestamo.getInstance();
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Prestamo>> listado(@RequestParam(value = "activo", required = false) boolean estado) {

		ArrayList<Prestamo> list = new ArrayList<Prestamo>();
		ResponseEntity<ArrayList<Prestamo>> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {
			if(estado) {
				list = (ArrayList<Prestamo>) servicePrestamo.listar();
			}else {
				list = (ArrayList<Prestamo>) servicePrestamo.listardevueltos();
			}
			
			response = new ResponseEntity<>(list, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}
	
}
