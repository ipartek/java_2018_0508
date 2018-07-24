package com.ipartek.formacion.recursividad;

import java.util.Scanner;

/**
 * Programa java que calcula el n�mero de cifras de un n�mero entero de forma
 * recursiva.
 * 
 * @see package-info.java
 * @author Luis
 *
 */
public class Ejercicio4 {

	static Scanner scConsola = new Scanner(System.in);

	public static void main(String[] args) {

		int num;

		do {

			System.out.print("Introduce un n�mero positivo: ");
			num = scConsola.nextInt();

		} while (num <= 0);

		System.out.print("N�mero de cifras de " + num + ": ");

		System.out.print(numDigitos(num));

		scConsola.close();

	} 

	private static int numDigitos(int num) {

		if (num < 10) { // Caso base

			return 1;

		} else {

			return 1 + numDigitos(num / 10);
		}
	} 

} 
