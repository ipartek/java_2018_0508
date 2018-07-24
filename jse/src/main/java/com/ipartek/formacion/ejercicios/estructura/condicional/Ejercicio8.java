package com.ipartek.formacion.ejercicios.estructura.condicional;

import java.util.Scanner;

/**
 * Calcular el mayor de tres números enteros en Java.
 * El programa lee por teclado tres números enteros y calcula y muestra el mayor de los tres.
 * @author Curso
 *
 */

public class Ejercicio8 {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		int n1;
		int n2;
		int n3;
		
		System.out.println("Introduce un numero:");
		n1 = teclado.nextInt();
		
		System.out.println("Introduce otro numero:");
		n2 = teclado.nextInt();
		
		System.out.println("Introduce otro numero:");
		n3 = teclado.nextInt();
		
		System.out.println();
		System.out.println("Eston son los numeros introducidos: " + n1 + " " + n2 + " " + n3);
		System.out.println();
		if(n1 > n2) {
			if( n1 > n3) {
				System.out.println("El número " + n1 + " es el mayor.");
			}else {
				System.out.println("El número " + n3 + " es el mayor.");
			}
		}else if(n2 > n1) {
			if(n2 > n3) {
				System.out.println("El número " + n2 + " es el mayor.");
			}else {
				System.out.println("El número " + n3 + " es el mayor.");
			}
		}

		teclado.close();
		
	}

}
