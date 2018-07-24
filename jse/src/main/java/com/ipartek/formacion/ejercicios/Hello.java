package com.ipartek.formacion.ejercicios;

import java.util.logging.Logger;

import com.ipartek.formacion.pojo.Person;

public class Hello {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Logger log = Logger.getLogger(Hello.class.getName());

		log.info("Listado de Alumnos");
		/*
		 * String[] alumnos = { "Eneko Muñoz", "joseba", "Adrian P","Ainara", "Asier",
		 * "Adrian G", " Raul", "Luis", "Guillermo", "Carlos",
		 * "Eneko Sanchez","Adriana", "Andrea", "Valeria", "Alain" };
		 */

		Person[] alumnos = new Person[15];
		Person p = new Person("Eneko", "Muñoz", Person.SEX_HOMBRE);
		alumnos[0] = p;
		p = new Person("Joseba", "Ramirez", Person.SEX_HOMBRE);
		alumnos[1] = p;

		/*
		 * { "Adrian P", "Ainara", "Asier", "Adrian G", "Raul", "Luis", "Guillermo",
		 * "Carlos", "Eneko Sanchez","Adriana", "Andrea", "Valeria", "Alain" };
		 */

		// for clasico
		for (int i = 0; i < alumnos.length; i++) {
			String PAR = (i % 2 == 0) ? "PAR" : "IMPAR";
			log.info(i + " " + PAR + " " + alumnos[i]);
		}

		log.info("------------------------------------");
		@SuppressWarnings("unused")
		int num = (int) ((Math.random() * alumnos.length));

		log.info("Voluntario es " + alumnos.toString());

	}

}
