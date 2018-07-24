package com.ipartek.formacion.ejercicios.arrays;

import java.util.Scanner;

/**
 * 5. Programa Java que guarda en un array 10 números enteros que se leen por<br>
 * teclado. A continuación se recorre el array y calcula cuántos números son<br>
 * positivos, cuántos negativos y cuántos ceros.<br>
 * 
 * @author Ainara
 *
 */
public class Ejercicio5 {
	public static void main(String[] args) {
		int i;
		int[] num = new int[10];
		int positivos = 0;
		int negativos = 0;
		int cero = 0;

		Scanner sc = new Scanner(System.in);

		System.out.println("Introducción de números en array: \n");
		for (i = 0; i < num.length; i++) {
			System.out.print("Números[" + i + "]= ");
			num[i] = sc.nextInt();
		}

		for (i = 0; i < num.length; i++) {
			if (num[i] > 0) {
				positivos++;
			} else if (num[i] < 0) {
				negativos++;
			} else {
				cero++;
			}
		}

		System.out.println("Positivos: " + positivos);
		System.out.println("Negativos: " + negativos);
		System.out.println("Ceros: " + cero);

		sc.close();

	}
}
