package com.ipartek.formacion.ejercicios.array;

import java.util.Scanner;

/**
 * Leer 10 enteros y mostrar la media de los valores negativos y la de los
 * positivos.
 *
 */

public class Ejercicio6 {
	
	public static void main(String[] args) {

		int[] nums = new int[10];
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < nums.length; i++) {
			System.out.print("Introduce un numero: ");
			nums[i] = sc.nextInt();
		}
		int negatives = 0;
		int sumNegatives = 0;
		int positives = 0;
		int sumPositives = 0;
		
		for (int num : nums) {
			if (num >= 0) {
				sumPositives+=num;
				positives++;
			} else if (num < 0) {
				sumNegatives+=num;
				negatives++;
			}
		}
		System.out.println("Media positivos: "+(float)(sumPositives/positives));
		System.out.println("Media negativos: "+(float)(sumNegatives/negatives));
		
		sc.close();

	}

}
