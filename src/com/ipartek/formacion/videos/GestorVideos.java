package com.ipartek.formacion.videos;

import java.util.ArrayList;
import java.util.Scanner;

import com.ipartek.formacion.model.VideoYoutubeArrayDAO;
import com.ipartek.formacion.pojo.VideoYoutube;

/**
 * 
 * @author andreaperez
 *
 */

public class GestorVideos {

	static Scanner sc = new Scanner(System.in);
	static String continuar = "s";
	static int respuesta;

	static ArrayList<VideoYoutube> videos = new ArrayList<VideoYoutube>();

	public static void main(String[] args) {

		videos.add(new VideoYoutube(1, "Vj1190w58UM", "Uno X Uno", "Manuel Carrasco"));
		videos.add(new VideoYoutube(2, "RgULjdsjiLQ", "Clandestino", "Shakira, Maluma"));
		videos.add(new VideoYoutube(3, "I8oOS73Mpao", "Quiero ser un tronista", "chirigota callejera de Cadiz"));
		videos.add(new VideoYoutube(4, "RgULjdsjiLQ", "Lo Malo", "Aitana, Ana Guerra"));
		videos.add(new VideoYoutube(5, "RgULjdsjiLQ", "No vaya a ser", "Pablo Alboran"));

		do {
			pintarMenu();
			System.out.print("Inserta el numero de la opcion deseada:");
			respuesta = sc.nextInt();
			switch (respuesta) {
			case 1:
				listaVideo(videos);
				break;
			case 2:
				agregarVideo();
				break;
			case 3:
				eliminaElement();
				break;
			case 4:
				System.out.println(" ADIOS!! ");
				break;

			}

		} while (respuesta != 0);

	}

	private static void pintarMenu() {

		// TODO pintar menu
		System.out.println("------------------------------------");
		System.out.println("--          youtube               --");
		System.out.println("------------------------------------");
		System.out.println("------------------------------------");
		System.out.println("    1. Listar");
		System.out.println("------------------------------------");
		System.out.println("    2. Agregar");
		System.out.println("------------------------------------");
		System.out.println("    3. Eliminar");
		System.out.println("------------------------------------");
		System.out.println("    4. salir");

	}

	private static void listaVideo(ArrayList<VideoYoutube> videos) {

		for (VideoYoutube listVideos : VideoYoutubeArrayDAO.getInstance().getALl()) {
			System.out.println(listVideos);
		}
	}

	private static void agregarVideo() {
		long cont = 1;
		System.out.println("\n");
		System.out.println(" - INSERTANDO VIDEOS - ");

		do {

			VideoYoutube v = new VideoYoutube();

			v.setId(cont);
			System.out.print("inserte autor: ");
			v.setAutor(sc.next());

			System.out.print("inserte titulo: ");
			v.setTitulo(sc.next());

			System.out.print("inserte URL: ");
			v.setCodigo(sc.next());

			System.out.println("guardado registro....");
			VideoYoutubeArrayDAO.getInstance().insert(v);
			cont++;
			System.out.println("¿Deseas agregar mas videos? \"s\" si \"n\"no");
			continuar = sc.next();

		} while (!"n".equalsIgnoreCase(continuar));
		System.out.println("\n");
	}

	private static void eliminaElement() {

		System.out.println("    Listado de videos :    ");
		listaVideo(videos);

		System.out.print("Ingrese el numero del video a eliminar:");
		long r = sc.nextLong();

		VideoYoutubeArrayDAO.getInstance().delete(r);

		listaVideo(videos);

	}

}
