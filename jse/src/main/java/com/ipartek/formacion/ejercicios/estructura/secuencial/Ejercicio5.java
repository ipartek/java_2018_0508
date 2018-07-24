package com.ipartek.formacion.ejercicios.estructura.secuencial;

import java.util.Scanner;

/**
 * Programa que lee por teclado el valor del radio de una circunferencia y calcula y muestra por pantalla la longitud y el área de la circunferencia. 
 * Longitud de la circunferencia = 2*PI*Radio, Area de la circunferencia = PI*Radio^2
 * @author Curso
 *
 */

public class Ejercicio5 {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		double radio;
		double longitud;
		double area;
		
		
		System.out.println("Introduce el radio de una circunferencia:");
		radio = teclado.nextDouble();
		
		longitud = 2 * Math.PI * radio;
		area = Math.PI * Math.pow(radio, 2);
		
		System.out.println();
		System.out.println("El radio de la circunferencia es: " + radio);
		System.out.println("Su longitud es: " + longitud);
		System.out.println("Su area es: " + area);

		teclado.close();
	}

}
