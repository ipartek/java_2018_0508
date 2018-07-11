package com.ipartek.formacion.basicos.bucles_anidados;

/**
 * Programa que muestre el alfabeto por pantalla y vaya restando un carácter por
 * línea.
 * 
 * @author Curso
 *
 */
public class Ejercicio4 {

	static final String ALFABETO = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static void main(String[] args) {

		for (int i = 0; i < ALFABETO.length(); i++) {

			for (int j = i; j < ALFABETO.length(); j++) {
				System.out.print(ALFABETO.charAt((ALFABETO.length() - 1) - j));
			}

			System.out.print("\n");
		}
	}

}
