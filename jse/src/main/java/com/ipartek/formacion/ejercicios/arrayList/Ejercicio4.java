package com.ipartek.formacion.ejercicios.arrayList;

import java.util.ArrayList;
import java.util.List;

/**
 * 4. Cadena m�s larga contenida en un ArrayList de Strings.
 * 
 * @author Curso
 *
 */
public class Ejercicio4 {

	public static void main(String[] args) {

		List<String> palabras = new ArrayList<String>();

		palabras.add("Hola");
		palabras.add("Hola holita");
		palabras.add("Hola holita vecinito");

		String mayor = "";

		for (String pActual : palabras) {

			if (mayor.length() < pActual.length()) {
				mayor = pActual;
			}

		}

		System.out.println("La mayor palabra es: " + mayor);

	}

}
