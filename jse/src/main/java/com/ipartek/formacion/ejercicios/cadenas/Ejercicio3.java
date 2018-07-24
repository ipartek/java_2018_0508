package com.ipartek.formacion.ejercicios.cadenas;

import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * Contar el número de veces que aparece un carácter en un texto.
 *
 */
public class Ejercicio3 {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce una frase: ");
		String str = sc.nextLine();

		System.out.print("Introduce un caracter: ");
		char ch = (char) System.in.read();
		str.indexOf(ch);
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ch) {
				count++;
			}
		}
		System.out.println("Numero de veces que se repite el caracter: " + count);
		sc.close();

	}

}
