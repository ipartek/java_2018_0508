package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * Programa que lea una serie de números por teclado hasta que se lea un número negativo. El programa indicará cuántos números acabados en 2 se han leído.
 * @author Curso
 *
 */
public class Ejercicio5 {
	
	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		int n1;
		int cont = 0;
		
		do {
			System.out.println("Introduce un numero:");
			n1 = teclado.nextInt();
			System.out.println();
			
			if(n1%10 == 2) {
				cont++;
			}
		} while (n1 >= 0);
		
		System.out.println(cont + " números han terminado en dos.");
		
		teclado.close();
	}

}
