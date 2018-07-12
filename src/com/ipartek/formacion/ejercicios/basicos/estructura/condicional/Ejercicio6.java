package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.io.IOException;

/**
 * Programa java que lea un carácter por teclado y compruebe si es un dígito numérico <br>
 * (cifra entre 0 y 9). <br>
 * Vamos a escribir dos soluciones a este ejercicio.<br>
 * La primera consiste en comprobar si el carácter es un dígito mediante el método isDigit de la <br>
 * clase Character.<br>
 * Este método devuelve true si el carácter que se le pasa como parámetro es una cifra entre 0 y 9:<br>
 * @param args
 */

public class Ejercicio6 {

	public static void main(String[] args) throws IOException {
		char carac;

		System.out.println("Introduce una letra: ");
		carac = (char) System.in.read();
		System.in.read();

		String NUM=(Character.isDigit(carac))?"ES NUMERICO": "NO ES NUMERICO";
		
		System.out.println("El caracter introducido es : " + NUM);
	}

}
