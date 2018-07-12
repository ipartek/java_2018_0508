package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * 5. Leer números y contar cuántos acaban en 2.
 * 
 * @author Curso
 *
 */
public class Ejercicio5 {

	private static Scanner scan;

	public static void main(String[] args) {

		scan = new Scanner(System.in);
		int num, cont = 0;

		System.out.print("Introduce un numero: ");
		num = scan.nextInt();

		while (num >= 0) {
			if (num % 10 == 2) {
				cont++;
			}
			System.out.print("Introduce un numero(numero negativo para finalizar cuenta): ");
			num = scan.nextInt();
		}
		System.out.println("Has introducido " + cont + " numeros que acaban en 2");
	}

}
