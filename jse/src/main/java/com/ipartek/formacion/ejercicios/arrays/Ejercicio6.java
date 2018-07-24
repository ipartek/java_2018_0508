package com.ipartek.formacion.ejercicios.arrays;

import java.util.Scanner;

/**
 * 6. Programa Java que llene un array con 10 números enteros que se leen por<br>
 * teclado. A continuación calcula y muestra la media de los valores positivos y<br>
 * la de los valores negativos del array.<br>
 * 
 * @author Ainara
 *
 */
public class Ejercicio6 {
	public static void main(String[] args) {
		int i;
		int[] num = new int[10];
		int positivos = 0;
		int negativos = 0;
		float sumapositivos = 0;
		float sumanegativos=0;

		Scanner sc = new Scanner(System.in);

		System.out.println("Introducción de números en array: \n");
		for (i = 0; i < num.length; i++) {
			System.out.print("Números[" + i + "]= ");
			num[i] = sc.nextInt();
		}

		 for (i = 0; i < num.length; i++) {
	            if (num[i] > 0){ 
	            	sumapositivos += num[i];
	                positivos++;
	            } else if (num[i] < 0){ 
	            	sumanegativos += num[i];
	                negativos++;
	            }
	        }

		if (positivos != 0) {
			System.out.println("Media de los valores positivos: " + positivos / sumapositivos);
		} else {
			System.out.println("No has introducido ningun número positivo");
		}
		
		if (negativos != 0) {
			System.out.println("Media de los valores negativos: " + negativos / sumanegativos);
		} else {
			System.out.println("No has introducido ningun número negativo");
		}

		sc.close();

	}
}
