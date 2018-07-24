package com.ipartek.formacion.ficheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;

/**
 * Programa que obtiene la l�nea de mayor tama�o y la de menor tama�o dentro de
 * un fichero de texto. Para resolver este ejercicio se utiliza la clase Scanner
 * para leer el fichero. La lectura se realiza l�nea a l�nea hasta que se
 * alcance el final del fichero. Para determinar cu�l es la de mayor longitud y
 * cu�l es la menor, se lee la primera l�nea del fichero y se toma como la l�nea
 * mayor y la menor. A continuaci�n se leen el resto de l�neas y para cada una
 * se compara su tama�o con la mayor y menor actuales. El nombre del fichero se
 * selecciona de forma gr�fica utilizando la clase JFileChooser.
 * 
 * @see Scanner, JFileChooser
 * @author Luis
 *
 */
public class Ejercicio7 {

	static File fichero;

	static JFileChooser jfc;

	static String ruta;

	static String mayor = "";
	static String menor = "";

	static Scanner scFichero; // Scanner que leerá el fichero;
	static Scanner scConsola; // Scanner que mostrará por consola

	public static void main(String[] args) {

		mostrarVentanaFicheros();

		System.out.println("Leyendo archivo " + ruta);
		
		try {

			abrirFichero();

			leerFichero(ruta);

			System.out.println("Fichero le�do con �xito.");

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}

		mostrarResultados();

	}

	private static void mostrarResultados() {

		System.out.println("La línea más larga es: " + mayor);

		System.out.println("La línea más corta es: " + menor);

	}

	private static void mostrarVentanaFicheros() {

		jfc = new JFileChooser(); // Creamos el objeto JFileChooser

		jfc.showOpenDialog(jfc); // Abrimos el jfc en modo "Open"

		ruta = jfc.getSelectedFile().getAbsolutePath(); // Guardamos en ruta la ruta absoluta

	} // FIN mostrarVentanaFicheros();

	private static void abrirFichero() throws FileNotFoundException {

		fichero = new File(ruta);
		scFichero = new Scanner(fichero);

	} // FIN abrirFichero():

	private static void leerFichero(String ruta) throws FileNotFoundException {

		String linea = "";

		if (scFichero.hasNext()) {// Fichero abierto y con contenido

			mayor = menor = scFichero.nextLine(); // Leemos la primera l�nea
		}

		while (scFichero.hasNext()) { // Mientras haya  l�neas

			linea = scFichero.nextLine(); // Leemos

			if (mayor.length() < linea.length()) { // Línea más larga que mayor

				mayor = linea;

			} else if (menor.length() > linea.length()) { // Línea más corta que menor

				menor = linea;
			}

		}
		scFichero.close();

	} // FIN leerFichero();

} // FIN Ejercicio7
