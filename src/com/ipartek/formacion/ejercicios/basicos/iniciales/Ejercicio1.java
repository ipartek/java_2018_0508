package com.ipartek.formacion.ejercicios.basicos.iniciales;

/**
 * Escribe un programa Java que realice lo siguiente: declarar una variable N de
 * tipo int, una variable A de tipo double y una variable C de tipo char y
 * asigna a cada una un valor. A continuación muestra por pantalla: El valor de
 * cada variable. La suma de N + A La diferencia de A - N El valor numérico
 * correspondiente al carácter que contiene la variable C.
 * 
 * @author Curso
 * 
 *         Variable N = 5 Variable A = 4.56 Variable C = a 5 + 4.56 =
 *         9.559999999999999 4.56 - 5 = -0.4400000000000004 Valor numérico del
 *         carácter a = 97
 */

public class Ejercicio1 {
	public static void main(String[] args) {

		int n = 5;
		double a = 4.809;
		char c = 'a';

		System.out.println("Valor de la variable n = " + n);
		System.out.println("Valor de la variable a = " + a);
		System.out.println("valor de la variable c = " + c);
		System.out.println("La suma de n + a es =  " + n + a);
		System.out.println("La diferencia de a - n = " + (a - n));
		System.out.println("El valor del caracter c = " + c);

	}

}
