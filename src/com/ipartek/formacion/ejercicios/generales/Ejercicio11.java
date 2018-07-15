package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * Convertir a Números Romanos El programa pide un número entre 1 y 3999 y
 * calcula su equivalente en números romanos. Se utiliza un método llamado
 * convertirANumerosRomanos que recibe el número N a convertir de tipo int y
 * devuelve un String con el equivalente en números romanos. Para convertirlo se
 * obtiene por separado cada cifra del número y se muestran las combinaciones de
 * letras del número romano equivalentes a cada cifra del número original. Este
 * método no utiliza arrays de modo que este programa se puede resolver sin
 * haber estudiado aún los arrays.
 * 
 * 
 * @author andreaperez
 *
 */
public class Ejercicio11 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = 0;

		do {

			System.out.println("Escribe un numero entre 1 y 3999 ");
			n = sc.nextInt();

		} while (n < 1 || n > 3999);

		System.out.println(n + " en numeros romanos -> " + convertirANumerosRomanos(n));

		sc.close();

	}

	public static String convertirANumerosRomanos(int n) {
		String numRomano = "";
		int unidades = 0;
		int decenas = 0;
		int centenas = 0;
		int millar = 0;

		// obtenemos cada cifra
		millar = n / 1000;
		centenas = n / 100 % 10;
		decenas = n / 10 % 10;
		unidades = n % 10;

		// millar
		for (int i = 1; i <= millar; i++) {
			numRomano = numRomano + "M";
		}

		// centenas
		if (centenas == 9) {
			numRomano = numRomano + "CM";
		} else if (centenas >= 5) {
			numRomano = numRomano + "D";
			for (int i = 6; i <= centenas; i++) {
				numRomano = numRomano + "C";
			}
		} else if (centenas == 4) {
			numRomano = numRomano + "CD";
		} else {
			for (int i = 1; i <= centenas; i++) {
				numRomano = numRomano + "C";
			}
		}

		// decenas
		if (decenas == 9) {
			numRomano = numRomano + "XC";
		} else if (decenas >= 5) {
			numRomano = numRomano + "L";
			for (int i = 6; i <= decenas; i++) {
				numRomano = numRomano + "X";
			}
		} else if (decenas == 4) {
			numRomano = numRomano + "XL";
		} else {
			for (int i = 1; i <= decenas; i++) {
				numRomano = numRomano + "X";
			}
		}

		// unidades
		if (unidades == 9) {
			numRomano = numRomano + "IX";
		} else if (unidades >= 5) {
			numRomano = numRomano + "V";
			for (int i = 6; i <= unidades; i++) {
				numRomano = numRomano + "I";
			}
		} else if (unidades == 4) {
			numRomano = numRomano + "IV";
		} else {
			for (int i = 1; i <= unidades; i++) {
				numRomano = numRomano + "I";
			}
		}

		return numRomano;
	}

}
