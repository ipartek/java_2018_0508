package com.ipartek.formacion.generales;

import java.util.Scanner;

/**
 * La serie de fibonacci la forman una serie de números tales que:
 * 
 * El primer término de la serie es el número 1 El segundo término de la serie
 * es el número 1 Los siguientes términos de la serie de fibonacci se obtienen
 * de la suma de los dos anteriores:
 * 
 * 1, 1, 2, 3, 5, 8, 13, .....
 * 
 * Vamos a escribir el programa java que muestra los N primeros números de la
 * serie. El valor de N se lee por teclado.
 * 
 * 
 * import java.util.*; /** Serie de Fibonacci en Java Programa que imprima los N
 * primeros números de la serie de Fibonacci. El primer número de la serie es 1,
 * el segundo número es 1 y cada uno de los siguientes es la suma de los dos
 * anteriores. 1, 1, 2, 3, 5, 8, 13, ....... , N
 * 
 * 
 * @author Ainara
 *
 */
public class Ejercicio8 {

	public static void main(String[] args) {

		int num;
		int fi1;
		int fi2;

		Scanner sc = new Scanner(System.in);

		do {

			System.out.print("Introduce numero mayor que 1: ");
			num = sc.nextInt();

		} while (num <= 1);

		System.out.println("La serie Fibonacci del número " + num + " es: ");

		fi1 = 1;
		fi2 = 1;

		System.out.print(fi1 + " ");

		for (int i = 2; i <= num; i++) {
			System.out.print(fi2 + " ");
			fi2 = fi1 + fi2;
			fi1 = fi2 - fi1;
		}

		sc.close();
	}
}
