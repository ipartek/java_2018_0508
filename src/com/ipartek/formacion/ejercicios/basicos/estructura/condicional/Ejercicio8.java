package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

/**
 * Calcular el mayor de tres números enteros en Java.<br>
 * El programa lee por teclado tres números enteros y calcula y muestra el mayor de los tres.<br>
 */

import java.util.Scanner;

public class Ejercicio8 {

	public static void main(String[] args) {
		int num1;
		int num2;
		int num3;

		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce el primer numero: ");
		num1 = sc.nextInt();
		System.out.println("Introduce el segundo numero: ");
		num2 = sc.nextInt();
		System.out.println("Introduce el tercero numero: ");
		num3 = sc.nextInt();

		if (num1 > num2) {
			if (num1 > num3) {
				System.out.println(num1 + " es mayor que " + num2 + "y " + num3);
			} else {
				System.out.println(num3 + " es mayor que " + num1 + "y " + num2);
			}
		} else if (num2 > num3) {
			System.out.println(num2 + " es mayor que " + num1 + "y " + num3);
		} else {
			System.out.println(num3 + " es mayor que " + num1 + "y " + num2);
		}

		sc.close();

	}

}
