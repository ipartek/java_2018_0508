package com.ipartek.formacion.personas.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.log4j.Logger;

import com.google.gson.JsonElement;
import com.ipartek.formacion.personas.model.PersonaDAO;
import com.ipartek.formacion.personas.pojo.Persona;
import com.ipartek.formacion.personas.pojo.ResultadoUpdate;
import com.ipartek.formacion.personas.pojo.ResultadoVolcadoDeDatos;


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

		daoPersona = PersonaDAO.getInstance(); // Inicializiar Data Access Object
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	public ResultadoVolcadoDeDatos cargarPersonasDesdeFichero(File archivo) throws Exception {

		personas = new ArrayList<Persona>();

		leerFichero(archivo);

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

		LOG.debug("Leyendo el archivo, por favor espere...");

		while ((linea = br.readLine()) != null) { // Lectura del fichero linea a linea

			procesarLinea(linea); // Comprobar los datos
			totalLineas++;

		}

		if (null != fr) {
			fr.close();
		}

		LOG.debug("Lectura de archivo completada.");

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
			persona.setDni(tokens.nextToken());
			persona.setRol(tokens.nextToken());

			if (validarPersona(persona).size() == 0) { // Persona OK

				personas.add(persona);
				lineasInsertadas++;

			} else { // Validaciones incorrectas

				lineasEvitadas++;

			}

		} else { // Línea incorrecta

			lineasEvitadas++;

		}

	}

	private Set<ConstraintViolation<Persona>> validarPersona(Persona persona) {

		Set<ConstraintViolation<Persona>> violations = validator.validate(persona);

		return violations;

	}

	private void insertarDatos() throws Exception {

		LOG.debug("Líneas leidas: " + totalLineas);
		LOG.debug("Líneas aceptadas: " + lineasInsertadas);
		LOG.debug("Personas creadas: " + personas.size());
		LOG.debug("Líneas evitadas: " + lineasEvitadas);

		if (personas != null) {

			daoPersona.insertMultiple(personas);

		} else {

			LOG.debug("No hay personas en el array.");
		}

	}

	public ResultadoUpdate crear(Persona persona) throws Exception {

		ResultadoUpdate result = new ResultadoUpdate();

		Set<ConstraintViolation<Persona>> violations = validarPersona(persona);

		if ( violations.size() == 0 ) {

			result.setResult(daoPersona.insert(persona));

		}

		result.setViolations(violations);

		return result;
	}

	public ResultadoUpdate modificar(Persona persona) throws Exception {

		ResultadoUpdate result = new ResultadoUpdate();

		Set<ConstraintViolation<Persona>> violations = validarPersona(persona);

		if ( violations.size() == 0 ) {

			result.setResult( daoPersona.update(persona) );

		}

		result.setViolations( violations );

		return result;
	}

	public List<Persona> listar() throws Exception {

		return daoPersona.getAll();

	}

	public Persona obtenerId(long id) throws Exception {

		return daoPersona.getById(id);
	}

	public ArrayList<Persona> buscar(String txtBusqueda) throws SQLException {
		
		return daoPersona.buscar( txtBusqueda );
	}

}
