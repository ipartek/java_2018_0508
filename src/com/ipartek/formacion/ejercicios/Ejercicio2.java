package com.ipartek.formacion.ejercicios;

/**
 * 2. Programa java que realice lo siguiente: declarar dos variables X e Y de tipo int, <br>
 * dos variables N y M de tipo double y asigna a cada una un valor. A continuación reliza <br>
 * y muestra muestra por pantalla una serie de operaciones entre ellas.
 */

public class Ejercicio2 {

	public static int x = 2, y = 4;
	public static double n = 15, m = 25;

	public static void main(String[] args) {

		System.out.println("x= " + x + " y= " + y + " n= " + n + " m= " + m);
		System.out.println("x + y = " + (x + y));
		System.out.println("x - y = " + (y - x));
		System.out.println("m : x = " + (m / x));
		System.out.println("n * x = " + (n * x));
		System.out.println("n % m = " + (n % m));

	}

}
