package com.ipartek.formacion.ejercicios.bucles.anidados;

/**
 * Mostrar los números perfectos entre 1 y 1000.
 * 
 * Un número es perfecto si es igual a la suma de todos sus divisores
 * positivos<br>
 * sin incluir el propio número.
 * 
 * @author Asier Cornejo
 * 
 * 
 *
 */
public class Ejercicio1 {

	public static void main(String[] args) {

		int i;
		int j;
		int suma;
		System.out.println("Números perfectos entre 1 y 1000: ");
		for (i = 1; i <= 1000; i++) {
			suma = 0;
			for (j = 1; j < i; j++) {
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
