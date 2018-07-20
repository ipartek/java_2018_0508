package com.ipartek.formacion.uf2216;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GestionRevista {

	private static int cont = 0;

	static private RevistaArrayDAO dao;
	static private int opcionSeleccionada = 0;
	static Scanner sc = null;

	static private final int OPCION_SALIR = 0;
	static private final int OPCION_LISTAR = 1;
	static private final int OPCION_ANADIR = 2;

	static private final int LONGITUD_MINIMA_TITULO = 3;
	static private final int LONGITUD_MAXIMA_TITULO = 150;

	static private final int LONGITUD_ISBN = 10;

	static private final int NUM_PAGINAS = 1;

	static private char contest;
	static private char formato;

	static ArrayList<Revista> videos = new ArrayList<Revista>();

	public static void main(String[] args) throws IOException {

		sc = new Scanner(System.in);

		dao = RevistaArrayDAO.getInstance();
		try {
			cargarRevista();

			pintarMenu();

			do {
				switch (opcionSeleccionada) {

				case OPCION_LISTAR:
					listar();
					break;

				case OPCION_SALIR:
					salir();
					break;

				case OPCION_ANADIR:
					anadir();
					break;

				default:
					noOption();
					break;
				}

			} while (opcionSeleccionada != OPCION_SALIR);
		} catch (Exception e) {
			System.out.println("Ha sucedido un error que intentaremos arreglar cuanto antes.\n");
			System.out.println("Disculpen las molestias.");
		}

	}

	private static void salir() throws IOException {
		System.out.println("Vuelve pronto.");
		sc.close();
	}

	private static void noOption() {
		System.out.println("Lo sentimos. No existe esa opcion");
		pintarMenu();

	}

	private static void listar() {
		System.out.println("------------------------------------");
		System.out.println("--         LISTAR REVISTAS        --");
		System.out.println("------------------------------------\n");

		for (Revista revista : dao.getAll()) {
			System.out.println("    " + revista);
		}

		System.out.println("");
		System.out.println("");
		System.out.println("");

		pintarMenu();

	}

	private static void anadir() throws Exception {
		System.out.println("------------------------------------");
		System.out.println("--         AÑADIR REVISTAS        --");
		System.out.println("------------------------------------\n");
		Revista revista = new Revista();

		revista.setId(dao.getAll().size() + 1);

		do {

			do {
				System.out.print("Inserte título que sea entre 3 y 150 caracteres: ");
				revista.setTitulo(sc.next());
				if (revista.getTitulo().length() < LONGITUD_MINIMA_TITULO) {
					System.out.println("La longitud del título es corta. Como mínimo debe tener 3 caracteres.");

				} else if (revista.getTitulo().length() > LONGITUD_MAXIMA_TITULO) {
					System.out.println(
							"La longitud del título es demasiado largo. Como máximo debe tener 244 caracteres.");

				}
			} while (revista.getTitulo().length() < LONGITUD_MINIMA_TITULO
					|| revista.getTitulo().length() > LONGITUD_MAXIMA_TITULO);

			do {
				System.out.print("Inserte ISBN que sea de 10 caracteres: ");
				revista.setIsbn(sc.next());
				if (revista.getIsbn().length() < LONGITUD_ISBN || revista.getIsbn().length() > LONGITUD_ISBN) {
					System.out.println("La longitud del ISBN es corta. Tiene que tener 10 caracteres");

				}
			} while (revista.getIsbn().length() < LONGITUD_ISBN || revista.getIsbn().length() > LONGITUD_ISBN);

			do {
				System.out.print("Inserte un número de páginas mayor o igual que 1: ");
				revista.setPaginas(sc.nextInt());
				if (revista.getPaginas() < NUM_PAGINAS) {
					System.out.println("El número de páginas a de ser mayor que 0.");

				}
			} while (revista.getPaginas() < NUM_PAGINAS);

			/*
			 * System.out.print("Formato de la revista (digital(D) o papel(P)): ");
			 * formato=Character.toUpperCase((char) System.in.read());
			 * 
			 * if(formato=='D') { revista.setFormato(true); }else if (formato=='P') {
			 * revista.setFormato(false); }else { System.out.
			 * println("El formato debe de ser para digital un D y para papel una P");
			 * 
			 * System.out.print("Formato de la revista (digital(D) o papel(P)): ");
			 * sc.nextLine(); formato=Character.toUpperCase((char) System.in.read()); }
			 */

			System.out.println("Inserte formato.\n El formato debe de ser para digital un D y para papel una P");
			revista.setFormato(formato);

			System.out.println("¿Quieres guardar la revista con los siguientes datos?");
			System.out.println(
					revista.getTitulo() + " " + revista.getIsbn() + " " + revista.getPaginas() + " " + revista.isFormato(););
			sc.nextLine();
			System.out.println("S/N");
			contest = Character.toUpperCase((char) System.in.read());

		} while (contest != 'S');

		dao.insert(revista);
		System.out.println("Video guardado.\n");
		pintarMenu();

	}

	private static void cargarRevista() throws Exception {
		Revista revista = new Revista(++cont, "Pronto", "1234567890", 120, true);
		dao.insert(revista);

		revista = new Revista(++cont, "Glamour", "0987654321", 80, false);
		dao.insert(revista);

		revista = new Revista(++cont, "Muy Interesante", "1598746320", 180, false);
		dao.insert(revista);

		revista = new Revista(++cont, "Instyle", "7854123690", 200, true);
		dao.insert(revista);

		revista = new Revista(++cont, "Hola", "1023654752", 300, false);
		dao.insert(revista);

	}

	private static void pintarMenu() {

		System.out.println("------------------------------------");
		System.out.println("--          REVISTAS              --");
		System.out.println("------------------------------------");
		System.out.println("-    1. Listar                     -");
		System.out.println("-    2. Añadir revista             -");
		System.out.println("-                                  -");
		System.out.println("-    0 - salir                     -");
		System.out.println("------------------------------------");
		System.out.println("");
		System.out.println("Dime una opcion por favor");

		try {
			opcionSeleccionada = sc.nextInt();

		} catch (Exception e) {
			// e.printStackTrace(); -->pinta la pila de excepcion
			sc.nextLine();
			System.out.println("OPCIÓN NO VALIDA. Por favor introduce un número del 0 al 2.\n");
			pintarMenu();
		}

	}

}
