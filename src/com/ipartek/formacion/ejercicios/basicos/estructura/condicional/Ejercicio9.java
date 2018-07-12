package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.util.Scanner;

/**
 * 9. Programa que lea tres números enteros H, M, S que contienen hora, minutos<br>
 * y segundos respectivamente, y comprueba si la hora que indican es una hora<br>
 * válida.
 * 
 * @author Curso
 *
 */
public class Ejercicio9 {

	private static Scanner scan;

	public static void main(String[] args) {

		scan = new Scanner(System.in);
		int h, m, s;

		System.out.println("Introduce la hora(hh): ");
		h = scan.nextInt();

		System.out.println("Introduce los minutos(mm): ");
		m = scan.nextInt();

		System.out.println("Introduce los segundos(ss): ");
		s = scan.nextInt();

		if (h >= 24 || h <= 0 || m >= 60 || m <= 0 || s >= 60 || s <= 0) {
			System.out.println("Solo hay 24 horas, 60 minutos y 60 segundos. Bienvenido al mundo real =)");
		} else {
			System.out.println("Has escrito " + h + ":" + m + ":" + s + ", buena hora para no hacer nada");
		}

	}

}
