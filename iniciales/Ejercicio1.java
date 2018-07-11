package com.ipartek.formacion.ejercicios.basicos.iniciales;

/**
 * 
 * Programa java que realice lo siguiente: declarar una variable <b>n</b> de tipo int,
 * una variable <b>a</b> de tipo double y una variable <b>c</b> de tipo char. asigna a cada
 * una un valor.
 * 
 * @author andreaperez
 *
 */

public class Ejercicio1 {

	public static void main(String[] args) {

		int n = 5;
		double a = 2.5;
		char c = 'a';

		// mostrar por pantalla: El valor de cada variable.
		System.out.println("valor de numero es: " + n);
		System.out.println("valor del decimal es: " + a);
		System.out.println("valor del caracter es : " + c);

		// la suma de N + * A.
		System.out.println("La suma de " + n + " y " + a + " es: " + (n + a));

		// la diferencia de A - N
		System.out.println("La diferencia entre " + a + " y " + n + " es: " + (a - n));

		// el valor numerico correspondiente al caracter que contiene la variable C.
		System.out.println("el valor numérico de la variable \"" + c + "\" es: " + (int) c);
	}

}
