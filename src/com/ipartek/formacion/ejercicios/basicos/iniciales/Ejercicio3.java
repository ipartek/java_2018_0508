package com.ipartek.formacion.ejercicios.basicos.iniciales;

/**
 * Escribe un programa Java que declare una variable entera n y asígnale un valor. A continuación escribe las instrucciones que realicen los siguientes:
 * Incrementar N en 77.
 * Decrementarla en 3.
 * Duplicar su valor.
 * @author Curso
 *
 */

public class Ejercicio3 {
	public static void main(String[] args) {
		
		int n = 1;
		
		System.out.println("Valor inicial de n: " + n);
		
		/* Incrementar valor de N en 77*/
		n += 77;
		System.out.println("n + 77" + " = " + n);
		/* Decrementar valor de N en 3*/
		n -= 3;
		System.out.println("n - 3" + " = " + n);
		/* Duplicar valor de N*/
		n *= 2;
		System.out.println("n * 2" + " = " + n);
	}
}
