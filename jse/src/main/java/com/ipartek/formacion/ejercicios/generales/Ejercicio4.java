package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * Programa Java que lea un número entero N y muestre la tabla de multiplicar de ese número.
 * @author Curso
 *
 */
public class Ejercicio4 {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		int n1;
		int cont = 1;
		
		System.out.println("Introduce un numero entero:");
		n1 = teclado.nextInt();
		
		System.out.println();
		System.out.println("Tabla de multiplicar del número: " + n1);
		System.out.println("-----------------------------------------");
		
		do {
			System.out.println(n1 + " * " + cont + " = " + (n1 * cont));
			cont++;
		} while (cont <= 10);

		teclado.close();
	}

}
