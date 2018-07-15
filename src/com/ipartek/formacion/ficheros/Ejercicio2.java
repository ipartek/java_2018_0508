package com.ipartek.formacion.ficheros;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Programa que leer por teclado líneas de texto y las añade al final del
 * ficheros datos.txt. Para resolverlo vamos a modificar el programa anterior
 * para que añada texto al fichero datos.txt, es decir, al volver a ejecutar el
 * programa el contenido anterior del fichero no se pierde y el contenido nuevo
 * se añade al final.
 * 
 * @see FileWriter, PrintWriter
 * 
 * @author Luis
 *
 */
public class Ejercicio2 {

	static final String FIN = "FIN";

	static Scanner sc = new Scanner(System.in);

	static FileWriter fichero = null;

	public static void main(String[] args) {

		try {
			cargarFichero();

			escribirFichero();

			System.out.println("Fichero modificado con éxito.");

		} catch (IOException e) { // Capturamos cualquier excepción

			System.out.println(e.getMessage()); // Mostramos el mensaje por consola

		} finally {
			try {

				if (null != fichero) {
					fichero.close(); // Cerramos PrinWriter
				}
				System.out.println("Fichero cerrado con éxito.");

			} catch (Exception e2) {
				System.out.println(e2.getMessage()); // Mostramos el mensaje por consola
			}
		} // FIN finally

		sc.close();

	} // FIN main

	private static void cargarFichero() throws IOException {

		fichero = new FileWriter("c:/datos.txt", true); // Abrimos el fichero en modo escritura e indicamos que vamos a
														// añadir datos

	} // FIN cargarFichero();

	private static void escribirFichero() {

		PrintWriter pw = null;

		String linea;

		pw = new PrintWriter(fichero);

		System.out.println("Introduce el texto. Para acabar introduce la cadena FIN:");
		linea = sc.nextLine(); // Leemos la primera línea de la consola

		while (!FIN.equalsIgnoreCase(linea)) { // Escribimos sobre el fichero

			pw.println(linea);
			linea = sc.nextLine(); // Seguimos leyendo líneas
		}
		pw.flush(); // Obligamos a PrintWriter a volcar toda la información que queda

	} // FIN escribirFichero();

}
