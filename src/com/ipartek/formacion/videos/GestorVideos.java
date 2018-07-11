package com.ipartek.formacion.videos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.ipartek.formacion.pojo.Person;
import com.ipartek.formacion.pojo.videoYoutube;

public class GestorVideos {
	static videoYoutube[] videos = new videoYoutube[5];

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

	}

	private static void cargarMenu() throws Exception {
		
		for(int i= 0; i > 6;i++) {
			videoYoutube cancionVideo = new videoYoutube();
			videos[0] = cancionVideo;
	}
		pintarMenu();
	}

	private static void Anadir() {

		videoYoutube test = new videoYoutube();
		videos[0] = test;

	}
}
