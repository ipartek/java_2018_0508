package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.util.Scanner;

/***
 * Programa Java que lea un número entero y calcule si es par o impar.
 * 
 * @author Curso
 *
 */
public class Ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num;

		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce un numero por teclado: ");
		num = sc.nextInt();

		if (num % 2 == 0)
			System.out.println("El numero que has introducido es par");
		else
			System.out.println("El numero que has introducido es impar");
		
		sc.close();
	}

}
