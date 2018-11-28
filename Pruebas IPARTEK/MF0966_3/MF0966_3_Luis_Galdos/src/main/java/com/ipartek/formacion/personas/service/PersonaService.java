package com.ipartek.formacion.personas.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.log4j.Logger;

import com.ipartek.formacion.personas.model.PersonaDAO;
import com.ipartek.personas.personas.pojo.Persona;
import com.ipartek.personas.personas.pojo.ResultadoVolcadoDeDatos;

public class PersonaService {

	// CONSTANTES
	private static final Logger LOG = Logger.getLogger(PersonaService.class);
	private static final String TOKENIZER_DELIMITER = ","; // Los datos están separado por comas

	private static PersonaDAO daoPersona;
	private static StringTokenizer tokens;
	private static ValidatorFactory factory;
	private static Validator validator;

	private static ArrayList<Persona> personas;

	private static Persona persona;;
	
	private static PersonaService INSTANCE = null;
	
	private static int totalLineas;
	private static int lineasInsertadas;
	private static int lineasEvitadas;

	public static synchronized PersonaService getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new PersonaService();
		}
		return INSTANCE;
	}

	private PersonaService() {
		super();
		
		daoPersona = PersonaDAO.getInstance();	// Inicializiar Data Access Object
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	public ResultadoVolcadoDeDatos cargarPersonasDesdeFichero(File archivo) throws Exception {

		personas = new ArrayList<Persona>();
		
		leerFichero( archivo );
		
		insertarDatos();
		
		return new ResultadoVolcadoDeDatos(totalLineas, lineasInsertadas, lineasEvitadas);

	}

	public int leerFichero(File archivo) throws Exception {

		totalLineas = 0;
		lineasEvitadas = 0;
		lineasInsertadas = 0;

		FileReader fr;
		BufferedReader br;

		fr = new FileReader(archivo); // Cargamos el FileReader, lanza FileNotFoundException

		br = new BufferedReader(fr); // Abrimos el buffer

		String linea;

		while ((linea = br.readLine()) != null) { // Lectura del fichero linea a linea

			procesarLinea( linea ); // Comprobar los datos
			LOG.debug( linea );
			totalLineas++;
			
		}

		if (null != fr) {
			fr.close();
		}
		
		return totalLineas;
	}

	private void procesarLinea(String linea) throws Exception {

		tokens = new StringTokenizer(linea, TOKENIZER_DELIMITER);

		// Es necesario conocer el formato de los datos
		// en la linea para poder insertar correctamente los datos.

		persona = new Persona();

		if (tokens.countTokens() == 7) { // Evitamos las líneas incorrectas
			
			// Los campos deben seguir un orden de lectura estricto
			persona.setNombre(tokens.nextToken());
			persona.setApellido1(tokens.nextToken());
			persona.setApellido2(tokens.nextToken());

			tokens.nextToken(); // Avanzamos en el tokenizer para evitar la edad (no requerida en el ejercicio)

			persona.setEmail(tokens.nextToken());
			persona.setDni( tokens.nextToken() );
			persona.setRol( tokens.nextToken() );
			
			validarPersona( persona );	
		
		} else {	// Línea incorrecta
			
			lineasEvitadas++;
			
		}

	}

	private void validarPersona(Persona persona) {
		
		Set<ConstraintViolation<Persona>> violations = validator.validate(persona);
		
		if ( violations.size() == 0 ) { // Persona OK
			
			personas.add( persona );
			lineasInsertadas++;
			
		} else {
			
			lineasEvitadas++;
			
		}
		
		
	}

	private void insertarDatos() throws Exception {
		
		LOG.debug("Personas size: " + personas.size());
		LOG.debug("Líneas leidas: " + totalLineas);
		LOG.debug("Líneas evitadas: " + lineasEvitadas);
		
		LOG.debug("Lineas ignoradas antes del INSERT: " + lineasEvitadas);
		
		if (personas != null) {

			daoPersona.insertMultiple( personas );

		} else {
			
			LOG.debug("No hay personas en el array.");
		}
		

	}
	
	public boolean crear( Persona persona ) throws Exception {

		return daoPersona.insert( persona );
	}

	public boolean modificar( Persona persona ) throws Exception {

		return daoPersona.update( persona );
	}


	public List<Persona> listar() throws Exception {
		
		return daoPersona.getAll();
		
	}

	public Object obtenerId(long id) throws Exception {
		
		return daoPersona.getById(id);
	}

}
