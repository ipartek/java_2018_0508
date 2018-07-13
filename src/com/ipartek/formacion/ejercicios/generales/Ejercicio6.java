package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * 
 * Comprobar si un número es perfecto.<br>
 * 
 * Un número es perfecto si es igual a la suma de todos sus divisores positivos
 * sin incluir el propio número.
 * 
 * @author Asier Cornejo
 *
 */
public class Ejercicio6 {

	public static void main(String[] args) {

		int suma = 0;
		int num;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce un número: ");
		num = sc.nextInt();
		for (int i = 1; i < num; i++) {
			if (num % i == 0) {
				suma = suma + i;
			}
		}
		if (suma == num) {
			System.out.println("El número " + num + " es perfecto");
		} else {
			System.out.println("El número " + num + " no es perfecto");

		}
		sc.close();
	}

}
