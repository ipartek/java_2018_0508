package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
 * 
 * 
 * @author Asier Cornejo
 * 
 *         Programa que lee un número de 3 cifras y muestra sus cifras por
 *         separado.
 *
 */
public class Ejercicio10 {
	public static void main(String[] args) {
		int num = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca un número de 3 cifras: ");
		num = sc.nextInt();
		System.out.println("Primera cifra de " + num + " -> " + (num / 100));
		System.out.println("Segunda cifra de " + num + " -> " + (num / 10) % 10);
		System.out.println("Última cifra  de " + num + " -> " + (num % 10));

	}

}
