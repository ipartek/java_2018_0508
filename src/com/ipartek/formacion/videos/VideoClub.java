package com.ipartek.formacion.videos;

import java.io.IOException;
import java.util.Scanner;

import com.ipartek.formacion.model.VideoYoutubeArrayDAO;
import com.ipartek.formacion.pojo.VideoYoutube;

public class VideoClub {

	static private VideoYoutubeArrayDAO dao;
	static private int opcionSeleccionada = 0;
	static Scanner sc = null;

	static private final int OPCION_SALIR = 0;
	static private final int OPCION_LISTAR = 1;
	static private final int OPCION_ANADIR = 2;
	static private final int OPCION_ELIMINAR = 3;

	static private char contest;

	public static void main(String[] args) throws IOException {

		sc = new Scanner(System.in);

		dao = VideoYoutubeArrayDAO.getInstance();

		cargarVideos();

		pintarMenu();
		
		
		do {
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

		}while (opcionSeleccionada!=0);
		
		
		sc.close();
	}

	private static void salir() {
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("Hasta luego");

	}

	private static void noOption() {
		System.out.println("Lo sentimos. No existe esa opcion");
		pintarMenu();

	}

	private static void listar() {

		for (VideoYoutube video : dao.getAll()) {
			System.out.println("    " + video);
		}

		System.out.println("");
		System.out.println("");
		System.out.println("");

		pintarMenu();

	}

	private static void anadir() throws IOException {
		int num;
		int id;
		String codigo;
		String titulo;

		do {
			do {
				System.out.print("¿Cuantos canciones quieres meter? ");
				num = sc.nextInt();
			} while (num <= 0);
			for (int i = 0; i < num; i++) {
			System.out.println("Introduce el código: ");
			codigo = sc.next();
			System.out.println("Introduce el titulo: ");
			titulo = sc.next();
			
			VideoYoutube video = new VideoYoutube(id, titulo, codigo);
			dao.insert(video);
			}
			

			System.out.println("¿Quieres introducir otra cancion");
			contest = (char) System.in.read();

		} while (contest != 'n' && contest != 'N');
		
		for (VideoYoutube video : dao.getAll()) {
			System.out.println("    " + video);
		}

	}


	private static void eliminar() throws IOException {

		int id;

		System.out.println("Introduce el código que deseas eliminar: ");
		id = sc.nextInt();
		do {
			System.out.println("¿Estas seguro de que deseas borrar la cancion " + dao.getById(id) + "?");
			contest = (char) System.in.read();

		} while (contest != 's' && contest != 'S');

		VideoYoutube video = new VideoYoutube();
		dao.delete(id);

		listar();

		pintarMenu();

	}

	private static void cargarVideos() {
		VideoYoutube video = new VideoYoutube(12650, "Nightmares On Wax Boiler Room London DJ Set", "Q692lHFaLVM");
		dao.insert(video);

		video = new VideoYoutube(701, "The Skatalites - Rock Fort Rock", "6bLVdKbPHHY");
		dao.insert(video);

	}

	private static void pintarMenu() {

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
		} catch (Exception e) {
			// e.printStackTrace(); -->pinta la pila de excepcion
			sc.nextLine();
			System.out.println("OPCIÓN NO VALIDA. Por favor introduce un número del 0 al 1.\n");
			pintarMenu();
		}


	}

}