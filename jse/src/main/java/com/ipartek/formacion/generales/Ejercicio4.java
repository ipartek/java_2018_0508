package com.ipartek.formacion.generales;

import java.util.Scanner;

/*
 * Programa que lea una serie de números por teclado hasta que se lea un número negativo. 
 * El programa indicará cuántos números acabados en 2 se han leído.
 */
public class Ejercicio4 {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int n;
		int cont = 0;
		
		do {
			
			System.out.println("Introduce un número entero: ");
			n = sc.nextInt();
			
			cont+= (n%10==2 ? 1 : 0);
	
		} while (n>=0);
		
		System.out.println("Ha introducido " + cont + " valores terminados en 2.");
	}

}
