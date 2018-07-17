package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * Programa Java para convertir un número entero a números romanos. El programa
 * pide un número entre 1 y 3999 y calcula su equivalente en números romanos. Se
 * utiliza un método llamado convertirANumerosRomanos que recibe el número N a
 * convertir de tipo int y devuelve un String con el equivalente en números
 * romanos. Para convertirlo se obtiene por separado cada cifra del número y se
 * muestran las combinaciones de letras del número romano equivalentes a cada
 * cifra del número original. Este método no utiliza arrays de modo que este
 * programa se puede resolver sin haber estudiado aún los arrays.
 * 
 * @author valen
 *
 */

public class Ejercicio11 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numero1;
		do {
			System.out.println("Ingresa un numero : ");
			numero1 = s.nextInt();
		} while (numero1 < 1 || numero1 > 3999);
		System.out.println("En numero romanos son = ");
	}

	public static String numerosRomanos(int numero) {
		int i;
		int miles;
		int centenas;
		int decenas;
		return null;

	}
}
