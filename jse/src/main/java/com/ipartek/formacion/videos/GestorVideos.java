package com.ipartek.formacion.videos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import com.ipartek.formacion.model.VideoYoutubeArrayDAO;
import com.ipartek.formacion.pojo.VideoYoutube;

public class GestorVideos {

	static private VideoYoutubeArrayDAO dao;
	static private int opcionSeleccionada = 0;
	static Scanner sc = null;
	static BufferedReader br = null;
	
	static private final int OPCION_SALIR = 0;
	static private final int OPCION_LISTAR = 1;
	static private final int OPCION_ANADIR = 2;
	static private final int OPCION_ELIMINAR = 3;
	static private final int TITULO_MINIMO = 3;
	static private final int TITULO_MAXIMO = 254;
	static private final int CARACTERES_CODIGO = 11;
	static private int CONTADOR = 0;
	
	
	public static void main(String[] args) {
				
		try {
			sc = new Scanner(System.in);
			
			br = new BufferedReader(new InputStreamReader(System.in));
			
			dao = VideoYoutubeArrayDAO.getInstance();
			
			cargarVideos();
			
			pintarMenu();

			opcionElegida();
			
		} catch (Exception e) {
			System.out.println("Lo sentimos, ha habido un error.");
		}		
		
		finally {
			
			if (sc != null) {
				sc.close();
			}
			dao = null;
		}
		
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
		
		if(dao.getAll().isEmpty()) {
			System.out.println("No hay videos para listar, por favor añade uno nuevo");
			pintarMenu();
			opcionElegida();
		}
		else {
		
			for ( VideoYoutube video : dao.getAll() ) {
				System.out.println("    " + video);
			}
			
			System.out.println("");
			System.out.println("");
			System.out.println("");
			
			pintarMenu();
			opcionElegida();
		
		}
		
	}
	
	//T�tulo mayor que 3 y menor que 254 caracteres, el c�digo 11 caracteres.
	private static void anadir() {
		
		VideoYoutube video = new VideoYoutube();
		long id = ++CONTADOR;
		String titulo = "";
		String codigo;
		
		video.setId(id);
		
		do {
			System.out.println("Introduce un t�tulo (de 3 a 254 caracteres)");
			try {
				titulo = br.readLine();
			} catch (IOException e) {
				System.out.println("Lo sentimos, ha sucedido un error inesperado.");
			}
		} while (titulo.length() <= TITULO_MINIMO || titulo.length() >= TITULO_MAXIMO);
		
		video.setTitulo(titulo);		
		
		do {
			System.out.println("Introduce un c�digo (de 11 caracteres)");
			codigo = sc.next();
		} while (codigo.length() != CARACTERES_CODIGO);
		
		video.setCodigo(codigo);
		
		dao.insert(video);
		
		if(dao.getAll().size() == CONTADOR) {
			System.out.println("\nVideo introducido correctamente\n");
		}

		pintarMenu();
		opcionElegida();
		
	}
	
	private static void eliminar() {
		
		long id;
		
		if(dao.getAll().isEmpty()) {
			System.out.println("No hay videos en la lista, por favor añade uno nuevo");
			pintarMenu();
			opcionElegida();
		}
		else {
		
			System.out.println("Introduce la id del video a eliminar");
			try {
				//dao.delete(sc.nextLong());
				id = sc.nextLong();
				
				while(dao.getById(id) == null) {
					System.out.println("No puede eliminar algo que no existe");
					System.out.println("Introduzca otra id");
					id = sc.nextLong();
				}
				
				dao.delete(id);
				
			} catch (Exception e) {
				System.out.println("La id debe ser un n�mero entero");
			}
			
			if(CONTADOR - 1 == dao.getAll().size()) {
				System.out.println("Video eliminado correctamente");
			}
			
			pintarMenu();
			opcionElegida();
		
		}
		
	}


	private static void cargarVideos() {
		VideoYoutube video = new VideoYoutube(++CONTADOR, "Nightmares On Wax Boiler Room London DJ Set", "Q692lHFaLVM");
		dao.insert(video);
		
		video = new VideoYoutube(++CONTADOR, "The Skatalites - Rock Fort Rock", "6bLVdKbPHHY");
		dao.insert(video);
				
	}


	private static void pintarMenu() {//throws Exception{
		
		System.out.println("------------------------------------");
		System.out.println("--          youtube               --");
		System.out.println("------------------------------------");
		System.out.println("-    1. Listar                     -");
		System.out.println("-    2. A�adir Nuevo               -");
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