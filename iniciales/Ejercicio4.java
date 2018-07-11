package com.ipartek.formacion.ejercicios.basicos.iniciales;

/**
 * Programa java que declare cuatro variables enteras A, B, C y D y asígnale un
 * valor acada una. A continuación realiza las instrucciones necesarias para
 * que: B tome el valor de C, C tome el valor de A, A tome el valor de D, D tome
 * el valor de B.
 * 
 * @author andreaperez
 *
 */
public class Ejercicio4 {

	public static void main(String[] args) {

		int a = 1;
		int b = 2;
		int c = 3;
		int d = 4;
		int temp = b;
		System.out.println("Valores iniciales: ");
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		System.out.println("c: " + c);
		System.out.println("d: " + d);

		System.out.println("Valores finales: ");

		System.out.println("\"b \"toma el valor de \"c\": " + (b = c));
		System.out.println("\"c \"toma el valor de \"a\": " + (c = a));
		System.out.println("\"a \"toma el valor de \"d\": " + (a = d));
		System.out.println("\"d \"toma el valor de \"b\": " + (d = temp));

	}

}
