package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Programa que lea un número entero N de 5 cifras y muestre sus cifras igual
 * que en el ejemplo.
 */

public class Ejercicio11 {

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
		teclado.close();
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

	}

}
