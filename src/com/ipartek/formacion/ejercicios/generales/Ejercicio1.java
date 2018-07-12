package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * Programa para intercambiar el valor de dos variables. 
 * Los valores iniciales se leen por teclado.
 * 
 * Por ejemplo, suponiendo que las variables se llaman A y B, si A contiene 3 y B contiene 5, 
 * después del intercambio A contendrá 5 y B 3.
 *
 */
public class Ejercicio1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int a;
		int b;
		int auxiliar;
		
		System.out.println("Introduzca un primer número");
		a = sc.nextInt();
		
		System.out.println("Introduzca un segundo número");
		b = sc.nextInt();
		
		System.out.println("Valor de A = " + a);
		System.out.println("Valor de B = " + b);
		
		auxiliar = a;
		a = b;
		b = auxiliar;
		
		System.out.println("\nValores intercambidos:\n");
		
		System.out.println("Valor de A = " + a);
		System.out.println("Valor de B = " + b);
		
		sc.close();

	}

}
