package com.ipartek.formacion.prestamos.api.controller;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.prestamos_libros.pojo.Prestamo;
import com.ipartek.formacion.prestamos_libros.service.ServicePrestamo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/prestamos")
@Api(value = "PRESTAMOS", description = "prestamos de libros", tags = { "PRESTAMOS" })
public class PrestamosController {

	ServicePrestamo servicePrestamo = null;
	private final static Logger LOG = Logger.getLogger(PrestamosController.class);
	

	public PrestamosController() {
		super();
		LOG.trace("constructor");
		servicePrestamo = new ServicePrestamo();
		LOG.trace("servicio prestamos instanciado");
	
	}

	@ApiOperation( value = "Listado Prestamos Activos o Historico")
	@ApiResponses( value = {@ApiResponse(code=200, message="Listado Prestamos")})
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Prestamo>> listado( @RequestParam(name="activos", required=false, defaultValue="-1" ) int activos) {

		ArrayList<Prestamo> list = new ArrayList<Prestamo>();
		ResponseEntity<ArrayList<Prestamo>> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {

			list = (ArrayList<Prestamo>) servicePrestamo.listar();
			LOG.debug("prestamos recuperados " + list.size());
			response = new ResponseEntity<>(list, HttpStatus.OK);

		} catch (Exception e) {
			LOG.error(e);
			//e.printStackTrace();
		}

		return response;
	}

	

}
