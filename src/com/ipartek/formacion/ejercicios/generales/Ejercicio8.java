package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * 
 * Serie de Fibonacci en Java Programa que imprima los N primeros números de la
 * serie de Fibonacci. El primer número de la serie es 1, el segundo número es 1
 * y cada uno de los siguientes es la suma de los dos anteriores. 1, 1, 2, 3, 5,
 * 8, 13, ....... , N
 * 
 * @author andreaperez
 *
 */
public class Ejercicio8 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num = 1;
		int aux1 = 1;
		int aux2 = 1;

		do {
			System.out.println("Escribe un numero mayor que 1 para calcular el fibonacci: ");
			num = sc.nextInt();
		} while (num <= 1);

		System.out.print(aux1 + " ");

		for (int i = 2; i <= num; i++) {

			System.out.print(aux2 + " ");
			aux2 += aux1;
			aux1 = aux2 - aux1;

		}

		System.out.println();

		sc.close();

	}

}
