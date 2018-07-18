package com.ipartek.formacion.libros;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.ipartek.formacion.model.LibroDAO;
import com.ipartek.formacion.pojo.Libro;

public class GestorLibros {

		static private LibroDAO dao;
		static private int opcionSeleccionada = 0;
		static Scanner sc = null;
		static BufferedReader br = null;
		
		static private final int OPCION_SALIR = 0;
		static private final int OPCION_LISTAR = 1;
		static private final int OPCION_LISTAR_PRESTADOS = 2;
		static private final int OPCION_LISTAR_NO_PRESTADOS = 3;
		static private final int OPCION_BUSCAR = 4;
		static private int CONTADOR = 0;

	public static void main(String[] args) {

		
		try {
			sc = new Scanner(System.in);
			
			br = new BufferedReader(new InputStreamReader(System.in));
			
			dao = LibroDAO.getInstance();

			cargarVideos();
			
			pintarMenu();

			opcionElegida();
			
		} catch (Exception e) {
			System.out.println("Lo sentimos, ha habido un error.");
		}
		
		finally {
			
			if (sc != null && br != null) {
				try {
					br.close();
				} catch (IOException e) {
					System.out.println("Lo sentimos, ha habido un error.");
				}
				sc.close();
			}
			dao = null;
		}

	}
	
	private static void cargarVideos() throws Exception {
		
		dao.insert(new Libro(++CONTADOR, " 9788416001460", "FARIÑA: HISTORIA E INDISCRECIONES DEL NARCOTRAFICO EN GALICIA", "LIBROS DEL K.O", true));
				
		dao.insert(new Libro(++CONTADOR, " 9788467575057", "LENGUA TRIMESTRAL 2º EDUCACION PRIMARIA SAVIA ED 2015", "EDICIONES SM", false));
				
		dao.insert(new Libro(++CONTADOR, " 9788467575071", "MATEMÁTICAS TRIMESTRAL SAVIA-15", "EDICIONES SM", false));
				
		dao.insert(new Libro(++CONTADOR, " 9788461716098", "LA VOZ DE TU ALMA", "AUTOR-EDITOR", true));
				
		dao.insert(new Libro(++CONTADOR, " 9788467569957", "LENGUA CASTELLANA 3º EDUCACION PRIMARIA TRIMESTRES SAVIA CASTELLA NO ED 2014", "EDICIONES SM", false));
				
		dao.insert(new Libro(++CONTADOR, " 9781380013835", "NEW HIGH FIVE 1 PUPILS BOOK PACK", "MACMILLAN CHILDRENS BOOKS", false));
				
		dao.insert(new Libro(++CONTADOR, " 9781380011718", "NEW HIGH FIVE 3 PUPILS BOOK ", "MACMILLAN CHILDRENS BOOKS", false));
				
	}

	private static void pintarMenu() {//throws Exception{
		
		System.out.println("---------------------------------------");
		System.out.println("--          Libros                -----");
		System.out.println("---------------------------------------");
		System.out.println("-    1. Listar todos los libros    ----");
		System.out.println("-    2. Listar libros prestados    ----");
		System.out.println("-    3. Listar libros no prestados ----");
		System.out.println("-    4. Buscar por título          ----");
		System.out.println("-                                  ----");
		System.out.println("-    0 - salir                     ----");
		System.out.println("---------------------------------------");
		System.out.println("");
		System.out.println("Dime una opcion por favor");
		
		try {
			opcionSeleccionada = sc.nextInt();
		}catch (Exception e) {
			//e.printStackTrace(); Pinta la fila de excepción
			
			sc.nextLine();
			System.out.println("\nOPCIÓN NO VÁLIDA, Por favor, introduzca un número del menú\n");
			
			pintarMenu();
			opcionElegida();
			
		}
		
	}

	private static void opcionElegida() {
		
		switch (opcionSeleccionada) {
		
		case OPCION_LISTAR:
			listar();
			break;
			
		case OPCION_LISTAR_PRESTADOS:
			listarPrestados();
			break;
			
		case OPCION_LISTAR_NO_PRESTADOS:
			listarNoPrestados();
			break;

		case OPCION_BUSCAR:
			buscarPorTitulo();
			break;

		case OPCION_SALIR:
			salir();
			break;	
			
		default:
			noOption();
			break;
		}
		
	}

	private static void listar() {
		for ( Libro libro : dao.getAll() ) {
			System.out.println(libro);
		}

		pintarMenu();
		opcionElegida();
		
	}

	private static void listarPrestados() {
		
		int contadorPrestados = 0;
			
		for ( Libro libro : dao.getAll() ) {
			
			if(libro.isPrestado()) {
				System.out.println("   " + libro);
				contadorPrestados++;
			}
		}
		
		if(contadorPrestados == 0) {
			System.out.println("\nEn estos momentos no hay ningún libro prestado\n");
		}
		
		pintarMenu();
		opcionElegida();
		
	}

	private static void listarNoPrestados() {

		int contadorNoPrestados = 0;
			
		for ( Libro libro : dao.getAll() ) {
			if(libro.isPrestado() == false) {
				System.out.println("   " + libro);
				contadorNoPrestados++;
			}
		}
		
		if(contadorNoPrestados == 0) {
			System.out.println("\nEn estos momentos todos los libros están prestados\n");
		}
		
		pintarMenu();
		opcionElegida();
		
	}

	private static void buscarPorTitulo() {
		
		String titulo = "";
		int librosEncontrados = 0;
		
		System.out.println("Introduce el título del libro que deseas buscar");
		try {
			titulo = br.readLine();
		} catch (IOException e) {
			System.out.println("Lo sentimos, ha ocurrido un error inesperado");
		}
		
		for (Libro libro : dao.getAll()) {
			if(libro.getTitulo().contains(titulo.toUpperCase())) {
				System.out.println(libro);
				librosEncontrados++;
			}
		}
		
		if(librosEncontrados == 0) {
			System.out.println("\nNo hemos encontrado ninún libro con ese titulo\n");
			buscarPorTitulo();
		}
		
		pintarMenu();
		opcionElegida();
		
	}

	private static void noOption() {
		
		System.out.println("Lo sentimos, no existe esa opcion");
		pintarMenu();
		opcionElegida();
		
	}

	private static void salir() {
		
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("AGUR VENUR, esperamos verte pronto");
		
	}

}
