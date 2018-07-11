package com.ipartek.formacion.ejercicios.basicos.iniciales;

/**
 * Escribe un programa java que declare una variable a de tipo entero y asígnale un valor. A continuación muestra un mensaje indicando si A es par o impar. Utiliza el operador condicional ( ? : ) dentro del println para resolverlo.
 * Si por ejemplo A = 14 la salida será
 * 14 es par
 * Si fuese por ejemplo A = 15 la salida será:
 * 15 es impar
 * @author Curso
 *
 */

public class Ejercicio5 {

	public static void main(String[] args) {
		
		int a = 14;
		int b = 15;
		
		String estado = (a%2 == 0)? "Par" : "Impar";
		System.out.println("El numero " + a + " es " + estado);
		
		String estado2 = (b%2 == 0)? "Par" : "Impar";
		System.out.println("El numero " + b + " es " + estado2);

	}

}
