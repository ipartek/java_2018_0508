package com.ipartek.formacion.uf2216;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GestorDeRevistas {

	// CONSTANTES PARA EL MENÚ
	static private final int OPCION_SALIR = 0;
	static private final int OPCION_INSERTAR = 1;
	static private final int OPCION_LISTAR = 2;
	static private final int OPCION_GUARDAR = 3;

	static private final char CHAR_DIGITAL = 'D';
	static private final char CHAR_PAPEL = 'P';

	static private final char CHAR_SI = 'S';
	static private final char CHAR_NO = 'N';

	static private RevistaDAO dao; // Único objeto de la clase RevistaDAO
	private static int cont = 0; // Para simular el ID

	static Scanner sc; // Para leer por consola
	static private int opcionSeleccionada; // Guardar la opción seleccionada

	static File fichero; // Para guardar las revistas

	public static void main(String args[]) {

		try {
			System.out.println("------------------------------------");
			System.out.println("--        BIENVENIDO/A            --");

			inicializarVariables();

			do {

				pintarMenu();
				try {

					opcionSeleccionada = Integer.parseInt(sc.nextLine());

					switch (opcionSeleccionada) {
					case OPCION_INSERTAR:
						insertarRevista();
						break;

					case OPCION_LISTAR:
						listarRevistas();
						break;

					case OPCION_GUARDAR:
						guardarEnTxt();
						break;

					default:
						noOption();
						break;
					}

				} catch (InputMismatchException | NumberFormatException e) {

					System.out.println("ERROR: " + "La opción introducida debe de ser un número.");

				}

			} while (opcionSeleccionada != OPCION_SALIR);

		} catch (RevistaException e) {

			System.out.println("ERROR: " + e.getMessage());
		}
	}

	private static void noOption() {

		System.out.println("Lo sentimos, la opción seleccionada no existe.");

	}

	/**
	 * 
	 * Método para escribir las revistas de la lista en un documento txt. Si el
	 * archivo no existe, se crea, y sino se añade al final del documento.
	 * 
	 * @throws Exception, si ocurre cualquier error al escribir el fichero.
	 */
	private static void guardarEnTxt() {

		fichero = new File("Revistas.txt");

		FileWriter fw = null; // Para escribir en el fichero
		PrintWriter pw = null; // Para escribir en el buffer
		try {
			if (fichero.exists()) {
				fw = new FileWriter(fichero, true);
			} else {
				System.out.println("Creando el archivo...");
				fw = new FileWriter(fichero);
			}

			pw = new PrintWriter(fw);

			System.out.println("Volcando los datos...");
			for (Revista revIteracion : dao.getAll()) { // Para cada revista
				// Escribimos en el fichero
				pw.print(revIteracion.getTitulo() + " - " + revIteracion.getIsbn() + " - "
						+ revIteracion.getNumPaginas() + "pags." + " - ");
				if (revIteracion.isFormato()) {
					pw.print("Digital");
				} else {
					pw.print("Papel");
				}
				pw.print("\n");
			}
			fw.flush();
			System.out.println("Archivo creado con éxito.");

		} catch (Exception e) {

			System.out.println("ERROR:" + e.getMessage());

		} finally {
			try {

				if (null != fw) // Asegurarnos que se cierra el fichero.
					fw.close();

			} catch (Exception e2) { // Algo ha ido mal al cerrar FileWriter
				System.out.println("ERROR:" + e2.getMessage());
			}
		}
	}

	private static void listarRevistas() {

		if (dao.getAll().isEmpty()) { // No hay nada insertado

			System.out.println("Actualmente no hay revistas en la lista.");
		} else {
			System.out.println("------------------------------------");
			System.out.println("-------- CATÁLOGO DE REVISTAS ------");
			System.out.println("------------------------------------");
			for (Revista revista : dao.getAll()) {

				System.out.println(revista);
			}
		}

	}

	private static void insertarRevista() {

		String titulo = pedirTitulo(); // Llamamos a la función pediTitulo() y recogemos el resultado
		System.out.println("Título aceptado.");

		String isbn = pedirIsbn(); // Llamamos a la función pediIsbn() y recogemos el resultado
		System.out.println("ISBN aceptado.");

		int numPaginas = pedirNumPaginas(); // Llamamos a la función pedirNumPaginas() y recogemos el resultado
		System.out.println("Número de páginas aceptado.");

		boolean esDigital = pedirFormato(); // Llamamos a la función pedirFormato() y recogemos el resultado

		System.out.println("Formato aceptado.");

		Revista revInsertar = new Revista(++cont, titulo, isbn, numPaginas, esDigital);

		pedirConfirmacion(revInsertar);

	}

	/**
	 * Método que pide caracteres por teclado hasta que la confirmación sea
	 * correcta.
	 * 
	 * @param revInsertar, objeto de la claseRevista
	 * @throws IndexOutOfBoundsException si no se ha introducido nada
	 */
	private static void pedirConfirmacion(Revista revInsertar) {
		boolean esFinal = false;
		char op = 0;

		System.out.println("Va a insertar la Revista: ");
		System.out.println();
		System.out.println(revInsertar);
		System.out.println();
		System.out.println("¿Es correcto? Teclee '" + CHAR_SI + "' para seguir, '" + CHAR_NO + "' para cancelar");

		while (!esOpcionValida(op)) { // Pedir confirmación mientras no sea correcta la respuesta

			try { // Si la línea es vacía -> IndexOutOfBoundsException
				if (!esFinal) {
					op = sc.nextLine().charAt(0); // Tan sólo cogemos como válido el primer caracter

					op = Character.toUpperCase(op);
					if (!esOpcionValida(op) && op != ' ') { // Hemos leido un caracter desconocido

						System.out.println("Lo sentimos, la respuesta '" + op + "' no es válido");
					}

					if (op == CHAR_SI) { // Intentamos insertar
						boolean result = dao.insert(revInsertar);
						System.out.println(result ? "Revista insertada correctamente."
								: "Lo sentimos, ha ocurrido un error inesperado.");
						esFinal = true;
						System.out.println();
					}
				}

			} catch (IndexOutOfBoundsException e) {

				if (!esFinal) {
					System.out.println("ERROR: La línea no debe estar vacía.");
				}
			}

		}

	}

	private static boolean esOpcionValida(char op) {
		boolean result = false;

		if (op == CHAR_SI || op == CHAR_NO) {
			result = true;
		}
		return result;
	}

	/**
	 * Método que pide strings por teclado hasta que el título de la revista sea
	 * correcto.
	 * 
	 * @return titulo, String
	 */
	private static String pedirTitulo() throws RevistaException {

		boolean esCorrecto = false;
		String titulo = "";

		do { // Pedir el título mientras no sea correcto

			System.out.println("Por favor, introduce un título de " + Revista.MIN_LONG_TITULO + " - "
					+ Revista.MAX_LONG_TITULO + " caracteres.");

			try {
				titulo = sc.nextLine();

				if (titulo.length() < Revista.MIN_LONG_TITULO || titulo.length() > Revista.MAX_LONG_TITULO) {
					throw new RevistaException();

				} else {
					esCorrecto = true;
				}

			} catch (RevistaException e) {
				System.out.println("Lo sentimos, el título no es válido.");
			}

		} while (!esCorrecto);

		return titulo;
	}

	/**
	 * Método que pide strings por teclado hasta que el isbn de la revista sea
	 * correcto.
	 * 
	 * @return isbn, String
	 * @throws RevistaException si el ISBN introducido no es válido
	 */
	private static String pedirIsbn() throws RevistaException {

		boolean esCorrecto = false;
		String isbn = "";

		do { // Pedir el ISBN mientras no sea correcto

			System.out.println("Por favor, introduce el ISBN (de " + Revista.LONG_ISBN + " digitos).");

			try {
				isbn = sc.nextLine();

				if (isbn.length() != Revista.LONG_ISBN) {

					throw new RevistaException("ISBN incorrecto.");
				} else { // Para salir del bucle

					esCorrecto = true;
				}
			} catch (RevistaException e) {
				System.out.println("Lo sentimos, el ISBN no es válido.");
			}

		} while (!esCorrecto);
		return isbn;

	}

	/**
	 * Método que pide números por teclado hasta que el número de páginas de la
	 * revista sea correcto.
	 * 
	 * @return numPag, entero
	 * @throws NumberFormatException si lo que se ha introducido no es un número
	 *                               RevistaException si el número de páginas no es
	 *                               correcto
	 */
	private static int pedirNumPaginas() throws NumberFormatException, RevistaException {
		boolean esCorrecto = false;
		int numPag = 0;

		do { // Pedir el número de páginas mientras no sea correcto

			System.out.println("Por favor, introduce el número de páginas (>= " + Revista.MIN_NUM_PAGINAS + ").");

			try {
				numPag = Integer.parseInt(sc.nextLine());

				if (numPag < Revista.MIN_NUM_PAGINAS) {

					throw new RevistaException("Número de páginas incorrecto.");
				} else { // Para salir del bucle

					esCorrecto = true;
				}
			} catch (NumberFormatException | RevistaException e) {
				System.out.println("Lo sentimos, el número de páginas no es válido.");
			}

		} while (!esCorrecto);

		return numPag;

	}

	/**
	 * Función que pide caracteres por teclado hasta leer una D o una P, que
	 * representan los diferentes formatos posibles para la revista.
	 * 
	 * @return esDigital, booleano
	 * @throws IndexOutOfBoundsException si no se ha introducido nada
	 */
	private static boolean pedirFormato() throws IndexOutOfBoundsException {

		boolean esDigital = false;
		char c;

		do { // Pedir el formato mientras no sea correcto

			c = ' ';
			System.out.println("Por favor, introduce el formato. '" + CHAR_DIGITAL + "' para formato Digital y '"
					+ CHAR_PAPEL + "' para formato Papel.");

			try { // Si la línea es vacía -> IndexOutOfBoundsException

				c = sc.nextLine().charAt(0); // Tan sólo cogemos como válido el primer caracter
				c = Character.toUpperCase(c);
			} catch (IndexOutOfBoundsException e) {

				System.out.println("ERROR: La línea no debe estar vacía.");
			}

			if (!esFormatoValido(c) && c != ' ') { // Hemos leido un caracter desconocido

				System.out.println("Lo sentimos, el formato '" + c + "' no es válido");
			}

		} while (!esFormatoValido(c));

		if (c == CHAR_DIGITAL) { // El carácter leido (y válido) es D
			esDigital = true;
		}
		return esDigital;

	}

	/**
	 * Función que comprueba si un caracter representa el formato digital o el
	 * formato papel.
	 * 
	 * @param c, char
	 * @return true si c = 'D' || C = 'P'
	 */
	private static boolean esFormatoValido(char c) {

		boolean result = false;

		if (c == CHAR_DIGITAL || c == CHAR_PAPEL) {
			result = true;
		}

		return result;
	}

	private static void inicializarVariables() {

		dao = RevistaDAO.getInstance(); // Creamos la única instancia a la lista de Revistas
		sc = new Scanner(System.in); // Abrimos el Scanner (para leer de la consola)
		opcionSeleccionada = -1; // Ninguna opción seleccionada

	}

	private static void pintarMenu() {

		System.out.println("------------------------------------");
		System.out.println("--       GESTOR DE REVISTAS       --");
		System.out.println("------------------------------------");
		System.out.println("-    1. Insertar Revista           -");
		System.out.println("-    2. Listar Revistas            -");
		System.out.println("-    3. Guardar (.txt)	           -");
		System.out.println("-								   -");
		System.out.println("-    0. Salir                      -");
		System.out.println("------------------------------------");
		System.out.print("Por favor, selecciona una opcion: ");
	}

}
