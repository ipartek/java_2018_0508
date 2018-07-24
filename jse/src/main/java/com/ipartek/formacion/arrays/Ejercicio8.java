package com.ipartek.formacion.arrays;

import java.util.Scanner;

public class Ejercicio8 {

	static final int N = 3;

	static Scanner sc = new Scanner(System.in);
	static String[] empleados = new String[N];
	static double[] sueldos = new double[N];
	static int mayor = -1;

	public static void main(String[] args) {

		int i = 0;

		do {

			System.out.println("Nombre: ");
			empleados[i] = sc.nextLine();

			System.out.println("Sueldo: ");
			sueldos[i] = sc.nextDouble();

			if (i > 0) {
				esMayorSueldo(i);
			} else {
				mayor = i;
			}

			sc.nextLine();

			i++;
		} while (i < N);

		printMayor();

	}

	/**
	 * Procedimiento privado que consulta si el último sueldo insertado es mayor. Si
	 * es mayor, actualiza el mayorSueldo.
	 * 
	 * @param i, entero con el último indice insertado
	 *
	 */
	public static void esMayorSueldo(int i) {

		if (sueldos[i] > sueldos[mayor]) {
			mayor = i;
		}
	}

	private static void printMayor() {

		System.out.println("El elmpleado con mayor sueldo es: " + empleados[mayor]);
		System.out.println("El mayor sueldo es: " + sueldos[mayor]);
	}

}
