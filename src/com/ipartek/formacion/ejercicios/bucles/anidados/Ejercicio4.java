package com.ipartek.formacion.ejercicios.bucles.anidados;

/**
 * Programa que muestre en lineas separadas lo siguiente:
 * ZYWXVUTSRQPONMLKJIHGFEDCBA, YWXVUTSRQPONMLKJIHGFEDCBA,
 * WXVUTSRQPONMLKJIHGFEDCBA, ...., DCBA, CBA, BA, A.
 * 
 */
public class Ejercicio4 {

	public static void main(String[] args) {
		String alphabet = "ZYWXVUTSRQPONMLKJIHGFEDCBA";
		for (int i = 0; i < alphabet.length(); i++) {
			System.out.println(alphabet.substring(i, alphabet.length()));
		}

	}

}
