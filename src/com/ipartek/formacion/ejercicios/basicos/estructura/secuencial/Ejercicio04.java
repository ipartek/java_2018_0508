package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
 * 
 * Ejercicio 4: Programa que lea una cantidad de grados centígrados y la pase a
 * grados Fahrenheit. La fórmula correspondiente para pasar de grados
 * centígrados a fahrenheit es: F = 32 + ( 9 * C / 5)
 * 
 * @author Curso
 *
 */
public class Ejercicio04 {

	public static void main(String[] args) {

		int n1;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce una temperatura en Cº: ");
		n1 = sc.nextInt();

		double f = 32 + (9 * n1 / 5);

		System.out.println("En Fahrenheit son : " + f);
		sc.close();

	}

}
