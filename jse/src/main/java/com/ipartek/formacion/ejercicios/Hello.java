package com.ipartek.formacion.ejercicios;

import java.util.logging.Logger;

import com.ipartek.formacion.pojo.Person;

public class Hello {
	// crear array con los nombres de personas recorrerlo con un for pintar todos
	// los nombres.
	// generaar un numero aleatorio para decir quien es el que lee.

	public static void main(String[] args) {
		Logger log = Logger.getLogger(Hello.class.getName());
		log.info("Listado de alumnos---------");
		Person[] alumnos = { new Person("EnekoM", Person.SEXO_HOMBRE), new Person("Joseba", Person.SEXO_HOMBRE),
				new Person("AdrianP", Person.SEXO_HOMBRE), new Person("Ainara", Person.SEXO_MUJER),
				new Person("Asier", Person.SEXO_HOMBRE), new Person("AdrianG", Person.SEXO_HOMBRE),
				new Person("Raul", Person.SEXO_HOMBRE), new Person("Luis", Person.SEXO_HOMBRE),
				new Person("Guillermo", Person.SEXO_HOMBRE), new Person("Carlos", Person.SEXO_HOMBRE),
				new Person("EnekoS", Person.SEXO_HOMBRE), new Person("Adriana", Person.SEXO_MUJER),
				new Person("Valeria", Person.SEXO_MUJER), new Person("Alain", Person.SEXO_HOMBRE) };

		/*
		 * String[] nombres = { "EnekoM", "Joseba", "AdrianP", "Ainara", "Asier",
		 * "Adrian García", "Raúl", "Luis", "Guillermo", "Carlos", "EnekoS", "Adriana",
		 * "Valeria", "Alain" };
		 */
		int numero;

		for (int i = 0; i < alumnos.length; i++) {
			String par = (i % 2 == 0) ? "PAR " : "IMPAR ";
			// System.out.println(par + i + " " + alumnos[i]);
			log.info(par + i + "  " + alumnos[i]);
		}

		numero = (int) (Math.random() * alumnos.length);
		// System.out.println("Alumno seleccionado: " + alumnos[numero]);
		log.info("Alumno seleccionado: " + alumnos[numero]);

	}
}
