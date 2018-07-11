package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.util.Scanner;

/**
 * Programa que lea por teclado tres números enteros h, m, s correspondientes a
 * hora, minutos y segundos respectivamente, y comprueba si la hora que indican
 * es una hora válida.
 *
 */

public class Ejercicio9 {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		boolean correctValues = false;
		System.out.println("Introduce un numero: ");
		int h = teclado.nextInt();
		int m = 0;
		int s = 0;

		if (h <= 24 && h >= 0) {
			System.out.println("Introduce otro numero: ");
			m = teclado.nextInt();
			if (m <= 60 && h >= 0) {
				System.out.println("Introduce otro numero: ");
				s = teclado.nextInt();
				if (s <= 60 && h >= 0) {
					correctValues = true;
				}
			}
		}
		System.out.println("La hora " + h + ":" + m + ":" + s + ((correctValues) ? " es valida" : " no es valida"));
		teclado.close();
	}

}
