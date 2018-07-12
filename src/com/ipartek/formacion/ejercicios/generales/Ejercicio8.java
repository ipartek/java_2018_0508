package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * 8. Mostrar los N primeros términos de la serie de Fibonacci
 * 
 * @author Curso
 *
 */
public class Ejercicio8 {

	private static Scanner scan;

	public static void main(String[] args) {
		
		scan = new Scanner(System.in);
		int num, f1, f2;
		
		do {
			System.out.print("Introduce un numero superior a 1: ");
			num = scan.nextInt();
		} while (num <= 1);
		
		System.out.println("Los " + num + " primeros numeros Fibonacci son:");

		f1 = 1;
		f2 = 1;

		System.out.print(f1 + " ");
		
		for (int i = 2; i <= num; i++) {
			System.out.print(f2 + " ");
			f2 = f1 + f2;
			f1 = f2 - f1;
		}
		System.out.println();
	}

}
