package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.util.Scanner;

/**
 * Programa que lea por teclado tres números enteros H, M, S correspondientes a
 * hora, minutos y segundos<br>
 * respectivamente, y comprueba si la hora que indican es una hora válida. <br>
 * Supondremos que se leemos una hora en modo 24 Horas, es decir, el valor
 * válido para las horas será<br>
 * mayor o igual que cero y menor que 24.<br>
 * El valor válido para los minutos y segundos estará comprendido entre 0 y 59
 * ambos incluidos.<br>
 * 
 * @author Curso
 *
 */

public class Ejercicio9 {

	public static void main(String[] args) {

		int h;
		int m;
		int s;

		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce una hora: ");
		h = sc.nextInt();
		System.out.println("Introduce unos minutos: ");
		m = sc.nextInt();
		System.out.println("Introduce unos segundos: ");
		s = sc.nextInt();

		if (h >= 0 && h < 24 && m >= 0 && m < 60 && s >= 0 && s < 60) {
			System.out.println("La hora introducida es correcta");
		}	
		else {
			System.out.println("La hora introducida es incorrecta");
		}
		
		sc.close();
	}

}
