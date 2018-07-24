package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.io.IOException;
import java.util.Scanner;

/**
 * Ejercicio 4: Programa que lea dos caracteres y compruebe si son iguales.
 * 
 * @author Curso
 *
 */
public class Ejercicio04 {

	public static void main(String[] args) throws IOException {

		char c1;
		char c2;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce la primera letra:");
		c1 = sc.next().charAt(0);
		System.in.read();
		System.in.read();
		System.out.println("Introduce la segunda letra:");
		c2 = sc.next().charAt(0);
		
		if(Character.toUpperCase(c1) == Character.toUpperCase(c2)) {
			System.out.println(c1+" y "+c2+" son la misma letra.");
		}else {
			System.out.println(c1+" y "+c2+" no son la misma letra.");
		}
		
		sc.close();
		

	}

}
