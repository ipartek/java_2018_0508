package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * 13. Comprobar si un número entero es capicúa
 * 
 * @author Curso
 *
 */
public class Ejercicio12 {

	public static void main(String[] args) {

		int n;
		int inverso = 0;
		int cifra;
		Scanner sc = new Scanner(System.in);

		do {

			System.out.println("Introduce un número >= 10: ");
			n = sc.nextInt();

		} while (n < 10);

		int aux = n;
		while (aux != 0) {
			cifra = aux % 10;
			inverso = inverso * 10 + cifra;
			aux = aux / 10;
		}
		
		System.out.println((n==inverso)?n+" es capicua.":n+" no es capicua.");
		
		sc.close();

	}

}
