package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * 6. Comprobar si un número es perfecto.
 */
public class Ejercicio6 {

	private static Scanner scan;

	public static void main(String[] args) {

		int suma = 0, num;
		scan = new Scanner(System.in);

		System.out.println("Introduce un numero: ");
		num = scan.nextInt();

		for (int i = 1; i < num; i++) {
			if (num % i == 0) {
				suma = suma + i;
			}
		}
		if (suma == num) {
			System.out.println("Es perfecto");
		} else {
			System.out.println("No es perfecto");
		}
	}

}
