package com.ipartek.formacion.ejercicios.arraylist;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Leer números por teclado hasta introducir -99. Calcular la suma, la media y
 * cuántos son mayores que la media.
 *
 */
public class Ejercicio2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> numbers = new ArrayList<Integer>();

		int sum = 0;
		int num = 0;
		do {

			System.out.print("Introduce un numero: ");
			num = sc.nextInt();
			if (num != -99) {
				numbers.add(num);
				sum += num;
			}

		} while (num != -99);

		System.out.println("La suma es: " + sum);
		System.out.println("La media es: " + (float) (sum / numbers.size()));

		System.out.println("Las notas que han quedado por encima de la media son: ");

		float average = (float) (sum / numbers.size());
		for (Integer value : numbers) {
			if (value > average) {
				System.out.println(value);
			}
		}
		sc.close();

	}

}
