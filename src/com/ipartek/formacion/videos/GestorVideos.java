package com.ipartek.formacion.videos;

import java.util.Scanner;
import com.ipartek.formacion.model.VideoYoutubeArrayDAO;
import com.ipartek.formacion.pojo.VideoYoutube;

public class GestorVideos {

	static private VideoYoutubeArrayDAO dao;
	static private int opcionSeleccionada = 0;
	static Scanner sc = null;
	
	static private final int OPCION_SALIR = 0;
	static private final int OPCION_LISTAR = 1;
	static private final int OPCION_ANADIR = 2;
	static private final int OPCION_ELIMINAR = 3;
	
	
	public static void main(String[] args) {
				
		sc = new Scanner(System.in);
		
		dao = VideoYoutubeArrayDAO.getInstance();
		
		cargarVideos();
		
		pintarMenu();

		opcionElegida();		
		
		sc.close();
	}

	
	private static void salir() {
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("AGUR VENUR, esperamos verte pronto");
		
	}


	private static void noOption() {
		System.out.println("Lo sentimos, no existe esa opcion");
		pintarMenu();
		opcionElegida();
		
	}


	private static void listar() {
		
		for ( VideoYoutube video : dao.getAll() ) {
			System.out.println("    " + video);
		}
		
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		pintarMenu();
		opcionElegida();
		
	}
	
	//TODO Título mayor que 3 y menor que 254 caracteres, el código 11 caracteres.
	private static void anadir() {
		
		VideoYoutube video = new VideoYoutube();
		String titulo;
		String codigo;
				
		do {
			System.out.println("Introduce un título (de 3 a 254 caracteres)");
			titulo = sc.next();
		} while (titulo.length() <= 3 || titulo.length() >= 254);
		
		
		
		do {
			System.out.println("Introduce un código (de 11 caracteres)");
			codigo = sc.next();
		} while (codigo.length() != 11);
		
		video.setCodigo(codigo);		
		
		dao.insert(video);

		pintarMenu();
		opcionElegida();
		
	}
	
	private static void eliminar() {
		
		System.out.println("Introduce la id del video que quieres eliminar");
		
		dao.delete(sc.nextLong());
		
		pintarMenu();
		opcionElegida();
		
	}


	private static void cargarVideos() {
		VideoYoutube video = new VideoYoutube(1, "Nightmares On Wax Boiler Room London DJ Set", "Q692lHFaLVM");
		dao.insert(video);
		
		video = new VideoYoutube(2, "The Skatalites - Rock Fort Rock", "6bLVdKbPHHY");
		dao.insert(video);
				
	}


	private static void pintarMenu() {//throws Exception{
		
		System.out.println("------------------------------------");
		System.out.println("--          youtube               --");
		System.out.println("------------------------------------");
		System.out.println("-    1. Listar                     -");
		System.out.println("-    2. Añadir Nuevo               -");
		System.out.println("-    3. Eliminar                   -");
		System.out.println("-                                  -");
		System.out.println("-    0 - salir                     -");
		System.out.println("------------------------------------");
		System.out.println("");
		System.out.println("Dime una opcion por favor");
		
		try {
			opcionSeleccionada = sc.nextInt();
		}catch (Exception e) {
			//e.printStackTrace(); Pinta la fila de excepción
			
			sc.nextLine();
			System.out.println("OPCIÓN NO VÁLIDA, Por favor, introduzca un número del menú");
			
			pintarMenu();
			opcionElegida();
			
		}
		
		
	}


	private static void opcionElegida() {
		switch (opcionSeleccionada) {
		case OPCION_LISTAR:
			listar();
			break;

		case OPCION_ANADIR:
			anadir();
			break;

		case OPCION_ELIMINAR:
			eliminar();
			break;

		case OPCION_SALIR:
			salir();
			break;	
			
		default:
			noOption();
			break;
		}
		
	}
	
}