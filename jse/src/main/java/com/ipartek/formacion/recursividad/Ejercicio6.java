package com.ipartek.formacion.recursividad;

import java.util.Scanner;

/**
 * Programa Java que suma dos n�meros enteros de forma recursiva.
 * 
 * @see package-info.java
 * @author Luis
 *
 */
public class Ejercicio6 {

	static Scanner scConsola = new Scanner(System.in);

	public static void main(String[] args) {

		int num1;
		int num2;

		System.out.print("N�mero 1: ");
		num1 = scConsola.nextInt();

		System.out.print("N�mero 2: ");
		num2 = scConsola.nextInt();

		System.out.printf("%d+%d = %d %n", num1, num2, suma(num1, num2));
		scConsola.close();

	}

	private static int suma(int n1, int n2) {

		if (n1 == 0 || n2 == 0) { // No podemos seguir sumando

			return (n1 == 0 ? n2 : n1);
		} else {
			return (1 + suma(n1 - 1, n2));
		}
	}

} 
