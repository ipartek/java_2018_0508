package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
 * 8. Programa que calcula el volumen de una esfera.
 * 
 * @author Curso
 *
 */
public class Ejercicio8 {

	private static Scanner scan;

	public static void main(String[] args) {

		scan = new Scanner(System.in);
		double radio;

		System.out.print("Introduce el radio de la esfera: ");
		radio = scan.nextDouble();

		System.out.println("El volumen de la esfera es " + (4.0 / 3) * Math.PI * Math.pow(radio, 3));

	}

}
