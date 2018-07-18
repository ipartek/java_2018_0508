package com.ipartek.formacion.ejercicios.recursividad;

import java.util.Scanner;

/**
 * Pasar de decimal a binario de forma recursiva.
 */
public class Ejercicio2 {

	public static void main(String[] args) {
		Scanner sc = null;

		try {
			sc = new Scanner(System.in);
			System.out.print("Introduce un numero: ");
			int num = sc.nextInt();
			decimalToBinary(num);

		} catch (Exception e) {
			System.out.println("ERROR al introducir los datos");
			sc.close();
			main(args);

		} finally {
			sc.close();
		}

	}

	private static void decimalToBinary(int num) {

		if (num > 0) {
			decimalToBinary(num / 2);
			System.out.print(num % 2);
		}
		
	}
}
