package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

import com.ipartek.formacion.ejercicios.Utilities;

/**
 * Comprobar si un número es perfecto.
 */
public class Ejercicio6 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduce un número: ");
		int num = teclado.nextInt();
		System.out.println((num == Utilities.sumDivisors(num)) ? "Perfecto" : "No es perfecto");
		teclado.close();
	}

}
