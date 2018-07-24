package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

/**
 * Programa que lea un número entero y muestre si el número es múltiplo de 10.<br>
 * Podemos comprobar si un número entero es múltiplo de 10 si al dividirlo por 10 es resto de esta división es cero.<br>
 */

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {

		int num;

		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce un  numero: ");
		num = sc.nextInt();

		String MULTI = (num % 10 == 0) ? "MÚLTIPLO" : "NO ES MÚLTIPLO";

		System.out.println("El número introducido es: " + MULTI);

		sc.close();

	}

}
