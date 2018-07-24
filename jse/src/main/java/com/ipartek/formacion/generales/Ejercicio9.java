package com.ipartek.formacion.generales;

import java.util.Scanner;

/*
 * Programa Java para convertir un número entero a números romanos.
 * El programa pide un número entre 1 y 3999 y calcula su equivalente en números romanos. 
 * Se utiliza un método llamado convertirANumerosRomanos que recibe el número N a convertir
 * de tipo int y devuelve un String con el equivalente en números romanos.
 * Para convertirlo se obtiene por separado cada cifra del número y se muestran las 
 * combinaciones de letras del número romano equivalentes a cada cifra del número original. 
 * Este método no utiliza arrays de modo que este programa se puede resolver sin haber estudiado aún los arrays.
 */
public class Ejercicio9 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int n;
		String res;

		System.out.println("Introduce un valor entre 0 - 3999: ");

		n = sc.nextInt();
		res = convertirANumerosRomanos(n);

		System.out.println(n + " = " + res);

	}

	public static String convertirANumerosRomanos(int num) {

		int m = num / 1000;
		int c = (num % 1000) / 100;
		int d = ((num % 1000) % 100) / 10;
		int u = (((num % 1000) % 100) % 10);

		String mi = "";
		String ce = "";
		String de = "";
		String un = "";

		switch (m) {
		case 1:
			mi += "M";
			break;
		case 2:
			mi += "MM";
			break;
		case 3:
			mi += "MMM";
			break;
		}

		switch (c) {
		case 1:
			ce += "C";
			break;
		case 2:
			ce += "CC";
			break;
		case 3:
			ce += "CCC";
			break;
		case 4:
			ce += "CD";
			break;
		case 5:
			ce += "D";
			break;
		case 6:
			ce += "DC";
			break;
		case 7:
			ce += "DCC";
			break;
		case 8:
			ce += "DCCC";
			break;
		case 9:
			ce += "CM";
			break;
		}

		switch (d) {
		case 1:
			de += "X";
			break;
		case 2:
			de += "XX";
			break;
		case 3:
			de += "XXX";
			break;
		case 4:
			de += "XL";
			break;
		case 5:
			de += "L";
			break;
		case 6:
			de += "LX";
			break;
		case 7:
			de += "LXX";
			break;
		case 8:
			de += "LXXX";
			break;
		case 9:
			de += "XC";
			break;
		}

		switch (u) {
		case 1:
			un += "I";
			break;
		case 2:
			un += "II";
			break;
		case 3:
			un += "III";
			break;
		case 4:
			un += "IV";
			break;
		case 5:
			un += "V";
			break;
		case 6:
			un += "VI";
			break;
		case 7:
			un += "VII";
			break;
		case 8:
			un += "VIII";
			break;
		case 9:
			un += "IX";
			break;
		}

		return mi + ce + de + un;
	}

}
