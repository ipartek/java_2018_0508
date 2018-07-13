package com.ipartek.ejercicios.generales;

import java.util.Scanner;

/**
 * Programa que lea una serie de números por teclado hasta que se lea un número negativo. El programa indicará cuántos números acabados en 2 se han leído.
 * @author Curso
 *
 */

public class Ejercicio5 {
	
	private static Scanner sc;

	public static void main(String[] args) {
		
		sc = new Scanner(System.in);
		
		int n;
		int contador=0;
		
	   do {
			System.out.print("Introduce un número entero: ");
			n = sc.nextInt();

			if (n%10==2) { //para saber si el numero acaba en 2
			contador++;
			}

			} while (n>=0); //mientras n sea positivo puedes seguir metiendo numeros

			System.out.println("Se han introducido " + contador + " números acabados en 2");

}
	
}
