package com.ipartek.formacion.videos;

import java.io.IOException;
import java.util.InputMismatchException;
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
	static private int id;
	static private String codigo;
	static private String titulo;

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

		} while (opcionSeleccionada != 0);

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
		do {
			
			System.out.println("Introduce el código: ");
			codigo = sc.next();
			if (codigo.length()<11) {
				System.out.println("El código es corto. Tiene contener 11 caracteres");
			} else if(codigo.length()>11){
				System.out.println("El código es grande. Tiene contener 11 caracteres");
			}
			System.out.println("Introduce el titulo: ");
			titulo = sc.next();

			
				VideoYoutube video = new VideoYoutube(id, titulo, codigo);
				dao.insert(video);

			System.out.println("¿Quieres introducir otra cancion?(S/N)");
			contest = (char) System.in.read();
		} while (contest != 'n' && contest != 'N');

		for (VideoYoutube video : dao.getAll()) {
			System.out.println("    " + video);
		}
		pintarMenu();

	}

	private static void eliminar() throws IOException {
		try {
			System.out.println("Introduce el identificador que deseas eliminar: ");
			id = sc.nextInt();
		} catch (InputMismatchException e) {
			sc.nextLine();
			System.out.println("OPCIÓN NO VALIDA. Por favor introduce un número de identificador.\n");
			eliminar();
		}
		System.out.println("Introduce el código que deseas eliminar: ");
		id = sc.nextInt();
		while (dao.getById(id) == null) {

			System.out.println("Ese código no existe.\n");
			System.out.println("Introduce el código que deseas eliminar: ");
			id = sc.nextInt();

		}
		do {
			System.out.println("¿Estas seguro de que deseas borrar la cancion " + dao.getById(id) + " (S/N)?");
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