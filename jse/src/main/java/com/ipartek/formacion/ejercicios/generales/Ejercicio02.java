package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * 2.Programa Java que pide un número entero por teclado y calcula y muestra el
 * número de cifras que tiene.
 * 
 * @author Curso
 *
 */
public class Ejercicio02 {

	public static void main(String[] args) {

		int n;
		int contador = 1;
		Scanner sc = new Scanner(System.in);

		System.out.println("Dime un numero:");
		n = sc.nextInt();

		if (n >= 10) {
			int auxN = n;
			while (auxN > 10) {
				contador++;
				auxN = auxN / 10;
			}
		}
		System.out.println("El numero " + n + " tiene " + contador + " cifra.");

		sc.close();
	}

}
