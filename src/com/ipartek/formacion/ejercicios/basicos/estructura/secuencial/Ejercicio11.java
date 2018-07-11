package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

/**
 * Programa que lea un número entero N de 5 cifras y muestre sus cifras igual que 
 * en el ejemplo.
 * Por ejemplo para un número N = 12345   La salida debe ser:
 * 1
 * 12
 * 123
 * 1234
 * 12345
 */

import java.util.Scanner;

public class Ejercicio11 {

	public static void main(String[] args) {
		int n;

		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce un numero de 5 cifras");
		n = sc.nextInt();

		System.out.println(n / 10000);
		System.out.println(n / 1000);
		System.out.println(n / 100);
		System.out.println(n / 10);
		System.out.println(n);

		sc.close();
	}

}
