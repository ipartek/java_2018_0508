package com.ipartek.formacion.libreria;

import java.io.IOException;
import java.util.Scanner;


public class GestorLibros {

	static private LibroDAO dao;
	static private int opcionSeleccionada = 0;
	static Scanner sc = null;

	static private final int OPCION_SALIR = 0;
	static private final int OPCION_LISTAR_PRESTADOS = 1;
	static private final int OPCION_LISTAR_NO_PRESTADOS = 2;
	static private final int OPCION_BUSCAR = 3;

	static public boolean SALIR = false;

	static public final char NO = 'n';

	public static void main(String[] args) throws Exception {
		sc = new Scanner(System.in);

		dao = LibroDAO.getInstance();

		cargarLibros();

		pintarMenu();

		do {
			switch (opcionSeleccionada) {
			case OPCION_LISTAR_PRESTADOS:
				listarPrestados();
				break;

			case OPCION_LISTAR_NO_PRESTADOS:
				listarNoPrestados();
				break;

			case OPCION_BUSCAR:
				buscarPorTitulo();
				break;

			case OPCION_SALIR:
				salir();
				break;

			default:
				noOption();
				break;
			}

		} while (SALIR == false);

	}

	private static void buscarPorTitulo() throws IOException {
		String busqueda;

		char seguir;
		do {
			sc.nextLine();
			System.out.println("Introduce aquello que desees buscar: ");
			busqueda = sc.nextLine();

			for (Libro libro : dao.buscarPorTitulo(busqueda)) {
				//if (!dao.buscarPorTitulo(busqueda).isEmpty()) {
				System.out.println("  " + libro);
				// } else {
				// System.out.println("Lo siento, no se ha encontrado ningun nombre con ese titulo..");
				// }
			}

			System.out.println("Deseas realizar otra busqueda?(s/n)");
			seguir = (char) System.in.read();

		} while (seguir != NO);
		pintarMenu();

	
	}

	private static void listarNoPrestados() {
		for (Libro libro : dao.getAll()) {
			if (libro.isPrestado() == false) {
				System.out.println("    " + libro);
			}
		}

		System.out.println("");
		System.out.println("");
		System.out.println("");

		pintarMenu();

	}

	private static void listarPrestados() {
		for (Libro libro : dao.getAll()) {
			if (libro.isPrestado() == true) {
				System.out.println("    " + libro);
			}
		}
		System.out.println("");
		System.out.println("");
		System.out.println("");

		pintarMenu();

	}

	private static void cargarLibros() throws Exception {

		Libro libro = new Libro(1, "9788416001460",
				"FARIÑA: HISTORIA E INDISCRECIONES DEL" + " NARCOTRAFICO EN GALICIA", "LIBROS DEL K.O", true);
		dao.insert(libro);

		libro = new Libro(2, "9788467575057", "LENGUA TRIMESTRAL 2º EDUCACION PRIMARIA SAVIA" + " ED 2015",
				"EDICIONES SM", false);
		dao.insert(libro);

		libro = new Libro(3, "9788467575071", "MATEMÁTICAS TRIMESTRAL SAVIA-15", "EDICIONES SM", false);
		dao.insert(libro);

		libro = new Libro(4, "9788461716098", "LA VOZ DE TU ALMA", "LAIN GARCIA CALVO", true);
		dao.insert(libro);

		libro = new Libro(5, "9788467569957",
				"LENGUA CASTELLANA 3º EDUCACION PRIMARIA" + " TRIMESTRES SAVIA CASTELLA NO ED 2014", "EDICIONES SM",
				false);
		dao.insert(libro);

		libro = new Libro(6, "9781380013835", "NEW HIGH FIVE 1 PUPILS BOOK PACK", "MACMILLAN CHILDRENS BOOKS", false);
		dao.insert(libro);

		libro = new Libro(7, "9781380011718", "NEW HIGH FIVE 3 PUPILS BOOK", "MACMILLAN CHILDRENS BOOKS", false);
		dao.insert(libro);

	}

	private static void salir() {
		System.out.println(" ");
		System.out.println(" ");

		System.out.println("AGUR VENUR ETA JAN YOGUR");
		SALIR = true;
	}

	private static void noOption() {
		System.out.println("Lo sentimos No existe esa opcion");
		pintarMenu();

	}

	private static void pintarMenu() {

		System.out.println("------------------------------------");
		System.out.println("--          Libros                --");
		System.out.println("------------------------------------");
		System.out.println("-    1. Listar prestados           -");
		System.out.println("-    2. Listar no prestados        -");
		System.out.println("-    3. Buscar                     -");
		System.out.println("-                                  -");
		System.out.println("-    0. Salir                      -");
		System.out.println("------------------------------------");
		System.out.println("");
		System.out.println("Dime una opcion por favor");

		try {
			opcionSeleccionada = sc.nextInt();
		} catch (Exception e) {
			// e.printStackTrace();
			sc.nextLine();
			System.out.println("!OPCION NO VALIDA! Porfavor introduce un numero del menu");
			pintarMenu();
		}

	}

}
