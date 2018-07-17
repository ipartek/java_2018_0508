package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.util.Scanner;

/***
 * Programa que lea dos caracteres y compruebe si son dos letras minúsculas.
 * 
 * @author Curso
 *
 */
public class Ejercicio5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char c1, c2;

		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce un caracter: ");
		c1 = sc.nextLine().charAt(0);
		System.out.println("Introduce otro caracter: ");
		c2 = sc.nextLine().charAt(0);

		if (Character.isLowerCase(c1))
			if (Character.isLowerCase(c2))
				System.out.println("Los dos caracteres introducidos estan en minusculas");
			else
				System.out.println("El primer caracter esta en minuscula y el segundo no");
		else if (Character.isLowerCase(c2))
			System.out.println("El primer caracter no esta en minuscula y el segundo si");
		else
			System.out.println("Ninguno de los dos caracteres estan en minusculas");

		sc.close();

	}

}
