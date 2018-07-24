package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.util.Scanner;

/***
 * Programa que lea un n�mero entero y muestre si el n�mero es m�ltiplo de 10.
 * 
 * @author Curso
 *
 */
public class Ejercicio2 {

	public static void main(String[] args) {
		int num;

		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce un numero: ");
		num = sc.nextInt();

		if (num % 10 == 0)
			System.out.println("El numero introducido es multiplo de 10");
		else
			System.out.println("El numero introducido no es multiplo de 10");
		
		sc.close();
	}

}
