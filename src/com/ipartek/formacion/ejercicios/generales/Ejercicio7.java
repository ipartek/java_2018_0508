package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * Comprobar si dos numeros son amigos
 * 
 * @author Curso
 *
 */
public class Ejercicio7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1, num2;
		int totalDivisores1 = 0, totalDivisores2 = 0;

		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce un numero: ");
		num1 = sc.nextInt();

		System.out.println("Introduce un segundo numero: ");
		num2 = sc.nextInt();

		for (int i = 1; i < num1; i++) {
			if (num1 % i == 0) {
				totalDivisores1 += i;
			}
		}

		for (int i = 1; i < num2; i++) {
			if (num2 % i == 0) {
				totalDivisores2 += i;
			}
		}

		if (totalDivisores1 == num2 && totalDivisores2 == num1)
			System.out.println("Los numeros " + num1 + " y " + num2 + " son amigos");
		else
			System.out.println("Los numeros " + num1 + " y " + num2 + " no son amigos");

		sc.close();
	}

}
