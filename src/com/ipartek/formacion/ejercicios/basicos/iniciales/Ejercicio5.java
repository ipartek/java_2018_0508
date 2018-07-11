package com.ipartek.formacion.ejercicios.basicos.iniciales;

/**
 * Programa Java que declare una variable A de tipo entero y asígnale un valor.
 * A continuación muestra un mensaje indicando si A es par o impar. Utiliza el
 * operador condicional ( ? : ) dentro del println para resolverlo.
 * 
 * @author andreaperez
 *
 */
public class Ejercicio5 {

	public static void main(String[] args) {
		int a = 100;
		System.out.println((a % 2 == 0) ? "El numero " + a + " es PAR" : "El numero " + a + " es IMPAR");
	}

}
