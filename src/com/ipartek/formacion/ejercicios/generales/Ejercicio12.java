package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * Cifrado Cesar para codificar y decodificar un texto
 * 
 * @author andreaperez
 *
 */
public class Ejercicio12 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String texto = "Tengo el examen resuelto";
		String respuesta = "C";
		int nCodigo = 0;

		do {
			System.out.println("Introduce texto:");
			texto = sc.next();

			sc.nextLine();
			System.out.println("Introduce lugares a desplazar:");
			nCodigo = sc.nextInt();
		} while (nCodigo < 1 || texto.isEmpty());

		do {
			System.out.print("(C) cifrar o (D) descifrar?: ");
			respuesta = sc.next();
		} while (!"c".equalsIgnoreCase(respuesta) && !"d".equalsIgnoreCase(respuesta));

		if ("c".equalsIgnoreCase(respuesta)) {
			System.out.println("Texto cifrado: " + cifradoTexto(texto, nCodigo));
		} else {
			System.out.println("Texto cifrado: " + desCifradoTexto(texto, nCodigo));
		}

		sc.close();
	}

	private static String desCifradoTexto(String texto, int nCodigo) {

		StringBuilder cifrado = new StringBuilder();
		
		nCodigo = nCodigo % 26;
		
		for (int i = 0; i < texto.length(); i++) {
			if (texto.charAt(i) >= 'a' && texto.charAt(i) <= 'z') {
				if ((texto.charAt(i) - nCodigo) < 'a') {
					cifrado.append((char) (texto.charAt(i) - nCodigo + 26));
				} else {
					cifrado.append((char) (texto.charAt(i) - nCodigo));
				}
			} else if (texto.charAt(i) >= 'A' && texto.charAt(i) <= 'Z') {
				if ((texto.charAt(i) - nCodigo) < 'A') {
					cifrado.append((char) (texto.charAt(i) - nCodigo + 26));
				} else {
					cifrado.append((char) (texto.charAt(i) - nCodigo));
				}
			}
		}
		
		return cifrado.toString();
	}

	private static String cifradoTexto(String texto, int nCodigo) {
		StringBuilder cifrado = new StringBuilder();

		nCodigo = nCodigo % 26;

		for (int i = 0; i < texto.length(); i++) {
			if (texto.charAt(i) >= 'a' && texto.charAt(i) <= 'z') {
				if ((texto.charAt(i) + nCodigo) > 'z') {
					cifrado.append((char) (texto.charAt(i) + nCodigo - 26));
				} else {
					cifrado.append((char) (texto.charAt(i) + nCodigo));
				}
			} else if (texto.charAt(i) >= 'A' && texto.charAt(i) <= 'Z') {
				if ((texto.charAt(i) + nCodigo) > 'Z') {
					cifrado.append((char) (texto.charAt(i) + nCodigo - 26));
				} else {
					cifrado.append((char) (texto.charAt(i) + nCodigo));
				}
			}
		}

		return cifrado.toString();
	}

}
