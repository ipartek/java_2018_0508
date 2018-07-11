package com.ipartek.formacion.ejercicios.generales;

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
 */

public class Ejercicio8 {

	public static void main(String[] args) {
		int numero;
		int fibo1, fibo2, i;

		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("Introduce un numero mayor que 1 ");
			numero = sc.nextInt();
		} while (numero <= 1);

		System.out.println("Los primeros " + numero + " numero del metodo fibonacci son: ");

		fibo1 = 1;
		fibo2 = 1;

		System.out.println(fibo1 + " ");
		for (i = 2; i < numero; i++) {
			System.out.println(fibo2 + " ");

			fibo2 = fibo1 + fibo2;
			fibo1 = fibo2 - fibo1;
		}
		System.out.println();
		
		sc.close();
	}

}
