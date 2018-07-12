package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.io.IOException;

/**
 * Programa java que lea dos caracteres por teclado y compruebe si los dos son letras minúsculas
 * 
 * @author Curso
 *
 */

public class Ejercicio5 {

	public static void main(String[] args) throws IOException {

		char carac;
		char carac2;

		System.out.println("Introduce una letra: ");
		carac = (char) System.in.read();
		System.in.read();
		System.in.read();
		System.out.println("Introduce otra letra: ");
		carac2 = (char) System.in.read();

		if (Character.isLowerCase(carac)) {
			if (Character.isLowerCase(carac2))
				System.out.println("Los dos caracteres son minúsculas");
			else
				System.out.println("El primero es minúscula pero el segundo no");
		} else {
			if (Character.isLowerCase(carac2)) {
				System.out.println("El segundo es una letra minúscula pero el primero no");
			} else {
				System.out.println("Ninguno es una letra minúscula");
			}

		}

	}

}
