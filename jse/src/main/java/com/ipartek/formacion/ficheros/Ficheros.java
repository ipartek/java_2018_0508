package com.ipartek.formacion.ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ficheros {

	public static void main(String[] args) {

		// crearfichero();

		// leerFichero();
		
		// buscarMiTesoro();
		
		listarUnidadesPC();		
		
		//listarDirectorio("C:\\Desarrollo\\eclipse-workspace\\java_2018_0508\\ficheros", "");
	}

	private static void listarUnidadesPC() {
		File[] roots = File.listRoots();
		for (int i=0; i<roots.length; i++) {			    
		  System.out.println("--- El Pc tiene una unidad " + roots[i] + " ---");
		}		
	}

	public static void listarDirectorio(File f, String separador){
		  File[] ficheros = f.listFiles();		
		  if (ficheros!=null){
		    for (int x=0;x<ficheros.length;x++){			
		      System.out.println(separador + ficheros[x].getName());
		 
		      if (ficheros[x].isDirectory()){
		        String nuevo_separador;
		        nuevo_separador = separador + " ";
		        listarDirectorio(ficheros[x],nuevo_separador);
		      }
		    }
		  }
	}
	
	private static void buscarTesoro() {
		// TODO Auto-generated method stub
		
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

	private static void crearfichero() {

		File f = new File("temp.txt");
		System.out.println("path: " + f.getAbsolutePath());

		if (f.exists()) {
			System.out.println("Existe el fichero");			
		} else {
			System.out.println("Creamos el fichero");
			try {
				f.createNewFile();
			} catch (IOException e) {
				System.out.println("Error al crear el fichero");
				e.printStackTrace();
			}
		}

	}

}
