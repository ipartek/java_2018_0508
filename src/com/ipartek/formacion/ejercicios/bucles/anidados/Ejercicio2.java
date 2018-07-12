package com.ipartek.formacion.ejercicios.bucles.anidados;

/*
 * 2. Leer un número N y calcular el factorial de los números desde 0 hasta N.
 */
import java.util.Scanner;

public class Ejercicio2 {

	private static Scanner scan;

	public static void main(String[] args) {

		int num;
		double factorial;
		scan = new Scanner(System.in);

		do {
			System.out.print("Introduce un número > 0: ");
			num = scan.nextInt();
		} while (num < 0);

		for (int i = 0; i <= num; i++) {

			factorial = 1;
			for (int j = 1; j <= i; j++) {
				factorial = factorial * j;
			}

			System.out.printf("%2d! = %.0f %n", i, factorial);

		}
	}
}
