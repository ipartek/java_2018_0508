package com.ipartek.formacion.cms;

import java.util.List;
import java.util.Scanner;

import com.ipartek.formacion.model.LibroDAO;
import com.ipartek.formacion.pojo.Libro;

public class GestorDeLibros {

	static private final int OPCION_SALIR = 0;
	static private final int OPCION_LISTAR = 1;
	static private final int OPCION_PRESTADOS = 2;
	static private final int OPCION_NO_PRESTADOS = 3;
	static private final int OPCION_BUSCAR = 4;

	static private LibroDAO dao;
	private static int cont = 0;

	static Scanner sc;
	static private int opcionSeleccionada = -1;

	public static void main(String[] args) {
		boolean esFin = false;

		try {
			sc = new Scanner(System.in);

			System.out.println("------------------------------------");
			System.out.println("--        BIENVENIDO/A            --");

			dao = LibroDAO.getInstance();

			cargarLibros();

			do {

				pintarMenu();

				switch (opcionSeleccionada) {
				case OPCION_SALIR:
					esFin = true;
					salir();
					break;

				case OPCION_LISTAR:
					listarLibros();
					break;

				case OPCION_PRESTADOS:
					mostrarPrestamos(true);
					break;

				case OPCION_NO_PRESTADOS:
					mostrarPrestamos(false);
					break;

				case OPCION_BUSCAR:
					buscarLibro();
					break;

				default:
					noOption();
					break;
				}

			} while (opcionSeleccionada != OPCION_SALIR);

		} catch (Exception e) {

			System.out.println("Sentimos las molestias, ha ocurrido un error inesperado.");

		} finally {
			if (sc != null) {
				sc.close();
			}
			dao = null;
			if (!esFin) {
				salir();
			}
		}

	}

	private static void buscarLibro() {

		List<Libro> libros = dao.getAll();
		String busqueda = null;
		boolean hay = false;

		do {
			sc.nextLine();
			System.out.println("Por favor, introduce una palabra o título que quieras buscar: ");
			busqueda = sc.nextLine();
			
		} while (busqueda.isEmpty());
		

		if (libros.size() > 0) {
			System.out.println("Libros con la palabra " + busqueda + ":");
			for (Libro libro : libros) {
				if (libro.getTitulo().toLowerCase().contains(busqueda.toLowerCase().trim())) {
					hay = true;
					System.out.println(libro);
				}
			}
			if (!hay) {
				System.out.println("LO SENTIMOS. No hay libros que contengan la plabra " + busqueda + ".");
			}
		} else {
			System.out.println("LO SENTIMOS. La lista de libros está vacía.");
		}

	}

	private static void cargarLibros() {

		Libro l;
		try {
			l = new Libro(++cont, "FARIÑA: HISTORIA E INDISCRECIONES DEL NARCOTRAFICO EN GALICIA", "Nacho Carretero",
					"Libros del K.O.", "9788416001460", 358, true);
			dao.insert(l);
			l = new Libro(++cont, "LENGUA TRIMESTRAL 2º EDUCACION PRIMARIA", "V.V.A.A.", "Ediciones SM",
					"9788467575057", 344, false);
			dao.insert(l);
			l = new Libro(++cont, "MATEMÁTICAS TRIMESTRAL SAVIA-15", "V.V.A.A.", "Ediciones SM", "9788467575071", 288,
					false);
			dao.insert(l);
			l = new Libro(++cont, "LA VOZ DE TU ALMA", "Lain García Calvo", "Autor-Editor", "9788461716098", 390, true);
			dao.insert(l);
			l = new Libro(++cont, "LENGUA CASTELLANA 3º EDUCACION PRIMARIA", "V.V.A.A.", "Ediciones SM",
					"9788467569957", 246, false);
			dao.insert(l);
			l = new Libro(++cont, "NEW HIGH FIVE 1 PUPILS BOOK PACK", "V.V.A.A.", "Mcmillan Childrens Books",
					"9781380013835", 126, false);
			dao.insert(l);
			l = new Libro(++cont, "NEW HIGH FIVE 3 PUPILS BOOK PACK", "V.V.A.A.", "Mcmillan Childrens Books",
					"9781380011718", 126, false);
			dao.insert(l);
		} catch (Exception e) {

			System.out.println("LO SENTIMOS. El ISBN no es correcto.");
		}

	}

	private static void pintarMenu() {

		System.out.println("------------------------------------");
		System.out.println("--          LIBROS                --");
		System.out.println("------------------------------------");
		System.out.println("-    1. Listar                     -");
		System.out.println("-    2. Mostrar Prestados          -");
		System.out.println("-    3. Mostrar No Prestados       -");
		System.out.println("-    4. Buscar                     -");
		System.out.println("-    0. Salir                      -");
		System.out.println("------------------------------------");
		System.out.println("");
		System.out.print("Por favor, selecciona una opcion: ");

		try {
			opcionSeleccionada = sc.nextInt();

		} catch (Exception e) {
			System.out.println("ERROR: " + "La opción introducida no es un número.");
			System.out.println("Por favor, introduzca un valor numérico.");
			sc.nextLine();
			pintarMenu();
		}
	}

	private static void noOption() {

		System.out.println("LO SENTIMOS. La opcion seleccionada no existe.");

	}

	private static void salir() {

		System.out.println("");
		System.out.println("");
		System.out.println("");
		sc.close(); // Cerramos el Scanner

		System.out.println("HASTA OTRA. Esperamos volver a verte!!! =)");

	}

	private static void listarLibros() {
		List<Libro> libros = dao.getAll();

		if (libros.size() > 0) {
			
			for (Libro libro : libros) {
				
				System.out.println("    " + libro);
				System.out.println();
			}
		} else {
			System.out.println("LO SENTIMOS. No hay libros en la lista.");
		}

	}

	private static void mostrarPrestamos(boolean prestados) {

		List<Libro> libros = dao.getAll();
		
		if (libros.size() > 0) {
			if (prestados) {
				System.out.println("Lista de libros prestados: ");
			} else {
				System.out.println("Lista de libros disponibles: ");
			}

			for (Libro libro : libros) {
				if (prestados) {
					if (libro.isPrestado()) {
						System.out.println("    " + libro);
					}
				} else {
					if (!libro.isPrestado()) {
						System.out.println("    " + libro);
					}
				}
			}
		} else {
			System.out.println("LO SENTIMOS. No hay libros prestados.");
		}

	}

}
