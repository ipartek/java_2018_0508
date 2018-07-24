package com.ipartek.formacion.ejercicios.bucles.anidados;

/**
 * Programa Java que muestre todos los valores de un contador de 5 dígitos<br>
 * empezando por 00000 y acabando en 99999 con la particularidad que cada vez<br>
 * que se deba mostrar un 3 se muestre E.<br>
 * 
 * @author Ainara
 *
 */

public class Ejercicio4 {

	public static void main(String[] args) {

		for (int i = 0; i <= 9; i++) {
			for (int j = 0; j <= 9; j++) {
				for (int k = 0; k <= 9; k++) {
					for (int l = 0; l <= 9; l++) {
						for (int m = 0; m <= 9; m++) {
							System.out.print(i != 3 ? i : "E");
							System.out.print(j != 3 ? j : "E");
							System.out.print(k != 3 ? k : "E");
							System.out.print(l != 3 ? l : "E");
							System.out.println(m != 3 ? m : "E");
						} // Fin del quinto FOR
					} // Fin del cuarto FOR
				} // Fin del tercer FOR
			} // Fin del segundo FOR
		} // Fin del primer FOR
	}

}
