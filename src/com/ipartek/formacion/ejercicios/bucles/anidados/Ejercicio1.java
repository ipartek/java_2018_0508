package com.ipartek.formacion.ejercicios.bucles.anidados;

import java.util.Scanner;

/**
 * Mostrar los números perfectos entre 1 y 1000.
 * 
 * @author andreaperez
 *
 */
public class Ejercicio1 {

	public static void main(String[] args) {

		int n = 1000;
		int suma;

		for (int i = 1; i <= n; i++) { // numeros

			suma = 0;

			for (int j = 1; j < i; j++) { // Divisores
				if (i % j == 0) {
					suma += j;
				}
			}

			if (suma == i) {
				System.out.println(i + " es perfecto");
			} else {
				System.out.println(i + " no es perfecto");
			}
		}
	}
}
