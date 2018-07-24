package com.ipartek.formacion.ejercicios.bucles.anidados;

/**
 * Mostrar un contador de 5 dígitos. En lugar del dígito 3 se debe mostrar E
 */
public class Ejercicio5 {

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
				System.out.println((i==3)?"E":i);
		}

	}

}
