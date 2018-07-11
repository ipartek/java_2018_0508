package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
 * 12. Programa que lea un número entero N de 5 cifras y muestre sus cifras
 * desde<br>
 * el final igual que en el ejemplo.
 * 
 * @author Curso
 *
 */
public class Ejercicio12 {

	private static Scanner scan;

	public static void main(String[] args) {

		int n;
		scan = new Scanner(System.in);

		System.out.println("Introduce un numero de 5 cifras: ");
		n = scan.nextInt();

		System.out.println((n - ((n / 10) * 10)));
		System.out.println(n - ((n / 100) * 100));
		System.out.println(n - ((n / 1000) * 1000));
		System.out.println(n - ((n / 10000) * 10000));
		System.out.println(n);

	}

}
