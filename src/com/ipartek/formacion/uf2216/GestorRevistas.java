package com.ipartek.formacion.uf2216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class GestorRevistas {

		static private RevistaArrayDAO dao;
		static private int opcionSeleccionada = -1;
		static Scanner sc = null;
		static BufferedReader br = null;

		private static final int OPCION_SALIR = 0;
		private static final int OPCION_INSERTAR = 1;
		private static final int OPCION_LISTAR = 2;
		private static final int OPCION_GUARDAR_TXT = 3;
		
		
		
	public static void main(String[] args) {
		
		try {
			
			sc = new Scanner(System.in);
			
			br = new BufferedReader(new InputStreamReader(System.in));
			
			dao = RevistaArrayDAO.getInstance();
			
			pintarMenu();
			
		} catch (Exception e) {
			System.out.println("Lo sentimos, ha habido un error.");
		}

		
	}

	private static void pintarMenu() {

		System.out.println("\n-------------------------------------------");
		System.out.println("---          Revistas                   ---");
		System.out.println("-------------------------------------------");
		System.out.println("-     1. Añadir nueva revista             -");
		System.out.println("-     2. Listar todas las revistas        -");
		System.out.println("-     3. Guardar revistas en fichero.txt  -");
		System.out.println("---                                     ---");
		System.out.println("-     0 - salir                           -");
		System.out.println("-------------------------------------------");
		System.out.println("");
		System.out.println("Dime una opcion por favor");
		
		try {
			opcionSeleccionada = sc.nextInt();
		}catch (Exception e) {
			//e.printStackTrace(); Pinta la fila de excepción
			
			sc.nextLine();
			System.out.println("\nOpción incorrecta, Por favor, introduzca un NÚMERO del menú\n");
			
			pintarMenu();
			
		}

		opcionElegida();
		
		
	}

	private static void opcionElegida() {

		switch (opcionSeleccionada) {
		
		case OPCION_INSERTAR:
			insertar();
			break;
			
		case OPCION_LISTAR:
			listar();
			break;
			
		case OPCION_GUARDAR_TXT:
			guardarTxt();
			break;

		case OPCION_SALIR:
			salir();
			break;	
			
		default:
			noOption();
			break;
		}
		
	}

	
	private static void insertar() {

		Revista revista = new Revista();
		
		String titulo = "";
		String isbn = "";
		int nPaginas = 0;
		char formatoTexto = 'p';
		boolean formato = false;
		char guardar = 'n';
		
		do {
			System.out.println("¿Cuál es el título de la revista? (de " + Revista.TITULO_MIN_LENGTH +
					" a " + Revista.TITULO_MAX_LENGTH + " caracteres, por favor)");
			try {
				titulo = br.readLine();
			} catch (IOException e) {
				System.out.println("Lo sentimos, ha ocurrido un error inesperado");
			} 
		} while (titulo.trim().length() < Revista.TITULO_MIN_LENGTH || 
				titulo.trim().length() > Revista.TITULO_MAX_LENGTH);
		
		try {
			revista.setTitulo(titulo);
		} catch (Exception e) {
			System.out.println(Revista.TITULO_MENSAJE_EXCEPTION);
		}
		
		
		
		do {
			System.out.println("¿Cuál es el ISBN de la revista? (debe ser de " +  Revista.ISBN_LENGTH + " caracteres)");
			try {
				isbn = br.readLine();
			} catch (IOException e) {
				System.out.println("Lo sentimos, ha ocurrido un error inesperado");
			} 
		} while (isbn.trim().length() != Revista.ISBN_LENGTH);
		
		try {
			revista.setIsbn(isbn);
		} catch (Exception e) {
			System.out.println(Revista.ISBN_MENSAJE_EXCEPTION);
		}
		
		do {
			System.out.println("¿Cuántas páginas tiene la revista? (Debe introducir un NÚMERO mayor que " + Revista.PAGINAS_MIN_LENGTH + ")");
			nPaginas = sc.nextInt();
		} while (nPaginas < Revista.PAGINAS_MIN_LENGTH);
		
		try {
			revista.setnPaginas(nPaginas);
		} catch (Exception e) {
			System.out.println(Revista.PAGINAS_MENSAJE_EXCEPTION);
		}

		do {
			System.out.println("¿Cuál es el formato de la revista, digital o papel?");
			System.out.println("Introducir 'd' para digital y 'p' para papel");
			formatoTexto = sc.next().charAt(0);
			formatoTexto = Character.toLowerCase(formatoTexto);
		} while (formatoTexto != 'd' && formatoTexto != 'p');
		
		if(formatoTexto == 'd') {
			formato = true;
		}else {
			formato = false;
		}

		revista.setFormato(formato);
		
		System.out.println("Revista a ingresar:\n");
		System.out.println(revista + "\n");
		
		do {
			System.out.println("¿Quiere guardar esta revista en nuestra bibliotecta (s/n)?");
			guardar = sc.next().charAt(0);
			guardar = Character.toLowerCase(guardar);
		} while (guardar != 's' && guardar != 'n');
		
		if(guardar == 's') {
			dao.insert(revista);
			System.out.println("\nRevista insertada correctamente.");
		}else {
			System.out.println("\nComo quiera, si cambia de opinión pulse el " + OPCION_INSERTAR + "\n");
		}
		
		pintarMenu();
		
	}

	private static void listar() {
		
		System.out.println("\nLista de revistas almacenadas:\n");
		
		for ( Revista revista : dao.getAll() ) {
			System.out.println(revista);
		}

		pintarMenu();
		
	}

	private static void guardarTxt() {
		
		
		
	}
	
	private static void salir() {
		
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("Hasta luego, gracias por utilizar nuestro gestor de revistas");
		
	}

	private static void noOption() {
		
		System.out.println("Lo sentimos, no existe esa opcion");
		pintarMenu();
		
	}

}
