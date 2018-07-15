package com.ipartek.formacion.file;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Programa que muestre el contenido de un directorio o carpeta. Se deben mostar
 * los nombres de los archivos y los directorios que contiene en orden
 * alfababético.
 * 
 * @author Luis
 *
 */
public class Ejercicio2 {

	static File[] unidades;
	static String[] archivos;

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Leyendo unidades del sistema....");

		mostrarDirectorios();

		System.out.println("Seleccione un directorio: ");
		int op = sc.nextInt() - 1;

		File directorio = new File(unidades[op].getPath().toString()); // Cargamos el directorio seleccionado

		archivos = directorio.list(); // Cargamos los ficheros del directorio seleccionado

		Arrays.sort(archivos);

		System.out.println("Listado de archivos de " + directorio + " :");

		mostrarResultados();

		System.out.println("Finalizado con éxito");

	} // FIN main();

	private static void mostrarDirectorios() {

		unidades = File.listRoots(); // Leemos las unidades del SO con el método listRoots de la clase File

		System.out.printf("   %20s %20s %n", "Tamaño Total", "Tamaño disponible");

		for (int i = 0; i < unidades.length; i++) {
			System.out.print((i + 1) + ". " + unidades[i]);
			System.out.printf("   %20s %20s %n", unidades[i].getTotalSpace(), unidades[i].getFreeSpace());
		}

	} // FIN mostrarDirectorios();

	/**
	 * Muestra los archivos del directorio seleccionado por orden alfabetico.
	 */
	private static void mostrarResultados() {

		for (int i = 0; i < archivos.length; i++) {
			System.out.println(archivos[i]);
		}

	} // FIN mostrarResultados();

} // FIN Ejercicio2
