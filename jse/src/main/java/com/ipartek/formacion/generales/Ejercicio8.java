package com.ipartek.formacion.generales;

import java.util.Scanner;

/*
 * En esta entrada vamos a escribir el programa java para convertir un número de decimal 
 * a binario un número leido por teclado.
 */
public class Ejercicio8 {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int n; 
		String bin = "";
		String s = "";
		
		System.out.println("Introduce el valor decimal: ");
		n = sc.nextInt();
		
		while (n!=0) {
			bin+= n%2;
			n/= 2;
		}
		
		for (int j=bin.length()-1; j>=0; j--) { // Invertimos el array
			s+= bin.charAt(j);
		}
		
		System.out.println(n + " = " + s);

	}

}
