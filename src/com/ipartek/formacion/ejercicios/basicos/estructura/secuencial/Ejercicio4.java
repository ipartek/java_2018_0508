package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
 * 
 * 
 * @author Asier Cornejo
 * 
 *         Programa que lea una cantidad de grados centígrados y la pase a
 *         grados Fahrenheit.<br>
 *         La fórmula correspondiente es: F = 32 + ( 9 * C / 5)
 *
 * 
 */
public class Ejercicio4 {

	public static void main(String[] args) {
		float celsius = 0.0f;
		float fahrenheit = 0.0f;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca una temperatura en grados celsius para ver su equivalente en fahrenheit: ");
		celsius = sc.nextFloat();
		fahrenheit = 32 + (9 * celsius / 5);
		System.out.println(celsius + " celsius son " + fahrenheit + "º fahrenheit.");
		sc.close();
	}

}
