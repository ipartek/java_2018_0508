package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
 * Programa Java que lea un número entero N de 5 cifras y muestre sus cifras
 * igual que en el ejemplo. Por ejemplo para un número N = 12345 La salida debe
 * ser:
 * 
 * @author valen
 *
 */
public class Ejercicio12 {
	public static void main(String[] args) {

		Scanner o = new Scanner(System.in);
		int numeros = 0;
		System.out.println("Ingresa un numero entero de cinco cifras = ");
		numeros = o.nextInt();
		System.out.println("La primera cifra de la ultima posicion = " + (numeros % 10));
		System.out.println("Las dos ultimas cifras de la ultima posicion = " + (numeros % 100));
		System.out.println("Las tres ultimas cifras de la ultima posicion = " + (numeros % 1000));
		System.out.println("Las cuatro ultimas cifras de la ultima posicion = " + (numeros % 10000));
		System.out.println("Las cinco cifras = " + (numeros % 100000));

	}

}
