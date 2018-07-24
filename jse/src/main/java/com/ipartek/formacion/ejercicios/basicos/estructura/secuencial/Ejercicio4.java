package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
 * 
 * @author andreaPerez
 *
 *         Programa que lea una cantidad de grados centígrados y la pase a
 *         grados Fahrenheit. La fórmula correspondiente es: F = 32 + ( 9 * C /
 *         5)
 */
public class Ejercicio4 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		float gradosCent;
		float gradosFah;

		System.out.print("Ingrese grados centigrados: ");
		gradosCent = sc.nextFloat();

		gradosFah = 32 + (9 * gradosCent / 5);
		System.out.println(gradosCent + " ºC " + " = " + gradosFah + "ºF");
		
		sc.close();
	}

}
