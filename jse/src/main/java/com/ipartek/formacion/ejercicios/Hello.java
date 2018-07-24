package com.ipartek.formacion.ejercicios;

import java.util.logging.Logger;

import com.ipartek.formacion.pojo.Person;

public class Hello {
	public static void main(String[] args) {
		//System.out.println("Hello World");
		
		//Crear array de Strings con nombres de personas
		//Mediante un for pintar uno a uno todos los nombres
		//Generar un número aleatorio para decidir quien lee.
				
		Logger log = Logger.getLogger(Hello.class.getName());
		
		log.info("Listado de alumnos:\n");
		
		Person alumnos[] = {new Person("Eneko", "Muñoz", Person.SEXO_HOMBRE), 
				new Person("Joseba", "Ramirez", Person.SEXO_HOMBRE), 
				new Person("Adrian P", Person.SEXO_HOMBRE), 
				new Person("Ainara", Person.SEXO_MUJER), 
				new Person("Asier", Person.SEXO_HOMBRE), 
				new Person("Adrian", "Garcia", Person.SEXO_HOMBRE), 
				new Person("Raul", Person.SEXO_HOMBRE), 
				new Person("Luis", Person.SEXO_HOMBRE), 
				new Person("Guillermo", Person.SEXO_HOMBRE), 
				new Person("Carlos", Person.SEXO_HOMBRE), 
				new Person("Eneko S", Person.SEXO_HOMBRE), 
				new Person("Adriana", Person.SEXO_MUJER), 
				new Person("Andrea", Person.SEXO_MUJER), 
				new Person("Valeria", Person.SEXO_MUJER), 
				new Person("Alain", Person.SEXO_HOMBRE)};
		
		//Estructura 'for' clásica.
		for (int i = 0; i < alumnos.length; i++) {
			String par = (i % 2 == 0)? " PAR " : " IMPAR ";
			log.info(i + par + alumnos[i]);
			
		}
		
		//for each, pero no tenemos índice 'i'.
		/*for (String alumno : alumnos) {
			System.out.println(alumno);
		}*/
		
		int nAleatorio = (int) (Math.random() * alumnos.length);
		
		log.info("\nEl voluntario/a es " + alumnos[nAleatorio].toString());
	}
}
