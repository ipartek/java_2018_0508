package com.ipartek.formacion.ejercicios.basicos.iniciales;

/**
 * Programa java que declare cuatro variables enteras a, b, c y d y asígnale un valor a cada una. A continuación realiza las instrucciones necesarias para que:
 * B tome el valor de C
 * C tome el valor de A
 * A tome el valor de D
 * D tome el valor de B
 * Si por ejemplo A = 1, B = 2, C = 3 y D = 4 el programa debe mostrar:
 * Valores iniciales
 * A = 1
 * B = 2
 * C = 3
 * D = 4
 * Valores finales
 * B toma el valor de C -> B = 3
 * C toma el valor de A -> C = 1
 * A toma el valor de D -> A = 4
 * D toma el valor de B -> D = 2
 * @author Curso
 *
 */

public class Ejercicio4 {
	
	public static void main(String[] args) {
		
		int a = 1;
		int b = 2;
		int c = 3;
		int d = 4;
		int aux;
		
		/* Mostrar los valores de A, B, C y D */
		System.out.println("El valor de A es: " + a);
		System.out.println("El valor de B es: " + b);
		System.out.println("El valor de C es: " + c);
		System.out.println("El valor de D es: " + d);
		
		/* Guardar el contenido de b en aux para no perderlo */
		aux = b;
		
		/* Intercambiar el valor de B por el de C*/
		b = c;
		System.out.println();
		System.out.println("Intercambio el valor de B por el de C: " + b);
		
		/* Intercambiar el valor de C por el de A*/
		c = a;
		System.out.println();
		System.out.println("Intercambio el valor de C por el de A: " + c);
		
		/* Intercambiar el valor de A por el de D*/
		a = d;
		System.out.println();
		System.out.println("Intercambio el valor de A por el de D: " + a);
		
		/* Intercambiar el valor de A por el de D*/
		d = aux;
		System.out.println();
		System.out.println("Intercambio el valor de D por el de B: " + d);
	}
	
}
