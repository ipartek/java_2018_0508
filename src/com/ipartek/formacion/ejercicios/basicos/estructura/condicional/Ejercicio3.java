package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.io.IOException;

/**
 * 3. Programa que lea un carácter por teclado y compruebe si es una letra
 * mayúscula.
 * 
 * @author Curso
 *
 */
public class Ejercicio3 {

	public static void main(String[] args) throws IOException {

		char c;

		System.out.print("Introduce una letra: ");
		c = (char) System.in.read();

		if (Character.isUpperCase(c)) {
			System.out.println("Es una letra mayuscula");
		} else {
			System.out.println("Es una letra minuscula");
		}
	}
}
