package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
 * 6. Programa que pase una velocidad en Km/h a m/s. La velocidad se lee por<br>
 * teclado.
 * 
 * @author Curso
 *
 */
public class Ejercicio6 {
	
	private static Scanner scan;

	public static void main(String[] args) {
		
		scan = new Scanner(System.in);
		double v;
		
		System.out.println("Introduce la velocidad(Km/h): ");
		v = scan.nextDouble();
		
		System.out.println("Eso son "+ v*1000/3600 + "m/s");
		
	}

}
