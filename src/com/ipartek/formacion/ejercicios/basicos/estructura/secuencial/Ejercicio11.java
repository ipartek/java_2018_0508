package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
 * Programa que lea un número entero N de 5 cifras y muestre sus cifras igual
 * que en el ejemplo. Por ejemplo para un número N = 12345 La salida debe ser: 1
 * 12 123 1234 12345
 * 
 * @author valen
 *
 */

public class Ejercicio11 {
	public static void main(String[] args) {
		Scanner p = new Scanner(System.in);
		int numeros;
		System.out.println("Ingrese un numero entero de 5 cifras : ");
		numeros = p.nextInt();
		System.out.println("Una cifra : " + (numeros / 10000));
		System.out.println("Dos cifras : " + (numeros / 1000));
		System.out.println("Tres cifras : " + (numeros / 100));
		System.out.println("Cuatro cifras: " + (numeros / 10));
		System.out.println("Cinco cifras : " + (numeros / 1));
	}

}
