package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
 * Ejercicio 5. Programa que lee por teclado el valor del radio de una
 * circunferencia y calcula y muestra por pantalla la longitud y el área de la
 * circunferencia. Longitud de la circunferencia = 2*PI*Radio, Area de la
 * circunferencia = PI*Radio^2
 * 
 * @author valen
 *
 */
public class Ejercicio5 {
	private static final int PI = 0;

	public static void main(String[] args) {
		Scanner p = new Scanner(System.in);
		double radio;
		double longitud;
		double area;
		System.out.println("Ingrese el radio de la circunferencia = ");
		radio = p.nextDouble();
		longitud = 2 * PI * radio;
		System.out.println("La longitud de la circunferencia es : " + longitud);
		area = Math.PI * Math.pow(radio, 2);
		System.out.println("La area de la circunferencia es : " + area);

	}

}
