package com.ipartek.formacion.gestorDeVideos;

import java.util.Scanner;

import com.ipartek.formacion.pojo.VideoYoutube;

public class GestorDeVideos {

	static VideoYoutube[] videos = new VideoYoutube[5];
	static Scanner sc = new Scanner(System.in);
	static long id;

	public static void main(String args[]) {

		int op;

		cargarVideos();
		pintarMenu();

		op = sc.nextInt();

		switch (op) {
		case 1:
			listarVideos();
			break;
		case 2:
			addVideo();
			break;
		case 3:
			eliminarVideo();
			break;
		}
	}

	private static void pintarMenu() {

		// TODO pintar Menu
		System.out.println("--------------------");
		System.out.println("----- YOUTUBE ------");
		System.out.println("--------------------");
		System.out.println("1. Listar Videos");
		System.out.println("2. Añadir Video");
		System.out.println("3. Eliminar Video");
		System.out.println("--------------------");
	}

	private static void cargarVideos() {

		// TODO cargar videos
		
		VideoYoutube v = new VideoYoutube("Video de Prueba 1");
		videos[0] = v;
		
		v = new VideoYoutube("Video de Prueba 2");
		videos[1] = v;
		
		v = new VideoYoutube("Video de Prueba 3");
		videos[2] = v;
		
		v = new VideoYoutube("Video de Prueba 4");
		videos[3] = v;
		
		v = new VideoYoutube("Video de Prueba 5");
		videos[4] = v;

	}

	private static void listarVideos() {

		System.out.println("--------------------");
		for (int i = 0; i < videos.length; i++) {
			System.out.println(videos[i].toString());
		}
	}

	private static void addVideo() {

		String tit = "";

		while (sc.nextLine() == null) {
			System.out.println("Introduce título: ");
			tit = sc.nextLine();
		}
		
		VideoYoutube[] tmp = new VideoYoutube[videos.length + 1];
		VideoYoutube v = new VideoYoutube(tit);
		tmp[videos.length + 1] = v;

		videos = tmp;
	}

	private static void eliminarVideo() {

		String cod;
		VideoYoutube[] tmp = new VideoYoutube[videos.length - 1];
		int size = 0;

		listarVideos();
		System.out.println("Teclea el código del video que quieres eliminar: ");
		cod = sc.nextLine();

		for (int i = 0; i < videos.length; i++) { // Ponemos a NULL el video en el array
			if (videos[i].getCodigo().equalsIgnoreCase(cod)) {
				videos[i] = null;
			}
		}

		for (int i = 0; i < tmp.length; i++) { //Limpiamos el NULL
			if (videos[i] != null) {
				tmp[size] = videos[i];
				size++;
			}
		}

		videos = tmp;

	}

}
