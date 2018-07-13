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

	public static void main(String[] args) throws IOException {
		String alphabet="abcdefghijklmnopqrstuvwxyz";
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

		do {
			teclado.nextLine();
			System.out.print("(C) cifrar o (D) descifrar?: ");
			option = (char) System.in.read();
		} while (Character.toUpperCase(option) != 'C' || Character.toUpperCase(option) != 'D');
		
		

	}
	
	public static void cesarCode(String text,int position, String encode) {
		
		for (int i = 0; i < text.length(); i++) {
			
		}
		
	}

}
