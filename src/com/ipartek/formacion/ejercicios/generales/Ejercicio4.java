package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * Mostrar la tabla de multiplicar de un número.
 * 
 * @author andreaperez
 *
 */
public class Ejercicio4 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = 0;

		System.out.print("Indica que tabla de multiplicar quieres ver: ");
		n = sc.nextInt();

		for (int i = 1; i <= 10; i++) {
			System.out.println(n + " x " + i + ": " + (n * i));

		}

		sc.close();

	}

}
