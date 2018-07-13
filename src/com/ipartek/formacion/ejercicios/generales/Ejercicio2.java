package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * Programa Java que pide un número entero por teclado y calcula y 
 * muestra el número de cifras que tiene.
 * 
 * Por ejemplo si se introduce el número 54391 el programa mostrará el mensaje:
 * 
 * El número tiene 5 cifras
 * 
 * Si se introduce el número 101 se mostrará el mensaje:
 * 
 * El número tiene 3 cifras
 *
 */
public class Ejercicio2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int numero;
		int cifras = 0;
		
		System.out.println("Introduce un número entero");
		numero = sc.nextInt();
		
		while(numero != 0) {
			numero /= 10;
			cifras++;
		}
		
		System.out.println("El número tiene " + cifras + " cifras");
		
		sc.close();

	}

}
