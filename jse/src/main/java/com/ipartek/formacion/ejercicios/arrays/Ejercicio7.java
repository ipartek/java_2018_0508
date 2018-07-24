package com.ipartek.formacion.ejercicios.arrays;

import java.util.Scanner;

/**
 * 7. Programa Java para leer la altura de N personas y calcular la altura<br>
 * media. Calcular cuántas personas tienen una altura superior a la media y<br>
 * cuántas tienen una altura inferior a la media. El valor de N se pide por<br>
 * teclado y debe ser entero positivo.<br>
 * 
 * @author Ainara
 *
 */

public class Ejercicio7 {
	public static void main(String[] args) {
		int numPerson;
		int i;
		float suma = 0;
		float media;

		Scanner sc = new Scanner(System.in);

		do {
			System.out.print("¿Cuantas personas hay? ");
			numPerson = sc.nextInt();
		} while (numPerson <= 0);

		float[] altura = new float[numPerson];

		for (i = 0; i < altura.length; i++) {
			System.out.print("Persona " + (i + 1) + " Altura: ");
			altura[i] = sc.nextFloat();
		}

	
		for (i = 0; i < altura.length; i++) {
			suma = suma + altura[i];
		}

	
		media = suma / altura.length;

		System.out.printf("La altura media de las personas introducidas es: \n", media);

		System.out.println("Listado de altura igual a la media:");
		System.out.println("--------------------------------------: ");
		for (i = 0; i < altura.length; i++) {
			if (altura[i] == media) {
				System.out.println("Persona: " + (i + 1) + " Altura: " + altura[i]);
			}
		}
		System.out.println("Listado de altura superior a la media:");
		System.out.println("--------------------------------------: ");
		for (i = 0; i < altura.length; i++) {
			if (altura[i] > media) {
				System.out.println("Persona: " + (i + 1) + " Altura: " + altura[i]);
			}
		}
		
		System.out.println("Listado de altura inferior a la media: ");
		System.out.println("--------------------------------------: ");
		for (i = 0; i < altura.length; i++) {
			if (altura[i] < media) {
				System.out.println("Persona: " + (i + 1) + " Altura: " + altura[i]);
			}
		}
		
		sc.close();

	}
}
