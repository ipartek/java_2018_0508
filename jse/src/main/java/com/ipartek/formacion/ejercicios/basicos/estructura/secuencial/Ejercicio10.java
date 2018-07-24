package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.*;

/**
 * Programa Java que lea un número entero de 3 cifras y muestre por separado las
 * cifras del número
 * 
 * @author Curso
 *
 */
public class Ejercicio10 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n;

		System.out.print("Introduce numero de tres cifras: ");
		n = sc.nextInt();

		System.out.println("Primera cifra: " + (n / 100));
		System.out.println("Segunda cifra: " + (n / 10) % 10);
		System.out.println("Tercera cifra: " + (n % 10));

		sc.close();
	}

}
