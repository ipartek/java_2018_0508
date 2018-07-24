package com.ipartek.formacion.generales;

import java.util.Scanner;

/*
 * Programa para intercambiar el valor de dos variables. 
 * Los valores iniciales se leen por teclado.
 */
public class Ejercicio1 {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
			
		int x; 
		int y;
		int aux;
		
		System.out.println("Primer valor: ");
		x = sc.nextInt();
		
		System.out.println("Segundo valor: ");
		y = sc.nextInt();
		
		System.out.println("Valores originales: ");
		System.out.println("x = " + x + ";\t" + "y = " + y + ";\t");
		
		aux = x;
		x = y;
		y = aux;
		
		System.out.println("Valores intercambiados: ");
		System.out.println("x = " + x + ";\t" + "y = " + y + ";\t");


	}

}
