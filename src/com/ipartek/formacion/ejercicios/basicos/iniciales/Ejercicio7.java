package com.ipartek.formacion.ejercicios.basicos.iniciales;

/**
 * Escribe un programa java que declare una variable C de tipo entero y asígnale
 * un valor. A continuación muestra un mensaje indicando si el valor de C es
 * positivo o negativo, si es par o impar, si es múltiplo de 5, si es múltiplo
 * de 10 y si es mayor o menor que 100. Consideraremos el 0 como positivo.
 * Utiliza el operador condicional ( ? : ) dentro del println para resolverlo.
 * 
 * @author Curso
 *
 */

public class Ejercicio7 {

	public static void main(String[] args) {
		int c = 5;

		if (c < 0) {
			System.out.println("Este numero es negativo");
		} else {
			System.out.println("Este numero es positivo");
		}

		if (c % 2 == 0) {
			System.out.println("Este numero es par");
		} else {
			System.out.println("Este numero es impar");
		}

		if (c % 5 == 0) {
			System.out.println("Es multiplo de 5");
		} else {
			System.out.println("No es multiplo de 5");
		}

		if (c % 10 == 0) {
			System.out.println("Es multiplo de 10");
		} else {
			System.out.println("No es multiplo de 10");
		}

		if (c < 100) {
			System.out.println("Es menor que 100");
		} else {
			System.out.println("Es mayor que 100");
		}

	}

}
