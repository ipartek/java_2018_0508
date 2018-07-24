package com.ipartek.formacion.cadenas;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 
 * @author Luis
 *
 */
public class Ejercicio2 {

	static Scanner sc = new Scanner(System.in);

	static String texto = "";

	static StringTokenizer st = null;

	final static String DELIM = " \t"; // Los delimitadores son espacio y tabulación

	public static void main(String[] args) {
		
		String nuevoTxt = "";

		System.out.println("Introduce un texto: ");
		texto = sc.nextLine();

		nuevoTxt = eliminarUltimaPalabra(texto);

		System.out.println("El nuevo texto es: ");
		System.out.println(nuevoTxt);

	} 

	private static String eliminarUltimaPalabra(String s) {
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(texto, DELIM); // Creamos el StringTokenizer con los delimitadores indicados

		int tam = st.countTokens(); // Guardamos el n�mero de tokens para hacer una sola llamada a la función

		for (int i = 0; i < tam - 1; i++) { // En la condición eliminamos la última palabra

			sb.append(st.nextToken() + " "); // Leemos cada elemento del StringTokenizer y añadimos los espacios

		}

		return sb.toString();

	} 

} 
