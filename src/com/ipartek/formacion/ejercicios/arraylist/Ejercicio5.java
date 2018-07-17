package com.ipartek.formacion.ejercicios.arraylist;

import java.util.ArrayList;

/**
 * 
 * Utilizar un ArrayList de Objetos.
 *
 */
public class Ejercicio5 {

	public static void main(String[] args) {

		ArrayList<Object> cadenas = new ArrayList<Object>();
		cadenas.add("uyedbf");
		cadenas.add("uyedfgzddbf");
		cadenas.add("Soy el mas largo");
		cadenas.add("uyzcvedbf");
		cadenas.add("sdff");

		for (Object cadena : cadenas) {
			System.out.println(cadena);
		}

	}

}
