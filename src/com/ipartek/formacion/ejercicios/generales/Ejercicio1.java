package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * Programa para intercambiar el valor de dos variables. Los valores iniciales se leen por teclado.
 * @author Curso
 *
 */
public class Ejercicio1 {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		int n1;
		int n2;
		int aux = 0;
		
		System.out.println("Introduce un numero:");
		n1 = teclado.nextInt();
		
		System.out.println("Introduce otro numero:");
		n2 = teclado.nextInt();
		
		System.out.println();
		System.out.println("Valores iniciales");
		System.out.println("n1: " + n1 + " | n2: " + n2);
		
		aux = n1;
		n1 = n2;
		n2 = aux;
		
		System.out.println();
		System.out.println("Valores intercambiados");
		System.out.println("n1: " + n1 + " | n2: " + n2);

		teclado.close();
	}

}
