package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.util.Scanner;

/**
* Programa Java que lea un número entero por teclado y calcule si es par o impar.
*/
public class Ejercicio1 {

	public static void main(String[] args) {
		
		
		//TODO controlar que solo sean números esnteros
		Scanner sc = new Scanner(System.in);
		
		int numero;
		
		System.out.println("Introduce un número entero");
		
		numero = sc.nextInt();
		
		if(numero % 2 == 0) {
			System.out.println("El número " + numero + " es par");
		}
		else {
			System.out.println("El número " + numero + " es impar");
		}
		
		sc.close();

	}
	
}
