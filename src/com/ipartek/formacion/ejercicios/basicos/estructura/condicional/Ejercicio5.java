package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.io.IOException;

/**
 * 
 * 
 * @author Asier Cornejo
 *
 *
 *         Programa que lea dos caracteres y compruebe si son dos letras
 *         minúsculas.
 */
public class Ejercicio5 {

	public static void main(String[] args) throws IOException {
		char letra;
		char letra2;
		System.out.print("Introduzca un carácter: ");
		letra = (char) System.in.read();
		System.in.read();
		System.in.read();
		System.out.print("Introduzca el segundo carácter: ");
		letra2 = (char) System.in.read();
		if (Character.isLowerCase(letra)) {

			if (Character.isLowerCase(letra2)) {
				System.out.println("Los dos carácteres " + letra + " y " + letra2 + " son minúsculas");
			} else {
				System.out.println(
						"El carácter " + letra + "es minúscula pero el carácter " + letra2 + " no es minúscula");
			}
		} else {
			if (Character.isLowerCase(letra2)) {
				System.out
						.println("El carácter " + letra + " no es minúscula pero el carácter " + letra2 + " sí lo es");
			} else {
				System.out.println("Ni el carácter " + letra + " ni el el carácter " + letra2 + " son minúsculas");
			}

		}

	}

}
