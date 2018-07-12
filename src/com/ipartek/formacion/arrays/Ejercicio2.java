package com.ipartek.formacion.arrays;

import java.util.Scanner;

/**
 * Leer 10 números enteros por teclado y guardarlos en un array. Calcula y
 * muestra la media de los números que estén en las posiciones pares del array.
 * 
 * @author Curso
 *
 */
public class Ejercicio2 {

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

		System.out.println("La media es: " + mediaPosicionesPares());
	}

	private static int mediaPosicionesPares() {

		int suma = 0;

		for (int i = 0; i < N; i++) {
			if (i % 2 == 0) {
				suma += array[i];
			}
		}
		return suma / N;
	}

}
