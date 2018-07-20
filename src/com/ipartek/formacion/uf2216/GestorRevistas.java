package com.ipartek.formacion.uf2216;

import java.util.Scanner;

public class GestorRevistas {

	static private RevistaDAO dao;
	static private int opcionSeleccionada = 0;
	static Scanner sc = null;

	static long cont = 0;

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
		
		cargarRevistasPrueba();

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

	private static void cargarRevistasPrueba() {
		Revista r = new Revista(1000, "Revista ejemplo 1", "1234567890", 125, true);
		r =  new Revista(2000, "Revista ejemplo 2", "0987654321", 200, false);
	}

	private static void opcError() {
		System.out.println("La opcion que ha seleccionado no existe en el menu.");
		crearMenu();
	}

	private static void salir() {
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Hasta pronto");
	}

	private static void guardarEnFichero() {
		// TODO Auto-generated method stub

	}

	private static void crearRevista() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("----------------------------------------------------");
		System.out.println("		CREAR UNA NUEVA REVISTA				");
		System.out.println("----------------------------------------------------");

		do {
			System.out.println("Introduce el titulo de la revista: ");
			titulo = sc.nextLine().trim();
			System.out.println(titulo);

			if (titulo.length() < 3 || titulo.length() > 150)
				System.out.println(Revista.TITULO_LENGTH_EXCEPTION);

			/*
			 * if (titulo.length() >= 3 && titulo.length() <= 150) {
			 * System.out.println("Introduce el ISBN de la revista: "); isbn =
			 * sc.nextLine().trim();
			 * 
			 * if (isbn.length() == 10) {
			 * System.out.println("Introduce el numero de páginas de la revista: ");
			 * numPaginas = sc.nextInt(); if (numPaginas >= 1) { System.out.
			 * println("¿La revista esta en formato digital o en formato papel (D/P)?");
			 * opcionDigitalPapel = sc.nextLine().trim();
			 * 
			 * revista = new Revista(); revista.setId(cont++); revista.setTitulo(titulo);
			 * revista.setIsbn(isbn); revista.setNumPaginas(numPaginas);
			 * 
			 * if(opcionDigitalPapel.equalsIgnoreCase("d")) { revista.setEsDigital(true);
			 * }else if(opcionDigitalPapel.equalsIgnoreCase("p"))
			 * revista.setEsDigital(false);
			 * 
			 * System.out.println("Datos de la revista a guardar: ");
			 * System.out.println(revista.toString());
			 * System.out.println("Desea confirmar el ingreso de la revista (S/N)?");
			 * opcionSiONo = sc.nextLine().trim();
			 * 
			 * if(opcionSiONo.equalsIgnoreCase("S")) { dao.insert(revista);
			 * System.out.println("Revista guardada."); }else
			 * System.out.println("Ingreso de la revista cancelada.");
			 * 
			 * crearMenu(); } }else { System.out.println(Revista.ISBN_LENGTH_EXCEPTION); } }
			 * else { System.out.println(Revista.TITULO_LENGTH_EXCEPTION); }
			 */

		} while (titulo.length() < 3 || titulo.length() > 150);

		do {
			System.out.println("Introduce el ISBN de la revista: ");
			isbn = sc.nextLine().trim();

			if (isbn.length() != 10) {
				System.out.println(Revista.ISBN_LENGTH_EXCEPTION);
			}
		} while (isbn.length() != 10);

		do {
			System.out.println("Introduce el número de páginas de la revista: ");
			numPaginas = sc.nextInt();

			if (numPaginas < 1)
				System.out.println(Revista.NUM_PAGINAS_EXCEPTION);

		} while (numPaginas < 1);

		do {
			System.out.println("¿La revista esta en formato digital o en formato papel (D/P)?");
			opcionDigitalPapel = sc.nextLine().trim();

			if (!opcionDigitalPapel.equalsIgnoreCase("d") || !opcionDigitalPapel.equalsIgnoreCase("p"))
				System.out.println("No ha introducido una opción válida para el formato de la revista.");

		} while (!opcionDigitalPapel.toLowerCase().equalsIgnoreCase("d".toLowerCase()) || !opcionDigitalPapel.toLowerCase().equalsIgnoreCase("p".toLowerCase()));

		revista = new Revista();
		revista.setId(cont++);
		revista.setTitulo(titulo);
		revista.setIsbn(isbn);
		revista.setNumPaginas(numPaginas);

		if (opcionDigitalPapel.equalsIgnoreCase("d")) {
			revista.setEsDigital(true);
		} else if (opcionDigitalPapel.equalsIgnoreCase("p"))
			revista.setEsDigital(false);

		System.out.println("Datos de la revista a guardar: ");
		System.out.println(revista.toString());
		do {
			System.out.println("Desea confirmar el ingreso de la revista (S/N)?");
			opcionSiONo = sc.nextLine().trim();

			if (!opcionSiONo.toLowerCase().equalsIgnoreCase("s".toLowerCase()) || !opcionSiONo.toLowerCase().equalsIgnoreCase("n".toLowerCase()))
				System.out.println("No ha introducido una opción válida para el ingreso de la revista.");

		} while (!opcionSiONo.toLowerCase().equalsIgnoreCase("s".toLowerCase()) || !opcionSiONo.toLowerCase().equalsIgnoreCase("n".toLowerCase()));

		if (opcionSiONo.toLowerCase().equalsIgnoreCase("S".toLowerCase())) {
			dao.insert(revista);
			System.out.println("Revista guardada.");
		} else
			System.out.println("Ingreso de la revista cancelada.");
		
		crearMenu();
	}

	private static void listarRevistas() {
		System.out.println("----------------------------------------------------");
		System.out.println("		LISTADO DE REVISTAS ACTUALES			");
		System.out.println("----------------------------------------------------");

		for (Revista r : dao.GetAll()) {
			System.out.println("	" + r.toString());
		}

		System.out.println(" ");
		System.out.println(" ");

		crearMenu();
	}

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
		System.out.println("Seleccione una opcion del menu: ");

		opcionSeleccionada = sc.nextInt();

		sc.nextLine();

	}

}
