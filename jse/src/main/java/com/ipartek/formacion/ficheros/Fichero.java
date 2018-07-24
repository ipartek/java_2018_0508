package com.ipartek.formacion.ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Fichero {

	static final String LOREM = "Lorem ipsum dolor sit amet, consectetur adipiscing "
			+ "elit, sed eiusmod tempor incidunt ut labore et dolore " + "magna aliqua. Ut enim ad minim veniam, "
			+ "quis nostrud exercitation ullamco laboris nisi ut aliquid "
			+ "ex ea commodi consequat. Quis aute iure reprehenderit in voluptate "
			+ "velit esse cillum dolore eu fugiat nulla pariatur. " + "Excepteur sint obcaecat cupiditat non proident, "
			+ "sunt in culpa qui officia deserunt mollit anim id est laborum.";

	public static void main(String[] args) {

		File f = new File("hola.txt");

		System.out.println(f.getAbsolutePath());

		crearFichero(f);

		escribeLineasFichero(f, LOREM);

		leerLineasFichero(f);

	}

	private static void crearFichero(File f) {

		if (f.exists()) {
			System.out.println("El fichero ya existe.");

		} else {
			System.out.println("Creando el fichero...");

			try {

				f.createNewFile();
				System.out.println("Fichero creado con éxito.");
			} catch (IOException e) {

				System.out.println("Error al crear el archivo.");
				e.printStackTrace();
			}
		}
	}

	/**
	 * Método que escribe un fichero línea a línea.
	 * 
	 * @see PrintWriter, FileWriter
	 */
	private static void escribeLineasFichero(File f, String texto) {
		FileWriter fr = null;
		PrintWriter pw = null;

		try {

			fr = new FileWriter(new File("hola.txt"));
			pw = new PrintWriter(fr);
			pw.print(texto);

		} catch (IOException e) {
			System.out.println("LO SENTIMOS. Ha ocurrido un error inesperado.");
			e.printStackTrace();
		} finally {
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					System.out.println("LO SENTIMOS. Ha ocurrido un error inesperado.");
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Método que lee un fichero línea a línea.
	 * 
	 * @see BufferedReader, FileReader
	 */
	private static void leerLineasFichero(File f) {

		StringBuilder sb = new StringBuilder();

		try {

			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);

			String linea = null;

			try {

				while ((linea = br.readLine()) != null) {
					sb.append(linea);
				}
			} finally {
				if (fr != null) {
					fr.close();
				}
			}
		} catch (IOException e) {
			System.out.println("Caught exception while processing file: " + e.getMessage());
		}

		System.out.println(sb.toString());

	}

}
