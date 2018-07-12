package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.util.Scanner;

/**
 * 7. Programa que lea dos números por teclado y muestre el resultado de la<br>
 * división del primero por el segundo. Se debe comprobar que el divisor no<br>
 * puede ser cero.
 * 
 * @author Curso
 *
 */
public class Ejercicio7 {

	private static Scanner scan;

	public static void main(String[] args) {

		scan = new Scanner(System.in);
		double num1, num2, res;

		do {
			System.out.println("Introduce un numero distinto de 0: ");
			num1 = scan.nextInt();
		} while (num1 == 0);

		do {
			System.out.println("Introduce otro numero distinto de 0: ");
			num2 = scan.nextInt();
		} while (num2 == 0);

		res = num1 / num2;

		System.out.println("El resultado es " + res);

	}

}
