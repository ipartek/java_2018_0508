package com.ipartek.formacion.ejercicios;

/**
 * 5. Programa Java que declare una variable A de tipo entero y asígnale un<br>
 * valor. A continuación muestra un mensaje indicando si A es par o impar.<br>
 * Utiliza el operador condicional ( ? : ) dentro del println para resolverlo.
 * 
 * @author Curso
 *
 */
public class Ejercicio5 {

	public static int a = 4;

	public static void main(String[] args) {
		System.out.println(a + (a % 2 == 0 ? " es par " : " es impar "));
	}
}
