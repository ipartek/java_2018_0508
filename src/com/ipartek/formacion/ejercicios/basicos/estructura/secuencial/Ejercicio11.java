package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.*;

/**
 * Programa que lea un número entero N de 5 cifras y muestre sus cifras igual
 * que en el ejemplo. Por ejemplo para un número N = 12345 La salida debe ser: 1
 * 12 123 1234 12345
 * 
 * @author Curso
 *
 */
public class Ejercicio11 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n;
		System.out.print("Introduce N: ");
		n = sc.nextInt();
		System.out.println(n / 10000);
		System.out.println(n / 1000);
		System.out.println(n / 100);
		System.out.println(n / 10);
		System.out.println(n);

	}

}
