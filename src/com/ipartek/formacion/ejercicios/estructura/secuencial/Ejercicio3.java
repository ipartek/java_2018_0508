package com.ipartek.formacion.ejercicios.estructura.secuencial;

import java.util.Scanner;

/**
 * Escribe un programa Java que lee un número entero por teclado y obtiene y muestra por pantalla el doble y el triple de ese número.
 * @author Curso
 *
 */

public class Ejercicio3 {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		int n1;
		
		System.out.println("Escribe un numero:");
		n1 = teclado.nextInt();
		
		System.out.println();
		System.out.println("El numero introducido es: " + n1);
		System.out.println("El doble de " + n1 + " es: " + n1*2);
		System.out.println("El triple de " + n1 + " es: " + n1*3);

		teclado.close();
	}

}
