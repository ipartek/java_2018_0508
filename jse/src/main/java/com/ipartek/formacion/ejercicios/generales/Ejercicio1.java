package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * Intercambiar el contenido de dos variables
 */
public class Ejercicio1 {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		System.out.println("Introducir un numero: ");
		int x = teclado.nextInt();

		System.out.println("Introducir otro numero: ");
		int y = teclado.nextInt();
		int tmp = x;
		x = y;
		y = tmp;
		System.out.println(x + " - " + y);
		teclado.close();

	}

}
