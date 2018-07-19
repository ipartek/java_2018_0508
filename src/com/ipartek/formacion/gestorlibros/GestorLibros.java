package com.ipartek.formacion.gestorlibros;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.model.LibroDao;
import com.ipartek.formacion.pojo.Libro;

/**
 * 
 * @author Curso Gestion de prestamos de libros
 */
public class GestorLibros {

	static Libro libro;
	static LibroDao libroDao;

	public static void main(String[] args) {

		libroDao = LibroDao.getInstance();

		cargarLibros();
		pintarMenu();

	}

	public static LibroDao cargarLibros() {
		Libro libro1 = new Libro(1, "9788416001460", "FARIÑA: HISTORIA E INDISCRECIONES DEL NARCOTRAFICO EN GALICIA",
				"LIBROS DEL K.O", true);
		Libro libro2 = new Libro(2, "9788467575057", "LENGUA TRIMESTRAL 2º EDUCACION PRIMARIA SAVIA ED 2015 ",
				"EDICIONES SM", false);
		Libro libro3 = new Libro(3, "9788467575071", "MATEMÁTICAS TRIMESTRAL SAVIA-15", " EDICIONES SM", false);
		Libro libro4 = new Libro(4, "9788461716098", "LA VOZ DE TU ALMA", "AUTOR-EDITOR", true);
		Libro libro5 = new Libro(5, "9788467569957",
				"LENGUA CASTELLANA 3º EDUCACION PRIMARIA TRIMESTRES SAVIA CASTELLA NO ED 2014 ", "EDICIONES SM", false);
		Libro libro6 = new Libro(6, "9781380011718", "NEW HIGH FIVE 1 PUPILS BOOK PACK ", "MACMILLAN CHILDRENS BOOKS",
				false);
		Libro libro7 = new Libro(7, "9781380011718", "NEW HIGH FIVE 3 PUPILS BOOK ", "MACMILLAN CHILDRENS BOOKS",
				false);
		libroDao.insert(libro1);
		libroDao.insert(libro2);
		libroDao.insert(libro3);
		libroDao.insert(libro4);
		libroDao.insert(libro5);
		libroDao.insert(libro6);
		libroDao.insert(libro7);
		return libroDao;
	}

