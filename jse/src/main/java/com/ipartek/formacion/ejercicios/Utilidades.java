package com.ipartek.formacion.ejercicios;

import java.util.logging.Logger;

public class Utilidades {

	/**
	 * 
	 * 
	 * @param numeros  array de enteros que se quiere ordenar
	 * @param ordenado orden que se quiere conseguir dentro del array numeros, true
	 *                 de menor a mayor y false de mayor a menor
	 * @return array de enteros ordenado de menor a mayor o viceversa.
	 */
	public static int[] bubbleSort(int numeros[], boolean ordenado) {

		if (ordenado) {
			Logger log = Logger.getLogger(Utilidades.class.getName());

			int aux;
			for (int a = 0; a < numeros.length; a++) {
				for (int i = 0; i < numeros.length - 1; i++) {
					if (numeros[i] > numeros[i + 1]) {
						aux = numeros[i + 1];
						numeros[i + 1] = numeros[i];
						numeros[i] = aux;
					}

				}
			}
			for (int i = 0; i < numeros.length; i++) {
				log.info("Posicion del array [" + i + "] " + numeros[i]);
			}
			return numeros;
		} else {
			Logger log = Logger.getLogger(BubbleSort.class.getName());

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
			return numeros;
		}

	}
}
