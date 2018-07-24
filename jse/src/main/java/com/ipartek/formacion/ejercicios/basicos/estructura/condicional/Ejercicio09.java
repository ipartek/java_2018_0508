package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.util.Scanner;

/**
 * Programa que lea por teclado tres números enteros H, M, S correspondientes a
 * hora, minutos y segundos respectivamente, y comprueba si la hora que indican
 * es una hora válida.
 * 
 * Supondremos que se leemos una hora en modo 24 Horas, es decir, el valor
 * válido para las horas será mayor o igual que cero y menor que 24.
 * 
 * El valor válido para los minutos y segundos estará comprendido entre 0 y 59
 * ambos incluidos
 * 
 * @author Curso
 *
 */
public class Ejercicio09 {

	public static void main(String[] args) {

		int h;
		int m;
		int s;
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce la hora:");
		h = sc.nextInt();
		System.out.println("Introduce los minutos:");
		m = sc.nextInt();
		System.out.println("Introduce los segundos:");
		s = sc.nextInt();

		if (h >= 24 || h <= 0) {
			System.out.println("Has metido mal la hora.");
		} else if (m >= 59 || m <= 0) {
			System.out.println("Has metido mal los minutos.");
		} else if (s >= 59 || s <= 0) {
			System.out.println("Has metido mal los segundos.");
		} else {
			System.out.println("La hora es " + h + ":" + m + ":" + s);
		}

		sc.close();
	}

}
