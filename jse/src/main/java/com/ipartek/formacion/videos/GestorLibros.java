package com.ipartek.formacion.videos;

import java.util.*;

import com.ipartek.formacion.model.LibroArrayDAO;
import com.ipartek.formacion.pojo.Libro;

public class GestorLibros {

	static private LibroArrayDAO dao;
	static private Scanner sc = null;
	static private int opcionSeleccionada = 0;

	static private final int OPCION_SALIR = 0;
	static private final int OPCION_LISTAR_PRESTADO = 1;
	static private final int OPCION_LISTAR_NO_PRESTADO = 2;
	static private final int OPCION_BUSCAR = 3;

	public static void main(String[] args) {

		try {
			sc = new Scanner(System.in);
			CargarLibros();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		do {

			pintarMenu();

			switch (opcionSeleccionada) {
			case OPCION_LISTAR_PRESTADO:
				for (Libro libro : dao.getAllPrestados(true)) {
					System.out.println("    " + libro.toString());
				}
				break;

			case OPCION_LISTAR_NO_PRESTADO:
				for (Libro libro : dao.getAllPrestados(false)) {
					System.out.println("    " + libro.toString());
				}
				break;

			case OPCION_BUSCAR:
				//dao.buscarPorTitulo(busqueda;)
				break;

			default:
				noOption();
				break;
			}

		} while (opcionSeleccionada != OPCION_SALIR);

		sc.close();

	}

	private static void noOption() {
		System.out.println("Lo sentimos No existe esa opcion");

	}

	public static void CargarLibros() throws Exception {

		dao = LibroArrayDAO.getInstance();

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

	private static void listar() {

		for (Libro libro : dao.getAll()) {
			System.out.println("    " + libro.toString());
		}

		System.out.println("");
		System.out.println("");
		System.out.println("");

	}

	private static void pintarMenu() {

		System.out.println("------------------------------------");
		System.out.println("--       Gestor de Libros         --");
		System.out.println("------------------------------------");
		System.out.println("--    1. Listar prestados         --");
		System.out.println("--    2. Listar no prestados      --");
		System.out.println("--    3. Buscar por titulo        --");
		System.out.println("--                                --");
		System.out.println("--    0 - salir                   --");
		System.out.println("------------------------------------");
		System.out.println("");
		System.out.println("Dime una opcion por favor");

		try {
			opcionSeleccionada = sc.nextInt();
		} catch (Exception e) {
			// e.printStackTrace(); pinta la pila de excepciones
			sc.nextLine();
			System.out.println("OPCION NO VALIDA. Por favor introduce un numero del menu");
			pintarMenu();
		}

	}

}
