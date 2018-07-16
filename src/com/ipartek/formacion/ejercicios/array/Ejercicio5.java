package com.ipartek.formacion.ejercicios.array;

import java.util.Scanner;

/**
 * Contar el número de elementos positivos, negativos y ceros en un array de 10
 * enteros.
 *
 */
public class Ejercicio5 {

	public static void main(String[] args) {

		int[] nums = new int[10];
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < nums.length; i++) {
			System.out.print("Introduce un numero: ");
			nums[i] = sc.nextInt();
		}
		int negatives = 0;
		int positives = 0;
		int zeros = 0;

		for (int num : nums) {
			if (num > 0) {
				positives++;
			} else if (num < 0) {
				negatives++;
			} else {
				zeros++;
			}
		}
		System.out.println("Positivos: "+positives);
		System.out.println("Negativos: "+negatives);
		System.out.println("Ceros: "+zeros);
		sc.close();

	}

}
