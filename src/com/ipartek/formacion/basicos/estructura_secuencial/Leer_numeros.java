package com.ipartek.formacion.basicos.estructura_secuencial;

import java.util.Scanner;

/*
 * Programa Java que lea dos n�meros enteros por teclado y los muestre por pantalla.
 */
public class Leer_numeros {
	
	static Scanner sc = new Scanner(System.in);
	static int n;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i=0; i<2; i++) {
			System.out.println("Introduzca un n�mero por teclado:");
			n = sc.nextInt();
			System.out.println("El n�mero introducido es: " + n);
			System.out.println("---------------------------------");
		}
	}

}
