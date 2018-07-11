package com.ipartek.formacion.basicos.iniciales;

/**
 * Programa java que declare cuatro variables enteras A, B, C y D y asígnale un
 * valor a cada una. A continuación realiza las instrucciones necesarias para
 * que: --B tome el valor de C. --C tome el valor de A. --A tome el valor de D.
 * --D tome el valor de B.
 * 
 * @author Curso
 *
 */
public class Ejercicio4 {

	static int a = 10;
	static int b = 9;
	static int c = 1;
	static int d = 2;
	static int aux;

	public static void main(String[] args) {

		System.out.println("Valores iniciales:");
		System.out.print("A = " + a + "\t");
		System.out.print("B = " + b + "\t");
		System.out.print("C = " + c + "\t");
		System.out.print("D = " + d + "\n");

		aux = b;
		b = c;
		c = a;
		a = d;
		d = aux;

		System.out.println("Valores intercambiados:");
		System.out.print("A = " + a + "\t");
		System.out.print("B = " + b + "\t");
		System.out.print("C = " + c + "\t");
		System.out.print("D = " + d + "\n");

	}

}
