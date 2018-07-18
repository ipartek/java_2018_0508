package com.ipartek.formacion.ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;

public class Fichero implements Serializable {

	private static final long serialVersionUID = 301109299599011815L;// Quitar warning serializable

	public static void main(String[] args) {

		crearFichero();
		// leerFicheroCaracter(); NO FUNCIONA
		leerFicheroLinea();
		buscarTesoro("ficheros", "TESORO");
		listarUnidadesPc();
	}

	private static void listarUnidadesPc() {

		File[] unidades = File.listRoots();

		System.out.println("Listar Unidades Disco Duro:   ");
		for (int i = 0; i < unidades.length; i++) {
			System.out.println(unidades[i].getAbsolutePath());
		}

	}

	private static boolean buscarTesoro(String ruta, String palabra) {
		boolean resul = false;
		File f = new File(ruta);

		// Si es un directorio seguir buscando
		if (f.isDirectory()) {

			for (File fichero : f.listFiles()) {
				buscarTesoro(ruta, palabra);
			}

		} else {

			try {
				FileReader fr = new FileReader(f);
				BufferedReader br = new BufferedReader(fr);
				String linea;
				while ((linea = br.readLine()) != null) {

					if (linea.contains(palabra)) { // encontrado
						System.out.println("Encontrada palabra en " + f.getAbsolutePath());
						resul = true;
						break;
					}

				}

				br.close();
				fr.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return resul;
	}

	private static void leerFicheroCaracter() {

		StringBuilder sb = new StringBuilder();
		try {
			// usamos los Stream para mejorar la lectura o escritura
			InputStream inputStream = new FileInputStream(new File("Hola.txt"));
			InputStreamReader reader = new InputStreamReader(inputStream);
			try {
				int c = reader.read();
				while (c != -1) {
					sb.append(c);
				}
			} finally {
				reader.close();
			}
		} catch (IOException e) {
			System.out.println("Caught exception while processing file: " + e.getMessage());
		}
	}

	private static void leerFicheroLinea() {
		System.out.println("-----------------------------------------");
		System.out.println("Leer Fichero");
		System.out.println("-----------------------------------------");

		File f = new File("ficheros/Hola.txt");
		System.out.println("vamos a comenzar a leer fichero " + f.getAbsolutePath());
		try {

			FileReader fr = new FileReader(f);
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

		System.out.println("Terminada lectura fichero");

	}

	private static void crearFichero() {

		System.out.println("-----------------------------------------");
		System.out.println("Crear Fichero");
		System.out.println("-----------------------------------------");

		File f = new File("ficheros/temp.txt");
		System.out.println("path: " + f.getAbsolutePath());

		if (f.exists()) { // escribir en fichero
			System.out.println("Existe el fichero");

			String lorem = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam eget massa sed ligula elementum egestas. Praesent nec ex diam. Integer elementum, dolor non imperdiet finibus, massa eros viverra odio, a tincidunt sem nisi ac urna. Praesent a facilisis massa. Aliquam ligula leo, lobortis sed magna non, fringilla malesuada ex. Sed sit amet nisi sed dolor bibendum sodales. Sed in velit molestie, consectetur nunc vel, efficitur nisl. Aliquam nec nisi sit amet diam vulputate bibendum in id arcu. Vivamus at dignissim lorem. Pellentesque et magna nisl. Aliquam metus justo, dapibus dictum elit eget, pretium placerat sapien.";
			BufferedWriter bw = null;
			try {
				bw = new BufferedWriter(new FileWriter(f));
				bw.write(lorem);
				bw.close();
				System.out.println("Terminamos de escribir en el fichero");
			} catch (Exception e) {
				System.out.println("Exception escribiendo fichero: " + e.getMessage());
			}

		} else { // crear fichero

			try {
				f.createNewFile();
				System.out.println("Creamos fichero");

			} catch (IOException e) {

				System.out.println("Error al crear fichero");
				e.printStackTrace();
			}
		}

	}
}
