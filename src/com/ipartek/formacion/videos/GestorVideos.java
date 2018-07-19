package com.ipartek.formacion.videos;

import java.util.Scanner;

import com.ipartek.formacion.model.VideoYoutubeArrayDAO;

import com.ipartek.formacion.pojo.VideoYoutube;

/**
 * Clase GestorDeVideos para gestionar videos utilizando el model
 * VideoYoutubeArrayDAO
 * 
 * @see VideoYoutubeArrayDAO
 * @author Luis
 *
 */
public class GestorVideos {

	static private VideoYoutubeArrayDAO dao;

	private static int cont = 0;

	static private int opcionSeleccionada = -1;
	static Scanner sc; 

	static private final int OPCION_SALIR = 0;
	static private final int OPCION_LISTAR = 1;
	static private final int OPCION_ANADIR = 2;
	static private final int OPCION_ELIMINAR = 3;

	static private final int MIN_LONG_TITULO = 3;
	static private final int MAX_LONG_TITULO = 256;
	static private final int LONG_CODIGO = 11;

	public static void main(String args[]) {

		try {
			System.out.println("------------------------------------");
			System.out.println("--        BIENVENIDO/A            --");

			dao = VideoYoutubeArrayDAO.getInstance();
			sc = new Scanner(System.in);

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

			} while (opcionSeleccionada != OPCION_SALIR);
			
		} catch (Exception e) {
			
			System.out.println("Sentimos las molestias, ha ocurrido un error inesperado.");
		
		} finally {
			if (sc != null) {
				sc.close();
			}
			
			dao = null;
			
		}

	}

	
	private static void noOption() {

		System.out.println("LO SENTIMOS. La opción seleccionada no existe.");

	}

	private static void cargarVideos() throws Exception {

		VideoYoutube video = new VideoYoutube(++cont, "Crystallion - Crystal Clear", "qllRVZnpttM");
		dao.insert(video);

		video = new VideoYoutube(++cont, "Crystallion - Burning Bridges", "MSRvZ-YSlZI");
		dao.insert(video);

	}

	private static void listar() {

		if (dao.getAll().size() > 0) {
			System.out.println("Lista de videos: \n\n");
			for (VideoYoutube video : dao.getAll()) {
				System.out.println("    " + video);
			}
			System.out.println("\n\n\n");
		} else {
			System.out.println("LO SENTIMOS. No hay videos en la lista.");
		}

	}

	private static void salir() {

		System.out.println("");
		System.out.println("");
		System.out.println("");	
		System.out.println("AGUR BEN-HUR. Esperamos volver a verte!!! =)");

	}

	private static void anadir() throws Exception {

		String tit;
		String cod;

		do { // Pedimos t�tulo mientras no sea correcto

			System.out.println("Por favor, introduce un t�tulo de 3 a 254 caracteres para el video: ");
			tit = sc.nextLine();

			if (tit.length() < MIN_LONG_TITULO || tit.length() > MAX_LONG_TITULO) { // T�tulo incorrecto, avisamos
				System.out.println("LO SENTIMOS. El título introducido no es válido.");

			}
		} while (tit.length() < MIN_LONG_TITULO || tit.length() > MAX_LONG_TITULO);

		do { // Pedimos c�digo mientras no sea correcto

			System.out.println("Por favor, introduce un c�digo de 11 caracteres para el video: ");
			cod = sc.nextLine();

			if (cod.length() != LONG_CODIGO) { // Código incorrecto, avisamos

				System.out.println("LO SENTIMOS. El código introducido no es válido.");
			}
		} while (cod.length() != LONG_CODIGO);

		VideoYoutube v = new VideoYoutube(++cont, tit, cod); // Cremos el video con los datos recogidos

		System.out.println(dao.insert(v) ? "Video insertado con �xito."
				: "Lo sentimos, ha ocurrido un error durante la insersción.");

	}

	private static void eliminar() {
		long id;

		//listar();

		System.out.println("Por favor, teclea el id del video que deseas eliminar : ");
		try {

			id = sc.nextLong();
			System.out.println(dao.delete(id) ? "Video eliminado con Exito." : "No existe ese video.");

		} catch (Exception e) {

			System.out.println("ID NO VÁLIDA. Por favor, teclea un ID númerico correcto.");
			sc.nextLine();
			eliminar();

		} finally {
			sc.nextLine();
		}

	} // FIN eliminar();

	private static void pintarMenu() {

		System.out.println("------------------------------------");
		System.out.println("--          YOUTUBE               --");
		System.out.println("------------------------------------");
		System.out.println("-    1. Listar                     -");
		System.out.println("-    2. Añadir Nuevo               -");
		System.out.println("-    3. Eliminar                   -");
		System.out.println("-    0. Salir                      -");
		System.out.println("------------------------------------");
		System.out.println("");
		System.out.print("Por favor, selecciona una opción: ");

		try {
			opcionSeleccionada = sc.nextInt();

		} catch (Exception e) {
			//LOGGER
		} finally {

			sc.nextLine();
		}

	}

}