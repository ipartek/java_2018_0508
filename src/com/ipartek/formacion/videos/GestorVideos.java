package com.ipartek.formacion.videos;

import com.ipartek.formacion.pojo.VideoYoutube;

public class GestorVideos {

	static VideoYoutube[] videos = new VideoYoutube[5];
	
	public static void main(String[] args) {
		cargarVideos();
		pintarMenu();
	}
		
	private static void pintarMenu() {
		System.out.println("------------------------------------------");
		System.out.println("--               YOUTUBE                --");
		System.out.println("------------------------------------------");
		System.out.println("-   1. Listar                            -");
		System.out.println("-   2. Añadir                            -");
		System.out.println("-   3. Eliminar                          -");
		System.out.println("------------------------------------------");
	}
	
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

}
