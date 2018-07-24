package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.util.Scanner;

/**
 * Ejercicio 7: Programa que lea dos números por teclado y muestre el resultado
 * de la división del primer número por el segundo. Se debe comprobar que el
 * divisor no puede ser cero.
 * 
 * @author Curso
 *
 */
public class Ejercicio07 {

	public static void main(String[] args) {

		int n1;
		int n2;
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce un numero:");
		n1 = sc.nextInt();
		boolean noCero = true;
		do {
			System.out.println("Introduce un numero:");
			n2 = sc.nextInt();

			if (n2 != 0) {
				noCero = false;
			} else {
				System.out.println("Has metido un cero en el divisor, prueba otra vez");
			}
		} while (noCero);

		System.out.println("La division entre " + n1 + "/" + n2 + " es " + (n1 / n2));
		sc.close();
	}

}
