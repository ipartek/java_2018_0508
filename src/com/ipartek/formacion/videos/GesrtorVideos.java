package com.ipartek.formacion.videos;

import java.util.Scanner;

import com.ipartek.formacion.pojo.VideoYoutube;

public class GesrtorVideos {

	static VideoYoutube[] videos = new VideoYoutube[5];

	public static void main(String[] args) {
		cargarVideos();
		pintarMenu();

	}

	public static void pintarMenu() {

		System.out.println("----------------------");
		System.out.println("       YOUTUBE        ");
		System.out.println("----------------------");
		System.out.println("1.Listar");
		System.out.println("2.Añadir");
		System.out.println("3.Mostrar");
		Scanner teclado = new Scanner(System.in);
		System.out.print("Opción: ");
		int opc = teclado.nextInt();
		teclado.close();
		switch (opc) {
		case 1:
			listarVideos();
			break;
		case 2:
			System.out.println("Crear un video");

			break;
		case 3:

			break;

		default:
			break;
		}
	}

	public static void cargarVideos() {
		for (int i = 0; i < videos.length; i++) {
			VideoYoutube video = new VideoYoutube();
			videos[i] = video;
		}
	}

	public static void listarVideos() {
		for (int i = 0; i < videos.length; i++) {
			videos[i].toString();
			System.out.println();
		}
	}
	
	public static void crearVideo() {
		Scanner teclado = new Scanner(System.in);
		VideoYoutube video = new VideoYoutube();
		System.out.print("Introduce codigo del video: ");
		video.setCodigo(teclado.next());
		System.out.print("Introduce el titulo del video: ");
		video.setTitulo(teclado.next());
	}
	
	
	

	public static void mostrarVideo(VideoYoutube video) {
		video.toString();
	}

	public static boolean existInArray(VideoYoutube video) {
		for (int i = 0; i < videos.length; i++) {
			if (videos[i] == video) {
				return true;
			}
		}
		return false;
	}

	public static void modificarVideo(VideoYoutube video) {
		boolean encontrado = false;
		int i = 0;
		while (!encontrado) {
			if (videos[i].getId() == video.getId()) {
				videos[i] = video;
			}
		}

	}

	public static void borrarVideo(VideoYoutube video) {
		boolean encontrado = false;
		int i = 0;
		while (!encontrado) {
			if (videos[i].getId() == video.getId()) {
				videos[i] = new VideoYoutube();
			}
		}
	}

	public static void borrarVideos(VideoYoutube video) {

		for (int i = 0; i < videos.length; i++) {
			videos[i] = new VideoYoutube();
		}
	}

}
