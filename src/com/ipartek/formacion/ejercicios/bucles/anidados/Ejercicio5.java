package com.ipartek.formacion.ejercicios.bucles.anidados;

/**
 * 5. Mostrar un contador de 5 dígitos. En lugar del dígito 3 se debe mostrar E
 * 
 * @author Curso
 *
 */
public class Ejercicio5 {

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
						}
					}
				}
			}
		}
	}

}
