package com.ipartek.formacion.ejercicios.arrays;

import java.util.Scanner;

/**
 * Programa Java que lea 10 números enteros por teclado y los guarde en un
 * array. Calcula y muestra la media de los números que estén en las posiciones
 * pares del array.
 * 
 * Considera la primera posición del array (posición 0) como par.
 * 
 * @author andreaperez
 *
 */
public class Ejercicio2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[] miArray = new int[10];
		int nPar = 0;
		int sumaPar = 0;

		for (int i = 0; i < miArray.length; i++) {
			System.out.println("introduce numero:");
			miArray[i] = sc.nextInt();

		}

		for (int j = 0; j < miArray.length; j += 2) {
			nPar++;
			sumaPar += miArray[j];
		}

		System.out
				.println(nPar + " numeros en las posiciones pares; suman" + sumaPar + "La media es: " + sumaPar / nPar);

		sc.close();

	}

}
