package com.ipartek.formacion.basicos.iniciales;

/**
 * Programa java que realice lo siguiente: declarar dos variables X e Y de tipo
 * int, dos variables N y M de tipo double y asigna a cada una un valor. A
 * continuación realiza y muestra muestra por pantalla una serie de operaciones
 * entre ellas.
 * 
 * @author Curso
 *
 */
public class Ejercicio2 {

	static int x = 5;
	static int y = 4;
	static double n = 3.1415;
	static double m = 6.8685;

	public static void main(String[] args) {
		
		System.out.println("Operaciones con enteros");
		System.out.println("X + Y = " + (x + y));
		System.out.println("X - Y = " + (x - y));
		System.out.println("X * Y = " + (x * y));
		System.out.println("X / Y = " + (x / y));

		System.out.println("Operaciones con decimales");
		System.out.println("N + M = " + (n + m));
		System.out.println("N - M = " + (n - m));
		System.out.println("N * M = " + (n * m));
		System.out.println("N / M = " + (n / m));

		System.out.println("Operaciones con variables de diferente formato");
		System.out.println("X + N = " + (x + n));
		System.out.println("X - M = " + (y - m));
		System.out.println("X * N = " + (x * n));
		System.out.println("X / M = " + (y / m));
	}

}
