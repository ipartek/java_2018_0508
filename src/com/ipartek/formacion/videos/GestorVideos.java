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

	public static final int opcMinima = 1;
	public static final int opcMaxima = 2;

	public static void main(String[] args) {

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
		default:
			System.out.println("Adios!!!!");
			break;
		}
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
		System.out.println("--3. Pintar--");
		System.out.println("-------------");
		System.out.println("--4. Pintar--");
		System.out.println("-------------");
	}

	private static int opcion() {

		int opc;
		Scanner sc = new Scanner(System.in);
		do {

			System.out.println("Elige una opcion:");
			opc = sc.nextInt();

			if (opc > opcMaxima || opc < opcMinima) {
				System.out.println("No existe la opcion, vuelve a probar.");
			}
		} while (opc > opcMaxima || opc < opcMinima);

		sc.close();
		return opc;

	}

	private static void listarVideos() {

		System.out.println(dao.getAll());

	}
	
	private static void eliminarVideo() {
		long id;
		Scanner sc = new Scanner(System.in);
		
//		System.in.read();
//		System.in.read();
		
		System.out.println("Dime el id de una cancion para borrarla...");
		id = (long)sc.nextInt();
		
		dao.delete(id);
		
		listarVideos();
		
		sc.close();
		
	}

}
