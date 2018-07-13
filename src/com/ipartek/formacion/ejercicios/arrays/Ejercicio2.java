package com.ipartek.formacion.ejercicios.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author Curso 2. Leer 10 números enteros por teclado y guardarlos en un<br>
 *         array. Calcula y muestra la media de los números que estén en las<br>
 *         posiciones pares del array.<br>
 *
 */
public class Ejercicio2 {
	public static void main(String[] args) throws Exception {
		int i;
		int suma = 0;
		double media = 0;
		int[] numeros = new int[10];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Lectura de los elementos del array: ");
		for (i = 0; i < 10; i++) {
			System.out.print("numeros[" + i + "]= ");
			numeros[i] = Integer.parseInt(br.readLine());
		}
		for (int x = 0; x < numeros.length; x++) {
			if (x % 2 == 0) {
				if (numeros[x] > 0) {
					suma = suma + numeros[x];
				}
			}

			media = suma / numeros.length;
		}
		System.out.println("La media de los numeros introducidos es: " + media);
	}
}
