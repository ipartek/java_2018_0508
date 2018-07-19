package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * 
 * Número capicúa en Java COMPROBAR SI UN NÚMERO ES CAPICÚA EN JAVA Un número es
 * capicúa si se puede leer igual de derecha a izquierda que de izquierda a
 * derecha. Ejemplos de números capicúas: 121, 3003, 1234321, 33, 445544, etc.
 * Vamos a escribir un programa Java que pida por teclado un número entero N de
 * más de una cifra y verifique si es capicúa. import java.util.Scanner;
 * 
 * @author Curso
 *
 */

public class Ejercicio13 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numero;
		int numero2;
		int a;
		int inv = 0;

		do {
			System.out.println("Ingrese un numero entero por favor = ");
			numero = s.nextInt();
		} while (numero < 10);

		a = numero;
		while (a != 0) {
			numero2 = a % 10;
			inv = inv * 10 + numero2;
			a = a / 10;
		}
		if (numero == inv) {
			System.out.println("El numero ingresado es capicua ");
		}

	}
}
