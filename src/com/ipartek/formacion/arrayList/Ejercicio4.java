package com.ipartek.formacion.arrayList;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Programa Java para calcular el String de mayor longitud de todos los
 * contenidos en un ArrayList de String
 * 
 * @author Curso
 *
 */
public class Ejercicio4 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		ArrayList<String> arrayL = new ArrayList<String>();

		cargarArray(arrayL);

		String mayor = cadenaMasLarga(arrayL);

		System.out.println("La cadena más larga es: ");
		System.out.println(mayor);
	}

	private static void cargarArray(ArrayList<String> cadenas) {

		String s;
		boolean esFin = false;

		do {
			System.out.println("Introduce una cadena de caracteres (FIN para salir): ");
			s = sc.nextLine();

			if ("Fin".equalsIgnoreCase(s)) {
				esFin = true;
			} else {
				cadenas.add(s);
			}
		} while (!esFin);
	}

	public static String cadenaMasLarga(ArrayList<String> cadenas) {

		String result = cadenas.get(0);

		for (String s : cadenas) {
			if (s.length() > result.length()) {
				result = s;
			}
		}
		return result;
	}

}
