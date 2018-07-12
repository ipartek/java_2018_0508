package com.ipartek.formacion.videos;

import java.util.Scanner;

import com.ipartek.formacion.pojo.VideoYoutube;

public class GestorVideos {
	
	public static final int opcMinima = 1;
	public static final int opcMaxima = 1;

	static VideoYoutube[] videos = new VideoYoutube[5];

	public static void main(String[] args) {

		cargarVideos();

		pintarMenu();

		int opc = opcion();
		
		switch (opc) {
		case 1:
			listarVideos();
			break;

		default:
			System.out.println("Adios!!!!");
			break;
		}
	}

	private static void cargarVideos() {

		videos[0] = new VideoYoutube(1, "yuFI5KSPAt4", "Red Hot Chili Peppers - Snow (Hey Oh) (Official Music Video)");
		videos[1] = new VideoYoutube(2, "hTWKbfoikeg", "Nirvana - Smells Like Teen Spirit");
		videos[2] = new VideoYoutube(3, "iywaBOMvYLI", "System Of A Down - Toxicity");
		videos[3] = new VideoYoutube(4, "1V_xRb0x9aw", "Gorillaz - Clint Eastwood (Official Video)");
		videos[4] = new VideoYoutube(5, "LPHJLB1ZeAc",
				"BODY COUNT - Raining In Blood / Postmortem 2017 (OFFICIAL VIDEO)");
	}

	private static void pintarMenu() {
		// TODO pintar el menu

		System.out.println("-------------");
		System.out.println("---Youtube---");
		System.out.println("-------------");
		System.out.println("--1. Pintar--");
	}

	private static int opcion() {

		int opc;
		Scanner sc = new Scanner(System.in);
		do {
			
			System.out.println("Elige una opcion:");
			opc = sc.nextInt();
			
			if(opc>opcMaxima || opc<opcMinima) {
				System.out.println("No existe la opcion, vuelve a probar.");
			}
		} while (opc>opcMaxima || opc<opcMinima);

		sc.close();
		return opc;

	}
	
	private static void listarVideos() {

		for (int i = 0; i < videos.length; i++) {
			System.out.println(videos[i]);
		}
		
	}

}
