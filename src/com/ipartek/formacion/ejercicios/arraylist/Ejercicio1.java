package com.ipartek.formacion.ejercicios.arraylist;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Calcular la altura media de los alumnos de una clase.
 *
 */
public class Ejercicio1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Numero de alumnos en clase: ");
		int size = sc.nextInt();
		ArrayList<Integer> alumnos = new ArrayList<Integer>();

		int sum = 0;
		for (int i = 0; i <size; i++) {
			System.out.print("Introduce una altura: ");
			alumnos.add(sc.nextInt());
			sum += alumnos.get(i);

		}
		System.out.println("La media de clase es: " + (float) (sum / alumnos.size()));
		sc.close();

	}

}
