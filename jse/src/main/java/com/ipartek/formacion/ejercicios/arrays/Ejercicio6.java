package com.ipartek.formacion.ejercicios.arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 
 * @author Curso
 *6. Leer 10 enteros y mostrar la media de los valores negativos y la de los positivos.
 */
public class Ejercicio6 {
	public static void main(String[] args) throws Exception {
		int[] miArray = new int[10];
		int suma = 0;
		int mediaP=0;
		int mediaN =0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Introduce 10 numeros que sean positivos o negativos");
		for (int x = 0; x < 10; x++) {
			miArray[x] = Integer.parseInt(br.readLine());
			System.out.println("Introduzca otra numero:");
			
		}
		for (int x = 0; x < 10; x++) {
			if (miArray[x] > 0) {
				mediaP += miArray[x];
			} else {
				if (miArray[x] < 0) {
					mediaN += miArray[x];
				} 
			}
		}
		mediaP = mediaP / 10;
		mediaN = mediaN / 10;
		System.out.println("La media de los numeros positivos es: "+mediaP);
		System.out.println("La media de los numeros positivos es: "+mediaN);
	}
}
