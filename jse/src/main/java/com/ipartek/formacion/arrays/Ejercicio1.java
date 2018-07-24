package com.ipartek.formacion.arrays;

import java.util.Scanner;

/**
 * Calcular la media de 10 números que se leen por teclado.
 * 
 * @author Curso
 *
 */
public class Ejercicio1 {

	static final int N = 10;

	static Scanner sc = new Scanner(System.in);
	static int[] array = new int[N];

	public static void main(String[] args) {

		int i = 0;

		do {

			System.out.println("Introduce un número: ");
			array[i] = sc.nextInt();
			i++;

		} while (i < N);

		System.out.println("La media es: " + media());
	}

	private static int media() {

		int suma = 0;

		for (int i = 0; i < N; i++) {
			suma += array[i];
		}

		return suma / N;
	}
}
