package com.ipartek.formacion.ejercicios.basicos.estructura.iterativa;

/**
 * Programa Java que muestre los números del 100 al 1 utilizando la instrucción
 * while
 * 
 * @author KmK
 *
 */

public class Ejercicio4 {

	public static void main(String[] args) {

		int i =100;
		
		System.out.println("Numeros del 100 al 1: ");
		do {
			System.out.print(" " + i);
			i--;
		} while (i>0);
	}

}