package com.ipartek.formacion.ejercicios.array;

/**
 * 
 * Llenar un array con números aleatorios.
 *
 */
public class Ejercicio9 {

	public static void main(String[] args) {

		int[] nums = new int[10];

		for (int i = 0; i < nums.length; i++) {
			nums[i] = (int) (Math.random() * 100);
		}

		for (int num : nums) {
			System.out.println(num);
		}
		
	}

}
