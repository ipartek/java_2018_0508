package com.ipartek.formacion.ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Fichero {

	public static void main(String[] args) {

		//crearFichero();

		//leerFichero();
		
		//buscarMiTesoro();
		
		listarUnidadesPc();

	}
	
	private static void walkin(File dir) {
		 
        File listFile[] = dir.listFiles();
        if (listFile != null) {
            for (int i = 0; i < listFile.length; i++) {
                if (listFile[i].isDirectory()) {
                    walkin(listFile[i]);
                } else {
                    buscarMiTesoro(dir);
                }
            }
        }
    }

	private static void crearFichero() {

		File f = new File("C:\\desarrollo\\eclipse-workspace\\java_2018_0508\\ficheros\\temp.txt");
		System.out.println("path: " + f.getAbsolutePath());

		if (f.exists()) {
			System.out.println("Existe el fichero");
			
			String lorem = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc consectetur bibendum lacus, non interdum risus dictum at. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Integer iaculis blandit ante et semper. Nulla fringilla bibendum lorem quis egestas. Fusce nec odio bibendum lectus suscipit suscipit vitae ut sem. Maecenas condimentum aliquet venenatis. Suspendisse at dolor eleifend, tincidunt nisi vel, aliquam enim. Vivamus euismod sodales nibh vel aliquet. Sed non sodales nisi, vel ultricies purus. Maecenas placerat consectetur mi at ullamcorper. Cras consectetur, diam porttitor volutpat aliquam, turpis diam volutpat odio, convallis lobortis nulla eros at sem. Morbi ac nunc nisl.";
			
			//Escribir el lorem ipsum en el temp.txt
			
			try {
				//Usamos los Stream para mejorar la lectura o escritura.
				//InputStream inputStream = new FileInputStream(new File("hola.txt"));
				//InputStreamReader reader = new InputStreamReader(inputStream); buffer que lee caracter a caracter
				
				FileWriter fr = new FileWriter(f);
				BufferedWriter bf = new BufferedWriter(fr);
				
				try {
					
					bf.write(lorem);
					System.out.println("Escrito con éxito");
					
				} finally {
					bf.close();
					fr.close();
				}
				
			} catch (IOException e) {
				System.out.println("Caught exception while processing file: " + e.getMessage());
			}
			
			System.out.println("Terminada la lectura del fichero.");

		}//if
			else {
			try {
				f.createNewFile();
				System.out.println("Creamos el fichero");
			} catch (IOException e) {
				System.out.println("Lo sentimos, ha habido un error al crear el fichero");
				e.printStackTrace();
			}

		}
	} 

	private static void leerFichero() {

		//StringBuilder sb = new StringBuilder();
		
		File f = new File("C:\\desarrollo\\eclipse-workspace\\java_2018_0508\\ficheros\\hola.txt");
		System.out.println("Vamos a comenzar a leer fichero " + f.getName());

		try {
			//Usamos los Stream para mejorar la lectura o escritura.
			//InputStream inputStream = new FileInputStream(new File("hola.txt"));
			//InputStreamReader reader = new InputStreamReader(inputStream); buffer que lee caracter a caracter
			
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
		
		System.out.println("Terminada la lectura del fichero.");

	}
	
	private static void buscarMiTesoro(File dir) {
		
		Scanner entrada = null;
        String linea;
        int numeroDeLinea = 1;
        boolean contiene = false;
        Scanner sc = new Scanner(System.in);

        //Introducimos el texto a buscar
        
        String texto = "tesoro";

        try {
            //guardamos el path del fichero en la variable ruta
            
            //creamos un objeto File asociado al fichero seleccionado
            
            //creamos un Scanner para leer el fichero
            entrada = new Scanner(dir);
            
            //mostramos el nombre del fichero
            System.out.println("Archivo: " + dir.getName());
            
            //mostramos el texto a buscar
            System.out.println("Texto a buscar: " + texto);
            
            while (entrada.hasNext()) { //mientras no se llegue al final del fichero
                linea = entrada.nextLine();  //se lee una línea
                
                if (linea.contains(texto)) {   //si la línea contiene el texto buscado se muestra por pantalla
                    System.out.println("Linea " + numeroDeLinea + ": " + linea);
                    contiene = true;
                }
                
                numeroDeLinea++; //se incrementa el contador de líneas
            }
            if(!contiene){ //si el archivo no contienen el texto se muestra un mensaje indicándolo

                System.out.println(texto + " no se ha encontrado en el archivo");
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
            
        } catch (NullPointerException e) {
            System.out.println(e.toString() + "No ha seleccionado ningún archivo");
            
        } catch (Exception e) {
            System.out.println(e.toString());
            
        } finally {
        	
        	if(sc != null) {
        		sc.close();
        	}
        	
            if (entrada != null) {
                entrada.close();
            }
        }
    }
		
	

	private static void listarUnidadesPc() {
		
		System.out.println("-------------------");
		System.out.println("----Unidades PC----");
		System.out.println("-------------------");
		
		File[] unidades = File.listRoots();
		
		for (int i = 0; i < unidades.length; i++) {
			System.out.println(unidades[i]);
		}
		
	}

}
