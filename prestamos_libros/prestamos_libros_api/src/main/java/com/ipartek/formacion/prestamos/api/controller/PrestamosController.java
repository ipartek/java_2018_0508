package com.ipartek.formacion.prestamos.api.controller;

import java.util.ArrayList;
import java.util.Map;

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

import com.ipartek.formacion.libros.pojo.Editorial;
import com.ipartek.formacion.libros.pojo.Prestamo;
import com.ipartek.formacion.libros.service.ServicePrestamo;

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
		// Crear Factoria y Validador
		factory = Validation.buildDefaultValidatorFactory();
		validator = (Validator) factory.getValidator();

	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Prestamo>> listado( @RequestParam("accion") boolean accion) {
		
		ArrayList<Prestamo> list = new ArrayList<Prestamo>();
		ResponseEntity<ArrayList<Prestamo>> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		try {
			if(accion == true) {
				list = (ArrayList<Prestamo>) servicePrestamo.prestamosActivos();
			}else {
				list = (ArrayList<Prestamo>) servicePrestamo.historico();
			}
			
			response = new ResponseEntity<>(list, HttpStatus.OK);

		} catch (Exception e) {
			
			e.printStackTrace();
		}

		return response;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Editorial> detalle(@RequestParam Map<String,String> requestParams) {

		ResponseEntity<Editorial> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		String libro=requestParams.get("idLibro");
		String alumno=requestParams.get("idAlumno");
		String fechaInicio = requestParams.get("fechaInicio");
		

		try {

			/*Prestamo prestamo = servicePrestamo.obtenerPorId(libro, alumno, fecha);

			if (editorial != null && editorial.getId() > 0) {

				response = new ResponseEntity<>(editorial, HttpStatus.OK);

			} else {

				response = new ResponseEntity<>(HttpStatus.NOT_FOUND);

			}*/

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
}

	/*@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Editorial> eliminar(@PathVariable long id) {

		ResponseEntity<Editorial> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		

		try {

			if (serviceEditorial.eliminar(String.valueOf(id))) {

				response = new ResponseEntity<>(HttpStatus.OK);

			} else {

				response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return response;
	}

	@RequestMapping(method = RequestMethod.POST,consumes="application/json")
	public ResponseEntity<Object> crear(@RequestBody Editorial editorial) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		ResponseMensaje rm = new ResponseMensaje();

		try {

			Set<ConstraintViolation<Editorial>> violations = validator.validate(editorial);
			String[] errores = new String[violations.size()];
			

			if (violations.size() > 0) {

				int contador = 0;

				 No tenemos ningun fallo, la Validacion es correcta 
				for (ConstraintViolation<Editorial> violation : violations) {

					System.out.println(violation.getMessage());
					System.out.println(violation.getPropertyPath());
					errores[contador] = violation.getPropertyPath() + ":" + violation.getMessage();
					contador++;
				}

				rm.setErrores(errores);
				rm.setMensaje("error de validación");
				response = new ResponseEntity<>(rm, HttpStatus.CONFLICT);

			} else {

				if (serviceEditorial.crear(editorial)) {

					response = new ResponseEntity<>(editorial, HttpStatus.CREATED);

				} else {

					response = new ResponseEntity<>(HttpStatus.CONFLICT);
				}
			}

		} catch (SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
			String[] errores = new String[1];
			rm.setMensaje("Error");
			errores[0] = "No puede borrar un elemento con otras relaciones";
			rm.setErrores(errores);
			

			response = new ResponseEntity<>(rm, HttpStatus.CONFLICT);
		} catch (SQLException e) {
			e.printStackTrace();
			if (e.getMessage().contains("nombre")) {
				String[] errores = new String[1];
				errores[0] = "El <b>nombre</b> debe ser inferior a 50 caracteres";
				rm.setMensaje("El <b>nombre</b> debe ser inferior a 50 caracteres");
				rm.setErrores(errores);
				response = new ResponseEntity<>(rm, HttpStatus.CONFLICT);
			} else {
				String[] errores = new String[1];
				errores[0] = "El <b>nombre</b> debe ser inferior a 50 caracteres";
				rm.setMensaje("La <b>contraseña</b> debe ser inferior a 20 caracteres");
				rm.setErrores(errores);
				response = new ResponseEntity<>(rm, HttpStatus.CONFLICT);
			}
		} catch (Exception e) {
			String[] errores = new String[1];
			errores[0] = "Hemos tenido un problema";
			rm.setMensaje("Hemos tenido un problema");
			rm.setErrores(errores);
			response = new ResponseEntity<>(rm, HttpStatus.CONFLICT);
			e.printStackTrace();
		}
		
		return response;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> modificar(@PathVariable long id, @RequestBody Editorial editorial) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		try {

			Set<ConstraintViolation<Editorial>> violations = validator.validate(editorial);
			String[] errores = new String[violations.size()];
			ResponseMensaje rm = new ResponseMensaje();

			if (violations.size() > 0) {

				int contador = 0;
				 No ha pasado la valiadacion, iterar sobre los mensajes de validacion 
				for (ConstraintViolation<Editorial> violation : violations) {

					errores[contador] = violation.getPropertyPath() + " :" + violation.getMessage();
					contador++;

				}
				rm.setErrores(errores);
				rm.setMensaje("Error de validación");

				response = new ResponseEntity<>(rm, HttpStatus.CONFLICT);

			} else {

				editorial.setId(id);

				if (serviceEditorial.modificar(editorial)) {

					response = new ResponseEntity<>(editorial, HttpStatus.OK);

				} else {

					response = new ResponseEntity<>(HttpStatus.CONFLICT);
				}
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return response;
	}
*/

