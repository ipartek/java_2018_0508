package com.ipartek.formacion.gestorDeVideos;

import java.util.Scanner;

import com.ipartek.formacion.model.VideoYoutubeArrayDAO;

public class GestorDeVideos {

	static VideoYoutubeArrayDAO videos;
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
		// TODO listar videos
	}

	private static VideoYoutubeArrayDAO addVideo() {
		// TODO añadir video
		return videos;
	}

	private static void eliminarVideo() {
		// TODO eliminar video

	}

}
