package com.ipartek.formacion.ejercicios.cadenas;

import java.util.Scanner;

/**
 * Eliminar la última palabra de una frase.
 *
 */
public class Ejercicio2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce una frase: ");
		String str = sc.nextLine();

		String[] words = str.trim().split(" ");
		str = "";

		for (int i = 0; i < words.length - 1; i++) {
			str += words[i] + " ";
		}

		System.out.println(str.trim());
		sc.close();

	}

}
