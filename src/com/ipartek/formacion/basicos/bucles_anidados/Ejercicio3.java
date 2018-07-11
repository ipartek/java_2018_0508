package com.ipartek.formacion.basicos.bucles_anidados;

import java.util.Scanner;

/**
 * Leer un número N y calcular la suma de los factoriales de los números desde 0 hasta N.
 * @author Curso
 *
 */
public class Ejercicio3 {
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		int n;
		int sum = 0;
		
		System.out.println("Introduzca un número entero positivo: ");
		n = sc.nextInt();
		
		for (int i= 0; i <= n; i++ ) {
			sum+= factorial(i);
		}
		
		System.out.println("La suma de los factoriales es: " + sum);
	}
	
	private static int factorial(int n) {
		
		int fact = 1;
		
		for(int j = 1; j <= n; j++){
            fact*= j;
        }
		
		return fact;
	}

}
