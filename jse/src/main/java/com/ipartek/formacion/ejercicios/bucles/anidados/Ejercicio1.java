package com.ipartek.formacion.ejercicios.bucles.anidados;

import com.ipartek.formacion.ejercicios.Utilities;

/**
 * Mostrar los números perfectos entre 1 y 1000.
 *
 */
public class Ejercicio1 {

	public static void main(String[] args) {
		for (int i = 0; i < 1000; i++) {
			System.out.println((i + 1) + " -> "+ (((i + 1) == Utilities.sumDivisors(i + 1)) ? "Perfecto" : "No es perfecto"));
		}

	}

}
