package com.ipartek.formacion.ejercicios.basicos.iniciales;

/**
 * Programa Java que declare una variable C de tipo entero y asígnale un valor.
 * A continuación muestra un mensaje indicando si el valor de C es positivo o
 * negativo, si es par o impar, si es múltiplo de 5, si es múltiplo de 10 y si
 * es mayor o menor que 100. Consideraremos el 0 como positivo. Utiliza el
 * operador condicional ( ? : ) dentro del println para resolverlo.
 * 
 * @author andreaperez
 *
 */
public class Ejercicio7 {

	public static void main(String[] args) {
		int c = -100;
		System.out.println("El numero " + c + " es " + (c >= 0 ? "positivo" : "negativo"));
		System.out.println("El numero " + c + " es " + (c % 2 == 0 ? "par" : "impar"));
		System.out.println("El numero " + c + (c % 5 == 0 ? " es multiplo de 5" : " no es multiplo de 5"));
		System.out.println("El numero " + c + (c % 10 == 0 ? " es multiplo de 10" : " no es multiplo de 10"));
		System.out.println("El numero " + c + " es " + (c > 100 ? "mayor que 100" : "menor que 100"));
	}

}
