package com.ipartek.formacion.ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Fichero {

	public static void main(String[] args) {

		crearFichero();
		System.out.println("------------------------------------------------------");
		leerFichero();
		System.out.println("------------------------------------------------------");
		escribirEnFichero();
		System.out.println("------------------------------------------------------");
		buscarMiTesoro();
		System.out.println("------------------------------------------------------");
		listarUnidadesPc();
	}

	private static void crearFichero() {
		File f = new File("ficheros/temp.txt");
		if (f.exists()) {
			System.out.println("El fichero existe.");
		} else {
			try {
				f.createNewFile();
				System.out.println("Fichero creado.");
			} catch (IOException e) {
				System.out.println("Error al crear el fichero.");
				e.printStackTrace();
			}
		}
	}

	private static void leerFichero() {

		File f = new File("ficheros/hola.txt");

		System.out.println("Comenzamos la lectura del fichero: " + f.getAbsolutePath());
		System.out.println();
		try {
			FileReader fr = new FileReader("ficheros/hola.txt");
			BufferedReader br = new BufferedReader(fr);
			try {
				String linea;
				while ((linea = br.readLine()) != null) {
					System.out.println(linea);
				}
			} finally {
				br.close();
				fr.close();
			}
		} catch (IOException e) {
			System.out.println("Caught exception while processing file: " + e.getMessage());
		}
		System.out.println();
		System.out.println("Terminada lectura del fichero.");
	}

	private static void escribirEnFichero() {
		FileWriter fichero = null;
		PrintWriter pw = null;
		String lorem = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi molestie fringilla urna, et blandit magna auctor eget. Pellentesque volutpat, urna eget dapibus ullamcorper, nulla libero faucibus sapien, at hendrerit elit turpis et libero. Aliquam tristique, lacus eget aliquam aliquam, augue eros sollicitudin dolor, ut dictum quam ex sit amet leo. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam laoreet rutrum sem, eget rutrum augue lacinia porttitor. Sed sagittis dapibus augue sed faucibus. Suspendisse laoreet velit vel fermentum porttitor. Maecenas imperdiet eleifend imperdiet. Fusce aliquet, leo nec scelerisque venenatis, nisi massa molestie sapien, at consectetur erat est eget leo. Phasellus sagittis nibh a massa faucibus aliquet.";
		try {
			fichero = new FileWriter("ficheros/hola.txt");
			pw = new PrintWriter(fichero);
			pw.println(lorem);
			System.out.println("Se escribio en el fichero correctamente.");

		} catch (Exception e) {
			System.out.println("Error al escribir en el fichero.");
			e.printStackTrace();
		} finally {
			try {
				if (null != fichero)
					fichero.close();
			} catch (Exception e2) {
				System.out.println("Error al intentar cerrar el fichero.");
				e2.printStackTrace();
			}
		}
	}

	private static void buscarMiTesoro() {
		// TODO Buscar mi tesoro
		String palabraBuscar = "tesoro";
		searchFile(new File("ficheros"), palabraBuscar);
	}

	/**
	 * Buscar de forma recursive dentro de un sistema de ficheros una "palabra"
	 * @param file fichero a leer
	 * @param palabraBuscar String a buscar dentro del fichero
	 */
	private static void searchFile(File file, String palabraBuscar) {
		//boolean resul = false;
		if(file.isDirectory()) {
			for (File fichero : file.listFiles()) {
				searchFile(fichero, palabraBuscar);
			}
		}else {
			
		}
		
	}

	private static void listarUnidadesPc() {
		File[] roots = File.listRoots();

		System.out.println("Estas son las unidades del PC:");
		for (int i = 0; i < roots.length; i++) {
			System.out.println(roots[i]);
		}

	}
}
