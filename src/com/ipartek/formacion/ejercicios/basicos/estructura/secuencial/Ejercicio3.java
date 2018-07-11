package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

/**
 * Escribe un programa Java que lee un número entero por teclado y obtiene y 
 * muestra por pantalla el doble y el triple de ese número.
 */

import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {

		int numero;

		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce un numero: ");
		numero = sc.nextInt();

		System.out.println(
				"tu numero es: " + numero + " , el doble es: " + (numero * 2) + " y el triple: " + (numero * 3));

		sc.close();
	}

}
