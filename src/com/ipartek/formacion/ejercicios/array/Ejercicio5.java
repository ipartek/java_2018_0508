package com.ipartek.formacion.ejercicios.array;

import java.util.Scanner;

/**
 * Contar el número de elementos positivos, negativos y ceros en un array de 10 enteros.
 *
 */
public class Ejercicio5 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int numeros[] = new int[10];
		int contadorPositivos = 0;
		int contadorNegativos = 0;
		int contadorCeros = 0;
		
		for (int i = 0; i < numeros.length; i++) {
			System.out.println("Introduce un número");
			numeros[i] = sc.nextInt();
			
			if(numeros[i] > 0) {
				contadorPositivos++;
			}
			else if(numeros[i] < 0) {
				contadorNegativos++;
			}
			else {
				contadorCeros++;
			}
			
		}
		
		System.out.println("Has introducido " + contadorPositivos + " números positivos, " + 
		contadorNegativos + " números negativos y " + contadorCeros + " ceros");
		
		sc.close();
		
	}

}
