package com.ipartek.formacion.prestamos.api.controller;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.prestamolibros.pojo.Editorial;
import com.ipartek.formacion.prestamolibros.service.ServicioEditorial;
import com.ipartek.formacion.prestamos.api.controller.pojo.ResponseMensaje;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/editoriales")
@Api(tags="Editoriales",description="Gestión de Editoriales",produces="application/json")
public class EditorialesController {

	ValidatorFactory factory = null;
	Validator validator = null;
	ServicioEditorial serviceEditorial = null;
	private final static Logger LOG = Logger.getLogger(EditorialesController.class);
 
	public EditorialesController() {
		super();
		serviceEditorial = ServicioEditorial.getInstance();
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();

	}
	@ApiOperation(value = "Listado de editoriales")
	@ApiResponses(value =
						{ 
						  @ApiResponse(code = 200, message = "Editoriales encontradas"),
						  @ApiResponse(code = 500, message = "Ha ocurrido un error") })
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Editorial>> listar() {
		ResponseEntity<ArrayList<Editorial>> response = new ResponseEntity<ArrayList<Editorial>>(
				HttpStatus.INTERNAL_SERVER_ERROR);
		ArrayList<Editorial> editoriales = new ArrayList<Editorial>();

		try {
			ServicioEditorial.getInstance();
			editoriales = (ArrayList<Editorial>) serviceEditorial.listar();
			response = new ResponseEntity<ArrayList<Editorial>>(editoriales, HttpStatus.OK);
		} catch (Exception e) {
			LOG.error(e);
		}

		return response;
	}
	
	@ApiOperation(value = "Detalle de una editorial",response=Editorial.class)
	@ApiResponses(value =
						{ 
						  @ApiResponse(code = 200, message = "Editorial encontrada"),
						  @ApiResponse(code = 404, message = "La editorial no existe"),
						  @ApiResponse(code = 500, message = "Ha ocurrido un error")
						  
						  })
	@ApiParam(value="id")
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<Editorial> detalle(@PathVariable long id) {
		ResponseEntity<Editorial> response = new ResponseEntity<Editorial>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {

			Editorial edit = serviceEditorial.buscar(id);
			if (edit != null && edit.getId() > 0) {
				response = new ResponseEntity<Editorial>(edit, HttpStatus.OK);
			} else {
				response = new ResponseEntity<Editorial>(HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			LOG.error(e);		}
		return response;

	}
	
	

	
	@ApiOperation(value = "Crear una editorial",response=Editorial.class,notes="<ol><li>EDITORIAL: minimo 2 caracteres, máximo 50</li></ol>")
	@ApiResponses(value =
						{ 
						  @ApiResponse(code = 201, message = "Editorial creada"),
						  @ApiResponse(code = 409, message = "<ol><li>La editorial que intenta crear ya existe</li><li>El formato o los datos introducidos no son correctos</li></ol>"),
						  @ApiResponse(code = 500, message = "Ha ocurrido un error")
						  
						  })
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> crear(@RequestBody Editorial editorial) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		ResponseMensaje msg = new ResponseMensaje();
		try {

			// Validacion con javax validator
			Set<ConstraintViolation<Editorial>> violations = validator.validate(editorial);
			if (violations.isEmpty()) {
				if (serviceEditorial.crear(editorial)) {
					response = new ResponseEntity<>(editorial, HttpStatus.CREATED);
				} else {
					response = new ResponseEntity<>(new ResponseMensaje("La editorial ya existe"), HttpStatus.CONFLICT);
				}
			} else {
				for (ConstraintViolation<Editorial> constraint : violations) {
					msg.addError((constraint.getPropertyPath() + ": " + constraint.getMessage()));
				}
				response = new ResponseEntity<>(msg, HttpStatus.CONFLICT);

			}

		} catch (SQLIntegrityConstraintViolationException e) {
			
			response = new ResponseEntity<>(
					new ResponseMensaje("Ya existe una editorial con ese nombre, por favor cambialo"),
					HttpStatus.CONFLICT);
			LOG.debug(response);
		} catch (Exception e) {

			LOG.error(e);
		}

		return response;
	}
	
	
	
	

	
	@ApiOperation(value = "Modificar una editorial",response=Editorial.class,notes="<ol><li>NOMBRE: minimo 2 caracteres, máximo 50</li></ol>")
	@ApiResponses(value =
						{ 
						  @ApiResponse(code = 200, message = "Editorial modificada con éxito"),
						  @ApiResponse(code = 404, message = "La editorial no existe"),
						  @ApiResponse(code = 409, message = "<ol><li>Ya existe una editorial con ese nombre, por favor elige otro nombre</li><li>Los datos introducidos o su formato son incorrectos</li></ol>"),
						  @ApiResponse(code = 500, message = "Ha ocurrido un error")
						  })
	@ApiParam(value="id")
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> modificar(@PathVariable long id, @RequestBody Editorial editorial) {
		ResponseMensaje msg = new ResponseMensaje();

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {
			Set<ConstraintViolation<Editorial>> violations = validator.validate(editorial);
			if (violations.isEmpty()) {
				editorial.setId(id);
			
				if (serviceEditorial.modificar(editorial)) {
					response = new ResponseEntity<>(editorial, HttpStatus.OK);
				} else {
					response = new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
				}
			} else {

				for (ConstraintViolation<Editorial> constraint : violations) {
					msg.addError((constraint.getPropertyPath() + ": " + constraint.getMessage()));
				}
				response = new ResponseEntity<>(msg, HttpStatus.CONFLICT);

			}
		} catch (SQLIntegrityConstraintViolationException e) {
			
			response = new ResponseEntity<>(
					new ResponseMensaje("Ya existe una editorial con ese nombre, por favor elige otro nombre o los datos introducidos son incorrectos"),
					HttpStatus.CONFLICT);
			LOG.debug(response);
		} catch (Exception e) {
			LOG.error(e);
		}
		return response;
	}
	
	
	
	
	
	
	@ApiOperation(value = "Eliminar una editorial")
	@ApiResponses(value =
						{ 
						  @ApiResponse(code = 200, message = "Editorial eliminada"),
						  @ApiResponse(code = 404, message = "La editorial no existe"),
						  @ApiResponse(code = 409, message = "No se puede borrar la editorial porque hay un registro asociado"),
						  @ApiResponse(code = 500, message = "Ha ocurrido un error")

						  })
	@ApiParam(value="id")
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> eliminar(@PathVariable long id) {
		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {

			if (serviceEditorial.eliminar(id)) {
				response = new ResponseEntity<>(HttpStatus.OK);
			} else {
				response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (SQLIntegrityConstraintViolationException e) {
			
			response = new ResponseEntity<>(
					new ResponseMensaje("No se puede eliminar esta editorial porque tiene un registro asociado"),
					HttpStatus.CONFLICT);
			LOG.debug(response);
		} catch (Exception e) {
			LOG.error(e);
		}
		return response;

	}
}
