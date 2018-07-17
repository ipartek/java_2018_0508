package com.ipartek.formacion.model;

/**
 * Gestor de videos que Lista, Añade y Elimina videos
 */
import java.io.IOException;
import java.util.Scanner;

import com.ipartek.formacion.model.VideoYoutubeArrayDAO;

public class GestorVideos {

	static private VideoYoutubeArrayDAO dao;
	static private int opcionSeleccionada = 0;
	static Scanner sc = null;

	static private final int OPCION_SALIR = 0;
	static private final int OPCION_LISTAR = 1;
	static private final int OPCION_ANADIR = 2;
	static private final int OPCION_ELIMINAR = 3;

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

			case OPCION_ANADIR:
				anadirVideos();
				break;

			case OPCION_ELIMINAR:
				eliminarVideos();
				break;

			case OPCION_SALIR:
				salir();
				break;

			default:
				noOption();
				break;
			}

		} while (opcionSeleccionada != OPCION_SALIR);

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

		for (VideoYoutube video : dao.getAll()) {
			System.out.println("    " + video);
		}

		System.out.println("");
		System.out.println("");
		System.out.println("");

		pintarMenu();

	}

	private static void mostrar() {

		for (VideoYoutube video : dao.getAll()) {
			System.out.println("    " + video);
		}
	}

	private static void eliminarVideos() throws IOException {
		int idVideo = 0;
		char seguir;

		do {

			System.out.println("Deseas ELIMINAR algun video?(s/n)");
			seguir = (char) System.in.read();

			if (seguir != 'n') {
				if (dao.getAll().size() > 0) {

					System.out.println("Selecciona un video a ELIMINAR(Introduce su id): ");
					mostrar();

					try {
						idVideo = sc.nextInt();
					} catch (Exception e) {
						sc.nextLine();
						System.out.println("¡OPCION NO VALIDA! Porfavor introduce un numero!!");
						eliminarVideos();
					}

					if (dao.getAll().size() <= 0) {
						System.out.println("LO SENTIMOS NO HAY NINGUN VIDEO EN LA LISTA AÑADE UNO NUEVO");
					} else {
						System.out.println("Eliminando video seleccionado...");
						dao.delete(idVideo);
						mostrar();
					}

				}else {
					System.out.println("LO SENTIMOS NO HAY NINGUN VIDEO EN LA LISTA AÑADE UNO NUEVO");
					pintarMenu();
				}
			}//(s/n)

		} while (seguir != 'n');

		pintarMenu();
	}

	private static void anadirVideos() throws IOException {

		char seguir;
		int id = 2;

		do {

			String titulo = "";
			String codigo = "";

			do {
				System.out.println("Introduce el TITULO del video que deseas añadir:");
				titulo = sc.nextLine();
			} while (titulo.getBytes().length > 24 || titulo.getBytes().length < 3);

			titulo.trim();

			do {
				System.out.println("Introduce el CODIGO del video que deseas añadir(11 caracteres):");
				codigo = sc.nextLine();
			} while (codigo.getBytes().length != 11); // codigo.isEmpty() == true

			id++;

			VideoYoutube video = new VideoYoutube(id, titulo, codigo);
			dao.insert(video);

			System.out.println("Tu video ha sido añadido");
			mostrar();

			System.out.println("Deseas AÑADIR algun video mas(s/n)");
			seguir = (char) System.in.read();

		} while (seguir != 'n');
		pintarMenu();

	}

	private static void cargarVideos() {
		VideoYoutube video = new VideoYoutube(1, "Nightmares On Wax Boiler Room London DJ Set", "Q692lHFaLVM");
		dao.insert(video);

		video = new VideoYoutube(2, "The Skatalites - Rock Fort Rock", "6bLVdKbPHHY");
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
			// e.printStackTrace();
			sc.nextLine();
			System.out.println("¡OPCION NO VALIDA! Porfavor introduce un numero del menu");
			pintarMenu();
		}

	}

}