	private static void pintarMenu() {
		int opcion;

		System.out.println("-----------------------------");
		System.out.println("-----Registro de libros------");
		System.out.println("-----Opciones----------------");
		System.out.println("-----1: Añadir---------------");
		System.out.println("-----2: Listar prestados-----");
		System.out.println("-----3: Listar no prestados--");
		System.out.println("-----4: Listar por titulos---");
		System.out.println("-----5: Salir ---------------");
		System.out.println("-----Seleccione una opcion---");

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			opcion = Integer.parseInt(br.readLine());
			opcionesMenu(opcion);
		} catch (Exception e) {
			System.out.println("Opcion incorrecta!! Pulse un numero del 1 al 6 para");
			pintarMenu();
		}

	}

	private static void opcionesMenu(int opcion) throws Exception {
		// constantes
		final int ANADIR = 1;
		final int LISTAR_PRESTADOS = 2;
		final int LISTAR_NO_PRESTADOS = 3;
		final int LISTAR_POR_TITULO = 4;
		final int SALIR = 5;
		final int PRINCIPAL = 0;
		switch (opcion) {
		case (ANADIR):
			anadirLibro();
			break;
		case (LISTAR_PRESTADOS):
			listarPrestados();
			break;
		case (LISTAR_NO_PRESTADOS):
			listarNoPrestados();
			break;
		case (LISTAR_POR_TITULO):
			listarPorTitulo();
			break;
		case (PRINCIPAL):
			listarPorTitulo();
			break;

		case (SALIR):
			salir();
			break;

		default:
			eleccionUsuario();
			break;
		}
	}

	private static void salir() {
		System.out.println("Gracias por su consulta");
		System.exit(0);

	}

	private static void listarPorTitulo() throws Exception {
		String aBuscar = "";
		do {

			try {
				System.out.println("Introduzca el nombre del titulo");
				List<Libro> libroTemporal = libroDao.getAll();

				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				aBuscar = br.readLine();
				aBuscar = aBuscar.trim();
				//printeo del resultado
				libroTemporal =libroDao.listarTodosTitulo(aBuscar);
				for(Libro libroN : libroTemporal) {
					System.out.println(libroN.toString());
				}
			} catch (Exception e) {
				System.out.println("Se ha producido un error, vuelva a introducir un titulo");
				listarPorTitulo();
			}
		} while (aBuscar != null && aBuscar.isEmpty());
		eleccionUsuario();

	}

	private static void listarNoPrestados() {
		
		List<Libro> resul = libroDao.listarNoPrestados(false);
		//printeo del resultado
		for (Libro libroN : resul) {
			System.out.println(libroN.toString());
		}
		eleccionUsuario();

	}

	private static void listarPrestados() {
		
		List<Libro> resul = libroDao.listarNoPrestados(true);
		//printeo del resultado
		for (Libro libroN : resul) {
			System.out.println(libroN.toString());
		}
		eleccionUsuario();

	}

	private static void eleccionUsuario() {
		
		int opcion = 0;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("");
			System.out.println(
					"¿ Que desea hacer ahora ? Pulsa 1 para añadir un libro. Pulsa 2 para Listar los prestados  ");
			System.out.println(
					" Pulsa 3 para listar los no prestados. Pulsa 4 para buscar por titulo. Pulsa 5 para salir . Pulsa 0 para volver al menu principal ");
			opcion = Integer.parseInt(br.readLine());
			if (opcion < 7 ) {
				opcionesMenu(opcion);
			}else {
				System.out.println("Se produjo un error al tratar su respuesta,introduzca opcion numerica del 0 al 6");
				eleccionUsuario();
			}
			
		} catch (Exception e) {
			System.out.println("Se produjo un error al tratar su respuesta,introduzca opcion numerica del 0 al 6");
			eleccionUsuario();
		}

	}

	private static void anadirLibro() {

		/**
		 * Necesitamos los siguientes datos menos el id que lo autogeneraremos long
		 * id,<br>
		 * <br>
		 */

		String isbn;
		String titulo;
		String editorial;
		boolean prestado;
		long id;

		try {
			try {

				isbn = preguntarIsbn();

			} catch (Exception e) {
				isbn = preguntarIsbn();
			}
			try {
				titulo = preguntarTitulo();
			} catch (Exception e) {
				titulo = preguntarTitulo();
			}
			try {
				editorial = preguntarEditorial();
			} catch (Exception e) {
				editorial = preguntarEditorial();
			}
			id = calculeId();
			libro = new Libro(id, isbn, titulo, editorial, false);
			libroDao.insert(libro);
			System.out.println("Libro dado de alta satisfactoriamente");
			eleccionUsuario();
		} catch (Exception e) {
			System.out.println("Se ha producido un error, lamentablemente tendre que comenzar de nuevo");
			anadirLibro();
		}

	}

	private static String preguntarEditorial() {
		String editorial = "";

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("Introduce la editorial");
			editorial = br.readLine();
		} catch (Exception e) {
			preguntarIsbn();
		}
		return editorial;
	}

	private static String preguntarTitulo() {
		String titulo = "";

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("Introduce titulo del libro");
			titulo = br.readLine();
		} catch (Exception e) {
			preguntarIsbn();
		}
		return titulo;
	}

	private static String preguntarIsbn() {
		String isbn = "";

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("Introduce un codigo isbn del libro de 11 caracteres :");
			isbn = br.readLine();
			if (isbn.length() == 11) {
				
			}else {
				System.out.println("Codigo isbn incorrecto, introduza un codigo isbn de 11 caracteres:");
				preguntarIsbn();
			}
		} catch (Exception e) {
			preguntarIsbn();
		}
		return isbn;

	}

	private static long calculeId() {
		long id;
		id = libroDao.getAll().size() + 1;
		return id;
	}
}
