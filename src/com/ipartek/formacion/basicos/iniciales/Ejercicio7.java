package com.ipartek.formacion.basicos.iniciales;

/**
 * Programa Java que declare una variable C de tipo entero y asígnale un valor.
 * A continuación muestra un mensaje indicando si el valor de C es positivo o
 * negativo, si es par o impar, si es múltiplo de 5, si es múltiplo de 10 y si
 * es mayor o menor que 100. Consideraremos el 0 como positivo. Utiliza el
 * operador condicional ( ? : ) dentro del println para resolverlo.
 * 
 * @author Curso
 *
 */
public class Ejercicio7 {

	static int c = 100;

	public static void main(String[] args) {

		System.out.println(c < 0 ? "El número es negativo." : "El número es positivo.");
		System.out.println(c % 2 == 0 ? "El número es par." : "El número es impar.");
		System.out.println(c % 5 == 0 ? "El número es múltiplo de 5." : "El número no es múltiplo de 5.");
		System.out.println(c % 10 == 0 ? "El número es múltiplo de 10." : "El número no es múltiplo de 10.");
		System.out.println(c > 100 ? "El número es mayor que 100." : "El número es menor que 100.");
	}

}
