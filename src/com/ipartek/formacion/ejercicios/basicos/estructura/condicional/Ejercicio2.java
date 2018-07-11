package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.util.Scanner;

/**
 * 2. Programa que lea un número entero y muestre si el número es múltiplo de
 * 10.
 * 
 * @author Curso
 *
 */
public class Ejercicio2 {

	private static Scanner scan;

	public static void main(String[] args) {

		scan = new Scanner(System.in);
		int n;

		System.out.print("Introduce un numero: ");
		n = scan.nextInt();

		if (n % 10 == 0) {
			System.out.println(n + " es multiplo de 10");
		} else {
			System.out.println(n + " no es multiplo de 10");
		}
	}
}