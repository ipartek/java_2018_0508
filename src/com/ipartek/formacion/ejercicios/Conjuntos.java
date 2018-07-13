package com.ipartek.formacion.ejercicios;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

public class Conjuntos {

	public static void main(String[] args) {

		// HashSet no permite que se dupliquen datos
		Set<Integer> setOfIntegers = new HashSet<Integer>();
		setOfIntegers.add(Integer.valueOf(10));
		setOfIntegers.add(Integer.valueOf(11));
		setOfIntegers.add(Integer.valueOf(10));

		for (Integer i : setOfIntegers) {
			System.out.println("Integer value is: " + i);
		}

		//HashMap
		HashMap<String, String> hmPaises = new HashMap<String, String>();
		
		hmPaises.put("En_en", "Ingles de Inglaterra");
		hmPaises.put("Es_es", "Español de España");
		hmPaises.put("Es_eu", "Euskera de España");
		hmPaises.put("Es_ct","Catalan de España");
		hmPaises.put("ct   ","Catalan de España");
		for(Entry<String, String> pais: hmPaises.entrySet()) {
			System.out.println(pais.getKey()+" => "+pais.getValue());
		}
		
		System.out.println(hmPaises.values());
		
	}

}
