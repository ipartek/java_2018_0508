package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.io.IOException;

/**
 * Programa que lea dos caracteres y compruebe si son dos letras minusculas.
 * 
 * @author andreaperez
 *
 */
public class Ejercicio5 {

	public static void main(String[] args) throws IOException {

		char c1;
		char c2;

		System.out.print("Introduzca primer caracter: ");
		c1 = (char) System.in.read();

		System.in.read();

		System.out.print("Introduzca segundo caracter: ");
		c2 = (char) System.in.read();

		if (Character.isLowerCase(c1)) {
			if (Character.isLowerCase(c2)) {
				System.out.println("Los dos caracteres son minusculas ");
			} else {
				System.out.println("Solo el primer caracter es minuscula");
			}

		} else if (Character.isLowerCase(c2)) {
			System.out.println("Solo el segundo el caracter es minuscula");
		} else {
			System.out.println("Ninguno de los caracteres son minusculas");
		}

	}
}
