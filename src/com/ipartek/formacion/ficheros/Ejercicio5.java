package com.ipartek.formacion.ficheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Disponemos de un fichero de texto llamado enteros.txt que contiene números
 * enteros. El siguiente programa lee los números usando la clase Scanner y los
 * muestra. Muestra también la cantidad de números leídos y su suma.
 * 
 * @see Scanner
 * @author Luis
 *
 */
public class Ejercicio5 {

	static Scanner scConsola = new Scanner(System.in); // Scanner que leerá la consola

	static File fichero;

	static int suma;
	static int cont;

	public static void main(String[] args) {

		String ruta = "c:\\enteros.txt";

		System.out.println("Abriendo fichero con la clase Scanner...");

		try {

			leerFichero(ruta);
			System.out.println("Fichero leído con éxito.");

		} catch (FileNotFoundException e) { // No existe el fichero

			System.out.println(e.getMessage());
		}

		scConsola.close();
		mostrarResultados();

	}

	private static void mostrarResultados() {

		System.out.println("La suma de los números es:" + suma);

		System.out.println("Leidos " + cont + " números del fichero.");

	}

	/**
	 * La lectura acaba cuando no quedan más enteros (se ha llegado al final del
	 * fichero) o cuando encuentra un carácter no válido como entero.
	 * 
	 * @param ruta, String con la ruta del fichero
	 * @throws FileNotFoundException
	 */
	private static void leerFichero(String ruta) throws FileNotFoundException {

		Scanner scFichero = null; // Scanner que leerá el fichero

		int num; // En esta variable iremos leyendo cada número del fichero

		fichero = new File("c:\\enteros.txt");

		scFichero = new Scanner(fichero);

		while (scFichero.hasNextInt()) { // Mientras haya más números seguidos

			num = scFichero.nextInt(); // Lemmos el siguiente número

			System.out.println(num); // Lo mostramos por consola

			suma += num; // Lo sumamos a suma

			cont++; // Lo sumamos al contador de número

		}
		scFichero.close();

	} // FIN leerFichero();

} // FIN Ejercicio5
