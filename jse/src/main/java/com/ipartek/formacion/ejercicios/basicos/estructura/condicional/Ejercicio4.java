package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.io.IOException;

/**
 * Programa que lea dos caracteres por teclado y compruebe si son iguales.
 * 
 * @author andreaperez
 *
 */
public class Ejercicio4 {

	public static void main(String[] args) throws IOException {

		char a = 0;
		char b = 0;

		System.out.print("Introduzca primer carácter: ");
		a = (char) System.in.read();

		System.in.read();

		System.out.print("Introduzca segundo carácter: ");
		b = (char) System.in.read();

		if (Character.compare(a, b) == 0) {
			System.out.println("Son iguales");
		} else {
			System.out.println("No son iguales");
		}

	}

}
