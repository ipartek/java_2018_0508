package com.ipartek.formacion.basicos.estructura.secuencial;

import java.util.Scanner;

/**
 * Programa que lea una cantidad de grados centígrados y la pase a grados
 * Fahrenheit. La fórmula correspondiente es: F = 32 + ( 9 * C / 5)
 * 
 * @author Curso
 *
 */

public class Ejercicio4 {

	static Scanner sc = new Scanner(System.in);
	static int n;

	public static void main(String[] args) {

		System.out.println("Introduzca un número por teclado:");
		n = sc.nextInt();
		System.out.println(n + "�C = " + (32 + (9 * n / 5)) + "F");

	}

}
