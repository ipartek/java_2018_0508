package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * 11. Convertir a Números nRomanos
 * @see http://www.transliteration.kpr.eu/tk/
 * @author Curso
 *
 */
public class Ejercicio10 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n;
		String nRomano = "";

		System.out.println("Dame un numero entre 1  y 3999:");
		n = sc.nextInt();

		int miles = n / 1000;
		n = n % 1000;
		for (int i = 0; i < miles; i++) {
			nRomano = nRomano + "M";
		}

		int cientos = n / 100;
		n = n % 100;

		if (cientos == 9) {
			nRomano = nRomano + "CM";
		} else if (cientos >= 5) {
			nRomano = nRomano + "D";
			for (int i = 6; i <= cientos; i++) {
				nRomano = nRomano + "C";
			}
		} else if (cientos == 4) {
			nRomano = nRomano + "CD";
		} else {
			for (int i = 1; i <= cientos; i++) {
				nRomano = nRomano + "C";
			}
		}

		int diezmos = n / 10;
		n = n % 10;
		if (diezmos == 9) {
			nRomano = nRomano + "XC";
		} else if (diezmos >= 5) {
			nRomano = nRomano + "L";
			for (int i = 6; i <= diezmos; i++) {
				nRomano = nRomano + "X";
			}
		} else if (diezmos == 4) {
			nRomano = nRomano + "XL";
		} else {
			for (int i = 1; i <= diezmos; i++) {
				nRomano = nRomano + "X";
			}
		}

		if (n == 9) {
			nRomano = nRomano + "IX";
		} else if (n >= 5) {
			nRomano = nRomano + "V";
			for (int i = 6; i <= n; i++) {
				nRomano = nRomano + "I";
			}
		} else if (n == 4) {
			nRomano = nRomano + "IV";
		} else {
			for (int i = 1; i <= n; i++) {
				nRomano = nRomano + "I";
			}
		}

		System.out.println(nRomano);
		sc.close();

	}

}
