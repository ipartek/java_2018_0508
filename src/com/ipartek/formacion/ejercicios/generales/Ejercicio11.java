package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * 11. Convertir a Números Romanos
 * 
 * @author Curso
 *
 */
public class Ejercicio11 {

	private static Scanner scan;

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		int num;
		do {
			System.out.print("Introduce un número entre 1 y 3999: ");
			num = scan.nextInt();
		} while (num < 1 || num > 3999);
		System.out.println(num + " en numeros romanos -> " + convertirANumerosRomanos(num));
	}

	public static String convertirANumerosRomanos(int numero) {
		int i, miles, centenas, decenas, unidades;
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
