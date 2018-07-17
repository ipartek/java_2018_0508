package com.ipartek.formacion.ejercicios.cadenas;

import java.util.Scanner;

/**
 * Contar el número de palabras de una frase.
 *
 */
public class Ejercicio1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce una frase: ");
		String str = sc.nextLine();
		System.out.println("Numero de palabras: " + str.trim().split(" ").length);
		sc.close();

	}

}
