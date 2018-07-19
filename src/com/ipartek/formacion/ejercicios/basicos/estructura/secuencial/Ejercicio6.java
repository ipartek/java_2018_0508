package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/***
 * Programa que pase una velocidad en Km/h a m/s. La velocidad se lee por
 * teclado.
 * 
 * @author Curso
 *
 */
public class Ejercicio6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double velocidadKm;

		System.out.println("Introduce una velocidad en Km/h: ");
		velocidadKm = sc.nextDouble();

		System.out.println(velocidadKm + " Km/h equivale a " + velocidadKm * 1000 / 3600 + " M/s");

		sc.close();

	}

}
