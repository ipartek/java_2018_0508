package com.ipartek.formacion.util;

import java.util.Scanner;

public class Utilidades {

	static int[] array = { 0, 3, 1, 8, 7, 2, 5, 4, 6, 9 };
	static int[] res;

	//	PARA TESTEAR EL CÓDIGO
	public static void main(String[] args) {

		res = bubbleSort(array, true);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}
		System.out.println();
		
		res = bubbleSort(array, false);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}
		System.out.println();

	}
	/**
	 * Función que ordena un array de enteros según el algoritmo bubbleSort.
	 * @param nums
	 * @param asc
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
			}
		}
		return res;
	}
	
	//	FUNCIONES DE LECTURA DE DATOS EN CONSOLA
	/**
	 * Pide y Lee un número entero introducido por consola.
	 * @param sc
	 * @return int, con el valor introducido en consola.
	 */
	public static int leerInt(Scanner sc) {
		
		int n;
		
		sc = new Scanner(System.in);
		System.out.println("Introduce un valor númerico entero: ");
		n = sc.nextInt();
		sc.close();
		
		return n;
		
	}
	
	/**
	 * Pide y Lee una línea introducida en consola.
	 * @param sc
	 * @return String, con la línea introducida en consola.
	 */
	public static String leerString(Scanner sc) {
		
		String s;
		
		sc = new Scanner(System.in);
		System.out.println("Introduce un texto: ");
		s = sc.nextLine();
		sc.close();
		
		return s;
		
	}

}
