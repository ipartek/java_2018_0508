package com.ipartek.formacion.ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.sun.jndi.toolkit.dir.SearchFilter;

public class Fichero {

	public static void main(String[] args) {

		crearFichero();

		leerFichero();

		buscarTesoro();

		listarUnidadesPc();

	}

	private static void listarUnidadesPc() {
		
		File[] unidades = File.listRoots();
		for (int i = 0; i < unidades.length; i++) {
			System.out.println(unidades[i].getAbsolutePath());
		}

	}

	private static void buscarTesoro() {
		
		searchFile(new File("ficheros"), "tesoro");

	}

	private static boolean searchFile(File f, String palabra) {

		boolean resul = false;
		
		if (f.isDirectory()) {
			for (File fichero : f.listFiles()) {
				searchFile(fichero, palabra);
			}
		}else {
			try {
				FileReader fr = new FileReader(f);
				BufferedReader bf = new BufferedReader(fr);
				String linea;
				while ((linea = bf.readLine()) != null) {
					System.out.println(linea);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return resul;
		
	}

	private static void leerFichero() {

		File f = new File("Ficheros\\hola.txt");
		System.out.println("Vamos a comenzar a leer fichero " + f.getAbsolutePath());

		try {
			// usamos los Stream para mejorar la lectura o escritura
			FileReader fr = new FileReader(f);
			BufferedReader bf = new BufferedReader(fr);
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
			System.out.println("Caught exception while processing file: " + e.getMessage());
		}
		System.out.println("Terminada lectura del fichero");
	}

	private static void crearFichero() {
		File f = new File("Ficheros\\hola.txt");
		System.out.println("path:" + f.getAbsolutePath());

		if (f.exists()) {
			System.out.println("Existe el fichero");

			String lorem = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla non viverra ante. Nunc porta suscipit justo. Etiam ornare imperdiet urna in auctor. Sed at vestibulum tortor, luctus pellentesque nunc. In lacus est, pretium a viverra non, blandit ac leo. Aliquam porttitor ac purus at posuere. Donec et sagittis neque. ";

			try {
				FileWriter fw = new FileWriter(f);
				PrintWriter pw = new PrintWriter(fw);

				try {
					pw.println(lorem);

				} finally {
					pw.close();
					fw.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			try {
				f.createNewFile();
				System.out.println("Creamos el fichero");
			} catch (IOException e) {
				System.out.println("Error al crear fichero");
				e.printStackTrace();
			}
		}

	}

}
