package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
 * 1. Programa Java que lea dos números enteros por teclado y los muestre<br>
 * por pantalla.
 * 
 * @author Curso
 *
 */
public class Ejercicio1 {

	public static int a, b;
	private static Scanner scan;

	public static void main(String[] args) {

		scan = new Scanner(System.in);

		System.out.println("Introduce un numero: ");

		a = scan.nextInt();

		System.out.println("Introduce otro numero: ");

		b = scan.nextInt();

		System.out.println("Has introducido los numeros " + a + " y " + b);

	}

}
