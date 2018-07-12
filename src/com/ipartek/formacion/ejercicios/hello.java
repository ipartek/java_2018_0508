package com.ipartek.formacion.ejercicios;
import com.ipartek.formacion.pojo.Person;
import java.util.logging.Logger;

public class hello {
	
	public static void exercise() {
		
		Logger log=Logger.getLogger(hello.class.getName());
		
		Person []alumnos = {new Person("EnekoM",Person.SEXO_HOMBRE), new Person("Joseba",Person.SEXO_HOMBRE), new Person("Adrian P",Person.SEXO_HOMBRE), new Person("Ainara",Person.SEXO_MUJER), new Person("Asier",Person.SEXO_HOMBRE), new Person("Adrian G",Person.SEXO_HOMBRE), new Person("Raul",Person.SEXO_HOMBRE), new Person("Luis",Person.SEXO_HOMBRE), new Person("Guillermo",Person.SEXO_HOMBRE), new Person("Carlos",Person.SEXO_HOMBRE), new Person("EnekoS",Person.SEXO_HOMBRE), new Person("Adriana",Person.SEXO_MUJER), new Person("Andrea",Person.SEXO_MUJER), new Person("Valeria",Person.SEXO_MUJER), new Person("Alain",Person.SEXO_HOMBRE)};
		//Array de strings con nombres de personas
		//String[] nombres = {"EnekoM","Joseba","Adrian P","Ainara","Asier","Adrian G","Raul","Luis","Guillermo","Carlos","EnekoS","Adriana","Andrea","Valeria","Alain"};
		
		for (int i = 0; i < alumnos.length; i++) {
			//System.out.print(alumnos[i].getName());
			//System.out.print((i != (alumnos.length)-1)?", ":".");
			log.info(alumnos[i].getName());
		}
		
		
		//numero aleatorio para decir quien es el afortunado que le toca leer
		System.out.println();
		int randomNum = (int)(Math.random() * alumnos.length);
		//System.out.println((randomNum+1)+"."+alumnos[randomNum].getName());
		log.info((randomNum+1)+"."+alumnos[randomNum].getName());
	

	}
	
	
	public static void main(String[] args) {
	
		int []values = {0,3,1,8,7,2,5,4,6,9};
		values = Utilities.bubbleSort(values,true);
		for (int value : values) {
			System.out.print(value);
		}	
		System.out.println();
		values = Utilities.bubbleSort(values,false);
		for (int value : values) {
			System.out.print(value);
		}	
	}
}
