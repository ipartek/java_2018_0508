package com.ipartek.formacion.uf2216;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.Scanner;

public class GestorRevistas {

	static private RevistaDAO dao;
	static private int opcionSeleccionada = 0;
	static Scanner sc = null;
	private static int COUNTER_ID = 0;

	static private final int OPCION_ANADIR = 1;
	static private final int OPCION_LISTAR = 2;
	static private final int OPCION_FICHERO = 3;
	static private final int OPCION_SALIR = 0;

	static private final char DIGITAL = 'D';
	static private final char PAPEL = 'P';
	static private final char CONFIRMACION = 'S';

	public static void main(String[] args) {

		try {
			sc = new Scanner(System.in);
			do {
				menu();
			} while (opcionSeleccionada != OPCION_SALIR);

		} catch (Exception e) {
			System.out.println(
					"ERROR estamos teniendo problemas tecnicos. Por favor contacte con el servicio técnico para más información y disculpe las molestias.");
		} finally {
			sc.close();
		}

	}

	private static void printMenu() {

		System.out.println("--------------------------------------------");
		System.out.println("--                KIOSKO                  --");
		System.out.println("--------------------------------------------");
		System.out.println("-    1. Añadir revista                     -");
		System.out.println("-    2. Listar revistas                    -");
		System.out.println("-    3. Guardar en un fichero las revistas -");
		System.out.println("-                                          -");
		System.out.println("-    0 - Salir                             -");
		System.out.println("--------------------------------------------");
		System.out.println("");
		System.out.print("Dime una opcion por favor: ");

	}

	private static void menu() {

		printMenu();

		try {
			opcionSeleccionada = sc.nextInt();

			switch (opcionSeleccionada) {
			case OPCION_ANADIR:
				addRevista();
				break;

			case OPCION_LISTAR:
				listarRevistas();
				break;

			case OPCION_FICHERO:
				cargarFichero();
				break;

			case OPCION_SALIR:
				salir();
				break;

			default:
				throw new Exception("ERROR la opcion seleccionada no es correcta.");
			}

		} catch (Exception e) {
			System.out.println("ERROR la opcion seleccionada no es correcta.");
			// sc.nextLine();
			menu();

		}

	}

	private static void salir() {
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("¡HASTA PRONTO!");

	}

	private static void cargarFichero() {
		// TODO Auto-generated method stub

	}

	private static void listarRevistas() {

		List<Revista> lista = dao.getAll();
		if (lista != null) {
			for (Revista revista : lista) {
				System.out.println("ID         : " + revista.getId());
				System.out.println("TITULO     : " + revista.getTitulo());
				System.out.println("ISBN       : " + revista.getIsbn());
				System.out.println("Nº PAGINAS : " + revista.getNumeroPaginas());
				System.out.println("FORMATO    : " + ((revista.isFormato()) ? "Digital" : "Papel"));
				System.out.println();
			}
		} else {
			System.out.println("No hay revistas");

		}

	}

	private static void addRevista() {

		try {

			String titulo = "";
			String isbn = "";
			int numeroPaginas = 0;
			boolean formato = false; // true == digital false == papel
			boolean correcto = false;

			System.out.println("------- Nueva revista -------");
			do {

				System.out.print("Introduce titulo de la revista ( entre" + Revista.TITULO_MIN_SIZE + " y "
						+ Revista.TITULO_MAX_SIZE + " caracteres): ");
				titulo = sc.nextLine();
				if (titulo.length() < Revista.TITULO_MIN_SIZE || titulo.length() > Revista.TITULO_MAX_SIZE
						|| titulo == null) {
					System.out.println("ERROR al introducir el titulo.");

				} else {
					correcto = true;
				}

			} while (!correcto);

			correcto = false;
			do {
				System.out.print("Introduce ISBN de la revista ( entre" + Revista.TITULO_MIN_SIZE + " y "
						+ Revista.TITULO_MAX_SIZE + " caracteres): ");
				titulo = sc.nextLine();
				if (isbn.length() != Revista.ISBN_SIZE || isbn == null) {
					System.out.println("ERROR al introducir el ISBN.");
				} else {
					correcto = true;
				}

			} while (!correcto);

			correcto = false;
			do {
				System.out.print("Introduce el numero de páginas de la revista ( minimo " + Revista.NUMEROPAGINAS_MIN
						+ " páginas): ");
				titulo = sc.nextLine();
				if (numeroPaginas < Revista.NUMEROPAGINAS_MIN) {
					System.out.println("ERROR al introducir el numero de páginas.");
				} else {
					correcto = true;
				}

			} while (!correcto);

			correcto = false;
			do {
				System.out.print("Introduce el formato de la revista, digital(D) o papel(P): ");
				char formatoRevista = sc.nextLine().charAt(0);

				switch (Character.toUpperCase(formatoRevista)) {
				case DIGITAL:
					formato = true;
					correcto = true;
					break;
				case PAPEL:
					formato = false;
					correcto = true;
					break;

				default:
					System.out.println("ERROR al introducir el formato.");
					break;
				}

			} while (!correcto);

			resumenDatosRevista(titulo, isbn, numeroPaginas, formato);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			addRevista();

		}

	}

	private static void resumenDatosRevista(String titulo, String isbn, int numeroPaginas, boolean formato) {

		System.out.println("---------Resumen de la nueva revista--------");
		System.out.println();
		System.out.println("TITULO     : " + titulo);
		System.out.println("ISBN       : " + isbn);
		System.out.println("Nº PAGINAS : " + numeroPaginas);
		System.out.println("FORMATO    : " + ((formato) ? "Digital" : "Papel"));
		System.out.println();
		System.out.print(" ¿Seguro que quiere guardar los cambios? (S/N) ");
		char respuesta = sc.nextLine().charAt(0);

		if (Character.toUpperCase(respuesta) == CONFIRMACION) {
			insertarRevista(titulo, isbn, numeroPaginas, formato);
		} else {
			System.out.println("La revista ha sido borrada");
			System.out.println();
		}

	}

	private static void insertarRevista(String titulo, String isbn, int numeroPaginas, boolean formato) {

		Revista nuevaRevista;
		try {
			nuevaRevista = new Revista(++COUNTER_ID, titulo, isbn, numeroPaginas, formato);
			dao.insert(nuevaRevista);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			addRevista();

		}

	}

}
