package com.ipartek.formacion.ejercicios.basicos.iniciales;

/***
 * Programa java que declare cuatro variables enteras A, B, C y D y asígnale un
 * valor a cada una. A continuación realiza las instrucciones necesarias para
 * que: B tome el valor de C <br>
 * C tome el valor de A <br>
 * A tome el valor de D<br>
 * D tome el valor de B<br>
 */

public class Ejercicio4 {

	public static void main(String[] args) {

		int a = 1;
		int b = 2;
		int c = 3;
		int d = 4;
		int b_tmp = b;
		b = c;
		c = a;
		a = d;
		d = b_tmp;
		System.out.println(a + ", " + b + ", " + c + ", " + d);

	}

}
