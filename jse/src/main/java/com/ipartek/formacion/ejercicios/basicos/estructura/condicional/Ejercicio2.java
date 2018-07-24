package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.util.Scanner;

/**
 * Programa que lea un número entero y muestre si el número es múltiplo de 10.
 * 
 */

public class Ejercicio2 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		System.out.print("Introduzca un número: ");
		int num = teclado.nextInt();
		System.out.println(num + ((num % 5 == 0) ? " es multiplo de 5" : " no es multiplo de 5"));
		teclado.close();
	}

}
