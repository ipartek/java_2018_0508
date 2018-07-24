package com.ipartek.formacion.ejercicios;

import java.util.logging.Logger;

import com.ipartek.formacion.pojo.Person;

public class HelloWorld {
	
	//Cambiar syso por log
	static Logger log = Logger.getLogger(HelloWorld.class.getName().toString());
	
	//Cambiar array de String por Person
	static Person[] aula;
	static String[] nombres  = {"Eneko", "Joseba", "Adrián P", "Ainara", "Asier", "Adrián G", "Raul", "Luis",
			"Guillermo", "Carlos", "Eneko S.", "Adriana", "Andrea", "Valeria", "Alain"};
	static String[] apellidos = {"Muñoz", "Ramirez", "Perozzo", "Goitia", "Cornejo", "García", "Abejón", "Galdos",
			"Sánchez", "Sánchez", "Pérez", "Valencia", "Muñóz"};
	
	public static void main (String args[]) {
		log.info("Listado de Alumnos: ");
		log.info("--------------------");
		for (int i = 0; i<nombres.length; i++) {
			log.info((i + " " + nombres[i]));
		}
		inicializarAula(nombres, apellidos);
		log.info("--------------------");
		log.info("Afortunado " + aula[dado()]);
	}
	
	private static void inicializarAula(String[] nombs, String[] apels) {
		Person p;
		aula = new Person[nombres.length];
		for (int i = 0; i<nombres.length; i++) {
			if (nombres[i].equals("Ainara") || nombres[i].equals("Andrea") || nombres[i].equals("Valeria")) {
				p = new Person(nombres[i], apellidos[i], Person.SEXO_MUJER);
			} else {
				p = new Person(nombres[i], apellidos[i], Person.SEXO_HOMBRE);
			}
			aula[i] = p;
		}
	}
	
	public static int dado() {
		int n = (int) (Math.random()* aula.length);
		return n; 
	}
	

}
