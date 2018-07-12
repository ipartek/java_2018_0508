package com.ipartek.formacion.arrays;

import java.util.Scanner;

/**
 * rograma que lee por teclado la nota de los alumnos de una clase y calcula la
 * nota media del grupo. También muestra los alumnos con notas superiores a la
 * media. El número de alumnos se lee por teclado.
 * 
 * @author Curso
 *
 */
public class Ejercicio3 {

	static Scanner sc = new Scanner(System.in);
	static double[] alumnos;
	static int n = 0;
	static double media = 0f;

	public static void main(String[] args) {

		int i = 0;

		System.out.println("Introduce el número de alumnos: ");
		n = sc.nextInt();
		alumnos = new double[n];

		do {

			System.out.println("Introduce la nota: ");
			alumnos[i] = sc.nextDouble();
			i++;

		} while (i < n);

		media = media();
		System.out.println("La media es: " + media);

		alumnosMedia();
	}

	private static double media() {

		double media = 0;

		for (int i = 0; i < n; i++) {
			media += alumnos[i];
		}

		media /= n;
		return media;
	}

	private static void alumnosMedia() {

		System.out.println("Alumnos por encima de la media: ");
		System.out.println("------------------------------");
		for (int i = 0; i < alumnos.length; i++) {
			if (alumnos[i] > media) {
				System.out.println("Alumno " + (i + 1) + ": " + alumnos[i]);
			}

		}
	}
}
