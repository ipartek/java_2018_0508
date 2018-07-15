package com.ipartek.formacion.ficheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;

/**
 * Programa Java para buscar una palabra o una cadena en un fichero de texto.
 * 
 * El programa pedirá que se introduzca una palabra o un texto por teclado y
 * realizará su búsqueda por todo el archivo. Se mostrará por pantalla el número
 * de línea y el contenido de la línea del fichero que contiene la cadena
 * buscada. Si la cadena buscada aparece en varias líneas se mostrarán todas
 * ellas. Si el fichero no contiene el texto buscado se mostrará un mensaje
 * indicándolo.
 * 
 * @see Scanner
 * 
 * @author Luis
 *
 */
public class Ejercicio8 {

	static Scanner scConsola = new Scanner(System.in);
	static Scanner scFichero;

	static JFileChooser jfc;

	static String ruta;
	static String busqueda;

	static File fichero;

	static int numLinea = 1;

	static boolean contiene = false;

	public static void main(String[] args) {

		mostrarVentanaFicheros();

		try {

			abrirFichero();
			pedirTextoBusqueda();

			System.out.println("Archivo: " + fichero.getName());
			System.out.println("Texto a buscar: " + busqueda);

			leerFichero();

			if (!contiene) { // si el archivo no contienen el texto se muestra un mensaje indicándolo

				System.out.println(busqueda + " no se ha encontrado en el archivo.");
			}

		} catch (FileNotFoundException e) { // No se ha encontrado el archivo
			System.out.println(e.toString());

		} catch (NullPointerException e) { // No se ha seleccionado ningún archivo
			System.out.println(e.toString() + "No ha seleccionado ningún archivo");

		} catch (Exception e) { // Ha sucedido cualquier otro error
			System.out.println(e.toString());

		} finally {
			if (scFichero != null) { // Si todo ha ido bien y ya hemos leido el fichero
				scFichero.close();
				System.out.println("Fichero cerrado con éxito.");
			}
		}

		scConsola.close();

	} // FIN main();

	private static void abrirFichero() throws FileNotFoundException {

		fichero = new File(ruta);

		System.out.println("Abriendo fichero..." + ruta);

		scFichero = new Scanner(fichero);

		System.out.println("Fichero abierto con éxito.");

	} // FIN abrirFichero():

	private static void pedirTextoBusqueda() {

		System.out.println("Introduce el texto a buscar:");
		busqueda = scConsola.nextLine();

	} // FIN pedirTextoBusqueda();

	private static void mostrarVentanaFicheros() throws NullPointerException {

		jfc = new JFileChooser(); // Creamos el objeto JFileChooser

		jfc.showOpenDialog(jfc); // Abrimos el jfc en modo "Open"

		ruta = jfc.getSelectedFile().getAbsolutePath(); // Guardamos en ruta la ruta absoluta

	} // FIN mostrarVentanaFicheros();

	private static void leerFichero() {

		String linea;

		while (scFichero.hasNext()) { // Por cada línea del fichero

			linea = scFichero.nextLine();
			buscarTexto(linea); // Llamamos a la función buscarTexto
			numLinea++; // Aumentamos en contador de líneas
		}

	} // FIN leerFichero();

	private static void buscarTexto(String linea) {

		if (linea.contains(busqueda)) {

			System.out.println("Linea " + numLinea + ": " + linea);
			contiene = true;

		}
	} // FIN buscarTexto();

} // FIN Ejercicio8
