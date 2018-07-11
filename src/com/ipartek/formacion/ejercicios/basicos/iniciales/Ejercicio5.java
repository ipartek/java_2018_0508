package com.ipartek.formacion.ejercicios.basicos.iniciales;

/**
 * Escribe un programa java que declare una variable A de tipo entero y asígnale
 * un valor. A continuación muestra un mensaje indicando si A es par o impar.
 * Utiliza el operador condicional ( ? : ) dentro del println para resolverlo.
 * 
 * @author Curso
 *
 */

public class Ejercicio5 {

	public static void main(String[] args) {
		int A = 15;

		if (A % 2 == 0) {
			System.out.println("Es par");
		} else {
			System.out.println("Es impar");
		}
	}

}
