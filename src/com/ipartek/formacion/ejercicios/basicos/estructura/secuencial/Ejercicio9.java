package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
 * 9. Programa que calcula el área de un triángulo a partir de la longitudde<br>
 * sus lados.<br>
 * Ejemplo valido: A=10, B=12, C=6.
 * 
 * @author Curso
 *
 */
public class Ejercicio9 {

	private static Scanner scan;

	public static void main(String[] args) {

		scan = new Scanner(System.in);
		double a, b, c, p;

		System.out.print("Introduzca longitud del primer lado del triángulo: ");
		a = scan.nextDouble();

		System.out.print("Introduzca longitud del segundo lado del triángulo: ");
		b = scan.nextDouble();

		System.out.print("Introduzca longitud del tercer lado del triángulo: ");
		c = scan.nextDouble();

		p = (a + b + c) / 2;

		System.out.println("El area es " + Math.sqrt(p * (p - a) * (p - b) * (p - c)));

	}

}
