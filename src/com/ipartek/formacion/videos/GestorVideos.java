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
		
		
		switch (opcionSeleccionada) {
		case OPCION_LISTAR:
			listar();
			break;
			
		case OPCION_ANADIR:
			anadirVideo();
			break;
			
		case OPCION_ELIMINAR:
			eliminarVideo();
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


	private static void listar() {
		
		for ( VideoYoutube video : dao.getAll() ) {
			System.out.println("    " + video);
		}
		
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		pintarMenu();
		
	}
	
	private static void anadirVideo() {
		
		String titulo;
		int codigo;
		int id;
		
		// titulo: 3-254 de longitud, codigo: max 11 caracteres 
		System.out.println("Introduce el nombre del video que deseas añadir: ");
		titulo= sc.nextLine();
		
		if(titulo.getBytes().length < 3 && titulo.getBytes().length > 254 ) {
			System.out.println("Por favor, introduzca un nombre de entre 3 y 245 caracteres de longitud: ");
			titulo= sc.nextLine();
		}
		
		if((titulo.getBytes().length) > 3 && (titulo.getBytes().length < 254 )){
			
	
		System.out.println("Introduce un codigo de maximo 11 caracteres: ");
		codigo= sc.nextInt();
		
		
	    System.out.println("Introduce la id: ");
		id= sc.nextInt();
		
		
		VideoYoutube video= new VideoYoutube();
		dao.insert(video);	
		
		System.out.println("Su video ha sido añadido");
		
		}
	
	}
	
	private static void eliminarVideo() {
		
		int id;
		
		System.out.println("Introduzca la id del video que desea eliminar");
		id= sc.nextInt();
		
		dao.delete(id);
		
		System.out.println("Su video ha sido eliminado");
		
	}


	private static void cargarVideos() {
		VideoYoutube video = new VideoYoutube(12650, "Nightmares On Wax Boiler Room London DJ Set", "Q692lHFaLVM");
		dao.insert(video);
		
		video = new VideoYoutube(701, "The Skatalites - Rock Fort Rock", "6bLVdKbPHHY");
		dao.insert(video);
		
		
	}


	private static void pintarMenu() { //throws Exception
		
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
			
		opcionSeleccionada = sc.nextInt(); //puede que el usuario meta texto en vez de numeros
		}                                  //por ello hacemos un try and catch 
		catch(Exception e) {
			//e.printStackTrace(); pinta la pila de excepcion
			sc.nextLine();
			System.out.println("OPCION NO VALIDA. Por favor introduce un numero del menu");
			pintarMenu();
		}
		
	}
	
}