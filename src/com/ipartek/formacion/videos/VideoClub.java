package com.ipartek.formacion.videos;

import java.io.IOException;
import java.util.ArrayList;
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
	static private final int LONGITUD_CODIGO = 11;
	static private final int LONGITUD_MINIMA_TITULO = 3;
	static private final int LONGITUD_MAXIMA_TITULO = 254;

	static private char contest;
	static private int id;
	static ArrayList<VideoYoutube> videos = new ArrayList<VideoYoutube>();

	public static void main(String[] args) throws IOException {

		sc = new Scanner(System.in);

		dao = VideoYoutubeArrayDAO.getInstance();
		try {
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

			} while (opcionSeleccionada != OPCION_SALIR);
		} catch (Exception e) {
			System.out.println("Ha sucedido un error que intentaremos arreglar cuanto antes.\n");
			System.out.println("Disculpen las molestias.");
		} finally {
			sc.close();
		}

	}

	private static void salir() throws IOException {

			System.out.println("Vuelve pronto.");
			sc.close();
	}

	private static void noOption() {
		System.out.println("Lo sentimos. No existe esa opcion");
		pintarMenu();

	}

	private static void listar() {
		System.out.println("------------------------------------");
		System.out.println("--         MENÚ LISTAR            --");
		System.out.println("------------------------------------\n");
		for (VideoYoutube video : dao.getAll()) {
			System.out.println("Identificador: " + video.getId() + " - Código: " + video.getCodigo() + " - Título: "
					+ video.getTitulo() + "");
		}
		System.out.println("");
		System.out.println("");
		System.out.println("");

		pintarMenu();

	}

	private static void anadir() throws IOException {
		sc.nextLine();
		System.out.println("------------------------------------");
		System.out.println("--         MENÚ AÑADIR            --");
		System.out.println("------------------------------------");
		do {
			VideoYoutube video = new VideoYoutube();

			video.setId(dao.getAll().size() + 1);

			do {
				System.out.print("Inserte un código: ");
				video.setCodigo(sc.next());
				if (video.getCodigo().length() < LONGITUD_CODIGO) {
					System.out.println("La longitud del código es corta. Debe de ser de 11 caracteres.");
				}
				if (video.getCodigo().length() > LONGITUD_CODIGO) {
					System.out.println("La longitud del código es larga. Debe de ser de 11 caracteres.");
				}
			} while (video.getCodigo().length() < LONGITUD_CODIGO || video.getCodigo().length() > LONGITUD_CODIGO);

			do {
				System.out.print("Inserte titulo : ");
				video.setTitulo(sc.next().trim());
				if (video.getTitulo().length() < LONGITUD_MINIMA_TITULO) {
					System.out.println("La longitud del titulo es corta");

				} else if (video.getTitulo().length() > LONGITUD_MAXIMA_TITULO) {
					System.out.println("La longitud del titulo es demasiado largo");

				}
			} while (video.getTitulo().length() < LONGITUD_MINIMA_TITULO
					|| video.getTitulo().length() > LONGITUD_MAXIMA_TITULO);

			dao.insert(video);
			System.out.println("Video guardado.\n");
			System.out.println("¿Quieres introducir otra canción?(S/N)");
			contest = Character.toUpperCase((char) System.in.read());

		} while (contest != 'N');

		pintarMenu();

	}

	private static void eliminar() throws IOException {
		try {
			System.out.println("------------------------------------");
			System.out.println("--        MENÚ ELIMINA            --");
			System.out.println("------------------------------------");
			if (dao.getAll().size() == 0) {
				System.out.println("No existe ninguna canción.\n");
				System.out.println("Debes introducir una nueva canción.");
				anadir();
			} else {
				System.out.println("Introduce el identificador que deseas eliminar: ");
				id = sc.nextInt();
			}
		} catch (InputMismatchException e) {
			sc.nextLine();
			System.out.println("IDENTIFICADOR INCORRECTO. Por favor introduce un valor númerico.\n");
			eliminar();
		}

		while (dao.getById(id) == null) {

			System.out.println("Ese código no existe.\n");
			System.out.println("Introduce el código que deseas eliminar: ");
			id = sc.nextInt();

		}
		do {
			System.out.println("¿Estas seguro de que deseas borrar la cancion " + dao.getById(id) + " (S/N)?");
			contest = Character.toUpperCase((char) System.in.read());

		} while (contest != 'S');

		dao.delete(id);

		if (dao.getAll().size() == 0) {
			System.out.println("No existe ninguna canción.\n");
			System.out.println("Deberas introducir alguna canción.");
		}

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