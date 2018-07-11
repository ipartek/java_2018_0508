package com.ipartek.formacion.ejercicios.estructura.condicional;

import java.io.IOException;

/**
 * Programa que lea un carácter por teclado y compruebe si es una letra mayúscula
 * @author Curso
 *
 */

public class Ejercicio3 {

	public static void main(String[] args) throws IOException {
		
		char n;
		
		System.out.println("Introduce un character:");
		n = (char)System.in.read();

		if(Character.isLowerCase(n)) {
			System.out.println(n + " es minuscula.");
		}else {
			System.out.println(n + " es mayuscula.");
		}
		
	}

}
