package com.ipartek.formacion.ejercicios;

import java.util.logging.Logger;

public class BubbleSort {

	public static void main(String[] args) {
		Logger log = Logger.getLogger(BubbleSort.class.getName());
		/*
		 * int[] numeros = { 0, 3, 1, 8, 7, 2, 5, 4, 6, 9 }; int aux; for (int a = 0; a
		 * < numeros.length; a++) { for (int i = 0; i < numeros.length - 1; i++) { if
		 * (numeros[i] > numeros[i + 1]) { aux = numeros[i + 1]; numeros[i + 1] =
		 * numeros[i]; numeros[i] = aux; }
		 * 
		 * } } for (int i = 0; i < numeros.length; i++) {
		 * log.info("Posicion del array [" + i + "] " + numeros[i]); }
		 */

		int[] numeros = { 0, 3, 1, 8, 7, 2, 5, 4, 6, 9 };
		int aux;
		for (int a = 0; a < numeros.length; a++) {
			for (int i = 0; i < numeros.length - 1; i++) {
				if (numeros[i] < numeros[i + 1]) {
					aux = numeros[i + 1];
					numeros[i + 1] = numeros[i];
					numeros[i] = aux;
				}

			}
		}
		for (int i = 0; i < numeros.length; i++) {
			log.info("Posicion del array [" + i + "] " + numeros[i]);
		}

	}

}
