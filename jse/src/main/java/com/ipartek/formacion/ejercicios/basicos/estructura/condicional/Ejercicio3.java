package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.io.IOException;

/**
 * Programa que lea un carácter por teclado y compruebe si es una letra
 * mayúscula
 * 
 * @author andreaperez
 *
 */
public class Ejercicio3 {

	public static void main(String[] args) throws IOException {

		char c;

		System.out.print("Introduzca un caracter: ");
		c = (char) System.in.read();

		if (Character.isUpperCase(c)) {
			System.out.println("Es Mayuscula");

		} else {
			System.out.println("Es minuscula");
		}

	}

}
