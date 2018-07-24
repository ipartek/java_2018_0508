package com.ipartek.formacion.ejercicios.arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 
 * @author Curso 1. Calcular la media de una serie de números que se leen por
 *         teclado.
 *
 */
public class Ejercicio1 {
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
			if (numeros[x] > 0) {
				suma = suma + numeros[x];
			}
			media = suma / numeros.length;
		}
		System.out.println("La media de los numeros introducidos es: " + media);
	}
}
