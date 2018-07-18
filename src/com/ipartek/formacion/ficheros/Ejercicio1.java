package com.ipartek.formacion.ficheros;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Programa Java que lee texto por teclado y lo escribe en un fichero de texto
 * llamado datos.txt. El proceso consiste en leer una línea de texto por teclado
 * y escribirla en el fichero. Este proceso se repite hasta que se introduce por
 * teclado la cadena FIN. La cadena FIN que indica el final de lectura no se
 * debe escribir en el fichero.
 * 
 * @see FileWriter, PrintWriter
 * 
 * @author Luis
 *
 */
public class Ejercicio1 {

	static final String FIN = "FIN";

	static Scanner sc = new Scanner(System.in);

	static FileWriter fichero = null;
	static PrintWriter pw = null;

	public static void main(String[] args) {

		try {
			crearFichero();

			System.out.println("Fichero creado con �xito.");

		} catch (IOException e) { // Capturamos cualquier excepción y la mostramos

			System.out.println(e.getMessage());

		} finally {
			try {

				if (null != fichero) {
					fichero.close();
				}
				System.out.println("Fichero cerrado con �xito.");

			} catch (Exception e2) {

				System.out.println(e2.getMessage());
			}
		} 

		sc.close(); // Cerramos el Scanner

	} 
	
	private static void crearFichero() throws IOException {

		String linea;

		fichero = new FileWriter("c:/datos.txt"); // Abrimos el fichero en modo escritura

		pw = new PrintWriter(fichero); // Usamos PrintWriter para escribir sobre fichero

		System.out.println("Introduce texto. Para acabar introduce la cadena FIN:");
		linea = sc.nextLine(); // Leemos la primera línea de la consola

		while (!FIN.equalsIgnoreCase(linea)) { // Escribimos sobre el fichero

			pw.println(linea);
			linea = sc.nextLine(); // Seguimos leyendo líneas
		}
		pw.flush(); // Obligamos a PrintWriter a volcar toda la información que queda

	} 

}
