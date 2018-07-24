package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * Calcular el número de cifras de un número entero
 */

public class Ejercicio2 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Introducir un numero: ");
		int num = teclado.nextInt();
		System.out.println("Numero de cifras : "+(Integer.toString(num)).length());
		teclado.close();

	}

}
