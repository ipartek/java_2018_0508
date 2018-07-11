package com.ipartek.formacion.ejercicios.basicos.iniciales;

import java.text.DecimalFormat;

/**
 * Programa java que realice lo siguiente: declarar dos variables X e Y de tipo
 * int, dos variables N y M de tipo double y asigna a cada una un valor. A
 * continuación reliza y muestra por consola una serie de operaciones entre
 * ellas.
 * 
 * @author andreaperez
 *
 */
public class Ejercicio2 {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int x = 5;
		int y = 10;
		double n = 1.5;
		double m = 4.35;
		DecimalFormat df = new DecimalFormat("#.00");

		// Operaciones
		System.out.println("la multiplicacion de " + x + " y " + y + " es: " + (x * y));
		System.out.println("la division entre " + m + " y " + n + " es: " + df.format(m / n));
		System.out.println("la multiplicacion de " + x + " y " + m + " es: " + df.format(x * m));
		System.out.println("la division entre " + y + " y " + n + " es: " + df.format(y / n));

	}

}
