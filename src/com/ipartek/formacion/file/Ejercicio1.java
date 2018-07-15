package com.ipartek.formacion.file;

import java.io.File;

/**
 * Programa que muestre todas las unidades de disco del ordenador indicando para
 * cada una de ellas el tamaño disponible y el tamaño total.
 * 
 * @author Luis
 *
 */
public class Ejercicio1 {

	static File[] unidades;

	public static void main(String[] args) {

		System.out.println("Leyendo unidades del sistema....");

		cargarUnidades();

		mostrarResultados();
		
		System.out.println("Finalizado con éxito");

	} // FIN main();

	private static void cargarUnidades() {

		unidades = File.listRoots(); // Leemos las unidades del SO con el método listRoots de la clase File

	} // FIN cargarUnidades();

	private static void mostrarResultados() {

		System.out.printf("   %20s %20s %n", "Tamaño Total", "Tamaño disponible");
		for (File file : unidades) {
			System.out.print(file);
			System.out.printf("   %20s %20s %n", file.getTotalSpace(), file.getFreeSpace());
		}
	} // FIN mostrarResultados();

} // FIN Ejercicio1
