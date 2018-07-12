package com.ipartek.formacion.arrays;

import java.util.Scanner;

/**
 * Programa Java que lea por teclado 10 números enteros y los guarde en un
 * array. A continuación calcula y muestra por separado la media de los valores
 * positivos y la de los valores negativos.
 * 
 * @author Curso
 *
 */
public class Ejercicio6 {

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

		media();
	}

	private static void media() {

		int sumaPos = 0;
		int contPos = 0;
		int sumaNeg = 0;
		int contNeg = 0;

		for (int i = 0; i < N; i++) {
			if (array[i] > 0) {
				sumaPos+= array[i];
				contPos++;
			} else {
				sumaNeg+= array[i];
				contNeg++;
			}
		}
		
		System.out.println("La media de los positivos: " + sumaPos/contPos);
		System.out.println("La media de los negativos: " + sumaNeg/contNeg);
	}
}
