package com.ipartek.formacion.ejercicios.video;

import java.util.List;
import java.util.Scanner;

import com.ipartek.formacion.model.VideoYoutubeArrayDAO;
import com.ipartek.formacion.pojo.Youtube;

public class GestorVideo {

	private static Scanner sr = new Scanner(System.in);

	static private final int OPCION_SALIR = 0;
	static private final int OPCION_LISTAR = 1;
	static private final int OPCION_ANADIR = 2;
	static private final int OPCION_ELIMINAR = 3;

	public static void main(String[] args) {

		VideoYoutubeArrayDAO dao = VideoYoutubeArrayDAO.getIntance();

		int opcion = 0;

		do {

			mostrarMenu();

			opcion = sr.nextInt();
			sr.nextLine();

			switch (opcion) {
			case OPCION_LISTAR:

				List<Youtube> videos = dao.getAll();
				mostrarLista(videos);
				break;

			case OPCION_ANADIR:

				Youtube nuevoVideo = crearNuevoYoutube();
				dao.insert(nuevoVideo);
				break;

			case OPCION_ELIMINAR:

				System.out.println("Ingrese por favor el ID del video que quieres borrar");
				long id = sr.nextLong();
				dao.delete(id);
				break;

			case OPCION_SALIR:

				System.out.println("Gracias por tu visita a nuestra aplicacion ");
				break;

			default:
				System.out.println("Has ingresado un numero ERRONEO");
			}

		} while (opcion != OPCION_SALIR);

	}

	private static void mostrarMenu() {
		System.out.println("Selecciona una opci�n:");
		System.out.println("1 - Listar");
		System.out.println("2 - Anadir");
		System.out.println("3 - Eliminar");
		System.out.println("0 - Salir");

	}

	private static void mostrarLista(List<Youtube> videos) {

		for (int i = 0; i < videos.size(); i++) {
			Youtube vid = videos.get(i);
			System.out.println(vid.toString());
		}

	}

	private static Youtube crearNuevoYoutube() {

		System.out.println("Ingresa un titulo:");
		String titulo = sr.nextLine();
		System.out.println("Ingresa un codigo:");
		String codigo = sr.nextLine();

		Youtube nuevoVideo = new Youtube(titulo, codigo);

		return nuevoVideo;
		
	}

}
