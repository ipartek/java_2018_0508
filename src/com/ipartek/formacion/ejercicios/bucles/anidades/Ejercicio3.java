package com.ipartek.formacion.ejercicios.bucles.anidades;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 
 * @author Curso 2. Leer un número N y calcular el factorial de los números
 *         desde 0 hasta N. //Leer un número entero >= 0 //se calcula su
 *         factorial //para cada número desde 1 hasta N //se muestra el
 *         factorial //se suma el factorial o //Al final del proceso se muestra
 *         la suma de todos los factoriales
 */
public class Ejercicio3 {
	public static void main(String[] args) throws Exception {
		int n;
		double factorial, suma = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		do {
			System.out.print("Introduce un número > 0: ");
			n = Integer.parseInt(br.readLine());
		} while (n < 0);

		for (int i = 0; i <= n; i++) {

			factorial = 1;
			for (int j = 1; j <= i; j++) {
				factorial = factorial * j;
			}

			System.out.printf("%n%2d! = %.0f %n", i, factorial);

			suma = suma + factorial;
		}

		System.out.printf("Suma de los factoriales desde 0 hasta %d: %.0f%n", n, suma);
	}
}
