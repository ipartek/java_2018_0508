package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

import com.ipartek.formacion.ejercicios.Utilities;

/**
 * Comprobar si dos números son amigos.
 */

public class Ejercicio7 {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduce un número: ");
		int num1 = teclado.nextInt();
		System.out.print("Introduce un número: ");
		int num2 = teclado.nextInt();
		System.out.println((Utilities.sumDivisors(num1) == num2 && Utilities.sumDivisors(num2) == num1) ? "Son amigos"
				: "No son amigos");
		teclado.close();

	}

}
