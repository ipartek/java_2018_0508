package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.util.Scanner;

/**
 * Programa que lea un número entero y muestre si el número es múltiplo de 10.
 * 
 * @author andreaperez
 *
 */

public class Ejercicio2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int num;

		System.out.print("Introduzca Número entero: ");
		num = sc.nextInt();

		if (num % 10 == 0) {
			System.out.println("Es múltiplo de 10");

		} else {
			System.out.println("No es múltiplo de 10");
		}
		sc.close();
	}

}
