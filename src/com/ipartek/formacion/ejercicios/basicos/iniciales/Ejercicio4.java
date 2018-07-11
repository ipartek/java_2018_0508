package com.ipartek.formacion.ejercicios.basicos.iniciales;

/**
 * Programa java que declare cuatro variables enteras A, B, C y D y asígnale un
 * valor a cada una. A continuación realiza las instrucciones necesarias para
 * que: 
 * B tome el valor de C 
 * C tome el valor de A 
 * A tome el valor de D 
 * D tome el valor de B
 * 
 * @author Curso
 *
 */

public class Ejercicio4 {

	public static void main(String[] args) {
		int A;
		int B;
		int C;
		int D;
		int copa_vacia;

		A = 1;
		B = 2;
		C = 3;
		D = 4;
		copa_vacia = 0;

		copa_vacia = copa_vacia + B;

		B = C;
		System.out.println(B);

		C = A;
		System.out.println(C);

		A = D;
		System.out.println(A);

		D = copa_vacia;
		System.out.println(D);
	}

}
