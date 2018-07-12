package com.ipartek.formacion.videos;

import java.util.Scanner;

import com.ipartek.formacion.pojo.VideoYoutube;

public class GestorVideos {
	
	 static VideoYoutube videos[] = new VideoYoutube[5];

	public static void main(String[] args) {
		
		cargarVideos();
		
		pintarMenu();		

	}
	
	public static void cargarVideos() {
		//TODO crear y guardar 5 videos en el array
		
		videos[0] = new VideoYoutube(1, "Receta de cocina", "a8");
		videos[1] = new VideoYoutube(2, "Canción de rock", "m4");
		videos[2] = new VideoYoutube(3, "Partido de fútbol", "89n");
		videos[3] = new VideoYoutube(4, "Música clásica", "01k");
		videos[4] = new VideoYoutube(5, "Noticias", "abc43");
		
	}
	
	public static void pintarMenu() { 
		//TODO pintar menu
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
			//aniadir()
			break;
			
		case 3:
			//eliminar();
			break;
		}
		
		sc.close();
	}
	
	public static void listar() {
		
		for (int i = 0; i < videos.length; i++) {
			System.out.println(videos[i]);
		}
		
	}
	
	public static void aniadir() {
		
		
		
	}

}
