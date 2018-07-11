package com.ipartek.formacion.ejercicios.basicos.iniciales;

/**
 * Programa java que declare cuatro variables enteras A, B, C y D y asígnale un
 * valor a cada una. A continuación realiza las instrucciones necesarias para
 * que: B tome el valor de C C tome el valor de A A tome el valor de D D tome el
 * valor de B Si por ejemplo A = 1, B = 2, C = 3 y D = 4 el programa debe
 * mostrar: Valores iniciales A = 1 B = 2 C = 3 D = 4 Valores finales B toma el
 * valor de C -> B = 3 C toma el valor de A -> C = 1 A toma el valor de D -> A =
 * 4 D toma el valor de B -> D = 2
 * 
 * @author Curso
 *
 */
public class Ejercicio4 {
	public static void main(String[] args) {
		int a = 1;
		int b = 1;
		int c = 4;
		int d = 8;
		int aux;

		System.out.println("El valor de a = " + a);
		System.out.println("El valor de b = " + b);
		System.out.println("El valor de c = " + c);
		System.out.println("El valor de d = " + d);

		aux = b;
		b = c;
		c = a;
		a = d;
		d = aux;

		System.out.println("b y c -> b = " + b);
		System.out.println("c y a -> c = " + c);
		System.out.println("a y d -> a = " + a);
		System.out.println("d y d -> b = " + a);

	}

}
