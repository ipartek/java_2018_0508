package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.io.IOException;

/**
 * Programa que lea un carácter por teclado y compruebe si es una letra
 * mayúscula
 * 
 */

public class Ejercicio3 {

	public static void main(String[] args) throws IOException {

		System.out.print("Introduzca un carácter: ");
		char ch = (char)System.in.read();
		System.out.println("'"+ch+"'"+((Character.isUpperCase(ch))?" es una leta mayúscula":" es una letra minúscula"));

	}

}
