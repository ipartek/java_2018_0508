package com.ipartek.formacion.ejercicios.array;

import java.util.Scanner;

/**
 * Calcular la media de una serie de números que se leen por teclado.
 */
public class Ejercicio1 {

	public static void main(String[] args) {

		int sum = 0;
		int cont = 0;
		boolean fin = false;
		Scanner sc = new Scanner(System.in);

		do {
			System.out.print("Introduce un numero: ");
			if (sc.hasNextInt()) {
				sum += sc.nextInt();
				cont++;

			} else {
				fin = true;
			}

		} while (!fin);
		
		System.out.print("La media es " + (float) (sum / cont));
		sc.close();
	}

}
