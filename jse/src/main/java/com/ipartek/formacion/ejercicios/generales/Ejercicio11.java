package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * 
 * 
 * @author Asier Cornejo
 * 
 *         Convertir a Números Romanos.
 * 
 *         El programa pide un número entre 1 y 3999 y calcula su equivalente
 *         en<br>
 *         números romanos. Se utiliza un método llamado<br>
 *         convertirANumerosRomanos que recibe el número N a convertir de
 *         tipo<br>
 *         int y devuelve un String con el equivalente en números romanos.
 *         Para<br>
 *         convertirlo se obtiene por separado cada cifra del número y se<br>
 *         muestran las combinaciones de letras del número romano equivalentes
 *         a<br>
 *         cada cifra del número original. Este método no utiliza arrays de
 *         modo<br>
 *         que este programa se puede resolver sin haber estudiado aún los<br>
 *         arrays.
 *
 */
public class Ejercicio11 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N;
		do {
			System.out.print("Introduce un número entre 1 y 3999: ");
			N = sc.nextInt();
		} while (N < 1 || N > 3999);
		System.out.println(N + " en numeros romanos -> " + convertirANumerosRomanos(N));
		sc.close();
	}

	/**
	 * Metodo para convertir a numeros romanos
	 * 
	 * @param entero que se desea convertir a numeros romanos
	 * @return String con el numero convertido a romano
	 */
	public static String convertirANumerosRomanos(int numero) {
		int i;
		int miles;
		int centenas;
		int decenas;
		int unidades;
		String romano = "";

		miles = numero / 1000;
		centenas = numero / 100 % 10;
		decenas = numero / 10 % 10;
		unidades = numero % 10;

		
		for (i = 1; i <= miles; i++) {
			romano = romano + "M";
		}

		
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
