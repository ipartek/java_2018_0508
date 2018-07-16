package com.ipartek.formacion.videos;

import java.util.ArrayList;
//TODO el titulo tiene que tener al menos 3 caracteres y como mucho 254.
//TOdo el codigo tiene que tener 11 caracteres alfanumericos de el 0 al 9 y de la A a la Z y tambien valen minusculas
import java.util.Scanner;

import com.ipartek.formacion.pojo.VideoYoutube;
import com.sun.corba.se.impl.io.TypeMismatchException;

public class VideoClub {
	static Scanner sc = new Scanner(System.in);
	static VideoYoutube[] videos = new VideoYoutube[5];
	static int cont = 1;
	static ArrayList<VideoYoutube> arrayVideos = new ArrayList<VideoYoutube>();

	public static void main(String[] args) {

		cargarVideo(videos);
		pintarMenu();

	}

	private static void cargarVideo(VideoYoutube[] videos) {

		arrayVideos.add(new VideoYoutube(0, "Manifiesto", "3A2KtOXRpOo"));
		arrayVideos.add(new VideoYoutube(1, "Vivir para contarlo", "brwIP1wI-FA"));
		arrayVideos.add(new VideoYoutube(2, "Para los mios", "fp47VcTlwWQ"));
		arrayVideos.add(new VideoYoutube(3, "Manifiesto", "3A2KtOXRpOo"));
		arrayVideos.add(new VideoYoutube(4, "Para los mios", "fp47VcTlwWQ"));
		cont = arrayVideos.size() - 1;

	}

	private static void pintarMenu() {

		int opcion = 0;
		System.out.println("----------------------------------");
		System.out.println("--------------youtube-------------");
		System.out.println("----------------------------------");
		System.out.println("    1.Listar                      ");
		System.out.println("    2.Añadir                      ");
		System.out.println("    3.Eliminar                    ");
		System.out.println("    4.Salir                       ");
		System.out.println("----------------------------------");
		System.out.println("Elige una opcion");
		try {
			opcion = sc.nextInt();
		} catch (TypeMismatchException e) {
			System.out.println("Lo sentimos pero debe introducir un numero de la lista");
			sc.next();
			pintarMenu();

		} catch (Exception e) {
			System.out.println("Lo siento pero no has introducido una opcion correcta");
			System.out.println("Introduzca una numero entre 1 y 4 por favor");
			sc.next();
			pintarMenu();
		}
		sc.reset();
		switch (opcion) {
		case 1:
			listarVideos();
			pintarMenu();
			break;

		case 2:
			añadirVideo();
			pintarMenu();
			break;

		case 3:
			eliminarVideo();
			pintarMenu();
			break;

		case 4:
			System.exit(0);
			break;

		default:
			System.out.println("Lo siento pero no has introducido una opcion correcta");
			System.out.println("Introduzca una numero entre 1 y 4 por favor");
			pintarMenu();
			break;
		}
	}

	private static void eliminarVideo() {
		int codElim = 0;
		VideoYoutube videoElim;
		listarVideos();
		System.out.println("Introduce el id del video que desea  eliminar");
		try {

			codElim = sc.nextInt();

		} catch (ArrayIndexOutOfBoundsException e) {

			System.out.println("Lo sentimos pero debe introducir un numero entre 0 y " + videos.length);

		} catch (TypeMismatchException e) {

			System.out.println("Lo sentimos pero debe introducir un numero entre 0 y " + videos.length);

		} catch (Exception e) {

			System.out.println("Lo sentimos pero ha ocurrido un error, por favor intentelo de nuevo");
			pintarMenu();
		}
		sc.nextLine();
		try {
			arrayVideos.remove(codElim);
		} catch (ArrayIndexOutOfBoundsException e) {

			System.out.println("Lo sentimos pero debe introducir un numero entre 0 y " + (videos.length - 1));

		}
		System.out.println("El video seleccionado ha sido eliminado");
		cont++;

	}

	private static void listarVideos() {
		for (int i = 0; i < arrayVideos.size(); i++) {
			System.out.println("." + arrayVideos.get(i).toString());
		}

	}

	private static void añadirVideo() {

		int cont = 0;
		for (int i = 0; i < arrayVideos.size(); i++) {

			if (videos[i].getTitulo().equalsIgnoreCase("")) {
				cont++;
				String cod = "";
				String tit = "";

				System.out.println("Introduce el codigo del video");
				try {

					cod = sc.next();
					System.out.println("Introduce el titulo del video");
					tit = sc.next().trim();

				} catch (TypeMismatchException e) {

					System.out.println("Lo sentimos pero debe introducir un numero entre 0 y " + videos.length);

				} catch (Exception e) {

					System.out.println("Lo sentimos pero ha ocurrido un error, por favor intentelo de nuevo");

					pintarMenu();
				}

				for (int j = 0; j < videos.length; j++) {
					if (videos[j].getTitulo().equalsIgnoreCase("")) {
						videos[j] = new VideoYoutube(j, tit, cod);
					}
				}
				cont--;
				System.out.println("Video añadido a la lista.");
				System.out.println("Quedan " + cont + " huecos en la lista");

			}

		}
		if (cont == 0) {
			System.out.println("Lo sentimos pero no hay hueco en la lista");
		}

		cont++;
		pintarMenu();

	}

}
