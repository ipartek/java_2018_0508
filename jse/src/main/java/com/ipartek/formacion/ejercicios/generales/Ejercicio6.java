package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * Comprobar si un número es perfecto.
 * 
 * Qué es un número perfecto?
 * 
 * Un número es perfecto si es igual a la suma de todos sus divisores positivos 
 * sin incluir el propio número.
 * 
 * Por ejemplo, el número 6 es perfecto. 
 * 
 * El 6 tiene como divisores: 1, 2, 3 y 6 pero el 6 no se cuenta como divisor 
 * para comprobar si es perfecto.
 * 
 * Si sumamos 1 + 2 + 3 = 6 
 *
 */
public class Ejercicio6 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int numero; 
		int suma = 0;
		
		System.out.println("Introduce un número para saber si es perfecto");
		numero = sc.nextInt();
		
		for (int i = 1; i < numero; i++) {
			if(numero % i == 0) {
				suma += i;
			}
		}
		
		if (suma == numero) {
			System.out.println("El número " + numero + " es perfecto");
		}
		else {
			System.out.println("El número " + numero + " no es perfecto");
		}
		
		sc.close();

	}

}
