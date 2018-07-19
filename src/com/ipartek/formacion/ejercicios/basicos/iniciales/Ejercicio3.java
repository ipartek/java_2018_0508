package com.ipartek.formacion.ejercicios.basicos.iniciales;

/**
 * Programa Java que declare una variable entera N y as�gnale un valor. A
 * continuaci�n escribe las instrucciones que realicen lo siguiente: Incrementar
 * N en 77, Decrementarla en 3, Duplicar su valor.
 * 
 * @author Curso
 *
 */
public class Ejercicio3 {

	public static void main(String[] args) {
		int n = 5;
		System.out.println("Valor de N: " + n);
		n += 77;
		System.out.println("N + 77: " + n);
		n -= 3;
		System.out.println("N - 3: " + n);
		n *= 2;
		System.out.println("N * 2: " + n);
	}

}
