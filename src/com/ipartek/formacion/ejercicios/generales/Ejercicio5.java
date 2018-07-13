package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * Leer números y contar cuántos acaban en 2.
 * 
 * @author Asier Cornejo
 *
 */
public class Ejercicio5 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n, contador = 0;
		System.out.print("Introduce un número entero: ");
		n = sc.nextInt();
		while (n >= 0) {
			if (n % 10 == 2)
				contador++;
			System.out.print("Introduce un número entero: ");
			n = sc.nextInt();
		}
		System.out.println("Se han introducido " + contador + " números acabados en 2");
		sc.close();
	}

}
