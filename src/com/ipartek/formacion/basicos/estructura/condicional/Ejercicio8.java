package com.ipartek.formacion.basicos.estructura.condicional;

import java.util.Scanner;

/**
 * Programa que lea tres números por teclado y calcula el mayor.
 * 
 * @author Curso
 *
 */
public class Ejercicio8 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int x;
		int y;
		int z;

		x = leerInt();
		y = leerInt();
		z = leerInt();
		
		if (x > y) {
			if (x > z) {	// x es el mayor
				System.out.println("El mayor es: " + x);
			} else {		// z es el mayor
				System.out.println("El mayor es: " + z);
			}
		} else if (y > z) {
			System.out.println("El mayor es: " + y);
		} else {
			System.out.println("El mayor es: " + z);
		}

	}

	private static int leerInt() {

		System.out.println("Introduce un número entero: ");
		return sc.nextInt();
	}

}
