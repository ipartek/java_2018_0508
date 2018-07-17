package com.ipartek.formacion.ejercicios.array;

import java.util.Scanner;

/**
 * Leer N alturas y calcular la altura media. 
 * Calcular cuántas hay superiores a la media y cuántas inferiores.
 *
 */
public class Ejercicio7 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int nAlturas;
		double suma = 0;
		double media;
		int contadorAlturaSuperior = 0;
		int contadorAlturaInferior = 0;
		
		System.out.println("¿Cuántas alturas quieres introducir?");
		nAlturas = sc.nextInt();
		
		int alturas[] = new int[nAlturas];
		
		for (int i = 0; i < alturas.length; i++) {
			do {
				System.out.println("Introduce una altura (en cm)");
				alturas[i] = sc.nextInt();
			} while (alturas[i] <= 0);
			
			suma += alturas[i];
			
		}
		
		media = suma / nAlturas;
		
		for (int i = 0; i < alturas.length; i++) {
			if (alturas[i] > media) {
				contadorAlturaSuperior++;
			}
			else {
				contadorAlturaInferior++;
			}
		}
		
		System.out.println("La media de las alturas es " + media + "cm");
		System.out.println("Hay " + contadorAlturaSuperior + " personas que superan la media");
		System.out.println("Hay " + contadorAlturaInferior + " personas que no llegan a la media");
		
		sc.close();
	}

}
