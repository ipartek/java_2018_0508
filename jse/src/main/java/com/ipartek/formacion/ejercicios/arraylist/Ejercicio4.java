package com.ipartek.formacion.ejercicios.arraylist;

import java.util.ArrayList;

/**
 * 
 * Cadena más larga contenida en un ArrayList de Strings.
 *
 */
public class Ejercicio4 {

	public static void main(String[] args) {

		ArrayList<String> cadenas = new ArrayList<String>();
		cadenas.add("uyedbf");
		cadenas.add("uyedfgzddbf");
		cadenas.add("Soy el mas largo");
		cadenas.add("uyzcvedbf");
		cadenas.add("sdff");

		String max = "";
		for (String cadena : cadenas) {
			if (max.length() < cadena.length()) {
				max = cadena;
			}
		}

		System.out.println("La cadena más larga es: " + max);

	}

}
