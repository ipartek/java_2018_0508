package com.ipartek.formacion.ejercicios.generales;

import java.io.IOException;
import java.util.Scanner;

/**
 * 1. Intercambiar el contenido de dos variables
 * 
 * @author Curso
 *
 */
public class Ejercicio1 {

	private static Scanner scan;

	public static void main(String[] args) throws IOException {

		scan = new Scanner(System.in);
		int num1, num2, aux;
		char c;

		do {
			System.out.println("Introduce un numero: ");
			num1 = scan.nextInt();
			System.out.println("Introduce otro numero: ");
			num2 = scan.nextInt();
			System.out.println("Has introducido el " + num1 + " y el " + num2);

			aux = num1;
			num1 = num2;
			num2 = aux;

			System.out.println("Al reves el " + num1 + " y el " + num2);
			System.out.print("Continuar? ");
			c = (char) System.in.read();

		} while (c != 'n' && c != 'N');

	}

}
