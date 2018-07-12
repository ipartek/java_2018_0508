package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.io.IOException;

/**
 * Programa que lea dos caracteres y compruebe si son iguales.
 * 
 * @author Curso
 *
 */

public class Ejercicio4 {

	public static void main(String[] args) throws IOException {

		char carac1;
		char carac2;

		System.out.print("Introduzca el primer carácter: ");
		carac1 = (char) System.in.read();
		System.in.read();
		System.in.read();

		System.out.print("Introduzca el segundo carácter: ");
		carac2 = (char) System.in.read();

		String IGUALES = (carac1 == carac2) ? "SON IGUALES" : "SON DISTINTOS";

		System.out.println("Los caracteres introducidos son: " + IGUALES);
	}

}
