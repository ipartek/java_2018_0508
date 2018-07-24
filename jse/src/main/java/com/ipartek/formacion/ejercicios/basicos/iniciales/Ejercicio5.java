package com.ipartek.formacion.ejercicios.basicos.iniciales;

/**
 * 
 * Escribe un programa java que declare una variable A de tipo entero y asígnale
 * un valor. A continuación muestra un mensaje indicando si A es par o impar.
 * Utiliza el operador condicional ( ? : ) dentro del println para resolverlo.
 * Si por ejemplo A = 14 la salida será 14 es par Si fuese por ejemplo A = 15 la
 * salida será: 15 es impar
 * 
 * @author Curso
 *
 */
public class Ejercicio5 {

	public static void main(String[] args) {

		int a = 14;

		System.out.println("El " + a + " es un numero " + ((a % 2 == 0) ? "PAR" : "IMPAR"));

		a = 15;
		
		System.out.println("El " + a + " es un numero " + ((a % 2 == 0) ? "PAR" : "IMPAR"));
	}

}
