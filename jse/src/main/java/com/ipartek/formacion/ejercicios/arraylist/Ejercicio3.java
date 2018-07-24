package com.ipartek.formacion.ejercicios.arraylist;

import java.util.ArrayList;

/**
 * 
 * Rotar los elementos de un ArrayList.
 *
 */
public class Ejercicio3 {

	public static void main(String[] args) {

		ArrayList<Integer> numbers = new ArrayList<Integer>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);

		for (Integer num : numbers) {
			System.out.print(num + " ");
		}

		Integer num_tmp = 0;
		for (int i = 0; i < Math.floor(numbers.size() / 2); i++) {
			num_tmp = numbers.get(i);
			numbers.set(i, numbers.get((numbers.size() - 1) - i));
			numbers.set((numbers.size() - 1) - i, num_tmp);
		}

		System.out.println();
		for (Integer num : numbers) {
			System.out.print(num + " ");
		}

	}

}
