package com.ipartek.formacion.ejercicios;

public class Utilities {

	public Utilities() {
	}

	/***
	 * 
	 * @param values int[] array de numeros enteros
	 * @param asc boolean determina si el orden es ascendente (true) o descendente(false)
	 * @return int[] el array de numeros ordenados
	 */
	public static int[] bubbleSort(int[] values, boolean asc) {

		for (int i = 0; i < values.length; i++) {
			for (int j = i; j < values.length; j++) {
				if (asc) {
					if (values[i] > values[j]) {
						int value_tmp = values[j];
						values[j] = values[i];
						values[i] = value_tmp;
					}
				} else {
					if (values[i] < values[j]) {
						int value_tmp = values[j];
						values[j] = values[i];
						values[i] = value_tmp;
					}
				}
			}
		}
		return values;
	}
	
	public static int sumDivisors(int num) {
		int sum = 0;
		for (int i = 1; i < num; i++) {
			if (num % i == 0) {
				sum += i;
			}
		}
		return sum;
	}
}
