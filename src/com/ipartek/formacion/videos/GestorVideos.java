package com.ipartek.formacion.videos;

import java.util.Scanner;

import com.ipartek.formacion.pojo.VideoYoutube;

public class GestorVideos {

	static VideoYoutube[] videos = new VideoYoutube[5];

	public static void main(String[] args) {
		cargarVideos();
		pintarMenu();
	}

	/**
	 * Metodo para pinta el menu y seleccionar la operacion
	 */
	private static void pintarMenu() {
		// TODO Corregir error scanner
		System.out.println("------------------------------------------");
		System.out.println("--               YOUTUBE                --");
		System.out.println("------------------------------------------");
		System.out.println("-   1. Listar                            -");
		System.out.println("-   2. Añadir                            -");
		System.out.println("-   3. Modificar                         -");
		System.out.println("-   4. Eliminar                          -");
		System.out.println("------------------------------------------");
		System.out.println("-   0. Salir                             -");

		try {
			Scanner teclado = new Scanner(System.in);
			int opcion = 0;

			do {
				System.out.println();
				System.out.println("Elige una opcion del menu:");
				opcion = teclado.nextInt();
			} while (opcion < 0 || opcion > 4);

			switch (opcion) {
			case 1:
				listarVideos();
				break;
			case 2:
				añadirVideos();
				break;
			case 3:
				modificarVideos();
				break;
			case 4:
				eliminarVideos();
				break;
			case 0:
				System.out.println();
				System.out.println("¡Hasta la proxima!");
			}

			teclado.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo que carga la lista de videos
	 */
	private static void cargarVideos() {
		VideoYoutube video1 = new VideoYoutube(1, "v2AC41dglnM", "Video1");
		videos[0] = video1;
		VideoYoutube video2 = new VideoYoutube(2, "vx2u5uUu3DE", "Video2");
		videos[1] = video2;
		VideoYoutube video3 = new VideoYoutube(3, "X2SJkEDw1E8", "Video3");
		videos[2] = video3;
		VideoYoutube video4 = new VideoYoutube(4, "kXYiU_JCYtU", "Video4");
		videos[3] = video4;
		VideoYoutube video5 = new VideoYoutube(5, "6fVE8kSM43I", "Video5");
		videos[4] = video5;
	}

	/**
	 * Metodo para listar un video concreto o toda la lista
	 */
	private static void listarVideos() {
		//TODO Terminar listado de videos
		try {
			Scanner teclado = new Scanner(System.in);
			char opcion;
			do {
				System.out.println();
				System.out.println("¿Quieres listar un video en concreto? S/N");
				opcion = teclado.next().charAt(0);
				opcion = Character.toUpperCase(opcion);

			} while (opcion != 'S' && opcion != 'N');
			System.out.println();
			if (opcion == 'S') {
				long id;
				System.out.println("Introduce el ID del video que estas buscando:");
				id = teclado.nextLong();
				id--;

				System.out.println();
				for (int i = 0; i < videos.length; i++) {
					if (i == id) {
						System.out.println(videos[i]);
					}
				}
			} else {
				System.out.println();
				for (int i = 0; i < videos.length; i++) {
					System.out.println(videos[i]);
				}
			}

			teclado.close();

			System.out.println();
			pintarMenu();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo para añadir un video nuevo a la lista
	 */
	private static void añadirVideos() {
		// TODO Terminar añadir nuevo video
		try {
			Scanner teclado = new Scanner(System.in);

			long id = (videos.length+1);
			String nombre;
			String codigo;

			System.out.println("Introduce el nombre del video:");
			nombre = teclado.nextLine();
			System.out.println();
			System.out.println("Introduce el codigo del video:");
			codigo = teclado.nextLine();

			VideoYoutube video = new VideoYoutube(id, codigo, nombre);
			videos[(int) id] = video;
			
			teclado.close();
			pintarMenu();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo para modificar un video de la lista
	 */
	private static void modificarVideos() {
		// TODO Terminar modificar video
		try {
			Scanner teclado = new Scanner(System.in);
			long id;
			String nombre;
			String codigo;

			System.out.println("Introduce el ID del video que quieres modificar:");
			id = teclado.nextLong();
			id--;

			for (int i = 0; i < videos.length; i++) {
				if (id == i) {
					System.out.println("Introduce el nombre del video:");
					nombre = teclado.nextLine();
					teclado.nextLine();
					System.out.println("Introduce el codigo del video:");
					codigo = teclado.nextLine();

					videos[i].setNombre(nombre);
					videos[i].setCodigo(codigo);
				}
			}

			teclado.close();
			pintarMenu();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo para eliminar videos de la lista
	 */
	private static void eliminarVideos() {
		//TODO Terminar eliminar video
		try {
			Scanner teclado = new Scanner(System.in);
			char opcion;
			do {
				System.out.println();
				System.out.println("¿Quieres eliminar todos los videos? S/N");
				opcion = teclado.next().charAt(0);
				opcion = Character.toUpperCase(opcion);

			} while (opcion != 'S' && opcion != 'N');

			if (opcion == 'N') {
				long id;
				System.out.println();
				System.out.println("Introduce el ID del video que quieres borrar:");
				id = teclado.nextLong();
				id--;

				for (int i = 0; i < videos.length; i++) {
					if (i == id) {
						videos[i] = null;
						System.out.println("El video con id " + id + " se ha eliminado.");
					}
				}
			} else {
				videos = null;
				System.out.println("Todos los videos se han eliminado.");
			}

			teclado.close();
			pintarMenu();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
