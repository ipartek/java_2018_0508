package com.ipartek.formacion.ejercicios.basicos.iniciales;

/**
 * Escribe un programa java que declare una variable B de tipo entero y asígnale
 * un valor. A continuación muestra un mensaje indicando si el valor de B es
 * positivo o negativo. Consideraremos el 0 como positivo. Utiliza el operador
 * condicional ( ? : ) dentro del println para resolverlo.
 * 
 * @author Curso
 *
 */

public class Ejercicio6 {

	public static void main(String[] args) {
		int b = -1;

		if (b > 0) {
			System.out.println("Este numero es positivo.");
		} else {
			System.out.println("Este numero es negativo");
		}
	}

}
