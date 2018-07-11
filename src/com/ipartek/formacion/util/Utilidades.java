package com.ipartek.formacion.util;

public class Utilidades {

	static int[] array = { 0, 3, 1, 8, 7, 2, 5, 4, 6, 9 };
	static int[] res;

	public static void main(String[] args) {

		res = bubbleSort(array, true);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}
		System.out.println();
		
		res = bubbleSort(array, false);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}
		System.out.println();

	}
	/**
	 * Función que ordena un array de enteros según el algoritmo bubbleSort.
	 * @param nums
	 * @param asc
	 * @return int[] con el array nums[] ordenado ascendente o descendentemente
	 */
	public static int[] bubbleSort(int[] nums, boolean asc) {
		int[] res = nums;
		int aux;
		for (int i = 0; i < res.length; i++) {
			for (int j = i; j < res.length; j++) {
				if (asc) {
					if (res[i] > res[j]) {
						aux = res[i];
						res[i] = res[j];
						res[j] = aux;
					}
				} else {
					if (res[i] < res[j]) {
						aux = res[i];
						res[i] = res[j];
						res[j] = aux;
					}
				}
			}
		}
		return res;
	}

}
