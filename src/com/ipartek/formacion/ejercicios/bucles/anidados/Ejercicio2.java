package com.ipartek.formacion.ejercicios.bucles.anidados;

import java.util.Scanner;

import com.ipartek.formacion.ejercicios.Utilities;

/**
 * Leer un número N y calcular el factorial de los números desde 0 hasta N.
 *
 */
public class Ejercicio2 {

	public static void main(String[] args) {

		System.out.print("Introduce un numero: ");
		Scanner teclado = new Scanner(System.in);
		int num = teclado.nextInt();
		Utilities.factorial(num);
		teclado.close();

	}

}
