package com.ipartek.formacion.ejercicios.bucles.anidados;

/**
 * 1. Mostrar los números perfectos entre 1 y 1000.
 * 
 * @author apero
 *
 */
public class Ejercicio1 {

	public static void main(String[] args) {

		int sumaDeDivisores = 0;

		System.out.println("Los numeros perfectos entre el 1 y 1000");
		for (int i = 1; i <= 1000; i++) {
			for (int j = 1; j < i; j++) {
				if (i % j == 0) {
					sumaDeDivisores = sumaDeDivisores + j;
				}
			}
			if (sumaDeDivisores == i) {
				System.out.println(i);
			}
			sumaDeDivisores = 0;
		}

	}

}
