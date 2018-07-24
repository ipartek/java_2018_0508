package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
 * 
 * 3. Escribe un programa Java que lee un número entero por teclado y obtiene y
 * muestra por pantalla el doble y el triple de ese número.
 * 
 * @author Curso
 *
 */
public class Ejercicio03 {

	public static void main(String[] args) {

		int n1;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce un número entero: ");
		n1 = sc.nextInt();
		System.out.println("El doble de " + n1 + " es " + (n1 * 2) + "\nY el triple es " + n1 * 3);
		sc.close();

	}

}
