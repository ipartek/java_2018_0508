package com.ipartek.formacion.util;

public class LibreriasJAR {

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
