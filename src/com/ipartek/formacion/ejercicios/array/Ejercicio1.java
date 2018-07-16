package com.ipartek.formacion.ejercicios.array;

import java.util.Scanner;

/**
 * Calcular la media de una serie de números que se leen por teclado.
 * 
 * Programa Java que lea por teclado 10 números enteros y los guarde en un array. 
 * A continuación calcula y muestra por separado la media de los valores positivos 
 * y la de los valores negativos.
 *
 */
public class Ejercicio1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int numeros[] = new int[10];
		double mediaPositivos = 0;
		double mediaNegativos = 0;
		int contadorPositivos = 0;
		int contadorNegativos = 0;
		
		for (int i = 0; i < numeros.length; i++) {
			System.out.println("Introduce un número");
			numeros[i] = sc.nextInt();
			
			if(numeros[i] > 0) {
				mediaPositivos += numeros[i];
				contadorPositivos++;
			}
			else {
				mediaNegativos += numeros[i];
				contadorNegativos++;
			}
			
		}
		
		if(contadorPositivos != 0) {
			System.out.println("La media de los numeros positivos es " + mediaPositivos/contadorPositivos);
		}
		else {
			System.out.println("No has introducido números positivos");
		}
		
		if(contadorNegativos != 0) {
			System.out.println("La media de los numeros negativos es " + mediaNegativos/contadorNegativos);
		}
		else {
			System.out.println("No has introducido números negativos");
		}
		
		sc.close();

	}

}
