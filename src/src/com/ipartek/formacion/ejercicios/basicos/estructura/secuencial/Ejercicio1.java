package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
 * Programa Java que lea dos números enteros por teclado y los muestre por
 * pantalla.
 */

public class Ejercicio1 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		System.out.print("Introduzca el primer número: ");
		int x = teclado.nextInt();

		System.out.print("Introduzca el segundo número: ");
		int y = teclado.nextInt();

		System.out.println(x + " - " + y);
		teclado.close();

	}

}
