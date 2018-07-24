package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * Intercambiar el contenido de dos variables. Programa para intercambiar el
 * valor de dos variables. Los valores iniciales se leen por teclado.
 * 
 * Por ejemplo, suponiendo que las variables se llaman A y B, si A contiene 3 y
 * B contiene 5, después del intercambio A contendrá 5 y B 3.
 * 
 * 
 * @author andreaperez
 *
 */

public class Ejercicio1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int a = 0;
		int b = 0;
		int aux = 0;

		System.out.print("valor de a: ");
		a = sc.nextInt();
		aux = a;
		System.out.print("valor de b: ");
		b = sc.nextInt();
		a = b;
		b = aux;
		System.out.println("El valor de \"a\" es : " + a + " y el valor de \"b\" es: " + b);

		sc.close();

	}

}
