package com.ipartek.formacion.ejercicios.array;

import java.util.Scanner;

/**
 * 
 * Calcular la media de una serie de números que se leen por teclado.
 * 
 * Programa Java que lea por teclado 10 números enteros y los guarde en un<br>
 * array. A continuación calcula y muestra por separado la media de los
 * valores<br>
 * positivos y la de los valores negativos.
 * 
 * @author Asier Cornejo
 *
 */
public class Ejercicio1 {

	public static void main(String[] args) {
		int tamArray = 10;
		int[] numeros = new int[tamArray];
		int cont = 0;
		int contPos = 0;
		int contNeg = 0;
		double sumPos = 0.0;
		double sumNeg = 0.0;
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("Introduce un numero entero, positivo o negativo");
			numeros[cont] = sc.nextInt();
			cont++;

		} while (cont < numeros.length);

		for (int i = 0; i < numeros.length; i++) {
			if (numeros[i] < 0) {
				sumPos += numeros[i];
				contPos++;
			} else {
				sumNeg += numeros[i];
				contNeg++;
			}
		}

		System.out.printf("La media de los números positivos es %.2f %n", sumPos / contPos);
		System.out.printf("La media de los números negativos es %.2f %n", sumNeg / contNeg);

		sc.close();
	}

}
