package com.ipartek.ejercicios.generales;

import java.util.Scanner;

/**
 * Programa que intercambie dos variables
 * @author Curso
 *
 */

public class Ejercicio1 {
	
	private static Scanner sc;

	public static void main(String[] args) {
		
		sc = new Scanner(System.in);
		
		int a;
		int b;
		int aux;
		
		System.out.println("Introduzca un valor para a: ");
		a= sc.nextInt();
		System.out.println("Introduzca un valor para b: ");
		b= sc.nextInt();
		
		System.out.println("Valores iniciales: A = " + a + "   B = " + b);
		
		aux=a;
		a=b;
		b=aux;
		
		System.out.println("Valores intercambiados: A = " + a + "   B = " + b);
		
	}

}
