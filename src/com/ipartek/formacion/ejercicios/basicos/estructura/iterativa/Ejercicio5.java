package com.ipartek.formacion.ejercicios.basicos.estructura.iterativa;

/***
 * Programa Java que muestre los n�meros del 100 al 1 utilizando la instrucci�n
 * do..while
 * 
 * @author user
 *
 */
public class Ejercicio5 {

	public static void main(String[] args) {
		int i = 100;
		do {
			System.out.println(i--);
		} while (i >= 1);
	}

}
