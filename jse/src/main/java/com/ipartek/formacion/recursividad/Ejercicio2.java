package com.ipartek.formacion.recursividad;

import java.util.Scanner;

/**
 * Programa que lea un n�mero entero entero mayor o igual que cero en base
 * decimal y muestre su equivalente en binario de forma recursiva.
 * 
 * @see package-info.java
 * @author Luis
 *
 */
public class Ejercicio2 {

	static Scanner scConsola = new Scanner(System.in);

	public static void main(String[] args) {

		int num;

		System.out.print("Introduce un número: ");
		num = scConsola.nextInt();
		System.out.println("Decimal: " + num);

		System.out.print("Binario: ");
		decimalBinario(num);

		scConsola.close();

	} 

	private static void decimalBinario(int num) {

		if (num == 0 || num == 1) { // Caso base
			System.out.print(num);
		} else {

			decimalBinario(num / 2);
			System.out.print(num % 2);

			return;

		}
	} 

}
