package com.ipartek.formacion.libros;

import java.util.ArrayList;
import java.util.Scanner;

import com.ipartek.formacion.model.LibroArrayDAO;
import com.ipartek.formacion.pojo.Libro;

public class Biblioteca {

	static LibroArrayDAO dao;

	static private final int OPCION_MINIMA = 0;
	static private final int OPCION_MAXIMA = 4;
	static private final int OPCION_SALIR = 0;
	static private final int OPCION_LISTAR_PRESTADOS = 1;
	static private final int OPCION_LISTAR_NO_PRESTADOS = 2;
	static private final int OPCION_LISTAR_TODOS = 3;
	static private final int OPCION_BUSCAR = 4;
	static private final int VALOR_CHIVATO = -1;
	static private int ULTIMO_ID = 1;

	private static Scanner sc = null;

	public static void main(String[] args) {

		try {

			sc = new Scanner(System.in);

			dao = LibroArrayDAO.getInstance();

			cargarLibros();

			ULTIMO_ID = dao.getAll().size() + 1;

			int opc = VALOR_CHIVATO;

			while (opc != OPCION_SALIR) {

				opc = opcion();
				switch (opc) {

				case OPCION_LISTAR_PRESTADOS:
					listarPrestados(true);
					break;

				case OPCION_LISTAR_NO_PRESTADOS:
					listarPrestados(false);
					break;

				case OPCION_LISTAR_TODOS:
					listarLibros();
					break;

				case OPCION_BUSCAR:
					buscador();
					break;

				case OPCION_SALIR:
					System.out.println("Adios!!!! Vuelva pronto.");
					break;
				default:

					break;
				}

			}
		} catch (Exception e) {

			System.out.println("Disculpen las molestias pero hemos tenido un problema tecnico.");

		} finally {

			if (sc != null) {
				sc.close();
			}
			dao = null;
		}

	}

	private static void cargarLibros() throws Exception {

		dao.insert(new Libro(ULTIMO_ID, "FARIÑA: HISTORIA E INDISCRECIONES DEL NARCOTRAFICO EN GALICIA",
				"9788416001460", "LIBROS DEL K.O", true));
		ULTIMO_ID++;
		dao.insert(new Libro(ULTIMO_ID, "LENGUA TRIMESTRAL 2º EDUCACION PRIMARIA SAVIA ED", "9788467575057",
				"EDICIONES SM", false));
		ULTIMO_ID++;
		dao.insert(new Libro(ULTIMO_ID, "MATEMÁTICAS TRIMESTRAL SAVIA-15", "9788467575071", "EDICIONES SM", false));
		ULTIMO_ID++;
		dao.insert(new Libro(ULTIMO_ID, "LA VOZ DE TU ALMA", "9788461716098", "AUTOR-EDITOR", true));
		ULTIMO_ID++;
		dao.insert(new Libro(ULTIMO_ID, "LENGUA CASTELLANA 3º EDUCACION PRIMARIA TRIMESTRES SAVIA CASTELLA NO ED 2014 ",
				"9788467569957", "EDICIONES SM", false));
		ULTIMO_ID++;
		dao.insert(new Libro(ULTIMO_ID, "NEW HIGH FIVE 1 PUPILS BOOK PACK", "9781380013835",
				"MACMILLAN CHILDRENS BOOKS", false));
		ULTIMO_ID++;
		dao.insert(new Libro(ULTIMO_ID, "NEW HIGH FIVE 3 PUPILS BOOK", "9781380011718", "MACMILLAN CHILDRENS BOOKS",
				false));
		ULTIMO_ID++;

	}

	private static void pintarMenu() {

		System.out.println("**************************************************");
		System.out.println("----------------Biblioteca Ipartek----------------");
		System.out.println("**************************************************");
		System.out.println("-------------1. Listar Libros Prestados-----------");
		System.out.println("**************************************************");
		System.out.println("-------------2. Listar Libros Libres--------------");
		System.out.println("**************************************************");
		System.out.println("-------------3. Listar todos----------------------");
		System.out.println("**************************************************");
		System.out.println("-------------4. Buscador--------------------------");
		System.out.println("**************************************************");
		System.out.println("**************************************************");
		System.out.println("**************************************************");
		System.out.println("----------------0. Salir -------------------------");
		System.out.println("**************************************************");

	}

	private static int opcion() {

		pintarMenu();

		int opc = VALOR_CHIVATO;
		try {
			do {

				System.out.println("Elige una opcion:");
				opc = sc.nextInt();
				sc.nextLine();

				if (opc > OPCION_MAXIMA || opc < OPCION_MINIMA) {
					System.out.println("No existe la opcion, vuelve a probar.");
				}

			} while (opc > OPCION_MAXIMA || opc < OPCION_MINIMA);

		} catch (Exception e) {
			System.out.println("OPCION NO VALIDA, introduce numeros por favor.");
			sc.nextLine();
		}
		return opc;
	}

	private static void listarLibros() {

		if (dao.getAll().size() == 0) {
			System.out.println("No hay ningun libro :( \n Empieza a añadir.");
		} else {
			System.out.println(dao.getAll());
		}

	}

	private static void listarPrestados(boolean prestamo) {

		ArrayList<Libro> l = dao.listarLibrosPrestados(prestamo);

		if (l.size() != 0) {
			System.out.println(l);
		} else {
			System.out.println((prestamo) ? "No hay libro prestados." : "No hay libros sin prestar.");
		}

	}

	private static void buscador() {

		String busqueda;

		System.out.println("Introduce lo que quieres buscar:");
		busqueda = sc.nextLine();

		ArrayList<Libro> l = dao.getByTitulo(busqueda);

		if (l.size() != 0) {
			System.out.println(l);
		} else {
			System.out.println("No hay libros que coincidan con la busqueda.");
		}
	}
}
