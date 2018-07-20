package com.ipartek.formacion.uf2216;

import java.util.Scanner;

public class GestionRevistas {
	
	static private RevistasArrayDAO dao;

	static private int opcionSeleccionada = -1;
	static Scanner sc; 

	static private final int OPCION_SALIR = 0;
	static private final int OPCION_LISTAR = 1;
	static private final int OPCION_ANADIR = 2;
	
	static private final int MIN_LONG_TITULO = 3;
	static private final int MAX_LONG_TITULO = 150;
	static private final int MIN_PAGINAS = 1;
	
	public static final int ISBN_MIN_LENGTH = 10;
	
	public static void main(String[] args) {
		
		try {
			System.out.println("------------------------------------");
			System.out.println("--        GESTOR REVISTAS         --");

			dao = RevistasArrayDAO.getInstance();
			sc = new Scanner(System.in);

			cargarRevistas();

			
			do {

				pintarMenu();

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

				}

			} while (opcionSeleccionada != OPCION_SALIR);
			
		} catch (Exception e) {
			
			System.out.println("Sentimos las molestias, ha ocurrido un error inesperado.");
		
		} finally {
			if (sc != null) {
				sc.close();
			}
			
			dao = null;
			
		}
	}


	private static void anadir() {
		
		String titulo;
		String isbn;
		int paginas;
		boolean formato1= Boolean.valueOf("digital");
		boolean formato2= Boolean.valueOf("papel");
		
		
		do {
			System.out.println("Introduce el titulo de la revista: ");
			titulo= sc.nextLine();
			
			if (titulo.length() < MIN_LONG_TITULO || titulo.length() > MAX_LONG_TITULO) {
				System.out.println("Introduce un titulo con una longitud correcta: ");
			}
			
		}while(titulo.length() < MIN_LONG_TITULO || titulo.length() > MAX_LONG_TITULO);
		
		do {
			
			System.out.println("Introduce el isbn: ");
			isbn= sc.nextLine();
			
			if (isbn.trim().length() < ISBN_MIN_LENGTH) {
				System.out.println("Introduce un isbn correcto: ");
			}
		}while(isbn.trim().length() < ISBN_MIN_LENGTH);
		
		do {
			System.out.println("Introduce el numero de paginas: ");
			paginas= sc.nextInt();
			
			if (paginas < MIN_PAGINAS) {
				System.out.println("Introduzca un numero de paginas correcto: ");
			}
		}while(paginas < MIN_PAGINAS);
		
		
		
	}

	private static void salir() {
		
		System.out.println("");
		System.out.println("");	
		System.out.println("HAS SALIDO DEL GESTOR DE REVISTAS");
		
	}

	private static void listar() {
		
		if (dao.getAll().size() > 0) {
			System.out.println("Lista de revistas: \n\n");
			for (Revistas revista : dao.getAll()) {
				System.out.println("    " + revista);
			}
			System.out.println("\n\n\n");
		} else {
			System.out.println("LO SENTIMOS. No hay revistas en la lista.");
		}

		
	}

	private static void pintarMenu() {
		
		System.out.println("-    1. Listar                     -");
		System.out.println("-    2. Añadir Revista             -");
		System.out.println("-    0. Salir                      -");
		System.out.println("------------------------------------");
		System.out.println("");
		System.out.print("Por favor, selecciona una opción: ");

		try {
			opcionSeleccionada = sc.nextInt();

		} catch (Exception e) {
			
		} finally {

			sc.nextLine();
		}
		
	}

	private static void cargarRevistas() throws Exception {
		
		Revistas revista;
		
		revista = new Revistas("National Geographic", "1234567899",150,true);
		dao.insert(revista);
		
		revista = new Revistas("Motor Sport", "6374399118",128,false);
		dao.insert(revista);

		
	}

}
