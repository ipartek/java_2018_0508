package com.ipartek.formacion.videos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ipartek.formacion.pojo.VideoYoutube;

public class GestorVideos {
	
	static List <VideoYoutube> videos = new ArrayList<VideoYoutube>();

	public static void main(String[] args) {
		
		cargarVideos();
		
		pintarMenu();		

	}
	
	public static void cargarVideos() {
		/*		
		videos.add(1 VideoYoutube);
		videos.add(2);
		videos.add(3, "Programa", "a9");
		videos.add(4, "Partido fútbol", "a9");
		videos.add(5, "Música clásica", "a9");
		*/
	}
	
	public static void pintarMenu() { 
		
		System.out.println("---------------------------");
		System.out.println("--        Youtube        --");
		System.out.println("---------------------------");
		System.out.println("--        1.Listar       --");
		System.out.println("--                       --");
		System.out.println("--        2.Añadir       --");
		System.out.println("--                       --");
		System.out.println("--       3.Eliminar      --");
		System.out.println("---------------------------");

		elegirOpcion();
		
	}
	
	public static void elegirOpcion() {

		Scanner sc = new Scanner(System.in);
		
		int opcionElegida;
		
		opcionElegida = sc.nextInt();
		
		switch (opcionElegida) {
		case 1:
			listar();
			break;
			
		case 2:
			aniadir();
			break;
			
		case 3:
			//eliminar();
			break;
		}
		
		sc.close();
	}
	
	public static void listar() {
		
		for (int i = 0; i < videos.size(); i++) {
			System.out.println(videos.get(i));
		}
		
	}
	
	public static void aniadir() {
		
		Scanner sc = new Scanner(System.in);
		
		long id;
		String titulo;
		String codigo;
		int i = 5;
		
		System.out.println("Introduce la id del video");
		id = sc.nextLong();
		
		System.out.println("Introduce el título del video");
		titulo = sc.next();
		
		System.out.println("Introduce el código del video");
		codigo = sc.next();
		
		//videos[i] = new VideoYoutube(id, titulo, codigo);
		i++;
		
		sc.close();
		
	}

}
