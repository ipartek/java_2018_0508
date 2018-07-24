package com.ipartek.formacion.arrays;

import java.util.Scanner;

/**
 * Leer N alturas y calcular la altura media. Calcular cuántas hay superiores a
 * la media y cuántas inferiores.
 * 
 * @author Curso
 *
 */
public class Ejercicio7 {

	static Scanner sc = new Scanner(System.in);
	static double[] alturas;
	static int n = 0;
	static double media = 0f;

	public static void main(String[] args) {

		int i = 0;

		System.out.println("Introduce un número natural de alturas: ");
		n = sc.nextInt();
		alturas = new double[n];

		do {

			System.out.println("Introduce la altura: ");
			alturas[i] = sc.nextDouble();
			i++;

		} while (i < n);

		media = media();
		System.out.println("La media es: " + media);

		superiorMedia();
		inferiorMedia();
	}

	private static double media() {

		double media = 0;

		for (int i = 0; i < n; i++) {
			media += alturas[i];
		}

		media /= n;
		return media;
	}

	private static void superiorMedia() {

		System.out.println("Alturas por encima de la media: ");
		System.out.println("------------------------------");
		for (int i = 0; i < alturas.length; i++) {
			if (alturas[i] > media) {
				System.out.println("Altura " + (i + 1) + ": " + alturas[i]);
			}

		}
	}

	private static void inferiorMedia() {

		System.out.println("Alturas por debajo de la media: ");
		System.out.println("------------------------------");
		for (int i = 0; i < alturas.length; i++) {
			if (alturas[i] < media) {
				System.out.println("Altura " + (i + 1) + ": " + alturas[i]);
			}

		}
	}
}
