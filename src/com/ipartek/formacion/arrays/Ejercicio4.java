package com.ipartek.formacion.arrays;

/**
 * Guardar en un array los 20 primeros números pares.
 * 
 * @author Curso
 *
 */
public class Ejercicio4 {

	static int[] array = new int[20];

	public static void main(String args[]) {

		System.out.println("20 primeros números pares:");

		int cont = 0;
		int tam = 0;

		while (tam < 20) {
			if (cont % 2 == 0) {
				array[tam] = cont;
				tam++;
				System.out.print(cont + " ");
			}
			cont++;
		}
	}

}
