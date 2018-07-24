package com.ipartek.formacion.ejercicios.bucles.anidados;

import java.util.Scanner;

/**
 * 
 * Leer un número N y calcular el factorial de los números desde 0 hasta N.
 * 
 * El factorial de un número entero se expresa mediante el símbolo ‘!’ <br>
 * y se define de la siguiente forma: Si n = 0 entonces 0! = 1 Si n > 0 entonces
 * n! = n * (n – 1) * (n – 2) * …. * 3 * 2 * 1
 * 
 * @author Asier Cornejo
 *
 */
public class Ejercicio2 {

	public static void main(String[] args) {
		int n;
		double factorial;
		Scanner sc = new Scanner(System.in);

		do {
			System.out.print("Introduce un número mayor que 0: ");
			n = sc.nextInt();
		} while (n < 0);

		for (int i = 0; i <= n; i++) {

			// calcula su factorial
			factorial = 1;
			for (int j = 1; j <= i; j++) {
				factorial = factorial * j;
			}

			// se muestra el factorial
			System.out.printf("%2d! = %.0f %n", i, factorial);

		}
		sc.close();
	}

}
