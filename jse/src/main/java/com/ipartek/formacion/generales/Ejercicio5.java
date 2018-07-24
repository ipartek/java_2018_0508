package com.ipartek.formacion.generales;

import java.util.Scanner;

/*
 * Un número es perfecto si es igual a la suma de todos sus divisores positivos
 * sin incluir el propio número.
 * En esta entrada vamos a desarrollar el algoritmo para comprobar si un número es perfecto.
 * El programa pide por teclado un número y muestra si es perfecto o no.
 */
public class Ejercicio5 {
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		int n;
		int sum = 0;
		
		System.out.println("Introduce un número: ");
		n = sc.nextInt();
		
		for (int i=1; i<n; i++) {
			sum+= (n%i==0 ? i : 0);
		}
		
		System.out.println(sum == n ? "El número " + n + " es perfecto" : "El número " + n + " no es perfecto.");
		

	}

}
