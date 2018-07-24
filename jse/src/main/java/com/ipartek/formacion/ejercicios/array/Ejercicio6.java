package com.ipartek.formacion.ejercicios.array;

import java.util.Scanner;

/**
 * Leer 10 enteros y mostrar la media de los valores negativos y la de los positivos.
 *
 */
public class Ejercicio6 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int numeros[] = new int[10];
		double sumaPositivos = 0;
		double sumaNegativos = 0;
		int contadorPositivos = 0;
		int contadorNegativos = 0;
		
		for (int i = 0; i < numeros.length; i++) {
			System.out.println("Introduce un número");
			
			numeros[i] = sc.nextInt();
			
			if(numeros[i] >= 0) {
				sumaPositivos += numeros[i];
				contadorPositivos++;
			}
			else {
				sumaNegativos += numeros[i];
				contadorNegativos++;
			}
			
		}
		
		double mediaPositivos;
		double mediaNegativos;
		
		if(contadorPositivos != 0) {
			mediaPositivos = sumaPositivos / contadorPositivos;
		System.out.println("La media de números positivos es " + mediaPositivos);
		}else {
			System.out.println("No has introducido números positivos");
		}
		
		if(contadorNegativos != 0) {
			mediaNegativos = sumaNegativos / contadorNegativos;
		System.out.println("La media de números negativos es " + mediaNegativos);
		}else {
			System.out.println("No has introducido números negativos");
		}
		
		sc.close();

	}

}
