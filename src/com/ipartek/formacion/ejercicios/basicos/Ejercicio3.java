package com.ipartek.formacion.ejercicios.basicos;

/**
 * Escribe un programa Java que declare una variable entera <b>n</b> y asígnale un valor. A continuación escribe las <br>
 * instrucciones que realicen los siguientes:<br>
 *  Incrementar N en 77.<br>
 *  Decrementarla en 3.<br>
 *  Duplicar su valor.<br>
 *  Si por ejemplo N = 1 la salida del programa será:<br>
 *  Valor inicial de N = 1<br>
 *  N + 77 = 78<br>
 *  N - 3 = 75<br>
 *  N * 2 = 150<br>
 * @author Curso
 *
 */

public class Ejercicio3 {
	public static void main(String[] args){
		int n=1;
		System.out.println("Variable N = " + n);
		n+=77;
	    System.out.println("N + 77 = " + n);
	    n-=3;
	    System.out.println("N - 3 = " + n);
	    n*=2;
	    System.out.println("N * 2 = " + n);
	}
}
