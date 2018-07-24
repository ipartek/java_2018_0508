package com.ipartek.formacion.ejercicios.basicos.iterativa.repetitiva;

/**
 * 2. Ejemplo de uso de do-while. Programa Java que muestre los números del 1 al 100 utilizando la instrucción do..while.
 * 
 * @author Ainara
 *
 */

public class Ejercicio2 {

	public static void main(String[] args) {

		int i = 1;

		System.out.println("Numeros del 1 al 100: ");

		do {
			System.out.println(i);
			i++;
		} while (i <= 100);

	}

}
