package com.ipartek.formacion.ejercicios;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Conjuntos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Integer> setOfIntegers = new HashSet<Integer>();
		setOfIntegers.add(Integer.valueOf(10));
		setOfIntegers.add(Integer.valueOf(11));
		setOfIntegers.add(Integer.valueOf(10));
		for (Integer i : setOfIntegers) {
		  System.out.println("Integer value is: " + i);
		}
		
		
		HashMap<String, String> hmPaises = new HashMap<String, String>();
		
		hmPaises.put("En-en", "Inglés de Inglaterra");
		hmPaises.put("Es-es", "Español de España");
		hmPaises.put("Es-uy", "Español de Uruguay");
		hmPaises.put("Es-eu", "Euskera");
		hmPaises.put("Es-ct", "Catalan");
		hmPaises.put("ct", "Catalan");
		
		hmPaises.forEach((k,v) -> System.out.println("Idioma: " + k + ": valor: " + v));
		
	}

}
