package com.ipartek.formacion.recursividad;

import java.util.Scanner;

/**
 * Programa recursivo que calcula la suma desde 1 hasta un n�mero entero N le�do
 * por teclado.
 * 
 * @see package-info.java
 * @author Luis
 *
 */
public class Ejercicio5 {

	static Scanner scConsola = new Scanner(System.in);

	public static void main(String[] args) {

		int num;

		do {

			System.out.print("Introduce un n�mero positivo: ");
			num = scConsola.nextInt();

		} while (num <= 0);

		System.out.print("Suma desde 1 hasta " + num + ": ");

		System.out.print(sumaDesde1HastaN(num));

		scConsola.close();

	} 

	private static int sumaDesde1HastaN(int num) {

		if (num == 1) { // Caso base

			return 1;

		} else {

			return num + sumaDesde1HastaN(num - 1);
		}
	} 
} 
