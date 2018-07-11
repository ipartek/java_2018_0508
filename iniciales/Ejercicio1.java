package com.ipartek.formacion.ejercicios.basicos.iniciales;

/**
 * Escribe un programa Java que realice lo siguiente: declarar una variable <b>n<b> de tipo int, una variable <b>a</b> de tipo double y una variable <b>c</c> de tipo char y asigna a cada una un valor. A continuación muestra por pantalla:
 * El valor de cada variable.
 * La suma de N + A
 * La diferencia de A - N
 * El valor numérico correspondiente al carácter que contiene la variable C.
 * Si por ejemplo le hemos dado a N el valor 5, a A el valor 4.56 y a C el valor ‘a’, se debe mostrar por pantalla:
 *
 * Variable N = 5 <br>
 * Variable A = 4.56 <br>
 * Variable C = a <br>
 * 5 + 4.56 = 9.559999999999999 <br>
 * 4.56 - 5 = -0.4400000000000004 <br>
 * Valor numérico del carácter a = 97 <br>
 * @author Curso
 *
 */

public class Ejercicio1 {

	public static void main(String[] args) {
		
		int n = 5;
		double a = 4.56;
		char c = 'a';
		
		/* Mostrar contenido de cada variable */
		System.out.println("El contenido de N es: " + n);
		System.out.println("El contenido de A es: " + a);
		System.out.println("El contenido de C es: " + c);
		
		/* La suma de N + A */
		System.out.println();
		System.out.println(n + " + " + a + " = " + (n + a));
		
		/* La diferencia entre A - N */
		System.out.println();
		System.out.println(a + " - " + n + " = " + (a - n));

		/* El valor numerico de C */
		System.out.println();
		System.out.println("El valor numerico de " + c + " es: " + (int)c);
	}

}
