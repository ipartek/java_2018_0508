package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.io.IOException;

/**
 * 5. Programa que lea dos caracteres y compruebe si son dos letras minúsculas.
 * @author Curso
 *
 */
public class Ejercicio5 {

	public static void main(String[] args) throws IOException {
		
		char c1, c2;

		System.out.print("Introduce una letra: ");
		c1 = (char) System.in.read();
		
		System.in.read();
		System.in.read();

		System.out.print("Introduce otra letra: ");
		c2 = (char) System.in.read();

		if (Character.isLowerCase(c1) & Character.isLowerCase(c2)) {
			System.out.println("Esas dos letras son minusculas");
		} else {
			System.out.println("Esas dos letras NO son minusculas");
		}
	}

	}


