package com.ipartek.formacion.ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Fichero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		crearFichero();

		leerFichero();

		buscarMiTesoro();

		listarUnidadesPc();
	}

	private static void crearFichero() {
		// TODO Auto-generated method stub
		System.out.println("Crear fichero");
		File f = new File("temp.txt");
		System.out.println(f.getAbsolutePath());

		if (f.exists()) {
			System.out.println("El fichero existe.");

			// Escribir esto en el fichero
			String lorem = "Lorem ipsum dolor sit amet consectetur adipiscing elit magna orci, lacinia hac nulla netus metus mi lectus etiam habitasse, nisi class quam tempor malesuada et massa vivamus.";

			FileWriter fw;
			BufferedWriter bw;
			try {
				fw = new FileWriter(f);
				bw = new BufferedWriter(fw);
				//bw = new BufferedWriter(new FileWriter(f));
				bw.write(lorem);
				bw.close();
				fw.close();
			} catch (IOException e) {
				System.out.println("Error al escribir el fichero.");
			}
			System.out.println("Terminada escritura de fichero.");

		} else {
			try {
				f.createNewFile();
				System.out.println("Creando fichero...");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Error al crear el fichero.");
			}
		}
	}

	private static void leerFichero() {
		// TODO Auto-generated method stub

		// StringBuilder sb = new StringBuilder(); //Para strings largos

		/*
		 * try { //usamos los stream para mejorar la lectura o escritura InputStream
		 * inputStream = new FileInputStream(new File("hola.txt")); //decirle donde esta
		 * el fichero InputStreamReader reader = new InputStreamReader(inputStream);
		 * //Buffer //leer caracter a caracter try { int c = reader.read(); while (c !=
		 * -1) { sb.append(c); } } finally { reader.close(); } } catch (IOException e) {
		 * System.out.println("Error al leer el fichero."); }
		 */

		File f = new File("hola.txt");
		System.out.println("Comenzando a leer el fichero " + f.getAbsolutePath());

		try {
			// usamos los stream para mejorar la lectura o escritura
			FileReader fr = new FileReader(f); // decirle donde esta el fichero
			BufferedReader bf = new BufferedReader(fr); // Buffer
			// leer linea a linea
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
			System.out.println("Error al leer el fichero.");
		}
		System.out.println("Terminada lectura de fichero.");
	}

	private static void buscarMiTesoro() {
		// TODO Auto-generated method stub		
		String tesoro = "MiTesoro";

		File dir = new File("C:/Desarrollo/Eclipse_Workspace/java_2018_0508/ficheros");

		searchFile(dir, tesoro);

		/*if (dir.isDirectory()) {
			File[] subcarpetas = dir.listFiles();
			for (int i = 0; i < subcarpetas.length; i++) {
				if (subcarpetas[i].isDirectory()) {
					//meter aqui recursividad. search file si uso metodo aparte o buscarMiTesoro si esta todo dentro de este
					searchFile(subcarpetas[i], tesoro)
				} else {
					FileReader fr;
					try {
						fr = new FileReader(subcarpetas[i]);
						BufferedReader bf = new BufferedReader(fr);
						String linea;
						while ((linea = bf.readLine()) != null) {
							if(linea.contains(tesoro)) {
								System.out.println("Tesoro encontrado en: " + subcarpetas[i].getAbsolutePath());
							}
						}

					} catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println("Error al leer fichero.");
					}
				}
			}
		} else {
			System.out.println("El fichero no es un directorio.");
		}*/
	}
	
	/**
	 * Busca de forma recursiva dentro de un sistema de ficheros una "palabra"
	 * @param File - Fichero a leer
	 * @param palabra String a buscar dentro del fichero
	 * @return
	 */
	private static void searchFile(File dir, String tesoro) {
		// TODO Auto-generated method stub
		//boolean resul = false;
		
		if (dir.isDirectory()) {
			File[] subcarpetas = dir.listFiles();
			//tambien vale con for each )
			for (int i = 0; i < subcarpetas.length; i++) {
				if (subcarpetas[i].isDirectory()) {
					//meter aqui recursividad. search file si uso metodo aparte o buscarMiTesoro si esta todo dentro de este
					searchFile(subcarpetas[i], tesoro);
				} else {
					FileReader fr;
					try {
						fr = new FileReader(subcarpetas[i]);
						BufferedReader bf = new BufferedReader(fr);
						String linea;
						while ((linea = bf.readLine()) != null) {
							if(linea.contains(tesoro)) {
								System.out.println("Tesoro encontrado en: " + subcarpetas[i].getAbsolutePath());
								//resul = true;
								break;
							}
						}
						bf.close();
						fr.close();

					} catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println("Error al leer fichero.");
					}
				}
			}
		} else {
			System.out.println("El fichero no es un directorio.");
		}
	}

	private static void listarUnidadesPc() {
		// TODO Auto-generated method stub
		System.out.println("Listar unidades disco duro");

		File[] unidades = File.listRoots();
		for (int i = 0; i < unidades.length; i++) {

		}
	}
}
