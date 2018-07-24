package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.util.Scanner;

/**
 * 3. Programa que lea un carácter por teclado y compruebe si es una letra
 * mayúscula
 * 
 * @author valen
 *
 */

public class Ejercicio3 {
	public static void main(String[] args) {
		Scanner p = new Scanner(System.in);
		char letra;
		System.out.println("Ingrese el caracter = ");
		letra = p.nextLine().charAt(0);

		if (letra >= 'a' && letra <= 'z') {
			System.out.println("Es una letra minuscula");
		} else {
			System.out.println("Es una letra mayuscula");
		}

	}

}
