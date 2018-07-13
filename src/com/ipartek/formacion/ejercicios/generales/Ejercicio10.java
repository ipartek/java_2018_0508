package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * 11. Convertir a Números Romanos
 * 
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

		//TODO hacer bien las condicionales
		
		if (cientos < 9) {
			if (cientos >= 5) {
				for (int i = cientos; i >= 5; i--) {
					nRomano = nRomano + "D";
				}
			} else if (cientos == 4) {
				nRomano = nRomano + "CD";
			} else {
				for (int i = 0; i < cientos; i++) {
					nRomano = nRomano + "C";
				}
			}
		} else {
			nRomano = nRomano + "CM";
		}

		int diezmos = n / 10;
		n = n % 10;
		for (int i = 0; i < diezmos; i++) {
			nRomano = nRomano + "X";
		}

		for (int i = 0; i < n; i++) {
			nRomano = nRomano + "I";
		}

		System.out.println(nRomano);
		sc.close();

	}

}
