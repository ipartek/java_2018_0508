package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
 * 5. Programa que lee por teclado el valor del radio de una circunferencia y<br>
 * calcula y muestra por pantalla la longitud y el área de la circunferencia.<br>
 * Longitud de la circunferencia = 2*PI*Radio, Area de la circunferencia =<br>
 * PI*Radio^2<br>
 * 
 * @author Curso
 *
 */
public class Ejercicio5 {

	private static Scanner scan;

	public static void main(String[] args) {

		scan = new Scanner(System.in);
		double radio, longitud, area;

		System.out.println("Introduce el radio de la circunferencia: ");
		radio = scan.nextDouble();
		
		longitud = 2 * Math.PI * radio;
		area = Math.PI * Math.pow(radio, 2);
		
		System.out.println("La longitud de la circunferencia es " + longitud);
		System.out.println("El area de la circunferencia es " + area);

	}

}
