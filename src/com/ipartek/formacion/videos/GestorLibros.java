package com.ipartek.formacion.videos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ipartek.formacion.model.LibrosArrayDAO;
import com.ipartek.formacion.pojo.Libro;
import com.ipartek.formacion.pojo.VideoYoutube;


public class GestorLibros {
	//CONSTANTES
	static private LibrosArrayDAO dao;
	static private int opcionSeleccionada = 0;
	static Scanner sc = null;
	//OPCIONES MENU
	static private final int OPCION_SALIR = 4;
	static private final int OPCION_LISTAR_PRESTADO = 1;
	static private final int OPCION_LISTAR_NO_PRESTADO = 2;
	static private final int OPCION_BUSCADOR = 3;
	
	public static void main(String[] args) {
		
		try {
			sc = new Scanner(System.in);
			dao = LibrosArrayDAO.getInstance();
			cargarLibros();

			do { //Hazme esto

				pintarMenu();
				
				//Opciones de menu
				switch (opcionSeleccionada) {
				case OPCION_LISTAR_PRESTADO:
					listarPrestados(opcionSeleccionada);
					break;
				case OPCION_LISTAR_NO_PRESTADO:
					listarPrestados(opcionSeleccionada);
					break;
				case OPCION_BUSCADOR:
					buscarLibro();
					break;
				case OPCION_SALIR:
					System.out.println("Saliendo de la aplicacion...Hasta la proxima");
					break;
				}
				
			//MIENTRAS
			} while (opcionSeleccionada != OPCION_SALIR);
			
			
		} catch (Exception e) {//SI ME FALLARIA EL CARGAR LIBROS
			System.out.println("Lo sentimos la aplicacion esta fuera de servicio por problemas tecnicos");
		} finally {
			sc.close();
		}
	
	}

	
	public static void cargarLibros() throws Exception {

		Libro libro = new Libro(123456, "9788416001460","FARIÑA: HISTORIA E INDISCRECIONES DEL NARCOTRAFICO EN GALICIA", "LIBROS DEL K.O", true);
		dao.insert(libro);

		libro = new Libro(456456456, "9788467575057", "LENGUA TRIMESTRAL 2º EDUCACION PRIMARIA SAVIA ED","EDICIONES SM", false);
		dao.insert(libro);

		libro = new Libro(789679855, "9788467575071", "MATEMÁTICAS TRIMESTRAL SAVIA-15", "EDICIONES SM", false);
		dao.insert(libro);

		libro = new Libro(235423423, "9788461716098", "LA VOZ DE TU ALMA", "AUTOR-EDITOR", true);
		dao.insert(libro);

		libro = new Libro(456457456, "9788467569957","LENGUA CASTELLANA 3º EDUCACION PRIMARIA TRIMESTRES SAVIA CASTELLA NO ED 2014 ", "EDICIONES SM", false);
		dao.insert(libro);

		libro = new Libro(12312312, "9781380013835", "NEW HIGH FIVE 1 PUPILS BOOK PACK ", " MACMILLAN CHILDRENS BOOKS",false);
		dao.insert(libro);

		libro = new Libro(124324325, "9781380011718", "NEW HIGH FIVE 3 PUPILS BOOK", " MACMILLAN CHILDRENS BOOKS",false);
		dao.insert(libro);

	} 
	
	private static void pintarMenu() { 
		
		System.out.println("------------------------------------");
		System.out.println("--          Libros               --");
		System.out.println("------------------------------------");
		System.out.println("-    1.- Listar Prestado            -");
		System.out.println("-    2.- Listar no prestado         -");
		System.out.println("-    3.- Buscar por titulo          -");
		System.out.println("-    4.- salir                     -");
		System.out.println("------------------------------------");
		System.out.print("Elige una opcion:");
		
		
	
		try {
			opcionSeleccionada = sc.nextInt();
			sc.nextLine();
		}catch (Exception e) {
			sc.nextLine();
			System.out.println("OPCION NO VALIDA, Por favor introduzca un numero del menu");
			pintarMenu();
		}
	
	}
	/**********
	 * METODOS
	 **********/
	
	public static void listarPrestados(int opcion) {
		if(opcion==OPCION_LISTAR_PRESTADO) {
			//Listar prestados
			System.out.println("--    Lista  prestados    --");
			System.out.println(dao.getAllPrestados(true));
		}else{
			//Listar los no prestados
			System.out.println("--  Lista no prestados    --");
			System.out.println(dao.getAllPrestados(false));
		}
	}
	
	public static void buscarLibro() {
		
		Scanner sc=new Scanner(System.in);
		String buscar;
		
		System.out.println("Introduce el titulo del nombre a buscar:");
		buscar=sc.nextLine();
		List<Libro> resul =dao.buscarPorTitulo(buscar);
		
		
	}
}
