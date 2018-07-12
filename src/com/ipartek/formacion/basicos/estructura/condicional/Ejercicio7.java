package com.ipartek.formacion.basicos.estructura.condicional;

import java.util.Scanner;

/**
 * Programa que lea dos números por teclado y muestre el resultado de la
 * división del primero por el segundo. Se debe comprobar que el divisor no
 * puede ser cero.
 * 
 * @author Curso
 *
 */
public class Ejercicio7 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int n;
		int div;
		int res = 0;

		n = leerInt();
		div = leerInt();
		if (div !=0)  {
			res = n / div;
		}
		System.out.println(div == 0 ? "No se puede dividir entre 0" : n + "/" + div + " = " + res);

	}

	private static int leerInt() {

		System.out.println("Introduce un número entero: ");
		return sc.nextInt();
	}

}
