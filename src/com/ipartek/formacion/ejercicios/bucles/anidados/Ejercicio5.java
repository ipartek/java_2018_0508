package com.ipartek.formacion.ejercicios.bucles.anidados;

/**
 * Programa Java que muestre todos los valores de un contador de 5 dígitos
 * empezando por 00000 y acabando en 99999 con la particularidad que cada vez
 * que se deba mostrar un 3 se muestre E.
 * 
 * @author Curso
 *
 */
public class Ejercicio5 {

	public static void main(String[] args) {
		
		for (int i = 0; i <= 9; i++) {
			for (int j = 0; j <= 9; j++) {
				for (int c = 0; c <= 9; c++) {
					for (int k = 0; k <= 9; k++) {
						for (int q = 0; q <= 9; q++) {
							System.out.print(i != 3 ? i : "E");
							System.out.print(j != 3 ? j : "E");
							System.out.print(c != 3 ? c : "E");
							System.out.print(k != 3 ? k : "E");
							System.out.println(q != 3 ? q : "E");
						}
						System.out.println("---------------");
					}//4For
				}//3For
			}//2For

		}//1For

	}

}
