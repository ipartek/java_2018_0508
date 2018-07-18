package com.ipartek.formacion.ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Fichero {

	public static void main(String[] args) {

		// crearFichero();

		// leerFichero();

		buscarMiTesoro();

		// listarUnidades();

	}

	private static void crearFichero() {

		File f = new File("ficheros\\temp.txt");

		System.out.println("Path: " + f.getAbsolutePath());

		if (f.exists()) {

			System.out.println("Ya existe el fichero.");

			String lorem = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce id euismod nisl. Mauris lorem mi, malesuada non libero a, hendrerit lacinia turpis. Morbi sit amet augue eu tortor vehicula molestie eget non elit. Nulla tincidunt commodo orci, non sagittis justo mollis id. Integer sodales risus a augue semper malesuada. Sed vehicula finibus massa sit amet interdum. Aenean sollicitudin ipsum id tempor bibendum. Proin blandit purus finibus sapien rutrum dictum. Pellentesque facilisis commodo nunc, sed ullamcorper ante fringilla non. Quisque interdum pellentesque tempus. ";

			FileWriter fichero;
			try {

				fichero = new FileWriter(f);
				try {
					fichero.write(lorem);
				} catch (IOException e) {
					System.out.println("No se ha podido escribir.");
					e.printStackTrace();
				}

				fichero.close();

			} catch (IOException e1) {
				System.out.println("No se ha podido crear el fichero escritura");
				e1.printStackTrace();
			}

		} else {
			try {
				f.createNewFile();
				System.out.println("Se ha creado el fichero.");
			} catch (IOException e) {
				System.out.println("Error al crear el fichero.");
				e.printStackTrace();
			}
		}

	}

	private static void leerFichero() {

		File f = new File("ficheros\\hola.txt");
		System.out.println("Vamos a leer el fichero " + f.getAbsolutePath());

		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			try {
				String linea = null;
				while ((linea = br.readLine()) != null) {
					System.out.println(linea);
				}
			} finally {
				fr.close();
				br.close();
			}
		} catch (IOException e) {
			System.out.println("Caught exception while processing file: " + e.getMessage());
		}

		System.out.println("Terminada la lectura del fichero.");

	}

	/**
	 * Va recorrer recursivamente la estructura de ficheros y buscando la palabra
	 * tesoro.
	 */
	private static void buscarMiTesoro() {

		String directorioPrincipal = "ficheros";

		File f = new File(directorioPrincipal);

		recursividad(f);

	}

	private static void recursividad(File f) {

		File[] roots = f.listFiles();
		for (int i = 0; i < roots.length; i++) {
			if (roots[i].isDirectory()) {

				f = new File(roots[i].getPath());

				recursividad(f);

			} else {

				leerFichero(roots[i]);

			}
		}
	}

	private static void leerFichero(File f) {

		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			try {
				String linea = null;
				while ((linea = br.readLine()) != null) {
					if (linea.contains("tesoro")) {
						System.out.println("Encontrado en " + f.getPath());
					}
				}
			} finally {
				fr.close();
				br.close();
			}
		} catch (IOException e) {
			System.out.println("Caught exception while processing file: " + e.getMessage());
		}

	}

	private static void listarUnidades() {

		File[] roots = File.listRoots();

		System.out.println("Unidades de disco:");

		for (int i = 0; i < roots.length; i++) {
			System.out.println(roots[i]);
		}

	}

}
