package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Programa Java que lea un número entero de 3 cifras y muestre por separado las
 * cifras del número.
 */

public class Ejercicio10 {

	public static void main(String[] args) {
		boolean numSize = false;
		int num = 0;
		final int NUM_OF_DIGITS = 3;
		Scanner teclado = new Scanner(System.in);

		while (!numSize) {
			System.out.print("Numero de tres cifras: ");
			num = teclado.nextInt();
			numSize = (Integer.toString(num).length() == NUM_OF_DIGITS) ? true : false;
		}
		System.out.print("Sus cifras son : ");
		int resto = 0;
		ArrayList<Integer> values = new ArrayList<>();
		while (num > 0) {
			resto = num % 10;
			num /= 10;
			values.add(resto);
		}
		for (int j = values.size() - 1; j >= 0; j--) {
			System.out.print(values.get(j) + " ");
		}
		teclado.close();

	}

}
