package com.ipartek.formacion.ejercicios.arrays;

import java.util.Scanner;

/**
 * Leer 10 enteros y mostrar la media de los valores negativos y la de los
 * positivos.
 * 
 * @author andreaperez
 *
 */
public class Ejercicio6 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[] arrayEnt = new int[10];
		int pos = 0;
		int neg = 0;
		int sumaPos = 0;
		int sumaNeg = 0;

		for (int i = 0; i < arrayEnt.length; i++) {
			System.out.println("Introduce numeros:");
			arrayEnt[i] = sc.nextInt();
			if (arrayEnt[i] > 0) {
				pos++;
				sumaPos += arrayEnt[i];

			} else {
				neg++;
				sumaNeg += arrayEnt[i];
			}
		}
		if (pos != 0) {
			System.out.println(pos + " nº positivos; la suma= " + sumaPos + "; la media= " + sumaPos / pos);
		} else if (neg != 0) {
			System.out.println(neg + " nº positivos; la suma= " + sumaNeg + "; la media= " + sumaNeg / neg);
		}

		sc.close();
	}

}
