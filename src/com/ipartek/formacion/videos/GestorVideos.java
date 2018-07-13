package com.ipartek.formacion.videos;

import java.util.Scanner;
import java.util.logging.Logger;

import com.ipartek.formacion.pojo.VideoYoutube;

public class GestorVideos {

	static VideoYoutube[] videos;//= new VideoYoutube[5];
	static Scanner teclado;

	public static void main(String[] args) {
		pintarMenu();
	}

	private static void pintarMenu() {
		
		int opcion;

		System.out.println("------------------------------------");
		System.out.println("--          YOUTUBE               --");
		System.out.println("------------------------------------");
		System.out.println("    1. Listar");
		System.out.println("------------------------------------");
		System.out.println("    2. Añadir");
		System.out.println("------------------------------------");
		System.out.println("    3. Eliminar");
		System.out.println("------------------------------------");
		System.out.println("------------------------------------");
		System.out.println("-- Elige una opción:              --");
		opcion=teclado.nextInt();
		
		switch(opcion) {
		case 1:
			CargarVideo();
			break;
		case 2:
			AnadirVideo();
			break;
		case 3:
			EliminarVideo();
			break;
		default:
			System.out.println("ADIOS");
			break;
		}
			
	}

	private static void CargarVideo() {
		//Logger log = Logger.getLogger(GestorVideos.class.getName());

		
		VideoYoutube p=new VideoYoutube(1, "269659", "20 de Abril");
		videos[0]=p;
		p=new VideoYoutube(2, "2925581", "Loco");
		videos[1]=p;
		p=new VideoYoutube(3, "69413", "Estrella Polar");
		videos[2]=p;
		p=new VideoYoutube(4, "61546265", "Naufrago");
		videos[3]=p;
		p=new VideoYoutube(5, "5416451", "Power");
		videos[4]=p;
		
		System.out.println("Listado de Videos");
	
		// for clasico
		for (int i = 0; i < videos.length; i++) {
			
			System.out.println(i +  " " + videos[i]);
		}
		
		System.out.println("------------------------------------");

	}

	private static void AnadirVideo() {
		int num=0;
		
		System.out.println("Cuantos videos quieres meter");
		num=teclado.nextInt();
		videos= new VideoYoutube[num];
		for(int i=0;i<videos.length;i++) {
			
			System.out.println("Introduce titulo de video");
			
			System.out.println("Introduce codigo de video");
			
		}
		
		
	}
	
	private static void EliminarVideo() {
		
	}
	
}