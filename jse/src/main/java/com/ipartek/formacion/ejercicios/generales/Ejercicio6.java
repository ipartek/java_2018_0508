package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/***
 * Comprobar si un número es perfecto.
 * 
 * @author Curso
 *
 */
public class Ejercicio6 {

	public static void main(String[] args) {
		int num;
		int totalDivisores = 0;

		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce un numero: ");
		num = sc.nextInt();

		for (int i = 1; i < num; i++) {
			if (num % i == 0) {
				totalDivisores += i;
			}
		}

		if (totalDivisores == num) {
			System.out.println("El numero " + num + " es perfecto");
		} else
			System.out.println("El numero " + num + " no es perfecto.");

		sc.close();
	}

}
