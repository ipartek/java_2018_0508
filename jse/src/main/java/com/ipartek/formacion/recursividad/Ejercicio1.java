package com.ipartek.formacion.recursividad;

import java.util.Scanner;

/**
 * Programa Java que calcule el cociente de dos números enteros de forma
 * recursiva.
 * 
 * @see package-info.java
 * @author Luis
 *
 */
public class Ejercicio1 {

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

		System.out.printf("%d/%d = %d %n", dividendo, divisor, cociente(dividendo, divisor));
		scConsola.close();

	} // FIN main();

	private static int cociente(int num, int div) {

		if (num < div) { // No podemos seguir sumando
			return 0;
		} else {
			return (1 + cociente(num - div, div));
		}
	} // FIN cociente();

} // FIN Ejercicio1
