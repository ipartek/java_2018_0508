package com.ipartek.formacion.ejercicios.bucles.anidados;

import java.util.Scanner;

/**
 * Leer un número N y calcular el factorial de los números desde 0 hasta N.
 * 
 * @author andreaperez
 *
 */
public class Ejercicio2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = 0;
		int factorial;

		System.out.println("Escribe un numero: ");
		n = sc.nextInt();

		for (int i = 0; i <= n; i++) {
			factorial = 1;

			for (int j = 1; j <= i; j++) {
				factorial *= j;
			}

			System.out.println(i + "! = " + factorial);

		}

		sc.close();
	}

}
