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

		HashMap<String, String> hmPaises = new HashMap<String, String>();
		hmPaises.put("es_EN", "Ingles de Inglaterra");
		hmPaises.put("es_ES", "Ingles de España");
		hmPaises.put("es_EU", "Euskera de España");
		hmPaises.put("es_CT", "Catalan de España");

		for (Entry<String, String> pais : hmPaises.entrySet()) {
			System.out.println(pais.getKey() + " => " + pais.getValue());
		}

		System.out.println();
		hmPaises.forEach((k, v) -> System.out.println(k + " => " + v));

	}

}
