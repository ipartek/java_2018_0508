package com.ipartek.formacion.ejercicios.array;

import java.util.Scanner;

/**
 * 7. Leer N alturas y calcular la altura media. Calcular cuántas hay superiores
 * a la media y cuántas inferiores.
 * 
 * @author apero
 *
 */
public class Ejercicio7 {

	public static void main(String[] args) {

		int n;
		int[] alturas = new int[10];
		int media = 0;
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < alturas.length; i++) {
			System.out.println("Introduce la altura:");
			n = sc.nextInt();
			alturas[i] = n;
			media += alturas[i];
		}

		media = media / alturas.length;

		int cSupera = 0;
		int cNoSupera = 0;

		for (int i = 0; i < alturas.length; i++) {
			if (alturas[i] >= media) {
				cSupera++;
			} else {
				cNoSupera++;
			}
		}

		System.out.println("Hay "+cSupera+" que superan la media, y "+cNoSupera+" que no la superan.");
		
		sc.close();

	}

}
