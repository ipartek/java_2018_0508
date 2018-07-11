package com.ipartek.formacion.ejercicios;

import java.util.logging.Logger;

import com.ipartek.formacion.pojo.Person;

public class ListadoPersonas {

	public static void main(String[] args) {
		
		Logger log = Logger.getLogger(ListadoPersonas.class.getName());
		Person manolo = new Person();
		manolo.setNombre("Manolo");
		manolo.setApellido ("Cabezabolo");
		manolo.setEdad(-45);
		manolo.setNota(80f);
		manolo.setSexo (Person.SEX_HOMBRE);
		
		Person nuevo= new Person();
		nuevo.setNombre("Manolo");
		nuevo.setSexo('o');
		
		System.out.println(manolo);
		System.out.println(nuevo);
		log.info(manolo.toString());
		
	}

}
