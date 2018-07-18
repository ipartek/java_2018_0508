package com.ipartek.formacion.ejercicios;

import java.util.ArrayList;
import java.util.Scanner;

import com.ipartek.formacion.model.LibroDAO;
import com.ipartek.formacion.pojo.Libro;

public class Biblioteca {

	static private LibroDAO dao;
	static private int opcionSeleccionada = 0;
	static Scanner sc = null;
	private static int contBuscar = 0;

	static private final int OPCION_SALIR = 0;
	static private final int OPCION_LISTARPRESTADOS = 1;
	static private final int OPCION_LISTARNOPRESTADOS = 2;
	static private final int OPCION_BUSCAR = 3;
	static private final int VACIO = 0;

	public static void main(String[] args) {

		do {
			try {

				sc = new Scanner(System.in);
				dao = LibroDAO.getInstance();

				cargarLibros();

				pintarMenu();

				switch (opcionSeleccionada) {
				case OPCION_LISTARPRESTADOS:
					listarPrestados(opcionSeleccionada);
					break;
				case OPCION_LISTARNOPRESTADOS:
					listarPrestados(opcionSeleccionada);
					break;
				case OPCION_BUSCAR:
					buscarLibro();
					break;
				case OPCION_SALIR:
					System.out.println("Saliendo de la aplicacion...Hasta la proxima");
					break;
				default:
					break;
				}

			} catch (Exception e) {
				// TODO: handle exception
			}
		} while (opcionSeleccionada != OPCION_SALIR);

	}

	private static void buscarLibro() {

		sc = new Scanner(System.in);
		String texto = "";

		ArrayList<Libro> libro = (ArrayList<Libro>) dao.getALl();

		System.out.println("Introduzca texto del titulo a buscar:");
		texto = sc.next();

		for (Libro l : libro) {
			if (l.getTitulo().toLowerCase().contains(texto.toLowerCase().trim())) {
				System.out.println(l);
				contBuscar++;
			}
		}
		if (contBuscar == 0) {
			System.out.println("No se ha encontrado ningun libro.");
		}

	}

	
	/**
	 * 
	 * @param opcionListar int para saber si el usurario quiere ver los libros que estan prestados o no.
	 */
	private static void listarPrestados(int opcionListar) {
		try {
			ArrayList<Libro> libro = (ArrayList<Libro>) dao.getALl();

			if (libro.size() <= VACIO) {
				System.out.println("No hay libros para mostrar.");
			} else if (opcionListar == OPCION_LISTARPRESTADOS) {
				for (Libro l : libro) {
					if (l.isPrestado()) {
						System.out.println("  " + l + " \n");
					}
				}
			} else if (opcionListar == OPCION_LISTARNOPRESTADOS) {
				for (Libro l : libro) {
					if (!l.isPrestado()) {
						System.out.println("  " + l + " \n");
					}
				}
			}

		} catch (Exception e) {
			System.out.println("Actualmente no se puede mostrar la lista de libros.");
		}

	}

	public static void cargarLibros() throws Exception {

		Libro libro = new Libro(123456, "9788416001460",
				"FARIÑA: HISTORIA E INDISCRECIONES DEL NARCOTRAFICO EN GALICIA", "LIBROS DEL K.O", true);
		dao.insert(libro);

		libro = new Libro(456456456, "9788467575057", "LENGUA TRIMESTRAL 2º EDUCACION PRIMARIA SAVIA ED",
				"EDICIONES SM", false);
		dao.insert(libro);

		libro = new Libro(789679855, "9788467575071", "MATEMÁTICAS TRIMESTRAL SAVIA-15", "EDICIONES SM", false);
		dao.insert(libro);

		libro = new Libro(235423423, "9788461716098", "LA VOZ DE TU ALMA", "AUTOR-EDITOR", true);
		dao.insert(libro);

		libro = new Libro(456457456, "9788467569957",
				"LENGUA CASTELLANA 3º EDUCACION PRIMARIA TRIMESTRES SAVIA CASTELLA NO ED 2014 ", "EDICIONES SM", false);
		dao.insert(libro);

		libro = new Libro(12312312, "9781380013835", "NEW HIGH FIVE 1 PUPILS BOOK PACK ", " MACMILLAN CHILDRENS BOOKS",
				false);
		dao.insert(libro);

		libro = new Libro(124324325, "9781380011718", "NEW HIGH FIVE 3 PUPILS BOOK", " MACMILLAN CHILDRENS BOOKS",
				false);
		dao.insert(libro);

	}

	private static void pintarMenu() {

		System.out.println("|------------------------------------|");
		System.out.println("|           LIBROS                   |");
		System.out.println("|------------------------------------|");
		System.out.println("|    	1. Listar libros prestados   |");
		System.out.println("|------------------------------------|");
		System.out.println("|    	2. Listar libros no prestados|");
		System.out.println("|------------------------------------|");
		System.out.println("|    	3. Buscar                    |");
		System.out.println("|------------------------------------|");
		System.out.println("|    	0. salir	             |");
		System.out.println("|------------------------------------|\n");

		System.out.print("Inserta opcion deseada:");
		try {
			opcionSeleccionada = sc.nextInt();

		} catch (Exception e) {
			System.out.println("OPCION NO VALIDAD, Por favor introduce un numero del menu");
			sc.nextLine();
			pintarMenu();
		}
	}

}
