package com.ipartek.formacion.ejercicios;

/**
 * 6. Programa Java que declare una variable B de tipo entero y asígnale un<br>
 * valor. A continuación muestra un mensaje indicando si el valor de B es<br>
 * positivo o negativo. Consideraremos el 0 como positivo. Utiliza el operador<br>
 * condicional (? : ) dentro del println para resolverlo.
 * 
 * @author Curso
 *
 */
public class Ejercicio6 {

	public static int b = 6;

	public static void main(String[] args) {

		System.out.println(b + (b >= 0 ? " es positivo" : " es negativo"));
	}

}
