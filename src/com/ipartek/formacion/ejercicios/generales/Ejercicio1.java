package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * Programa para intercambiar el valor de dos variables. Los valores iniciales
 * se leen por teclado.
 * 
 * @author KmK
 *
 */
public class Ejercicio1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int a = 0;
		int b = 0;
		int aux = 0;

		System.out.print("Introduzca A: ");
		a = sc.nextInt();
		System.out.print("Introduzca B: ");
		a = sc.nextInt();

		System.out.println("Valor de A: " + a + " - Valor de B: " + b);
		System.out.println("Intercambiamos valores de A y B");

		aux = a;
		a = b;
		b = aux;

		System.out.println("Valor de A: " + a + " - Valor de B: " + b);

		sc.close();
	}

}
