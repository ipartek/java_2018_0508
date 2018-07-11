package com.ipartek.formacion.basicos.iniciales;

/*
 * Programa Java que declare una variable entera N y asígnale un valor. 
 * A continuación escribe las instrucciones que realicen lo siguiente: 
 * --Incrementar N en 77 
 * --Decrementarla en 3
 * --Duplicar su valor. 
 */
public class Ejercicio3 {

	static int n = 100;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("N = " + n);
		n+=77;
		System.out.println("N + 77 = " + n);
		n-=3;
		System.out.println("N - 3 = " + n);
		n*=2;
		System.out.println("N x 2 = " + n);
	}

}
