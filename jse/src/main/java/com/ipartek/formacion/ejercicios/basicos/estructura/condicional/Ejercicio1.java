package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.util.Scanner;

/**
 * Programa Java que lea un número entero por teclado y calcule si es par o
 * impar.
 *
 */

public class Ejercicio1 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		System.out.print("Introduzca un número: ");
		int num = teclado.nextInt();
		System.out.println(num + ((num % 2 == 0) ? " es par" : " es impar"));
		teclado.close();

	}

}
