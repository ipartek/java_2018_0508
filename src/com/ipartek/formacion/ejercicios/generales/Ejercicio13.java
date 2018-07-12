package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * 13. Comprobar si un número entero es capicúa
 * 
 * @author Curso
 *
 */
public class Ejercicio13 {

	private static Scanner scan;

	public static void main(String[] args) {
		int num, aux, inverso = 0, cifra;
		scan = new Scanner(System.in);
		do {
			System.out.print("Introduce un número >= 10: ");
			num = scan.nextInt();
		} while (num < 10);

		aux = num;
		while (aux != 0) {
			cifra = aux % 10;
			inverso = inverso * 10 + cifra;
			aux = aux / 10;
		}

		if (num == inverso) {
			System.out.println("Es capicua");
		} else {
			System.out.println("No es capicua");
		}
	}

}
