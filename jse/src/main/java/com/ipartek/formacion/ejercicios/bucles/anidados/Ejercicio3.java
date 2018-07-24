package com.ipartek.formacion.ejercicios.bucles.anidados;

import java.util.Scanner;

/**
 * 
 * Leer un número N y calcular la suma de los factoriales de los números desde 0
 * hasta N.
 * 
 * @author Curso
 *
 */
public class Ejercicio3 {

	public static void main(String[] args) {
		int n;
		double suma = 0;
		double factorial;
		Scanner sc = new Scanner(System.in);

		do {
			System.out.print("Introduce un número mayor que 0: ");
			n = sc.nextInt();
		} while (n < 0);

		for (int i = 0; i <= n; i++) {

			// calcula su factorial
			factorial = 1;
			for (int j = 1; j <= i; j++) {
				factorial = factorial * j;
			}
			// cogemos cada factorial y lo añadimos a la variable
			suma = suma + factorial;
		}

		System.out.printf("La suma de sus factoriales es %.0f %n", suma);
		sc.close();
	}

}
