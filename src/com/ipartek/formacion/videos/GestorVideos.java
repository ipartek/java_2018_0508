package com.ipartek.formacion.videos;

import java.util.Iterator;
import java.util.Scanner;

import javax.sound.midi.Soundbank;

import com.ipartek.formacion.pojo.VideoYoutube;

/**
 * 
 * @author andreaperez
 *
 */

public class GestorVideos {

	static VideoYoutube[] videos = new VideoYoutube[5];
	static Scanner sc = new Scanner(System.in);
	static String continuar = "s";
	static int respuesta;
	static String autor;
	static String titulo;
	static String codigoVideo;

	public static void main(String[] args) {

		videos[0] = new VideoYoutube(1, "Vj1190w58UM", "Uno X Uno", "Manuel Carrasco");
		videos[1] = new VideoYoutube(2, "RgULjdsjiLQ", "Clandestino", "Shakira, Maluma");
		videos[2] = new VideoYoutube(3, "I8oOS73Mpao", "Quiero ser un tronista", "chirigota callejera de Cádiz");
		videos[3] = new VideoYoutube(2, "RgULjdsjiLQ", "No vaya a ser", "Pablo Alborán");
		videos[4] = new VideoYoutube(2, "RgULjdsjiLQ", "Lo Malo", "Aitana, Ana Guerra");

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

				System.out.println("    Listado de videos :    ");
				listaVideo(videos);

				System.out.print("Ingrese el numero del video a eliminar:");
				respuesta = sc.nextInt();

				if (respuesta == videos.length - 1) {
					videos[respuesta] = new VideoYoutube("", "", "", "");
				} else {
					for (int i = respuesta; i < videos.length - 1; i++) {
						videos[respuesta] = videos[respuesta + 1];
					}
					videos[videos.length - 1] = new VideoYoutube("", "", "", "");
				}

				listaVideo(videos);
//				eliminaElement(videos,respuesta);
//				
//				System.out.println("    Listado de videos con elemento eliminado:    ");
//				listaVideo(videos);

				break;
			case 0:
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
		System.out.println("    0. salir");
		System.out.println("------------------------------------");
		System.out.println("    1. Listar");
		System.out.println("------------------------------------");
		System.out.println("    2. Agregar");
		System.out.println("------------------------------------");
		System.out.println("    3. Eliminar");
		System.out.println("------------------------------------");

	}

	private static boolean validarEnt(String cadena) {
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}

	}

	private static void listaVideo(VideoYoutube[] videos) {
		System.out.println("\n");
		System.out.println(" Listando videos:    ");
		for (int i = 0; i < videos.length; i++) {
			System.out.println(videos[i].getId() + " " + videos[i].getAutor()+" "+videos[i].getTitulo());

		}
		System.out.println("\n");

	}

	private static void agregarVideo() {
		System.out.println("\n");
		System.out.println(" - INSERTANDO VIDEOS - ");
		int cont = 0;
		int i;
		do {

			System.out.print("inserte autor: ");
			autor = sc.next();

			System.out.print("inserte titulo: ");
			titulo = sc.next();

			System.out.print("inserte URL: ");
			codigoVideo = sc.next();

			System.out.println("guardado registro....");

			for (i = cont; i <= cont; i++) {
				videos[i].setTitulo(titulo);
				videos[i].setAutor(autor);
				videos[i].setCodigo(codigoVideo);
				videos[i].setId(i + 1);
			}
			cont++;
			i++;

			System.out.println("Â¿Deseas agregar mas videos? \"s\" si \"n\"no");
			continuar = sc.next();

		} while (!"n".equalsIgnoreCase(continuar));
		System.out.println("\n");
	}

	private static void eliminaElement(VideoYoutube[] arrayVideos, int num) {

	}

}
