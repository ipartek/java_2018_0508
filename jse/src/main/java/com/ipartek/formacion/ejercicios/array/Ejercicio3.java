package com.ipartek.formacion.ejercicios.array;

import java.util.Scanner;

/**
 * Programa que lee por teclado la nota de los alumnos de una clase y calcula la nota media del grupo
 * También muestra los alumnos con notas superiores a la media
 * Este programa utiliza un array de elementos de tipo double que contendrá las notas de los alumnos
 * El tamaño del array será el número de alumnos de la clase, por lo tanto primero se pedirá por teclado el número de alumnos y a continuación se creará el array
 * @author Curso
 *
 */
public class Ejercicio3 {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		int nAlumnos = 0;
		double mediaNota = 0;

		System.out.println("¿Cuantos alumnos hay en clase?");
		nAlumnos = teclado.nextInt();
		
		double[] notas = new double[nAlumnos];
		
		System.out.println();
		for (int i = 0; i < notas.length; i++) {
			System.out.println("Introduce la nota del alumno " + (i+1) + " :");
			notas[i] = teclado.nextDouble();
			mediaNota = mediaNota + notas[i];
		}
		
		//Mostrar notas introducidas
		System.out.println();
		System.out.println("Las notas introducidas son:");
		for (int i = 0; i < notas.length; i++) {
			System.out.print(notas[i] + " | ");
		}
		
		// Calcular la media
		mediaNota = mediaNota / nAlumnos;
		
		System.out.println();
		System.out.println();
		System.out.println("La nota media de la clase es: " + mediaNota);
		
		//Mostrar las notas superiores a la media
		System.out.println();
		for (int i = 0; i < notas.length; i++) {
			if(notas[i] > mediaNota) {
				System.out.println("La nota del alumno " + (i+1) + "("+ notas[i] + ") es superior a la media");
			}
		}
		
		teclado.close();
	}

}
