package com.ipartek.formacion.ejercicios;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Se demuestra que los conjuntos no puede contener elementos repetidos.
 * 
 * @author andreaPerez
 *
 */
public class Conjuntos {

	public static void main(String[] args) {

		Set<Integer> setOfIntegers = new HashSet<Integer>();
		setOfIntegers.add(Integer.valueOf(10));
		setOfIntegers.add(Integer.valueOf(11));
		setOfIntegers.add(Integer.valueOf(10));

		for (Integer i : setOfIntegers) {
			System.out.println("Integer value is: " + i);
		}

		// Ejemplo de hashMap
		HashMap<String, String> hmPaises = new HashMap<String, String>();

		hmPaises.put("En_en", "Ingles de Inglaterra");
		hmPaises.put("Es_es", "Espa�ol de Espa�a");
		hmPaises.put("Es_eu", "Euskera de Espa�a");
		hmPaises.put("Es_ct", "Catalan de Espa�a");

//		for (int i = 0; i < hmPaises.size(); i++) {
//			System.out.println(hmPaises.values());
//		}

		for (Entry<String, String> pais : hmPaises.entrySet()) {
			System.out.println(pais.getKey() + " => " + pais.getValue());
		}		
	}
}
