package com.ipartek.formacion.ejercicios.basicos.iniciales;

/**
 * 
 * @author Curso 7. Programa Java que declare una variable C de tipo entero y
 *         asígnale un valor. A continuación muestra un mensaje indicando si el
 *         valor de C es positivo o negativo, si es par o impar, si es múltiplo
 *         de 5, si es múltiplo de 10 y si es mayor o menor que 100.
 *         Consideraremos el 0 como positivo. Utiliza el operador condicional (
 *         ? : ) dentro del println para resolverlo.
 */
public class Ejercicio7 {
	public static void main(String[] args) {
		int c = 200;
		System.out.println(c + (c > 0 ? " Es positivo" : " Es negativo"));
		System.out.println(c + (c % 2 == 0 ? " Es par" : " Es impar"));
		System.out.println(c + (c % 5 == 0 ? " Es multiplo de 5" : " No es multiplo de 5"));
		System.out.println(c + (c % 10 == 0 ? " Es multiplo de 10" : " No es multiplo de 10"));
		System.out.println(c + (c > 100 ? " Es mayor de 100" : " No es mayor de 100"));
	}
}
