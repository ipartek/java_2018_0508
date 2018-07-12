package com.ipartek.formacion.gestorDeVideos;

import java.util.Arrays;
import java.util.Scanner;

import com.ipartek.formacion.pojo.VideoYoutube;
import com.ipartek.formacion.util.Utilidades;


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
			videos = addVideo();
			listarVideos();
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
		System.out.println("-------Menu---------");
		System.out.println("1. Listar Videos");
		System.out.println("2. Añadir Video");
		System.out.println("3. Eliminar Video");
		System.out.println("--------------------");
	}

	private static void cargarVideos() {

		// TODO cargar videos
	
	}

	private static void listarVideos() {

		System.out.println("--------------------");
		for (int i = 0; i < videos.length; i++) {
			System.out.println(videos[i].toString());
		}
	}

	private static VideoYoutube[] addVideo() {

		String tit = "";

		// Creamos el nuevo video
		tit = Utilidades.leerString(sc);
		VideoYoutube v = new VideoYoutube();
		
		//	Creamos un nuevo array con una posición más
		videos  = Arrays.copyOf(videos, videos.length + 1);
		videos[videos.length - 1] = v;
	    return videos;
		
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
