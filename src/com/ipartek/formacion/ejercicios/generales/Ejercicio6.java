package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * Desarrollar el algoritmo para comprobar si un número es perfecto. El programa
 * pide por teclado un número y muestra si es perfecto o no. mediante un bucle
 * for sumaremos los divisores del número. Al final si esta suma es igual al
 * número mostraremos el mensaje correspondiente.
 * 
 * Por ejemplo, el número 6 es perfecto.
 * 
 * El 6 tiene como divisores: 1, 2, 3 y 6 pero el 6 no se cuenta como divisor
 * para comprobar si es perfecto.
 * 
 * Si sumamos 1 + 2 + 3 = 6
 * 
 * @author andreaperez
 *
 */
public class Ejercicio6 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = 0;
		int suma = 0;

		System.out.println("Escribe un numero entero, veremos si es perfecto o no: ");
		n = sc.nextInt();

		for (int i = 1; i < n; i++) {
			if (n % i == 0) {
				suma += i; // Se suma si es divisor
			}
		}

		if (suma == n) {
			System.out.println("El numero " + n + " es un numero perfecto.");
		} else {
			System.out.println("El numero " + n + " no es un numero perfecto.");
		}

		sc.close();

	}

}
