package com.ipartek.formacion.libros;

import java.util.List;
import java.util.Scanner;

import com.ipartek.formacion.model.LibroArrayDAO;
import com.ipartek.formacion.pojo.Libro;

public class GestorLibros {

	static private LibroArrayDAO dao;
	static private int opcionSeleccionada = 0;
	static Scanner sc = null;

	static long id;
	static String titulo;

	static private final int OPCION_SALIR = 0;
	static private final int OPCION_LISTAPRESTADOS = 1;
	static private final int OPCION_LISTANOPRESTADOS = 2;
	static private final int OPCION_BUSCAR = 3;

	public static void main(String[] args) {

		sc = new Scanner(System.in);

		dao = LibroArrayDAO.getInstance();

		try {
			cargarLibros();
		} catch (Exception e) {
			e.printStackTrace();
		}

		pintarMenu();

		do {
			switch (opcionSeleccionada) {
			case OPCION_LISTAPRESTADOS:
				listarPrestados();
				break;

			case OPCION_LISTANOPRESTADOS:
				listarNoPrestados();
				break;

			case OPCION_BUSCAR:
				buscar();
				break;

			case OPCION_SALIR:
				salir();
				break;

			default:
				noOption();
				break;
			}
		} while (opcionSeleccionada != OPCION_SALIR);
		sc.close();
	}

	/**
	 * Muestra la lista de libros prestados
	 */
	private static void listarPrestados() {

		List<Libro> listaLibros = dao.getAllPrestados(true);

		System.out.println("		Libros Prestados		");
		System.out.println("------------------------------------------------");

		for (Libro libro : listaLibros) {
			System.out.println(libro);
		}

		System.out.println("");
		System.out.println("");
		System.out.println("");

		pintarMenu();
	}

	/**
	 * Muestra la lista de libros no prestados
	 */
	private static void listarNoPrestados() {
		List<Libro> listaLibros = dao.getAllPrestados(false);

		System.out.println("		Libros no Prestados		");
		System.out.println("------------------------------------------------");

		for (Libro libro : listaLibros) {
			System.out.println(libro);
		}

		System.out.println("");
		System.out.println("");
		System.out.println("");

		pintarMenu();
	}

	/**
	 * Busca en la lista de libros por su titulo
	 */
	private static void buscar() {

		System.out.println("Introduce el titulo del libro a buscar: ");
		titulo = sc.nextLine();

		List<Libro> listaLibros = dao.buscarPorTitulo(titulo);

		System.out.println("Resultados de la busqueda de: " + titulo);
		System.out.println("------------------------------------------------------");

		for (Libro libro : listaLibros) {
			System.out.println(libro);
		}

		System.out.println("");
		System.out.println("");
		System.out.println("");

		if (listaLibros.size() == 0)
			System.out.println("No se encuentran libros con ese titulo.");

		pintarMenu();
	}

	/**
	 * Cierra la aplicacion
	 */
	private static void salir() {
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("AGUR VENUR, esperamos verte pronto");
	}

	/**
	 * Muestra un mensaje al usuario en caso de seleccionar una opcion no valida del
	 * menu
	 */
	private static void noOption() {
		System.out.println("Lo sentimos No existe esa opcion");
		pintarMenu();
	}

	/**
	 * Muestra por consola el menu de opciones de la app
	 */
	private static void pintarMenu() {
		System.out.println("------------------------------------");
		System.out.println("--        Casa del Libro          --");
		System.out.println("------------------------------------");
		System.out.println("-    1. Listar prestados           -");
		System.out.println("-    2. Libros no prestados			");
		System.out.println("-    3. Buscar        	           -");
		System.out.println("-                                  -");
		System.out.println("-    0 - Salir                     -");
		System.out.println("------------------------------------");
		System.out.println("");
		System.out.println("Dime una opcion por favor");

		try {

			opcionSeleccionada = sc.nextInt();

		} catch (Exception e) {
			System.out.println("OPCION NO VALIDA, por favor introduce un numero del menu");
			sc.nextLine();
		} finally {
			sc.nextLine();
		}
	}

	/**
	 * Carga manual de libros de prueba
	 * 
	 * @throws Exception Si el ISBN es nulo o < 5
	 */
	private static void cargarLibros() throws Exception {
		Libro libro;
		libro = new Libro(123, "9788416001460", "FARIÑA: HISTORIA E INDISCRECIONES DEL NARCOTRAFICO EN GALICIA",
				"LIBROS DEL K.O", true);
		dao.insert(libro);

		libro = new Libro(345, "9788467575057", "LENGUA TRIMESTRAL 2º EDUCACION PRIMARIA SAVIA ED 2015", "EDICIONES SM",
				false);
		dao.insert(libro);

		libro = new Libro(345, "9788467575071", "MATEMÁTICAS TRIMESTRAL SAVIA-15", "EDICIONES SM", false);
		dao.insert(libro);

		libro = new Libro(678, "9788461716098", "LA VOZ DE TU ALMA", "AUTOR-EDITOR", true);
		dao.insert(libro);

		libro = new Libro(901, "9788467569957",
				"LENGUA CASTELLANA 3º EDUCACION PRIMARIA TRIMESTRES SAVIA CASTELLA NO ED 2014", "EDICIONES SM", false);
		dao.insert(libro);

		libro = new Libro(234, "9781380013835", "NEW HIGH FIVE 1 PUPILS BOOK PACK", "MACMILLAN CHILDRENS BOOKS", false);
		dao.insert(libro);

		libro = new Libro(567, "9781380011718", "NEW HIGH FIVE 3 PUPILS BOOK", "MACMILLAN CHILDRENS BOOKS", false);
		dao.insert(libro);
	}

}