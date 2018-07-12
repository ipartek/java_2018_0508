package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.util.Scanner;

/**
* Programa que lea un número entero y muestre si el número es múltiplo de 10.
*/
public class Ejercicio2 {

	public static void main(String[] args) {
		
		
		//TODO controlar que solo sean números esnteros
		Scanner sc = new Scanner(System.in);
				
		int numero;
				
		System.out.println("Introduce un número entero");
				
		numero = sc.nextInt();
				
		if(numero % 10 == 0) {
			System.out.println("El número " + numero + " es multiplo de 10");
		}
		else {
			System.out.println("El número " + numero + " no es multiplo de 10");
		}
				
		sc.close();

	}

}
