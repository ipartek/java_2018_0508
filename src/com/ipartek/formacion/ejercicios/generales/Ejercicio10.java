package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * 10. Pasar de binario a decimal
 * 
 * @author Curso
 *
 */
public class Ejercicio10 {

	private static Scanner scan;

	public static void main(String[] args) {

		long num, aux, dig, deci;
		int exponente;
		boolean esBinario;
		scan = new Scanner(System.in);

		do {
			System.out.print("Introduce un numero binario: ");
			num = scan.nextLong();
			esBinario = true;
			aux = num;
			while (aux != 0) {
				dig = aux % 10;
				if (dig != 0 && dig != 1) {
					esBinario = false;
				}
				aux = aux / 10;
			}
		} while (!esBinario);

		exponente = 0;
		deci = 0;
		
		while (num != 0) {
			dig = num % 10;
			deci = deci + deci * (int) Math.pow(2, exponente);
			exponente++;
			num = num / 10;
		}
		System.out.println("Decimal: " + deci);
	}

}
