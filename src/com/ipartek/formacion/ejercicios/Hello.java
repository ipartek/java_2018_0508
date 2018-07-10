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
		log.info("Listado Alumnos-----------------");

		 
		//String[] alumnos = { "Eneko Muñoz", "joseba", "Adrian P","Ainara", "Asier", "Adrian G", " Raul", "Luis", "Guillermo", "Carlos",
		//		"Eneko Sanchez","Adriana", "Andrea", "Valeria", "Alain" };

		Person[] alumnos = new Person[15];
		
		Person p = new Person("Eneko" , "Muñoz", Person.SEXO_HOMBRE );
		alumnos[0] = p;
		
		p = new Person("Joseba" , "Ramirez", Person.SEXO_HOMBRE );
		alumnos[1] = p;
		
		p = new Person("Adrian" , "Perozzo", Person.SEXO_HOMBRE );
		alumnos[2] = p;
		
		p = new Person("Ainara" , "Goitia", Person.SEXO_MUJER );
		alumnos[3] = p;
		
		p = new Person("Asier" , "Cornejo", Person.SEXO_HOMBRE );
		alumnos[4] = p;
		
		p = new Person("Adrian" , "Garcia", Person.SEXO_HOMBRE );
		alumnos[5] = p;
		
		p = new Person("Raul" , "Abejon", Person.SEXO_HOMBRE );
		alumnos[6] = p;
		
		p = new Person("Luis" , "Galdos", Person.SEXO_HOMBRE );
		alumnos[7] = p;
		
		p = new Person("Guillermo" , "Sanchez", Person.SEXO_HOMBRE );
		alumnos[8] = p;
		
		p = new Person("Carlos" , "Leon", Person.SEXO_HOMBRE );
		alumnos[9] = p;
		
		p = new Person("Eneko" , "Sanchez", Person.SEXO_HOMBRE );
		alumnos[10] = p;
		
		p = new Person("Adriana" , "Prado", Person.SEXO_MUJER );
		alumnos[11] = p;
		
		p = new Person("Andrea" , "Perez", Person.SEXO_MUJER );
		alumnos[12] = p;
		
		p = new Person("Valeria" , "Valencia", Person.SEXO_MUJER);
		alumnos[13] = p;
		
		p = new Person("Alain" , "Muñoz", Person.SEXO_HOMBRE );
		alumnos[13] = p;
		
		
				
		
		// for clasico
		for (int i = 0; i < alumnos.length; i++) {
			log.info(i + " " + alumnos[i]);
		}

		log.info("------------------------------------");

		int numero = (int) ((Math.random() * alumnos.length));

		log.info("Voluntario es " + alumnos[numero].toString() );

	

	}

}
