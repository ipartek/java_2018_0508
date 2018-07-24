package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

/**
 * Ejercicio 12: Programa Java que lea un número entero N de 5 cifras y muestre
 * sus cifras igual que en el ejemplo. Por ejemplo para un número N = 12345 La
 * salida debe ser:
 * 
 * 5 45 345 2345 12345
 * 
 * @author Curso
 *
 */
public class Ejercicio12 {

	public static void main(String[] args) {

		int n = 12345;
		
		System.out.println(n%10);
		System.out.println(n%100);
		System.out.println(n%1000);
		System.out.println(n%10000);
		System.out.println(n);

	}

}
