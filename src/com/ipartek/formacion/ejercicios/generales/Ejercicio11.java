package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * Ejercicio 11 - Cifrado cesar
 * 
 * @author Curso
 *
 */
public class Ejercicio11 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n;
		String palabra;
		String pCesar;

		System.out.println("Introduce una palabra:");
		palabra = sc.next();

		System.out.println("Dime la n para descifrar/codificar:");
		n = sc.nextInt();

		pCesar = cifradoCesar(palabra, n);

		System.out.println(palabra + " en Cesar(a cifrar)" + n + " es " + pCesar);

		palabra = descifradoCesar(pCesar, n);
		
		System.out.println(pCesar + " en Cesar(a descifrar)" + n + " es " + palabra);
		
		sc.close();
	}

	/**
	 * Metodo de cifrado Cesar
	 * 
	 * @param texto  String a cifrar
	 * @param codigo int el nivel de cifrado
	 * @return String el texto ya cifrado
	 */
	public static String cifradoCesar(String texto, int codigo) {
		StringBuilder cifrado = new StringBuilder();
		codigo = codigo % 26;
		for (int i = 0; i < texto.length(); i++) {
			if (texto.charAt(i) >= 'a' && texto.charAt(i) <= 'z') {
				if ((texto.charAt(i) + codigo) > 'z') {
					cifrado.append((char) (texto.charAt(i) + codigo - 26));
				} else {
					cifrado.append((char) (texto.charAt(i) + codigo));
				}
			} else if (texto.charAt(i) >= 'A' && texto.charAt(i) <= 'Z') {
				if ((texto.charAt(i) + codigo) > 'Z') {
					cifrado.append((char) (texto.charAt(i) + codigo - 26));
				} else {
					cifrado.append((char) (texto.charAt(i) + codigo));
				}
			}
		}
		return cifrado.toString();
	}

	/**
	 * Metodo de cifrado Cesar
	 * 
	 * @param texto  String a cifrar
	 * @param codigo codigo int el nivel de cifrado
	 * @return String el texto ya descifrado
	 */
	public static String descifradoCesar(String texto, int codigo) {
		StringBuilder cifrado = new StringBuilder();
		codigo = codigo % 26;
		for (int i = 0; i < texto.length(); i++) {
			if (texto.charAt(i) >= 'a' && texto.charAt(i) <= 'z') {
				if ((texto.charAt(i) - codigo) < 'a') {
					cifrado.append((char) (texto.charAt(i) - codigo + 26));
				} else {
					cifrado.append((char) (texto.charAt(i) - codigo));
				}
			} else if (texto.charAt(i) >= 'A' && texto.charAt(i) <= 'Z') {
				if ((texto.charAt(i) - codigo) < 'A') {
					cifrado.append((char) (texto.charAt(i) - codigo + 26));
				} else {
					cifrado.append((char) (texto.charAt(i) - codigo));
				}
			}
		}
		return cifrado.toString();
	}

}
