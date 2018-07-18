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

	static private final int TITULO_MIN = 3;
	static private final int TITULO_MAX = 254;
	static private final int LONGCODIGO = 11;
	static private final String TERMINAR = "n";
	static private final int VACIO = 0;
	private static int cont = 0;

	public static void main(String[] args) {
		try {
			sc = new Scanner(System.in);

			dao = VideoYoutubeArrayDAO.getInstance();

			cargarVideos();

			do {

				pintarMenu();

				switch (opcionSeleccionada) {
				case OPCION_LISTAR:
					listarVideo();
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

			} while (opcionSeleccionada != OPCION_SALIR);

		} catch (Exception e) {
			System.out.println("Lo sentimos, no se puede usar la aplicacion por problemas tecnicos");
		} finally {
			sc.close();
		}

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

		VideoYoutube video = new VideoYoutube(cont++, "Uno X Uno", "6bLVdKbPHHY");
		dao.insert(video);

		video = new VideoYoutube(cont++, "Clandestino", "RgULjdsjiLQ");
		dao.insert(video);

	}

	private static void listarVideo() {

		ArrayList<VideoYoutube> videos = (ArrayList<VideoYoutube>) dao.getALl();

		if (videos.size() <= VACIO) {
			System.out.println("No hay videos para mostrar.");
		} else {
			System.out.println("\n Listado de " + videos.size() + " videos:");

			for (VideoYoutube listVideos : videos) {
				System.out.println("  " + listVideos + " \n");
			}

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

			do {
				System.out.print("inserte entre 3 y 254 caracteres para el titulo : ");
				v.setTitulo(sc.nextLine().trim());

				if (v.getTitulo().length() < TITULO_MIN || v.getTitulo().length() > TITULO_MAX) {
					System.out.println("ERROR...La longitud del titulo debe de ser entre 3 y 254 caracteres");
				}
			} while (v.getTitulo().length() < TITULO_MIN || v.getTitulo().length() > TITULO_MAX);

			do {
				System.out.print("inserte 11 caracteres para el codigo: ");
				v.setCodigo(sc.next());
				sc.nextLine();
				if (v.getCodigo().length() != LONGCODIGO) {
					System.out.println("ERROR...La longitud del codigo debe ser de 11 caracteres.");
				}

			} while (v.getCodigo().length() < LONGCODIGO || v.getCodigo().length() > LONGCODIGO);

			v.setId(cont++);

			System.out.println("guardado registro....");
			dao.insert(v);

			System.out.println("�Deseas agregar mas videos? \"s\" si \"n\"no");
			continuar = sc.next();
			resul = validarContinuar(continuar);

			while (resul == false) {
				System.out.println("Marque \"s\" si \"n\"no");
				continuar = sc.next();
				resul = validarContinuar(continuar);
				sc.nextLine();
			}
			sc.nextLine();

		} while (!TERMINAR.equalsIgnoreCase(continuar));

	}

	private static void eliminaElement() {

		ArrayList<VideoYoutube> videos = (ArrayList<VideoYoutube>) dao.getALl();

		long r = 0;
		long aux = 0;

		if (videos.size() <= VACIO) {
			System.out.println("\n No hay videos para mostrar \n");
			pintarMenu();
		} else {

			listarVideo();

			do {
				try {

					System.out.print("Ingrese el id del video a eliminar:");
					r = sc.nextLong();
					aux = r;

					if (dao.getById(r).getId() == r) {
						dao.delete(r);
						System.out.println("\n Lista actualizada....");
						listarVideo();
					}

				} catch (Exception e) {

					System.out.println("El codigo no corresponde a ningun video..");
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
