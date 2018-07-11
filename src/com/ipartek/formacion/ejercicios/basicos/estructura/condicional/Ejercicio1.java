package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.util.Scanner;

/**
 * 1. Programa Java que lea un número entero y calcule si es par o impar.
 * 
 * @author Curso
 *
 */
public class Ejercicio1 {

	private static Scanner scan;

	public static void main(String[] args) {

		scan = new Scanner(System.in);
		int n;

		System.out.print("Introduce un numero: ");
		n = scan.nextInt();

		if (n % 2 == 0) {
			System.out.println(n + " es par");
		} else {
			System.out.println(n + " es impar");
		}
	}
}
