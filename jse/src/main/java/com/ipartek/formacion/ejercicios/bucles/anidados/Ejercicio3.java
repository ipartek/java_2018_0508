package com.ipartek.formacion.ejercicios.bucles.anidados;

import java.util.Scanner;

/**
 * 3. Leer un número N y calcular la suma de los factoriales de los números
 * desde 0 hasta N.
 * 
 * @author apero
 *
 */
public class Ejercicio3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n;
		int factorial = 1;
		int sumaDeFactoriales = 0;

		System.out.println("Dime un numero:");
		n = sc.nextInt();

		for (int i = 0; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				factorial *= j;
			}
			sumaDeFactoriales += factorial;
			factorial = 1;
		}

		System.out.println("La suma de los factoriales de 0 a " + n + " es " + sumaDeFactoriales);

		sc.close();

	}

}
