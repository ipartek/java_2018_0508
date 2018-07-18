package com.ipartek.formacion.libros;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.model.LibroDAO;
import com.ipartek.formacion.pojo.Libro;
import com.sun.corba.se.impl.io.TypeMismatchException;

public class Biblioteca {

	static private final int OPCION_LISTAR_TODOS = 1;
	static private final int OPCION_LISTAR_PRESTADOS = 2;
	static private final int OPCION_LISTAR_DISPONIBLES = 3;
	static private final int OPCION_BUSCAR_POR_TITULO = 4;
	static private final int OPCION_SALIR = 5;
	static private final int ISBN_LENGHT = 5;
	static private final String MENSAJE_ERROR_ISBN = "El ISBN del libro debe tener al menos " + ISBN_LENGHT;

	static private LibroDAO dao;
	static private int opcionSeleccionada = 0;
	static BufferedReader br;
	static private List<Libro> listaPrestados = new ArrayList<Libro>();
	static private List<Libro> listaDisponibles = new ArrayList<Libro>();

	static int cont = 0;// Corntrola el id que se le dara al libreo en la lista.

	public static void main(String[] args) throws Exception {

		try {
			br = new BufferedReader(new InputStreamReader(System.in));

			dao = LibroDAO.getInstance();
			cargarLibros();
			pintarMenu();

		} catch (Exception e) {
			throw new Exception(MENSAJE_ERROR_ISBN);
		}

	}

	// Metodos

	private static void pintarMenu() {
		do {
			System.out.println("----------------------------------");
			System.out.println("-----------Biblioteca-------------");
			System.out.println("----------------------------------");
			System.out.println("    1.Listar todos los libros     ");
			System.out.println("    2.Listar libros prestados     ");
			System.out.println("    3.Listar libros disponibles   ");
			System.out.println("    4.Buscar libro por título     ");
			System.out.println("    5.Salir                       ");
			System.out.println("----------------------------------");
			System.out.println("Elige una opcion");
			try {

				opcionSeleccionada = Integer.parseInt(br.readLine());

			} catch (TypeMismatchException e) {
				System.out.println("Lo sentimos pero debe introducir un numero de la lista");

			} catch (Exception e) {
				System.out.println("Lo sentimoss pero no has introducido una opcion correcta");
				System.out.println("Introduzca una numero entre 1 y 5 por favor");
				pintarMenu();

			}
		} while (opcionSeleccionada == OPCION_SALIR || opcionSeleccionada == 0);

		switch (opcionSeleccionada) {
		case OPCION_LISTAR_TODOS:
			listarTodos();
			pintarMenu();
			break;

		case OPCION_LISTAR_PRESTADOS:
			listarPrestados();
			pintarMenu();
			break;

		case OPCION_LISTAR_DISPONIBLES:
			listarDisponibles();
			pintarMenu();
			break;

		case OPCION_BUSCAR_POR_TITULO:
			buscarPorTitulo();
			pintarMenu();
			break;

		case OPCION_SALIR:
			System.out.println("Hasta la próxima.");
			System.exit(0);
		default:
			System.out.println("Por favor introduzca una opcion correcta");
			break;
		}
	}

	private static void cargarLibros() throws Exception {

		/*
		 * dao.insert(new Libro(0, "9788416001460",
		 * "FARIÑA: HISTORIA E INDISCRECIONES DEL NARCOTRAFICO EN GALICIA",
		 * "LIBROS DEL K.O", true));
		 */

		dao.insert(new Libro(1, "9788467575057", "LENGUA TRIMESTRAL 2º EDUCACION PRIMARIA SAVIA ED 2015",
				"EDICIONES SM", false));
		dao.insert(new Libro(2, "9788467575071", "MATEMÁTICAS TRIMESTRAL SAVIA-15", "EDICIONES SM", false));

		// dao.insert(new Libro(3, "9788461716098", "LA VOZ DE TU ALMA", "AUTOR-EDITOR",
		// true));

		dao.insert(new Libro(4, "9788467569957",
				"LENGUA CASTELLANA 3º EDUCACION PRIMARIA TRIMESTRES SAVIA CASTELLA NO ED 2014", "EDICIONES SM", false));
		dao.insert(
				new Libro(5, "9781380013835", "NEW HIGH FIVE 1 PUPILS BOOK PACK", "MACMILLAN CHILDRENS BOOKS", false));

		dao.insert(new Libro(6, "9781380011718", "NEW HIGH FIVE 3 PUPILS BOOK", "MACMILLAN CHILDRENS BOOKS", false));
		cont = dao.getAll().size();//
		// Utilizaremos cont para determinar el id de los libros

		System.out.println(dao.getAll().size());
	}

	private static void listarTodos() {
		if (dao.getAll().isEmpty()) {
			System.out.println("La lista esta vacia");
		} else {
			for (Libro libroIteracion : dao.getAll()) {
				System.out.println(libroIteracion.toString());

			}
		}

	}

	/**
	 * 
	 * Metodo que lista los libros que estan prestados.
	 * 
	 * @see Libro
	 * 
	 */

	private static void listarPrestados() {
		if (dao.getAll().isEmpty()) {
			System.out.println("No ");
		} else {

		}

		for (Libro libroIteracion : dao.getAll()) {
			if (libroIteracion.isPrestado()) {
				listaPrestados.add(libroIteracion);
			}

		}
		if (listaPrestados.isEmpty()) {
			System.out.println("No hay ningún libro prestado");
		} else {
			for (Libro libroIteracion : listaPrestados) {
				System.out.println(libroIteracion.toString());
			}
		}
	}

	/**
	 * 
	 * Metodo que lista los libros que no estan prestados.
	 * 
	 * @see Libro
	 * 
	 */
	private static void listarDisponibles() {
		for (Libro libroIteracion : dao.getAll()) {
			if (libroIteracion.isPrestado() == false) {
				listaDisponibles.add(libroIteracion);
			}
		}
		if (listaDisponibles.isEmpty()) {
			System.out.println("No hay ningún libro disponible");
		} else {
			for (Libro libroIteracion : listaDisponibles) {
				System.out.println(libroIteracion.toString());
			}
		}

	}

	/**
	 * 
	 * Metodo que busca los libros que contengan la palabra o palabras que introduce
	 * el ususario.
	 */
	private static void buscarPorTitulo() {

		String titulo = "";
		Libro libroBuscado = null;

		do {
			System.out.println("Introduzca el titulo del libro que desea buscar");
			try {

				titulo = br.readLine().toUpperCase();

				if (!titulo.equalsIgnoreCase("")) {
					for (Libro libroIteracion : dao.getAll()) {
						if (libroIteracion.getTitulo().trim().contains(titulo.trim())) {
							libroBuscado = libroIteracion;
							System.out.println(libroBuscado.toString());

						}
					}

				}
				if (libroBuscado == null) {
					System.out.println("El libro buscado no se encuentra en la lista.");

				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		} while (titulo.equalsIgnoreCase(""));

	}

}
