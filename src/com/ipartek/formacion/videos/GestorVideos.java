package com.ipartek.formacion.videos;

import java.io.IOException;
import java.util.Scanner;

import com.ipartek.formacion.model.VideoYoutubeArrayDAO;
import com.ipartek.formacion.pojo.VideoYoutube;

public class GestorVideos {

	// TODO insertar las canciones, mostrar por pantalla las canciones
	// TODO recuperar la cancion 5397
	// TODO eliminar la cancion pintxo pintxo, luego por pantalla
	// TODO cambiar nombre, volver a mostrar por pantalla

	static VideoYoutubeArrayDAO dao;

	private static final int opcMinima = 1;
	private static final int opcMaxima = 3;
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		dao = VideoYoutubeArrayDAO.getInstance();

		cargarVideos();

		pintarMenu();

		int opc = opcion();

		switch (opc) {
		case 1:
			listarVideos();
			break;

		case 2:
			eliminarVideo();
			break;

		case 3:
			modficarVideo();
		default:
			System.out.println("Adios!!!!");
			break;
		}

		sc.close();
	}

	private static void cargarVideos() {

		VideoYoutube video = new VideoYoutube(1, "yuFI5KSPAt4",
				"Red Hot Chili Peppers - Snow (Hey Oh) (Official Music Video)");
		dao.insert(video);
		dao.insert(new VideoYoutube(2, "hTWKbfoikeg", "Nirvana - Smells Like Teen Spirit"));
		dao.insert(new VideoYoutube(3, "iywaBOMvYLI", "System Of A Down - Toxicity"));
		dao.insert(new VideoYoutube(4, "1V_xRb0x9aw", "Gorillaz - Clint Eastwood (Official Video)"));
		dao.insert(new VideoYoutube(5, "LPHJLB1ZeAc", "BODY COUNT - Raining In Blood (OFFICIAL VIDEO)"));
	}

	private static void pintarMenu() {

		System.out.println("-------------");
		System.out.println("---Youtube---");
		System.out.println("-------------");
		System.out.println("--1. Listar--");
		System.out.println("-------------");
		System.out.println("-2. Eliminar-");
		System.out.println("-------------");
		System.out.println("-3. Modificar-");
		System.out.println("-------------");
		System.out.println("--4. Pintar--");
		System.out.println("-------------");
	}

	private static int opcion() throws IOException {

		int opc;

		do {

			System.out.println("Elige una opcion:");
			opc = sc.nextInt();

			if (opc > opcMaxima || opc < opcMinima) {
				System.out.println("No existe la opcion, vuelve a probar.");
			}
			System.in.read();
		} while (opc > opcMaxima || opc < opcMinima);

		return opc;

	}

	private static void listarVideos() {

		System.out.println(dao.getAll());

	}

	private static void eliminarVideo() throws IOException {

		long id;

		System.in.read();
		System.in.read();

		System.out.println("Dime el id de una cancion para borrarla...");
		id = (long) sc.nextInt();

		dao.delete(id);

		listarVideos();

	}

	private static void modficarVideo() {

		System.out.println("Dime el video a modificar:");
		long id = (long) sc.nextInt();

		VideoYoutube video = dao.getById(id);

		System.out
				.println("Que quieres modificar:\n1.-Titulo:" + video.getTitulo() + "\n2.-Codigo:" + video.getCodigo());
		int opc = sc.nextInt();

		switch (opc) {
		case 1:
			System.out.println("Escribe el nuevo titulo:");
			String titulo = sc.next();
			video.setTitulo(titulo);
			break;

		case 2:
			System.out.println("Escribe el nuevo codigo:");
			String codigo = sc.next();
			video.setTitulo(codigo);
			break;
		default:
			System.out.println("No quieres modificar nada.");
			break;
		}

		dao.update(video);

		listarVideos();

	}

}
