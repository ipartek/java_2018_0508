package com.ipartek.formacion.ficheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Disponemos de un fichero de texto llamado enteros.txt que contiene números
 * enteros separados por comas, espacios en blanco y tabulaciones. El siguiente
 * programa lee los números usando la clase Scanner y los muestra. Muestra
 * también la cantidad de números leídos y su suma. El programa lee líneas
 * completas del fichero y las pasa a un StringTokenizer del que se extraen los
 * números.
 * 
 * @see Scanner, StringTokenizer
 * 
 * @author Luis
 *
 */
public class Ejercicio6 {

	static Scanner scConsola = new Scanner(System.in); // Scanner que leerá la consola

	static final String DELIM = " ,\t";

	static StringTokenizer tokens;
	static File fichero;

	static int suma;
	static int cont;

	public static void main(String[] args) {

		String ruta = "c:\\enteros.txt";

		System.out.println("Abriendo fichero " + ruta + " con la clase Scanner...");

		try {

			leerFichero(ruta);
			System.out.println("Fichero leído con éxito.");

		} catch (FileNotFoundException e) { // No existe el fichero en esa ruta

			System.out.println(e.getMessage());
		}

		scConsola.close();
		mostrarResultados();

	} // FIN main();

	private static void mostrarResultados() {

		System.out.println("La suma de los números es:" + suma);

		System.out.println("Leidos " + cont + " números del fichero.");

	} // FIN mostrarResultados();

	/**
	 * Procedimiento que lee los enteros de un fichero. La lectura acaba cuando no
	 * quedan más líneas.
	 * 
	 * @param ruta, String con la ruta del fichero
	 * @throws FileNotFoundException
	 */
	private static void leerFichero(String ruta) throws FileNotFoundException {

		Scanner scFichero = null; // Scanner que leerá el fichero

		String linea;

		fichero = new File("c:\\enteros.txt");

		scFichero = new Scanner(fichero);

		while (scFichero.hasNext()) { // Mientras haya más contenido

			linea = scFichero.nextLine(); // Lemmos la siguiente línea

			contarNumeros(linea);

		}
		scFichero.close();

	} // FIN leerFichero();

	private static void contarNumeros(String linea) {

		int num; // En esta variable iremos leyendo cada número de la línea

		tokens = new StringTokenizer(linea, DELIM);

		while (tokens.hasMoreTokens()) {

			num = Integer.parseInt(tokens.nextToken()); // Parseamos el String a Integer

			System.out.println(num); // Lo mostramos por consola

			suma += num; // Lo sumamos a suma

			cont++; // Lo sumamos al contador de número
		}

	} // FIN contarNumeros();

} // FIN Ejercicio6
