package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.util.Scanner;

/**
 * 
 * @author Asier Cornejo
 * 
 *         Programa que lea tres números enteros h, m, s que contienen hora,<br>
 *         minutos y segundos respectivamente, y comprueba si la hora que<br>
 *         indican es una hora válida.<br>
 *
 */
public class Ejercicio9 {

	public static void main(String[] args) {
		int h;
		int m;
		int s;
		int hLength;
		int mLenght;
		int sLength;
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce la hora:");
		h = sc.nextInt();
		hLength = String.valueOf(h).length();
		System.out.println("Introduce los minutos:");
		m = sc.nextInt();
		mLenght = String.valueOf(m).length();
		System.out.println("Introduce los segundos:");
		s = sc.nextInt();
		sLength = String.valueOf(s).length();
		if (h >= 0 && h <= 23 && hLength <= 2) {
			if (m >= 0 && m <= 59 && mLenght <= 2) {
				if (s >= 0 && s <= 59 && sLength <= 2) {
					System.out.println("La hora " + h + " : " + m + " : " + s + " es correcta");
				} else {
					System.out.println("Los segundos introducidos no son correctos");
				}

			} else {
				System.out.println("Los minutos introducidos no son correctos");
			}
		} else {
			System.out.println("La hora no es valida");
		}
		sc.close();
	}

}
