package com.ipartek.formacion.ejercicios.basicos.iniciales;

/**
 * 
 * @author Asier Cornejo
 * 
 *         Programa Java que declare una variable A de tipo entero y asígnale un
 *         valor. A continuación muestra un mensaje indicando si A es par o
 *         impar. Utiliza el operador condicional ( ? : ) dentro del println
 *         para resolverlo.
 *
 */
public class Ejercicio5 {

	public static void main(String[] args) {

		int a = 11;
		System.out.println((a % 2 == 0) ? "El valor de la variable a es: PAR" : "El valor de la variable a es: IMPAR");

	}

}
