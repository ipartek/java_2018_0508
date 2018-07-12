package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.util.Scanner;

/**
 * Programa que lea dos números por teclado y muestre el resultado de la
 * división del primero por el segundo. Se debe comprobar que el divisor no
 * puede ser cero.
 * 
 * @author andreaperez
 *
 */
public class Ejercicio7 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int dividendo;
		int divisor;

		System.out.println("Dividendo:");
		dividendo = sc.nextInt();

		System.out.println("Divisor:");
		divisor = sc.nextInt();

		if (divisor == 0) {
			System.out.println("El divisor no puede ser 0");
		} else {
			System.out.println("El resultado de la division es: " + dividendo / divisor);
		}

		sc.close();

	}

}
