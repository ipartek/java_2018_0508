package com.ipartek.formacion.videos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ipartek.formacion.model.VideoYoutubeArrayDAO;
import com.ipartek.formacion.pojo.VideoYoutube;

public class GestorVideos {

	//Constantes
	private final static int OPCION0 = 0;
	private final static int OPCION4 = 4;
	
	static private VideoYoutubeArrayDAO dao;
	static Scanner teclado;

	public static void main(String[] args) {
		try {
			
			dao = VideoYoutubeArrayDAO.getInstance();
			teclado = new Scanner(System.in);
			cargarVideos();
			pintarMenu();
			
		}catch(Exception e){
			
			System.out.println("Lo sentimos, hemos tenido un error.");
			
		}finally{
			teclado.close();
		}
	}

	/**
	 * Metodo para pinta el menu y seleccionar la operacion
	 */
	private static void pintarMenu() {
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
			int opcion = -1;

			do {
				try {
					System.out.println();
					System.out.println("Elige una opcion del menu:");
					opcion = teclado.nextInt();
					
				} catch (Exception e) {
					System.out.println();
					System.out.println("Por favor, introduzca un valor correcto.");
					teclado.nextLine();
				}
				
			} while (opcion < OPCION0 || opcion > OPCION4);

			switch (opcion) {
			case 1:
				listarVideos();
				break;
			case 2:
				anadirVideos();
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

		} catch (Exception e) {
			System.out.println("Se ha producido un error, lo sentimos.");
			e.printStackTrace();
		}
	}

	/**
	 * Metodo que carga la lista de videos
	 */
	private static void cargarVideos() {
		VideoYoutube video1 = new VideoYoutube(1, "v2AC41dglnM", "Video1");
		dao.insert(video1);
		VideoYoutube video2 = new VideoYoutube(2, "vx2u5uUu3DE", "Video2");
		dao.insert(video2);
		VideoYoutube video3 = new VideoYoutube(3, "X2SJkEDw1E8", "Video3");
		dao.insert(video3);
		VideoYoutube video4 = new VideoYoutube(4, "kXYiU_JCYtU", "Video4");
		dao.insert(video4);
		VideoYoutube video5 = new VideoYoutube(5, "6fVE8kSM43I", "Video5");
		dao.insert(video5);
	}

	/**
	 * Metodo para listar un video concreto o toda la lista
	 */
	private static void listarVideos() {
		try {
			List<VideoYoutube> listados = new ArrayList<VideoYoutube>();
			listados = dao.getAll();
			System.out.println("CODIGO -------- TITULO");
			System.out.println("----------------------");
			for (int i = 0; i < listados.size(); i++) {
				System.out.print(listados.get(i).getCodigo());
				System.out.println(listados.get(i).getNombre());
			}
		} catch (Exception e) {
			System.out.println("Lo sentimos, se ha producido un error y no se han encontrado videos.");
			e.printStackTrace();
		} finally {
			System.out.println();
			pintarMenu();
		}
	}

	/**
	 * Metodo para a�adir un video nuevo a la lista
	 */
	private static void anadirVideos() {
		// TODO Terminar a�adir nuevo video
		try {
			long id = dao.getAll().size();
			String nombre;
			String codigo;

			System.out.println("Introduce el nombre del video:");
			nombre = teclado.nextLine();
			teclado.nextLine();
			System.out.println();
			System.out.println("Introduce el codigo del video:");
			codigo = teclado.nextLine();

			VideoYoutube videoNuevo = new VideoYoutube(id++, codigo, nombre);
			dao.insert(videoNuevo);
			
		} catch (Exception e) {
			System.out.println("Lo sentimos, se ha producido un error.");
			e.printStackTrace();
		} finally {
			System.out.println();
			pintarMenu();
		}
	}

	/**
	 * Metodo para modificar un video de la lista
	 */
	private static void modificarVideos() {
		// TODO Terminar modificar video
		try {
			List<VideoYoutube> listados = new ArrayList<VideoYoutube>();
			listados = dao.getAll();
			long idBusqueda;
			String nombre;
			String codigo;

			System.out.println("Introduce el ID del video que quieres modificar:");
			idBusqueda = teclado.nextLong();

			for (int i = 0; i < listados.size(); i++) {
				if(listados.get(i).getId() == idBusqueda) {
					System.out.println("Introduce el nuevo nombre del video:");
					nombre = teclado.nextLine();
					teclado.nextLine();
					System.out.println();
					System.out.println("Introduce el nuevo codigo del video:");
					codigo = teclado.nextLine();
					
					VideoYoutube videoModificado = new VideoYoutube(idBusqueda, codigo, nombre);
					dao.update(videoModificado);
				}
			}	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println();
			pintarMenu();
		}
	}

	/**
	 * Metodo para eliminar videos de la lista
	 */
	private static void eliminarVideos() {
		//TODO Terminar eliminar video
		try {
			List<VideoYoutube> listados = new ArrayList<VideoYoutube>();
			listados = dao.getAll();
			long idEliminar = -1;
			do {
			try {
				System.out.println("Introduce el ID del video que quieres eliminar:");
				idEliminar = teclado.nextLong();
			} catch (Exception e) {
				System.out.println("Introduce una ID correcta, por favor");
				e.printStackTrace();
			}
			
			}while(idEliminar < 0);
			
		} catch (Exception e) {
			System.out.println();
			e.printStackTrace();
		} finally {
			System.out.println();
			pintarMenu();
		}
	}

}
