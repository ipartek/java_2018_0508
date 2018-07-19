package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/***
 * Programa que lee por teclado el valor del radio de una circunferencia y
 * calcula y muestra por pantalla la longitud y el �rea de la circunferencia.
 * Longitud de la circunferencia = 2*PI*Radio, Area de la circunferencia =
 * PI*Radio^2
 * 
 * @author Curso
 *
 */
public class Ejercicio5 {

	public static void main(String[] args) {
		double radio;
		double longitud;
		double area;
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduzca el radio de la circunferencia: ");
		radio = sc.nextDouble();
		longitud = 2 * Math.PI * radio;
		area = Math.PI * Math.pow(radio, 2);

		System.out.println("La longitud de la circunferencia es: " + longitud);
		System.out.println("El area de la circunferencia es: " + area);

		sc.close();
	}

}
