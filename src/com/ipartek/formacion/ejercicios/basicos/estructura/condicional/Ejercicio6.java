package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.io.IOException;

/**
 * 6. Programa que lea un carácter y compruebe si es un número (Carácter entre
 * '0' y '9').
 * 
 * @author Curso
 *
 */
public class Ejercicio6 {

	public static void main(String[] args) throws IOException {
		
		char c1;
		
		System.out.print("Introduzca carácter: ");
		c1 = (char) System.in.read();
		
		if (Character.isDigit(c1)) {
			System.out.println("Es un número");
		}else {
			System.out.println("No es un número");
		}

	}

}
