package com.ipartek.formacion.libros;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ipartek.formacion.model.LibroDAO;
import com.ipartek.formacion.pojo.Libro;

public class GestorLibros {

	// Constantes
	private final static int OPCION0 = 0;
	//private final static int OPCION1 = 1;
	//private final static int OPCION2 = 2;
	private final static int OPCION3 = 3;

	static private LibroDAO dao;
	static Scanner teclado;

	public static void main(String[] args) {

		try {

			dao = LibroDAO.getInstance();
			teclado = new Scanner(System.in);
			cargarLibros();
			pintarMenu();

		} catch (Exception e) {

			System.out.println("Lo sentimos, hemos tenido un error.");

		} finally {
			teclado.close();
		}

	}

	/**
	 * Metodo para pinta el menu y seleccionar la operacion
	 */
	private static void pintarMenu() {

		System.out.println("------------------------------------------");
		System.out.println("--              BIBLIOTECA              --");
		System.out.println("------------------------------------------");
		System.out.println("-   1. Listar prestados                  -");
		System.out.println("-   2. Listar no prestados               -");
		System.out.println("-   3. Buscar                            -");
		System.out.println("------------------------------------------");
		System.out.println("-   0. Salir                             -");

		try {
			int opcion = -1;

			do {
				try {
					System.out.println();
					System.out.println("Elige una opcion del menu:");
					opcion = teclado.nextInt();

				} catch (Exception e) {
					System.out.println();
					System.out.println("Por favor, introduzca un valor correcto.");
					teclado.nextLine();
				}
			} while (opcion < OPCION0 || opcion > OPCION3);

			switch (opcion) {
			case 1:
				listarLibrosPrestados();
				break;
			case 2:
				listarLibrosNoPrestados();
				break;
			case 3:
				buscar();
				break;
			case 0:
				System.out.println();
				System.out.println("¡Hasta la proxima!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Metodo que carga la lista de libros
	 * 
	 * @throws Exception
	 */
	private static void cargarLibros() throws Exception {
		Libro libro1 = new Libro(1, "9788416001460", "FARIÑA", "LIBROS DEL K.O", true);
		dao.insert(libro1);
		Libro libro2 = new Libro(2, "9788467575057", "LENGUA TRIMESTRAL 2º", "EDICIONES SM", false);
		dao.insert(libro2);
		Libro libro3 = new Libro(3, "9788467575071", "MATEMÁTICAS TRIMESTRAL", "EDICIONES SM", false);
		dao.insert(libro3);
		Libro libro4 = new Libro(4, "9788461716098", "LA VOZ DE TU ALMA", "AUTOR-EDITOR", true);
		dao.insert(libro4);
		Libro libro5 = new Libro(5, "9788467569957", "LENGUA CASTELLANA 3º", "EDICIONES SM", false);
		dao.insert(libro5);
		Libro libro6 = new Libro(6, "9781380013835", "NEW HIGH FIVE 1", "MACMILLAN CHILDRENS BOOKS", false);
		dao.insert(libro6);
		Libro libro7 = new Libro(7, "9781380011718", "NEW HIGH FIVE 3", "MACMILLAN CHILDRENS BOOKS", false);
		dao.insert(libro7);
	}

	/**
	 * Metodo para listar un libro concreto por titulo
	 */
	private static void buscar() {
		try {
			String busqueda = null;

			teclado.nextLine();
			System.out.println();
			List<Libro> buscados = new ArrayList<Libro>();

			do {
				try {
					System.out.println("Introduce lo que estas buscando:");
					busqueda = teclado.nextLine();
					busqueda = busqueda.trim().toUpperCase();
				} catch (Exception e) {
					System.out.println("Por favor, introduce un titulo valido.");
					e.printStackTrace();
				}
			} while (busqueda == null);

			System.out.println();
			try {
				System.out.println("Estas son las coincidencias de lo que estabas buscando:");
				System.out.println("-----------------------------------------------------------");
				buscados = dao.buscarPorTitulo(busqueda);
				if(buscados.isEmpty()) {
					System.out.println("No hay libros relacionados con tu busqueda.");
					System.out.println();
				}else {
					System.out.println("ISBN ---------- TITULO");
					System.out.println("----------------------");
					for (int i = 0; i < buscados.size(); i++) {
						System.out.print(buscados.get(i).getIsbn() + " - ");
						System.out.println(buscados.get(i).getTitulo());
					}
				}
			} catch (Exception e) {
				System.out.println("Se ha producido un error al listar tu busqueda, lo sentimos.");
				e.printStackTrace();
			}

		} catch (Exception e) {
			System.out.println("Se ha producido un error al listar tu busqueda, lo sentimos.");
			e.printStackTrace();
		} finally {
			System.out.println();
			pintarMenu();
		}
	}

	/**
	 * Metodo para listar todos los libros prestados
	 */
	private static void listarLibrosPrestados() {
		System.out.println();
		List<Libro> prestados = new ArrayList<Libro>();
		try {
			System.out.println("Estos son los libros que estan bajo prestamo:");
			System.out.println("-----------------------------------------------------------");
			prestados = dao.getAllPrestados(true);
			if(prestados.isEmpty()) {
				System.out.println("No hay libros que esten bajo prestamo.");
				System.out.println();
			}else {
				System.out.println("ISBN ---------- TITULO");
				System.out.println("----------------------");
				for (int i = 0; i < prestados.size(); i++) {
					System.out.print(prestados.get(i).getIsbn() + " - ");
					System.out.println(prestados.get(i).getTitulo());
				}
			}
		} catch (Exception e) {
			System.out.println("Error al listar libros prestados, lo sentimos.");
			e.printStackTrace();
		} finally {
			System.out.println();
			pintarMenu();
		}
	}

	/**
	 * Metodo para listar todos los libros NO prestados
	 */
	private static void listarLibrosNoPrestados() {
		System.out.println();
		List<Libro> noPrestados = new ArrayList<Libro>();
		try {
			System.out.println("Estos son los libros que no estan bajo prestamo:");
			System.out.println("-----------------------------------------------------------");
			noPrestados = dao.getAllPrestados(false);
			if(noPrestados.isEmpty()) {
				System.out.println("No hay libros disponibles para prestar.");
				System.out.println();
			}else {
				System.out.println("ISBN ---------- TITULO");
				System.out.println("----------------------");
				for (int i = 0; i < noPrestados.size(); i++) {
					System.out.print(noPrestados.get(i).getIsbn() + " - ");
					System.out.println(noPrestados.get(i).getTitulo());
				}
			}
		} catch (Exception e) {
			System.out.println("Error al listar libros no prestados, lo sentimos.");
			e.printStackTrace();
		} finally {
			System.out.println();
			pintarMenu();
		}
	}
}
