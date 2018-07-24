package com.ipartek.formacion.util;

public class Utilidades {

	/**
	 * Ordenamos un array de enteros de menor a mayor mediante el metodo "bubble
	 * sort"
	 * 
	 * @param arrayDesordenado int[]
	 * @return array ordenado de menor a mayor
	 */
	
	public static int[] bubbleSort(int[] array) {
		int temp;
		for (int i = 0; i < array.length; i++) {
			for (int j = 1; j < (array.length - i); j++) {
				if (array[j - 1] > array[j]) {
					// swap elements
					temp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = temp;
				}

			}
		}
		return array;
	}

}
