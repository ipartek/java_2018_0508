package com.ipartek.formacion.uf2216;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GestorRevista {

	static private RevistaDAO dao;
	static private int opcionSeleccionada = 0;
	static Scanner sc = null;

	static private final int OPCION_SALIR = 0;
	static private final int OPCION_LISTAR = 1;
	static private final int OPCION_ANADIR = 2;
	static private final int OPCION_GUARDAR = 3;
	static private final int TITULO_MIN = 3;
	static private final int TITULO_MAX = 150;
	static private final int LONGISBN = 10;
	static private final int MIN_NUMPAG = 1;

	static private final boolean DIGITAL = true;
	static private final boolean PAPEL = false;
	static private final String FORMATODIG = "Digital";
	static private final String FORMATOPAPEL = "Papel";

	static private final String TERMINAR = "n";
	static private final int VACIO = 0;
	private static int cont = 0;

	public static void main(String[] args) {

		try {
			sc = new Scanner(System.in);

			dao = RevistaDAO.getInstance();

			cargarRevista();

			do {

				pintarMenu();

				switch (opcionSeleccionada) {
				case OPCION_LISTAR:
					listarRevista();
					break;

				case OPCION_ANADIR:
					agregarRevista();
					break;

				case OPCION_GUARDAR:
					guardarListaFichero();
					break;

				case OPCION_SALIR:
					System.out.println(" Saliendo de la aplicacion...Hasta la proxima ");
					break;

				default:
					System.out.println(" Opcion no valida, el menu va del 0 al 3...");
					break;
				}

			} while (opcionSeleccionada != OPCION_SALIR);

		} catch (Exception e) {
			System.out.println("Lo sentimos ,la aplicacion esta fuera de servicio");
		} finally {
			sc.close();
		}

	}

	private static void agregarRevista() {

		sc.nextLine();
		boolean resul = false;
		int numPagRevista = 0;
		String titulo = "";
		String isbn = "";
		String formatoRevista = "";
		boolean formate = false;
		String FormatoMostrar = "";
		String guardar = "";

		String continuar = "n";
		System.out.println("\n");

		do {

			// Titulo
			do {
				System.out.print("inserte entre 3 y 150 caracteres para el titulo : ");
				titulo = sc.next();

				if (titulo.length() < TITULO_MIN || titulo.length() > TITULO_MAX) {
					System.out
							.println("Repita por favor...La longitud del titulo debe de ser entre 3 y 150 caracteres");
				}
			} while (titulo.length() < TITULO_MIN || titulo.length() > TITULO_MAX);

			// ISBN
			do {
				System.out.print("inserte 10 caracteres para el ISBN: ");
				isbn = sc.next();
				sc.nextLine();
				if (isbn.length() != LONGISBN) {
					System.out.println("ERROR...La longitud del ISBN debe ser de 10 caracteres.");
				}

			} while (isbn.length() != LONGISBN);

			// NUMPAG
			do {
				System.out.println("Indica el numero de paginas de la revista:");
				try {
					numPagRevista = sc.nextInt();

				} catch (Exception e) {
					System.out.println("debe de tener al menos 1 pagina la revista");
					sc.nextLine();

				}

			} while (numPagRevista < MIN_NUMPAG);

			// FORMATO

			do {

				System.out.println("Indica el formato de la revista(digital(D) o papel(P)):");
				try {
					formatoRevista = sc.next();

					if ("P".equalsIgnoreCase(formatoRevista)) {
						formate = PAPEL;
						FormatoMostrar = FORMATOPAPEL;

					} else if ("D".equalsIgnoreCase(formatoRevista)) {
						formate = DIGITAL;
						FormatoMostrar = FORMATODIG;
					} else {
						System.out.println("Formato no valido...eliga entre (D)igital o (P)apel");
					}
				} catch (Exception e) {
					System.out.println("Valor incorrecto, opciones disponibles digital(D) o papel(p)");
					sc.nextLine();

				}

			} while (!"P".equalsIgnoreCase(formatoRevista) && !"D".equalsIgnoreCase(formatoRevista));

			// Mostrar antes de guardar
			System.out.println("_____________________________");
			System.out.println("Datos de la revista a crear:");
			System.out.println("_____________________________");
			System.out.println("Titulo: " + titulo + "\n ISBN: " + isbn + "\n Numero Paginas: " + numPagRevista
					+ " \n Formato: " + FormatoMostrar);

			System.out.println("¿Deseas guardar la revista a la lista? \"s\" si \"n\"no");
			guardar = sc.next();

			// Guarda revista
			if ("s".equalsIgnoreCase(guardar)) {
				Revista r = new Revista();

				r.setId(cont++);
				r.setTitulo(titulo.trim());
				r.setIsbn(isbn);
				r.setNumPag(numPagRevista);
				r.setFormato(formate);

				dao.insert(r);

				System.out.println("guardado registro....");

			} else {
				System.out.println("No se ha guardado en la lista.");

			}

			// Añadir mas revistas
			System.out.println("¿Deseas agregar mas revistas? \"s\" si \"n\"no");
			continuar = sc.next();
			resul = validarContinuar(continuar);
			sc.nextLine();
			while (resul == false) {
				System.out.println("Por favor inserte \"s\" si o \"n\"no");
				continuar = sc.next();
				resul = validarContinuar(continuar);
				sc.nextLine();
			}
			sc.nextLine();

		} while (!TERMINAR.equalsIgnoreCase(continuar));

	}

	private static void listarRevista() {
		ArrayList<Revista> revista = (ArrayList<Revista>) dao.getALl();

		if (revista.size() <= VACIO) {
			System.out.println("No hay Revistas para mostrar.");
		} else {
			System.out.println("\n Listado de " + revista.size() + " revista:");

			for (Revista listRevista : revista) {
				System.out.println("  " + listRevista + " \n");
			}

		}

	}

	private static void cargarRevista() {
		Revista revista = new Revista(cont++, "Mega", "1111111111", 2, PAPEL);
		dao.insert(revista);

		revista = new Revista(cont++, "Corazon", "1111111112", 2, DIGITAL);
		dao.insert(revista);

	}

	private static boolean validarContinuar(String c) {

		boolean resul = false;

		if ("s".equalsIgnoreCase(c) || "n".equalsIgnoreCase(c)) {
			resul = true;
		} else {
			resul = false;
		}

		return resul;
	}

	private static void pintarMenu() {

		System.out.println("______________________________________");
		System.out.println("|       Menu   Revistas              |");
		System.out.println("|____________________________________|");
		System.out.println("|    	1. Listar		     |");
		System.out.println("|------------------------------------|");
		System.out.println("|    	2. Agregar	             |");
		System.out.println("|------------------------------------|");
		System.out.println("|    	3.Guardar   	             |");
		System.out.println("|------------------------------------|");
		System.out.println("|    	0. salir	             |");
		System.out.println("|____________________________________|\n");

		System.out.print("Inserta opcion deseada:");
		try {
			opcionSeleccionada = sc.nextInt();

		} catch (Exception e) {
			System.out.println("OPCION NO VALIDAD, Por favor introduce un numero del menu");
			sc.nextLine();
			pintarMenu();
		}
	}

	/**
	 * Metodo que guardao la lista de revistas en un fichero. si existe el
	 * fichero.txt en la ruta C:\Desarrollo\Workspace\java_2018_0508\fichero.txt se
	 * guarda.
	 * 
	 */
	private static void guardarListaFichero() {

		File f = new File("fichero.txt");

		if (f.exists()) {
			escribirFichero(f);
			System.out.println("Se ha añadido los registros en el fichero " + f);
		} else {

			try {
				f.createNewFile();
				System.out.println("Se ha creado el fichero " + f);
				escribirFichero(f);
				System.out.println("Se ha añadido los registros en el fichero " + f);
			} catch (IOException e) {

				System.out.println("Error al crear fichero");
				e.printStackTrace();
			}
		}
	}

	private static void escribirFichero(File f) {
		System.out.println("Escribiendo en el fichero ....");
		ArrayList<Revista> listaRevista = (ArrayList<Revista>) dao.getALl();
		BufferedWriter bw = null;

		try {
			bw = new BufferedWriter(new FileWriter(f));
			for (int i = 0; i < listaRevista.size(); i++) {
				bw.write(listaRevista.get(i).toString());
				bw.newLine();
			}

			bw.close();
			System.out.println("Terminamos de escribir en el fichero....\n");

		} catch (Exception e) {
			System.out.println("Exception escribiendo fichero: " + e.getMessage());
		}
	}

}
