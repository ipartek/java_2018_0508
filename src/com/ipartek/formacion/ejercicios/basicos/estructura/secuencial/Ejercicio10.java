package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
 * Programa Java que lea un número entero de 3 cifras y muestre por separado las
 * cifras del número.
 * 
 * @author valen
 *
 */

public class Ejercicio10 {
	public static void main(String[] args) {
		Scanner p = new Scanner(System.in);
		int numero;
		System.out.println("Ingresa un numero entero con 3 cifras = ");
		numero = p.nextInt();

		System.out.println("La primera cifra es  : " + (numero / 100));
		System.out.println("La segunda cifra es : " + (numero / 10) % 10);
		System.out.println("La tercera cifra es : " + (numero % 10));
	}

}
