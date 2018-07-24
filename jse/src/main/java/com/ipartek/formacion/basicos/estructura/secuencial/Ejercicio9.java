package com.ipartek.formacion.basicos.estructura.secuencial;

import java.util.Scanner;

/**
 * Programa que calcula el área de un triángulo a partir de la longitud de sus
 * lados.
 * 
 * @author Curso
 *
 */

public class Ejercicio9 {

	static Scanner sc = new Scanner(System.in);
	static int b;
	static int h;
	static float res;

	public static void main(String[] args) {

		System.out.println("Longitud base: ");
		b = sc.nextInt();

		System.out.println("Longitud altura: ");
		h = sc.nextInt();

		res = b * h / 2f;
		System.out.println("El �rea del tri�ngulo es: " + res);

	}

}
