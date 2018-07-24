package com.ipartek.formacion.generales;

import java.util.Scanner;

/*
 * Mostrar los N primeros términos de la serie Fibbonacci.
 */
public class Ejercicio7 {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int n;
		int f1 = 1;
		int f2 = 1;
		
		System.out.println("Introduzca un valor para n: ");
		n = sc.nextInt();
		
		System.out.print(f1 + " ");
		for (int i=1; i<n; i++) {
			System.out.print(f2 + " ");
			 f2+= f1;
             f1 = f2 - f1;
		}
		
		

	}

}
