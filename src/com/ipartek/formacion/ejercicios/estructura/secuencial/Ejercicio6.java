package com.ipartek.formacion.ejercicios.estructura.secuencial;

import java.util.Scanner;

/**
 * Programa que pase una velocidad en Km/h a m/s. La velocidad se lee por teclado.
 * @author Curso
 *
 */

public class Ejercicio6 {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		double velocidad;
		
		System.out.println("Introduce una velocidad en Km/h:");
		velocidad = teclado.nextDouble();
		
		System.out.println();
		System.out.println(velocidad + " Km/h = " + velocidad*1000/3600 + " m/s");

	}

}
