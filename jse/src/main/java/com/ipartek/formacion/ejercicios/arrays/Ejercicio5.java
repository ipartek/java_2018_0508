package com.ipartek.formacion.ejercicios.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author Curso 5. Contar el número de elementos positivos, negativos y
 *         ceros<br>
 *         en un array de 10 enteros.
 */
public class Ejercicio5 {
	public static void main(String[] args) throws Exception {
		int contadorP = 0;
		int contadorN = 0;
		int contadorC = 0;
		int[] miArray = new int[10];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Introduce 10 numeros que sean positivos, negativos o ceros");
		for (int x = 0; x < 10; x++) {
			miArray[x] = Integer.parseInt(br.readLine());
			System.out.println("Introduzca otra numero:");
			
		}
		for (int x = 0; x < 10; x++) {
			if (miArray[x] > 0) {
				contadorP += 1;
			} else {
				if (miArray[x] < 0) {
					contadorN += 1;
				} else {
					contadorC += 1;
				}
			}

		}
		System.out.println("Los resultados son : nº positivos = "+contadorP+ " nº negativos "+ contadorN+" ceros "+contadorC);

	}
}
