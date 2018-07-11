package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
 * 11. Programa que lea un número entero N de 5 cifras y muestre sus cifras<br>
 * desde el principio como en el ejemplo.
 * 
 * @author Curso
 *
 */
public class Ejercicio11 {

	private static Scanner scan;

	public static void main(String[] args) {

		int n;
		scan = new Scanner(System.in);

		System.out.println("Introduce un numero de 5 cifras: ");
		n = scan.nextInt();

		System.out.println(n / 10000);
		System.out.println(n / 1000);
		System.out.println(n / 100);
		System.out.println(n / 10);
		System.out.println(n);

	}

}
