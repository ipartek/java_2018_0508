package com.ipartek.formacion.videos;

import java.util.Scanner;

import com.ipartek.formacion.model.VideoYoutubeArrayDAO;
import com.ipartek.formacion.pojo.VideoYoutube;

public class GestorVideos {

	static private VideoYoutubeArrayDAO dao;
	static private int opcionSeleccionada = 0;
	static Scanner sc = null;

	static String titulo;
	static long id;
	static String codigo;
	static VideoYoutube video;
	static long cont = 0;

	static private final int OPCION_SALIR = 0;
	static private final int OPCION_LISTAR = 1;
	static private final int OPCION_ANADIR = 2;
	static private final int OPCION_ELIMINAR = 3;


	public static void main(String[] args) {

		sc = new Scanner(System.in);

		dao = VideoYoutubeArrayDAO.getInstance();

		cargarVideos();

		pintarMenu();

		do {
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
		}while(opcionSeleccionada != OPCION_SALIR);
		sc.close();
	}

	/***
	 * Cierra la aplicacion
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

	/***
	 * Muestra por consola todos los videos de la lista
	 */
	private static void listar() {

		for ( VideoYoutube video : dao.getAll() ) {
			System.out.println("    " + video);
		}

		System.out.println("");
		System.out.println("");
		System.out.println("");

		pintarMenu();
	}

	/***
	 * Añade un video a la lista de videos
	 * El titulo del video debe ser mayor de 3 caracteres y menor de 254
	 * El codigo debe ser de 11 caracteres
	 */
	private static void anadir() {
		do {
			System.out.println("Introduce el titulo del video a añadir: ");
			titulo = sc.nextLine().trim();

			if(titulo.length() < 3 || titulo.length() > 254) {
				System.out.println("ERROR. El titulo tiene que ser mayor de 3 caracteres y menor de 254.");
				System.out.println("");
			}else{
				System.out.println("Introduce el codigo del video a añadir: ");
				codigo = sc.next();

				if(codigo.length() != 11) {
					System.out.println("ERROR. El codigo tiene que ser de 11 caracteres");
					System.out.println("");
					sc.nextLine();
				}else {
					video = new VideoYoutube();
					video.setId(cont);
					video.setTitulo(titulo);
					video.setCodigo(codigo);

					dao.insert(video);
					
					cont++;

					System.out.println("Video añadido. "+ video.toString());

					pintarMenu();
				}
			}

		}while(titulo.length() < 3 || titulo.length() > 254 || codigo.length() != 11);
	}

	/***
	 * Borra un video de la lista de videos a traves del ID
	 */
	private static void eliminar() {
		do {
			System.out.println("Introduzca el ID del video que desea borrar: ");
			id = sc.nextLong();
			video = dao.getById(id);
			if(video == null) {
				System.out.println("ERROR. El video que quiere borrar no existe.");
				System.out.println("");
			}else {
				System.out.println("Video borrado: "+video.toString());
				System.out.println("");
				dao.delete(id);				
				pintarMenu();
			}
		}while(video == null);		
	}

	/***
	 * Carga manual de la lista de videos de prueba
	 */
	private static void cargarVideos() {
		VideoYoutube video = new VideoYoutube(12650, "Nightmares On Wax Boiler Room London DJ Set", "Q692lHFaLVM");
		dao.insert(video);

		video = new VideoYoutube(701, "The Skatalites - Rock Fort Rock", "6bLVdKbPHHY");
		dao.insert(video);
	}

	/***
 	* Dibuja en la consola el menu de opciones
 	*/
	private static void pintarMenu() /*throws Exception*/{

		System.out.println("------------------------------------");
		System.out.println("--          youtube               --");
		System.out.println("------------------------------------");
		System.out.println("-    1. Listar                     -");
		System.out.println("-    2. Añadir Nuevo               -");
		System.out.println("-    3. Eliminar                   -");
		System.out.println("-                                  -");
		System.out.println("-    0 - Salir                     -");
		System.out.println("------------------------------------");
		System.out.println("");
		System.out.println("Dime una opcion por favor");

		try {

			opcionSeleccionada = sc.nextInt();

		}catch(Exception e) {
			//e.printStackTrace(); pinta la pila de excepcion
			System.out.println("OPCION NO VALIDA, por favor introduce un numero del menu");
			sc.nextLine();			
			//pintarMenu();
		}finally {
			sc.nextLine();	
		}

	}

}