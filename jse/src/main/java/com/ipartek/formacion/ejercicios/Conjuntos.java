package com.ipartek.formacion.ejercicios;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

public class Conjuntos {

	public static void main(String[] args) {
		
		Set<Integer> setOfIntegers = new HashSet<Integer>();
		setOfIntegers.add(Integer.valueOf(10));
		setOfIntegers.add(Integer.valueOf(11));
		setOfIntegers.add(Integer.valueOf(10));
		for (Integer i : setOfIntegers) {
		  System.out.println("Integer value is: " + i);
		}
		
		System.out.println();
		
		HashMap<String, String> hmPaises = new HashMap<String, String>();
		hmPaises.put("Es_es", "Español de España");
		hmPaises.put("Es_eu", "Euskera de España");
		hmPaises.put("Es_ct", "Catalan de España");
		hmPaises.put("En_en", "Ingles de Inglaterra");
		
		for (Entry<String, String> pais : hmPaises.entrySet()) {
			System.out.println(pais.getKey() + " => " + pais.getValue());
		}
		
	}

}
