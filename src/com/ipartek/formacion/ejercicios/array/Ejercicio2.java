package com.ipartek.formacion.ejercicios.array;

import java.util.Scanner;

/**
 * Programa Java que lea 10 números enteros por teclado y los guarde en un array.
 * Calcula y muestra la media de los números que estén en las posiciones pares del array.
 * @author Curso
 *
 */
public class Ejercicio2 {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);

		int[] numeros = new int[10];
		int suma1 = 0;
		int contPar = 0;
		
		for (int i = 0; i < numeros.length; i++) {
			System.out.println("Introduce un numero entero: ");
			numeros[i] = teclado.nextInt();
			
			if (numeros[i] % 2 == 0) {
				suma1 = suma1 + numeros[i];
				contPar++;
			}
		}
		
		System.out.println();
		System.out.println("Numeros introducidos:");
		for (int i = 0; i < numeros.length; i++) {
			System.out.print(numeros[i] + " ");
		}
		
		System.out.println();
		System.out.println();
		
		System.out.println("La media de los numeros introducidos en posiciones pares es: " + (suma1 / contPar));
		
	}
}
