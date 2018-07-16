package com.ipartek.formacion.ejercicios.arrays;

import java.util.Scanner;

/**
 * 2. Programa Java que lea 10 números enteros por teclado y los guarde en un
 * array. Calcula y muestra la media de los números que estén en las posiciones
 * pares del array.
 * 
 * Considera la primera posición del array (posición 0) como par.
 * 
 * @author Ainara
 *
 */
public class Ejercicio2 {

	public static void main(String[] args) {
		int[] numeros = new int[10];
		int par = 0;
		int i;
		float resultadopar = 0;

		Scanner sc = new Scanner(System.in);

		for (i = 0; i < numeros.length; i++) {
			System.out.println("Introduce un numero: ");
			numeros[i] = sc.nextInt();
		}

		for (i = 0; i < 10; i++) {
			if (numeros[i] % 2 == 0) {
				par += numeros[i];
				resultadopar++;
			}
		}

		if (par != 0) {
			System.out.println("Media de los valores pares: " + par / resultadopar);
		} else {
			System.out.println("No ha introducido números pares");
		}

		sc.close();

	}

}
