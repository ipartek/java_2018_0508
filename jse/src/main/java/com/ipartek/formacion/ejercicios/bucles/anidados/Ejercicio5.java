package com.ipartek.formacion.ejercicios.bucles.anidados;

/**
 * Mostrar un contador de 5 dígitos. En lugar del dígito 3 se debe mostrar E
 *
 */
public class Ejercicio5 {

	public static void main(String[] args) {
		
		for (int i = 0; i <= 9; i++) {
			for (int j = 0; j <= 9; j++) {
				for (int j2 = 0; j2 <= 9; j2++) {
					for (int k = 0; k <= 9; k++) {
						for (int k2 = 0; k2 <= 9; k2++) {
							System.out.print((i != 3)? i : "E");
							System.out.print((j != 3)? j : "E");
							System.out.print((j2 != 3)? j2 : "E");
							System.out.print((k != 3)? k : "E");
							System.out.println((k2 != 3)? k2 : "E");
						}
					}
				}
			}
		}

	}

}
