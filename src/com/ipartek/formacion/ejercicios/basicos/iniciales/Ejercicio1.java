package com.ipartek.formacion.ejercicios.basicos.iniciales;

/**
 * Escribe un programa Java que realice lo siguiente: declarar una variable N de tipo int, una variable A de tipo double y una variable C de tipo char y asigna a cada una un valor. A continuación muestra por pantalla:
 * El valor de cada variable.
 * La suma de N + A
 * La diferencia de A - N
 * El valor numérico correspondiente al carácter que contiene la variable C.
 * @author Curso
 *
 */

public class Ejercicio1 {

	public static void main(String[] args) {
		int n = 5;
		double a = 4.56;
		char c = 'a';
		double suma = 0;
		double resta = 0;
		
		System.out.println(n);
		System.out.println(a);
		System.out.println(c);
		
		suma = n + a;
		System.out.println(suma);
		
		resta = a - n;
		System.out.println(resta);
		
		System.out.println("Valor numerico del caracter " + c + " : " + (int)c);
	}
	
}
