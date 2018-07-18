package com.ipartek.formacion.ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Fichero {

	public static void main(String[] args) {

		crearFichero();

		leerFichero();
		
		buscarMiTesoro();
		
		listarUnidadesPc();

	}

	private static void listarUnidadesPc() {
		// TODO Auto-generated method stub
		
	}

	private static void buscarMiTesoro() {
		// TODO Auto-generated method stub
		
	}

	private static void crearFichero() {

		File f = new File("ficheros/temp.txt");
		System.out.println("path: " + f.getAbsolutePath());

		if (f.exists()) {
			System.out.println("Existe el fichero");
			
			String lorem = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam eget massa sed ligula elementum egestas. Praesent nec ex diam. Integer elementum, dolor non imperdiet finibus, massa eros viverra odio, a tincidunt sem nisi ac urna. Praesent a facilisis massa. Aliquam ligula leo, lobortis sed magna non, fringilla malesuada ex. Sed sit amet nisi sed dolor bibendum sodales. Sed in velit molestie, consectetur nunc vel, efficitur nisl. Aliquam nec nisi sit amet diam vulputate bibendum in id arcu. Vivamus at dignissim lorem. Pellentesque et magna nisl. Aliquam metus justo, dapibus dictum elit eget, pretium placerat sapien.";
			
			
			
		} else {

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

		File f = new File("ficheros/hola.txt");
		System.out.println("vamos a comenzar a leer fichero " + f.getAbsolutePath() );
		try {
			
			FileReader fr = new FileReader(f);
			BufferedReader bf = new BufferedReader (fr); 
			try {
				String linea;
			    while((linea = bf.readLine()) != null) {
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
