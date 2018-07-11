package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
 * 4. Programa que lea una cantidad de grados centígrados y la pase a grados
 * Fahrenheit. La fórmula correspondiente es: F = 32 + ( 9 * C / 5)
 * 
 * @author Curso
 *
 */
public class Ejercicio4 {
	
	public static int num;
	private static Scanner scan;

	public static void main(String[] args) {
		
		scan = new Scanner(System.in);
		
		System.out.println("Introduce los grados C: ");
		
		num = scan.nextInt();
		
		System.out.println("La temperatura en grados Fahrenheit es "+(32 + (9*num/5)));
		

	}

}
