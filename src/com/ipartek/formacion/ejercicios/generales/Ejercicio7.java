package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * Comprobar si dos números son amigos.
 * 
 * Dos números enteros positivos A y B son números amigos si la suma de los<br>
 * divisores propios de A es igual a B y la suma de los divisores propios de B
 * <br>
 * es igual a A.
 * 
 * @author Asier Cornejo
 *
 */
public class Ejercicio7 {

	public static void main(String[] args) {
		int suma = 0;
		int num1, num2;
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce primer número: ");
		num1 = sc.nextInt();
		System.out.print("Introduce segundo número: ");
		num2 = sc.nextInt();
		for (int i = 1; i < num1; i++) {
			if (num1 % i == 0) {
				suma = suma + i;
			}
		}

		if (suma == num2) {
			suma = 0;
			for (int i = 1; i < num2; i++) {
				if (num2 % i == 0) {
					suma = suma + i;
				}
			}

			if (suma == num1) {
				System.out.println("Los numeros " + num1 + " y " + num2 + " son amigos");
			} else {
				System.out.println("Los numeros " + num1 + " y " + num2 + " no son amigos");
			}
		} else {
			System.out.println("Los numeros " + num1 + " y " + num2 + " no son amigos");
		}
		sc.close();
	}

}
