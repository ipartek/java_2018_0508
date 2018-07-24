package com.ipartek.formacion.ejercicios.bucles.anidados;

/**
 * Programa Java que muestre todos los valores de un contador de 5 dígitos
 * empezando por 00000 y acabando en 99999 con la particularidad que cada vez
 * que se deba mostrar un 3 se muestre E.
 * 
 * @author andreaPerez
 *
 */
public class Ejercicio5 {

	public static void main(String[] args) {

		for (int a = 0; a <= 9; a++) {
			for (int b = 0; b <= 9; b++) {
				for (int c = 0; c <= 9; c++) {
					for (int d = 0; d <= 9; d++) {
						for (int e = 0; e <= 9; e++) {
							System.out.print((a != 3) ? a : "E");
							System.out.print((b != 3) ? b : "E");
							System.out.print((c != 3) ? c : "E");
							System.out.print((d != 3) ? d : "E");
							System.out.println((e != 3) ? e : "E");
						}
					}
				}
			}
		}
	}

}
