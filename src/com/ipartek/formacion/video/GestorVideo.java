package com.ipartek.formacion.video;

import java.util.List;
import java.util.Scanner;

import com.ipartek.formacion.model.VideoYoutubeArrayDAO;
import com.ipartek.formacion.pojo.Youtube;

public class GestorVideo {

	private static Scanner p = new Scanner(System.in);

	public static void main(String[] args) {

		VideoYoutubeArrayDAO ytDAO = VideoYoutubeArrayDAO.getIntance();

		int opcion = 0;

		do {

			mostrarMenu();

			opcion = p.nextInt();
			p.nextLine();

			switch (opcion) {
			case 1:

				List<Youtube> videos = ytDAO.getAll();

				mostrarLista(videos);
				break;
			case 2:
				Youtube nuevoVideo = crearNuevoYoutube();
				ytDAO.insert(nuevoVideo);
				break;
			case 3:
				System.out.println("Ingrese el ID del video que quieres borrar");

				long id = p.nextLong();

				ytDAO.delete(id);

				break;
			case 0:
				System.out.println("Gracias ");
				break;
			default:
				System.out.println("Has ingresado un numero ERRONEO");
			}
		} while (opcion != 0);

	}

	private static void mostrarMenu() {
	
		System.out.println("1 - Listar");
		System.out.println("2 - Añadir");
		System.out.println("3 - Eliminar");
		System.out.println("0 - Salir");
		System.out.println("Selecciona una opción:");
	}

	private static void mostrarLista(List<Youtube> videos) {

		for (int i = 0; i < videos.size(); i++) {
			Youtube vid = videos.get(i);
			System.out.println(vid.toString());
		}

	}

	private static Youtube crearNuevoYoutube() {
		System.out.println("Ingresa un titulo:");
		String titulo = p.nextLine();
		System.out.println("Ingresa un codigo:");
		String codigo = p.nextLine();

		Youtube nuevoVideo = new Youtube(titulo, codigo);

		return nuevoVideo;
	}

}
