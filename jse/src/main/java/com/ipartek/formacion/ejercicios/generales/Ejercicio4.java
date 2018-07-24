package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * Mostrar la tabla de multiplicar de un número.
 */
public class Ejercicio4 {

	public static void main(String[] args) {
		System.out.print("Introduce un nuemro: ");
		Scanner teclado = new Scanner(System.in);
		int num = teclado.nextInt();
		for (int i = 0; i < 10; i++) {
			System.out.println(num + " x " + (i + 1) + " = " + (num * (i + 1)));

		}
		teclado.close();

	}

}
