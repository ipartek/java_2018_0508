package com.ipartek.formacion.basicos.estructura_secuencial;

import java.util.Scanner;

/**
 * Programa que lee por teclado el valor del radio de una circunferencia y
 * calcula y muestra por pantalla la longitud y el área de la circunferencia.
 * Longitud de la circunferencia = 2*PI*Radio, Area de la circunferencia =
 * PI*Radio^2
 * 
 * @author Curso
 *
 */

public class Ejercicio5 {

	static Scanner sc = new Scanner(System.in);
	static int n;

	public static void main(String[] args) {

		System.out.println("Introduzca un radio por teclado:");
		n = sc.nextInt();

		System.out.println("Área de la circunferencia: " + (2 * Math.PI * n));
		System.out.println("Longitud de la circunferencia: " + (Math.PI * Math.pow(n, 2)));
	}

}
