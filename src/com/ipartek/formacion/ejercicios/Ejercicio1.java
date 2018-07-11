package com.ipartek.formacion.ejercicios;

/**
 * 
 * 1. Programa java que realice lo siguiente: declarar una variable N de tipo int, <br>
 * una variable A de tipo double y una variable C de tipo char y asigna a cada una <br>
 * un valor. A continuación muestra por pantalla: El valor de cada variable, la suma <br>
 * de N + A, la diferencia de A - N, el valor numérico correspondiente al carácter <br>
 * que contiene la variable C.
 * 
 */

public class Ejercicio1 {

	public static int n = 1;
	public static double a = 10;
	public static char c = 'c';

	public static void main(String[] args) {

		System.out.println("N " + "= " + n + " A " + "= " + a + " C " + "= " + c);

		System.out.println("La suma entre N y A es: " + (n + a));

		System.out.println("La diferencia entre N y A es: " + (a - n));

		System.out.println("El valor numerico de (c) es: " + (int) c);
	}

}
