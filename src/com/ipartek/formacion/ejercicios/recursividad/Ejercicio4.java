package com.ipartek.formacion.ejercicios.recursividad;

import java.util.Scanner;

/**
 * Calcular el número de cifras de un número entero de forma recursiva.
 *
 */
public class Ejercicio4 {

	public static void main(String[] args) {
		Scanner sc = null;

		try {
			sc = new Scanner(System.in);
			System.out.print("Introduce un numero: ");
			int num = sc.nextInt();
			System.out.println(numberOfDigits(num));

		} catch (Exception e) {
			System.out.println("ERROR al introducir los datos");
			sc.close();
			main(args);

		} finally {
			sc.close();
		}

	}

	private static int numberOfDigits(int num) {
		
		int result = 0;
		if (num > 0) {
			result = 1+numberOfDigits(num/10); 
		}
		return result;

	}

}
