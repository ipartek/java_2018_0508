package com.ipartek.formacion.basicos.estructura.secuencial;

import java.util.Scanner;

/**
 * Programa que lea un número entero N de 5 cifras y muestre sus cifras desde el
 * principio como en el ejemplo.
 */
public class Ejercicio11 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int N;
		System.out.print("Introduzca valor de N de 5 cifras: ");
		N = sc.nextInt(); // Supondremos que el número introducido tiene 5 cifras
		System.out.println(N / 10000);
		System.out.println(N / 1000);
		System.out.println(N / 100);
		System.out.println(N / 10);
		System.out.println(N);
	}
}
