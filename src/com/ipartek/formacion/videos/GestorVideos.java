package com.ipartek.formacion.videos;

import java.util.Scanner;

import com.ipartek.formacion.model.VideoYoutubeArrayDAO;
import com.ipartek.formacion.pojo.VideoYoutube;

public class GestorVideos {

	static private VideoYoutubeArrayDAO dao;
	static private int opcionSeleccionada = 0;
	static Scanner sc = null;
	static private long idCounter = 0;
	
	static private final int OPCION_SALIR = 0;
	static private final int OPCION_LISTAR = 1;
	static private final int OPCION_ANADIR = 2;
	static private final int OPCION_ELIMINAR = 3;
	
	
	public static void main(String[] args) {
				
		sc = new Scanner(System.in);
		
		dao = VideoYoutubeArrayDAO.getInstance();
		
		cargarVideos();
		
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
				
			case OPCION_ELIMINAR:
				eliminar();
				break;
				
			default:
				noOption();
				break;
			}

		} while (opcionSeleccionada!=OPCION_SALIR);
		
		sc.close();
	}
	
	private static void anadir() {
		
		Scanner sc2 = new Scanner(System.in);
		
		long id;
		String titulo;
		String codigo;
				
		id = idCounter;
		
		do {
			System.out.println("Introduce el titulo del video");
			titulo = sc2.next();
			if ( (titulo.length()<3) || (titulo.length()>254) ) {
				System.out.println("Titulo no valido (debe introducir de 3 a 254 caracdteres alfanumericos)");
			}
		} while ( (titulo.length()<3) || (titulo.length()>254) );
			
		do {
			System.out.println("Introduce el codigo del video");
			codigo = sc2.next();
			if (codigo.length()!=11)
				System.out.println("Codigo no valido (debe introducir 11 caracteres alfanumericos");
		} while (codigo.length()!=11);
		
		VideoYoutube nuevoVideo = new VideoYoutube(id, titulo, codigo);
		
		if (dao.insert(nuevoVideo))
			idCounter++;
		
		sc2.close();
			
	}
	
	private static void salir() {
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("AGUR BEN HUR, esperamos verte pronto");
		
	}


	private static void noOption() {
		System.out.println("Lo sentimos No existe esa opcion");

	}


	private static void listar() {
		
		for ( VideoYoutube video : dao.getAll() ) {
			System.out.println("    " + video);
		}
		
		System.out.println("");
		System.out.println("");
		System.out.println("");
				
	}


	private static void cargarVideos() {
		VideoYoutube video = new VideoYoutube(1, "Nightmares On Wax Boiler Room London DJ Set", "Q692lHFaLVM");
		dao.insert(video);
		++idCounter;
		
		video = new VideoYoutube(2, "The Skatalites - Rock Fort Rock", "6bLVdKbPHHY");
		dao.insert(video);
		++idCounter;
		
	}
	private static void eliminar() {
		long id;

		System.out.println("Por favor, teclea el id del video que deseas eliminar : ");
		try {

			id = sc.nextLong();
			System.out.println(dao.delete(id) ? "Video eliminado con exito." : "No existe ese video.");

		} catch (Exception e) {

			System.out.println("ID NO VALIDA. Por favor, teclea un ID numerico correcto.");
			sc.nextLine();
			eliminar();

		} finally {
			sc.nextLine();
		}

}

	private static void pintarMenu() {
		
		System.out.println("------------------------------------");
		System.out.println("--          youtube               --");
		System.out.println("------------------------------------");
		System.out.println("--    1. Listar                   --");
		System.out.println("--    2. Añadir Nuevo             --");
		System.out.println("--    3. Eliminar                 --");
		System.out.println("--                                --");
		System.out.println("--    0 - salir                   --");
		System.out.println("------------------------------------");
		System.out.println("");
		System.out.println("Dime una opcion por favor");
		
		try {
			opcionSeleccionada = sc.nextInt();
		} catch (Exception e) {
			//e.printStackTrace(); pinta la pila de excepciones
			sc.nextLine();
			System.out.println("OPCION NO VALIDA. Por favor introduce un numero del menu");
			pintarMenu();
		}
		
	}
	
}