package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * Mostrar los N primeros términos de la serie de Fibonacci
 * 
 * @author Curso
 *
 */
public class Ejercicio8 {

	public static void main(String[] args) {
		int num, fibo1 = 1, fibo2 = 1;

		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce un numero mayor que 1: ");
		num = sc.nextInt();

		if (num <= 1)
			System.out.println("El numero introducido no es valido");
		else {
			System.out.println("Los " + num + " primeros numeros de la serie Fibonacci son: ");

			System.out.print(fibo1 + " ");
			for (int i = 2; i <= num; i++) {
				System.out.print(fibo2 + " ");
				fibo2 = fibo1 + fibo2;
				fibo1 = fibo2 - fibo1;
			}
		}

		sc.close();
	}

}
