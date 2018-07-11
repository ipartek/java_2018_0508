package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
 * Programa que lea una cantidad de grados centígrados y la pase a grados
 * Fahrenheit. La fórmula correspondiente para pasar de grados centígrados a
 * fahrenheit es: F = 32 + ( 9 * C / 5)
 * 
 * @author Curso
 *
 */

public class Ejercicio4 {
	public static void main(String[] args) {
		Scanner p = new Scanner(System.in);
		double m;
		double n;
		System.out.println("Ingresa la cantidad de grados centigrados");
		m = p.nextDouble();
		n = 32 + (9 * m / 5);
		System.out.println(" El valor en grados centigrados" + n);

	}
}
