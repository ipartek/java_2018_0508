package com.ipartek.formacion.ejercicios.array;

import java.util.Scanner;

/**
 * 1. Calcular la media de una serie de números que se leen por teclado.
 * 
 * @author apero
 *
 */
public class Ejercicio1 {

	public static void main(String[] args) {

		int n;
		int[] numeros = new int[10];
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < numeros.length; i++) {
			System.out.println("Introduce el numerito:");
			n = sc.nextInt();
			numeros[i] = n;
		}

		int suma = 0;

		for (int i = 0; i < numeros.length; i++) {
			suma += numeros[i];
		}

		System.out.println("La suma de todos los numeros es " + suma);

		sc.close();

	}

}
