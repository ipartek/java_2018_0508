package com.ipartek.formacion.basicos.iniciales;

/**
 * Programa java que realice lo siguiente: declarar una variable N de tipo int,
 * una variable A de tipo double y una variable C de tipo char y asigna a cada
 * una un valor. A continuación muestra por pantalla: --El valor de cada
 * variable --La suma de N + A --La diferencia de A - N --El valor numérico
 * correspondiente al carácter que contiene la variable C.
 * 
 * @author Curso
 *
 */
public class Ejercicio1 {

	static int n = 10;
	static double a = 3.1416;
	static char c = 'E';

	public static void main(String[] args) {

		System.out.println("N = " + n);
		System.out.println("A = " + a);
		System.out.println("C = " + c);
		System.out.println("N + A = " + (n + a));
		System.out.println("N - A = " + (n - a));
		System.out.println("C Value = " + Integer.valueOf(c));
	}

}
