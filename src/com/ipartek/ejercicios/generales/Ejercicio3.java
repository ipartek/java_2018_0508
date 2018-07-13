package com.ipartek.ejercicios.generales;

import java.util.Scanner;

/**
 * Programa Java que lee una temperatura expresada en grados centígrados y la convierte a grados kelvin.
 * @author Curso
 *
 */

public class Ejercicio3 {
	
	private static Scanner sc;

	public static void main(String[] args) {
		
		sc = new Scanner(System.in);
		
		double gradosC;
		double gradosK;
		
		System.out.println("Introduce un temperatura en grados celsius: ");
		gradosC= sc.nextDouble();
		
		gradosK= gradosC + 273;
		
		System.out.println("El valor en grados Kelvin es de: "+gradosK);

}
	
}
