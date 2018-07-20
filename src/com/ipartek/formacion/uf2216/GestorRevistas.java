package com.ipartek.formacion.uf2216;

import java.util.Scanner;

public class GestorRevistas {

	static RevistaArrayDAO dao;

	static private final int OPCION_MINIMA = 0;
	static private final int OPCION_MAXIMA = 3;
	static private final int VALOR_CHIVATO = -1;
	static private final int OPCION_SALIR = 0;
	static private final int OPCION_LISTAR = 1;
	static private final int OPCION_ANADIR = 2;

	private static Scanner sc = null;

	public static void main(String[] args) {

		try {

			sc = new Scanner(System.in);

			dao = RevistaArrayDAO.getInstance();

			cargarRevistas();

			int opc = VALOR_CHIVATO;

			while (opc != OPCION_SALIR) {

				opc = opcion();

				switch (opc) {

				case OPCION_LISTAR:
					listarRevistas();
					break;

				case OPCION_ANADIR:
					anadirRevista();
					break;

				case OPCION_SALIR:
					System.out.println("Agur !! Vuelva pronto !! :D");
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

	private static void cargarRevistas() {

		dao.insert(new Revista("Muy Interesante", "1234567890", 120, Revista.DIGITAL));
		dao.insert(new Revista("Muy Historia", "1237894560", 120, Revista.PAPEL));
		dao.insert(new Revista("Muy Interesante", "1234567890", 120, Revista.PAPEL));
		dao.insert(new Revista("Hobby Consolas", "1234869570", 140, Revista.PAPEL));
		dao.insert(new Revista("Metal Hammer Magazine", "123456789", 120, Revista.DIGITAL));

	}

	private static void pintarMenu() {

		System.out.println(" ---EL Kiosko de Ipartek--- ");
		System.out.println("----------------------------");
		System.out.println(" ---1. Ver Revistas");
		System.out.println(" ---2. Añadir revista");
		System.out.println(" ---3. Guardar en TXT");
		System.out.println("****************************");
		System.out.println("----------------------------");
		System.out.println(" ---0.Salir");

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

	private static void listarRevistas() {

		if (dao.getAll().size() != 0) {
			System.out.println(dao.getAll());
		} else {
			System.out.println("Disculpe pero no tenemos ninguna revista ahora mismo.");
		}

	}

	private static void anadirRevista() {

		Revista r = null;

		// Toma y comprobacion del titulo
		String titulo = "";

		while (titulo == "") {
			System.out.println("Introduce el titulo de la revista:");
			titulo = sc.nextLine();
			titulo = comprobarTitulo(titulo);
		}

		// Toma y comprobacion del isbn
		String isbn = "";

		while (isbn == "") {
			System.out.println("Introduce el isbn de la revista:");
			isbn = sc.nextLine();
			isbn = comprobarIsbn(isbn);
		}

		// Toma y comprobacion de las paginas
		int paginas = VALOR_CHIVATO;

		while (paginas == VALOR_CHIVATO) {

			do {

				try {
					System.out.println("Introduzca el numero de paginas:");
					paginas = sc.nextInt();
				} catch (Exception e) {
					System.out.println("Uppsss, Tienes que meter un numero, sin letras.");
					paginas = VALOR_CHIVATO;
					sc.nextLine();
				}

			} while (paginas == VALOR_CHIVATO);

			paginas = comprobarPaginas(paginas);

		}

		sc.nextLine();

		// Toma y comprobacion del formato
		char c = ' ';
		while (c == ' ') {
			System.out.println("Elija el formato: (P)apel\t(D)igital");
			c = sc.nextLine().trim().toLowerCase().charAt(0);

			if (c != 'p' && c != 'd') {
				System.out.println("DISCULPE, Introduzca P o D para elegir el formato.");
				c = ' ';
			}
		}

		boolean formato = (c == 'p') ? Revista.PAPEL : Revista.DIGITAL;

		r = new Revista(titulo, isbn, paginas, formato);

		comprobarRevista(r);

	}

	/**
	 * Metodo que recibe un titulo y comprueba que este entre los valores de tamaño
	 * maximo y minimo
	 * 
	 * @param titulo String introducido por el usuario
	 * @return retorna cadena vacia si no cumple el tamaño fijado
	 */
	private static String comprobarTitulo(String titulo) {
		if (titulo.trim().length() >= Revista.MAX_TITULO || titulo.trim().length() <= Revista.MIN_TITULO) {
			System.out.println("DISCULPE, El nombre del titulo tiene que estar entre " + Revista.MIN_TITULO + " y "
					+ Revista.MAX_TITULO + " caracteres.");
			titulo = "";
		}
		return titulo;
	}

	/**
	 * Metodo que recibe un isbn y comprueba que su longitud sea la correcta
	 * 
	 * @param isbn String introducido por el usuario
	 * @return retorna cadena vacia si no cumple el tamaño fijado
	 */
	private static String comprobarIsbn(String isbn) {

		if (isbn.trim().length() != Revista.ISBN_TAMANO) {
			System.out.println("DISCULPE, El ISBN tiene que tener 10 digitos.");
			isbn = "";
		}
		return isbn;

	}

	private static int comprobarPaginas(int paginas) {

		if (paginas < Revista.MIN_PAG) {
			System.out.println("DISCULPE, La revista tiene que tener al menos una pagina.");
			paginas = VALOR_CHIVATO;
		}
		return paginas;
	}

	private static void comprobarRevista(Revista r) {

		char c = ' ';

		System.out.println("Estos son los datos de la revista:");
		System.out.println(r);
		while (c == ' ') {
			System.out.println("Esta de acuerdo: (S)i\t(N)o");
			c = sc.nextLine().trim().toLowerCase().charAt(0);

			if (c != 's' && c != 'n') {
				System.out.println("DISCULPE, Introduzca S o N para aceptar la revista.");
				c = ' ';
			}
		}

		if (c == 's') {
			dao.insert(r);
			System.out.println("Revista añadida al Kiosko.");
		}

	}
}
