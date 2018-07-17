package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/***
 * Programa Java que lee un número entero por teclado y obtiene y muestra por
 * pantalla el doble y el triple de ese número.
 * 
 * @author user
 *
 */
public class Ejercicio3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numero;

		Scanner sc = new Scanner(System.in);

		System.out.println("Introduzca un numero entero: ");
		numero = sc.nextInt();

		System.out.println("El doble de " + numero + " es" + numero * 2);
		System.out.println("El triple de " + numero + " es" + numero * 3);

		sc.close();

	}

}
