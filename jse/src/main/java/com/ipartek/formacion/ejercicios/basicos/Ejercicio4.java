package com.ipartek.formacion.ejercicios.basicos;

/**
 * Programa java que declare cuatro variables enteras <b>a</b>, <b>b</b>,
 * <b>c</b> y <b>d</b> y asígnale un valor a cada una.<br>
 * A continuación realiza las instrucciones necesarias para que:<br>
 * B tome el valor de C<br>
 * C tome el valor de A<br>
 * A tome el valor de D<br>
 * D tome el valor de B<br>
 * Si por ejemplo A = 1, B = 2, C = 3 y D = 4 el programa debe mostrar:<br>
 * Valores iniciales<br>
 * A = 1<br>
 * B = 2<br>
 * C = 3<br>
 * D = 4<br>
 * Valores finales<br>
 * B toma el valor de C -> B = 3<br>
 * C toma el valor de A -> C = 1<br>
 * A toma el valor de D -> A = 4<br>
 * D toma el valor de B -> D = 2<br>
 * 
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

		System.out.println("Valor inicial de A: " + a);
		
		System.out.println("Valor inicial de B: " + b);
		
		System.out.println("Valor inicial de C: " + c);
		
		System.out.println("Valor inicial de D: " + d);
		
		System.out.println("------------------- ");

		aux = b;
		b = c;
		c = a;
		a = d;
		d = aux;

		System.out.println("Valor final de A: " + a);
		
		System.out.println("Valor final de B: " + b);
		
		System.out.println("Valor final de C: " + c);
		
		System.out.println("Valor final de D: " + d);

	}

}
