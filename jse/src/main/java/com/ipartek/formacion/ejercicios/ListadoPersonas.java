package com.ipartek.formacion.ejercicios;

import java.util.logging.Logger;

import com.ipartek.formacion.pojo.Person;

public class ListadoPersonas {

	public static void main(String[] args) {
		
		Logger log = Logger.getLogger(ListadoPersonas.class.getName());
		
		Person manolo = new Person();
		Person sevilla = new Person();
		Person melendi = new Person();
		
		manolo.setNombre("Manolo");
		manolo.setApellido("Kabezabolo");
		manolo.setSexo('H');
		manolo.setEdad(52);
		manolo.setNota((float)5.7);
		
		sevilla.setNombre("Miguel Ángel");
		sevilla.setApellido("Rodriguez");
		sevilla.setSexo('m');
		sevilla.setEdad(48);
		sevilla.setNota((float)-3.2);
		
		melendi.setNombre("Ramón");
		melendi.setApellido("Melendi");
		melendi.setSexo('d');
		melendi.setEdad(39);
		melendi.setNota((float)13.2);
				
		log.info(manolo.toString());
		log.info(sevilla.toString());
		log.info(melendi.toString());
		
	}

}
