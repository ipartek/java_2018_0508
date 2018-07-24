package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.util.*;

/**
 * Programa que lea dos caracteres y compruebe si son iguales
 * 
 * @author Curso
 *
 */

public class Ejercicio4 {
	
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

		if (c1 == c2)
			System.out.println("Los dos caracteres son iguales");
		else
			System.out.println("Los dos caracteres no son iguales");
		
		sc.close();
	}
}
