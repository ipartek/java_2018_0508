package com.ipartek.formacion.ejercicios.array;

import java.util.Scanner;

/**
 * 
 * Leer 10 números enteros por teclado y guardarlos en un array. Calcula y
 * muestra la media de los números que estén en las posiciones pares del array.
 * 
 */
public class Ejercicio2 {
	
	public static void main(String[] args) {

		int sum = 0;
		int[]nums=new int[10];
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < nums.length; i++) {
			System.out.print("Introduce un numero: ");
			nums[i] = sc.nextInt();
			sum+=nums[i];
			
		}

		System.out.print("La media es " + (float) (sum / nums.length));
		sc.close();
	}
}
