package com.ipartek.formacion.arrays;

import java.util.Scanner;

/**
 * Programa Java que guarda en un array 10 números enteros que se leen por
 * teclado. A continuación se recorre el array y calcula cuántos números son
 * positivos, cuántos negativos y cuántos ceros.
 * 
 * @author Curso
 *
 */
public class Ejercicio5 {

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

		contar();
	}

	private static void contar() {

		int contPos = 0;
		int contNeg = 0;
		int contCero = 0;

		for (int i = 0; i < N; i++) {
			if (array[i] > 0) {
				contPos++;
			} else if (array[i] == 0) {
				contCero++;
			} else {
				contNeg++;
			}
		}

		System.out.println("Número de positivos: " + contPos);
		System.out.println("Número de negativos: " + contNeg);
		System.out.println("Número de ceros: " + contCero);

	}
}
