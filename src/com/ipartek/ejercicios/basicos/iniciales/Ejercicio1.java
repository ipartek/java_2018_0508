
//Empezamos con una serie de ejercicios para aquellos que están comenzando desde cero con el lenguaje Java y tampoco tienen experiencia con ningún otro lenguaje de programación. 
//En estos ejercicios básicos inicales se realizan las siguientes instrucciones: declarar variables, asignarles un valor, operar con ellas y mostrar resultados por pantalla.
//Estos ejercicios son todos de estructura secuencial, es decir, no hay condiciones ni bucles. Tampoco se lee nada por teclado. El objetivo es familiarizarse con la declaración
//de variables y practicar la salida por consola utilizando los métodos print y println.


package com.ipartek.ejercicios.basicos.iniciales;

/**
 * Escribe un programa Java que realice lo siguiente: declarar una variable N de tipo int, una variable A de tipo double y una variable C de tipo char y asigna a cada una un valor. A continuación muestra por pantalla:
El valor de cada variable.
La suma de N + A
La diferencia de A - N
El valor numérico correspondiente al carácter que contiene la variable C.
Si por ejemplo le hemos dado a N el valor 5, a A el valor 4.56 y a C el valor ‘a’, se debe mostrar por pantalla:

Variable N = 5
Variable A = 4.56
Variable C = a
5 + 4.56 = 9.559999999999999
4.56 - 5 = -0.4400000000000004
Valor numérico del carácter a = 97
 * @author Curso
 *
 */

public class Ejercicio1 {
	
	public static void main(String[] args) {
		
		int n=5;
		double a=4.56;
		char c='a';
		
		System.out.println("La suma de N+A es: "+(n+a));
		System.out.println("La diferencia de A-N es: "+(a-n));
		System.out.println("El valor del caracter a es: "+(int)(c));
	}

}
