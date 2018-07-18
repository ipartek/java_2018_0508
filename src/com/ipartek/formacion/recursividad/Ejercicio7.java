package com.ipartek.formacion.recursividad;

import java.util.Scanner;

/**
 * Programa que calcula el resto de la divisi�n de dos n�meros enteros de forma
 * recursiva.
 * 
 * @see package-info.java
 * @author Luis
 *
 */
public class Ejercicio7 {

	static Scanner scConsola = new Scanner(System.in);

	public static void main(String[] args) {

		int dividendo;
		int divisor;

		System.out.print("Dividendo: ");
		dividendo = scConsola.nextInt();

		do {

			System.out.print("Divisor (>0): ");
			divisor = scConsola.nextInt();

		} while (divisor <= 0);

		System.out.printf("Resto de %d/%d = %d %n", dividendo, divisor, resto(dividendo, divisor));
		scConsola.close();

	}

	private static int resto(int num, int div) {

		if (num < div) { // Caso base
			return num;
		} else {
			return resto(num - div, div);
		}
	} 

} 
