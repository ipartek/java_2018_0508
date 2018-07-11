package com.ipartek.formacion.ejecicios;
//import java.util.logging.Logger;

import com.ipartek.formacion.pojo.Person;;

public class ListadoPersonas {

	public static void main(String[] args) {
		
		//Logger log = Logger.getLogger(ListadoPersonas.class.getName());
		
		Person manolo = new Person();
		Person sevilla = new Person();
		Person melendi = new Person();
		
		
		manolo.setName("Manolo");
		manolo.setSurname("kabezabolo");
		manolo.setGender(Person.SEXO_HOMBRE);
		manolo.setAge(52);
		manolo.setMark(5.0f);
		System.out.println(manolo);
		
		sevilla.setName("Miguel Ángel");
		sevilla.setSurname("Rodríguez");
		sevilla.setGender(Person.SEXO_HOMBRE);
		sevilla.setAge(48);
		sevilla.setMark(5.0f);
		System.out.println(sevilla);

		melendi.setName("Ramon");
		melendi.setSurname("Melendi");
		melendi.setGender(Person.SEXO_HOMBRE);
		melendi.setAge(39);
		melendi.setMark(12.0f);
		System.out.println(melendi);
		
		
		
	}

}
