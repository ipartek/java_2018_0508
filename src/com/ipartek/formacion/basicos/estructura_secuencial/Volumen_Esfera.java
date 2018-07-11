package com.ipartek.formacion.basicos.estructura_secuencial;

import java.util.Scanner;

/*
 * Programa que calcula el volumen de una esfera.
 * V = 4/3 * PI * r^3
 */
public class Volumen_Esfera {
	
	static Scanner sc = new Scanner(System.in);
	static int r;
	static double V;

	public static void main(String[] args) {
		System.out.println("Radio de la esfera: ");
		r = sc.nextInt();
		V = ((3/4f)*Math.PI*Math.pow(r, 3));
		System.out.println("V = " + V);

	}

}
