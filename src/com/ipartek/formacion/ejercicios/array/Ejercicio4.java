package com.ipartek.formacion.ejercicios.array;

/**
 * 
 * Guardar en un array los 20 primeros números pares
 * 
 * @author Asier Cornejo
 *
 */
public class Ejercicio4 {

	public static void main(String[] args) {
		int[] numeros = new int[20];
		int cont = 2;

		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = cont;
			cont += 2;
		}

		for (int j = 0; j < numeros.length; j++) {
			System.out.println(numeros[j]);
		}

	}
}
