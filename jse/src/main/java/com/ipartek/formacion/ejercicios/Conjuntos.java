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
		
		hmPaises.put("EN_en","Inglaterra");
		hmPaises.put("ES_es","España");
		hmPaises.put("ES_eu","Euskera de españa");
		hmPaises.put("ES_ct","Catalan de españa");
		
		for (Entry<String, String> pais :hmPaises.entrySet()) {
			System.out.println(pais.getKey() + "=>"+pais.getValue());
		}
		
		System.out.println(hmPaises.values());
	}

}
