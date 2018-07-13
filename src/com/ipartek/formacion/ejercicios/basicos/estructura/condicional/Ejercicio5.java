package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.util.Scanner;

/**
 * Programa java que lea dos caracteres por teclado y compruebe si los dos son
 * letras minúsculas
 * 
 * @author Curso
 *
 */
public class Ejercicio5 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String s1;
		String s2;
		char c1;
		char c2;

		System.out.print("Introduce un carácter: ");
		s1 = sc.next();
		c1 = s1.charAt(0);
		System.out.print("Introduce otro carácter: ");
		s2 = sc.next();
		c2 = s2.charAt(0);

		if (Character.isLowerCase(c1)) {
			if (Character.isLowerCase(c2))
				System.out.println("Los dos son letras minúsculas");
			else
				System.out.println("El primero es una letra minúscula pero el segundo no");
		} else {
			if (Character.isLowerCase(c2))
				System.out.println("El segundo es una letra minúscula pero el primero no");
			else
				System.out.println("Ninguno es una letra minúscula");
		}
		
		sc.close();
	}
}