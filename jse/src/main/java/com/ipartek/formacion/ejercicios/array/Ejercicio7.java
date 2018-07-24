package com.ipartek.formacion.ejercicios.array;

import java.util.Scanner;

/**
 * 
 * Leer N alturas y calcular la altura media. Calcular cuántas hay superiores a
 * <br>
 * la media y cuántas inferiores.
 * 
 * @author Asier Cornejo
 *
 */
public class Ejercicio7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i, n;
		int contMas = 0;
		int contMenos = 0;
		double media = 0;
		do {
			System.out.print("Número de personas: ");
			n = sc.nextInt();
		} while (n <= 0);

		double[] alturas = new double[n];

		System.out.println("Lectura de la altura de las personas: ");
		for (i = 0; i < n; i++) {
			System.out.print("persona " + (i + 1) + " = ");
			alturas[i] = sc.nextDouble();
			media = media + alturas[i];
		}

		media = media / n;

		for (i = 0; i < alturas.length; i++) {
			if (alturas[i] > media) {
				contMas++;
			} else if (alturas[i] < media) {
				contMenos++;
			}
		}

		System.out.println("Estatura media: " + media);
		System.out.println("Personas con estatura superior a la media: " + contMas);
		System.out.println("Personas con estatura inferior a la media: " + contMenos);
		sc.close();
	}

}
