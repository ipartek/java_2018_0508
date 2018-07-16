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

public class VideoClub {

	static private VideoYoutubeArrayDAO dao;
	static private int opcionSeleccionada = 0;
	static Scanner sc = null;

	static private final int OPCION_SALIR = 0;
	static private final int OPCION_LISTAR = 1;
	static private final int OPCION_ANADIR = 2;
	static private final int OPCION_ELIMINAR = 3;

	static ArrayList<VideoYoutube> videos = new ArrayList<VideoYoutube>();

	public static void main(String[] args) {

		sc = new Scanner(System.in);

		dao = VideoYoutubeArrayDAO.getInstance();

		cargarVideos();

		do {

			pintarMenu();

			switch (opcionSeleccionada) {
			case OPCION_LISTAR:
				listarVideo(videos);
				break;

			case OPCION_ANADIR:
				agregarVideo();
				break;

			case OPCION_ELIMINAR:
				eliminaElement();
				break;

			case OPCION_SALIR:
				System.out.println(" ADIOS!! ");
				break;

			}

		} while (opcionSeleccionada != 0);

		sc.close();

	}

	private static void pintarMenu() {

		System.out.println("|------------------------------------|");
		System.out.println("|           youtube                  |");
		System.out.println("|------------------------------------|");
		System.out.println("|    	1. Listar		     |");
		System.out.println("|------------------------------------|");
		System.out.println("|    	2. Agregar	             |");
		System.out.println("|------------------------------------|");
		System.out.println("|    	3. Eliminar		     |");
		System.out.println("|------------------------------------|");
		System.out.println("|    	0. salir	             |");
		System.out.println("|------------------------------------|\n");

		System.out.print("Inserta opcion deseada:");
		try {
			opcionSeleccionada = sc.nextInt();

		} catch (Exception e) {
			System.out.println("OPCION NO VALIDAD, Por favor introduce un numero del menu");
			sc.nextLine();
			pintarMenu();
		}
	}

	public static void cargarVideos() {

		VideoYoutube video = new VideoYoutube(12650, "Uno X Uno", "6bLVdKbPHHY");
		dao.insert(video);

		video = new VideoYoutube(701, "Clandestino", "RgULjdsjiLQ");
		dao.insert(video);

	}

	private static void listarVideo(ArrayList<VideoYoutube> videos) {

		for (VideoYoutube listVideos : dao.getALl()) {
			System.out.println("  " + listVideos + " \n");
		}

	}

	private static void agregarVideo() {

		String continuar = "n";
		boolean resul = false;
		System.out.println("\n");
		System.out.println(" - INSERTANDO VIDEOS - ");

		do {

			VideoYoutube v = new VideoYoutube();

			v.setId(dao.getALl().size() + 1);

			System.out.print("inserte titulo: ");
			v.setTitulo(sc.next());

			System.out.print("inserte codigo: ");
			v.setCodigo(sc.next());

			System.out.println("guardado registro....");
			dao.insert(v);

			System.out.println("Â¿Deseas agregar mas videos? \"s\" si \"n\"no");
			continuar = sc.next();
			resul = validarContinuar(continuar);

			while (resul == false) {
				System.out.println("Marque \"s\" si \"n\"no");
				continuar = sc.next();
				resul = validarContinuar(continuar);
			}

		} while (!"n".equalsIgnoreCase(continuar));

	}

	private static void eliminaElement() {

		String continuar = "n";
		boolean resul = false;

		do {
			if (dao.getALl().isEmpty()) {
				System.out.println("\n No hay videos que mostrar \n");
				pintarMenu();
			} else {
				System.out.println(" \n Listado de videos :    ");
				listarVideo(videos);

				System.out.print("Ingrese el numero del video a eliminar:");
				long r = sc.nextLong();

				dao.delete(r);

				if (!dao.getALl().isEmpty()) {
					System.out.println(" \n Listado actualizado :    ");

					listarVideo(videos);

					System.out.println("¿Deseas seguir eliminando ? \"s\" si \"n\"no");
					continuar = sc.next();
					resul = validarContinuar(continuar);
				}
			}
		} while (!"n".equalsIgnoreCase(continuar));

	}

	private static boolean validarContinuar(String c) {

		boolean resul = false;

		if ("s".equalsIgnoreCase(c) || "n".equalsIgnoreCase(c)) {
			resul = true;
		} else {
			resul = false;
		}

		return resul;
	}

}
