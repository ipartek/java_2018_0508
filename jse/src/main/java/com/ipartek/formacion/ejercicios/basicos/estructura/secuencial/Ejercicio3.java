package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.*;

/**
 * Escribe un programa Java que lee un número entero por teclado y obtiene y
 * muestra por pantalla el doble y el triple de ese número.
 * 
 * @author Curso
 *
 */

public class Ejercicio3 {

	public static void main(String[] args) {

		int n;

		Scanner sc = new Scanner(System.in);

		System.out.print("Introduce un numero: ");
		n = sc.nextInt();

		System.out.println("El doble de " + n + " es " + n * 2 + " y el triple " + n * 3);

		sc.close();

	}

}
