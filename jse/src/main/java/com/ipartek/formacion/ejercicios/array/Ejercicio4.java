package com.ipartek.formacion.ejercicios.array;

/**
 * 
 * Guardar en un array los 20 primeros números pares
 */
public class Ejercicio4 {

	public static void main(String[] args) {

		final int SIZE = 20;
		int[] nums = new int[20];
		int pos = 0;
		int i=0;

		while (pos < SIZE) {
			if(i%2==0) {
				nums[pos] = i;
				pos++;
			}
			i++;
		}
		
		for (int num : nums) {
			System.out.println(num);
		}

	}

}
