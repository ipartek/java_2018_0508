package com.ipartek.formacion.ejercicios.basicos.iniciales;

/**
 * Programa Java que declare una variable B de tipo entero y asígnale un valor.
 * A continuación muestra un mensaje indicando si el valor de B es positivo o
 * negativo. Consideraremos el 0 como positivo. Utiliza el operador condicional
 * (? : ) dentro del println para resolverlo.
 * 
 * @author andreaperez
 *
 */
public class Ejercicio6 {

	public static void main(String[] args) {
		int b = -23;
		System.out.println("El numero " + b + " es " + (b >= 0 ? " positivo" : "negativo"));
	}

}
