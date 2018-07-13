package com.ipartek.formacion.ejercicios.generales;

import java.io.IOException;
import java.util.Scanner;

/**
 * Cifrado Cesar para codificar y decodificar un texto.<br>
 * El programa pedirá por teclado un texto, a continuación el valor de N y si
 * queremos codificar o decodificar el texto. Finalmente se mostrará el texto
 * resultante.
 */
public class Ejercicio12 {

	public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

	public static void main(String[] args) throws IOException {

		Scanner teclado = new Scanner(System.in);
		String text;
		int code;
		char option;

		do {
			System.out.print("Introduce un texto: ");
			text = teclado.nextLine();
		} while (text.isEmpty());

		do {
			System.out.print("Introduce el código: ");
			code = teclado.nextInt();
		} while (code < 1);
		System.out.print("Codificacion: " + cesardecode(text, code));

		do {
			teclado.nextLine();
			System.out.print("(C) cifrar o (D) descifrar?: ");
			option = (char) System.in.read();

		} while (Character.toUpperCase(option) != 'C' && Character.toUpperCase(option) != 'D');
		System.out.println("Resultado: "+((Character.toUpperCase(option)=='C')?cesarCode(text,code):cesardecode(text,code)));
		teclado.close();
	}

	public static String cesarCode(String txt, int position) {

		String result = "";
		for (int i = 0; i < txt.length(); i++) {
			result += ((ALPHABET.indexOf(txt.charAt(i)) + position) >= ALPHABET.length())
					? ALPHABET.charAt((ALPHABET.indexOf(txt.charAt(i)) + position) - ALPHABET.length())
					: ALPHABET.charAt((ALPHABET.indexOf(txt.charAt(i)) + position));
		}
		return result;

	}

	public static String cesardecode(String txt, int position) {

		String result = "";
		for (int i = 0; i < txt.length(); i++) {
			result += ((ALPHABET.indexOf(txt.charAt(i)) - position) < 0)
					? ALPHABET.charAt((ALPHABET.indexOf(txt.charAt(i)) - position) + ALPHABET.length() - 1)
					: ALPHABET.charAt((ALPHABET.indexOf(txt.charAt(i)) - position));
		}
		return result;

	}

}
