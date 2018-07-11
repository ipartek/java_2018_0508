package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.io.IOException;

/**
 * Programa java que lea dos caracteres por teclado y compruebe si los dos son
 * letras minúscula
 */

public class Ejercicio5 {

	public static void main(String[] args) throws IOException {
		System.out.print("Introduzca un carácter: ");
		char ch = (char)System.in.read();
		System.out.println("'"+ch+"'"+(!(Character.isLowerCase(ch))?" es una leta mayúscula":" es una letra minúscula"));

	}

}
