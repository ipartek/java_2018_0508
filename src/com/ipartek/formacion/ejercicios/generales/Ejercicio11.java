package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * 
 * Programa Java para convertir un número entero a números romanos. El programa
 * pide un número entre 1 y 3999 y calcula su equivalente en números romanos. Se
 * utiliza un método llamado convertirANumerosRomanos que recibe el número N a
 * convertir de tipo int y devuelve un String con el equivalente en números
 * romanos. Para convertirlo se obtiene por separado cada cifra del número y se
 * muestran las combinaciones de letras del número romano equivalentes a cada
 * cifra del número original. Este método no utiliza arrays de modo que este
 * programa se puede resolver sin haber estudiado aún los arrays.
 *
 */

public class Ejercicio11 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numero;
		do {
			System.out.print("Introduce un número entre 1 y 3999: ");
			numero = sc.nextInt();
		} while (numero < 1 || numero > 3999);
		System.out.println(numero + " en numeros romanos -> " + convertirANumerosRomanos(numero));
	
		sc.close();
	}

	private static String convertirANumerosRomanos(int numero) {
		int i, miles, centenas, decenas, unidades;
		String romano = "";

		miles = numero / 1000;
		centenas = numero / 100 % 10;
		decenas = numero / 10 % 10;
		unidades = numero % 10;

		// millar
		for (i = 1; i <= miles; i++) {
			romano = romano + "M";
		}

		// centenas
		if (centenas == 9) {
			romano = romano + "CM";
		} else if (centenas >= 5) {
			romano = romano + "D";
			for (i = 6; i <= centenas; i++) {
				romano = romano + "C";
			}
		} else if (centenas == 4) {
			romano = romano + "CD";
		} else {
			for (i = 1; i <= centenas; i++) {
				romano = romano + "C";
			}
		}

		// Decenas

		if (decenas == 9) {
			romano = romano + "XC";
		} else if (decenas >= 5) {
			romano = romano + "L";
			for (i = 6; i <= decenas; i++) {
				romano = romano + "X";
			}
		} else if (decenas == 4) {
			romano = romano + "XL";
		} else {
			for (i = 1; i <= decenas; i++) {
				romano = romano + "X";
			}
		}

		// unidades
		if (unidades == 9) {
			romano = romano + "IX";
		} else if (unidades >= 5) {
			romano = romano + "V";
			for (i = 6; i <= unidades; i++) {
				romano = romano + "I";
			}
		} else if (unidades == 4) {
			romano = romano + "IV";
		} else {
			for (i = 1; i <= unidades; i++) {
				romano = romano + "I";
			}
		}

		return romano;
		
	}

}
