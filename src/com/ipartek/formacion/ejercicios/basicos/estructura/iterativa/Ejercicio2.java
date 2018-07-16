package com.ipartek.formacion.ejercicios.basicos.estructura.iterativa;

/**
 * Programa Java que muestre los números del 1 al 100 utilizando la instrucción
 * while
 * 
 * @author KmK
 *
 */

public class Ejercicio2 {

	public static void main(String[] args) {

		int i =1;
		
		System.out.println("Numeros del 1 al 100: ");
		do {
			System.out.print(" " + i);
			i++;
		} while (i<=100);
	}

}
