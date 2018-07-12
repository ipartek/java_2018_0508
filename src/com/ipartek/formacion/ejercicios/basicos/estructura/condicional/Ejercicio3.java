package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * @author Asier Cornejo Programa que lea un carácter por teclado y compruebe si
 *         es una letra mayúscula.
 */
public class Ejercicio3 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		char letra;
		System.out.print("Introduzca un carácter: ");

		letra = (char) System.in.read();

		if (Character.isUpperCase(letra))
			System.out.println(letra + " es una letra mayúscula");
		else
			System.out.println(letra + " no es una letra mayúscula");
		sc.close();
	}

}
