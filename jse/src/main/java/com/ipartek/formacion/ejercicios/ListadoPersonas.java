package com.ipartek.formacion.ejercicios;

import java.util.logging.Logger;

import com.ipartek.formacion.pojo.Person;

public class ListadoPersonas {

	
	public static void main(String[] args) {
		
		Logger log = Logger.getLogger(ListadoPersonas.class.getName());
						
		Person manolo = new Person();
		manolo.setNombre("Manolo");
		manolo.setApellido("Kabezabolo");
		manolo.setEdad(45);
		manolo.setNota(7.6f);
		manolo.setSexo( Person.SEXO_HOMBRE );
		
		log.info( manolo.toString() );
		
		
		Person sinSexo = new Person("Trdiste", 'o'); 
		log.info( sinSexo.toString() );
		
	}
	
}
