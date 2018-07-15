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
public class GestorDeVideos {

	static private VideoYoutubeArrayDAO dao;
	static private int opcionSeleccionada = 0;
	static Scanner sc = null;

	static private final int OPCION_SALIR = 0;
	static private final int OPCION_LISTAR = 1;
	static private final int OPCION_ANADIR = 2;
	static private final int OPCION_ELIMINAR = 3;

	public static void main(String args[]) {

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
		} while (opcionSeleccionada != OPCION_SALIR);

	}

	private static void noOption() {

		System.out.println("La opción seleccionada no existe.");
		pintarMenu();

	} // FIN noOption();

	private static void cargarVideos() {

		VideoYoutube video = new VideoYoutube(12650, "Crystallion - Crystal Clear", "qllRVZnpttM");
		dao.insert(video);

		video = new VideoYoutube(701, "Crystallion - Burning Bridges", "MSRvZ-YSlZI");
		dao.insert(video);

	} // FIN cargarVideos();

	private static void listar() {

		for (VideoYoutube video : dao.getAll()) {
			System.out.println("    " + video);
		}
		System.out.println("");
		System.out.println("");
		System.out.println("");

	} // FIN listar();

	private static void salir() {

		System.out.println("");
		System.out.println("");
		System.out.println("");
		sc.close();
		System.out.println("AGUR BEN-HUR, esperamos volver a verte. =)");

	} // FIN salir();

	private static void anadir() {

		long id;
		String tit;
		String cod;

		System.out.print("Teclea un id: ");
		id = sc.nextLong();
		sc.nextLine(); // El método nextLong no salta de línea, debemos hacerlo nosotros

		System.out.print("Teclea un título: ");
		tit = sc.nextLine();

		System.out.print("Teclea un código: ");
		cod = sc.nextLine();

		VideoYoutube v = new VideoYoutube(id, tit, cod);
		System.out.println(dao.insert(v) ? "Video insertado con éxito." : "Error durante la insersción.");

		pintarMenu();

	} // FIN anadir();

	private static void eliminar() {
		long id;

		listar();

		System.out.println("Teclea el id del video que deseas eliminar : ");
		id = sc.nextLong();

		System.out.println(dao.delete(id) ? "Video eliminado con éxito." : "No existe ese video.");

		pintarMenu();

	} // FIN eliminar();

	private static void pintarMenu() {

		System.out.println("------------------------------------");
		System.out.println("--          YOUTUBE               --");
		System.out.println("------------------------------------");
		System.out.println("-    1. Listar                     -");
		System.out.println("-    2. Añadir Nuevo               -");
		System.out.println("-    3. Eliminar                   -");
		System.out.println("-    0. Salir                     -");
		System.out.println("------------------------------------");
		System.out.println("");
		System.out.print("Selecciona una opción: ");

		opcionSeleccionada = sc.nextInt();

	} // FIN pintarMenu();

} // FIN GestorDeVideos
