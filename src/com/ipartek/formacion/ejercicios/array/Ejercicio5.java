package com.ipartek.formacion.ejercicios.array;

/**
 * 
 * Contar el número de elementos positivos, negativos y ceros en un array de 10
 * enteros.
 * 
 * @author Asier Cornejo
 *
 */
public class Ejercicio5 {

	public static void main(String[] args) {
		int[] numeros = { 1, -2, 5, -3, 4 };
		int positivos = 0;
		int negativos = 0;

		for (int i = 0; i < numeros.length; i++) {
			if (numeros[i] < 0) {
				positivos++;
			} else {
				negativos++;
			}
		}
		System.out.println("En el array hay " + positivos + " numeros positivos");
		System.out.println("En el array hay " + negativos + " numeros negativos");
	}

}
