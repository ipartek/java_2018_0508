package com.ipartek.formacion.videos;

import java.util.Scanner;

import com.ipartek.formacion.pojo.VideoYoutube;

public class GestorDeVideos {
	static Scanner sc = new Scanner(System.in);
	static VideoYoutube[] videos = new VideoYoutube[5];

	public static void main(String[] args) {

		cargarVideo(videos);
		pintarMenu();

	}

	private static void cargarVideo(VideoYoutube[] videos) {

		videos[0] = new VideoYoutube(0, "Manifiesto", "3A2KtOXRpOo");
		videos[1] = new VideoYoutube(1, "Vivir para contarlo", "brwIP1wI-FA");
		videos[2] = new VideoYoutube(2, "Hero of the day", "XkfO8c8MlKU");
		videos[3] = new VideoYoutube(3, "Welcome to the jungle", "o1tj2zJ2Wvg");
		videos[4] = new VideoYoutube(4, "Para los mios", "fp47VcTlwWQ");

	}

	private static void pintarMenu() {

		int opcion = 0;
		System.out.println("----------------------------------");
		System.out.println("--------------youtube-------------");
		System.out.println("----------------------------------");
		System.out.println("    1.Listar                      ");
		System.out.println("    2.Añadir                      ");
		System.out.println("    3.Eliminar                    ");
		System.out.println("    4.Salir                       ");
		System.out.println("----------------------------------");
		System.out.println("Elige una opcion");
		opcion = sc.nextInt();
		switch (opcion) {
		case 1:
			listarVideos();
			pintarMenu();
			break;

		case 2:
			añadirVideo();
			pintarMenu();
			break;

		case 3:
			eliminarVideo();
			pintarMenu();
			break;

		case 4:

			break;

		default:
			break;
		}
	}

	private static void eliminarVideo() {
		// TODO eliminar el video de la lista
		int codElim;
		listarVideos();
		System.out.println("introduce el codigo de video a eliminar");
		codElim = sc.nextInt();
		videos[codElim] = null;

	}

	private static void listarVideos() {
		for (int i = 0; i < videos.length; i++) {
			System.out.println("." + videos[i].toString());
		}

	}

	private static void añadirVideo() {
		String cod;
		String tit = "";
		System.out.println("Introduce el codigo del video");
		cod = sc.nextLine();
		System.out.println("Introduce el titulo del video");
		tit = sc.nextLine();

	}

}
