package com.ipartek.formacion.generales;

import java.util.Scanner;

/**
 * Programa para codificar o decodificar un texto utilizando el método de
 * cifrado de César. Supondremos que el texto solo contiene letras mayúsculas o
 * minúsculas. La letras serán las correspondientes al alfabeto inglés. En este
 * método de cifrado cada letra del texto se sustituye por otra letra que se
 * encuentra N posiciones delante en el alfabeto. Se considera que el alfabeto
 * es circular, es decir, la letra siguiente a la ‘z’ es la ‘a’.
 * 
 * @author Curso
 *
 */
public class Ejercicio10 {

	static Scanner sc = new Scanner(System.in);
	final static String ALPHABET = "abcdefghijklmnopkrstuvwxyz";
	static String msj;
	static int cod;
	static String op;

	public static void main(String[] args) {

		String s;

		System.out.println("Mensaje a codificar (en una sola línea): ");
		msj = sc.nextLine();

		System.out.println("Clave de cifrado): ");
		cod = sc.nextInt();

		System.out.println("Pulse 'C' para codificar y 'D' para descodificar:");
		op = sc.next();

		if ("C".equals(op)) {
			s = codificar(msj, true);
		} else {
			s = codificar(msj, false);
		}

		System.out.println("Mensaje original: ");
		System.out.println(msj);
		System.out.println("Mensaje codificado/descodificado: ");
		System.out.println(s);
	}

	public static String codificar(String m, boolean op) {
		String s = "";
		int[] pos = new int[m.length()];

		for (int i = 0; i < m.length(); i++) {
			for (int j = 0; j < ALPHABET.length(); j++) {
				if (Character.toLowerCase(m.charAt(i)) == ALPHABET.charAt(j)) {
					pos[i] = j;
				}
			}
		}

		for (int i = 0; i < pos.length; i++) {
			if (op) {
				s += ALPHABET.charAt(setCodToIndex(pos[i]));
			} else {
				s += ALPHABET.charAt(removeCodToIndex(pos[i]));
			}

		}
		return s;
	}

	private static int setCodToIndex(int i) {
		if (i + cod < 26) {
			return i + cod;
		} else {
			return ((i + cod) - 26);
		}
	}

	private static int removeCodToIndex(int i) {
		if (i - cod >= 0) {
			return i - cod;
		} else {
			return ((i - cod) + 26);
		}
	}

}
