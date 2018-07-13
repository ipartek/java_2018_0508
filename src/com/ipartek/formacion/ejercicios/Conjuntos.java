package com.ipartek.formacion.ejercicios;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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
		
		HashMap<String, String> hmPaises = new HashMap<String, String>();
		
		hmPaises.put("En_en", "Ingles de Inglaterra");
		hmPaises.put("Es_es", "Español de España");
		hmPaises.put("Es_eu", "Euskera de Euskadi");
		hmPaises.put("Es_ct", "Catalan de Cataluña");
		hmPaises.put("Es_ct", "Catalan de Cataluña");
		
		for (Entry<String, String> pais : hmPaises.entrySet()) {
			System.out.println(pais.getKey()+ " => "+ pais.getValue());
		}
		
		
		
		

	}

}
