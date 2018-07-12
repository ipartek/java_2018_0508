package com.ipartek.formacion.ejercicios.bucles.anidados;

import java.util.Scanner;

/**
 * 3. Leer un número N y calcular la suma de los factoriales de los números
 * desde 0 hasta N.
 * 
 * @author Curso
 *
 */
public class Ejercicio3 {

	private static Scanner scan;

	public static void main(String[] args) {

		int num;
		double factorial, suma = 0;
		scan = new Scanner(System.in);

		do {
			System.out.print("Introduce un numero > 0: ");
			num = scan.nextInt();
		} while (num < 0);

		for (int i = 0; i <= num; i++) {

			factorial = 1;
			for (int j = 1; j <= i; j++) {
				factorial = factorial * j;
			}

			System.out.printf("%n%2d! = %.0f %n", i, factorial);

			suma = suma + factorial;
		}

		System.out.printf("Suma de los factoriales desde 0 hasta %d: %.0f%n", num, suma);
	}

}
