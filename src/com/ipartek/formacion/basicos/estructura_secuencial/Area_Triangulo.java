package com.ipartek.formacion.basicos.estructura_secuencial;

import java.util.Scanner;

/*
 * Programa que calcula el área de un triángulo a partir de la longitud de sus lados.
 */
public class Area_Triangulo {

	static Scanner sc = new Scanner(System.in);
	static int b;
	static int h;
	static int res;
	
	public static void main(String[] args) {
		System.out.println("Longitud base: ");
		b = sc.nextInt();
		System.out.println("Longitud altura: ");
		h = sc.nextInt();
		res = b*h/2;
		System.out.println("El área del triángulo es: " + res);

	}

}
