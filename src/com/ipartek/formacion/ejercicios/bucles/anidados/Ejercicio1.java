package com.ipartek.formacion.ejercicios.bucles.anidados;

/**
 * 1. Mostrar los números perfectos entre 1 y 1000.
 * 
 * @author Curso
 *
 */
public class Ejercicio1 {

	public static void main(String[] args) {

		int suma;

		System.out.println("Numeros perfectos entre 1 y 1000: ");
		for (int i = 1; i <= 1000; i++) {
			suma = 0;
			for (int j = 1; j < i; j++) {
				if (i % j == 0) {
					suma = suma + j;
				}
			}
			if (i == suma) {
				System.out.println(i);
			}
		}
	}

}
