package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
 * Programa Java que lea un número entero N de 5 cifras y muestre sus cifras
 * igual que en el ejemplo.
 */

public class Ejercicio12 {

	public static void main(String[] args) {
		boolean numSize = false;
		int num = 0;
		final int NUM_OF_DIGITS = 5;
		Scanner teclado = new Scanner(System.in);
		while (!numSize) {
			System.out.print("Numero de cinco cifras: ");
			num = teclado.nextInt();
			numSize = (Integer.toString(num).length() == NUM_OF_DIGITS) ? true : false;
		}
		System.out.print("Sus cifras son : ");
		int resto = 0;
		while (num > 0) {
			resto = num % 10;
			num /= 10;
			System.out.print(resto + " ");
		}
		teclado.close();


	}

}
