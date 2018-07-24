package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * 
 * @author Asier Cornejo
 * 
 *         Programa que lea un carácter y compruebe si es un número (Carácter
 *         entre '0' y '9').
 *
 * 
 */
public class Ejercicio6 {

	public static void main(String[] args) throws IOException {
		char carac;
		System.out.println("Introduce un carácter para saber si es un número");
		Scanner sc = new Scanner(System.in);
		carac = (char) System.in.read();
		if (Character.isDigit(carac)) {
			System.out.println("El carácter " + carac + " es un número");
		} else {
			System.out.println("El carácter " + carac + " no es un número");
		}
		sc.close();
	}

}
