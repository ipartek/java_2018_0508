package com.ipartek.formacion.ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Fichero {

	public static void main(String[] args) {

		 crearFichero();

		leerFichero("Ficheros/hola.txt");
	
		buscarTesoro("Ficheros","tesoro");
		listarUnidadesPC();
		
		//File f = new File("Ficheros");
		//System.out.println(f.getAbsolutePath());
	}

	private static void listarUnidadesPC() {
		File[] roots = File.listRoots();

		for (int i = 0; i < roots.length; i++) {
			System.out.println(roots[i].getAbsolutePath());
		}

	}

	private static void buscarTesoro(String pathname, String key) {

		File folder = new File(pathname);
		File[] listOfFiles = folder.listFiles();
		String txt = "";

		for (int i = 0; i < listOfFiles.length; i++) {

			if (listOfFiles[i].isDirectory()) {
				buscarTesoro(pathname+"/"+listOfFiles[i].getName(),key);
			}

			if (listOfFiles[i].isFile()) {
				txt = leerFichero(pathname+"/"+listOfFiles[i].getName());
				if (txt.contains(key)) {
					System.out.println("Encontrado!");
					System.out.println("Esta en el archivo: " + folder.getAbsolutePath() + "/" + listOfFiles[i].getName());
					break;
				}

			}

		}

	}

	private static void crearFichero() {

		File f = new File("Ficheros/temp.txt");
		System.out.println("Path" + f.getAbsolutePath());

		if (f.exists()) {
			System.out.println("Existe el fichero");
			String lorem = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed vehicula malesuada aliquam. Nullam lacus sem, bibendum et condimentum ac, maximus eget sem. Fusce dictum lectus sit amet ligula ullamcorper, sit amet pellentesque lorem molestie. Donec magna diam, sodales nec dictum at, rutrum at est. Ut rhoncus in lacus sed lacinia. Nullam nibh lorem, molestie nec aliquet et, vestibulum id mauris. Mauris augue est, varius at vestibulum non, rhoncus sed leo. Ut consectetur dictum libero, et laoreet quam tincidunt ac. Fusce congue pellentesque dictum. Praesent aliquet turpis sit amet lorem pellentesque gravida. Nam feugiat commodo ultrices. Mauris dignissim viverra metus vitae imperdiet. Duis feugiat volutpat quam, ut ullamcorper augue tristique id. Maecenas lorem lorem, fermentum vel nibh a, blandit placerat neque. Sed sed facilisis enim. Nulla scelerisque purus vitae nibh venenatis, a accumsan magna dictum.";
			
			BufferedWriter bw = null;
			
			try {
				bw = new BufferedWriter(new FileWriter(f));
				bw.write(lorem);
				bw.close();

			} catch (Exception e) {
				e.printStackTrace();

			} finally {

				

			}

		} else {
			try {
				f.createNewFile();

			} catch (Exception e) {

				e.printStackTrace();
			}
		}

		

	}

	private static String leerFichero(String fileName) {

		File f = new File(fileName);
		String txt = "";
		// System.out.println("Vamos a comenzar a leer fichero...");
		try {
			// usamos los stream para mejorar la lectura o la escritura
			FileReader fr = new FileReader(f);
			BufferedReader bf = new BufferedReader(fr); // buffer
			try {

				String linea;
				while ((linea = bf.readLine()) != null) {
					// System.out.println(linea);
					txt += linea + "\n";
				}

			} finally {
				bf.close();
				fr.close();

			}
		} catch (IOException e) {
			System.out.println("Caught exception while processing file: " + e.getMessage());
		}
		// System.out.println("Terminada lectura del fichero");

		return txt;

	}

}
