package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * Ejercicio 5: Programa java que lea dos caracteres por teclado y compruebe si
 * los dos son letras minúsculas
 * 
 * @author Curso
 *
 */
public class Ejercicio05 {

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

		boolean primero = (Character.toLowerCase(c1) == c1) ? true : false;
		boolean segundo = (Character.toLowerCase(c2) == c2) ? true : false;

		if (primero && segundo) {
			System.out.println("Las dos letras estan en minusculas, " + c1 + " y " + c2);
		} else {
			System.out.println("Una de las letras no esta en minusculas, " + c1 + " y " + c2);
		}

		sc.close();

	}

}
