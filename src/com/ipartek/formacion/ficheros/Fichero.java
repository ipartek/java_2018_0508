package com.ipartek.formacion.ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Fichero {

	public static void main(String[] args) {
		
		File f = new File("hola.txt");
		System.out.println("Ruta: "+f.getAbsolutePath());
		
		if(f.exists()) {
			System.out.println("Existe el fichero");
		
		}
		else {
			System.out.println("Creamos fichero");
			try {
				f.createNewFile();
			} catch (IOException e) {
				System.out.println("Error al crear fichero");
				e.printStackTrace();
			}
		}
		
		crearFichero();
		
		leerFichero();
		
		buscarMiTesoro();
		
	    listarUnidadesPc();

	}

	private static void listarUnidadesPc() {
		
		File[] unidades= File.listRoots();
		for (int i = 0; i < unidades.length; i++) {
			System.out.println("Unidad del PC: ");
			System.out.println(unidades[i].getAbsolutePath());
		}
		
	}

	private static void buscarMiTesoro() {
		
		System.out.println("Buscar tesoro: ");
		
		searchFile(new File("ficheros"), "tesoro");
		
	}
	
private static void searchFile(File file, String string) {
	
	boolean resul= false;
	
	//si es un directorio seguimos buscando
	//if(isDirectory()) {
		
		//for (file fichero : f.listFiles()) {
			//searchFile(fichero, palabra);
			
		//}
	//}
	//else {
		//try {
			//FileReader fr= 
		//}
	//}
	
		
	
		
	}

private static void leerFichero() {
		
		File f= new File("hola.txt");
		System.out.println("Vamos a comenzar a leer el fichero "+f.getAbsolutePath());
		
		try {
			 FileReader fr = new FileReader(f);
			 BufferedReader bf = new BufferedReader(fr); 
			 try {
			 String linea= null;
			 while ((linea= bf.readLine())!=null) {
				 System.out.println(linea); 
			 }
			 } finally {
			 bf.close();
			 fr.close();
			 }
			} catch (IOException e) {
			 System.out.println("Caught exception while processing file: " + e.getMessage());
			}
		
		    System.out.println("Terminada lectura del ficero");
		
	}

	

	private static void crearFichero() {
		
		File f= new File("temp.txt");
		System.out.println("Vamos a comenzar a escribir el fichero "+f.getAbsolutePath());
		
		if(!f.exists()) {
			System.out.println("No existe el fichero");
			
		}
		
		else {
			try {
				 FileWriter fr = new FileWriter(f);
				 BufferedWriter bf = new BufferedWriter(fr);
				 PrintWriter wr= new PrintWriter(bf);
				 
				 wr.write("Lorem ipsum dolor sit amet, consectetur adipiscing elit...");
				 wr.append("\nEsta es una segunda linea del texto");
				 wr.close();
				 bf.close();
			} catch (IOException e) {
				System.out.println("Caught exception while processing file: " + e.getMessage());
				
				e.printStackTrace();
			}
			
			System.out.println("Hemos escrito en el fichero existente");
		}
		
		
		
	}

}
