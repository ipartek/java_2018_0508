package com.ipartek.formacion.ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Fichero {

	public static void main(String[] args) {
		String path = "\\\\192.168.1.201\\java\\0508\\ficheros";

		// crearFichero();

		// leerFichero();

		// escribirFichero();

		 buscarMiTesoro(path);

		// listarUnidadesPc();
	}

	private static void listarUnidadesPc() {

		File[] unidades = File.listRoots();

		for (int i = 0; i < unidades.length; i++) {
			System.out.println(unidades[i].getAbsolutePath());
		}

	}

	private static void buscarMiTesoro(String path) {
		// Aquí la carpeta donde queremos buscar

		File file;
		String palabra = "tesoro";
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {

			if (listOfFiles[i].isFile()) {
				file = new File(listOfFiles[i].getAbsolutePath());
				FileReader fr = null;
				try {
					fr = new FileReader(file);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				BufferedReader br = new BufferedReader(fr);// buffer que lee caracter a caracter.

				String linea = null;
				try {
					while ((linea = br.readLine()) != null) {
						if (linea.contains(palabra)) {
							System.out.println("Se ha encontrado la palabra en el archivo " + file.getAbsolutePath());
							break;
						}
					}
					br.close();
					fr.close();
				} catch (IOException e) {

				}
			} else if (listOfFiles[i].isDirectory()) {
				buscarMiTesoro(listOfFiles[i].getAbsolutePath());
			}

		}

	}

	private static void escribirFichero() {
		File f = new File("C:\\Desarrollo\\eclipseWorkspace\\java_2018_0508\\ficheros\\lorem.txt");
		FileWriter fw = null;
		String lorem = "Lorem ipsum dolor sit amet consectetur adipiscing elit praesent, arcu pretium malesuada condimentum vestibulum ultrices aenean in phasellus, cubilia fusce ridiculus aptent proin vivamus vulputate. Volutpat parturient morbi suscipit quis ullamcorper nec lacus, erat etiam rhoncus cum dictumst cursus sollicitudin, posuere vel quam ligula laoreet natoque. Lobortis nisi curabitur faucibus egestas platea ad venenatis lacinia netus tempus, ut praesent euismod mattis vulputate orci diam mus. A dictum condimentum diam sociis tortor nec pretium, taciti cursus nisi mauris luctus dui ullamcorper, vitae nam cum egestas proin faucibus.";

		try {
			fw = new FileWriter(f);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		BufferedWriter bw = new BufferedWriter(fw);// buffer escribe.

		if (f.exists()) {
			System.out.println("Existe el fichero");

			try {
				System.out.println("Escribimos en el fichero");
				bw.write(lorem);
				bw.close();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {
			System.out.println("El fichero no existe vamos a crearlo y escribiremos en él.");
			crearFichero();
			escribirFichero();

		}
	}

	// Metodos

	private static void crearFichero() {
		File f = new File("C:\\Desarrollo\\eclipseWorkspace\\java_2018_0508\\ficheros\\lorem.txt");
		System.out.println(f.getAbsolutePath());
		if (f.exists()) {
			System.out.println("Existe el fichero");

		} else {

			try {
				System.out.println("Creamos fichero");
				f.createNewFile();
			} catch (IOException e) {
				System.out.println("Ha ocurrido un error y no se ha creado el fichero.");
			}
		}
	}

	private static void leerFichero() {
		File f = new File("C:\\Desarrollo\\eclipseWorkspace\\java_2018_0508\\ficheros\\hola.txt");
		System.out.println("Vamos a comenzar a leer fichero" + f.getAbsolutePath());
		try {

			// usamos los Stream para mejorar la lectura o escritura.
			FileReader fr = new FileReader(f);
			BufferedReader bf = new BufferedReader(fr);// buffer que lee caracter a caracter.

			try {
				String linea = null;
				while ((linea = bf.readLine()) != null) {

					System.out.println(linea);
				}
			} finally {
				bf.close();
				fr.close();
			}
		} catch (IOException e) {
			System.out.println();
		}

		System.out.println("Terminada la lectura del fichero");
	}

}
