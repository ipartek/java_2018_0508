package com.ipartek.formacion.ejercicios.bucles.anidados;

import java.util.Scanner;

/**
 * Leer un número N y calcular el factorial de los números desde 0 hasta N.
 *
 */
public class Ejercicio2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n;
		
		do {
			System.out.println("Introduce un número");
			n = sc.nextInt();
		} while (n >= 0);

	}

}
