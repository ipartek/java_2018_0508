package com.ipartek.formacion.ejercicios.bucles.anidados;

import java.util.Scanner;

/**
 * Leer por teclado un número entero N no negativo y mostrar el factorial de<br>
 * todos los números desde 0 hasta N. El factorial de un número entero se<br>
 * expresa mediante el símbolo ‘!’ y se define de la siguiente forma: Si n = 0<br>
 * entonces 0! = 1 Si n > 0 entonces n! = n * (n – 1) * (n – 2) * …. * 3 * 2 * 1<br>
 * Por ejemplo, n = 5 entonces 5! = 5 * 4 * 3 * 2 * 1 = 120<br>
 * 
 * @author Ainara
 *
 */
public class Ejercicio1 {

	public static void main(String[] args) {
		int num;
		float factorial;
		
		Scanner sc = new Scanner(System.in);

		do {
			System.out.print("Introduce un número mayor que 0: ");
			num = sc.nextInt();
		} while (num < 0);

		for (int i = 0; i <= num; i++) { 

			factorial = 1;
	
			for (int j = 1; j <= i; j++) {
			
				factorial = factorial * j;
		
			}

			System.out.printf("%2d! = %.0f %n", i, factorial);

		}
		
		sc.close();
	}

}
