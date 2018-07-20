package com.ipartek.formacion.uf2216;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class GestorRevistas {

//Constantes para el menu
	static private final int OPCION_SALIR = 0;
	static private final int OPCION_LISTAR_REVISTAS = 1;
	static private final int ANADIR_REVISTA = 2;
	static private final int OPCION_ESCRIBIR_FICHERO = 3;

	// Constantes para controlar las revistas

	static private final int MIN_TITULO = 3;
	static private final int MAX_TITULO = 150;
	static private final int LONG_ISBN = 10;
	static private final int MIN_PAGINAS = 1;
	static private final int FORMATO_DIGITAL = 1;
	static private final int FORMATO_PAPEL = 2;

	// rUTA DEL Fichero en el que se escribiran los registros.
	static private final String FILEPATH = "C:\\Desarrollo\\eclipseWorkspace\\java_2018_0508\\src\\com\\ipartek\\formacion\\uf2216\\Listado_Revistas.txt";

	// Atributos y variables

	static private RevistaDAO dao;
	static private int opcionSeleccionada = 0;
	static Scanner sc = null;

	static long id;
	static String titulo;
	static String isbn;
	static int numPag;
	static boolean formato;
	static int cont;// Controlamos el id de las revistas que se quieran añadir

	public static void main(String[] args) {

		sc = new Scanner(System.in);

		dao = RevistaDAO.getInstance();

		try {
			cargarRevistas();
		} catch (Exception e) {
			e.printStackTrace();
		}

		pintarMenu();

		do {
			switch (opcionSeleccionada) {
			case OPCION_LISTAR_REVISTAS:
				listarRevistas();
				pintarMenu();
				break;

			case ANADIR_REVISTA:
				anadir();
				break;

			case OPCION_ESCRIBIR_FICHERO:
				escribibrFichero(dao.getAll());
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
	 * Carga de revistas de prueba.
	 */
	private static void cargarRevistas() throws Exception {
		Revista revista;
		revista = new Revista("Quo", "1234567890", 40, false);
		dao.insert(revista);

		revista = new Revista("Año Cero", "1634517936", 30, false);
		dao.insert(revista);

		revista = new Revista("Hobby consolas", "2938456701", 50, true);
		dao.insert(revista);
		cont = dao.getAll().size();
	}

	/**
	 * Muestra por consola el menu de opciones de la app
	 */
	private static void pintarMenu() {
		System.out.println("------------------------------------");
		System.out.println("--           Kiosko                --");
		System.out.println("------------------------------------");
		System.out.println("-    1. Listar Revistas            -");
		System.out.println("-    2. Añadir Revista   			");
		System.out.println("-    3. Escribir en archivo			");
		System.out.println("-    0 - Salir                     -");
		System.out.println("------------------------------------");
		System.out.println("");
		System.out.println("Dime una opcion por favor");

		try {

			opcionSeleccionada = sc.nextInt();

		} catch (Exception e) {
			System.out.println("OPCION NO VALIDA, por favor introduce un numero entre 0 y 3");
			sc.nextLine();
		} finally {
			sc.nextLine();
		}
	}

	private static void listarRevistas() {
		if (dao.getAll().isEmpty()) {
			System.out.println("La lista esta vacia, no hay revistas que mostrar");
		} else {
			for (Revista rev : dao.getAll()) {
				System.out.println(rev.toString());
			}
		}
	}

	private static void anadir() {
		String continuar = "";

		do {

			titulo = "";
			isbn = "0000000000";
			numPag = 0;
			formato = false;

			do {
				System.out.println(
						"Introduce el título de la revista que deseas añadir(3 caracteres como minimo y 150 como máximo):");
				titulo = sc.nextLine();
			} while (titulo.length() > MAX_TITULO || titulo.length() < MIN_TITULO);

			do {
				System.out.println("Introduce el ISBN de la revista que deseas añadir(10 caracteres):");
				isbn = sc.nextLine();
			} while (isbn.length() != LONG_ISBN);

			do {
				System.out.println("Introduce el número de página de la revista que deseas añadir(1 como minimo):");
				try {
					numPag = sc.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("Lo sentimos debes introducir un numero.");
				}
			} while (numPag == MIN_PAGINAS);

			do {
				System.out.println("Introduce el número del formato de la revista que deseas añadir");
				System.out.println("1.Digital");
				System.out.println("2.Papel");
				opcionSeleccionada = sc.nextInt();

			} while (opcionSeleccionada != FORMATO_PAPEL && opcionSeleccionada != FORMATO_DIGITAL);
			if (opcionSeleccionada == 1) {
				formato = true;
			}
			do {
				System.out.println("¿Desea guardar la revista introducida? (s/n)");
				continuar = sc.nextLine();

				if (continuar.startsWith("s")) {
					Revista revista = new Revista(titulo, isbn, numPag, formato);
					if (dao.insert(revista)) {
						cont++;
						System.out.println("La revista ha sido añadida");
						System.out.println(revista.toString());
					} else {
						System.out.println("Lo sentimos pero ha ocurrido un error, vuelva a intentarlo por favor.");
					}
				}
			} while (continuar != 'n' || continuar != 'N');

			System.out.println("¿Deseas añadir otra revista?(s/n)");
			try {
				continuar = (char) System.in.read();
			} catch (IOException e) {
				System.out.println("Lo sentimos ha ocurrido un error");
			}

		} while (continuar != 'n' && continuar != 'N');
		pintarMenu();
	}

	private static void escribibrFichero(List<Revista> listaRevistas) {
		File f = new File(FILEPATH);
		String linea = "";
		if (f.exists()) {
			System.out.println("Existe el fichero");

			try {
				FileWriter fw = new FileWriter(f);

				try {
					for (Revista revista : listaRevistas) {
						linea = revista.toString();
						fw.write(linea + "\n");
					}

				} finally {

					fw.close();
					System.out.println("Las revistas se han introducido en el fichero.");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {
			try {
				f.createNewFile();
				System.out.println("Creamos el fichero");
				escribibrFichero(listaRevistas);
			} catch (IOException e) {
				System.out.println("Error al crear fichero");
				e.printStackTrace();
			}
		}
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
		System.out.println("Hasta la proxima, esperamos verte pronto");
	}

	/**
	 * Muestra un mensaje al usuario si este no introduce una opcion correctaen el
	 * menu.
	 */
	private static void noOption() {
		System.out.println("Lo sentimos No existe esa opcion, por favor seleccione una opcion valida.");
		pintarMenu();
	}

}
