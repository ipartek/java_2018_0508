package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.util.Scanner;

/***
 * Programa que lea tres números enteros H, M, S que contienen hora, minutos y
 * segundos respectivamente, y comprueba si la hora que indican es una hora
 * válida.
 * 
 * @author Curso
 *
 */
public class Ejercicio9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int h, m, s;

		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce las horas: ");
		h = sc.nextInt();
		System.out.println("Introduce los minutos: ");
		m = sc.nextInt();
		System.out.println("Introduce los segundos: ");
		s = sc.nextInt();

		if (h > 24 || h < 0 || m > 60 || m < 0 || s > 60 || s < 0)
			System.out.println("La hora introducida no es correcta.");
		else
			System.out.println("La hora introducida es correcta");

		sc.close();
	}

}
