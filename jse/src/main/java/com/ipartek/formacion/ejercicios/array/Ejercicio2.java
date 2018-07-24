package com.ipartek.formacion.ejercicios.array;

import java.util.Scanner;

/**
 * 2. Leer 10 números enteros por teclado y guardarlos en un array. Calcula y
 * muestra la media de los números que estén en las posiciones pares del array.
 * 
 * @author apero
 *
 */
public class Ejercicio2 {

	public static void main(String[] args) {

		int n;
		int[] numeros = new int[10];
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < numeros.length; i++) {
			System.out.println("Introduce el numerito:");
			n = sc.nextInt();
			numeros[i] = n;
		}

		int sumaPares = 0;

		for (int i = 0; i < numeros.length; i++) {
			if (i % 2 == 0) {
				sumaPares += numeros[i];
			}
		}

		System.out.println("La suma de todos los numeros es " + sumaPares);

		sc.close();

	}

}
