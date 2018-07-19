package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.util.Scanner;

/***
 * Programa que lea un car�cter y compruebe si es un n�mero (Car�cter entre '0'
 * y '9').
 * 
 * @author Curso
 *
 */
public class Ejercicio6 {

	public static void main(String[] args) {
		char c1;

		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce un caracter: ");
		c1 = sc.nextLine().charAt(0);

		if (Character.isDigit(c1))
			System.out.println("El caracter introducido es un numero");
		else
			System.out.println("El caracter introducido no es un numero");

		sc.close();
	}

}
