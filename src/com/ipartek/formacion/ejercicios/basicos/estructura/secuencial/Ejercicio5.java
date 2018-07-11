package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
 * 
 * @author Asier Cornejo
 * 
 *         Programa que lee por teclado el valor del radio de una circunferencia
 *         y calcula y muestra por pantalla la longitud y el área de la
 *         circunferencia.<br>
 *         Longitud de la circunferencia = 2*PI*Radio, Area de la circunferencia
 *         = PI*Radio^2
 *
 */
public class Ejercicio5 {

	public static void main(String[] args) {
		double radio = 0.0;
		double longitud = 0.0;
		double area = 0.0;

		System.out.println("Introduzca el radio de la circunferencia.");
		Scanner sc = new Scanner(System.in);
		radio = sc.nextFloat();
		longitud = 2 * Math.PI * radio;
		area= Math.PI * Math.pow(radio, 2);
		System.out.println("La longitud de la circunferencia es: " + longitud);
		System.out.println("El área de la circunferencia es: " + area);
	}

}
