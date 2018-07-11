package com.ipartek.formacion.ejercicios;

/**
 * 4. Programa java que declare cuatro variables enteras A, B, C y D y asígnale<br>
 * un valor acada una. A continuación realiza las instrucciones necesarias para<br>
 * que: B tome el valor de C, C tome el valor de A, A tome el valor de D, D tome<br>
 * el valor de B.
 * 
 * @author Curso
 *
 */
public class Ejercicio4 {

	public static int a = 1, b = 2, c = 3, d = 4, aux;

	public static void main(String[] args) {

		System.out.println("ANTES DE CAMBIAR NADA =>> a=" + a + " b=" + b + " c=" + c + " d=" + d + " aux=" + aux);

		aux = d;
		d = b;
		b = aux;
		aux = c;
		c = a;
		a = b;
		b = aux;

		System.out.println("CAMBIADO =>> a=" + a + " b=" + b + " c=" + c + " d=" + d + " aux=" + aux);

	}

}
