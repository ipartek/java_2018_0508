package com.ipartek.formacion.ejercicios;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Clase Conjuntos con diferentes tipos de colecciones vistas en clase.
 * 
 * @author Curso
 *
 */
public class Conjuntos {

	public static void main(String[] args) {

		System.out.println("Set: ");
		
		Set<Integer> setOfIntegers = new HashSet<Integer>(); // Un 'Set' es una lista que no permite objetos duplicados.

		setOfIntegers.add(Integer.valueOf(10));
		setOfIntegers.add(Integer.valueOf(11));
		setOfIntegers.add(Integer.valueOf(10));

		for (Integer i : setOfIntegers) {
			System.out.println("Integer value is: " + i);
		}
	
		System.out.println("\nHasMap: ");
		
		HashMap<String, String> hmIdiomas= new HashMap<String, String>();
		
		hmIdiomas.put("En_En", "Inglés de Inglaterra");
		hmIdiomas.put("ES_Es", "Español de España");
		hmIdiomas.put("Es_Eu", "Euskera de España");
		hmIdiomas.put("Es_ct", "Catalán de España");
		
		for (Entry<String, String> pais : hmIdiomas.entrySet()) {
		    System.out.println("Clave=" + pais.getKey() + ", Valor=" + pais.getValue());
		}
	
	}

}
