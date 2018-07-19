package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/***
 * Leer n�meros y contar cu�ntos acaban en 2.
 * 
 * @author user
 *
 */
public class Ejercicio5 {

	public static void main(String[] args) {
		int num, cont = 0;

		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("Inserte un numero: ");
			num = sc.nextInt();
			if (num % 10 == 2) {
				cont++;
			}
		} while (num > 0);

		System.out.println("Numeros acabados en 2: " + cont);

		sc.close();
	}

}
