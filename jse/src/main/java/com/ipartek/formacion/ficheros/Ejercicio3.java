package com.ipartek.formacion.ficheros;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Programa Java que lee el contenido del fichero datos.txt creado en el ejemplo
 * anterior y lo muestra por pantalla. El proceso consiste en leer una línea del
 * fichero y mostrarla por pantalla.
 * 
 * @see FileReader, BufferedReader
 * 
 * @author Luis
 *
 */
public class Ejercicio3 {

	static Scanner sc = new Scanner(System.in);

	static FileReader fr = null;

	static BufferedReader br = null;

	public static void main(String[] args) {

		System.out.println("Leyendo el fichero...\n");
		try {
			abrirFichero();

			leerFichero();

			System.out.println("\nFichero leido con éxito.");

		} catch (IOException e) { // Capturamos cualquier excepción

			System.out.println(e.getMessage()); // Mostramos el mensaje por consola

		} finally {
			try { // Intentamos cerrar FileReader

				if (null != fr) {
					fr.close(); // Cerramos FileReader
				}
				System.out.println("Fichero cerrado con éxito.");

			} catch (Exception e2) { // Capturamos cualquier excepción

				System.out.println(e2.getMessage()); // Mostramos el mensaje por consola
			}
		} // FIN finally

		sc.close();

	} // FIN main();

	private static void abrirFichero() throws FileNotFoundException {

		fr = new FileReader("c:/datos.txt"); // Abrimos el fichero en modo lectura
	}

	private static void leerFichero() throws IOException {

		String linea;

		br = new BufferedReader(fr);

		linea = br.readLine(); // Leemos la primera línea

		while (linea != null) { // Mientras haya más líneas

			System.out.println(linea); // Mostramos la línea por pantalla
			linea = br.readLine(); // Leemos la siguiente línea
		}
	}

} // FIN Ejercicio3
