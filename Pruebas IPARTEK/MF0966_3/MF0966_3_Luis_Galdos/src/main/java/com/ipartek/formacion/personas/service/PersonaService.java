package com.ipartek.formacion.personas.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;

import com.ipartek.formacion.personas.model.PersonaDAO;
import com.ipartek.personas.personas.pojo.Persona;

public class PersonaService {

	// CONSTANTES
	private static final Logger LOG = Logger.getLogger(PersonaService.class);
	private static final String TOKENIZER_DELIMITER = ","; // Los datos están separado por comas

	private static PersonaDAO daoPersona;

	private static ArrayList<Persona> personas;

	private static Persona persona;;
	
	private static PersonaService INSTANCE = null;

	public static synchronized PersonaService getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new PersonaService();
		}
		return INSTANCE;
	}

	private PersonaService() {
		super();
		
		daoPersona = PersonaDAO.getInstance();	// Inicializiar Data Access Object
	}

	public void cargarPersonasDesdeFichero(String ruta) throws Exception {

		leerFichero(ruta);
		insertarDatos();
	}

	public void leerFichero(String ruta) throws Exception {

		personas = new ArrayList<Persona>();
		File archivo;
		FileReader fr;
		BufferedReader br;

		archivo = new File(ruta); // Abrimos el fichero, lanza NullPointerException

		fr = new FileReader(archivo); // Cargamos el FileReader, lanza FileNotFoundException

		br = new BufferedReader(fr); // Abrimos el buffer

		String linea;

		while ((linea = br.readLine()) != null) { // Lectura del fichero linea a linea

			personas.add( procesarLinea(linea) ); // Crear objeto a partir de la linea
			LOG.debug("linea");
			
		}
		
		LOG.debug("Num Personas: " + personas.size());

		if (null != fr) {
			fr.close();
		}

	}

	private Persona procesarLinea(String linea) throws Exception {

		StringTokenizer tokens = new StringTokenizer(linea, TOKENIZER_DELIMITER);

		// Es necesario conocer el formato de los datos
		// en la linea para poder insertar correctamente los datos.

		persona = new Persona();

		if (tokens.countTokens() == 7) { // Evitamos las líneas incorrectas

			persona.setNombre(tokens.nextToken());
			persona.setApellido1(tokens.nextToken());
			persona.setApellido2(tokens.nextToken());

			tokens.nextToken(); // Avanzamos en el tokenizer para evitar la edad (no requerida en el ejercicio)

			persona.setEmail(tokens.nextToken());
			persona.setDni(tokens.nextToken());
			persona.setRol(tokens.nextToken());
		}

		return persona;
	}

	private void insertarDatos() throws Exception {

		if (personas != null) {

			daoPersona.insertMultiple(personas);

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

	/*
	 * public static void main(String[] args) { try { cargarPersonasDesdeFichero();
	 * } catch (Exception e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } }
	 */

}
