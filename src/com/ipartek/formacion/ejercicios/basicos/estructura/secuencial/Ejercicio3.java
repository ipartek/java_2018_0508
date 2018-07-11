package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
 * 
 * @author Asier Cornejo
 * 
 *         Programa Java que lee un número entero por teclado y obtiene y
 *         muestra por pantalla el doble y el triple de ese número.
 */
public class Ejercicio3 {

	public static void main(String[] args) {
		int num = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca un número entero");
		num = sc.nextInt();
		System.out.println(
				"El número introducido es: " + num + " , su doble es: " + num * 2 + " y su triple es: " + num * 3);
	}

}
