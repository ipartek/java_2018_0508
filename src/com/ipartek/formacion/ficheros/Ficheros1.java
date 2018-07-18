package com.ipartek.formacion.ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Ficheros1 {
	public static void main(String[] args) {
		/*
		 * crearFichero(); escribirFichero(); leerFichero();
		 */
		File miDir = new File("C:\\desarrollo\\java_2018_0508\\ficheros"); // directorio actual, cambiarlo si se quiere
		leerCarpetas(miDir);
	}

	private static void leerCarpetas(File dir) {

		try {
			File[] files = dir.listFiles();
			for (File file : files) {
				if (file.isDirectory()) {
					System.out.println("directorio:" + file.getCanonicalPath());
					leerCarpetas(file);
				} else {
					System.out.println("     archivo:" + file.getCanonicalPath());
					buscarTesoro(file);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void buscarTesoro(File file) {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura comoda (disponer del metodo readLine()).
			archivo = file;
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			// Lectura del fichero
			String linea;
			String comodin;
			while ((linea = br.readLine()) != null){
				System.out.println(linea);
				comodin = linea;
				
				if (comodin.contains("tesoro")) {
					System.out.println("Encontrado");
					System.out.println("En la ruta "+ file.getAbsolutePath());
			}

		}} catch (Exception e) {
			
		} finally {
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}

/*
 * private static void crearFichero() {
 * 
 * File f = new File("temp.tx"); System.out.println(f.getAbsolutePath()); if
 * (f.exists()) { System.out.println("Existe el fichero"); } else {
 * System.out.println("Creamos fichero"); } try { f.createNewFile();
 * System.out.println("Creamos el fichero"); } catch (Exception e) {
 * System.out.println("Error al crear el fichero"); e.printStackTrace(); }
 * 
 * }
 */

/*
 * private static void escribirFichero() { FileWriter fichero = null;
 * PrintWriter pw = null; try { fichero = new FileWriter("c:/prueba.txt"); pw =
 * new PrintWriter(fichero);
 * 
 * for (int i = 0; i < 10; i++) pw.println("Linea " + i);
 * 
 * } catch (Exception e) { e.printStackTrace(); } finally { try { // Nuevamente
 * aprovechamos el finally para // asegurarnos que se cierra el fichero. if
 * (null != fichero) fichero.close(); } catch (Exception e2) {
 * e2.printStackTrace(); } } }
 */

/*
 * private static void leerFichero() { // leerCarpetas(); File f = new
 * File("hola.txr"); String dir = "C:\\desarrollo\\java_2018_0508\\ficheros";
 * System.out.println("Vamos a comenzar a leeer el fichero " + dir);
 * StringBuilder sb = new StringBuilder();
 * 
 * try { // Usamos los strings para mejorar la lectura o escritura FileReader fr
 * = new FileReader(new File("hola.txt")); BufferedReader br = new
 * BufferedReader(fr); try {
 * 
 * int c = reader.read(); while (c != -1) { sb.append(c);
 * 
 * String linea = null; while (linea != br.readLine()) {
 * System.out.println(linea); } } finally { br.close(); fr.close();
 * 
 * } } catch (IOException e) {
 * System.out.println("Caught exception while processing file: " +
 * e.getMessage()); }
 * 
 * }
 */
