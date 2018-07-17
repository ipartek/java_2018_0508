package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.util.Scanner;

/***
 * Programa que lea dos caracteres por teclado y compruebe si son iguales.
 * @author Curso
 *
 */
public class Ejercicio4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char c1, c2;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce un primer caracter: ");
		c1 = sc.nextLine().charAt(0);
		System.out.println("Introduce un segundo caracter: ");
		c2 = sc.nextLine().charAt(0);
		
		if(Character.compare(c1, c2) == 0)
			System.out.println("Los dos caracteres introducidos son iguales");
		else
			System.out.println("Los dos caracteres introducidos no son iguales");
		
		sc.close();
	}

}
