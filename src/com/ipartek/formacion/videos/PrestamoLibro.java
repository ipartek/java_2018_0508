package com.ipartek.formacion.videos;

import java.util.Scanner;

import com.ipartek.formacion.model.LibrosDAO;
import com.ipartek.formacion.pojo.Libro;

public class PrestamoLibro {

	static private LibrosDAO dao;

	private static int cont = 0;

	static private int opcionSeleccionada = -1;
	static Scanner sc = null;

	static private final int OPCION_SALIR = 0;
	static private final int OPCION_LISTAR_TODOS = 1;
	static private final int OPCION_LISTAR_PRESTADOS = 2;
	static private final int OPCION_LISTAR_NO_PRESTADOS = 3;
	static private final int OPCION_LISTAR_BUSQUEDA = 4;

	public static void main(String args[]) {

		try {
			System.out.println("-----------------------------------------------------");
			System.out.println("--  BIENVENIDO/A AL PRESTAMO DE LIBROS DE IPARTEK  --");

			dao = LibrosDAO.getInstance();
			sc = new Scanner(System.in);

			cargarLibros();

			pintarMenu();

			do {
				switch (opcionSeleccionada) {

				case OPCION_LISTAR_TODOS:
					listar();
					break;

				case OPCION_SALIR:
					salir();
					break;

				case OPCION_LISTAR_PRESTADOS:
					listarPrestados();
					break;

				case OPCION_LISTAR_NO_PRESTADOS:
					listarNoPrestados();
					break;

				case OPCION_LISTAR_BUSQUEDA:
					listarPorTitulo();
					break;

				default:
					noOption();
					break;
				}

			} while (opcionSeleccionada != OPCION_SALIR);
		} catch (Exception e) {
			System.out.println("Ha sucedido un error que intentaremos arreglar cuanto antes.\n");
			System.out.println("Disculpen las molestias.");
		}

	}

	private static void listarPorTitulo() {
		String titulo;

		System.out.println("------------------------------------");
		System.out.println("- MENÚ LISTAR POR TÍTULO          --");
		System.out.println("------------------------------------\n");

		System.out.println("Introduce un libro a buscar: ");
		titulo = sc.next();

		for (Libro libro : dao.getAll()) {

			if (libro.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
				System.out.println("    " + libro);
			}
		}

		System.out.println("");
		System.out.println("");
		System.out.println("");

		pintarMenu();

	}

	private static void listarNoPrestados() {
		System.out.println("------------------------------------");
		System.out.println("--       MENÚ LISTAR PRESTADO     --");
		System.out.println("------------------------------------\n");

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
		System.out.println("------------------------------------");
		System.out.println("--       MENÚ LISTAR PRESTADO     --");
		System.out.println("------------------------------------\n");

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

	private static void noOption() {

		System.out.println("LO SENTIMOS. La opción seleccionada no existe.");
		System.out.println("Debes elegir un número del 0 al 4.");
		pintarMenu();
		sc.reset();

	}

	private static void cargarLibros() throws Exception {

		Libro libro = new Libro(++cont, "9788416001460", "Fariña", "LIBROS DEL K.O", true);
		dao.insert(libro);

		libro = new Libro(++cont, "9788467575057", "LENGUA TRIMESTRAL 2º EDUCACION PRIMARIA", "EDITORIAL S.M", false);
		dao.insert(libro);

		libro = new Libro(++cont, "9788467575071", "MATEMÁTICAS TRIMESTRAL SAVIA-15", "EDITORIAL S.M", false);
		dao.insert(libro);

		libro = new Libro(++cont, "9788461716098", "LA VOZ DE TU ALMA", "AUTOR-EDITOR", true);
		dao.insert(libro);

		libro = new Libro(++cont, "9788467569957", "LENGUA CASTELLANA 3º EDUCACION PRIMARIA TRIMESTRES",
				"EDITORIAL S.M", false);
		dao.insert(libro);

		libro = new Libro(++cont, "9781380013835", "NEW HIGH FIVE 1 PUPILS BOOK PACK", "MACMILLAN CHILDRENS ", false);
		dao.insert(libro);

	}


	private static void listar() {
	
		System.out.println("------------------------------------");
		System.out.println("--         MENÚ LISTAR            --");
		System.out.println("------------------------------------\n");

		for (Libro libro : dao.getAll()) {
			/*MIRAR
			 * if (libro.isPrestado()) {
				prestado = "SI";
			} else {
				prestado = "NO";
			}*/
			System.out.println("    " + libro);
		}

		System.out.println("");
		System.out.println("");
		System.out.println("");

		pintarMenu();

	}

	private static void salir() {

		System.out.println("Vuelve pronto.");
		sc.close();

	}

	private static void pintarMenu() {

		System.out.println("------------------------------------");
		System.out.println("-       PRESTAMO DE LIBROS        --");
		System.out.println("------------------------------------");
		System.out.println("-    1. Listar todos               -");
		System.out.println("-    2. Listar prestados           -");
		System.out.println("-    3. Listar no prestados        -");
		System.out.println("-    4. Listar por título          -");
		System.out.println("-                                  -");
		System.out.println("-    0. Salir                      -");
		System.out.println("------------------------------------");
		System.out.println("");
		System.out.print("Por favor, selecciona una opción del 0 al 4: ");

		try {
			opcionSeleccionada = sc.nextInt();

		} catch (Exception e) {
			// e.printStackTrace(); -->pinta la pila de excepcion

			System.out.println("OPCIÓN NO VALIDA. Por favor introduce un número del 0 al 4.\n");
			pintarMenu();
		}

	}

}