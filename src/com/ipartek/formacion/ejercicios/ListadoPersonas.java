package com.ipartek.formacion.ejercicios;

import java.util.logging.Logger;

import com.ipartek.formacion.pojo.Person;

public class ListadoPersonas {
	
	static Logger log = Logger.getLogger(ListadoPersonas.class.getName().toString());

	public static void main(String[] args) {

		Person manolo = new Person();
		manolo.setNombre("Manolo");
		manolo.setApellido("Cabezabolo");
		manolo.setEdad(52);
		manolo.setSexo(Person.SEXO_HOMBRE);
		manolo.setNota(8.0f);
		log.info(manolo.toString());

		Person elSevilla = new Person();
		elSevilla.setNombre("Miguel Ángel");
		elSevilla.setApellido("Rodriguez");
		elSevilla.setEdad(48);
		elSevilla.setSexo(Person.SEXO_HOMBRE);
		elSevilla.setNota(7.0f);
		log.info(elSevilla.toString());
	}

}
