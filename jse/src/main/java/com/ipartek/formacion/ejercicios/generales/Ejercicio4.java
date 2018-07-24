package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * Programa Java que lea un número entero N y muestre la tabla de multiplicar de
 * ese número.
 * 
 * @author Curso
 *
 */

public class Ejercicio4 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num;

		System.out.print("Tabla de multiplicar del: ");
		num = sc.nextInt();

		for (int i = 1 ; i<=10 ; i++) {
			System.out.println("  " + num + " * " + i + " = " + num*i);
		}
		
		sc.close();
	}

}
