package com.ipartek.formacion.prestamos.api.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.pojo.Alumno;
import com.ipartek.formacion.pojo.Editorial;
import com.ipartek.formacion.pojo.Prestamo;
import com.ipartek.formacion.service.ServiceAlumno;
import com.ipartek.formacion.service.ServicePrestamo;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/libros/prestamos")
public class PrestamosController {

	private static final int ACTIVOS = 1; // 1 == Prestados o 0 == Historico

	ServicePrestamo servicePrestamo = null;
	ValidatorFactory factory = null;
	Validator validator = null;

	public PrestamosController() {
		super();
		servicePrestamo = ServicePrestamo.getInstance();
		// Crear Factoria y Validador
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Prestamo>> listar(@RequestParam(value = "activos", required = false) int activos) {

		ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
		ResponseEntity<ArrayList<Prestamo>> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

		try {

			if (activos == ACTIVOS) {
				prestamos = (ArrayList<Prestamo>) servicePrestamo.listarPrestados();

			} else {
				prestamos = (ArrayList<Prestamo>) servicePrestamo.listarHistorico();

			}
			response = new ResponseEntity<>(prestamos, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}

//	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
//	public ResponseEntity<Object> detalle(@PathVariable long id) throws Exception {
//		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
//		Prestamo prestamo = new Prestamo();
//		prestamo = servicePrestamo.buscarPorId(id);
//
//		if (prestamo != null && prestamo.getId() > 0) {
//
//			response = new ResponseEntity<>(alumno, HttpStatus.OK);
//		} else {
//			response = new ResponseEntity<>(
//					new ResponseMensaje("No se ha encotrado ningun registro, cambie de identificador"),
//					HttpStatus.NOT_FOUND);
//		}
//
//		return response;
//	}
//
//	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//	public ResponseEntity<Object> eliminar(@PathVariable long id) throws Exception {
//
//		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
//
//		try {
//
//			if (serviceAlumno.eliminar(id)) {
//				response = new ResponseEntity<>(HttpStatus.OK);
//			} else {
//				response = new ResponseEntity<>(
//						new ResponseMensaje("No se ha encotrado ningun registro, cambie de identificador"),
//						HttpStatus.NOT_FOUND);
//			}
//
//		} catch (MySQLIntegrityConstraintViolationException e) {
//
//			response = new ResponseEntity<>(
//					new ResponseMensaje(
//							"No es posible eliminar el registro deseado porque tiene algun prestamo pendiente."),
//					HttpStatus.CONFLICT);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return response;
//	}
//
//
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> prestar(@RequestBody Prestamo prestamo) throws Exception {
		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		ResponseMensaje responseMensaje = new ResponseMensaje();

		try {

			Set<ConstraintViolation<Prestamo>> violations = validator.validate(prestamo);
			if (violations.size() > 0) {
				/* No ha pasado la valiadacion, iterar sobre los mensajes de validacion */

				ArrayList<String> errores = new ArrayList<>();
				for (ConstraintViolation<Prestamo> violation : violations) {
					errores.add(violation.getPropertyPath() + ": " + violation.getMessage());

				}
				responseMensaje.setErrores(errores);
				responseMensaje.setMensaje("Datos no validos");

				response = new ResponseEntity<>(responseMensaje, HttpStatus.CONFLICT);
			} else {
				if (servicePrestamo.prestar(prestamo.getLibro().getId(), prestamo.getAlumno().getId(),
						prestamo.getFecha_prestado())) {
					response = new ResponseEntity<>(prestamo, HttpStatus.CREATED);
				} else {
					response = new ResponseEntity<>(new ResponseMensaje("Datos no validos"),
							HttpStatus.CONFLICT);

				}
			}

		} catch (MySQLIntegrityConstraintViolationException e) {

			response = new ResponseEntity<>(
					new ResponseMensaje("Datos no validos"), HttpStatus.CONFLICT);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return response;
	}

//	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
//	public ResponseEntity<Object> modificar(@PathVariable long id, @RequestBody Alumno alumno) throws Exception {
//
//		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
//		ResponseMensaje responseMensaje = new ResponseMensaje();
//
//		try {
//			alumno.setId(id);
//			Set<ConstraintViolation<Alumno>> violations = validator.validate(alumno);
//			if (violations.size() > 0) {
//				/* No ha pasado la valiadacion, iterar sobre los mensajes de validacion */
//
//				ArrayList<String> errores = new ArrayList<>();
//				for (ConstraintViolation<Alumno> violation : violations) {
//					errores.add(violation.getPropertyPath() + ": " + violation.getMessage());
//
//				}
//				responseMensaje.setErrores(errores);
//				responseMensaje.setMensaje("Datos no validos");
//
//				response = new ResponseEntity<>(responseMensaje, HttpStatus.CONFLICT);
//			} else {
//				if (serviceAlumno.modificar(alumno)) {
//					response = new ResponseEntity<>(alumno, HttpStatus.OK);
//				} else {
//					response = new ResponseEntity<>(
//							new ResponseMensaje("No se ha encotrado ningun registro, cambie de identificador"),
//							HttpStatus.NOT_FOUND);
//				}
//			}
//
//		} catch (MySQLIntegrityConstraintViolationException e) {
//
//			response = new ResponseEntity<>(
//					new ResponseMensaje("Ya existe el alumno,Por favor prueba con otro nombre."),
//					HttpStatus.CONFLICT);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return response;
//	}

}
