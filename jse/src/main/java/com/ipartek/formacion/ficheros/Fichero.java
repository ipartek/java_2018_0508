package com.ipartek.formacion.ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Fichero {

	public static void main(String[] args) {

		//crearFichero();
		//leerFichero();
		//buscarMiTesoro();
		listarUnidadesPC();

	}

	private static void listarUnidadesPC() {
	

	}
	// TODO Auto-generated method stub

	private static void buscarMiTesoro() {
		String path = "C://Users/curso/eclipse-workspace/java_2018_0508/ficheros";
		String files;
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();
		
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				files = listOfFiles[i].getName();
				if (files.endsWith(".txt") || files.endsWith(".TXT")) {
					System.out.println(files);
				}
			}

		}
	}
	// TODO Auto-generated method stub

	private static void crearFichero() {
		File f = new File("temp.txt");
		System.out.println("path: " + f.getAbsolutePath());

		if (f.exists()) {
			System.out.println("Existe el fichero");
			// String lorem = Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec
			// tincidunt, sapien eget bibendum pellentesque, leo sem viverra purus, ac
			// euismod dolor ipsum nec dui. Nunc ornare venenatis ligula sagittis sagittis.;
		} else {
			System.out.println("No existe el fichero");
			try {
				f.createNewFile();
				System.out.println("Creamos el fichero");
			} catch (IOException e) {
				System.out.println("Erros al crear ficheros");
				e.printStackTrace();
			}
		}

	}

	private static void leerFichero() {
		StringBuilder sb = new StringBuilder(); // buffer asociado
		try {
			// Usamos los stream para mejorar la lectura o la escritura

			FileReader fr = new FileReader(new File("hola.txt"));
			BufferedReader bf = new BufferedReader(fr);

			try {
				String linea;

				while ((linea = bf.readLine()) != null) {
					System.out.println(linea);
				}
			} finally {
				fr.close();
				bf.close();
			}
		} catch (IOException e) {
			System.out.println("Caught exception while processing file: " + e.getMessage());
		}
		System.out.println("Terminada la lectura del fichero");
	}

}
