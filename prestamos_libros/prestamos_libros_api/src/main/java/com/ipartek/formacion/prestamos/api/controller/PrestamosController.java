package com.ipartek.formacion.prestamos.api.controller;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.libros.pojo.Libro;
import com.ipartek.formacion.libros.service.ServiceLibro;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/prestamos_old")
public class PrestamosController {

	ServiceLibro serviceLibro = null;
	ValidatorFactory factory = null;
	Validator validator = null;

	public PrestamosController() {
		super();
		serviceLibro = ServiceLibro.getInstance();
		// Crear Factoria y Validador
		factory = Validation.buildDefaultValidatorFactory();
		validator = (Validator) factory.getValidator();

	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Libro>> listado() {

		ArrayList<Libro> list = new ArrayList<Libro>();
		ResponseEntity<ArrayList<Libro>> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		try {

			list = (ArrayList<Libro>) serviceLibro.listar();
			response = new ResponseEntity<>(list, HttpStatus.OK);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return response;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> detalle(@PathVariable long id) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		ResponseMensaje rm = new ResponseMensaje();

		try {

			Libro libro = serviceLibro.obtener(id);

			if (libro != null && libro.getId() > 0) {

				response = new ResponseEntity<>(libro, HttpStatus.OK);

			} else {
				rm.setMensaje("Usuario no encontrado");
				response = new ResponseEntity<>(rm,HttpStatus.NOT_FOUND);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> eliminar(@PathVariable long id) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		ResponseMensaje rm = new ResponseMensaje();

		try {
			

			if (serviceLibro.eliminar(String.valueOf(id))) {

				response = new ResponseEntity<>(HttpStatus.OK);

			} else {

				rm.setMensaje("Libro no encontrado en la base de datos");

				response = new ResponseEntity<>(rm, HttpStatus.NOT_FOUND);
			}

		}catch (SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
			rm.setMensaje("Intenta eliminar un libro con relacion a otros registros");
			response = new ResponseEntity<>(rm, HttpStatus.CONFLICT);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return response;
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Object> crear(@RequestBody Libro libro) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		ResponseMensaje rm = new ResponseMensaje();

		try {

			Set<ConstraintViolation<Libro>> violations = validator.validate(libro);
			String[] errores = new String[violations.size()];

			if (violations.size() > 0) {

				int contador = 0;

				// No tenemos ningun fallo, la Validacion es correcta
				for (ConstraintViolation<Libro> violation : violations) {

					System.out.println(violation.getMessage());
					System.out.println(violation.getPropertyPath());
					errores[contador] = violation.getPropertyPath() + ":" + violation.getMessage();
					contador++;
				}

				rm.setErrores(errores);
				rm.setMensaje("error de validación");
				response = new ResponseEntity<>(rm, HttpStatus.CONFLICT);

			} else {

				if (serviceLibro.crearVarios(libro,1)) {

					response = new ResponseEntity<>(libro, HttpStatus.CREATED);

				} else {
					rm.setMensaje("Error");
					response = new ResponseEntity<>(rm, HttpStatus.CONFLICT);
				}
			}
		} catch (SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
			rm.setMensaje("Esta intentando crear un registro con datos no existentes");
			response = new ResponseEntity<>(rm, HttpStatus.CONFLICT);
		} catch (SQLException e) {
			e.printStackTrace();
			if (e.getMessage().contains("nombre")) {
				rm.setMensaje("El <b>nombre</b> debe ser inferior a 50 caracteres");
				response = new ResponseEntity<>(rm, HttpStatus.CONFLICT);
			} else {
				rm.setMensaje("La <b>contraseña</b> debe ser inferior a 20 caracteres");
				response = new ResponseEntity<>(rm, HttpStatus.CONFLICT);
			}
		} catch (Exception e) {
			
			rm.setMensaje("Hemos tenido un problema");
			response = new ResponseEntity<>(rm, HttpStatus.CONFLICT);
			e.printStackTrace();
		}

		return response;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> modificar(@PathVariable long id, @RequestBody Libro libro) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		ResponseMensaje rm = new ResponseMensaje();

		try {

			Set<ConstraintViolation<Libro>> violations = validator.validate(libro);
			String[] errores = new String[violations.size()];

			if (violations.size() > 0) {

				int contador = 0;
				// No ha pasado la valiadacion, iterar sobre los mensajes de validacion
				for (ConstraintViolation<Libro> violation : violations) {

					errores[contador] = violation.getPropertyPath() + " :" + violation.getMessage();
					contador++;

				}
				rm.setErrores(errores);
				rm.setMensaje("Error de validación");

				response = new ResponseEntity<>(rm, HttpStatus.CONFLICT);

			} else {

				libro.setId(id);

				if (serviceLibro.modificar(libro)) {

					response = new ResponseEntity<>(libro, HttpStatus.OK);

				} else {
					rm.setMensaje("Registro no encontrado");

					response = new ResponseEntity<>(rm,HttpStatus.CONFLICT);
				}
			}

		} catch (SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
			if(e.getMessage().contains("Cannot add or update a child row")) {
				String[] errores = new String[1];
				rm.setMensaje("Error");
				errores[0] = "No puede modificar un elemento no existente";
				rm.setErrores(errores);
			}
			
			
			

			response = new ResponseEntity<>(rm, HttpStatus.CONFLICT);
		} catch (SQLException e) {
			e.printStackTrace();
			if (e.getMessage().contains("No output parameters returned by procedure")) {
				//System.out.println(e.getCause().toString());
				String[] errores = new String[1];
				errores[0] = "No se han encontrado libros coincidentes";
				rm.setMensaje("Error de integridad");
				rm.setErrores(errores);
				response = new ResponseEntity<>(rm, HttpStatus.CONFLICT);
			} 
		} catch (Exception e) {
			if (e.getMessage().contains("null")) {
				String[] errores = new String[1];
				errores[0] = "No se han encontrado libros coincidentes";
				rm.setMensaje("No se han encontrado libros coincidentes");
				rm.setErrores(errores);
				response = new ResponseEntity<>(rm, HttpStatus.CONFLICT);
				e.printStackTrace();
			}
			
		}

		return response;
	}

}
