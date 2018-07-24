package com.ipartek.formacion.ejercicios.array;

/**
 * 9. Llenar un array con números aleatorios.
 * 
 * @author apero
 *
 */
public class Ejercicio9 {

	public static void main(String[] args) {

		int[] numeros = new int[10];

		for (int i = 0; i < numeros.length; i++) {
			numeros[i]=(int) Math.random();
		}
		
		for (int i = 0; i < numeros.length; i++) {
			System.out.println(numeros[i]);
		}
	}

}
