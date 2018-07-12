package com.ipartek.formacion.videos;

import com.ipartek.formacion.pojo.VideoYoutube;

public class GestorVideos {

	static VideoYoutube[] videos = new VideoYoutube[5];
	
	public static void main(String[] args) {
		
		cargarVideos();
		
		pintarMenu();
	}

	
	private static void cargarVideos() {
		//TODO crear y guadar 5 videos en el array
		
	}


	private static void pintarMenu() {
	
		//TODO pintar menu
		System.out.println("------------------------------------");
		System.out.println("--          youtube               --");
		System.out.println("------------------------------------");
		System.out.println("    1. Listar");
		System.out.println("------------------------------------");
		
	}
	
}
