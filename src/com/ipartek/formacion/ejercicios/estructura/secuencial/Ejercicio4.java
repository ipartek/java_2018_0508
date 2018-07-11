package com.ipartek.formacion.ejercicios.estructura.secuencial;

import java.util.Scanner;

/**
 * Programa que lea una cantidad de grados centígrados y la pase a grados Fahrenheit. 
 * La fórmula correspondiente para pasar de grados centígrados a fahrenheit es:
 * F = 32 + ( 9 * C / 5)
 * @author Curso
 *
 */

public class Ejercicio4 {
	public static void main(String[] args) {
	
		Scanner teclado = new Scanner(System.in);
		
		float n1 = 0;
		
		System.out.println("Introduce una temperatura en grados centígrados:");
		n1 = teclado.nextFloat();
		
		float n2 = 32 + (9 * n1/5);
		
		System.out.println(n1 + " ºC = " + n2 + " ºF");
		
		
		
	}
}
