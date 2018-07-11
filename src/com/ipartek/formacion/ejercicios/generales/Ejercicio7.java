package com.ipartek.formacion.ejercicios.generales;

/**
 * 
 * Dos números enteros positivos A y B son números amigos si la suma de los
 * divisores propios de A es igual a B y la suma de los divisores propios de B
 * es igual a A.
 *
 */

import java.util.Scanner;


public class Ejercicio7 {

	public static void main(String[] args){
		int divisor, numero1, numero2;
		int suma = 0;

		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce un numero ");
		numero1 = sc.nextInt();

		System.out.println("Introduce otro numero ");
		numero2 = sc.nextInt();

		for (divisor = 1; divisor < numero1; divisor++) {
			if (numero1 % divisor == 0) {
				suma = suma + divisor;
			}
		}

		if (suma == numero2) {
			suma = 0;
			for (divisor = 1; divisor < numero2; divisor++) {
				if (numero2 % divisor == 0) {
					suma = suma + divisor;
				}
			}
			if (suma == numero1) {
				System.out.println("Son Amigos");
			} else {
				System.out.println("No son amigos");
			}
		}

		else {
			System.out.println("No son amigos");
		}

		sc.close();
	}

}
