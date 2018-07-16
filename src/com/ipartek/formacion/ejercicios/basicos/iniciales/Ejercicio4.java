package com.ipartek.formacion.ejercicios.basicos.iniciales;

/***
 * Programa java que declare cuatro variables enteras A, B, C y D y asígnale un
 * valor a cada una. A continuación realiza las instrucciones necesarias para
 * que: B tome el valor de C, C tome el valor de A, A tome el valor de D, D tome
 * el valor de B.
 * 
 * @author user
 *
 */
public class Ejercicio4 {
	public static void main(String[] args) {
		int a = 1;
		int b = 3;
		int c = 5;
		int d = 7;
		int copiaA;
		
		System.out.println("Valor inicial de a: " + a);
		System.out.println("Valor inicial de b: " + b);
		System.out.println("Valor inicial de c: " + c);
		System.out.println("Valor inicial de d: " + d);
		
		copiaA = a;
		a = d;
		d = b;
		b = c;
		c = copiaA;
		
		System.out.println("Valor final de a: " + a);
		System.out.println("Valor final de b: " + b);
		System.out.println("Valor final de c: " + c);
		System.out.println("Valor final de d: " + d);
	}
}
