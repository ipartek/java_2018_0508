package com.ipartek.formacion.ejercicios.generales;

import java.io.IOException;
import java.util.Scanner;

/**
 * 3. Pasar de grados centígrados a grados kelvin.El proceso de leer grados
 * centígrados se debe repetir mientras que se responda ‘S’ a la pregunta:
 * Repetir proceso? (S/N)
 * 
 * @author Curso
 *
 */
public class Ejercicio3 {

	private static Scanner scan;

	public static void main(String[] args) throws IOException {

		scan = new Scanner(System.in);
		int num;
		char c;

		do {

			System.out.println("Introduce los grados C: ");

			num = scan.nextInt();

			System.out.println("La temperatura en grados Fahrenheit es " + (32 + (9 * num / 5)));
			System.out.print("Continuar? ");
			c = (char) System.in.read();
		} while (c != 'n' && c != 'N');

	}

}
