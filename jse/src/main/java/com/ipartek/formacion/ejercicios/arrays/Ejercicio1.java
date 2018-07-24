package com.ipartek.formacion.ejercicios.arrays;

import java.util.Scanner;

/**
 * Programa Java que lea por teclado 10 números enteros y los guarde en un
 * array. A continuación calcula y muestra por separado la media de los valores
 * positivos y la de los valores negativos.
 * 
 * @author andreaperez
 *
 */
public class Ejercicio1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[] arrayNum = new int[10];
		int totalPos = 0;
		int totalNeg = 0;
		int sumaPos = 0;
		int sumaNeg = 0;

		for (int i = 0; i < arrayNum.length; i++) {
			System.out.println("introduce numero:");
			arrayNum[i] = sc.nextInt();
		}

		for (int i = 0; i < arrayNum.length; i++) {
			if (arrayNum[i] > 0) {
				sumaPos += arrayNum[i];
				totalPos++;
			} else {
				sumaNeg += arrayNum[i];
				totalNeg++;
			}
		}

		if (totalPos!=0) {
			System.out.println(
					totalPos + " Nº positivos " + "la suma es: " + sumaPos + " nos da de media: " + sumaPos / totalPos);

		} else {
			System.out.println("No hay numeros positivos");

		}
		
		if (totalNeg!=0) {
			System.out.println(
					totalNeg + " Nº positivos " + "la suma es: " + sumaNeg + " nos da de media: " + sumaNeg / totalNeg);

		} else {
			System.out.println("No hay numeros negativos");

		}
		
		
		sc.close();
	}

}
