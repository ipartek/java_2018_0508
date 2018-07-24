package com.ipartek.formacion.ejercicios;

import java.util.logging.Logger;

import com.ipartek.formacion.pojo.Person;

public class ListadoPersonas {

	public static void main(String[] args) {
		Logger log = Logger.getLogger(ListadoPersonas.class.getName());

		// El sevilla y melendi
		Person manolo = new Person();
		Person sevilla = new Person();
		Person melendi = new Person();
		manolo.setNombre("Manolo");
		manolo.setApellido("Kabezabolo");
		manolo.setNota(18);
		manolo.setSexo('M');
		manolo.setEdad(0);
		log.info(manolo.toString());

		sevilla.setNombre("Hector");
		sevilla.setApellido("Sevilla");
		sevilla.setEdad(48);
		sevilla.setNota(-5);
		sevilla.setEdad(98);
		sevilla.setSexo('h');
		log.info(sevilla.toString());

		melendi.setNombre("Ramón");
		melendi.setApellido("Melendi");
		melendi.setNota(7.5f);
		melendi.setEdad(12);
		melendi.setSexo('I');

		log.info(melendi.toString());
		;// Porque tiene el metodo toString();

	}

}
