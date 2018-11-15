package com.ipartek.formacion.prestamos.api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.prestamos_libros.pojo.Prestamo;
import com.ipartek.formacion.prestamos_libros.service.ServicePrestamo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.ArrayList;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Api(tags = { "Prestamos" }, produces = "application/json", description = "Gestión Préstamos")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/prestamos")
public class PrestamosController {

	ServicePrestamo servicePrestamo = null;
	ValidatorFactory factory = null;
	Validator validator = null;

	// Logger
	private final static Logger LOG = Logger.getLogger(PrestamosController.class);

	public static final int FINALIZADOS = 0;

	public PrestamosController() {
		super();
		LOG.trace("Constructor");
		servicePrestamo = ServicePrestamo.getInstance();
		LOG.trace("Servicio préstamo instanciado");

		// Crear Factoria y Validador
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@ApiOperation(value = "Listado de prestamos activos o historico")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Listado Prestamos") })
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Prestamo>> listado(
			@ApiParam(value = "No obligatorio, 1: Prestamos activos, 0: Prestamos finalizados") @RequestParam(value = "activos", required = false, defaultValue = "1") int activos) {
		ResponseEntity<ArrayList<Prestamo>> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();

		try {
			// Si es 0 es historico, si es 1 son activos
			if (activos == FINALIZADOS) {
				prestamos = (ArrayList<Prestamo>) servicePrestamo.listarHistorico();
				LOG.debug("Prestamos de histórico recuperados " + prestamos.size());
			} else {
				prestamos = (ArrayList<Prestamo>) servicePrestamo.listarPrestados();
				LOG.debug("Prestamos activos recuperados " + prestamos.size());
			}
			response = new ResponseEntity<>(prestamos, HttpStatus.OK);
		} catch (Exception e) {
			LOG.error(e);
		}

		return response;
	}

}
