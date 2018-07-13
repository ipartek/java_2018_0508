package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * Mostrar la tabla de multiplicar de un número.
 *
 */
public class Ejercicio4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int numero;
		
		System.out.println("Introduzca un número para mostrar su tabla de multiplicar");
		numero = sc.nextInt();
		
		System.out.println("Tabla de multiplicar del " + numero + ":\n");
		
		for (int i = 0; i <= 10; i++) {
			System.out.println(numero + " * " + i + " = " + numero * i);
		}
		
		sc.close();

	}

}
