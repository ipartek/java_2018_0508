package com.ipartek.formacion.basicos.estructura_secuencial;

import java.util.Scanner;

/*
 * Programa que lee un número de 3 cifras y muestra sus cifras por separado.
 */
public class Tres_Digitos {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
	        int N;
	        System.out.print("Introduzca valor de N: ");
	        N = sc.nextInt(); //Supondremos que el número introducido tiene 3 cifras
	        System.out.println(N/100);
	        System.out.println(N/10);
	        System.out.println(N);
	}

}
