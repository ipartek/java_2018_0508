package com.ipartek.formacion.ejercicios.basicos.iniciales;

/***
 * Programa Java que declare una variable A de tipo entero y asígnale un valor.
 * A continuación muestra un mensaje indicando si A es par o impar. Utiliza el
 * operador condicional ( ? : ) dentro del println para resolverlo.
 * 
 * @author user
 *
 */

public class Ejercicio5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 27;

		System.out.println("El numero " + a + " es " + ((a % 2 == 0) ? "par" : "impar"));

		a = 26;

		System.out.println("El numero " + a + " es " + ((a % 2 == 0) ? "par" : "impar"));
	}

}
