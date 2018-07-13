package com.ipartek.formacion.ejercicios.array;

import java.util.Scanner;

/**
 * Leer por teclado la nota de los alumnos de una clase y calcular la nota media
 * del grupo. Mostar los alumnos con notas superiores a la media.
 * 
 * @author Asier Cornejo
 *
 */
public class Ejercicio3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int numAlum;
		int i;
		double suma = 0;
		double media;

		// Lectura del número de alumnos. Debe ser un valor positivo
		do {
			System.out.print("Número de alumnos de la clase: ");
			numAlum = sc.nextInt();
		} while (numAlum <= 0);

		// se crea un array llamado notas de numAlumn elementos de tipo double
		double[] notas = new double[numAlum];

		// Entrada de datos. Se lee la nota de cada alummo y se guarda
		// en cada elemento del array
		for (i = 0; i < notas.length; i++) {
			System.out.print("Alumno " + (i + 1) + " Nota final: ");
			notas[i] = sc.nextDouble();
		}

		// Sumar todas las notas
		for (i = 0; i < notas.length; i++) {
			suma = suma + notas[i];
		}

		// Calcular la media
		media = suma / notas.length;

		// Mostrar la media
		System.out.printf("Nota media del curso: %.2f %n", media);

		// Mostrar los valores superiores a la media
		System.out.println("Listado de notas superiores a la media: ");
		for (i = 0; i < notas.length; i++) {
			if (notas[i] > media) {
				System.out.println("Alumno numero " + (i + 1) + " Nota final: " + notas[i]);
			}
		}
		sc.close();
	}

}
