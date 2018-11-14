package com.ipartek.formacion.prestamos.api.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.pojo.Alumno;
import com.ipartek.formacion.service.ServiceAlumno;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/alumnos")

@Api(tags = "Alumnos",  description = "Parte de la API que controla las alumnos")
public class AlumnosController {

	ServiceAlumno serviceAlumno = null;
	ValidatorFactory factory = null;
	Validator validator = null;

	public AlumnosController() {
		super();
		serviceAlumno = serviceAlumno.getInstance();
		// Crear Factoria y Validador
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@ApiOperation( 
		    value = "Lista todas los alumnos que se encuentran en la BBDD", 
		    notes = ""
		)
		@ApiResponses( {
		    @ApiResponse( code = 404, message = "No existe la dirección a la que intenta acceder." )    
		} )		
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<ArrayList<Alumno>> listar() {

		ArrayList<Alumno> list = new ArrayList<Alumno>();
		ResponseEntity<ArrayList<Alumno>> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		try {
			list = (ArrayList<Alumno>) serviceAlumno.listar();
			response = new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}
	
	@ApiOperation( 
		    value = "Lista un alumno concreto que se encuentran en la BBDD", 
		    notes = "Busqueda por ID de alumno"
		)
		@ApiResponses( {
		    @ApiResponse( code = 404, message = "Alumno no existe" )    
		} )		  

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Alumno> detalle(@PathVariable long id) {
		ResponseEntity<Alumno> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {
			Alumno alumno = serviceAlumno.buscar(id);

			if (alumno != null && alumno.getId() > 0) {
				response = new ResponseEntity<>(alumno, HttpStatus.OK);
			} else {
				response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;

	}
	
	@ApiOperation( 
		    value = "Elimina un alumno concreto que se encuentran en la BBDD", 
		    notes = "Se requiere un ID de alumno para eliminar el registro."
		)
		@ApiResponses( {
		    @ApiResponse( code = 409, message = "Alumno tiene un prestamo y no se puede eliminar." ),    
		    @ApiResponse( code = 404, message = "El registro a eliminar no existe" )
		} )	

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> eliminar(@PathVariable long id) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {
						
			if ( serviceAlumno.eliminar(id) ) {
				response = new ResponseEntity<>(HttpStatus.OK);
			}else {
				response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		
		}catch( SQLIntegrityConstraintViolationException e ) {	
			response = new ResponseEntity<>(new ResponseMensaje("No se puede eliminar si tiene Libros asociados"), HttpStatus.CONFLICT);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
	
	@ApiOperation( 
		    value = "Crea un nuevo registro para alumno", 
		    notes = "Se requiere un nombre de alumno comprendido entre 2 y 100 caracteres."
		    		+ "Se requiere un apellido de alumno comprendido entre 2 y 100 caracteres."
		)
		@ApiResponses( {
		    @ApiResponse( code = 409, message = "El error se pproduce por dos opciones. Nombre y apellido coinciden con un registro de la BBDD o los datos introducidos no cumple con los parametros establecidos." )    
		} )

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> crear(@RequestBody Alumno alumno) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {

			Set<ConstraintViolation<Alumno>> violations = validator.validate(alumno);
			if(violations.isEmpty()) {
				 
				if (serviceAlumno.crear(alumno)) {
					response = new ResponseEntity<>(alumno, HttpStatus.CREATED);
				} else {
					response = new ResponseEntity<>(HttpStatus.CONFLICT);
				}
			}else {
				ResponseMensaje mensaje = new ResponseMensaje("Los datos no son correctos");
				for (ConstraintViolation<Alumno> violation : violations) {
					mensaje.addError( violation.getPropertyPath() + ": " + violation.getMessage() );
					
					
				}
				response = new ResponseEntity<>( mensaje ,  HttpStatus.CONFLICT);
			}

			
		} catch (SQLIntegrityConstraintViolationException e) {
			ResponseMensaje msj = new ResponseMensaje("Ya existe el Alumno, por favor prueba con otro nombre");			
			response = new ResponseEntity<>(msj, HttpStatus.CONFLICT);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;

	}
	
	@ApiOperation( 
		    value = "Modifica un alumno", 
		    notes = "Se requiere un ID."
		)
		@ApiResponses( {
		    @ApiResponse( code = 409, message = "Error producido por varios motivos. El alumno ya existe. Los datos introducidos no cumplen las condiciones especificadas." )    
		} )
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> modificar(@PathVariable long id, @RequestBody Alumno alumno) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {
			
			Set<ConstraintViolation<Alumno>> violations =  validator.validate(alumno);
			if ( violations.isEmpty() ) {
			
				alumno.setId(id);			
				if ( serviceAlumno.modificar(alumno) ) {
					response = new ResponseEntity<>(alumno, HttpStatus.OK);
				}else {
					response = new ResponseEntity<>(HttpStatus.CONFLICT);
				}
				
			}else {
				ResponseMensaje mensaje = new ResponseMensaje("Los datos no son correctos");
				for ( ConstraintViolation<Alumno> v : violations ) {
					mensaje.addError( v.getPropertyPath() + ": " + v.getMessage() );
				};
				response = new ResponseEntity<>( mensaje ,  HttpStatus.CONFLICT);
			}	
		
		}catch (SQLIntegrityConstraintViolationException e) {
			
			response = new ResponseEntity<>( new ResponseMensaje("Ya existe la Alumno, por favor prueba con otro nombre")  ,HttpStatus.CONFLICT);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
}
