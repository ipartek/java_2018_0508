package com.ipartek.formacion.ejercicios.basicos.iniciales;

/**
 * Escribe un programa java que declare una variable C de tipo entero y asígnale
 * un valor. A continuación muestra un mensaje indicando si el valor de C es
 * positivo o negativo, si es par o impar, si es múltiplo de 5, si es múltiplo
 * de 10 y si es mayor o menor que 100. Consideraremos el 0 como positivo.
 * Utiliza el operador condicional ( ? : ) dentro del println para resolverlo.
 * Si por ejemplo C = 55 la salida será 55 es positivo 55 es impar 55 es
 * múltiplo de 5 55 no es múltiplo de 10 55 es menor que 100
 * 
 * @author Curso
 *
 */
public class Ejercicio7 {

	public static void main(String[] args) {

		int c = -35;

		System.out.println("El " + c + " es un numero " + ((c % 2 == 0) ? "PAR" : "IMPAR"));

		System.out.println("El " + c + " es un numero " + ((c % 5 == 0) ? "MULTIPO DE 5" : "NO MULTIPO DE 5"));

		System.out.println("El " + c + " es un numero " + ((c % 10 == 0) ? "MULTIPO DE 10" : "NO MULTIPO DE 10"));

		System.out.println("El " + c + " es un numero " + ((c >= 100) ? "MAYOR QUE 100" : "MENOR QUE 100"));
	}
}
