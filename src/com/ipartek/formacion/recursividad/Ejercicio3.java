package com.ipartek.formacion.recursividad;

import java.util.Scanner;

/**
 * Programa Java recursivo para calcular 2 elevado a n de forma recursiva,
 * siendo n un número entero mayor o igual que 0.
 * 
 * @see package-info.java
 * @author Luis
 *
 */
public class Ejercicio3 {

	static Scanner scConsola = new Scanner(System.in);

	public static void main(String[] args) {

		int num;

		do {
			
			System.out.print("Introduce un número: ");
			num = scConsola.nextInt();
			
		} while (num <= 0);

		System.out.print("Potencia de 2^" + num + ": ");

		System.out.print(potencia2N(num));

		scConsola.close();

	} // FIN main();

	private static int potencia2N(int num) {

		if (num == 0) { // Caso base

			return 1;

		} else {

			return 2 * potencia2N(num - 1);
		}
	} // FIN potencia2N();

} // FIN Ejercicio3
