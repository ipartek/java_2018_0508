package com.ipartek.formacion.libros;

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

	static private final boolean OPCION_NOPRESTADO = false;
	static private final boolean OPCION_PRESTADO = true;

	public static void main(String[] args) {

		try {

			sc = new Scanner(System.in);
			dao = LibroDAO.getInstance();
			cargarLibros();

			do {

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
				}

			} while (opcionSeleccionada != OPCION_SALIR);
		} catch (Exception e) {
			System.out.println("Lo sentimos la aplicacion esta fuera de servicio por problemas tecnicos");
		} finally {
			sc.close();
		}
	}

	private static void buscarLibro() {

		sc = new Scanner(System.in);
		String texto = "";

		System.out.println("Introduzca texto del titulo a buscar:");
		texto = sc.next();

		ArrayList<Libro> libro = (ArrayList<Libro>) dao.getByTitulo(texto);

		for (Libro l : libro) {
			System.out.println(l);
			contBuscar++;

		}
		if (contBuscar == VACIO) {
			System.out.println("El libro que buscas, no esta en nuestra base de datos.");
		}

	}

	/**
	 * 
	 * Metodo que segun la opcion del menu que el usurario elija(
	 * OPCION_LISTARPRESTADOS u OPCION_LISTARNOPRESTADOS) muestra una lista con los
	 * libros correspondientes.
	 * 
	 * @param opcionListar int
	 */
	private static void listarPrestados(int opcionListar) {
		try {
			if (opcionListar == OPCION_LISTARPRESTADOS) {
				ArrayList<Libro> libro = (ArrayList<Libro>) dao.getALlPrestados(OPCION_PRESTADO);
				for (Libro l : libro) {
					System.out.println(l);
					contBuscar++;

				}
			} else {
				System.out.println("Actualmente no hay libros en prestamos");
			}

			if (opcionListar == OPCION_LISTARNOPRESTADOS) {
				ArrayList<Libro> libro = (ArrayList<Libro>) dao.getALlPrestados(OPCION_NOPRESTADO);
				for (Libro l : libro) {
					System.out.println(l);
					contBuscar++;

				}
			} else {
				System.out.println("Actualmente estan todos prestados");
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
