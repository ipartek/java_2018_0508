package com.ipartek.ejercicios.generales;

import java.util.Scanner;

/**
 * Programa java para calcular si un número es perfecto
 * @author Curso
 *
 */

public class Ejercicio6 {
	
	private static Scanner sc;

	public static void main(String[] args) {
		
		sc = new Scanner(System.in);
		
		int n;
		int i;
		int suma=0;
		
		System.out.println("Introduce un numero: ");
		n= sc.nextInt();
		
		for (i = 1; i < n; i++) {  // i son los divisores. Se divide desde 1 hasta n-1 
            if (n % i == 0) {
                suma = suma + i;     // si es divisor se suma
            }
        }
        if (suma == n) {  // si el numero es igual a la suma de sus divisores es perfecto
            System.out.println("Es Perfecto");
        } else {
            System.out.println("No es perfecto");

        }

}

}