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
import com.ipartek.formacion.prestamolibros.pojo.Libro;
import com.ipartek.formacion.prestamolibros.service.ServicioEditorial;
import com.ipartek.formacion.prestamolibros.service.ServicioLibro;
import com.ipartek.formacion.prestamos.api.controller.pojo.ResponseMensaje;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/libros")
@Api(tags="Libros",description="Gestión de Libros",produces="application/json")
public class LibrosController {
	ValidatorFactory factory = null;
	Validator validator = null;
	ServicioLibro servicioLibro = null;
	ServicioEditorial servicioEditorial=null;
	private final static Logger LOG = Logger.getLogger(LibrosController.class);
  

	public LibrosController() {
		super();
		servicioLibro = ServicioLibro.getInstance();
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
		servicioEditorial= ServicioEditorial.getInstance();

	}
	
	
	
	@ApiOperation(value = "Listado de Libros")
	@ApiResponses(value =
						{ 
						  @ApiResponse(code = 200, message = "Libros encontradas"),
						  @ApiResponse(code = 500, message = "Ha ocurrido un error") })
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Libro>> listar() {
		ResponseEntity<ArrayList<Libro>> response = new ResponseEntity<ArrayList<Libro>>(
				HttpStatus.INTERNAL_SERVER_ERROR);
		ArrayList<Libro> libros = new ArrayList<Libro>();

		try {
			ServicioEditorial.getInstance();
			libros = (ArrayList<Libro>) servicioLibro.listar();
			response = new ResponseEntity<ArrayList<Libro>>(libros, HttpStatus.OK);
		} catch (Exception e) {
			LOG.error(e);
		}

		return response;
	}
	
	
	
	@ApiOperation(value = "Detalle de un libro",response=Libro.class)
	@ApiResponses(value =
						{ 
						  @ApiResponse(code = 200, message = "Libro encontrado"),
						  @ApiResponse(code = 404, message = "El libro no existe"),
						  @ApiResponse(code = 500, message = "Ha ocurrido un error")
						  
						  })
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<Libro> detalle(@PathVariable long id) {
		ResponseEntity<Libro> response = new ResponseEntity<Libro>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {

			Libro libro = servicioLibro.buscar(id);
			if (libro != null && libro.getId() > 0) {
				response = new ResponseEntity<Libro>(libro, HttpStatus.OK);
			} else {
				response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			LOG.error(e);
		}
		return response;

	}
	
	
	
	

	
	@ApiOperation(value = "Crear un libro",response=Libro.class,notes="<ol><li>TÍTULO: minimo 2 caracteres, máximo 150</li><li>ISBN: minimo 2 caracteres, máximo 20</li></ol>")
	@ApiResponses(value =
						{ 
						  @ApiResponse(code = 201, message = "Libro creado"),
						  @ApiResponse(code = 409, message = "<ol><li>El libro intenta crear ya existe</li><li>Los datos introducidos o su formato no son correctos</li></ol>"),
						  @ApiResponse(code = 500, message = "Ha ocurrido un error")
						  
						  })
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> crear(@RequestBody Libro libro) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		ResponseMensaje msg = new ResponseMensaje();
		try {

			// Validacion con javax validator
			Set<ConstraintViolation<Libro>> violations = validator.validate(libro);
			if (violations.isEmpty()) {
				if (servicioLibro.crear(libro)) {
					Editorial editorial=servicioEditorial.buscar(libro.getEditorial().getId());
					libro.setEditorial(editorial);
					response = new ResponseEntity<>(libro, HttpStatus.CREATED);
				} else {
					response = new ResponseEntity<>(new ResponseMensaje("El libro ya existe"), HttpStatus.CONFLICT);
				}
			} else {
				for (ConstraintViolation<Libro> constraint : violations) {
					msg.addError((constraint.getPropertyPath() + ": " + constraint.getMessage()));
					msg.setMensaje("Ha ocurrido un error");
				}
				response = new ResponseEntity<>(msg, HttpStatus.CONFLICT);

			}

		} catch (SQLIntegrityConstraintViolationException e) {
			
			response = new ResponseEntity<>(
					new ResponseMensaje("Ya existe un libro con ese nombre, por favor cambialo"), HttpStatus.CONFLICT);
			LOG.debug(response);

		} catch (Exception e) {

			LOG.error(e);
		}

		return response;
	}
	
	
	
	
	
	
	@ApiOperation(value = "Modificar un libro",response=Libro.class,notes="<ol><li>TÍTULO: minimo 2 caracteres, máximo 150</li><li>ISBN: minimo 2 caracteres, máximo 20</li></ol>")
	@ApiResponses(value =
						{ 
					
						  @ApiResponse(code = 200, message = "Libro modificado con éxito"),
						  @ApiResponse(code = 404, message = "El libro no existe"),
						  @ApiResponse(code = 409, message = "Los datos introducidos o su formato son incorrectos"),
						  @ApiResponse(code = 500, message = "Ha ocurrido un error")
						  })
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> modificar(@PathVariable long id, @RequestBody Libro libro) {
		ResponseMensaje msg = new ResponseMensaje();

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {
			Set<ConstraintViolation<Libro>> violations = validator.validate(libro);
			if (violations.isEmpty()) {
				libro.setId(id);
				if (servicioLibro.modificar(libro)) {
					
					Editorial editorial = servicioEditorial.buscar(libro.getEditorial().getId());
					libro.setEditorial(editorial);
					response = new ResponseEntity<>(libro, HttpStatus.OK);
				} else {
					response = new ResponseEntity<>(new ResponseMensaje("El libro que intenta modificar no exite"),HttpStatus.NOT_FOUND);
				}
			} else {

				for (ConstraintViolation<Libro> constraint : violations) {
					msg.addError((constraint.getPropertyPath() + ": " + constraint.getMessage()));
				}
				response = new ResponseEntity<>(msg, HttpStatus.CONFLICT);

			}
		

		} catch (Exception e) {
			LOG.error(e);
		}
		return response;
	}
	
	
	
	
	@ApiOperation(value = "Eliminar un libro")
	@ApiResponses(value =
						{ 
						  @ApiResponse(code = 200, message = "Libro eliminado"),
						  @ApiResponse(code = 404, message = "El libro no existe"),
						  @ApiResponse(code = 409, message = "No se puede borrar el libro porque hay un registro asociado"),
						  @ApiResponse(code = 500, message = "Ha ocurrido un error")

						  })
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> eliminar(@PathVariable long id) {
		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {

			if (servicioLibro.eliminar(id)) {
				response = new ResponseEntity<>(HttpStatus.OK);
			} else {
				response = new ResponseEntity<>(new ResponseMensaje("No se puede eliminar este Libro porque no existe"),
						HttpStatus.NOT_FOUND);
			}
		} catch (SQLIntegrityConstraintViolationException e) {
			
			response = new ResponseEntity<>(
					new ResponseMensaje("No se puede eliminar este Libro porque tiene un registro asociado"),
					HttpStatus.CONFLICT);
			LOG.debug(response);
		} catch (Exception e) {
			LOG.error(e);
		}
		return response;

	}

}
