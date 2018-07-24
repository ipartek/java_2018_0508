package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
 * Ejercicio 5. Programa que lee por teclado el valor del radio de una
 * circunferencia y calcula y muestra por pantalla la longitud y el área de la
 * circunferencia.
 * 
 * Longitud de la circunferencia = 2*PI*Radio, Area de la circunferencia =
 * PI*Radio^2
 * 
 * @author Curso
 *
 */
public class Ejercicio05 {

	public static void main(String[] args) {

		double PI = 3.1416;
		double radio;
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce un radio de circuferencia:");
		radio = (double)sc.nextDouble();

		System.out.println("Longitud de la circunferencia = " + 2 * PI * radio);
		System.out.println("Area de la circunferencia = " + (PI * (radio * radio)));

		sc.close();

	}

}
