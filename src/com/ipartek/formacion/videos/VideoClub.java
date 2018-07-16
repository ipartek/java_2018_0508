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

		sc.nextLine();
		String continuar = "n";
		boolean resul = false;
		System.out.println("\n");
		System.out.println(" - INSERTANDO VIDEOS - ");

		do {

			VideoYoutube v = new VideoYoutube();

			v.setId(dao.getALl().size() + 1);

			do {
				System.out.print("inserte titulo : ");
				v.setTitulo(sc.nextLine().trim());

				if (v.getTitulo().length() < 3) {
					System.out.println("La longitud del titulo es corta");

				} else if (v.getTitulo().length() > 254) {
					System.out.println("La longitud del titulo es demasiado largo");

				}
			} while (v.getTitulo().length() < 3 || v.getTitulo().length() > 254);

			do {
				System.out.print("inserte codigo: ");
				v.setCodigo(sc.next());
				if (v.getCodigo().length() < 11) {
					System.out.println("La longitud del codigo es corta");
				}
				if (v.getCodigo().length() > 11) {
					System.out.println("La longitud del codigo es larga");
				}
			} while (v.getCodigo().length() < 11 || v.getCodigo().length() > 11);

			System.out.println("guardado registro....");
			dao.insert(v);

			System.out.println("¿Deseas agregar mas videos? \"s\" si \"n\"no");
			continuar = sc.next();
			resul = validarContinuar(continuar);

			while (resul == false) {
				System.out.println("Marque \"s\" si \"n\"no");
				continuar = sc.next();
				resul = validarContinuar(continuar);
				sc.nextLine();
			}

		} while (!"n".equalsIgnoreCase(continuar));

	}

	private static void eliminaElement() {

		long r = 0;
		long aux = 0;
		if (dao.getALl().isEmpty()) {
			System.out.println("\n No hay videos que mostrar \n");
			pintarMenu();
		} else {
			System.out.println(" \n Listado de videos :    ");
			listarVideo(videos);

			do {
				try {

					System.out.print("Ingrese el numero del video a eliminar:");
					r = sc.nextLong();
					aux = r;

					if (dao.getById(r).getId() == r) {
						dao.delete(r);
						System.out.println("\n Lista actualizada....");
						listarVideo(videos);
					} else {
						System.out.println("Video no encontrado");
					}

				} catch (Exception e) {

					System.out.println("El codigo es incorrecto..");
					sc.nextLine();

					eliminaElement();

				} // end catch
			} while (aux != r);
		}

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
