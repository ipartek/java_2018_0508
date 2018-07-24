package com.ipartek.formacion.ejercicios.basicos.iniciales;

/**
 * Programa Java que declare una variable entera N y asígnale un valor. A
 * continuación escribe las instrucciones que realicen lo siguiente: Incrementar
 * N en 77, Decrementarla en 3, Duplicar su valor.
 * 
 * @author andreaperez
 *
 */

public class Ejercicio3 {

	public static final int INCREMENTAR = 77;
	public static final int DECREMENTAR = 3;

	public static void main(String[] args) {

		int n = 30;

		System.out.println("Incrementar " + n + " en " + INCREMENTAR + " : " + (n + INCREMENTAR));
		System.out.println("Decrementar " + n + " en " + DECREMENTAR + " : " + (n - DECREMENTAR));
		System.out.println("Duplicar " + n + " : " + n * 2);
	}

}
