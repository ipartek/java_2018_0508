package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
 * Ejercicio 10: Programa Java que lea un número entero de 3 cifras y muestre
 * por separado las cifras del número.
 * 
 * @author Curso
 *
 */
public class Ejercicio10 {

	public static void main(String[] args) {
		
		int n;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce un numero de 3 cifras:");
		n = sc.nextInt();
		
		System.out.println("Primera cifra "+n/100);
		n=n%100;
		System.out.println("Segunda cifra "+n/10);
		n=n%10;
		System.out.println("Tercera cifra "+n);
		
		sc.close();

	}

}
