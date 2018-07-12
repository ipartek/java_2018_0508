package com.ipartek.formacion.videos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.pojo.Person;
import com.ipartek.formacion.pojo.videoYoutube;

public class GestorVideos {
	static videoYoutube[] videos = new videoYoutube[5];
	//List<String> videos = new ArrayList<String>();

	public static void main(String[] args) throws Exception {

		cargarMenu();
	}

	private static void pintarMenu() throws Exception {
		int opcion;
		System.out.println("-----------------------");
		System.out.println("-------Youtube---------");
		System.out.println("-------Opciones--------");
		System.out.println("------1: Listar--------");
		System.out.println("------2: Añadir--------");
		System.out.println("------3: Eliminar------");
		System.out.println("------Seleccione una opcion------");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		opcion = Integer.parseInt(br.readLine());
		if (opcion == 1) {
			listarMenu();
		}else {
			if (opcion == 2) {
				Anadir();
			}
		}

	}

	private static void cargarMenu() throws Exception {
		
		/*for(int i= 0; i > 6;i++) {
			videoYoutube cancionVideo = new videoYoutube();
			videos[0] = cancionVideo;
	}*/
		pintarMenu();
	}

	private static void Anadir() throws Exception {

		/*videoYoutube test = new videoYoutube();
		videos[0] = test;*/
		String cancion;
		String codigo;
		System.out.println("------Opcion añadir------");
		System.out.println("------Introduzca el nombre de la cancion------");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		cancion = br.readLine();
		System.out.println("------Introduzca el codigo de la cancion------");
		codigo = br.readLine();
		//videoYoutube test = new videoYoutube(cancion,codigo);
		//System.out.println(test.getTitulo() +"-"+ test.getCodigo());
		

	}
	private static void listarMenu() {
		//List<String> videos =  new videoYoutube("Cancion1","cod1");
		//videoYoutube video = new videoYoutube("Cancion1","cod1");
		/*videoYoutube test2 = new videoYoutube("Cancion2","cod2");
		videoYoutube test3 = new videoYoutube("Cancion3","cod3");
		videoYoutube test4 = new videoYoutube("Cancion4","cod4");
		videoYoutube test5 = new videoYoutube("Cancion5","cod51");
		System.out.println(test.getTitulo() +"-"+ test.getCodigo());*/
		
		System.out.println("------Listar Menu------");
		for (int x= 0 ; x < videos.length; x++) {
			System.out.println(videos[x]);
		}
		//System.out.println(videos.getTitulo() +"-"+ test.getCodigo());
		

	}
}
