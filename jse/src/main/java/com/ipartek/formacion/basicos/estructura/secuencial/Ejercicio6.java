package com.ipartek.formacion.basicos.estructura.secuencial;

import java.util.Scanner;

/**
 * Programa que pase una velocidad en Km/h a m/s. La velocidad se lee por
 * teclado.
 * 
 * @author Curso
 *
 */

public class Ejercicio6 {

	static Scanner sc = new Scanner(System.in);
	static int n;

	public static void main(String[] args) {

		System.out.println("Introduzca velocidad en Km/h:");
		n = sc.nextInt();

		System.out.println(n + "Km/h = " + n * 0.28f + "m/s");

	}

}
