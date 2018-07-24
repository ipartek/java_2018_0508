package com.ipartek.formacion.ejercicios.estructura.condicional;

import java.util.Scanner;

/**
 * Programa Java que lea un número entero por teclado y calcule si es par o impar.
 * Podemos saber si un número es par si el resto de dividir el número entre 2 es igual a cero. En caso contrario el número es impar
 * El operador Java que calcula el resto de la división entre dos números enteros o no es el operador %
 * @author Curso
 *
 */

public class Ejercicio1 {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		int n1;
		
		System.out.println("Introduce un numero entero:");
		n1 = teclado.nextInt();
		
		System.out.println();
		if(n1 % 2 == 0) {
			System.out.println(n1 + " es un numero par.");
		}else {
			System.out.println(n1 + " es un numero impar.");
		}
		
		teclado.close();

	}

}
