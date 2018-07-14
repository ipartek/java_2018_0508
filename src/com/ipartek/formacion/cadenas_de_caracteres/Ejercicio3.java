package com.ipartek.formacion.cadenas_de_caracteres;

import java.util.Scanner;

/**
 * Clase java que cuenta cuántas veces aparece un carácter dentro de un texto.
 * Ambos se piden por teclado.
 * 
 * @author Luis
 *
 */
public class Ejercicio3 {

	static Scanner sc = new Scanner(System.in);

	static String texto = "";

	static char c;

	public static void main(String[] args) {

		leerCaracter();
		leerTexto();

		int n = contarCaracteres();
		System.out.println("Número de veces que aparece '" + Character.toString(c) + "' en el texto: " + n);

	}

	private static int contarCaracteres() {

		int cont = 0;

		for (int i = 0; i < texto.length(); i++) {
			if (c == texto.charAt(i)) {
				cont++;
			}
		}
		return cont;

	} // FIN contarCaracteres();

	private static void leerCaracter() {

		System.out.println("Introduce un carácter: ");

		c = sc.nextLine().charAt(0); // Como sólo queremos leer un carácter, cogemos la primera posición de la línea

	} // FIN leerCaracter();

	private static void leerTexto() {

		System.out.println("Introduce el texto: ");
		texto = sc.nextLine();

	} // FIN leerTexto();

} // FIN Ejercicio3
