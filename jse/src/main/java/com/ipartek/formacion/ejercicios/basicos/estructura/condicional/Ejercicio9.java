package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.util.Scanner;

/**
 * Programa que lea tres números enteros H, M, S que contienen hora, minutos y
 * segundos respectivamente, y comprueba si la hora que indican es una hora
 * válida.
 * 
 * @author andreaperez
 *
 */
public class Ejercicio9 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int h;
		int m;
		int s;

		System.out.println("hora:");
		h = sc.nextInt();

		System.out.println("minutos:");
		m = sc.nextInt();

		System.out.println("segundos:");
		s = sc.nextInt();

		if (h >= 0 && h < 24 && m >= 0 && m < 60 && s >= 0 && s < 60) {
			System.out.println("Hora correcta");
		} else {
			System.out.println("Hora incorrecta");

		}

		sc.close();
	}

}
