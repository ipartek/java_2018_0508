package com.ipartek.formacion.ejercicios.basicos.iniciales;

/**
* Escribe un programa Java que declare una variable entera N y asígnale un valor. 
* A continuación escribe las instrucciones que realicen los siguientes:
* Incrementar N en 77.
* Decrementarla en 3.
* Duplicar su valor.
* Si por ejemplo N = 1 la salida del programa será:
* Valor inicial de N = 1
* N + 77 = 78
* N - 3 = 75
* N * 2 = 150
*/
public class Ejercicio3 {

	public static void main(String[] args) {
		
		
		int n = 1;
		
		System.out.println("Valor inicial de N = " + n);
		System.out.println("Incremento de 77 = " + (n += 77));
		System.out.println("Decremento de 3 = " + (n -= 3));
		System.out.println("Duplicar su valor = " + (n *= 2));

	}

}
