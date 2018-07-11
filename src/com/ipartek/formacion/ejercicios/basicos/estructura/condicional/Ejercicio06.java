package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.util.Scanner;

/**
 * Ejercicio 6: Programa java que lea un carácter por teclado y compruebe si es
 * un dígito numérico (cifra entre 0 y 9).
 * 
 * @author Curso
 *
 */
public class Ejercicio06 {

	public static void main(String[] args) {

		char c;
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce un caracter: ");
		c = sc.next().charAt(0);

		if (Character.isDigit(c)) {
			System.out.println("Me has dado un digito.");
		} else {
			System.out.println("Me has dado una letra.");
		}

		sc.close();

	}

}
