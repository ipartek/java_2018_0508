package com.ipartek.formacion.basicos.estructura.condicional;

import java.util.Scanner;

/**
 * Programa que lea tres números enteros H, M, S que contienen hora, minutos y
 * segundos respectivamente, y comprueba si la hora que indican es una hora
 * válida.
 * 
 * @author Curso
 *
 */
public class Ejercicio10 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int h;
		int m;
		int s;

		System.out.println("Introduce las horas: ");
		h = sc.nextInt();
		
		System.out.println("Introduzca los minutos: ");
		m = sc.nextInt();
		
		System.out.println("Introduzca los segundos: ");
		s = sc.nextInt();
		
		if (h >= 0 && h < 24 && m >= 0 && m < 60 && s >= 0 && s < 60) {
			System.out.println(" La hora " + h + ":" + m + ":" + s + ":" + " es correcta");
		}else {
			System.out.println(" La hora " + h + ":" + m + ":" + s + ":" + " no es correcta");
		}

	}

}
