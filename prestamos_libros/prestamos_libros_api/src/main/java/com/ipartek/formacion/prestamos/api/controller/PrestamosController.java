package com.ipartek.formacion.prestamos.api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.prestamos_libros.pojo.Prestamo;
import com.ipartek.formacion.prestamos_libros.service.ServiceAlumno;
import com.ipartek.formacion.prestamos_libros.service.ServiceEditorial;
import com.ipartek.formacion.prestamos_libros.service.ServiceLibro;
import com.ipartek.formacion.prestamos_libros.service.ServicePrestamo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/prestamos")
public class PrestamosController {
	
	ServicePrestamo servicePrestamo = null;
	ServiceLibro serviceLibro = null;
	ServiceAlumno serviceAlumno = null;
	ServiceEditorial serviceEditorial = null;
	ValidatorFactory factory = null;
	Validator validator = null;
	
	//Logger
	private final static Logger LOG = Logger.getLogger(PrestamosController.class);
	
	public static final int FINALIZADOS = 0;
	
	public PrestamosController() {
		super();
		LOG.trace("Constructor");
		servicePrestamo = ServicePrestamo.getInstance();
		LOG.trace("Servicio préstamo instanciado");
		serviceLibro = ServiceLibro.getInstance();
		serviceAlumno = ServiceAlumno.getInstance();
		serviceEditorial = ServiceEditorial.getInstance();
		
		//Crear Factoria y Validador
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@ApiOperation(value = "Listado de prestamos activos o historico")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Listado Prestamos")})
	@ApiImplicitParams({
	    @ApiImplicitParam(name = "activos", value = "0: Historico, 1: Activos", required = false, dataType = "int", paramType = "RequestParam")
	  })
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Prestamo>> listado(@RequestParam(value = "activos", required = false, defaultValue = "-1") int activos) {
		ResponseEntity<ArrayList<Prestamo>> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
		
		try {
			//Si es 0 es historico, si es 1 son activos
			if(activos == FINALIZADOS) {
				prestamos = (ArrayList<Prestamo>) servicePrestamo.listarHistorico();
				LOG.debug("Prestamos de histórico recuperados "+prestamos.size());
			}else{
				prestamos = (ArrayList<Prestamo>) servicePrestamo.listarPrestados();
				LOG.debug("Prestamos activos recuperados "+prestamos.size());
			}
			response = new ResponseEntity<>(prestamos, HttpStatus.OK);
		}catch(Exception e) {
//			e.printStackTrace();
			LOG.error(e);
		}
		
		return response;
	}
	
}
