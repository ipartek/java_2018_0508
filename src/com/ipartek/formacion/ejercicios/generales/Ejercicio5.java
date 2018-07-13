package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * Programa que lea una serie de números por teclado hasta que se lea un número negativo. 
 * El programa indicará cuántos números acabados en 2 se han leído.
 *
 */
public class Ejercicio5 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int numero;
		int contador = 0;
		
		do {
			
			System.out.println("Introduzca un número (negativo para finalizar)");
			numero = sc.nextInt();
			
			if(numero % 10 == 2) {
				contador++;
			}
			
		} while (numero >= 0);
		
		System.out.println("Has introducido " + contador + " números acabados en 2");
		
		sc.close();
		
	}

}
