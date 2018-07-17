package com.ipartek.formacion.ejercicios.basicos.iniciales;

/***
 * Programa Java que declare una variable B de tipo entero y asígnale un valor.
 * A continuación muestra un mensaje indicando si el valor de B es positivo o
 * negativo. Consideraremos el 0 como positivo. Utiliza el operador condicional
 * (? : ) dentro del println para resolverlo.
 * 
 * @author user
 *
 */
public class Ejercicio6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int b = 10;
		System.out.println("El numero " + b + " es un numero " + ((b >= 0) ? "positivo" : "negativo"));

		b = -10;
		System.out.println("El numero " + b + " es un numero " + ((b >= 0) ? "positivo" : "negativo"));
	}

}
