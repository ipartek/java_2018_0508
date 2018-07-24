package com.ipartek.formacion.ejercicios.arrays;

import java.util.Scanner;

/**
 * Programa Java que guarda en un array 10 números enteros que se leen por
 * teclado. A continuación se recorre el array y calcula cuántos números son
 * positivos, cuántos negativos y cuántos ceros.
 * 
 * @author andreaperez
 *
 */
public class Ejercicio5 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[] arrayEnt = new int[10];
		int pos = 0;
		int neg = 0;
		int cero = 0;

		for (int i = 0; i < arrayEnt.length; i++) {
			System.out.println("Escribe numero entero:");
			arrayEnt[i] = sc.nextInt();
			if (arrayEnt[i] > 0) {
				pos++;
			} else if (arrayEnt[i] < 0) {
				neg++;
			} else {
				cero++;
			}
		}

		System.out.println(pos + "nº positivos; " + neg + " nº negativos; " + cero + "ceros");
		sc.close();
	}

}
