package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.util.Scanner;

/**
 * 3. Programa que lea un carácter por teclado y compruebe si es una letra
 * mayúscula
 * 
 * @author Curso
 *
 */
public class Ejercicio03 {

	public static void main(String[] args) {

		char c;
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce un caracter:");
		c = sc.nextLine().charAt(0);
		char cMayus = Character.toUpperCase(c);
		if (c == cMayus) {
			System.out.println(c + " esta en mayusculas.");
		} else {
			System.out.println(c + " esta en minusculas.");
		}
		
		sc.close();
	}

}
