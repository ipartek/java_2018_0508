package com.ipartek.formacion.cadenas_de_caracteres;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Clase que cuenta el número de palabras de una frase con el uso de la clase
 * StringTokenizer.
 * 
 * @see StringTokenizer
 * 
 * @author Luis
 *
 */
public class Ejercicio1 {

	static Scanner sc = new Scanner(System.in);

	static String texto = "";

	static StringTokenizer st = null;

	final static String DELIM = " \t"; // Los delimitadores son espacio y tabulación

	public static void main(String[] args) {

		System.out.println("Introduce un texto: ");
		texto = sc.nextLine();

		st = new StringTokenizer(texto, DELIM); // Creamos el StringTokenizer con los delimitadores indicados

		System.out.println("Número de palabras: " + st.countTokens());

	} // FIN main();

} // FIN Ejercicio1
