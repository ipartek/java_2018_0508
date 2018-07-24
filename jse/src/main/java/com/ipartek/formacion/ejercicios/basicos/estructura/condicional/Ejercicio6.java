package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.io.IOException;

/**
 * Programa que lea un carácter y compruebe si es un número (Carácter entre '0'
 * y '9').
 * 
 * @author andreaperez
 *
 */
public class Ejercicio6 {

	public static void main(String[] args) throws IOException {

		char c;

		System.out.print("Introduzca primer caracter: ");
		c = (char) System.in.read();

		if (c >= '0' && c <= '9') {
			System.out.println("Es un número");
		} else {
			System.out.println("No es un número");
		}
	}

}
