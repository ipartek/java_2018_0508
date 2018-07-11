package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
 * Programa que lee por teclado el valor del radio de una circunferencia y
 * calcula y muestra por pantalla la longitud y el área de la circunferencia.
 * <br>
 * Longitud de la circunferencia = 2*PI*Radio, Area de la circunferencia =
 * PI*Radio^2
 *
 */

public class Ejercicio5 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduzca el radio:  ");
		float radius = teclado.nextFloat();
		System.out.println("Longitud: " + 2 * Math.PI * radius);
		System.out.println("Area de la circunferencia: " + Math.pow(Math.PI * radius, 2));
		teclado.close();

	}

}
