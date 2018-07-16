package com.ipartek.formacion.ejercicios.arrays;

import java.util.Scanner;

/**
 * Programa Java para leer la altura de N personas y calcular la altura media.
 * Calcular cuántas personas tienen una altura superior a la media y cuántas
 * tienen una altura inferior a la media. El valor de N se pide por teclado y
 * debe ser entero positivo.
 * 
 * @author andreaperez
 *
 */
public class Ejercicio7 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		double[] alturas = null;
		int contMayor = 0;
		int contMenor = 0;
		int cont = 0;
		double suma = 0;

		System.out.println("¿De cuantas alturas quieres el array?");
		alturas = new double[sc.nextInt()];

		for (int i = 0; i < alturas.length; i++) {
			System.out.println("altura " + i + " da valor: ");
			alturas[i] = sc.nextDouble();
			cont++;
			suma += alturas[i];
		}

		for (int i = 0; i < alturas.length; i++) {
			if (alturas[i] > suma / cont) {
				contMayor++;
			} else {
				contMenor++;
			}
		}

		System.out.println("La altura media es: " + suma / cont);
		System.out.println(contMayor + "personas superan la altura media ");
		System.out.println(contMenor + "no personas superan la altura media ");
		sc.close();

	}

}
