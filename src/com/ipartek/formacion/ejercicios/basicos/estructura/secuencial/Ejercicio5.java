package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 
 * @author Curso 5. Programa que lee por teclado el valor del radio de una
 *         circunferencia y calcula y muestra por pantalla la longitud y el área
 *         de la circunferencia. Longitud de la circunferencia = 2*PI*Radio,
 *         Area de la circunferencia = PI*Radio^2
 */
public class Ejercicio5 {
	public static void main(String[] args) throws Exception {
		double longitud;
		double area;

		System.out.println("Introduzca el radio:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double radio = Double.parseDouble(br.readLine());
		longitud = 2 * Math.PI * radio;
		area = Math.PI * Math.pow(radio, 2);
		System.out.println("El area es : " + area + " la longitud es : " + longitud);
	}
}
