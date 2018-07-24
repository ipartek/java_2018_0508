package com.ipartek.formacion.ejercicios.array;

import java.util.Scanner;

/**
 * 
 * Leer N alturas y calcular la altura media. Calcular cuántas hay superiores a
 * la media y cuántas inferiores.
 *
 */

public class Ejercicio7 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Numero de alturas a introducir: ");
		int size = sc.nextInt();

		int[] nums = new int[size];
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			System.out.print("Introduce una altura: ");
			nums[i] = sc.nextInt();
			sum += nums[i];

		}

		System.out.println("Las notas que han quedado por encima de la media son: ");
		float average = (float) (sum / nums.length);
		for (int num : nums) {
			if (num > average) {
				System.out.println(num);
			}
		}
		sc.close();
	}

}
