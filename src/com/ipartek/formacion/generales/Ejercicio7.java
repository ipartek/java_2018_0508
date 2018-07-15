package com.ipartek.formacion.generales;

import java.util.Scanner;

/**
 * COMPROBAR SI DOS NÚMEROS SON AMIGOS Dos números enteros positivos A y B
 * son
 * números amigos si la suma de los divisores propios de A es igual a B y la
 * suma de los divisores propios de B es igual a A.
 * 
 * Los divisores propios de un número incluyen la unidad pero no el propio
 * número.
 * 
 * Un ejemplo de números amigos son los números 220 y 284. Los divisores propios
 * de 220 son 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 y 110. La suma de los divisores
 * propios de 220 da como resultado 284 Los divisores propios de 284 son 1, 2,
 * 4, 71 y 142. La suma de los divisores propios de 284 da como resultado 220.
 * Por lo tanto 220 y 284 son amigos.
 * 
 * Otras parejas de números amigos son:
 * 
 * 1184, 1210 2620, 2924 5020, 5564 6232, 6368 10744, 10856 12285, 14595 17296,
 * 18416
 * 
 * Vamos a escribir el programa que calcula si dos números son amigos:
 * 
 * 
 * @author Ainara
 *
 */
public class Ejercicio7 {

	public static void main(String[] args) {
		
		int i;
		int suma = 0;
		int num1;
		int num2;

		Scanner sc = new Scanner(System.in);

		System.out.print("Introduce primer número: ");
		num1 = sc.nextInt();

		System.out.print("Introduce segundo número: ");
		num2 = sc.nextInt();

		for (i = 1; i < num1; i++) {
			if (num1 % i == 0) {
				suma = suma + i;
			}
		}

		if (suma == num2) {
			suma = 0;
			for (i = 1; i < num2; i++) {
				if (num2 % i == 0) {
					suma = suma + i;
				}
			}

			if (suma == num1) {
				System.out.println("Los numeros " + num1 +" y " + num2 + " son Amigos");
			} else {
				System.out.println("Los numeros " + num1 +" y " + num2 + " no son amigos");
			}
		} else {
			System.out.println("Los numeros " + num1 +" y " + num2 + " no son amigos");
		}

		sc.close();

	}

}
