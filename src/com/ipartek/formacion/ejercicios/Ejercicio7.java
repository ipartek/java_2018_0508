package com.ipartek.formacion.ejercicios;

/**
 * 7. Programa Java que declare una variable C de tipo entero y asígnale un<br>
 * valor. A continuación muestra un mensaje indicando si el valor de C es<br>
 * positivo o negativo, si es par o impar, si es múltiplo de 5, si es múltiplo<br>
 * de 10 y si es mayor o menor que 100. Consideraremos el 0 como positivo.<br>
 * Utiliza el operador condicional ( ? : ) dentro del println para resolverlo.<br>
 * 
 * @author Curso
 *
 */
public class Ejercicio7 {
	
	public static int c = 7;

	public static void main(String[] args) {
		
		System.out.println(c+(c >= 0 ? " es positivo" : " es negativo"));
		System.out.println(c+(c % 2 == 0 ? " es par" : " es impar"));
		System.out.println(c+(c % 5 == 0 ? " es multiplo de 5" : " no es multiplo de 5"));
		System.out.println(c+(c % 10 == 0 ? " es multiplo de 10" : " no es multiplo de 10"));
		System.out.println(c+(c >= 100 ? " es mayor que 100" : " es menor que 100"));

	}

}
