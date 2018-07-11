package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

/**
 * Programa que lea un carácter por teclado y compruebe si es una letra mayúscula
 */

import java.io.IOException;
import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) throws IOException {
		char letra;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce una letra");
		letra = (char)System.in.read();
		
		if(letra >= 'A' && letra <= 'Z') {
			System.out.println("Es una letra mayuscula");
		}
		else {
			System.out.println("Es una letra minuscula	");
		}
		sc.close();
	}

}
