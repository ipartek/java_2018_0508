package com.ipartek.formacion.util;

import java.util.Scanner;

public class Utilidades {

	// PARA TESTEAR EL C�DIGO
	public static void main(String[] args) {

		int[] array = { 0, 3, 1, 8, 7, 2, 5, 4, 6, 9 };
		int[] res;

		res = bubbleSort(array, true); // Llamada a la la funcion bubbleSort en orden ascendente
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}

		System.out.println();

		res = bubbleSort(array, false); // Llamada a la funcion bubbleSort en orden descendente
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}
		System.out.println();

	}

	// UTILIDADES PARA LOS ARRAYS DE ENTEROS
	// --------------------------------------
	/**
	 * Funci�n que ordena un array de enteros seg�n el algoritmo bubbleSort.
	 * 
	 * @param nums, array de enteros con valores numericos
	 * @param asc, boolean que indica si es ascendente
	 * @return int[] con el array nums[] ordenado ascendente o descendentemente
	 */
	public static int[] bubbleSort(int[] nums, boolean asc) {

		int[] res = nums;
		int aux;

		for (int i = 0; i < res.length; i++) {
			for (int j = i; j < res.length; j++) {
				if (asc) {
					if (res[i] > res[j]) {
						aux = res[i];
						res[i] = res[j];
						res[j] = aux;
					}
				} else {
					if (res[i] < res[j]) {
						aux = res[i];
						res[i] = res[j];
						res[j] = aux;
					}
				}
			} // for 2
		} // for
		return res;
	}

	/**
	 * Funci�n que devuelve un String con la representaci�n de los valores del
	 * array.
	 * 
	 * @param array, con valores enteros
	 * @return String con los valores del array
	 */
	public static String arrayIntToString(int[] array) {

		String result = "[ ";

		for (int i = 0; i < array.length; i++) {
			result += (i == array.length - 1 ? array[i] + "]" : array[i] + ", ");
		}
		return result;
	}

	// FUNCIONES DE LECTURA DE DATOS EN CONSOLA
	// -----------------------------------------
	/**
	 * Pide y Lee un n�mero entero introducido por consola.
	 * 
	 * @param sc, Scanner
	 * @return int, con el valor introducido en consola.
	 */
	public static int leerInt(Scanner sc) {

		int n;

		System.out.println("Introduce un valor n�merico entero: ");
		n = sc.nextInt();
		sc.nextLine();

		return n;
	}

	/**
	 * Pide y Lee una l�nea introducida en consola.
	 * 
	 * @param sc, Scanner
	 * @return String, con la l�nea introducida en consola.
	 */
	public static String leerString(Scanner sc) {

		String s;

		System.out.println("Introduce un texto: ");
		s = sc.nextLine();

		return s;
	}

}
