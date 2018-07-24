package com.ipartek.formacion.basicos.anidados;

import java.util.Scanner;

/**
 * Leer un número N y calcular el factorial de los números desde 0 hasta N.
 * @author Curso
 *
 */
public class Ejercicio2 {
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		int n;
		
		System.out.println("Introduzca un número entero positivo: ");
		n = sc.nextInt();
		
		for (int i= 0; i <= n; i++ ) {
			System.out.println(i + "! = " + factorial(i));
		}
	}
	
	private static int factorial(int n) {
		
		int fact = 1;
		
		for(int j = 1; j <= n; j++){
            fact*= j;
        }
		
		return fact;
	}

}
