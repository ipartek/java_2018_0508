package com.ipartek.formacion.ejercicios.array;

/**
 * Llenar un array con números aleatorios.
 * 
 * @author Asier Cornejo
 *
 */
public class Ejercicio9 {

	public static void main(String[] args) {
		int[] numeros = new int[5];
		int numAle = 0;

		for (int i = 0; i < numeros.length; i++) {
			numAle = (int) (Math.random() * 10);
			numeros[i] = numAle;
		}
		for (int i = 0; i < numeros.length; i++) {
			System.out.println(numeros[i]);
		}

	}

}
