package com.ipartek.formacion.ejercicios.array;

import java.util.Scanner;

/**
 * 3. Leer por teclado la nota de los alumnos de una clase y calcular la nota
 * media del grupo. Mostar los alumnos con notas superiores a la media.
 * 
 * @author apero
 *
 */
public class Ejercicio3 {

	public static void main(String[] args) {

		int n;
		int[] notas = new int[10];
		int media = 0;
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < notas.length; i++) {
			System.out.println("Introduce la nota del alumno" + (i + 1) + " :");
			n = sc.nextInt();
			notas[i] = n;
			media += notas[i];
		}

		media = media / notas.length;

		for (int i = 0; i < notas.length; i++) {
			if (notas[i] >= media) {
				System.out.println("El alumno" + (i+1) + " supera la media.");
			}
		}

		sc.close();

	}

}
