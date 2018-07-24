package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
 * Ejercicio 6. Programa que pase una velocidad en Km/h a m/s. La velocidad se
 * lee por teclado.
 * 
 * @author Curso
 *
 */
public class Ejercicio06 {

	public static void main(String[] args) {

		double velocidad;
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce una velocidad en Km/h:");
		velocidad = (double)sc.nextDouble();

		System.out.println("En m/s son  = " + (velocidad * 5/18));
		sc.close();

	}

}
