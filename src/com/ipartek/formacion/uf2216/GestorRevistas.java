package com.ipartek.formacion.uf2216;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GestorRevistas {

	static private RevistaDAO dao;
	static private int opcionSeleccionada = 0;
	static Scanner sc = null;

	static Revista revista;
	static String titulo;
	static String isbn;
	static int numPaginas;
	static boolean esDigital;
	static String opcionDigitalPapel;

	static String opcionSiONo;

	static private final int OPCION_LISTAR = 1;
	static private final int OPCION_INGRESAR_REVISTA = 2;
	static private final int OPCION_GUARDAR_FICHERO = 3;
	static private final int OPCION_SALIR = 0;

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		dao = RevistaDAO.getInstance();

		try {
			cargarRevistasPrueba();
		} catch (Exception e1) {
			System.out.println("Error al cargar revistas de prueba.");
		}

		crearMenu();

		do {
			switch (opcionSeleccionada) {
			case OPCION_LISTAR:
				listarRevistas();
				break;
			case OPCION_INGRESAR_REVISTA:
				try {
					crearRevista();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case OPCION_GUARDAR_FICHERO:
				guardarEnFichero();
				break;
			case OPCION_SALIR:
				salir();
				break;
			default:
				opcError();
				break;
			}
		} while (opcionSeleccionada != OPCION_SALIR);

		sc.close();
	}

	/**
	 * Carga manual de revistas de prueba para comprobar el metodo Listar()
	 * 
	 * @throws Exception En caso de que los atributos no se introduzcan
	 *                   correctamente
	 */
	private static void cargarRevistasPrueba() throws Exception {
		Revista r = new Revista("Revista ejemplo 1", "1234567890", 125, true);
		dao.insert(r);
		r = new Revista("Revista ejemplo 2", "0987654321", 200, false);
		dao.insert(r);
	}

	/**
	 * Metodo que le saca un mensaje de error al usuario en caso de que este
	 * introduzca cualquier caracter que no corresponde con las opciones de la lista
	 */
	private static void opcError() {
		System.out.println("La opcion que ha seleccionado no existe en el menu.");
		crearMenu();
	}

	/**
	 * Metodo que se lanza cuando el usuario introduce la opcion SALIR
	 */
	private static void salir() {
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Hasta pronto");
	}

	/**
	 * Metodo que guarda en un fichero txt las revistas actuales
	 */
	private static void guardarEnFichero() {

		File f = new File("Revistas.txt");

		if (f.exists()) {

			BufferedWriter bw;
			try {
				bw = new BufferedWriter(new FileWriter(f));
				for (Revista r : dao.GetAll()) {
					bw.write(r.toString());
					bw.write("\n");
					bw.write("\n");
				}
				bw.close();
			} catch (IOException e) {
				System.out.println("Error al crear el fichero con las revistas.");
			}
			System.out.println("Actualizado el fichero con las revistas.");

		}

		crearMenu();
	}

	/**
	 * Metodo que pide al usuario los datos de una revista para posteriormente
	 * guardarla en la lista de revistas
	 * 
	 * @throws Exception En caso de que algun atributo introducido no sea del
	 *                   formato que se pide
	 */
	private static void crearRevista() throws Exception {
		System.out.println("----------------------------------------------------");
		System.out.println("		CREAR UNA NUEVA REVISTA				");
		System.out.println("----------------------------------------------------");

		comprobarTitulo();
		comprobarIsbn();
		comprobarNumPaginas();

		sc.nextLine();

		comprobarFormato();

		revista = new Revista();
		revista.setTitulo(titulo);
		revista.setIsbn(isbn);
		revista.setNumPaginas(numPaginas);

		if (opcionDigitalPapel.equalsIgnoreCase("d")) {
			revista.setEsDigital(true);
		} else if (opcionDigitalPapel.equalsIgnoreCase("p"))
			revista.setEsDigital(false);

		System.out.println("Datos de la revista a guardar: ");
		System.out.println(revista.toString());
		System.out.println(" ");

		do {
			System.out.println("Desea confirmar el ingreso de la revista (S/N)?");
			opcionSiONo = sc.nextLine().trim();

			if (!opcionSiONo.equalsIgnoreCase("s") && !opcionSiONo.equalsIgnoreCase("n"))
				System.out.println("No ha introducido una opción válida para el ingreso de la revista.");

			System.out.println(" ");

		} while (!opcionSiONo.equalsIgnoreCase("s") && !opcionSiONo.equalsIgnoreCase("n"));

		if (opcionSiONo.equalsIgnoreCase("s")) {
			dao.insert(revista);
			System.out.println("Revista guardada.");
		} else
			System.out.println("Ingreso de la revista cancelada.");

		System.out.println(" ");
		crearMenu();
	}

	private static void comprobarFormato() {
		do {
			System.out.println("¿La revista está en formato digital o en formato papel (D/P)?");
			opcionDigitalPapel = sc.nextLine().trim();

			if (!opcionDigitalPapel.equalsIgnoreCase("d") && !opcionDigitalPapel.equalsIgnoreCase("p"))
				System.out.println("No ha introducido una opción válida para el formato de la revista.");

			System.out.println(" ");

		} while (!opcionDigitalPapel.equalsIgnoreCase("d") && !opcionDigitalPapel.equalsIgnoreCase("p"));
	}

	private static void comprobarNumPaginas() {
		do {
			System.out.println("Introduce el número de páginas de la revista: ");
			numPaginas = sc.nextInt();

			if (numPaginas < 1)
				System.out.println(Revista.NUM_PAGINAS_EXCEPTION);

			System.out.println(" ");

		} while (numPaginas < 1);
	}

	private static void comprobarIsbn() {
		do {
			System.out.println("Introduce el ISBN de la revista: ");
			isbn = sc.nextLine().trim();

			if (isbn.length() != 10)
				System.out.println(Revista.ISBN_LENGTH_EXCEPTION);

			System.out.println(" ");

		} while (isbn.length() != 10);
	}

	private static void comprobarTitulo() {
		do {
			System.out.println("Introduce el título de la revista: ");
			titulo = sc.nextLine().trim();

			if (titulo.length() < 3 || titulo.length() > 150)
				System.out.println(Revista.TITULO_LENGTH_EXCEPTION);

			System.out.println(" ");

		} while (titulo.length() < 3 || titulo.length() > 150);
	}

	/**
	 * Metodo que saca por pantalla todas las revistas actuales de la lista
	 */
	private static void listarRevistas() {
		System.out.println("----------------------------------------------------");
		System.out.println("	LISTADO DE REVISTAS ACTUALES			");
		System.out.println("----------------------------------------------------");

		for (Revista r : dao.GetAll()) {
			System.out.println(r.toString());
			System.out.println(" ");
		}

		System.out.println(" ");

		crearMenu();
	}

	/**
	 * Metodo que pinta el menu para el usuario y le permite introducir un valor
	 * para seleccionar una de las opciones listadas
	 */
	private static void crearMenu() {
		System.out.println("-------------------------------------------------");
		System.out.println("		GESTOR DE REVISTAS				 ");
		System.out.println("-------------------------------------------------");
		System.out.println("- 1. 		Listar revistas guardadas	-");
		System.out.println("- 2. 		Crear nueva revista		-");
		System.out.println("- 3. 		Guardar revistas		-");
		System.out.println("- 0. 		Salir				-");
		System.out.println("-------------------------------------------------");
		System.out.println(" ");
		System.out.println("Seleccione una opción del menú: ");

		try {

			opcionSeleccionada = sc.nextInt();

		} catch (Exception e) {
			System.out.println("Opción no válida. Introduce un número del menú.");
			sc.nextLine();
		} finally {
			sc.nextLine();
		}
	}

}
