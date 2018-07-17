package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.util.Scanner;

/***
 * Programa que lea un carácter por teclado y compruebe si es una letra
 * mayúscula.
 * 
 * @author Curso
 *
 */
public class Ejercicio3 {

	public static void main(String[] args) {
		String teclado;
		char c;

		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce un caracter por teclado: ");
		teclado = sc.nextLine();

		c = teclado.charAt(0);

		if (Character.isUpperCase(c))
			System.out.println("El caracter introducido esta en mayusculas");
		else
			System.out.println("El caracter introducido esta en minusculas");

		sc.close();

	}
}
