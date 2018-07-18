package com.ipartek.formacion.videos;

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
	static private final int OPCION_SALIR = 0;
	static private final int OPCION_LISTAR_PRESTADO = 1;
	static private final int OPCION_LISTAR_NO_PRESTADO = 2;
	static private final int OPCION_BUSCADOR = 3;
	
	public static void main(String[] args) {
		
		sc = new Scanner(System.in);
		dao = LibrosArrayDAO.getInstance();
		
		//Cargamos el pojo y pintamos el menu
		//cargarLibros();
		pintarMenu();
		
		switch (opcionSeleccionada) {
		case OPCION_LISTAR_PRESTADO:
			//listar_prestado();
			break;
		
		case  OPCION_LISTAR_NO_PRESTADO:
			//listar_no_prestado();
			break;
		
		case OPCION_SALIR:
			salir();
			break;	
			
		default:
			noOption();
			break;
		}
		
		
		sc.close();
	}

	
	/*private static void cargarLibros() {
		//TODO MIRAR ESTO BIEN PORQUE ESTA MAL ¿NO SE ELQUE?
		Libro nuevo_libro = new Libro("FARIÑA: HISTORIA E INDISCRECIONES DEL NARCOTRAFICO EN GALICIA"," LIBROS DEL K.O", 9788416001460,1,true);
		dao.insert(nuevo_libro);
		
		nuevo_libro = new Libro();
		dao.insert(nuevo_libro);

	}*/
	
	private static void pintarMenu() { // throws Exception, NullPointerException{
		
	
		
		System.out.println("------------------------------------");
		System.out.println("--          Libros               --");
		System.out.println("------------------------------------");
		System.out.println("-    1. Listar Prestado            -");
		System.out.println("-    2. Listar no prestado         -");
		System.out.println("-    3. Buscar por titulo          -");
		System.out.println("-                                  -");
		System.out.println("-    0 - salir                     -");
		System.out.println("------------------------------------");
		System.out.println("");
		System.out.println("Dime una opcion por favor");
		
		opcionSeleccionada = sc.nextInt();
		
		try {			
			opcionSeleccionada = sc.nextInt();
		}catch (Exception e) {
			// e.printStackTrace();   pinta la pila de excepcion
			sc.nextLine();
			System.out.println("OPCION NO VALIDA, Por favor introduce un numero del menu");
			pintarMenu();
		}
			

	}
	
	/*private static void listar() {
		
		for ( Libro libros_biblio : dao.getAll() ) {
			System.out.println("    " + libros_biblio);
		}
		
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		pintarMenu();
		
	}
	*/
	
	private static void salir() {
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("AGUR VENUR, esperamos verte pronto");
		
	}

	private static void noOption() {
		System.out.println("Lo sentimos No existe esa opcion");
		pintarMenu();
		
	}
}
