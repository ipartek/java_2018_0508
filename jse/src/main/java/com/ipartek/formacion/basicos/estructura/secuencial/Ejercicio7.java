package com.ipartek.formacion.basicos.estructura.secuencial;

import java.util.Scanner;

/**
 * Programa lea la longitud de los catetos de un triángulo rectángulo y calcule
 * la longitud de la hipotenusa según el teorema de Pitágoras.
 * 
 * @author Curso
 *
 */

public class Ejercicio7 {

	static Scanner sc = new Scanner(System.in);
	static int a;
	static int b;

	public static void main(String[] args) {

		System.out.println("Longitud del cateto A: ");
		a = sc.nextInt();

		System.out.println("Longitud del cateto B: ");
		a = sc.nextInt();

		System.out.println("La hipotenusa de AB es: " + (Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2))));

	}

}
