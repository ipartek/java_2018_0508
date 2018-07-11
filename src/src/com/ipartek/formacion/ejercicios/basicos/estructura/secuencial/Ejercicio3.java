package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

public class Ejercicio3 {

	/**
	 * Escribe un programa Java que lee un número entero por teclado y obtiene y
	 * muestra por pantalla el doble y el triple de ese número.
	 */

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		System.out.print("Introduzca el número: ");
		int num = teclado.nextInt();
		System.out.println("El doble: " + num * 2);
		System.out.println("El triple: " + num * 3);
		teclado.close();

	}

}
