package com.ipartek.formacion.ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FicheroPruebas {

	public static void main(String[] args) {
		
		String pathFicheros = "C:\\Desarrollo\\eclipse-workspace\\java_2018_0508\\ficheros\\";
		
		File fichero = new File(pathFicheros + "temp.txt");
		
		FileReader fr = new FileReader(fichero);
		
		
	}

	private static void leerFichero() {
		
		try {
			//
			FileReader fr = new FileReader(new File("C:\\Desarrollo\\eclipse-workspace\\java_2018_0508\\ficheros\\Hola.txt"));
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
		System.out.println("Terminada la lectura del fichero");
	}
	
}
