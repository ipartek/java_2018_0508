package com.ipartek.formacion.ejercicios.arrays;

import java.util.Scanner;

/**
 * Programa que lee por teclado la nota de los alumnos de una clase y calcula la
 * nota media del grupo. También muestra los alumnos con notas superiores a la
 * media. El número de alumnos se lee por teclado. Este programa utiliza un
 * array de elementos de tipo double que contendrá las notas de los alumnos. El
 * tamaño del array será el número de alumnos de la clase, por lo tanto primero
 * se pedirá por teclado el número de alumnos y a continuación se creará el
 * array. Se realizan 3 recorridos sobre el array, el primero para asignar a
 * cada elemento las notas introducidas por teclado, el segundo para sumarlas y
 * calcular la media y el tercero para mostrar los alumnos con notas superiores
 * a la media.
 * 
 * @author andreaperez
 *
 */
public class Ejercicio3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		double[] arrayAlum = null;
		int sumaNota = 0;

		System.out.println("¿Cuantos alumnos hay?");
		arrayAlum = new double[sc.nextInt()];

		for (int i = 0; i < arrayAlum.length; i++) {
			System.out.println("Pon nota al " + i + " alumno:");
			arrayAlum[i] = sc.nextDouble();
		}

		for (int i = 0; i < arrayAlum.length; i++) {
			if (arrayAlum[i] >= 0) {
				sumaNota += arrayAlum[i];
			}
		}
		System.out.println("La nota media de los alumnos es: " + sumaNota / arrayAlum.length);

		int cont = 0;
		for (int i = 0; i < arrayAlum.length; i++) {
			if (arrayAlum[i] > sumaNota / arrayAlum.length) {
				cont++;
			}

		}

		System.out.println(cont + " alumnos han superado la nota media ");

		sc.close();

	}

}
