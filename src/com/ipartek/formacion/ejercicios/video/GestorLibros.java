package com.ipartek.formacion.ejercicios.video;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.ipartek.formacion.model.LibroDAO;
import com.ipartek.formacion.pojo.Libro;

public class GestorLibros {

	private static Scanner sr = new Scanner(System.in);

	static private final int OPCION_SALIR = 0;
	static private final int OPCION_LISTAR = 1;
	static private final int OPCION_LISTAR_PRESTADOS = 2;
	static private final int OPCION_LISTAR_NOPRESTADOS = 3;
	static private final int OPCION_BUSCAR = 4;

	private static LibroDAO dao = LibroDAO.getIntance();

	public static void main(String[] args) throws Exception {

		int opcion = 0;

		cargarVideos();

		do {

			try {
				mostrarMenu();

				opcion = sr.nextInt();
				sr.nextLine();

				switch (opcion) {

				case OPCION_LISTAR:

					List<Libro> lib = dao.getAll();

					mostrarLista(lib);
					break;

				case OPCION_LISTAR_PRESTADOS:

					listaNoPrestados();
					break;

				case OPCION_LISTAR_NOPRESTADOS:

					listaSiPrestados();
					break;

				case OPCION_BUSCAR:

					buscarLibro();
					break;

				case OPCION_SALIR:

					System.out.println("Gracias por tu visita a nuestra aplicacion ");
					break;

				default:

					System.out.println("Has ingresado un numero ERRONEO");
				}
			} catch (InputMismatchException ex) {
				System.out.println("No has introducido un numero valido");
			}

		} while (opcion != OPCION_SALIR);

	}

	private static void listaSiPrestados() {
		List<Libro> lib = dao.getAll();
		for (int i = 0; i < lib.size(); i++) {
			Libro l = lib.get(i);
			if (l.isPrestado() == true) {
				System.out.println(l.toString());
			}

		}
	}

	private static void listaNoPrestados() {
		List<Libro> lib = dao.getAll();
		for (int i = 0; i < lib.size(); i++) {
			Libro l = lib.get(i);
			if (l.isPrestado() == false) {
				System.out.println(l.toString());
			}

		}

	}

	private static void cargarVideos() throws Exception {

		Libro lib = new Libro("9788416001460", "FARIÑA HISTORIA E INDISCRECIONES DEL NARCOTRAFICO EN GALICIA",
				"LIBROS DEL K.O", false);
		dao.insert(lib);
		lib = new Libro("9788467575057", "LENGUA TRIMESTRAL 2º EDUCACION PRIMARIA SAVIA ED 2015 ", "EDICIONES SM",
				true);
		dao.insert(lib);
		lib = new Libro(" 9788467575071", "MATEMÃ�TICAS TRIMESTRAL SAVIA-15", "EDICIONES SM", false);
		dao.insert(lib);
		lib = new Libro(" 9788461716098", "LA VOZ DE TU ALMA", "AUTOR-EDITOR", true);
		dao.insert(lib);
		lib = new Libro("  9788467569957",
				"LENGUA CASTELLANA 3Âº EDUCACION PRIMARIA TRIMESTRES SAVIA CASTELLA NO ED 2014 ", "EDICIONES SM",
				false);
		dao.insert(lib);
		lib = new Libro(" 9781380013835", "NEW HIGH FIVE 1 PUPILS BOOK PACK", "MACMILLAN CHILDRENS ", false);
		dao.insert(lib);
		lib = new Libro(" 9781380011718", "NEW HIGH FIVE 3 PUPILS BOOK", "MACMILLAN CHILDRENS ", true);
		dao.insert(lib);

	}

	private static void buscarLibro() {

		List<Libro> lib = dao.getAll();
		String titulo;
		System.out.println("Ingrese el libro que desea buscar por favor : ");
		titulo = sr.nextLine();

		for (int i = 0; i < lib.size(); i++) {
			Libro l = lib.get(i);
			if (l.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
				System.out.println(l.toString());
			}

		}
	}

	private static void mostrarLista(List<Libro> lib) {
		if (lib.size() == 0) {
			System.out.println("No hay libros ");
		} else {
			for (int i = 0; i < lib.size(); i++) {
				Libro li = lib.get(i);
				System.out.println(li.toString());
			}

		}
	}

	private static void mostrarMenu() {
		System.out.println("Selecciona una opcion:");
		System.out.println("1 - Listado");
		System.out.println("2 - Listado no prestados");
		System.out.println("3 - Listado prestados");
		System.out.println("4 - Buscar");
		System.out.println("0 - Salir");

	}

}
