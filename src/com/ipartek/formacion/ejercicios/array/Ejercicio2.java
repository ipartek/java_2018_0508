package com.ipartek.formacion.ejercicios.array;

import java.util.Scanner;

/**
 * 
 * Leer 10 números enteros por teclado y guardarlos en un array. Calcula y<br>
 * muestra la media de los números que estén en las posiciones pares del
 * array.<br>
 * 
 * @author Asier Cornejo
 *
 */
public class Ejercicio2 {

	public static void main(String[] args) {
		int sumPares = 0;
		int tamArray = 10;
		int cont = 0;

		int[] numeros = new int[tamArray];

		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("Introduce un numero entero, positivo o negativo");
			numeros[cont] = sc.nextInt();
			cont++;

		} while (cont < numeros.length);

		sc.close();

		for (int i = 0; i < numeros.length; i++) {
			if (i % 2 == 0) {
				sumPares += numeros[i];

			}
		}
		System.out.println("La media de los numeros colocados en las posiciones pares es: " + sumPares / cont);
	}

}
