package com.ipartek.formacion.ejercicios.basicos.iniciales;
/*
 * Escribe un programa Java que declare una variable entera N y asígnale un valor. A continuación escribe las instrucciones que realicen los siguientes:
Incrementar N en 77.
Decrementarla en 3.
Duplicar su valor.
Si por ejemplo N = 1 la salida del programa será:*/

public class Ejercicio3 {
	public static void main(String[] args) {
		/*Variables*/
		int n=1;
		
		n+=77;
		System.out.println("Incremento n + 77="+n);
		
		n-=3;
		System.out.println("Decrementarla n - 3="+n);
		
		n*=2;
		System.out.println("Dublicar su valor="+n);
		
	}
	
}
