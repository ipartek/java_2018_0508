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

		leerFichero();

		buscarMiTesoro();

		listarUnidadesPc();

	}

	private static void listarUnidadesPc() {

		System.out.println("-----------------------------------------");
		System.out.println("Listar Unidades Disco Duro:   ");
		System.out.println("-----------------------------------------");

		File[] unidades = File.listRoots();
		for (int i = 0; i < unidades.length; i++) {
			System.out.println(unidades[i].getAbsolutePath());
		}

	}

	/**
	 * Recorrer de forma recursiva en el directorio "ficheros", todos los ficheros
	 * "lorem.txt" y buscar dentro de ellos la palabra "tesoro"
	 * 
	 */
	private static void buscarMiTesoro() {
		System.out.println("-----------------------------------------");
		System.out.println("Buscar Tesoro");
		System.out.println("-----------------------------------------");

		searchFile(new File("ficheros"), "tesoro");

	}

	/**
	 * Busca de forma recursiva dentro de un sistema de ficheros una "palabra"
	 * 
	 * @param f       File fichero a leer
	 * @param palabra String a buscar dentro del fichero
	 * @return
	 */
	private static boolean searchFile(File f, String palabra) {
		boolean resul = false;
		// Si es un directorio seguir buscando
		if (f.isDirectory()) {

			for (File fichero : f.listFiles()) {
				searchFile(fichero, palabra);
			}

		} else {

			try {
				FileReader fr = new FileReader(f);
				BufferedReader bf = new BufferedReader(fr);
				String linea;
				while ((linea = bf.readLine()) != null) {

					if (linea.contains(palabra)) { // encontrado
						System.out.println("Encontrada palabra en " + f.getAbsolutePath());
						resul = true;
						break;
					}

				}

				bf.close();
				fr.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return resul;
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

	private static void leerFichero() {

		System.out.println("-----------------------------------------");
		System.out.println("Leer Fichero");
		System.out.println("-----------------------------------------");

		File f = new File("ficheros/hola.txt");
		System.out.println("vamos a comenzar a leer fichero " + f.getAbsolutePath());
		try {

			FileReader fr = new FileReader(f);
			BufferedReader bf = new BufferedReader(fr);
			try {
				String linea;
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

		System.out.println("Terminada lectura fichero");

	}

}