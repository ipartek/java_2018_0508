package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.io.IOException;
import java.util.Scanner;

/**
 * 4. Programa que lea dos caracteres por teclado y compruebe si son iguales.
 * 
 * @author Curso
 *
 */
public class Ejercicio4 {

	public static void main(String[] args) throws IOException {

		char c1, c2;

		System.out.print("Introduce una letra: ");
		c1 = (char) System.in.read();

		System.in.read();
		System.in.read();

		System.out.print("Introduce otra letra: ");
		c2 = (char) System.in.read();

		if (c1 == c2) {
			System.out.println("Esas dos letras son iguales");
		} else {
			System.out.println("Esas dos letras NO son iguales");
		}
	}

}
